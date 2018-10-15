package com.usc.dao.objects;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@Entity(name = "airlines_node")
public class AirlinesNode {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Column(name = "gmt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreated;

    @CreationTimestamp
    @Column(name = "gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @Column(name = "plane_model")
    private String planeModel;

    @Column(name = "num_firstclass")
    private Integer numFirstclass;

    @Column(name = "num_economy")
    private Integer numEconomy;

    @Column(name = "price_firstclass")
    private Integer priceFirstclass;

    @Column(name = "price_economy")
    private Integer priceEconomy;

    @Column(name = "departure_port")
    private String departurePort;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_port")
    private String arrivalPort;

    @Column(name = "arrival_time")
    private String arrivalTime;

    private String creator;

    private String modifier;

    @Column(name = "airline_num")
    private String airlineNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public Integer getNumFirstclass() {
        return numFirstclass;
    }

    public void setNumFirstclass(Integer numFirstclass) {
        this.numFirstclass = numFirstclass;
    }

    public Integer getNumEconomy() {
        return numEconomy;
    }

    public void setNumEconomy(Integer numEconomy) {
        this.numEconomy = numEconomy;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getAirlineNum() {
        return airlineNum;
    }

    public void setAirlineNum(String airlineNum) {
        this.airlineNum = airlineNum;
    }

    @Override
    public String toString() {
        return "AirlinesNode{" +
                "id=" + id +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", planeModel='" + planeModel + '\'' +
                ", numFirstclass=" + numFirstclass +
                ", numEconomy=" + numEconomy +
                ", priceFirstclass=" + priceFirstclass +
                ", priceEconomy=" + priceEconomy +
                ", departurePort='" + departurePort + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalPort='" + arrivalPort + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", airlineNum='" + airlineNum + '\'' +
                '}';
    }
}
