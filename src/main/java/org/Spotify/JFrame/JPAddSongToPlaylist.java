package org.Spotify.JFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.Spotify.Models.PlayList;
import org.Spotify.Models.Song;
import org.Spotify.Services.PlaylistService;
import org.Spotify.Services.SongService;
public class JPAddSongToPlaylist extends javax.swing.JFrame {
    private JLabel labelTitulo;
    private JComboBox<PlayList> comboPlaylists;
    private JComboBox<Song> comboSongs;
    private JButton btnAgregar;

    private PlaylistService playlistService = new PlaylistService();
    private SongService songService = new SongService();

    public JPAddSongToPlaylist() {
        initComponents();
        cargarPlaylists();
        cargarSongs();
    }
    
    private void initComponents() {
        setLayout(null);

        labelTitulo = new JLabel("Agregar canción a playlist");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        labelTitulo.setBounds(80, 20, 300, 30);
        add(labelTitulo);

        comboPlaylists = new JComboBox<>();
        comboPlaylists.setBounds(50, 70, 300, 25);
        add(comboPlaylists);

        comboSongs = new JComboBox<>();
        comboSongs.setBounds(50, 110, 300, 25);
        add(comboSongs);

        btnAgregar = new JButton("Agregar canción");
        btnAgregar.setBounds(110, 160, 160, 30);
        add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCancion();
            }
        });
    }

    private void cargarPlaylists() {
        comboPlaylists.removeAllItems();
        ArrayList<PlayList> playlists = playlistService.getAllPlaylists();
        for (PlayList p : playlists) {
            comboPlaylists.addItem(p);
        }
    }

    private void cargarSongs() {
        comboSongs.removeAllItems();
        ArrayList<Song> canciones = songService.getAllSongs(); // este método debe existir en tu servicio
        for (Song s : canciones) {
            comboSongs.addItem(s);
        }
    }

    private void agregarCancion() {
        PlayList playlist = (PlayList) comboPlaylists.getSelectedItem();
        Song song = (Song) comboSongs.getSelectedItem();

        if (playlist != null && song != null) {
            playlistService.addSongToPlaylist(playlist.getIdPlayList(), song.getIdSong());
            JOptionPane.showMessageDialog(this, "Canción agregada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una playlist y una canción.");
        }
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
            java.util.logging.Logger.getLogger(JPAddSongToPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPAddSongToPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPAddSongToPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPAddSongToPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPAddSongToPlaylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
