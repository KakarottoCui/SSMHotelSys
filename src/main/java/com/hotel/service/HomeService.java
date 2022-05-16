package com.hotel.service;

import com.hotel.pojo.Home;

import java.util.ArrayList;

public interface HomeService {

    int addHome(Home home);

    int deleteHomeById(int id);

    int updateHomeById(Home home);

    Home queryHomeById(Integer  id);

    ArrayList<Home> queryAllHome();

    Home queryHomeByNum(int num);

    int updateH_TypeById(Home home);
}
