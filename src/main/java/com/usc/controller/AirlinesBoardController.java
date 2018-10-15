package com.usc.controller;

import com.usc.Response.ListResponse;
import com.usc.Response.SingleResponse;
import com.usc.dao.info.FlightInfo;
import com.usc.dao.objects.AirlinesNode;
import com.usc.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@Controller
public class AirlinesBoardController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public String airlinesBoard(Model model) {

        List<FlightInfo> res = null;
        ListResponse resp = airlineService.getAirlineforGuests();
        if(resp.getStatus() == 101) {
            res = resp.getList();
        }
        model.addAttribute("flightList", res);
        return "airlines";
    }

    @GetMapping("/seat")
    public String seatSelection(@RequestParam(name="airlineNum", required=true) String airlineNum, Model model) {
        model.addAttribute("airlineNum", airlineNum);
        SingleResponse res = airlineService.getOccupiedSeatString(airlineNum);
        model.addAttribute("occupied", res.getData());

        res = airlineService.selectNodeByFlightNum(airlineNum);
        if(res.getStatus() == 101) {
            AirlinesNode priceNode = (AirlinesNode) res.getData();
            model.addAttribute("priceFirst", priceNode.getPriceFirstclass());
            model.addAttribute("priceEco", priceNode.getPriceEconomy());
            model.addAttribute("planeModel", priceNode.getPlaneModel());
        }

        return "seatSelection";
    }

}
