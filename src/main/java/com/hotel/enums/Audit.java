package com.hotel.enums;

/**
 * 类描述：房间预约审核结果
 * @author 8528
 * @date 2022-05-03 13:50:22
 */
public enum Audit {
    AGREE(0, "通过"),
    REFUSE(1, "拒绝"),
    ;
    private final Integer code;
    private final String desc;

    Audit(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
