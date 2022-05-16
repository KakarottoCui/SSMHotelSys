package com.hotel.service;

import com.hotel.pojo.Admin;

public interface AdminService {

    int updatePwd (Admin admin);

    Admin findAdmin(String username,int password);
}
