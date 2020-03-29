package hello;

import com.baidu.brpc.protocol.BrpcMeta;

public interface HelloService {
  @BrpcMeta(serviceName = "HelloService", methodName = "plaintext")
  String plaintext();

  @BrpcMeta(serviceName = "HelloService", methodName = "json")
  Message json();
}
