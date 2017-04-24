package com.abin.lee.circular.service.impl;

import com.abin.lee.circular.service.ForwardService;
import com.abin.lee.circular.service.RegularService;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by abin on 2017/4/24 13:16.
 * circular-reference
 * com.abin.lee.circular.service.impl
 */
@Service
public class ForwardServiceImpl implements ForwardService {

//    @Autowired
//    @Lazy(true)
    @Resource
    RegularService regularService;

    @Override
    public void callForward(String id) {
        System.out.println("ForwardService--id="+id);
        Integer ids = Ints.tryParse(id);
        ids+=1;
        System.out.println("RegularService--ids="+ids);
        this.regularService.callRegular(UnsignedInts.toString(ids));
    }


}
