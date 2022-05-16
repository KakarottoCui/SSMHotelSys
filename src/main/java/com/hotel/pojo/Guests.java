package com.hotel.pojo;

public class Guests {

    private int Id;
    private String Name;
    private String Sex;
    private long Card;
    private long Phone;
    private String EnterTime;
    private String ExitTime;
    private int Num;
    private String H_Type;


    public Guests(int id, String name, String sex, long card, long phone, String enterTime, String exitTime, int num, String h_Type) {
        Id = id;
        Name = name;
        Sex = sex;
        Card = card;
        Phone = phone;
        EnterTime = enterTime;
        ExitTime = exitTime;
        Num = num;
        H_Type = h_Type;
    }

    public Guests() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public long getCard() {
        return Card;
    }

    public void setCard(long card) {
        Card = card;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }

    public String getEnterTime() {
        return EnterTime;
    }

    public void setEnterTime(String enterTime) {
        EnterTime = enterTime;
    }

    public String getExitTime() {
        return ExitTime;
    }

    public void setExitTime(String exitTime) {
        ExitTime = exitTime;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getH_Type() {
        return H_Type;
    }

    public void setH_Type(String h_Type) {
        H_Type = h_Type;
    }

    @Override
    public String toString() {
        return "Guests{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Card=" + Card +
                ", Phone=" + Phone +
                ", EnterTime='" + EnterTime + '\'' +
                ", ExitTime='" + ExitTime + '\'' +
                ", Num=" + Num +
                ", H_Type='" + H_Type + '\'' +
                '}';
    }
}
