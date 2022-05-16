package com.hotel.dao;

import com.hotel.pojo.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminMapper {

    int updatePwd (Admin admin);

   Admin findAdmin(String username,int password);

}
