package game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Sound 
{
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Sound()
    {
        soundURL[0] = getClass().getResource("/player/bgm.wav");
        soundURL[1] = getClass().getResource("/player/lock.wav");
        soundURL[2] = getClass().getResource("/player/sword.wav");
        soundURL[3] = getClass().getResource("/player/end.wav");
    }
    
    public void setFile(int i)
    {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e)
        {
            
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
