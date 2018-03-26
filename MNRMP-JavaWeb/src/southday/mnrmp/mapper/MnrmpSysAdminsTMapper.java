package southday.mnrmp.mapper;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpSysAdminsT;

public interface MnrmpSysAdminsTMapper {
    
    /**
     * 根据id查询系统管理员详细信息
     * @param adminId
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT findSysAdminById(@Param(value="adminId") Integer adminId) throws Exception;
    
    /**
     * 根据系统管理员账号和密码查询匹配的系统管理员信息
     * @param sysAdmin
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT findSysAdminByAccountPassword(MnrmpSysAdminsT sysAdmin) throws Exception;
    
    /**
     * 根据系统管理员电子邮件和密码查询匹配的系统管理员信息
     * @param sysAdmin
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT findSysAdminByEmailPassword(MnrmpSysAdminsT sysAdmin) throws Exception;
    
    /**
     * 根据系统管理员账号查询匹配的系统管理员信息
     * @param account
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT findSysAdminByAccount(String account) throws Exception;
}
