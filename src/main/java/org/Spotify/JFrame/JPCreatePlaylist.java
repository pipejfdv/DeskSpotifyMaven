package org.Spotify.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import org.Spotify.Models.PlayList;
import org.Spotify.Models.User;
import org.Spotify.Services.PlaylistService;
import org.Spotify.Models.Session;

public class JPCreatePlaylist extends javax.swing.JFrame {
    private JLabel labelTitulo;
    private JLabel labelNombre;
    private JTextField txtNombrePlaylist;
    private JButton btnCrear;
    
    private PlaylistService playlistService = new PlaylistService();
    
    public JPCreatePlaylist() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        labelTitulo = new JLabel("Crear Playlist");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        labelTitulo.setBounds(110, 20, 200, 30);
        add(labelTitulo);

        labelNombre = new JLabel("Nombre de la Playlist:");
        labelNombre.setBounds(40, 80, 150, 25);
        add(labelNombre);

        txtNombrePlaylist = new JTextField();
        txtNombrePlaylist.setBounds(180, 80, 180, 25);
        add(txtNombrePlaylist);

        btnCrear = new JButton("Crear");
        btnCrear.setBounds(130, 130, 120, 30);
        add(btnCrear);

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPlaylist();
            }
        });
    }
    
    private void crearPlaylist() {
        String nombre = txtNombrePlaylist.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un nombre.");
            return;
        }

        User user = Session.usuarioActual;

        if (user == null) {
            JOptionPane.showMessageDialog(this, "No hay usuario en sesión.");
        return;
        }
        
        PlayList nueva = new PlayList(UUID.randomUUID().toString(), nombre, user);
        playlistService.addPlaylist(nueva);

        JOptionPane.showMessageDialog(this, "¡Playlist creada con éxito!");
        txtNombrePlaylist.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JPCreatePlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPCreatePlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPCreatePlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPCreatePlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPCreatePlaylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
