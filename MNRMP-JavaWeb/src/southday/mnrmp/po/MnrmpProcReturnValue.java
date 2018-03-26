package southday.mnrmp.po;

/**
 * MNRMP 数据库存储过程返回值PO类
 * @author southday
 * @date Sep 19, 2016
 */
public class MnrmpProcReturnValue {
	private Boolean tError;
	
	private Integer keyId;
	
	private String videoName;
	
	private String miniatureName;
	
	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getMiniatureName() {
		return miniatureName;
	}

	public void setMiniatureName(String miniatureName) {
		this.miniatureName = miniatureName;
	}

	public Boolean gettError() {
		return tError;
	}

	public void settError(Boolean tError) {
		this.tError = tError;
	}

	public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
}
