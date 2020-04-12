package hello;

import com.linecorp.armeria.common.SessionProtocol;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;

import com.linecorp.armeria.server.ServerPort;
import hello.services.HelloService;
import hello.services.PostgresDbService;
import hello.services.PostgresFortunesService;
import io.netty.channel.ChannelOption;

public final class App {
  public static void main(String[] args) {
    ServerBuilder sb = Server.builder();

    sb
      .http(8080)
//      .https(8443)
//      .tlsSelfSigned()
      // .disableDateHeader()
      // .disableServerHeader()
      .childChannelOption(ChannelOption.SO_KEEPALIVE, true)
	    .channelOption(ChannelOption.SO_BACKLOG, 8192)
	    .channelOption(ChannelOption.SO_REUSEADDR, true)
      .annotatedService(new HelloService());
//      .annotatedService(new PostgresDbService())
//      .annotatedService(new PostgresFortunesService());

    Server server = sb.build();
    server.start().join();
  }
}
