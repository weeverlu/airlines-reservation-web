package com.usc.dao.objects;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@Entity(name = "seats_node")
public class SeatsNode {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created")
    private Date gmtCreated;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    private Date gmtModified;

    @Column(name = "airline_num")
    private String airlineNum;

    @Column(name = "plane_model")
    private String planeModel;

    @Column(name = "guest_first_name")
    private String guestFirstName;

    @Column(name = "guest_last_name")
    private String guestLastName;

    @Column(name = "guest_age")
    private Integer guestAge;

    @Column(name = "seat_num")
    private String seatNum;

    private Integer price;

    // 0 - eco, 1 - first class
    @Column(name = "seat_type")
    private Integer seatType;

    private String creator;

    private String modifier;

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

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public Integer getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(Integer guestAge) {
        this.guestAge = guestAge;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
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

    @Override
    public String toString() {
        return "SeatsNode{" +
                "id=" + id +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", airlineNum='" + airlineNum + '\'' +
                ", planeModel='" + planeModel + '\'' +
                ", guestFirstName='" + guestFirstName + '\'' +
                ", guestLastName='" + guestLastName + '\'' +
                ", guestAge=" + guestAge +
                ", seatNum='" + seatNum + '\'' +
                ", price=" + price +
                ", seatType=" + seatType +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
