package com.example.demo.entity;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/30 20:08
 */
public class DeviceErrorNumber {
    private String deviceName;
    private String errorNum;

    public DeviceErrorNumber(String deviceName, String errorNum) {
        this.deviceName = deviceName;
        this.errorNum = errorNum;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(String errorNum) {
        this.errorNum = errorNum;
    }
}
