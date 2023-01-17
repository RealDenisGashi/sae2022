package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.NmeaReader;
import at.ac.fhwn.sae.lesson4.SaePoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LocationTransmitter {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(SaePoint.class.getClassLoader().getResource("auto.txt").getFile());
        NmeaReader nmeaReader = new NmeaReader(file);
        LocationClientService locationClientService = new LocationClientService();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                try {
                    SaePoint saePoint = nmeaReader.readPoint();
                    System.out.println("Time " + new Date());
                    locationClientService.sendLocation(1, saePoint);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        };

        Timer timer = new Timer("timerTask");
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);

    }
}