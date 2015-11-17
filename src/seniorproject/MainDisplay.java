package seniorproject;

import java.io.File;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import java.time.Duration;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import org.openstreetmap.gui.jmapviewer.*;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;
import org.openstreetmap.gui.jmapviewer.interfaces.TileLoader;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOpenAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;


public class MainDisplay extends JFrame{
    //private static File file = new File("C:\\Users\\MagnusonA1782\\Downloads\\sample_mpeg4.mp4");
    //private static final String MEDIA_URL = file.toURI().toString();
    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
    
    private static void initMediaControls(JFXPanel fxPanel)
    {
        HBox mediaBar = new HBox();
        
        mediaBar.setPadding(new Insets(20));
        mediaBar.setAlignment(Pos.CENTER);
        mediaBar.alignmentProperty().isBound();
        mediaBar.setSpacing(5);
        mediaBar.setStyle("-fx-background-color: Black");
        
        final Button playButton = new Button(">");
        final Button pauseButton = new Button("||");
        
        
        mediaBar.getChildren().add(playButton);
        mediaBar.getChildren().add(pauseButton);
    }
    private static void initFX(JFXPanel fxPanel)
    {
        /*Group root = new Group();
        Scene scene = new Scene(root, 540, 400);
        // create media player
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        mediaPlayer.setAutoPlay(false);
        //MediaControls mediaControls = new MediaControls();
        //scene.setRoot(mediaControls);
        // create mediaView and add media player to the viewer
        MediaView mediaView = new MediaView(mediaPlayer);
        
       ((Group) scene.getRoot()).getChildren().add(mediaView);
        
        fxPanel.setScene(scene);*/
        Group root = new Group();
        Scene scene = new Scene(root, 540, 310);
        // create media player
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        // create mediaView and add media player to the viewer
        MediaView mediaView = new MediaView(mediaPlayer);
        ((Group) scene.getRoot()).getChildren().add(mediaView);
        
        fxPanel.setScene(scene);
    }
    
    static void initMap(JFrame mainFrame)
    {
        JMapViewer map = new JMapViewer();
        //map.setSize(25,25);
        //map.setBounds(250, 250, 25, 25);
        //position the map
        Point mapPos = new Point();
        mapPos.x = mainFrame.getX() + 100;
        mapPos.y = mainFrame.getY() + 100;
        map.setCenter(mapPos);
        map.setSize(100,100);
        mainFrame.add(map);
    }
    
    static void initAndShowGUI()
    {
    new Demo().setVisible(true);
    }
    
//    static void initAndShowGUI()
//    {
//        //to be called by Login Screen
//        JFrame frame = new JFrame("Apollo Dash Cam");
//        final JFXPanel fxPanel = new JFXPanel();
//        frame.add(fxPanel);
//        frame.setSize(800,800);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        //Menu items
//        JMenu fileMenu = new JMenu("File");
//        
//        JMenuItem playItem = new JMenuItem("Play");
//        fileMenu.add(playItem);
//        playItem.addActionListener(
//                new ActionListener()
//                {
//                    public void actionPerformed(ActionEvent event)
//                    {
//                        //mediaPlayer.play();
//                    }
//                }
//        );
//        
//        JMenu aboutMenu = new JMenu("About");
//        
//        JMenuItem aboutItem = new JMenuItem("About");
//        aboutMenu.add(aboutItem);
//        
//        JMenuBar bar = new JMenuBar();
//        frame.setJMenuBar(bar);
//        bar.add(fileMenu);
//        bar.add(aboutMenu);
//        
//    //    initFX(fxPanel);
//        frame.add(fxPanel);
//        
//        initMap(frame);
//        
//        /*Platform.runLater(new Runnable(){
// 
//            @Override
//            public void run() {
//                initFX(fxPanel);
//            }
//        });*/
//    } 
}
