package com.hotel.service;

import com.hotel.pojo.Appointment;

import java.util.ArrayList;

public interface AppointmentService {

    int add(Appointment appointment);

    int deleteById(int id);

    ArrayList<Appointment> queryAll(Integer vipId, Integer homeId);
}
