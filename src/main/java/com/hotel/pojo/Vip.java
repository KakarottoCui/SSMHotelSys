package com.hotel.pojo;

public class Vip {

    private int Id;
    private String Name;
    private String Account;
    private String Password;
    private String Sex;
    private long Card;
    private long Phone;
    private String V_Type;
    private String StartTime;
    private String EndTime;
    /***************** 回显字段 *****************/
    private String confirmPassword;

    public Vip() {
    }

    public Vip(int id, String name, String account, String password, String sex, long card, long phone, String v_Type, String startTime, String endTime) {
        Id = id;
        Name = name;
        Account = account;
        Password = password;
        Sex = sex;
        Card = card;
        Phone = phone;
        V_Type = v_Type;
        StartTime = startTime;
        EndTime = endTime;
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

    public String getV_Type() {
        return V_Type;
    }

    public void setV_Type(String v_Type) {
        V_Type = v_Type;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getAccount() {
        return Account;
    }

    public Vip setAccount(String account) {
        Account = account;
        return this;
    }

    public String getPassword() {
        return Password;
    }

    public Vip setPassword(String password) {
        Password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Vip setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Card=" + Card +
                ", Phone=" + Phone +
                ", V_Type='" + V_Type + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
