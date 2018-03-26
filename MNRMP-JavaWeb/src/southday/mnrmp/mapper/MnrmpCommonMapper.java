package southday.mnrmp.mapper;

import org.apache.ibatis.annotations.Param;

public interface MnrmpCommonMapper {
	
	/**
	 * 查询指定表的下一个自增id
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public Integer findNextAutoIncId(@Param(value="tableName") String tableName) throws Exception;
}
