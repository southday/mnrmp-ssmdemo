package southday.mnrmp.mapper;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpUsersT;

public interface MnrmpUsersTMapper {
    
    /**
     * 根据id查询用户详细信息
     * @param userId
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserById(@Param(value="userId") Integer userId) throws Exception;
    
    /**
     * 根据用户账号和密码查询匹配的用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserByAccountPassword(MnrmpUsersT user) throws Exception;
    
    /**
     * 根据用户电子邮件和密码查询匹配鹅的用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserByEmailPassword(MnrmpUsersT user) throws Exception;
    
    /**
     * 根据用户账号查询匹配的用户信息
     * @param account
     * @return
     * @throws Exception
     */
    public MnrmpUsersT findUserByAccount(String account) throws Exception;
    
    /**
     * 根据id和密码判断用户是否存在
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean findUserExistsByIdPassword(MnrmpUsersT user) throws Exception;
    
    /**
     * 查询是否用户账号已存在
     * @param account
     * @return
     * @throws Exception
     */
    public Boolean findAccountExists(@Param(value="account") String account) throws Exception;
    
    /**
     * 查询是否用户Email已存在
     * @param email
     * @return
     * @throws Exception
     */
    public Boolean findEmailExists(@Param(value="email") String email) throws Exception;
    
    /**
     * 用户注册，是一个事务，需要操作mnrmp_users_t,mnrmp_catalogs_t,mnrmp_user_session_t三张表
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean insertUser(MnrmpUsersT user) throws Exception;
    
    /**
     * 根据user_id判断该用户是否已经激活
     * @param userId
     * @return
     * @throws Exception
     */
    public Boolean findIsActivatedByUserId(@Param(value="userId") Integer userId) throws Exception;
    
    /**
     * 通过user_id来更新指定用户的账号激活状态为：已激活
     * @param userId
     * @throws Exception
     */
    public Integer updateIsActivatedByUserId(MnrmpUsersT user) throws Exception;
    
    /**
     * 更新用户基本信息
     * @param user
     * @return
     * @throws Exception
     */
    public Integer updateUserById(MnrmpUsersT user) throws Exception;
    
    /**
     * 更新用户密码
     * @param user
     * @return
     * @throws Exception
     */
    public Integer updateUserPasswordById(MnrmpUsersT user) throws Exception;
}
