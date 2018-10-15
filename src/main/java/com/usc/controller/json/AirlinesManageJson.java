package com.usc.controller.json;

import com.usc.Response.SingleResponse;
import com.usc.dao.objects.AirlinesNode;
import com.usc.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
@RestController
@RequestMapping("/json/airManage")
public class AirlinesManageJson {
    @Autowired
    private AirlineService airlineService;

    @PostMapping(value = "/addNewOne")
    public SingleResponse addNewNode(@RequestBody AirlinesNode airlinesNode) {
        airlinesNode.setCreator("admin");
        airlinesNode.setModifier("admin");

        SingleResponse response = airlineService.insertAirline(airlinesNode);

        return response;
    }

    @DeleteMapping(value = "/delete")
    public SingleResponse deleteNode(@RequestBody AirlinesNode airlinesNode) {
        airlinesNode.setCreator("admin");
        airlinesNode.setModifier("admin");

        SingleResponse response = airlineService.deleteAirline(airlinesNode);

        return response;
    }

    @PostMapping(value = "editThisOne")
    public SingleResponse editNode(@RequestBody AirlinesNode airlinesNode) {
        airlinesNode.setCreator("admin");
        airlinesNode.setModifier("admin");

        SingleResponse response = airlineService.updateAirline(airlinesNode);

        return response;
    }
}
