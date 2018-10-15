package com.usc.controller.json;

import com.usc.Response.SingleResponse;
import com.usc.dao.objects.SeatsNode;
import com.usc.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@RestController
@RequestMapping("/json/seat")
public class SeatReservationJson {
    @Autowired
    private AirlineService airlineService;
    @PostMapping(value = "/reserve")
    public SingleResponse addNewNode(@RequestBody SeatsNode seatsNode) {
        seatsNode.setCreator("admin");
        seatsNode.setModifier("admin");

        SingleResponse response = airlineService.insertSeatNode(seatsNode);
        return response;
    }
}
