package com.example.demo.test;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/6 15:00
 */

public class DeviceName {
    private List<String> deviceNameList;

    public List<String> getDeviceNameList() {
        return deviceNameList;
    }

    public void setDeviceNameList(List<String> deviceNameList) {
        this.deviceNameList = deviceNameList;
    }

    public DeviceName() {
    }

    public DeviceName(List<String> deviceNameList) {
        this.deviceNameList = deviceNameList;
    }

}
