package chatclient;

import com.google.gson.Gson;
import common.representation.UserRepresentation;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.ResponseHandler;
import java.util.Base64;
import org.apache.http.client.methods.HttpDelete;
import javax.ws.rs.core.Response.Status;

public class AdminSettings extends javax.swing.JFrame {

   private final String authEncoded;
   private final String URL = "http://localhost:8080/";

   /**
    * Creates new form AdminSettings
    */
   public AdminSettings(UserRepresentation userCredentials) {
      initComponents();
      this.authEncoded = Base64.getEncoder().encodeToString(new Gson().toJson(userCredentials).getBytes());
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            dispose();
         }
      });
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
      jPanel1 = new javax.swing.JPanel();
      addRoomLbl = new javax.swing.JLabel();
      addRoomNameTxt = new javax.swing.JTextField();
      jPanel2 = new javax.swing.JPanel();
      deleteRoomBtn = new javax.swing.JButton();
      deleteRoomLbl = new javax.swing.JLabel();
      deleteRoomNameTxt = new javax.swing.JTextField();
      addRoomBtn = new javax.swing.JButton();
      makeAdminBtn = new javax.swing.JButton();
      makeAdminTxt = new javax.swing.JTextField();
      makeAdminLbl = new javax.swing.JLabel();
      jPanel3 = new javax.swing.JPanel();
      removeAdminBtn = new javax.swing.JButton();
      removeAdminLbl = new javax.swing.JLabel();
      removeAdminTxt = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBackground(new java.awt.Color(255, 255, 255));
      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin Options"));

      addRoomLbl.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
      addRoomLbl.setText("Add Room");

      jPanel2.setBackground(new java.awt.Color(0, 0, 0));
      jPanel2.setForeground(new java.awt.Color(255, 255, 255));

      deleteRoomBtn.setText("Delete");
      deleteRoomBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteRoomBtnActionPerformed(evt);
         }
      });

      deleteRoomLbl.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
      deleteRoomLbl.setForeground(new java.awt.Color(255, 255, 255));
      deleteRoomLbl.setText("Delete Room");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(deleteRoomLbl)
            .addGap(40, 40, 40)
            .addComponent(deleteRoomNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
            .addComponent(deleteRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(29, 29, 29)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(deleteRoomNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(deleteRoomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(deleteRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(23, Short.MAX_VALUE))
      );

      addRoomBtn.setText("Add");
      addRoomBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addRoomBtnActionPerformed(evt);
         }
      });

      makeAdminBtn.setText("Make");
      makeAdminBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            makeAdminBtnActionPerformed(evt);
         }
      });

      makeAdminLbl.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
      makeAdminLbl.setText("Make Admin");

      jPanel3.setBackground(new java.awt.Color(0, 0, 0));
      jPanel3.setForeground(new java.awt.Color(255, 255, 255));

      removeAdminBtn.setText("Remove");
      removeAdminBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeAdminBtnActionPerformed(evt);
         }
      });

      removeAdminLbl.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
      removeAdminLbl.setForeground(new java.awt.Color(255, 255, 255));
      removeAdminLbl.setText("Remove Admin");

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(removeAdminLbl)
            .addGap(29, 29, 29)
            .addComponent(removeAdminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(29, 29, 29)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(removeAdminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(removeAdminLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(removeAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(23, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(addRoomLbl)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(addRoomNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(53, 53, 53)
                  .addComponent(addRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(makeAdminLbl)
                  .addGap(48, 48, 48)
                  .addComponent(makeAdminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(makeAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(35, 35, 35))
         .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(addRoomNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(addRoomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(addRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(makeAdminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(makeAdminLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(makeAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void addRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomBtnActionPerformed
       String roomName = addRoomNameTxt.getText();
       if (roomName.matches("^[^\\d\\s]+$")) {
          addRoomRequest(roomName);
       } else {
          errorBox("No spaces or numbers allowed");
       }
    }//GEN-LAST:event_addRoomBtnActionPerformed

    private void deleteRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomBtnActionPerformed
       String roomName = deleteRoomNameTxt.getText();
       if (roomName.matches("^[^\\d\\s]+$")) {
          deleteRoomRequest(roomName);
       } else {
          errorBox("No spaces or numbers allowed");
       }
    }//GEN-LAST:event_deleteRoomBtnActionPerformed

   private void makeAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAdminBtnActionPerformed
      String adminUsername = makeAdminTxt.getText();
      if (!adminUsername.isEmpty()) {
         makeAdminRequest(adminUsername);
      } else {
         errorBox("Insert the admin's username");
      }
   }//GEN-LAST:event_makeAdminBtnActionPerformed

   private void removeAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdminBtnActionPerformed
      String adminUsername = removeAdminTxt.getText();
      if (!adminUsername.isEmpty()) {
         removeAdminRequest(adminUsername);
      } else {
         errorBox("Insert the admin's username");
      }
   }//GEN-LAST:event_removeAdminBtnActionPerformed

   public void addRoomRequest(String roomName) {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
         try {
            HttpPut httpPut = new HttpPut(URL + "room/" + roomName);
            httpPut.addHeader("Volatile-ChatServer-Auth", authEncoded);

            ResponseHandler responseHandler = (final HttpResponse response) -> {
               int status = response.getStatusLine().getStatusCode();
               if (status == Status.CREATED.getStatusCode()) {
                  infoBox("Room successfully created.");
                  addRoomNameTxt.setText("");
               } else if (status == Status.UNAUTHORIZED.getStatusCode()) { // which won't happen
                  infoBox("Somehow you're not an administrator");
               } else if (status == Status.CONFLICT.getStatusCode()) {
                  infoBox("Room name is already in use.");
               } else {
                  errorBox("Unexpected response status: " + status);
               }

               return status;
            };

            httpclient.execute(httpPut, responseHandler);
         } finally {
            httpclient.close();
         }
      } catch (IOException e) {
         errorBox(e.getMessage());
      }

   }

   public void deleteRoomRequest(String roomName) {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
         try {
            HttpDelete httpDelete = new HttpDelete(URL + "room/" + roomName);
            httpDelete.addHeader("Volatile-ChatServer-Auth", authEncoded);

            ResponseHandler responseHandler = (final HttpResponse response) -> {
               int status = response.getStatusLine().getStatusCode();
               if (status == Status.OK.getStatusCode()) {
                  infoBox("Room successfully deleted.");
                  deleteRoomNameTxt.setText("");
               } else if (status == Status.UNAUTHORIZED.getStatusCode()) { // which won't happen
                  infoBox("Somehow you're not an administrator");
               } else if (status == Status.NOT_FOUND.getStatusCode()) {
                  infoBox("That room does not exist");
               } else if (status == Status.PRECONDITION_FAILED.getStatusCode()) {
                  infoBox("That room still has users");
               } else {
                  errorBox("Unexpected response status: " + status);
               }

               return status;
            };

            httpclient.execute(httpDelete, responseHandler);
         } finally {
            httpclient.close();
         }
      } catch (IOException e) {
         errorBox(e.getMessage());
      }
   }

   public void makeAdminRequest(String adminUsername) {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
         try {
            HttpPut httpPut = new HttpPut(URL + "admin/" + adminUsername);
            httpPut.addHeader("Volatile-ChatServer-Auth", authEncoded);

            ResponseHandler responseHandler = (final HttpResponse response) -> {
               int status = response.getStatusLine().getStatusCode();
               if (status == Status.CREATED.getStatusCode()) {
                  infoBox("Admin successfully created.");
                  makeAdminTxt.setText("");
               } else if (status == Status.UNAUTHORIZED.getStatusCode()) { // which won't happen
                  infoBox("Somehow you're not an administrator");
               } else if (status == Status.NOT_FOUND.getStatusCode()) {
                  infoBox("Username not found.");
               } else {
                  errorBox("Unexpected response status: " + status);
               }

               return status;
            };

            httpclient.execute(httpPut, responseHandler);
         } finally {
            httpclient.close();
         }
      } catch (IOException e) {
         errorBox(e.getMessage());
      }

   }

   public void removeAdminRequest(String adminUsername) {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
         try {
            HttpDelete httpDelete = new HttpDelete(URL + "admin/" + adminUsername);
            httpDelete.addHeader("Volatile-ChatServer-Auth", authEncoded);

            ResponseHandler responseHandler = (final HttpResponse response) -> {
               int status = response.getStatusLine().getStatusCode();
               if (status == Status.OK.getStatusCode()) {
                  infoBox("Admin successfully removed.");
                  removeAdminTxt.setText("");
               } else if (status == Status.UNAUTHORIZED.getStatusCode()) { // which won't happen
                  infoBox("Somehow you're not an administrator");
               } else if (status == Status.NOT_FOUND.getStatusCode()) {
                  infoBox("Admin not found.");
               } else {
                  errorBox("Unexpected response status: " + status);
               }

               return status;
            };

            httpclient.execute(httpDelete, responseHandler);
         } finally {
            httpclient.close();
         }
      } catch (IOException e) {
         errorBox(e.getMessage());
      }
   }

   private static void errorBox(String errorMessage) {
      JOptionPane.showMessageDialog(null, errorMessage, "Something Went Wrong", JOptionPane.ERROR_MESSAGE);
   }

   private static void infoBox(String infoMessage) {
      JOptionPane.showMessageDialog(null, infoMessage, "Some info for you", JOptionPane.INFORMATION_MESSAGE);
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addRoomBtn;
   private javax.swing.JLabel addRoomLbl;
   private javax.swing.JTextField addRoomNameTxt;
   private javax.swing.JButton deleteRoomBtn;
   private javax.swing.JLabel deleteRoomLbl;
   private javax.swing.JTextField deleteRoomNameTxt;
   private javax.swing.Box.Filler filler1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JButton makeAdminBtn;
   private javax.swing.JLabel makeAdminLbl;
   private javax.swing.JTextField makeAdminTxt;
   private javax.swing.JButton removeAdminBtn;
   private javax.swing.JLabel removeAdminLbl;
   private javax.swing.JTextField removeAdminTxt;
   // End of variables declaration//GEN-END:variables
}
