package com.hotel.dao;

import com.hotel.pojo.Vip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface VipMapper {

    int addVip(Vip vip);

    int deleteVipById(int id);

    int updateVipById(Vip vip);

    Vip queryVipById(int id);

    ArrayList<Vip> queryAllVip();

    Vip queryVipByPhone(String phone);

    Vip queryVipByAccount(String account);

    Vip findByLogin(@Param("account") String account, @Param("password") String password);
}
