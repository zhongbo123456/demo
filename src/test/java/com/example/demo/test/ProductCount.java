package com.example.demo.test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @BelongProjecet manage-device-mangement
 * @BelongPackage com.langyangtech.iot.managedevicemangement.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/10 13:34
 */
public class ProductCount {
    /**
     * 本月
     */
    @JsonFormat(
            pattern = "yyyy-MM"
    )
    private Date month;



    /**
     * 本月产品数量
     */
    private Integer value;

    /**
     * 本月与上月产品数量的差值
     */
    private Integer difference;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }



    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }



    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }
}
