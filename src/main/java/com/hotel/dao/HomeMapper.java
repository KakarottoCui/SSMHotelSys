package com.hotel.dao;

import com.hotel.pojo.Home;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface HomeMapper {

    int addHome(Home home);

    int deleteHomeById(int id);

    int updateHomeById(Home home);

    Home queryHomeById(Integer  id);

    ArrayList<Home> queryAllHome();

    Home queryHomeByNum(int num);

    int updateH_TypeById(Home home);
}
