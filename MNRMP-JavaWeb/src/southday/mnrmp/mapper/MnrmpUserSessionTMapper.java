package southday.mnrmp.mapper;

import southday.mnrmp.po.MnrmpUserSessionT;

public interface MnrmpUserSessionTMapper {

	/**
	 * 根据account、sessionId、userTypeCode来查询用户session信息，判断用户session是否存在
	 * @param userSession
	 * @return
	 * @throws Exception
	 */
	public Boolean findUserSessionExists(MnrmpUserSessionT userSession) throws Exception;
	
	/**
	 * 更新用户sessionID
	 * @param userSession
	 * @throws Exception
	 */
	public void updateUserSessionId(MnrmpUserSessionT userSession) throws Exception;
}
