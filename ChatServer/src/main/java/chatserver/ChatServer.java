package chatserver;

import co.paralleluniverse.actors.ActorRef;

import chatserver.rest.ChatServerApplication;
import chatserver.quasar.Acceptor;
import chatserver.quasar.NotificationManager;
import chatserver.quasar.Room;
import chatserver.quasar.RoomManager;

public class ChatServer {

   public static void main(String[] args) throws Exception {
      int chatPort = 1111; //Integer.parseInt(args[0]);
      int notificationPort = 2222;
      ActorRef notificationManager = new NotificationManager(notificationPort).spawnThread(); // starts notifications
      ActorRef roomManager = new RoomManager(notificationManager).spawn();
      new ChatServerApplication(roomManager).run(args); // starts rest
      ActorRef mainRoom = new Room("Main", notificationManager).spawn();
      Acceptor acceptor = new Acceptor(chatPort, mainRoom, roomManager);
      acceptor.spawn();
      acceptor.join();
      /*
       Admin ad= new Admin();
       ad.addRoomRequest("randomroom");
       ad.listRoomsRequest();
       */
   }
}
