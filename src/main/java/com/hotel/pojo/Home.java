package com.hotel.pojo;

import com.hotel.enums.HomeState;
import org.springframework.web.multipart.MultipartFile;

public class Home {

    private Integer Id;
    private int Num;
    private String H_Type;
    private String Price;
    /**
     * @see HomeState
     */
    private String State;
    private String Img;
    private String Text;

    private MultipartFile file;
    /**
     * 预约人名称
     */
    private String appointmentName;

    public Home() {
    }

    public Home(Integer id, int num, String h_Type, String price, String state, String img, String text, MultipartFile file) {
        Id = id;
        Num = num;
        H_Type = h_Type;
        Price = price;
        State = state;
        Img = img;
        Text = text;
        this.file = file;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public Home setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
        return this;
    }

    @Override
    public String toString() {
        return "Home{" +
                "Id=" + Id +
                ", Num=" + Num +
                ", H_Type='" + H_Type + '\'' +
                ", Price='" + Price + '\'' +
                ", State='" + State + '\'' +
                ", Img='" + Img + '\'' +
                ", Text='" + Text + '\'' +
                ", file=" + file +
                ", appointmentName='" + appointmentName + '\'' +
                '}';
    }
}
