package com.hotel.service;

import com.hotel.pojo.Guests;

import java.util.ArrayList;

public interface GuestsService {

    int addGuests (Guests guests);

    int deleteGuestsById (int id);

    int updateGuestsById (Guests guests);

    Guests queryGuestsById (int id);

    ArrayList<Guests> queryAllGuests();

    Guests queryGuestsByPhone(String phone);

    Guests queryGuestsByHomeNum(Integer num);
}
