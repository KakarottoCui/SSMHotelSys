package com.hotel.service;

import com.hotel.dao.HomeMapper;
import com.hotel.pojo.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class HomeServiceImpl  implements HomeService{

    @Autowired
            HomeMapper homeMapper;


    public int addHome(Home home) {
        return homeMapper.addHome(home);
    }

    public int deleteHomeById(int id) {
        return homeMapper.deleteHomeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateHomeById(Home home) {
        return homeMapper.updateHomeById(home);
    }

    public Home queryHomeById(Integer  id) {
        return homeMapper.queryHomeById(id);
    }

    public ArrayList<Home> queryAllHome() {
        return homeMapper.queryAllHome();
    }

    public Home queryHomeByNum(int num) {
        return homeMapper.queryHomeByNum(num);
    }

    @Override
    public int updateH_TypeById(Home home) {
        return homeMapper.updateH_TypeById(home);
    }

}
