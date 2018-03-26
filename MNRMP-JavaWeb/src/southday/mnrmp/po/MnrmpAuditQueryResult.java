package southday.mnrmp.po;

import java.util.List;

/**
 * 视频审核记录查询结果-封装类
 * @author southday
 * @date Sep 23, 2016
 */
public class MnrmpAuditQueryResult {
	private List<MnrmpManagerAuditsV> auditList;
	
	private Integer totalRecordNum;

	public List<MnrmpManagerAuditsV> getAuditList() {
		return auditList;
	}

	public void setAuditList(List<MnrmpManagerAuditsV> auditList) {
		this.auditList = auditList;
	}

	public Integer getTotalRecordNum() {
		return totalRecordNum;
	}

	public void setTotalRecordNum(Integer totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}
	
}
