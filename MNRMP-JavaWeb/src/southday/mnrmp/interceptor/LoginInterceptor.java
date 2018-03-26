package southday.mnrmp.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import southday.mnrmp.po.MnrmpResManagersT;
import southday.mnrmp.po.MnrmpSysAdminsT;
import southday.mnrmp.po.MnrmpUserSessionT;
import southday.mnrmp.po.MnrmpUsersT;
import southday.mnrmp.service.MnrmpResManagersTService;
import southday.mnrmp.service.MnrmpSysAdminsTService;
import southday.mnrmp.service.MnrmpUserSessionTService;
import southday.mnrmp.service.MnrmpUsersTService;
import southday.mnrmp.util.MnrmpUtil;

/**
 * 登录验证拦截器
 * @author LiChaoxi
 * @date Jun 7, 2016
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private MnrmpUserSessionTService userSessionService;
	
	@Autowired
	private MnrmpUsersTService userService;
	
	@Autowired
	private MnrmpResManagersTService resManagerService;
	
	@Autowired
	private MnrmpSysAdminsTService sysAdminService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Cookie loginCookie = null;
		HttpSession session = request.getSession();
		String currentSessionId = session.getId();
		// 1) 判断session中是否有相关的用户信息Object
		if (session.getAttribute(currentSessionId) != null) {
			return true;
		}
		loginCookie = MnrmpUtil.getLoginCookie(request, MnrmpUtil.COOKIE_NAME_LOGIN_COOKIE);
		// 2) 如果session中没有，则从cookie中获取
		if (loginCookie != null) { // 若没有找到相应的cookie，则返回到登录界面
			MnrmpUserSessionT userSession = new MnrmpUserSessionT();
			String[] cookieValue = loginCookie.getValue().split(",");
			userSession.setAccount(cookieValue[1]);
			userSession.setSessionId(cookieValue[2]);
			userSession.setUserTypeCode(cookieValue[3]);
			if (userSessionService.checkUserCookie(userSession)) {
				switch (cookieValue[3]) {
				case MnrmpUtil.USER_TYPE_USER:
					MnrmpUsersT user = userService.findUserByAccount(cookieValue[1]);
					user.setHasLogined(true);
					session.setAttribute(currentSessionId, user);
					MnrmpUtil.addSessionIdToUserSessionIdMap(user, currentSessionId);
					break;
				case MnrmpUtil.USER_TYPE_RES_MANAGER:
					MnrmpResManagersT resManager = resManagerService.findResManagerByAccount(cookieValue[1]);
					resManager.setHasLogined(true);
					session.setAttribute(currentSessionId, resManager);
					MnrmpUtil.addSessionIdToUserSessionIdMap(resManager, currentSessionId);
					break;
				case MnrmpUtil.USER_TYPE_SYS_ADMIN:
					MnrmpSysAdminsT sysAdmin = sysAdminService.findSysAdminByAccount(cookieValue[1]);
					sysAdmin.setHasLogined(true);
					session.setAttribute(currentSessionId, sysAdmin);
					MnrmpUtil.addSessionIdToUserSessionIdMap(sysAdmin, currentSessionId);
					break;
				}
				return true; // 如果核对该cookie有效，则放行
			}
		}
		// 3) 执行到这里，如果前面没有被放行，则这里就需要跳转到登录页面login-test.jsp
		// 登录失败应该返回一个消息提示
		response.sendRedirect("/MNRMP/index.html");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
