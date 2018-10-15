package com.usc.service.impl;

import com.usc.Response.ListResponse;
import com.usc.Response.SingleResponse;
import com.usc.dao.AirlinesMapper;
import com.usc.dao.SeatsMapper;
import com.usc.dao.info.FlightInfo;
import com.usc.dao.objects.AirlinesNode;
import com.usc.dao.objects.SeatsNode;
import com.usc.service.AirlineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlinesMapper airlinesMapper;

    @Autowired
    private SeatsMapper seatsMapper;


    @Override
    public SingleResponse insertSeatNode(SeatsNode node) {
        if(node.getAirlineNum() == null || StringUtils.isBlank(node.getAirlineNum()) ||
            node.getPlaneModel() == null || StringUtils.isBlank(node.getPlaneModel()) ||
            node.getGuestFirstName() == null || StringUtils.isBlank(node.getGuestFirstName()) ||
            node.getGuestLastName() == null || StringUtils.isBlank(node.getGuestLastName())||
            node.getGuestAge() == null || node.getGuestAge().intValue() <0 ||
            node.getSeatNum() == null || StringUtils.isBlank(node.getSeatNum())||
            node.getPrice() == null || node.getPrice().intValue() <0 ||
            node.getSeatType() == null || node.getSeatType().intValue() <0 ||
            node.getCreator() == null || StringUtils.isBlank(node.getCreator()) ||
            node.getModifier() == null || StringUtils.isBlank(node.getModifier())) {

            return new SingleResponse(-1, "Invalid Seat Information!");
        }

        if(seatsMapper.countBySeatNum(node.getAirlineNum(), node.getSeatNum()) > 0) {
            return new SingleResponse(-3, "Seat Occupied!");
        }
        seatsMapper.save(node);

        return new SingleResponse(101, "ok");
    }

    @Override
    public SingleResponse selectNodeByFlightNum(String airlineNum) {
        if(airlineNum == null || StringUtils.isBlank(airlineNum)) {
            return new SingleResponse(-1,"invalid information!");
        }
        AirlinesNode node = airlinesMapper.selectByAirlineNum(airlineNum);

        return new SingleResponse(101, node);
    }

    @Override
    public SingleResponse getOccupiedSeatString(String airlineNum) {
        if(airlineNum == null || StringUtils.isBlank(airlineNum)) {
            return new SingleResponse(-1,"invalid information!");
        }
        SeatsNode seat = new SeatsNode();
        seat.setAirlineNum(airlineNum);
        List<String> firstList = seatsMapper.selectSeatInfo(airlineNum, 1);
        List<String> ecoList = seatsMapper.selectSeatInfo(airlineNum, 0);

        StringBuilder sb = new StringBuilder();
        for(String s : firstList) {
            sb.append(s + ",");
        }
        for(String s : ecoList) {
            sb.append(s + ",");
        }
        if(sb.length() > 0) {
            sb.setLength(sb.length()-1);
        }


        return new SingleResponse(101, sb.toString());
    }

    @Override
    public ListResponse getAirlineforGuests() {
        List<FlightInfo> res = new ArrayList<>();
        List<AirlinesNode> ite = airlinesMapper.findAll();
        for(AirlinesNode node : ite) {
            FlightInfo info = new FlightInfo();
            info.setId(node.getId());
            info.setAirlineNum(node.getAirlineNum());
            info.setPlaneModel(node.getPlaneModel());
            info.setPriceFirstclass(node.getPriceFirstclass());
            info.setPriceEconomy(node.getPriceEconomy());
            info.setDeparturePort(node.getDeparturePort());
            info.setDepartureTime(node.getDepartureTime());
            info.setArrivalPort(node.getArrivalPort());
            info.setArrivalTime(node.getArrivalTime());

            Integer firstclassOccupied = seatsMapper.countByType(node.getAirlineNum(), 1);
            info.setFirstclassLeft(node.getNumFirstclass() - firstclassOccupied);
            Integer economyOccupied = seatsMapper.countByType(node.getAirlineNum(), 0);
            info.setEconomyLeft(node.getNumEconomy() - economyOccupied);

            res.add(info);
        }

        return new ListResponse(101, res);
    }

    @Override
    public SingleResponse updateAirline(AirlinesNode node) {
        if(node.getId() == null || node.getId().intValue() <=0 ||
                node.getAirlineNum() == null || StringUtils.isBlank(node.getAirlineNum()) ||
                node.getPlaneModel() == null || StringUtils.isBlank(node.getPlaneModel()) ||
                node.getNumFirstclass() == null || node.getNumFirstclass().intValue()<0 ||
                node.getNumEconomy() == null || node.getNumEconomy().intValue()<0 ||
                node.getPriceFirstclass() == null || node.getPriceFirstclass().intValue() <0 ||
                node.getPriceEconomy() == null || node.getPriceEconomy().intValue() <0 ||
                node.getDeparturePort() == null || StringUtils.isBlank(node.getDeparturePort()) ||
                node.getDepartureTime() == null || StringUtils.isBlank(node.getDepartureTime()) ||
                node.getArrivalPort() == null || StringUtils.isBlank(node.getArrivalPort()) ||
                node.getArrivalTime() == null || StringUtils.isBlank(node.getArrivalTime())) {
            return new SingleResponse(-1,"invalid information!");
        }

        Integer result = airlinesMapper.customerUpdate(node.getId(),node.getAirlineNum(),node.getPlaneModel(),node.getNumFirstclass(),
                node.getNumEconomy(),node.getPriceFirstclass(),node.getPriceEconomy(),node.getDeparturePort(),node.getDepartureTime(),
                node.getArrivalPort(),node.getArrivalTime());

        if(result == 0) {
           return new SingleResponse(-2,"database error!");
        }

        return new SingleResponse(101,"ok");
    }

    @Override
    public SingleResponse deleteAirline(AirlinesNode airlinesNode) {
        if(airlinesNode.getId() == null || airlinesNode.getId().intValue() <=0) {
            return new SingleResponse(-1,"invalid information!");
        }
        try{
            airlinesMapper.delete(airlinesNode.getId());
        } catch (Exception e) {
            return new SingleResponse(-2,"database error!");
        }

        return new SingleResponse(101, "ok");
    }

    @Override
    public SingleResponse insertAirline(AirlinesNode node) {
        if(node.getAirlineNum() == null || StringUtils.isBlank(node.getAirlineNum()) ||
                node.getPlaneModel() == null || StringUtils.isBlank(node.getPlaneModel()) ||
                node.getNumFirstclass() == null || node.getNumFirstclass().intValue()<0 ||
                node.getNumEconomy() == null || node.getNumEconomy().intValue()<0 ||
                node.getPriceFirstclass() == null || node.getPriceFirstclass().intValue() <0 ||
                node.getPriceEconomy() == null || node.getPriceEconomy().intValue() <0 ||
                node.getDeparturePort() == null || StringUtils.isBlank(node.getDeparturePort()) ||
                node.getDepartureTime() == null || StringUtils.isBlank(node.getDepartureTime()) ||
                node.getArrivalPort() == null || StringUtils.isBlank(node.getArrivalPort()) ||
                node.getArrivalTime() == null || StringUtils.isBlank(node.getArrivalTime())) {

                return new SingleResponse(-1,"invalid information!");
        }

        AirlinesNode result = airlinesMapper.save(node);

        return new SingleResponse(101, result);
    }

    @Override
    public List<AirlinesNode> selectAllNodes() {
        List<AirlinesNode> res = airlinesMapper.findAll();

        return res;
    }

    @Override
    public List<AirlinesNode> saveAirlines(List<AirlinesNode> airlinesNodes) {
        for(AirlinesNode node : airlinesNodes) {
            AirlinesNode suc = airlinesMapper.save(node);
        }

        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        AirlinesNode airlinesNode = new AirlinesNode();
        airlinesNode.setId(id);
        airlinesMapper.delete(airlinesNode);

        return null;
    }

    @Override
    public Page<AirlinesNode> findByAirlineNum(String airlineNum, Pageable pageable) {
        return null;
    }
}
