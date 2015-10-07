/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedmediaplayer;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author jogarcia
 */
public class EmbeddedMediaPlayer extends Application {
//private static final String MEDIA_URL = "file:/c:/Users/jogarcia/Downloads/test.mp4";
        
        private static File file = new File("c:/Users/jogarcia/Downloads/test.mp4");
       private static final String MEDIA_URL = file.toURI().toString();
        //private static final String MEDIA_URL
          //      = "file:///c:/"
        //\\localhost\Users\jogarcia\Downloads\sample_iPod.m4v
        //  = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
        //file:///C:/Documents%20and%20Settings/davris/FileSchem

        @Override

        public void start(Stage primaryStage) {
                primaryStage.setTitle("Embedded Media Player");
                Group root = new Group();
                Scene scene = new Scene(root, 540, 310);
// create media player
                Media media = new Media(MEDIA_URL);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
// create mediaView and add media player to the viewer
                MediaView mediaView = new MediaView(mediaPlayer);
                ((Group) scene.getRoot()).getChildren().add(mediaView);
                primaryStage.setScene(scene);
                primaryStage.show();
        }
}
