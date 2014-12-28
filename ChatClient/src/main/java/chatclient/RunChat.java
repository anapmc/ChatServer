/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import common.representations.RoomRepresentation;
import common.representations.RoomsRepresentation;
import com.google.gson.Gson;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.ResponseHandler;

/**
 *
 * @author pc-user
 */
public class RunChat extends JFrame {

   private final int MAXLEN = 2048; // problem when receiving json with more than 2048 char
   private SocketChannel socket;
   private Inbox inbox;

   /**
    * Creates new form RunChat
    */
   public RunChat(SocketChannel socket) {
      initComponents();
      this.socket = socket;
      this.inbox = null;
      new LineReader().start();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPopupMenu1 = new javax.swing.JPopupMenu();
      jDialog1 = new javax.swing.JDialog();
      jScrollPane1 = new javax.swing.JScrollPane();
      chatTxt = new javax.swing.JTextArea();
      sendTxt = new javax.swing.JTextField();
      listRoomsBtn = new javax.swing.JButton();
      listUsersBtn = new javax.swing.JButton();
      listUsersRoomLbl = new javax.swing.JLabel();
      roomListUsersTxt = new javax.swing.JTextField();
      inboxBtn = new javax.swing.JButton();
      jScrollPane3 = new javax.swing.JScrollPane();
      list = new javax.swing.JList();

      javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
      jDialog1.getContentPane().setLayout(jDialog1Layout);
      jDialog1Layout.setHorizontalGroup(
         jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
      );
      jDialog1Layout.setVerticalGroup(
         jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setFocusable(false);
      setMinimumSize(new java.awt.Dimension(600, 410));
      setPreferredSize(new java.awt.Dimension(740, 450));

      chatTxt.setEditable(false);
      chatTxt.setColumns(20);
      chatTxt.setRows(5);
      jScrollPane1.setViewportView(chatTxt);

      sendTxt.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sendTxtActionPerformed(evt);
         }
      });

      listRoomsBtn.setText("List Rooms");
      listRoomsBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listRoomsBtnActionPerformed(evt);
         }
      });

      listUsersBtn.setText("List Users in Room");
      listUsersBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listUsersBtnActionPerformed(evt);
         }
      });

      listUsersRoomLbl.setText("Room:");

      roomListUsersTxt.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            roomListUsersTxtActionPerformed(evt);
         }
      });

      inboxBtn.setText("Inbox");
      inboxBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            inboxBtnActionPerformed(evt);
         }
      });

      list.setEnabled(false);
      jScrollPane3.setViewportView(list);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(sendTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
               .addComponent(jScrollPane1))
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(listRoomsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(inboxBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(listUsersBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(listUsersRoomLbl)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(roomListUsersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(6, 6, 6))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jScrollPane3)
                  .addGap(18, 18, 18)
                  .addComponent(listRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(51, 51, 51)
                  .addComponent(listUsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(listUsersRoomLbl)
                     .addComponent(roomListUsersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(52, 52, 52))
               .addComponent(jScrollPane1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(inboxBtn)
               .addComponent(sendTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void sendTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTxtActionPerformed
      try {
         say(sendTxt.getText() + "\n");
         sendTxt.setText("");
      } catch (IOException ex) {
         errorBox(ex.getMessage());
      }
   }//GEN-LAST:event_sendTxtActionPerformed

   private void listRoomsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRoomsBtnActionPerformed
      String responseBody = httpGet("rooms");

      if (responseBody != null) {
         RoomsRepresentation rr = new Gson().fromJson(responseBody, RoomsRepresentation.class);
         DefaultListModel dlm = new DefaultListModel();
         for (String room : rr.getRooms()) {
            dlm.addElement(room);
         }
         clearList();
         list.setModel(dlm);

         addRoomsDoubleClickAction();

      } else {
         errorBox("");
      }
   }//GEN-LAST:event_listRoomsBtnActionPerformed

   private void listUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listUsersBtnActionPerformed
      String roomName = roomListUsersTxt.getText();
      if (roomName != null && !"".equals(roomName)) {
         String responseBody = httpGet("room/" + roomName);
         if (responseBody != null) {
            RoomRepresentation rr = new Gson().fromJson(responseBody, RoomRepresentation.class);
            DefaultListModel dlm = new DefaultListModel();
            for (String user : rr.getUsers()) {
               dlm.addElement(user);
            }
            clearList();
            list.setModel(dlm);
         } else {
            errorBox(new StringBuilder("Room ").append(roomName).append(" does not exist!").toString());
         }
         roomListUsersTxt.setText("");
      }
   }//GEN-LAST:event_listUsersBtnActionPerformed

   private void roomListUsersTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomListUsersTxtActionPerformed
      listUsersBtnActionPerformed(evt);
   }//GEN-LAST:event_roomListUsersTxtActionPerformed

   private void inboxBtnActionPerformed(java.awt.event.ActionEvent evt) {
      this.inbox = new Inbox(socket);
      this.inbox.setVisible(true);
   }

   private String httpGet(String path) {
      String result = null;
      CloseableHttpClient httpclient = HttpClients.createDefault();

      try {
         try {
            HttpGet httpget = new HttpGet("http://localhost:8080/" + path);
            ResponseHandler<String> responseHandler = (final HttpResponse response) -> {
               int status = response.getStatusLine().getStatusCode();
               String responseBody = null;
               if (status == 200) {
                  HttpEntity entity = response.getEntity();
                  responseBody = entity != null ? EntityUtils.toString(entity) : null;
               }
               return responseBody;
            };

            result = httpclient.execute(httpget, responseHandler);

         } finally {
            httpclient.close();
         }
      } catch (IOException ex) {
         errorBox(ex.getMessage());
      }

      return result;
   }

   private void clearList() {
      list = new javax.swing.JList();
      jScrollPane3.setViewportView(list);
   }

   private void addRoomsDoubleClickAction() {
      list.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
               try {
                  say(new StringBuilder(":cr ").append(list.getSelectedValue()).append("\n").toString());
               } catch (IOException ex) {
                  errorBox(ex.getMessage());
               }
            }
         }
      });
   }

   private class LineReader extends Thread {

      private final ByteBuffer in = ByteBuffer.allocate(MAXLEN);
      private final ByteBuffer out = ByteBuffer.allocate(MAXLEN);

      @Override
      public void run() {
         boolean eof = false;
         byte b = 0;
         try {
            for (;;) {
               if (socket.read(in) <= 0) {
                  eof = true;
               }
               in.flip();
               while (in.hasRemaining()) {
                  b = in.get();
                  out.put(b);
                  if (b == '\n') {
                     break;
                  }
               }
               if (eof || b == '\n') { // send line
                  out.flip();
                  if (out.remaining() > 0) {
                     byte[] ba = new byte[out.remaining()];
                     out.get(ba);
                     out.clear();
                     String text = new String(ba);
                     if (text.startsWith(":iu:")) {
                        inbox.updateUsers(text.substring(4));
                     } else if (text.startsWith(":tk:")) {
                        inbox.updateTalk(text.substring(4));
                     } else {
                        chatTxt.append(new String(ba));
                     }
                  }
               }
               if (eof && !in.hasRemaining()) {
                  break;
               }
               in.compact();
            }
            errorBox("");
         } catch (IOException e) {
            errorBox(e.getMessage());
         }
      }
   }

   private static void errorBox(String infoMessage) {
      JOptionPane.showMessageDialog(null, infoMessage, "Something Went Wrong", JOptionPane.ERROR_MESSAGE);
   }

   private void say(byte[] whatToSay) throws IOException {
      socket.write(ByteBuffer.wrap(whatToSay));
   }

   private void say(String whatToSay) throws IOException {
      say(whatToSay.getBytes());
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextArea chatTxt;
   private javax.swing.JButton inboxBtn;
   private javax.swing.JDialog jDialog1;
   private javax.swing.JPopupMenu jPopupMenu1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JList list;
   private javax.swing.JButton listRoomsBtn;
   private javax.swing.JButton listUsersBtn;
   private javax.swing.JLabel listUsersRoomLbl;
   private javax.swing.JTextField roomListUsersTxt;
   private javax.swing.JTextField sendTxt;
   // End of variables declaration//GEN-END:variables
}
