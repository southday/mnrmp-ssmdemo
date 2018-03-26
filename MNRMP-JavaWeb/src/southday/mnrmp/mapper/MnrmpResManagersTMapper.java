package southday.mnrmp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpResManagersT;

public interface MnrmpResManagersTMapper {
    /**
     * 根据id查询资源管理员详细信息
     * @param managerId
     * @return
     * @throws Exception
     */
    public MnrmpResManagersT findResManagerById(@Param(value="managerId") Integer managerId) throws Exception;
    
    /**
     * 根据资源管理员帐号和密码查询匹配的资源管理员信息
     * @param resManager
     * @return
     * @throws Exception
     */
    public MnrmpResManagersT findResManagerByAccountPassword(MnrmpResManagersT resManager) throws Exception;
    
    /**
     * 根据资源管理员电子邮箱和密码查询匹配的资源管理员信息
     * @param resManager
     * @return
     * @throws Exception
     */
    public MnrmpResManagersT findResManagerByEmailPassword(MnrmpResManagersT resManager) throws Exception;
    
    /**
     * 根据资源管理员账号来查询匹配的资源管理员信息
     * @param account
     * @return
     * @throws Exception
     */
    public MnrmpResManagersT findResManagerByAccount(String account) throws Exception;
    
    /**
     * 查询所有资源管理员的id
     * @return
     * @throws Exception
     */
    public List<Integer> findResManagerIds() throws Exception;
    
    /**
     * 更新资源管理员基本信息
     * @param resManagers
     * @return
     * @throws Exception
     */
    public Integer updateResManagerById(MnrmpResManagersT resManager) throws Exception;
    
    /**
     * 更新资源管理员密码
     * @param resManager
     * @return
     * @throws Exception
     */
    public Integer updateResManagerPasswordById(MnrmpResManagersT resManager) throws Exception;
    
    /**
     * 根据id和密码查询资源管理员是否存在
     * @param resManager
     * @return
     * @throws Exception
     */
    public Boolean findResManagerExistsByIdPassword(MnrmpResManagersT resManager) throws Exception;
    
}
