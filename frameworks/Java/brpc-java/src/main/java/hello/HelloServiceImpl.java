package hello;

public class HelloServiceImpl implements HelloService {
  @Override
  public String plaintext() {
    return "Hello World";
  }

  @Override
  public Message json() {
    return new Message("Hello, World!");
  }
}
