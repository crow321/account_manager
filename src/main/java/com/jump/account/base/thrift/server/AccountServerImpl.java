package com.jump.account.base.thrift.server;

import com.jump.account.base.thrift.AccountService;
import com.jump.account.base.thrift.impl.TAccountServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhangp on 2017/7/5.
 */
@Component("accountServer")
public class AccountServerImpl implements IAccountServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServerImpl.class);

    @Value("${serverTransport}")
    private int server_transport;

    @Override
    public void run() {
        try {
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(server_transport, 10000);
            TProcessor processor = new AccountService.Processor<AccountService.Iface>(new TAccountServiceImpl());

            Args args = new Args(serverTransport);
            args.processorFactory(new TProcessorFactory(processor));
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.transportFactory(new TFramedTransport.Factory());

            TServer server = new TNonblockingServer(args);

            LOGGER.info("AServer start on port {}...", server_transport);
            LOGGER.info("使用非阻塞、单线程、二进制编码通信...");

            server.serve();
        } catch (TTransportException e) {
            LOGGER.error("TServerTransport error,{}", e);
        }
    }
}
