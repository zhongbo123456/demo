package com.example.demo.test;



import java.util.List;

public class MultiTypeDevices {
    private List<MultiTypeDevices.CityListBean> cityList;
    private List<MultiTypeDevices.TradeListBean> tradeList;
    private List<MultiTypeDevices.UseCodeBean> useCodeList;
    private List<ApplicationBean> applicationList;


    public List<ApplicationBean> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<ApplicationBean> applicationList) {
        this.applicationList = applicationList;
    }

    public MultiTypeDevices() {
    }

    public List<MultiTypeDevices.CityListBean> getCityList() {
        return this.cityList;
    }

    public void setCityList(List<MultiTypeDevices.CityListBean> cityList) {
        this.cityList = cityList;
    }

    public List<MultiTypeDevices.TradeListBean> getTradeList() {
        return this.tradeList;
    }

    public void setTradeList(List<MultiTypeDevices.TradeListBean> tradeList) {
        this.tradeList = tradeList;
    }

    public List<MultiTypeDevices.UseCodeBean> getUseCodeList() {
        return this.useCodeList;
    }

    public void setUseCodeList(List<MultiTypeDevices.UseCodeBean> useCodeList) {
        this.useCodeList = useCodeList;
    }

    public static class TradeListBean extends DeviceName{
        private int trade;

        public TradeListBean() {
        }

        public int getTrade() {
            return this.trade;
        }

        public void setTrade(int trade) {
            this.trade = trade;
        }

    }

    public static class UseCodeBean extends DeviceName{
        private Integer useCode;
        private String description;

        public UseCodeBean() {
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getUseCode() {
            return this.useCode;
        }

        public void setUseCode(Integer useCode) {
            this.useCode = useCode;
        }


    }

    public static class CityListBean extends DeviceName{
        private String location;

        public CityListBean() {
        }

        public String getLocation() {
            return this.location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }
    public static class ApplicationBean extends DeviceName{
        private Integer applicationId;
        private String applicationName;

        public ApplicationBean(){

        }


        public Integer getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(Integer applicationId) {
            this.applicationId = applicationId;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }
    }
}

