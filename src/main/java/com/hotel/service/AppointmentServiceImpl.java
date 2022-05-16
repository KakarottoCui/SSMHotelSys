package com.hotel.service;

import com.hotel.dao.AppointmentMapper;
import com.hotel.dao.VipMapper;
import com.hotel.pojo.Appointment;
import com.hotel.pojo.Vip;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(Appointment appointment) {
        return appointmentMapper.add(appointment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(int id) {
        return appointmentMapper.deleteById(id);
    }

    @Override
    public ArrayList<Appointment> queryAll(Integer vipId, Integer homeId) {
        return appointmentMapper.queryAll(vipId, homeId);
    }

}
