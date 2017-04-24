package com.abin.lee.circular.service.impl;

import com.abin.lee.circular.service.RegularService;
import com.abin.lee.circular.service.SlapService;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by abin on 2017/4/24 13:16.
 * circular-reference
 * com.abin.lee.circular.service.impl
 */
@Service
public class RegularServiceImpl implements RegularService {

    //    @Autowired
//    @Lazy(true)
    @Resource
    SlapService slapService;

    @Override
    public void callRegular(String id) {
        System.out.println("RegularService--id="+id);
        if(!Strings.isNullOrEmpty(id)){
            Integer ids = Ints.tryParse(id);
            ids+=1;
            System.out.println("RegularService--ids="+ids);
            if(ids<5){
                this.slapService.callSlap(UnsignedInts.toString(ids));
            }
        }

    }




}
