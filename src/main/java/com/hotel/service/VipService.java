package com.hotel.service;

import com.hotel.pojo.Vip;

import java.util.ArrayList;

public interface VipService {

    int addVip(Vip vip);

    int deleteVipById(int id);

    int updateVipById(Vip vip);

    Vip queryVipById(int id);

    ArrayList<Vip> queryAllVip();

    Vip queryVipByPhone(String phone);

    Vip queryVipByAccount(String account);

    Vip findByLogin(String account, String password);
}
