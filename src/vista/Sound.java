package vista;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound {
	
	
	private Media media;
	private MediaPlayer player;
	
	
	public Sound(String file) {	
		
		this.media=new Media(new File(file).toURI().toString());
		this.player=new MediaPlayer(media);		
	}
	
	public void play(){
		player.play();
	}
	
	public void stop(){
		player.stop();
	}
	public void Nostop() {
		
		player.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				player.seek(Duration.ZERO);
			}
			
		});
		player.play();
		
	}
	

}
