package org.Spotify.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.Spotify.Models.PlayList;
import org.Spotify.Models.Song;
import org.Spotify.Services.PlaylistService;

public class JPListSongs extends javax.swing.JPanel {

    private JComboBox<PlayList> comboPlaylists;
    private JList<String> listSongs;
    private DefaultListModel<String> listModel;

    private PlaylistService playlistService = new PlaylistService();

    public JPListSongs() {
        initComponents();
        cargarPlaylists();
    }
    private void initComponents() {
        setLayout(null);

        jLabel = new JLabel("Playlist");
        jLabel.setFont(new java.awt.Font("Noto Sans CJK SC", 1, 24));
        jLabel.setBounds(150, 20, 200, 30);
        add(jLabel);

        comboPlaylists = new JComboBox<>();
        comboPlaylists.setBounds(50, 70, 300, 30);
        add(comboPlaylists);

        listModel = new DefaultListModel<>();
        listSongs = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listSongs);
        scrollPane.setBounds(50, 120, 300, 250);
        add(scrollPane);

        comboPlaylists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayList selected = (PlayList) comboPlaylists.getSelectedItem();
                if (selected != null) {
                    cargarCancionesDePlaylist(selected.getIdPlayList());
                }
            }
        });
    }

    private void cargarPlaylists() {
        ArrayList<PlayList> playlists = playlistService.getAllPlaylists();
        comboPlaylists.removeAllItems();
        for (PlayList p : playlists) {
            comboPlaylists.addItem(p);
        }
    }

    private void cargarCancionesDePlaylist(String idPlaylist) {
        listModel.clear();
        ArrayList<Song> canciones = playlistService.getSongsByPlaylistId(idPlaylist);
        for (Song s : canciones) {
            listModel.addElement(s.getNameSong());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();

        jLabel.setFont(new java.awt.Font("Noto Sans CJK SC", 1, 24)); // NOI18N
        jLabel.setText("Playlist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel)
                .addContainerGap(371, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel;
    // End of variables declaration//GEN-END:variables
}
