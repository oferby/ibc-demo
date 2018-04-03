package com.huawei.ibc.model.db.node;

import com.huawei.ibc.model.common.NodeType;
import com.huawei.ibc.model.controller.DatabaseControllerImpl;
import com.huawei.ibc.model.db.protocol.EthernetPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router extends AbstractDevice implements ForwardingDevice{

    private static final Logger logger = LoggerFactory.getLogger(Router.class);


    public Router(String id) {
        super(id, NodeType.ROUTER);
    }

    @Override
    public void rx(ForwardingPort inPort, EthernetPacket packet) {

        logger.debug("received packet: " + packet);

    }

}
