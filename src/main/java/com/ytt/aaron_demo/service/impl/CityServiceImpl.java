package com.ytt.aaron_demo.service.impl;

import com.ytt.aaron_demo.mapper.CityMapper;
import com.ytt.aaron_demo.po.City;
import com.ytt.aaron_demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:07 2019/3/8
 * @Modiflid By:
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCity(City city) {
        if(!Optional.ofNullable(city).isPresent()){
            city = new City();
        }
        City rc = cityMapper.findById(city.getId());
        return rc;
    }
}
