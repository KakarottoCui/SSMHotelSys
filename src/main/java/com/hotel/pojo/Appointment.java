package com.hotel.pojo;

/**
 * 类描述：预约关系表
 * @author 8528
 * @date 2022-05-03 14:04:22
 */
public class Appointment {
    private Integer Id;
    private Integer Vip_Id;
    private Integer Home_Id;
    private String Appointment_Time;

    /************ 用于显示的字段 ************/
    private String Vip_Name;
    private String Home_Num;

    public Appointment() {
    }

    public Appointment(Integer id, Integer vip_Id, Integer home_Id, String appointment_Time) {
        Id = id;
        Vip_Id = vip_Id;
        Home_Id = home_Id;
        Appointment_Time = appointment_Time;
    }

    public Appointment(Integer id, Integer vip_Id, Integer home_Id, String appointment_Time, String vip_Name, String home_Num) {
        Id = id;
        Vip_Id = vip_Id;
        Home_Id = home_Id;
        Appointment_Time = appointment_Time;
        Vip_Name = vip_Name;
        Home_Num = home_Num;
    }

    public Integer getId() {
        return Id;
    }

    public Appointment setId(Integer id) {
        Id = id;
        return this;
    }

    public Integer getVip_Id() {
        return Vip_Id;
    }

    public Appointment setVip_Id(Integer vip_Id) {
        Vip_Id = vip_Id;
        return this;
    }

    public Integer getHome_Id() {
        return Home_Id;
    }

    public Appointment setHome_Id(Integer home_Id) {
        Home_Id = home_Id;
        return this;
    }

    public String getAppointment_Time() {
        return Appointment_Time;
    }

    public Appointment setAppointment_Time(String appointment_Time) {
        Appointment_Time = appointment_Time;
        return this;
    }

    public String getVip_Name() {
        return Vip_Name;
    }

    public Appointment setVip_Name(String vip_Name) {
        Vip_Name = vip_Name;
        return this;
    }

    public String getHome_Num() {
        return Home_Num;
    }

    public Appointment setHome_Num(String home_Num) {
        Home_Num = home_Num;
        return this;
    }
}
