package southday.mnrmp.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import southday.mnrmp.mapper.MnrmpManagerAuditsTMapper;
import southday.mnrmp.mapper.MnrmpResManagersTMapper;
import southday.mnrmp.po.MnrmpManagerAuditsT;
import southday.mnrmp.po.MnrmpManagerAuditsV;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpResManagersT;
import southday.mnrmp.service.MnrmpResManagersTService;

public class MnrmpResManagersTServiceImpl implements MnrmpResManagersTService {
    
    @Autowired
    private MnrmpResManagersTMapper resManagerMapper;

    @Override
    public MnrmpResManagersT login(MnrmpResManagersT resManager) throws Exception {
        // TODO Auto-generated method stub
        if (resManager.getAccount().contains("@")) {
            resManager.setEmail(resManager.getAccount()); // 使用 [电子邮箱] 登录
            return resManagerMapper.findResManagerByEmailPassword(resManager);
        } else { // 使用 [登录账号] 登录
            return resManagerMapper.findResManagerByAccountPassword(resManager);
        }
    }

    @Override
    public MnrmpResManagersT findResManagerByAccount(String account) throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.findResManagerByAccount(account);
    }

    @Override
    public List<Integer> getResManagerIds() throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.findResManagerIds();
    }

    @Override
    public Integer randomSelectOneResManagerId() throws Exception {
        // TODO Auto-generated method stub
        List<Integer> resManagerIdList = getResManagerIds();
        return resManagerIdList.get(new Random().nextInt(resManagerIdList.size()));
    }
    
    @Autowired
    private MnrmpManagerAuditsTMapper managerAuditMapper;

    @Override
    public List<MnrmpManagerAuditsV> getAuditRecord(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return managerAuditMapper.findAuditRecord(queryParam);
    }

    @Override
    public Boolean auditVideo(MnrmpManagerAuditsT managerAudit) throws Exception {
        // TODO Auto-generated method stub
        return managerAuditMapper.updateAuditRecord(managerAudit);
    }

    @Override
    public Integer updateResManagerBasicInfo(MnrmpResManagersT resManager) throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.updateResManagerById(resManager);
    }

    @Override
    public Integer updateResManagerPassword(MnrmpResManagersT resManager) throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.updateResManagerPasswordById(resManager);
    }

    @Override
    public Boolean isPasswordRight(MnrmpResManagersT resManager) throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.findResManagerExistsByIdPassword(resManager);
    }

    @Override
    public MnrmpResManagersT findResManagerById(Integer managerId) throws Exception {
        // TODO Auto-generated method stub
        return resManagerMapper.findResManagerById(managerId);
    }

    @Override
    public Integer getAuditTotalRecordNum(MnrmpQueryParameter queryParam) throws Exception {
        // TODO Auto-generated method stub
        return managerAuditMapper.findAuditTotalRecordNum(queryParam);
    }

}
