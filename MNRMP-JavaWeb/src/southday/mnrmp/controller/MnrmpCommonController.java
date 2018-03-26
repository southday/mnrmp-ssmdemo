package southday.mnrmp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import southday.mnrmp.po.MnrmpDicData;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpUsersT;
import southday.mnrmp.po.MnrmpVideoEx;
import southday.mnrmp.po.MnrmpVideoQueryResult;
import southday.mnrmp.service.MnrmpCommonService;
import southday.mnrmp.service.MnrmpUsersTService;
import southday.mnrmp.util.EncryptUtil;
import southday.mnrmp.util.MnrmpUtil;

@Controller
@RequestMapping("/common")
public class MnrmpCommonController {
	
	private static String[] commonPrivacyCodes = {
			"PUBLIC", "ENCRYPTION"
	};
	
	private static String[] commonStatusCodes = {
			"ACCEPTED"
	};
	
	@Autowired
	private MnrmpUsersTService userService;
	
	private static List<String> lookupTypeCodeList = new ArrayList<String>(
			Arrays.asList("MNRMP_VIDEO_CATAGORY")
	);
	
	private static SimpleDateFormat birthDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private MnrmpCommonService commonService;
	
	@RequestMapping("/loadDicData")
	public @ResponseBody List<MnrmpDicData> loadDicData(HttpSession session) throws Exception {
		@SuppressWarnings("unchecked")
		List<MnrmpDicData> dicDataList = (List<MnrmpDicData>) session.getAttribute(MnrmpUtil.SESSION_NAME_DIC_DATA);
		if (dicDataList == null) {
			dicDataList = commonService.loadDicData(lookupTypeCodeList);
			session.setAttribute(MnrmpUtil.SESSION_NAME_DIC_DATA, dicDataList);
		}
		return dicDataList;
	}
	
	@RequestMapping("/checkAccount")
	public @ResponseBody Boolean checkAccount(HttpServletRequest request) throws Exception {
		return userService.isAccountExists(request.getParameter("account"));
	}
	
	@RequestMapping("/checkEmail")
	public @ResponseBody Boolean checkEmail(HttpServletRequest request) throws Exception {
		return userService.isEmailExists(request.getParameter("email"));
	}
	
	@RequestMapping("/register")
	public @ResponseBody Boolean register(HttpServletRequest request) throws Exception {
		// 验证码是否正确
		String usrCaptchaResponse = request.getParameter("jcaptcha");
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, usrCaptchaResponse);
		if (!captchaPassed) {
			return null; // 前端通过判断object == null?来判断是不是验证码错误
		}
		
		// 创建并填充参数对象 argUser
		String account = request.getParameter("account");
		String recipient = request.getParameter("email");
		String password = request.getParameter("password");
		MnrmpUsersT argUser = new MnrmpUsersT();
		argUser.setRoleId(MnrmpUtil.ROLE_COMMON_USER_ID);
		argUser.setUserName(request.getParameter("userName"));
		argUser.setAccount(account);
		argUser.setPassword(EncryptUtil.getEncryptPassword(password)); // 加盐后的md5值
		argUser.setBirthday(birthDateFormat.parse(request.getParameter("birthday")));
		argUser.setSex("1".equals(request.getParameter("sex")) ? true : false);
		argUser.setEmail(recipient);
		argUser.setPhone(request.getParameter("phone"));
		argUser.setActivateCode(EncryptUtil.md5(account));
		
		// 获取mnrmp_users_t表中下一个自增的userId
//		Integer userId = commonService.nextAutoIncId("mnrmp_users_t");
//		String activateCode = argUser.getActivateCode();
////		发送电子邮件
//		boolean sendMailSucceed = CommunicUtil.sendActivateMail(userId, account, activateCode, recipient);
//		if (!sendMailSucceed) { // 如果发送邮件失败，则返回对应的状态码，并要求用户重新填写表达(电子邮箱)
//			return false;
//		}
		
		// 若点子邮件发送成功，则将用户填写的信息插入到相应表中
		return userService.register(argUser) ? false : true; // 方法的返回值代表是否回滚，所以这样写
	}
	
	@RequestMapping("/activate")
	public @ResponseBody Boolean activate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer userId = null;
		try {
			userId = Integer.valueOf(request.getParameter("userId"));
		} catch (NumberFormatException e) { // userId转换错误，下面的查询肯定无法继续
			e.printStackTrace();
			response.sendRedirect("/MNRMP/jsp/user-not-exists.jsp");
			return false;
		}
		String activateCode = request.getParameter("activateCode");
		// 创建并填充参数对象 argUser
		MnrmpUsersT argUser = new MnrmpUsersT();
		argUser.setUserId(userId);
		argUser.setActivateCode(activateCode);
		
		Boolean hasActivated = userService.isUserHasActivated(userId);
		if (hasActivated == null) { // 说明用户不存在，返回相应状态码
			response.sendRedirect("/MNRMP/jsp/user-not-exists.jsp");
			return false;
		} else if (hasActivated == true) { // 说明用户已经激活过了，不用再次激活
			response.sendRedirect("/MNRMP/jsp/user-has-activated.jsp");
			return false;
		}
		// 如果用户存在则执行激活过程
		int beAffectedNum = userService.activateUser(argUser);
		if (beAffectedNum == 0) { // 如果被影响的记录条数为0,说明激活失败
			response.sendRedirect("/MNRMP/jsp/activate-failure.jsp");
			return false;
		}
		response.sendRedirect("/MNRMP/jsp/activate-success.jsp");
		return true;
	}
	
	@RequestMapping("/logout")
	public @ResponseBody Boolean logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		session.removeAttribute(session.getId());
		MnrmpUtil.clearCookie(request, response, MnrmpUtil.COOKIE_NAME_LOGIN_COOKIE);
		return true; // 返回一个json值，让前台处理
	}
	
	@RequestMapping("/loadHomePageVideos")
	public @ResponseBody MnrmpVideoQueryResult loadHomePageVideos(HttpServletRequest request, MnrmpQueryParameter queryParam) throws Exception {
		String searchKeyword = queryParam.getSearchKeyword();
		if (searchKeyword != null && searchKeyword.length() > 0) {
			queryParam.setSearchKeywords(searchKeyword.split(" {1,}"));
		}
		queryParam.setSelectRecordNum(MnrmpUtil.SELECT_VIDEO_DEFAULT_NUM);
		queryParam.setStartRecordNo(queryParam.getSelectRecordNum() * (queryParam.getCurPageNo() - 1));
		MnrmpVideoQueryResult videoQueryResult = new MnrmpVideoQueryResult();
		videoQueryResult.setVideoList(commonService.loadHomePageVideos(queryParam));
		videoQueryResult.setTotalRecordNum(commonService.getVideoTotalRecordNum(queryParam));
		return videoQueryResult;
	}
	
	@RequestMapping("/getVideo")
	public @ResponseBody MnrmpVideoEx getVideo(MnrmpQueryParameter queryParam) throws Exception {
		queryParam.setStatusCodes(commonStatusCodes);
		queryParam.setPrivacyCodes(commonPrivacyCodes);
		return commonService.getVideoInfoWithUser(queryParam);
	}
}
