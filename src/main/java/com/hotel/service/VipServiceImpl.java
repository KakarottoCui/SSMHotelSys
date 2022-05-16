package com.hotel.service;

import com.hotel.dao.VipMapper;
import com.hotel.pojo.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    VipMapper vipMapper;

    public int addVip(Vip vip) {
        return vipMapper.addVip(vip);
    }

    public int deleteVipById(int id) {
        return vipMapper.deleteVipById(id);
    }

    public int updateVipById(Vip vip) {
        return vipMapper.updateVipById(vip);
    }

    public Vip queryVipById(int id) {
        return vipMapper.queryVipById(id);
    }

    public ArrayList<Vip> queryAllVip() {
        return vipMapper.queryAllVip();
    }

    public Vip queryVipByPhone(String phone) {
        return vipMapper.queryVipByPhone(phone);
    }

    @Override
    public Vip queryVipByAccount(String account) {
        return vipMapper.queryVipByAccount(account);
    }

    @Override
    public Vip findByLogin(String account, String password) {
        return vipMapper.findByLogin(account, password);
    }
}
