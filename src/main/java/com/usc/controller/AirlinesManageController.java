package com.usc.controller;

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
public class AirlinesManageController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlinesManage")
    public String airlinesManage(@RequestParam(name="name", required=false, defaultValue="admin") String name, Model model) {
        model.addAttribute("name", name);
        List<AirlinesNode> airlineList = airlineService.selectAllNodes();
        model.addAttribute("airlineList", airlineList);

        return "airlinesManage";
    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }
}
