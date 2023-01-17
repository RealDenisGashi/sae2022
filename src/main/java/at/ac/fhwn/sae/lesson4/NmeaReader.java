package at.ac.fhwn.sae.lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NmeaReader {

    private final File file;
    double latitude = 0;
    double latitudedegree = 0;
    double latitudeminute = 0;
    double longitude = 0;
    double longitudedegree = 0;
    double longitudeminute = 0;
    private Scanner scanner;

    public NmeaReader(File file) throws FileNotFoundException {
        this.file = file;
        initScanner();
    }

    private void initScanner() throws FileNotFoundException{

        System.out.println("Exists: " + file.exists());
        System.out.println("Can read: " + file.canRead());

        FileInputStream fis = new FileInputStream(file);
        this.scanner = new Scanner(fis);
    }

    public SaePoint readPoint() throws FileNotFoundException {

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
                return(new SaePoint(components[1],latitude,longitude,components[7],components[6]));
            }
        }
        initScanner();
        return readPoint();
    }
}
