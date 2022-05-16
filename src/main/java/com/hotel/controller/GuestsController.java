package com.hotel.controller;

import com.hotel.enums.HomeState;
import com.hotel.pojo.Guests;
import com.hotel.pojo.Home;
import com.hotel.service.GuestsServiceImpl;
import com.hotel.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestsController {

    @Autowired
    GuestsServiceImpl guestsService;
    @Autowired
    HomeServiceImpl homeService;

    @RequestMapping("/add")
    public ModelAndView add(Guests guests) {
        ModelAndView mv = new ModelAndView();
        Home home = homeService.queryHomeByNum(guests.getNum());
        if (home == null) {
            mv.addObject("result", "不存在该房间");
            mv.setViewName("vip/error");
            return mv;
        }
        guestsService.addGuests(guests);
        home.setState(HomeState.OCCUPIED.getState());
        homeService.updateHomeById(home);
        mv.setViewName("suc_g");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        guestsService.deleteGuestsById(id);
        return "redirect:/guests/list";
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Guests> guestsList = guestsService.queryAllGuests();
        mv.addObject("list", guestsList);
        mv.setViewName("guests_list");
        return mv;
    }

    @RequestMapping("/update1")
    public ModelAndView update1(int id) {
        ModelAndView mv = new ModelAndView();
        Guests guests = guestsService.queryGuestsById(id);
        mv.addObject("g", guests);
        mv.setViewName("guests_update");
        return mv;
    }

    @RequestMapping("/update2")
    public String update2(Guests g) {
        guestsService.updateGuestsById(g);
        return ("redirect:/guests/list");
    }

    @RequestMapping("/find")
    public ModelAndView find(String findByPhone) {
        ModelAndView mv = new ModelAndView();
        Guests guests = guestsService.queryGuestsByPhone(findByPhone);
        List<Guests> guestsList = new ArrayList<Guests>();
        guestsList.add(guests);
        if (guests == null) {
            guestsList = guestsService.queryAllGuests();
            mv.addObject("error", "未查询出结果");
        }
        mv.addObject("list", guestsList);
        mv.setViewName("guests_list");
        return mv;
    }
}
