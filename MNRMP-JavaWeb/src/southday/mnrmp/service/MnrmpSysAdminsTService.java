package southday.mnrmp.service;

import southday.mnrmp.po.MnrmpSysAdminsT;

public interface MnrmpSysAdminsTService {
    /**
     * 系统管理员登录
     * @param sysAdmin 
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT login(MnrmpSysAdminsT sysAdmin) throws Exception;
    
    /**
     * 根据系统管理员账号查找资源管理员信息并返回
     * @param account
     * @return
     * @throws Exception
     */
    public MnrmpSysAdminsT findSysAdminByAccount(String account) throws Exception;
}
