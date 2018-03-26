package southday.mnrmp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpCatalogsT;
import southday.mnrmp.po.MnrmpVideosT;

public interface MnrmpCatalogsTMapper {
    
    /**
     * 根据catalogId来获取目录信息
     * @param catalogId
     * @return
     * @throws Exception
     */
    public MnrmpCatalogsT findCatalogByCatalogId(@Param(value="catalogId") Integer catalogId) throws Exception;
   
    /**
     * 查询指定用户的视频目录
     * @param userId
     * @return
     * @throws Exception
     */
    public List<MnrmpCatalogsT> findCatalogsByUserId(@Param(value="userId") Integer userId) throws Exception;
    
    /**
     * 查询指定用户的某个目录及该目录下的所有子目录
     * @param catalog
     * @return
     * @throws Exception
     */
    public List<MnrmpCatalogsT> findCatalogWithChilds(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 插入用户视频目录记录
     * @param catalog
     * @return
     * @throws Exception
     */
    public MnrmpCatalogsT insertCatalog(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 在删除视频目录前，获取该用户自己上传的[已接受]或[已拒绝]的在该目录下的视频
     * @param catalog
     * @return
     * @throws Exception
     */
    public List<MnrmpVideosT> findMyVideosByCatalogId(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 删除用户视频目录
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean deleteCatalog(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 更新视频目录名称(目录重命名)
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean updateCatalogName(MnrmpCatalogsT catalog) throws Exception;
    
    /**
     * 更新视频目录位置(目录移动)
     * @param catalog
     * @return
     * @throws Exception
     */
    public Boolean updateCatalogSite(MnrmpCatalogsT catalog) throws Exception;
}
