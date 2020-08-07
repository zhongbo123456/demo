package com.example.demo.test;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/8/7 15:55
 */
public class Alarm {
    private String alarmCode;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String deviceName;
    private Integer deviceCount;

    public Alarm() {
    }

    public Alarm(String alarmCode, String deviceName) {
        this.alarmCode = alarmCode;
        this.deviceName = deviceName;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }
}
