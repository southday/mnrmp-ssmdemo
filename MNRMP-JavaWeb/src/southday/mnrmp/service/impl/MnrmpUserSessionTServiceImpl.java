package southday.mnrmp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import southday.mnrmp.mapper.MnrmpUserSessionTMapper;
import southday.mnrmp.po.MnrmpUserSessionT;
import southday.mnrmp.service.MnrmpUserSessionTService;

public class MnrmpUserSessionTServiceImpl implements MnrmpUserSessionTService {
    
    @Autowired
    private MnrmpUserSessionTMapper userSessionMapper;

    @Override
    public Boolean checkUserCookie(MnrmpUserSessionT userSession) throws Exception {
        // TODO Auto-generated method stub
        return userSessionMapper.findUserSessionExists(userSession);
    }

    @Override
    public void updateUserSessionId(MnrmpUserSessionT userSession) throws Exception {
        // TODO Auto-generated method stub
        userSessionMapper.updateUserSessionId(userSession);
    }

}
