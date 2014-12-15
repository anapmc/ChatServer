package chatserver.db;

import co.paralleluniverse.actors.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDB {

   private ActorRef actorRef;
   private final String name;
   private final String pass;
   private boolean loggedIn;
   private final Set<MessageDB> inbox = new HashSet();

   public UserDB(String pass, String name) {
      this.name = name;
      this.pass = pass;
   }

   public void setActorRef(ActorRef actorRef) {
      this.actorRef = actorRef;
   }

   public ActorRef getActorRef() {
      return actorRef;
   }

   public String getPassword() {
      return pass;
   }

   public boolean isLoggedIn() {
      return loggedIn;
   }

   public void setLoggedIn(boolean loggedIn) {
      this.loggedIn = loggedIn;
   }

   public void addMessage(String fromUsername, String message) {
      inbox.add(new MessageDB(fromUsername, message));
   }

   public String showInbox() {
      StringBuilder sb = new StringBuilder();
      for (MessageDB m : inbox) {
         sb.append(m.toString());
      }

      return sb.toString();

      /*
       Iterator it = inbox.iterator();
       String res;
       res = "";
       while (it.hasNext()) {
       MessageDB m = (MessageDB) it.next();
       res = res + (m.getFromUsername() + " said '" + m.getMessage() + "'\n -------------------\n");
       it.remove(); // avoids a ConcurrentModificationException
       }
       return res;
       */
   }
}
