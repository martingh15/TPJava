package utils;

import java.io.File;
import utils.*;
import javax.sound.sampled.*;

public class ReproduceAudio {
	
	public void reproducir(){
		try{
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("Sonidos","Mortal Kombat 8-bit (online-audio-converter.com).wav")));
			
			sonido.start();
			
			sonido.loop(Clip.LOOP_CONTINUOUSLY);
		}catch (Exception e){
			System.out.println("Error en el audio" + e);
		}
	}
	
	public void audioAtaque(){
		try{
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("Sonidos","Efectos de Sonido - Street Fight II Ryu's Hadouken (online-audio-converter.com).wav")));
			
			sonido.start();
			
		}catch (Exception e){
			System.out.println("Error en el audio" + e);
		}
	}

}
