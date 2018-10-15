package com.usc.dao.info;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public class FlightInfo {
    private Long id;

    private String airlineNum;

    private String planeModel;

    private Integer firstclassLeft;

    private Integer economyLeft;

    private Integer priceFirstclass;

    private Integer priceEconomy;

    private String departurePort;

    private String departureTime;

    private String arrivalPort;

    private String arrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineNum() {
        return airlineNum;
    }

    public void setAirlineNum(String airlineNum) {
        this.airlineNum = airlineNum;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public Integer getFirstclassLeft() {
        return firstclassLeft;
    }

    public void setFirstclassLeft(Integer firstclassLeft) {
        this.firstclassLeft = firstclassLeft;
    }

    public Integer getEconomyLeft() {
        return economyLeft;
    }

    public void setEconomyLeft(Integer economyLeft) {
        this.economyLeft = economyLeft;
    }

    public Integer getPriceFirstclass() {
        return priceFirstclass;
    }

    public void setPriceFirstclass(Integer priceFirstclass) {
        this.priceFirstclass = priceFirstclass;
    }

    public Integer getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(Integer priceEconomy) {
        this.priceEconomy = priceEconomy;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "id=" + id +
                ", airlineNum='" + airlineNum + '\'' +
                ", planeModel='" + planeModel + '\'' +
                ", firstclassLeft=" + firstclassLeft +
                ", economyLeft=" + economyLeft +
                ", priceFirstclass=" + priceFirstclass +
                ", priceEconomy=" + priceEconomy +
                ", departurePort='" + departurePort + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalPort='" + arrivalPort + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
