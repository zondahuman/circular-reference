package com.abin.lee.circular.service.impl;

import com.abin.lee.circular.service.ForwardService;
import com.abin.lee.circular.service.SlapService;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by abin on 2017/4/24 13:15.
 * circular-reference
 * com.abin.lee.circular.service.impl
 */
@Service
public class SlapServiceImpl implements SlapService {

    //    @Autowired
//    @Lazy(true)
    @Resource
    ForwardService forwardService;




    @Override
    public void callSlap(String id) {
        System.out.println("SlapService--id="+id);
        Integer ids = Ints.tryParse(id);
        ids+=1;
        System.out.println("SlapService--ids="+ids);
        this.forwardService.callForward(UnsignedInts.toString(ids));

    }





}
