package southday.mnrmp.mapper;

import java.util.List;

import southday.mnrmp.po.MnrmpManagerAuditsT;
import southday.mnrmp.po.MnrmpManagerAuditsV;
import southday.mnrmp.po.MnrmpQueryParameter;

public interface MnrmpManagerAuditsTMapper {
	/**
	 * 根据managerId和statusCode来查询相应的审核记录
	 * @param managerAudit
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpManagerAuditsV> findAuditRecord(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 更新审核记录
	 * @param managerAudit
	 * @return
	 * @throws Exception
	 */
	public Boolean updateAuditRecord(MnrmpManagerAuditsT managerAudit) throws Exception;
	
	/**
	 * 查询满足查询条件的审核记录总数
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public Integer findAuditTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception;
}