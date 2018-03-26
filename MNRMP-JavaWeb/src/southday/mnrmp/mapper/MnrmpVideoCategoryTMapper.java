package southday.mnrmp.mapper;

import southday.mnrmp.po.MnrmpVideoCategoryT;

public interface MnrmpVideoCategoryTMapper {

	/**
	 * 插入一条视频分类记录
	 * @param videoCategory
	 * @throws Exception
	 */
	public void insertOneVideoCategoryRecord(MnrmpVideoCategoryT videoCategory) throws Exception;
}
