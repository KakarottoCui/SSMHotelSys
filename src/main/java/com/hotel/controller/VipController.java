package com.hotel.controller;

import com.hotel.enums.HomeState;
import com.hotel.pojo.Appointment;
import com.hotel.pojo.Guests;
import com.hotel.pojo.Home;
import com.hotel.pojo.Vip;
import com.hotel.service.AppointmentService;
import com.hotel.service.GuestsServiceImpl;
import com.hotel.service.HomeServiceImpl;
import com.hotel.service.VipServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vip")
public class VipController {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final String SESSION_USER = "LOGINUSER";
    private static final String DEFAULT_VIP_NAME = "VIP客户";
    private static final String DEFAULT_VIP_SEX = "男";
    private static final String DEFAULT_VIP_TYPE = "初级会员";

    @Autowired
    HttpSession session;
    @Autowired
    VipServiceImpl vipService;
    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    GuestsServiceImpl guestsService;

    @RequestMapping("/add")
    public ModelAndView add(Vip vip) {
        ModelAndView mv = new ModelAndView();
        vipService.addVip(vip);
        mv.setViewName("suc_v");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        vipService.deleteVipById(id);
        return "redirect:/vip/list";
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Vip> vipList = vipService.queryAllVip();
        mv.addObject("list", vipList);
        mv.setViewName("vip_list");
        return mv;
    }

    @RequestMapping("/update1")
    public ModelAndView update1(int id) {
        ModelAndView mv = new ModelAndView();
        Vip vip = vipService.queryVipById(id);
        mv.addObject("v", vip);
        mv.setViewName("vip_update");
        return mv;
    }

    @RequestMapping("/update2")
    public String update2(Vip v) {
        vipService.updateVipById(v);
        return ("redirect:/vip/list");
    }

    @RequestMapping("/find")
    public ModelAndView find(String findByPhone) {
        ModelAndView mv = new ModelAndView();
        Vip vip = vipService.queryVipByPhone(findByPhone);
        List<Vip> vipList = new ArrayList<Vip>();
        vipList.add(vip);
        if (vip == null) {
            vipList = vipService.queryAllVip();
            mv.addObject("verror", "未查询出结果");
        }
        mv.addObject("list", vipList);
        mv.setViewName("vip_list");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        ModelAndView mv = new ModelAndView();
        try {
            Vip vip = vipService.findByLogin(username, password);
            if (vip != null) {
                if (vip.getPassword().equals(password)) {
                    session.setAttribute(SESSION_USER, vip);
                    mv.setViewName("vip/index");
                    return mv;
                }
            }
            mv.addObject("result", "账号或密码错误");
            mv.setViewName("vip/error");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("result", "系统异常");
            mv.setViewName("vip/error");
        }
        return mv;
    }

    @RequestMapping("/home/list")
    public ModelAndView homeList() {
        ModelAndView mv = new ModelAndView();
        List<Home> homeList = homeService.queryAllHome();
        for (Home home : homeList) {
            ArrayList<Guests> guests = guestsService.queryAllGuests();
            for (Guests guest : guests) {
                if (home.getNum() == guest.getNum()) {
                    home.setState(HomeState.OCCUPIED.getState());
                    break;
                }
            }
        }
        mv.addObject("list", homeList);
        mv.setViewName("vip/home_list");
        return mv;
    }

    @RequestMapping("/home/find")
    public ModelAndView homeFind(int findByNum) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeByNum(findByNum);
        List<Home> homeList = new ArrayList<Home>();
        homeList.add(home);
        if (home == null) {
            homeList = homeService.queryAllHome();
            mv.addObject("error", "未查询出结果");
        }
        mv.addObject("list", homeList);
        mv.setViewName("vip/home_list");
        return mv;
    }

    @RequestMapping("/home/appoint")
    public ModelAndView homeAppoint(Integer id) {
        ModelAndView mv = new ModelAndView();
        try {
            Home home = homeService.queryHomeById(id);
            if (home == null) {
                mv.addObject("result", "房间不存在");
                mv.setViewName("vip/error");
                return mv;
            }
            if (HomeState.EMPTY.getState().equals(home.getState())) {
                //guests入住
                boolean canAppointment = true;
                ArrayList<Guests> guests = guestsService.queryAllGuests();
                for (Guests guest : guests) {
                    if (guest.getNum() == home.getNum()) {
                        canAppointment = false;
                        break;
                    }
                }
                if (canAppointment) {
                    home.setState(HomeState.APPOINTING.getState());
                    homeService.updateHomeById(home);
                    Vip vip = (Vip) session.getAttribute(SESSION_USER);
                    Appointment appointment = new Appointment();
                    appointment.setVip_Id(vip.getId());
                    appointment.setHome_Id(id);
                    appointment.setAppointment_Time(sdf.format(new Date()));
                    appointmentService.add(appointment);
                    mv.addObject("result", "房间预约成功");
                    mv.setViewName("vip/suc");
                } else {
                    mv.addObject("result", "该房间已入住，无法预约");
                    mv.setViewName("vip/error");
                }
            } else {
                mv.addObject("result", "该房间已预约");
                mv.setViewName("vip/error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("result", "系统异常");
            mv.setViewName("vip/error");
        }
        return mv;
    }

    @RequestMapping("/home/show")
    public ModelAndView homeShow(Integer id) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeById(id);
        mv.addObject("home", home);
        mv.setViewName("vip/home_show");
        return mv;
    }

    @RequestMapping("/register")
    public ModelAndView register(Vip vip) {
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(vip.getAccount())) {
            mv.addObject("result", "账号不能为空");
            mv.setViewName("vip/error");
            return mv;
        }
        if (StringUtils.isBlank(vip.getPassword())) {
            mv.addObject("result", "密码不能为空");
            mv.setViewName("vip/error");
            return mv;
        }
        if (!vip.getPassword().equals(vip.getConfirmPassword())) {
            mv.addObject("result", "密码不一致");
            mv.setViewName("vip/error");
            return mv;
        }
        Vip existVip = vipService.queryVipByAccount(vip.getAccount());
        if (existVip != null) {
            mv.addObject("result", "该账号已存在");
            mv.setViewName("vip/error");
            return mv;
        }
        vip.setName(DEFAULT_VIP_NAME);
        vip.setSex(DEFAULT_VIP_SEX);
        vip.setCard(0);
        vip.setPhone(0);
        vip.setV_Type(DEFAULT_VIP_TYPE);
        vip.setStartTime(sdf.format(new Date()));
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 1);
        vip.setEndTime(sdf.format(instance.getTime()));
        vipService.addVip(vip);
        mv.addObject("url", "/vip");
        mv.setViewName("vip/suc");
        return mv;
    }
}

