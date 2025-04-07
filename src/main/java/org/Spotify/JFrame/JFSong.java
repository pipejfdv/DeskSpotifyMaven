
package org.Spotify.JFrame;

import GlobalData.ArrayData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.Spotify.ConfigPlayer.saveSong;
import org.Spotify.Controllers.GenderController;
import org.Spotify.Controllers.SongController;
import org.Spotify.DB.DataBase;
import org.Spotify.Models.Album;
import org.Spotify.Models.GenderList;
import org.Spotify.Models.GenderOfMusic;
import org.Spotify.Models.Person;
import org.Spotify.Models.Song;
import org.Spotify.Models.User;
import org.Spotify.Services.GenderMusicService;
import org.Spotify.Services.SongService;

public class JFSong extends javax.swing.JFrame {

    private Map<String, GenderOfMusic> genderMap;
    
    SongController songCon = new SongController();
    private boolean update;
    private String idSong;
    private DefaultListModel<String> modelArtists = new DefaultListModel<>();
    private DefaultListModel<String> modelPersons = new DefaultListModel<>();
    
    public JFSong(boolean update, String idSong) {
        initComponents();
        loadGenders();
        
        this.update = update;
        this.idSong = idSong;
        
        jLiArtistSong.setModel(modelArtists);
        jLiPersonSong.setModel(modelPersons);
        jBAddArtist.addActionListener(e -> agregarArtista());
        jBDeleteArtist.addActionListener(e -> eliminarArtista());
        jBAddPerson.addActionListener(e -> agregarPersona());
        jBDeletePerson.addActionListener(e -> eliminarPersona());
        
        if (update) {
            jLaTitle.setText("Update Song");
            jBSongAddUpd.setText("Update Song");
            cargarDatosCancion();
        } else {
            jLaTitle.setText("Add Song");
            jBSongAddUpd.setText("Add Song");
        }
        
        jBSongAddUpd.addActionListener(e -> newSong(update, idSong));
    }
    
    public void newSong(boolean update, String idSong){
         
        String nameSong = jTFNameSong.getText();
        
        String durationSong = jTFDurationSong.getText();
        
        
        
        for (int i = 0; i < modelArtists.size(); i++) {
            String nickname = modelArtists.getElementAt(i);
            String idUser = songCon.getUser(nickname);
            if (idUser != null) {
                ArrayData.artistas.add(new User(idUser));
            }
        }
        
        if (nameSong == null || durationSong == null || ArrayData.artistas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name, Duration and at least one artist are required to create a song");
            return;
        }
        
        if (!update){
            if (checkSongsBD(nameSong)) {
                JOptionPane.showMessageDialog(this, "This song name is already registered");
                return;
            }
        }
        
            
        String genderName = jCBGenders.getSelectedItem().toString();
        String idGender = songCon.getIdGender(genderName);
                
        GenderOfMusic genderSong = new GenderOfMusic(idGender);
        
        Album albumSong = null;
        String album = jTFAlbumSong.getText().trim();
        
        if (!album.isEmpty()) {
            if (checkAlbumsBD(album)) {
                albumSong = new Album(album);
            }
            else{
                JOptionPane.showMessageDialog(this, "This Album name doesn't exist");
                return;
            }
        }

        
        for (int i = 0; i < modelPersons.size(); i++) {
            String firstName = modelPersons.getElementAt(i);
            String idPerson = songCon.getPerson(firstName);
            if (idPerson != null) {
                ArrayData.personas.add(new Person(idPerson));
            }
        }
        
        if (update){
            Song updateSong = new Song(idSong, nameSong, "1111", false, durationSong, genderSong, albumSong, ArrayData.artistas, ArrayData.personas);
        
            songCon.updateSong(updateSong);

            JOptionPane.showMessageDialog(this, "Song updated successfully.");

        }else{
            String file = saveSong.uploadMP3Song();
            
            Song song = new Song(UUID.randomUUID().toString(), jTFNameSong.getText(), jTYearRelease.getText(), jTFDurationSong.getText(), getSelectedGender(), null, file, ArrayData.artistas, ArrayData.personas);
        
            songCon.insertSong(song);

            JOptionPane.showMessageDialog(this, "Song added successfully.");

            limpiarCampos();
        }
    }
    
    private void loadGenders(){
        GenderController genderController = new GenderController(new GenderMusicService());
        genderMap = genderController.genders();
        for(String genderName : genderMap.keySet()){
            jCBGenders.addItem(genderName);
        }
    }
    
    private GenderOfMusic getSelectedGender(){
        String selectGender = (String) jCBGenders.getSelectedItem();
        return genderMap.get(selectGender);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLaTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFDurationSong = new javax.swing.JTextField();
        jTFNameSong = new javax.swing.JTextField();
        jCBGenders = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLiArtistSong = new javax.swing.JList<>();
        jBAddArtist = new javax.swing.JButton();
        jBDeleteArtist = new javax.swing.JButton();
        jBSongAddUpd = new javax.swing.JButton();
        jTFArtistSong = new javax.swing.JTextField();
        jTFPersonSong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLiPersonSong = new javax.swing.JList<>();
        jBAddPerson = new javax.swing.JButton();
        jBDeletePerson = new javax.swing.JButton();
        jTFAlbumSong = new javax.swing.JTextField();
        jBBackHome = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTYearRelease = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLaTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLaTitle.setText("Add Song");

        jLabel2.setText("Name");

        jLabel3.setText("Duration");

        jLabel4.setText("Gender");

        jLabel5.setText("Album");

        jLabel6.setText("Artist");

        jLabel7.setText("Person");

        jTFDurationSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDurationSongActionPerformed(evt);
            }
        });

        jTFNameSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameSongActionPerformed(evt);
            }
        });

        jCBGenders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGendersActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jLiArtistSong);

        jBAddArtist.setText("Add A.");
        jBAddArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddArtistActionPerformed(evt);
            }
        });

        jBDeleteArtist.setText("Delete A.");
        jBDeleteArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteArtistActionPerformed(evt);
            }
        });

        jBSongAddUpd.setText("Add Song");
        jBSongAddUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSongAddUpdActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jLiPersonSong);

        jBAddPerson.setText("Add P.");
        jBAddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddPersonActionPerformed(evt);
            }
        });

        jBDeletePerson.setText("Delete P.");
        jBDeletePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletePersonActionPerformed(evt);
            }
        });

        jBBackHome.setText("Back");
        jBBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackHomeActionPerformed(evt);
            }
        });

        jLabel8.setText("Year of release");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBBackHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBSongAddUpd, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBAddArtist)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBDeleteArtist))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBAddPerson)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBDeletePerson))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLaTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jTFArtistSong, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTFNameSong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFDurationSong, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFPersonSong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCBGenders, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(155, 155, 155))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTYearRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(166, 166, 166)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTFAlbumSong, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLaTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFNameSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFDurationSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTFAlbumSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTYearRelease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBGenders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFArtistSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPersonSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAddArtist)
                            .addComponent(jBDeleteArtist))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBAddPerson)
                                .addComponent(jBDeletePerson))
                            .addGap(101, 101, 101))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jBSongAddUpd)
                .addGap(18, 18, 18)
                .addComponent(jBBackHome)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFDurationSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDurationSongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDurationSongActionPerformed

    private void jTFNameSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNameSongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNameSongActionPerformed

    private void jCBGendersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGendersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBGendersActionPerformed

    private void jBAddArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddArtistActionPerformed
        
    }//GEN-LAST:event_jBAddArtistActionPerformed

    private void jBDeleteArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteArtistActionPerformed
        
    }//GEN-LAST:event_jBDeleteArtistActionPerformed

    private void jBAddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddPersonActionPerformed
        
    }//GEN-LAST:event_jBAddPersonActionPerformed

    private void jBDeletePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletePersonActionPerformed
        
    }//GEN-LAST:event_jBDeletePersonActionPerformed

    private void jBBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackHomeActionPerformed
        JFHome open = new JFHome();
        limpiarCampos();
        open.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBBackHomeActionPerformed

    private void jBSongAddUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSongAddUpdActionPerformed
        //newSongAdd(boolean update, String idSong);
        
    }//GEN-LAST:event_jBSongAddUpdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddArtist;
    private javax.swing.JButton jBAddPerson;
    private javax.swing.JButton jBBackHome;
    private javax.swing.JButton jBDeleteArtist;
    private javax.swing.JButton jBDeletePerson;
    private javax.swing.JButton jBSongAddUpd;
    private javax.swing.JComboBox<String> jCBGenders;
    private javax.swing.JLabel jLaTitle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jLiArtistSong;
    private javax.swing.JList<String> jLiPersonSong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFAlbumSong;
    private javax.swing.JTextField jTFArtistSong;
    private javax.swing.JTextField jTFDurationSong;
    private javax.swing.JTextField jTFNameSong;
    private javax.swing.JTextField jTFPersonSong;
    private javax.swing.JTextField jTYearRelease;
    // End of variables declaration//GEN-END:variables
    
    private boolean agregarArtista() {
        String artista = jTFArtistSong.getText().trim();
        if (!artista.isEmpty()) {
            if (checkUsersBD(artista)) {
                modelArtists.addElement(artista);
                jTFArtistSong.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "This Artist isn't registered in the DB");
                int answer = JOptionPane.showConfirmDialog(null, "You want to add a new record?","Yes o no", JOptionPane.YES_NO_OPTION);
                boolean aceptado = (answer == JOptionPane.YES_OPTION);
                if (aceptado){
                    JFRegistryArtis open = new JFRegistryArtis();
                    open.setVisible(true);
                    open.setLocationRelativeTo(null);
                    open.setResizable(false);
                    this.setVisible(false);
                }
                return false;
            }
        } else{
            JOptionPane.showMessageDialog(this, "To add an Artist you need to write his/her nickname");
            return false;
        }
        return true;
    }
    
    private boolean agregarPersona() {
        String persona = jTFPersonSong.getText().trim();
        if (!persona.isEmpty()) {
            if (checkPersonsBD(persona)) {
                modelPersons.addElement(persona);
                jTFPersonSong.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "This Person isn't registered in the DB");
                int answer = JOptionPane.showConfirmDialog(null, "You want to add a new record?","Yes o no", JOptionPane.YES_NO_OPTION);
                boolean aceptado = (answer == JOptionPane.YES_OPTION);
                if (aceptado){
                    JFRegistryArtis open = new JFRegistryArtis();
                    open.setVisible(true);
                    open.setLocationRelativeTo(null);
                    open.setResizable(false);
                    this.setVisible(false);
                }
                return false;
            }
        } else{
            int answer = JOptionPane.showConfirmDialog(null, "You want to add a new record?","Yes o no", JOptionPane.YES_NO_OPTION);
            
            return false;
        }
        return true;
    }

    private void eliminarArtista() {
        int index = jLiArtistSong.getSelectedIndex();
        if (index != -1) {
            modelArtists.remove(index);
        }
    }

    // Método para eliminar persona seleccionada
    private void eliminarPersona() {
        int index = jLiPersonSong.getSelectedIndex();
        if (index != -1) {
            modelPersons.remove(index);
        }
    }
    
    private boolean checkSongsBD(String songName){
        return songCon.checkDB("Songs", "nameSong", songName);
    }
    
    private boolean checkUsersBD(String nickname) {
        return songCon.checkDB("Users", "nickname", nickname);
    }

    private boolean checkPersonsBD(String nombre) {
        return songCon.checkDB("Persons", "firstName", nombre);
    }

    private boolean checkAlbumsBD(String album) {
        return songCon.checkDB("Albums", "nameAlbum", album);
    }
    
    private void limpiarCampos() {
        jTFNameSong.setText("");       
        jTFDurationSong.setText("");   
        jTFAlbumSong.setText("");     
        jCBGenders.setSelectedIndex(0); 
        modelArtists.clear();
        modelPersons.clear();
    }
    
     private void cargarDatosCancion() {
        Song song = songCon.showSong(idSong);

        if (song != null) {
            jTFNameSong.setText(song.getNameSong());
            jTFDurationSong.setText(song.getDurationSong());

            if (song.getAlbumSong() != null) {
                jTFAlbumSong.setText(song.getAlbumSong().getNameAlbum());
            }

            jCBGenders.setSelectedItem(song.getGenderSong().getGenderOfMusic());

            for (User user : song.getArtistSong()) {
                modelArtists.addElement(user.getNickname()); 
            }

            for (Person person : song.getPersonSong()) {
                modelPersons.addElement(person.getFirstName()); 
            }
        }
     }
}
