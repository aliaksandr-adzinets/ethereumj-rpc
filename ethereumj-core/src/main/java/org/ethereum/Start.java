package org.ethereum;

import org.ethereum.cli.CLIInterface;
import org.ethereum.config.SystemProperties;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.rpc.JsonRpcListener;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Roman Mandeleil
 * @since 14.11.2014
 */
public class Start {

    public static void main(String args[]) throws Exception {
        CLIInterface.call(args);

        if (!SystemProperties.getDefault().blocksLoader().equals("")) {
            SystemProperties.getDefault().setSyncEnabled(false);
            SystemProperties.getDefault().setDiscoveryEnabled(false);
        }

        Ethereum ethereum = EthereumFactory.createEthereum();

        if (!SystemProperties.getDefault().blocksLoader().equals(""))
            ethereum.getBlockLoader().loadBlocks();

        // TODO adding rpc
        if (CONFIG.isRpcEnabled()) {
            new JsonRpcListener(ethereum).start();
        }
    }
}
