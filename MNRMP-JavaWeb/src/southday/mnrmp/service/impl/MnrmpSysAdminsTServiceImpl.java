package southday.mnrmp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import southday.mnrmp.mapper.MnrmpSysAdminsTMapper;
import southday.mnrmp.po.MnrmpSysAdminsT;
import southday.mnrmp.service.MnrmpSysAdminsTService;

public class MnrmpSysAdminsTServiceImpl implements MnrmpSysAdminsTService {

	@Autowired
	private MnrmpSysAdminsTMapper sysAdminMapper;
	
	@Override
	public MnrmpSysAdminsT login(MnrmpSysAdminsT sysAdmin) throws Exception {
		// TODO Auto-generated method stub
		if (sysAdmin.getAccount().contains("@")) {
			sysAdmin.setEmail(sysAdmin.getAccount()); // 使用 [电子邮箱] 登录
			return sysAdminMapper.findSysAdminByEmailPassword(sysAdmin);
		} else { // 使用 [登录账号] 登录
			return sysAdminMapper.findSysAdminByAccountPassword(sysAdmin);
		}
	}

	@Override
	public MnrmpSysAdminsT findSysAdminByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return sysAdminMapper.findSysAdminByAccount(account);
	}

}
