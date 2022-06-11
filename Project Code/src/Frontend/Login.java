/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;


import dbConnection.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Login extends javax.swing.JFrame {

    DBConnection db=new DBConnection();
    int wrong_number=0;
    String remember_email="";
    String remember_password="";
    
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        generalpanel = new keeptoo.KGradientPanel();
        signinpanel = new javax.swing.JPanel();
        signinlabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        i_username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passwordlabel = new javax.swing.JLabel();
        i_password = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        f_password = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        signbutton = new javax.swing.JButton();
        signuplabel = new javax.swing.JLabel();
        errormessage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        iconlabel = new javax.swing.JLabel();
        projectnamelabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

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

        jTextField1.setText("jTextField1");

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 200, 0, 0));
        setUndecorated(true);

        generalpanel.setkEndColor(new java.awt.Color(0, 0, 204));
        generalpanel.setkGradientFocus(1200);
        generalpanel.setkStartColor(new java.awt.Color(153, 0, 153));

        signinpanel.setBackground(new java.awt.Color(255, 255, 255));

        signinlabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signinlabel.setForeground(new java.awt.Color(51, 153, 255));
        signinlabel.setText("Sign In");

        usernamelabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernamelabel.setForeground(new java.awt.Color(51, 153, 255));
        usernamelabel.setText("Email");

        i_username.setBackground(new java.awt.Color(255, 255, 255));
        i_username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        i_username.setForeground(new java.awt.Color(51, 153, 255));
        i_username.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));

        passwordlabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordlabel.setForeground(new java.awt.Color(51, 153, 255));
        passwordlabel.setText("Password");

        i_password.setBackground(new java.awt.Color(255, 255, 255));
        i_password.setForeground(new java.awt.Color(51, 153, 255));
        i_password.setBorder(null);

        jSeparator2.setForeground(new java.awt.Color(0, 153, 204));

        f_password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        f_password.setForeground(new java.awt.Color(51, 153, 255));
        f_password.setText("Forgot your password?");
        f_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_passwordMouseClicked(evt);
            }
        });

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 51));
        kGradientPanel2.setkGradientFocus(800);
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 0, 153));

        signbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signbutton.setForeground(new java.awt.Color(51, 153, 255));
        signbutton.setText("Sign In");
        signbutton.setBorder(null);
        signbutton.setBorderPainted(false);
        signbutton.setContentAreaFilled(false);
        signbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        signuplabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signuplabel.setForeground(new java.awt.Color(51, 153, 255));
        signuplabel.setText("Don't have an account yet? Sign Up!");
        signuplabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signuplabelMouseClicked(evt);
            }
        });

        errormessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errormessage.setForeground(new java.awt.Color(51, 153, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N

        javax.swing.GroupLayout signinpanelLayout = new javax.swing.GroupLayout(signinpanel);
        signinpanel.setLayout(signinpanelLayout);
        signinpanelLayout.setHorizontalGroup(
            signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(signinpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_username)
                    .addComponent(i_password)
                    .addGroup(signinpanelLayout.createSequentialGroup()
                        .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errormessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(signinpanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(signinpanelLayout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(signinlabel))
                                    .addGroup(signinpanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usernamelabel)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(signinpanelLayout.createSequentialGroup()
                .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signinpanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signuplabel)
                            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(signinpanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordlabel))
                    .addGroup(signinpanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(f_password)))
                .addGap(0, 69, Short.MAX_VALUE))
        );
        signinpanelLayout.setVerticalGroup(
            signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinpanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(signinlabel)
                .addGap(24, 24, 24)
                .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernamelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(i_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signinpanelLayout.createSequentialGroup()
                        .addComponent(passwordlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(i_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_password)
                .addGap(33, 33, 33)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signuplabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(errormessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        iconlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bachelor.png"))); // NOI18N

        projectnamelabel.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        projectnamelabel.setForeground(new java.awt.Color(204, 204, 255));
        projectnamelabel.setText("QBox");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 255));
        jButton1.setText("X");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout generalpanelLayout = new javax.swing.GroupLayout(generalpanel);
        generalpanel.setLayout(generalpanelLayout);
        generalpanelLayout.setHorizontalGroup(
            generalpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalpanelLayout.createSequentialGroup()
                .addGroup(generalpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalpanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(iconlabel))
                    .addGroup(generalpanelLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(projectnamelabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(generalpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalpanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalpanelLayout.createSequentialGroup()
                        .addComponent(signinpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        generalpanelLayout.setVerticalGroup(
            generalpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalpanelLayout.createSequentialGroup()
                .addGroup(generalpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(generalpanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(signinpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(generalpanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(projectnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconlabel)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(generalpanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signbuttonActionPerformed
       
        String email=i_username.getText();
        String password=new String(i_password.getPassword());
        
        String query="Select * from User where email = ? and password = ?";
        
        
        try {
            db.psqlquery=db.con.prepareStatement(query);
            db.psqlquery.setString(1, email);
            db.psqlquery.setString(2,password);
            
            ResultSet res=db.psqlquery.executeQuery();
            
            
            
            
            
            if(res.next()){
                
                errormessage.setText("Login succesfuly.");
                
                
            }
            
            else{
                if(wrong_number==3){
                    errormessage.setText("Wrong! You can try to reset your password!");
                }
                else{
                errormessage.setText("Wrong email or password!");
                wrong_number++;
                }
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signbuttonActionPerformed

    private void signuplabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signuplabelMouseClicked
        
        Register register=new Register();
        
        register.setVisible(true);
        
        errormessage.setText("Registration is succesfuly!");
        
    }//GEN-LAST:event_signuplabelMouseClicked

    private void f_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_passwordMouseClicked
       
       ChangePassword cp=new ChangePassword();
        
        cp.setVisible(true);
        
        errormessage.setText("Password is changed.");
        
    }//GEN-LAST:event_f_passwordMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errormessage;
    private javax.swing.JLabel f_password;
    private keeptoo.KGradientPanel generalpanel;
    private javax.swing.JPasswordField i_password;
    private javax.swing.JTextField i_username;
    private javax.swing.JLabel iconlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JLabel projectnamelabel;
    private javax.swing.JButton signbutton;
    private javax.swing.JLabel signinlabel;
    private javax.swing.JPanel signinpanel;
    private javax.swing.JLabel signuplabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}