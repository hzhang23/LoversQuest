package com.loversQuest.shootingGame;

import javax.sound.sampled.*;
import java.io.*;

public class PlaySounds {
    public PlaySounds (String file) {
        try {
            AudioInputStream AIS = AudioSystem.getAudioInputStream(new File(file));
            AudioFormat audioFormat = AIS.getFormat();
            System.out.println("sample rate is " + audioFormat.getSampleRate());
            System.out.println("FrameLength is " + AIS.getFrameLength());
            System.out.println("sound length is " + AIS.getFrameLength() / audioFormat.getSampleRate());

            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while ((len = AIS.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            AIS.close();
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new PlaySounds("resources/shootingGameResources/M4_SOUND.wav");

    }

}
