package com.hotel.controller;

import com.hotel.enums.HomeState;
import com.hotel.pojo.Appointment;
import com.hotel.pojo.Guests;
import com.hotel.pojo.Home;
import com.hotel.pojo.Vip;
import com.hotel.service.AppointmentService;
import com.hotel.service.GuestsService;
import com.hotel.service.GuestsServiceImpl;
import com.hotel.service.HomeServiceImpl;
import com.hotel.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/home")

public class HomeController {

    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    VipService vipService;
    @Autowired
    GuestsService guestsService;

    @RequestMapping("/add")
    public String add(Home home, Model model) throws IOException {

        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath = "D:\\Projects\\BiShe\\SsmHotel\\Hotel_Manage\\src\\main\\webapp\\WEB-INF\\views\\static\\admin\\img\\";
        //定义 文件名
        String filename = null;
        if (!home.getFile().isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = home.getFile().getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //得到 文件名
            filename = uuid + "." + suffixName;
            System.out.println(filename);
            //文件保存路径
            home.getFile().transferTo(new File(localPath + filename));
        }
        //把图片的相对路径保存至数据库
        sqlPath = "/img/" + filename;
        System.out.println(sqlPath);
        home.setImg(sqlPath);

        homeService.addHome(home);
        model.addAttribute("home", home);
        return "home_show";
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Integer id) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeById(id);
        if (home == null) {
            mv.addObject("result", "该房间不存在");
            mv.setViewName("vip/error");
            return mv;
        }
        Guests guests = guestsService.queryGuestsByHomeNum(home.getNum());
        if (guests != null) {
            mv.addObject("result", "该房间已预约，无法删除");
            mv.setViewName("vip/error");
            return mv;
        }
        ArrayList<Appointment> appointments = appointmentService.queryAll(null, home.getId());
        if (appointments != null && appointments.size() > 0) {
            mv.addObject("result", "该房间已预约，无法删除");
            mv.setViewName("vip/error");
            return mv;
        }
        homeService.deleteHomeById(id);
        mv.addObject("url", "/home/list");
        mv.setViewName("suc");
        return mv;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Home> homeList = homeService.queryAllHome();
        for (Home home : homeList) {
            ArrayList<Appointment> appointments = appointmentService.queryAll(null, home.getId());
            if (appointments != null && !appointments.isEmpty()) {
                Appointment appointment = appointments.get(0);
                Vip vip = vipService.queryVipById(appointment.getVip_Id());
                home.setAppointmentName(vip.getName());
            }
            ArrayList<Guests> guests = guestsService.queryAllGuests();
            for (Guests guest : guests) {
                if (home.getNum()==guest.getNum()) {
                    home.setAppointmentName(guest.getName());
                    home.setState(HomeState.OCCUPIED.getState());
                    break;
                }
            }
        }
        mv.addObject("list", homeList);
        mv.setViewName("home_list");
        return mv;
    }

    @RequestMapping("/update1")
    public ModelAndView update1(Integer id) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeById(id);
        mv.addObject("h", home);
        mv.setViewName("home_update");
        return mv;
    }

    @RequestMapping("/update2")
    public String update2(Home h) throws IOException {
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath = "D:\\Projects\\BiShe\\SsmHotel\\Hotel_Manage\\src\\main\\webapp\\WEB-INF\\views\\static\\admin\\img\\";
        //定义 文件名
        String filename = null;
        if (!h.getFile().isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = h.getFile().getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //得到 文件名
            filename = uuid + "." + suffixName;
            System.out.println(filename);
            //文件保存路径
            h.getFile().transferTo(new File(localPath + filename));
        }
        //把图片的相对路径保存至数据库
        sqlPath = "/img/" + filename;
        System.out.println(sqlPath);
        h.setImg(sqlPath);

        homeService.updateHomeById(h);
        return ("redirect:/home/list");
    }

    @RequestMapping("/show")
    public ModelAndView show(Integer id) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeById(id);
        mv.addObject("home", home);
        mv.setViewName("home_show");
        return mv;
    }

    @RequestMapping("/find")
    public ModelAndView find(int findByNum) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeByNum(findByNum);
        List<Home> homeList = new ArrayList<Home>();
        homeList.add(home);
        if (home == null) {
            homeList = homeService.queryAllHome();
            mv.addObject("error", "未查询出结果");
        }
        mv.addObject("list", homeList);
        mv.setViewName("home_list");
        return mv;
    }

    @RequestMapping("/type1")
    public String type1(Integer id, Model model) {
        Home home = homeService.queryHomeById(id);
        model.addAttribute("h", home);
        return "H_Type_update";
    }

    @RequestMapping("/type2")
    public String type2(Home home) {
        homeService.updateH_TypeById(home);
        return "redirect:/home/list";
    }
}
