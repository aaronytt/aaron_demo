package com.ytt.aaron_demo.controller;

import com.ytt.aaron_demo.po.City;
import com.ytt.aaron_demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:01 2019/3/8
 * @Modiflid By:
 */
@Controller
@RequestMapping("/map")
public class CityController {

    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/getCity", method = RequestMethod.GET)
    public City getCity(City city){
        city.setId(1);
        City rc = cityService.getCity(city);
        return rc;
    }

}
