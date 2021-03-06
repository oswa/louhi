/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PDFPasswordIncorrectoWindow.java
 *
 * Created on 12/05/2009, 06:34:07 PM
 */

package interfaz;

/**
 *
 * @author vang
 */
public class PDFPasswordIncorrectoWindow extends javax.swing.JFrame {

    Interfaz laGuiPrincipal;

    /** Creates new form PDFPasswordIncorrectoWindow */
    public PDFPasswordIncorrectoWindow() {
        initComponents();
    }

     public PDFPasswordIncorrectoWindow(Interfaz interfaz) {
         initComponents();
         laGuiPrincipal = interfaz;
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelNewPassword = new javax.swing.JLabel();
        pfWritePassword = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setText("El password del archivo PDF es incorrecto");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabelNewPassword.setText("Nuevo Password");
        getContentPane().add(jLabelNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        pfWritePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfWritePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(pfWritePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 180, -1));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        changePasswordButton.setText("Cambiar");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changePasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed

        // TODO add your handling code here:
        String pwdString = String.copyValueOf(pfWritePassword.getPassword());

        this.setVisible(false);
        laGuiPrincipal.setPassword(pwdString);
}//GEN-LAST:event_changePasswordButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
}//GEN-LAST:event_cancelButtonActionPerformed

    private void pfWritePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfWritePasswordActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_pfWritePasswordActionPerformed

    /**
    * @param args the command line arguments
    */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDFPasswordIncorrectoWindow().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JLabel jLabelNewPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPasswordField pfWritePassword;
    // End of variables declaration//GEN-END:variables

}
