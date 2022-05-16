package com.hotel.enums;

/**
 * 类描述：房间状态
 * @author 8528
 * @date 2022-05-03 12:53:59
 */
public enum HomeState {
    EMPTY("空房"),
    APPOINTING("预约中"),
    APPOINTMENT("已预约"),
    OCCUPIED("已入住"),
    NOT_CLEAN("未打扫"),
    ;
    private final String state;

    HomeState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
