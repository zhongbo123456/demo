package com.example.demo.test;


public class DeviceOnlineNum  {
    /**
     * 总数
     */
    private Integer total;
    /**
     * 用途分类,1是水表，2是电表，3是压力表，4是燃气表
     */
    private Integer useCode;
    /**
     * 在线数量
     */
    private Integer onlineNum;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUseCode() {
        return useCode;
    }

    public void setUseCode(Integer useCode) {
        this.useCode = useCode;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    @Override
    public String toString() {
        return "DeviceOnlineNum{" +
                "total=" + total +
                ", useCode=" + useCode +
                ", onlineNum=" + onlineNum +
                '}';
    }
}
