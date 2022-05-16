package com.hotel.dao;

import com.hotel.pojo.Guests;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface GuestsMapper {

    int addGuests(Guests guests);

    int deleteGuestsById(int id);

    int updateGuestsById(Guests guests);

    Guests queryGuestsById(int id);

    ArrayList<Guests> queryAllGuests();

    Guests queryGuestsByPhone(String phone);

    Guests queryGuestsByHomeNum(Integer num);
}
