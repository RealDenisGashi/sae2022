package at.ac.fhwn.sae.lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NmeaReaderApplication {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<SaePoint> NmeaList = new ArrayList<>();
        double latitude = 0;
        double latitudedegree = 0;
        double latitudeminute = 0;
        double longitude = 0;
        double longitudedegree = 0;
        double longitudeminute = 0;

        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("nmea.txt").getFile());
        System.out.println("Exists: " + file.exists());
        System.out.println("Can read: " + file.canRead());

        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        boolean canContinueLoop = scanner.hasNext();
        String line = scanner.nextLine();

        while (scanner.hasNext()) {
            String[] components = scanner.nextLine().split(",");
            if (components[0].equals("$GNGGA")) {
                latitudedegree = Double.parseDouble(components[2].substring(0, 2));
                latitudeminute = Double.parseDouble(components[2].substring(2)) / 60;
                latitude = latitudedegree + latitudeminute;
                if (components[3].equals("S")) {
                    latitude = latitude * -1;
                }
                longitudedegree = Double.parseDouble(components[4].substring(0, 3));
                longitudeminute = Double.parseDouble(components[4].substring(3)) / 60;
                longitude = longitudedegree + longitudeminute;
                if (components[5].equals("W")) {
                    longitude = longitude * -1;
                }
                NmeaList.add(new SaePoint(components[1],latitude,longitude,components[7],components[6]));
            }
        }

        //Ausgabe
        System.out.println("time       |latitude          |longitude         |satNr|fix");
        int i = 0;
        for(SaePoint element : NmeaList){
            System.out.println(NmeaList.get(i).getTime() + "  |" + NmeaList.get(i).getLatitude() + "|" +  NmeaList.get(i).getLongitude() + "|" + NmeaList.get(i).getSatNr() + "|" + NmeaList.get(i).getFix());
            i ++;
        }
    }
}