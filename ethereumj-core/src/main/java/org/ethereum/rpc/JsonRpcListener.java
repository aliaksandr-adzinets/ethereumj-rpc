package org.ethereum.rpc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.ethereum.config.SystemProperties;
import org.ethereum.facade.Ethereum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ruben on 3/11/2015.
 */
public class JsonRpcListener {

    private Logger logger = LoggerFactory.getLogger("jsonrpc");

    Ethereum eth;

    public JsonRpcListener(Ethereum eth)
    {
        this.eth = eth;
    }

    public void start() throws Exception {

        logger.info("Starting RPC Server on PORT [{}]", SystemProperties.getDefault().RpcPort());

        Server server = new Server(SystemProperties.getDefault().RpcPort());

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        JsonRpcServlet.eth = this.eth;
        handler.addServletWithMapping(JsonRpcServlet.class, "/*");

        server.start();
        server.join();
    }

}
