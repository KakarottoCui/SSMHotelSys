package com.hotel.service;

import com.hotel.dao.AdminMapper;
import com.hotel.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
            AdminMapper adminMapper;

    @Override
    public int updatePwd(Admin admin) {
        return adminMapper.updatePwd(admin) ;
    }

    @Override
    public Admin findAdmin(String username, int password) {
        return adminMapper.findAdmin(username,password);
    }


}
