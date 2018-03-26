package southday.mnrmp.service;

import java.util.List;

import southday.mnrmp.po.MnrmpManagerAuditsT;
import southday.mnrmp.po.MnrmpManagerAuditsV;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpResManagersT;

public interface MnrmpResManagersTService {
	/**
	 * 资源管理员登录
	 * @param resManager
	 * @return
	 * @throws Exception
	 */
	public MnrmpResManagersT login(MnrmpResManagersT resManager) throws Exception;
	
	/**
	 * 根据资源管理员账号查找资源管理员信息并返回
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public MnrmpResManagersT findResManagerByAccount(String account) throws Exception;
	
	/**
	 * 获取所有资源管理员的id
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getResManagerIds() throws Exception;
	
	/**
	 * 随机选择一个资源管理员的id
	 * @return
	 * @throws Exception
	 */
	public Integer randomSelectOneResManagerId() throws Exception;
	
	/**
	 * 根据managerId和statusCode来获取审核记录 
	 * @param managerAudit
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpManagerAuditsV> getAuditRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 审核视频资源
	 * @param managerAudit
	 * @return
	 * @throws Exception
	 */
	public Boolean auditVideo(MnrmpManagerAuditsT managerAudit) throws Exception;
	
	/**
	 * 更新资源管理员基本信息
	 * @param resManager
	 * @return
	 * @throws Exception
	 */
	public Integer updateResManagerBasicInfo(MnrmpResManagersT resManager) throws Exception;
	
	/**
	 * 更新资源管理员密码
	 * @param resManager
	 * @return
	 * @throws Exception
	 */
	public Integer updateResManagerPassword(MnrmpResManagersT resManager) throws Exception;
	
	/**
	 * 判断资源管理员密码是否正确
	 * @param resManager
	 * @return
	 * @throws Exception
	 */
	public Boolean isPasswordRight(MnrmpResManagersT resManager) throws Exception;
	
	/**
	 * 根据id查询资源管理员
	 * @param managerId
	 * @return
	 * @throws Exception
	 */
	public MnrmpResManagersT findResManagerById(Integer managerId) throws Exception; 
	
	/**
	 * 返回满足查询条件的审核记录总数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer getAuditTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
}
