package GameSetting;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class CreatSound {
    public static void playMedia(String filename) {
        Media media = new Media(new File(filename).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}

