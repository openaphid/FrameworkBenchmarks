package hello;

import com.baidu.brpc.server.RpcServer;
import com.baidu.brpc.server.RpcServerOptions;

public class App {
  public static void main(String[] args) {
    final int port = 8081;

    RpcServerOptions options = new RpcServerOptions();
    RpcServer rpcServer = new RpcServer(port, options);
    // rpcServer.registerService(new EchoServiceImpl());
    rpcServer.registerService(new HelloServiceImpl(), options);
    rpcServer.start();

    // make server keep running
    synchronized (App.class) {
      try {
        App.class.wait();
      } catch (Throwable e) {
        // ignore
      }
    }
  }
}
