package com.huawei.ibc.service;

import com.huawei.ibc.model.db.protocol.MACAddress;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController {

    private int lastAddress = 100;

    public MACAddress getMacAddress(){

        return MACAddress.valueOf(lastAddress++);
    }


}
