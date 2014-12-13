package chatserver.quasar;


import java.io.IOException;
import java.net.InetSocketAddress;
import co.paralleluniverse.actors.*;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.io.*;

import chatserver.util.Msg;
import chatserver.util.MsgType;


public class Acceptor extends BasicActor {
  final int port;
  private final ActorRef roomManager;

  public Acceptor(int port, ActorRef roomManager) { 
    this.port = port; 
    this.roomManager = roomManager;
  }

  @Override
  protected Void doRun() throws InterruptedException, SuspendExecution {
    ActorRef mainRoom = new Room("Main").spawn();
    ActorRef loginManager = new LoginManager().spawn();
    
    byte[] welcomeMessage = "------ Welcome to an awesome chat service! ------\n #Please login to chat. Type :h for help.\n".getBytes();
    
    // the mainRoom shall be returned when someone asks for the list of rooms?
    try {
      FiberServerSocketChannel ss = FiberServerSocketChannel.open();
      ss.bind(new InetSocketAddress(port));
      while (true) {
        FiberSocketChannel socket = ss.accept();
        ActorRef user = new User(mainRoom, roomManager, loginManager, socket).spawn();
        user.send(new Msg(MsgType.LINE, null, welcomeMessage));
      }
    } catch (IOException e) { System.out.println(e.getMessage()); }
    return null;
  }
}