package southday.mnrmp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import southday.mnrmp.po.MnrmpSysAdminsT;
import southday.mnrmp.po.MnrmpUserSessionT;
import southday.mnrmp.service.MnrmpSysAdminsTService;
import southday.mnrmp.service.MnrmpUserSessionTService;
import southday.mnrmp.util.EncryptUtil;
import southday.mnrmp.util.MnrmpUtil;

@Controller
@RequestMapping("/sysAdmin")
public class MnrmpSysAdminsTController {

    @Autowired
    private MnrmpSysAdminsTService sysAdminService;
    
    @Autowired
    private MnrmpUserSessionTService userSessionService;
    
    @RequestMapping("/login")
    public @ResponseBody MnrmpSysAdminsT login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 验证码是否正确
        String usrCaptchaResponse = request.getParameter("jcaptcha");
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, usrCaptchaResponse);
        if (!captchaPassed) {
            return null; // 前端通过判断object == null?来判断是不是验证码错误
        } 
        
        // 获取用户输入信息
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userTypeCode = MnrmpUtil.USER_TYPE_SYS_ADMIN;
        boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe"));
        // 填充 参数对象
        MnrmpSysAdminsT argSysAdmin = new MnrmpSysAdminsT();
        argSysAdmin.setAccount(account);
        argSysAdmin.setPassword(EncryptUtil.getEncryptPassword(password));
        
        MnrmpSysAdminsT realSysAdmin = sysAdminService.login(argSysAdmin);
        if (realSysAdmin == null) {
            argSysAdmin.setAdminId(null); // 前端通过判断Id == null?得知用户是否存在
            argSysAdmin.setPassword(password); // 保密md5Password
            argSysAdmin.setUserTypeCode(userTypeCode);
            argSysAdmin.setHasLogined(false);
            return argSysAdmin;
        } else {
            // 用户验证成功，将用户信息存入session
            realSysAdmin.setUserTypeCode(userTypeCode);
            realSysAdmin.setHasLogined(true);
            String currentSessionId = session.getId();
            session.setAttribute(currentSessionId, realSysAdmin);
            MnrmpUtil.addSessionIdToUserSessionIdMap(realSysAdmin, currentSessionId); // 为了实现不同浏览器(不同电脑)登录同一用户信息的同步
            if (rememberMe) {
                MnrmpUserSessionT userSession = new MnrmpUserSessionT();
                account = realSysAdmin.getAccount(); // 当用户用的是[电子邮箱]登录时，要获取正确的account
                userSession.setAccount(account);
                userSession.setUserTypeCode(userTypeCode);
                userSession.setSessionId(currentSessionId);
                userSessionService.updateUserSessionId(userSession);
                // 创建cookie
                StringBuilder userLoginCookieValue = new StringBuilder(); // 取值时，使用','进行分割字符串
                userLoginCookieValue.append(realSysAdmin.getAdminId()).append(",").append(account).append(",").append(currentSessionId).append(",").append(userTypeCode);
                Cookie userLoginCookie = new Cookie(MnrmpUtil.COOKIE_NAME_LOGIN_COOKIE, userLoginCookieValue.toString());
                userLoginCookie.setMaxAge(MnrmpUtil.COOKIE_SAVE_TIME);
                userLoginCookie.setPath(MnrmpUtil.LOGIN_COOKIE_PATH); // 整个项目目录都可使用该cookie
                response.addCookie(userLoginCookie);
            }
        }
        return realSysAdmin;
    }
    
}
