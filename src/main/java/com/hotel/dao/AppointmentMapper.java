package com.hotel.dao;

import com.hotel.pojo.Appointment;
import com.hotel.pojo.Vip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface AppointmentMapper {

    int add(Appointment appointment);

    int deleteById(int id);

    ArrayList<Appointment> queryAll(@Param("vipId") Integer vipId, @Param("homeId") Integer homeId);

}
