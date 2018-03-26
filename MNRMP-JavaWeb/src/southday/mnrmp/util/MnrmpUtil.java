package southday.mnrmp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import southday.mnrmp.po.MnrmpResManagersT;
import southday.mnrmp.po.MnrmpSysAdminsT;
import southday.mnrmp.po.MnrmpUsersT;

/**
 * Mnrmp工具类
 * @author southday
 * @date Sep 14, 2016
 */
public class MnrmpUtil {
	/**
	 * 保存[用户类型+用户id] -> [sessionId1, sessionId2, ...] 的值;<br />
	 * 考虑到同一用户可能在不同浏览器(或不同电脑)上登录，也就是同一个用户会对应多个sessionId，因此用map来存放这个对应关系，以方便其他操作
	 */
	public static Map<String, List<String>> userSessionIdMap = new HashMap<String, List<String>>();
	/**
	 * cookie保存时间 10天
	 */
	public static final int COOKIE_SAVE_TIME = 864000;
	/**
	 * 默认查询视频的记录数，用于分页加载数据
	 */
	public static final int SELECT_VIDEO_DEFAULT_NUM = 7;
	/**
	 * 默认查询评论的记录数，用户分批加载数据
	 */
	public static final int SELECT_COMMENT_DEFAULT_NUM = 7;
	/**
	 * cookie名称-登录cookie
	 */
	public static final String COOKIE_NAME_LOGIN_COOKIE = "LOGIN_COOKIE";
	/**
	 * 登录cookie的作用域
	 */
	public static final String LOGIN_COOKIE_PATH = "/MNRMP/";
	/**
	 * 用户类型-普通用户
	 */
	public static final String USER_TYPE_USER = "COMMON_USER";
	/**
	 * 用户类型-资源管理员
	 */
	public static final String USER_TYPE_RES_MANAGER = "RES_MANAGER";
	/**
	 * 用户类型-系统管理员
	 */
	public static final String USER_TYPE_SYS_ADMIN = "SYS_ADMIN";
	/**
	 * session名称-字典数据
	 */
	public static final String SESSION_NAME_DIC_DATA = "DIC_DATA";
	/**
	 * 默认的缩略图名称
	 */
	public static final String DEFAULT_MINIATURE_NAEM = "miniature-defalut.png";
	/**
	 * 用户角色-普通用户id
	 */
	public static final Integer ROLE_COMMON_USER_ID = 1;
	
	/**
	 * 获取用于登录的指定cookie对象
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie getLoginCookie(HttpServletRequest request, String cookieName) {
		Cookie loginCookie = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookieName.equals(cookie.getName())) {
				loginCookie = cookie;
				break;
			}
		}
		return loginCookie;
	}
	
	/**
	 * 清除指定用户类型的oldCookie
	 * @param request
	 * @param response
	 * @param userTypeCode
	 */
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookieName.equals(cookie.getName())) {
				cookie.setMaxAge(-1);
				cookie.setValue(null);
				cookie.setPath(LOGIN_COOKIE_PATH);
				response.addCookie(cookie);
			}
		}
	}
	
	/**
	 * 生成userSessionIdMap的key名称
	 * @param obj
	 * @return
	 */
	public static String generateUserSessionIdMapKeyName(Object obj) {
		if (obj instanceof MnrmpUsersT) {
			MnrmpUsersT user = (MnrmpUsersT) obj;
			return user.getUserTypeCode() + "_" + user.getUserId();
		} else if (obj instanceof MnrmpResManagersT) {
			MnrmpResManagersT resManager = (MnrmpResManagersT) obj;
			return resManager.getUserTypeCode() + "_" + resManager.getManagerId();
		} else if (obj instanceof MnrmpSysAdminsT) {
			MnrmpSysAdminsT sysAdmin = (MnrmpSysAdminsT) obj;
			return sysAdmin.getUserTypeCode() + "_" + sysAdmin.getAdminId();
		} else {
			return null;
		}
	}
	
	/**
	 * 将sessionId加入到全局的userSessionIdMap中
	 * @param obj
	 * @param sessionId
	 */
	public static void addSessionIdToUserSessionIdMap(Object obj, String sessionId) {
		// 为了实现不同浏览器，不同电脑中登录的用户信息同步
		String keyName = MnrmpUtil.generateUserSessionIdMapKeyName(obj);
		if (keyName != null && keyName.length() > 0) { // 一般情况下 keyName 都不为空
			// 如果该用户账号是第一次被登录，则创建该账号的sessionIdList，并把此次的sessionId加入到List中
			if (MnrmpUtil.userSessionIdMap.get(keyName) == null) {
				List<String> sessionIdList = new ArrayList<String>();
				sessionIdList.add(sessionId);
				MnrmpUtil.userSessionIdMap.put(keyName, sessionIdList);
			} else { // 如果该用户账号不是第一次被登录(可能之前在不同的电脑中已经登录过)，则将此次的sessionId直接加入到原有的List中
				MnrmpUtil.userSessionIdMap.get(keyName).add(sessionId);
			}
		}
	}
	
	/**
	 * 获取相同用户对应的sessionIdList
	 * @param obj
	 * @return
	 */
	public static List<String> getSameUserSessionIds(Object obj) {
		String keyName = MnrmpUtil.generateUserSessionIdMapKeyName(obj);
		if (keyName != null && keyName.length() > 0) {
			return MnrmpUtil.userSessionIdMap.get(keyName);
		}
		return null;
	}
	
	/**
	 * 更新指定session的用户信息
	 * @param session
	 * @param obj 最新的用户信息
	 */
	public static void updateUserInfoInSession(HttpSession session, Object obj) {
		List<String> sessionIdList = getSameUserSessionIds(obj);
		for (String sessionId : sessionIdList) {
			session.setAttribute(sessionId, obj);
		}
	}
	
	/**
	 * 删除指定用户对应的session，并同步MnrmpUtil.userSessionIdMap
	 * @param session
	 * @param obj 指定的用户
	 */
	public static void removeSessionByUser(HttpSession session, Object obj) {
		List<String> sessionIdList = getSameUserSessionIds(obj);
		for (String sessionId : sessionIdList) {
			session.removeAttribute(sessionId);
		}
		// 同步全局userSessionIdMap
		String keyName = MnrmpUtil.generateUserSessionIdMapKeyName(obj);
		if (keyName != null & keyName.length() > 0) {
			MnrmpUtil.userSessionIdMap.remove(keyName);
		}
	}
	
	/**
	 * 删除文件，若删除成功则返回true，否则返回false
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
	    File file = new File(filePath);
	    if (file.isFile() && file.exists()) {
	        file.delete();
	        return true;
	    } else {
	        return false;
	    }
	}
	
	/**
	 * 移动文件
	 * @param sourceFilePath
	 * @param targetFilePath
	 * @return
	 */
	public static boolean moveFile(String sourceFilePath, String targetFilePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel finc = null, foutc = null;
		try {
			File sourceFile = new File(sourceFilePath);
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFilePath);
			finc = fis.getChannel();
			foutc = fos.getChannel();
			finc.transferTo(0, finc.size(), foutc);
			if (sourceFile.isFile() && sourceFile.exists()) {
				sourceFile.delete();
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			return false;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return false;
		} catch (IOException ie) {
			ie.printStackTrace();
			return false;
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
		return true;
	}
}
