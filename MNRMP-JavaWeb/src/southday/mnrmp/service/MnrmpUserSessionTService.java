package southday.mnrmp.service;

import southday.mnrmp.po.MnrmpUserSessionT;

public interface MnrmpUserSessionTService {
	
	/**
	 * 核对用户cookie中的数据是否与数据库表中保存的一致，以实现使用cookie自动登录
	 * @param userSession
	 * @return
	 * @throws Exception
	 */
	public Boolean checkUserCookie(MnrmpUserSessionT userSession) throws Exception;
	
	/**
	 * 当用户登录时，获取当前sessionId，然后将信息更新到mnrmp_user_session_t表相关的记录中
	 * @param userSession
	 * @throws Exception
	 */
	public void updateUserSessionId(MnrmpUserSessionT userSession) throws Exception;
}
