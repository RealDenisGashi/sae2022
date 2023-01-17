package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson3.*;
import at.ac.fhwn.sae.lesson4.SaePoint;

import java.util.*;

public class LocationReciever {
    static LocationClientService locationClientService = new LocationClientService();


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Was möchten Sie tun?");
        System.out.println("Für Letzte Position mit der ID abfragen drücken Sie die [1]");
        System.out.println("Für Position mit der ID abfragen drücken Sie die [2]");
        System.out.println("Für alle Positionen anzeigen drücken Sie die [3]");

        String sinput = in.next();
        int iinput  = Integer.parseInt(sinput);
        System.out.println(iinput);

        while(iinput != 5){
            switch(iinput){
                case 1:
                    System.out.println("Eingabe der ID:");
                    String sinputid = in.next();
                    int iinputid  = Integer.parseInt(sinputid);

                    System.out.println("time       |latitude          |longitude         |satNr|fix");
                    SaePoint pointToPrint = locationClientService.getLocation(iinputid);
                    System.out.println(LocationReciever.print(pointToPrint));

                    break;
                case 2:
                    System.out.println("Eingabe der ID:");
                    sinputid = in.next();
                    iinputid  = Integer.parseInt(sinputid);

                    System.out.println("time       |latitude          |longitude         |satNr|fix");
                    List<SaePoint> pointsToPrint = new ArrayList<>(locationClientService.getLocations(iinputid) );
                    int i = 0;
                    for(SaePoint element : pointsToPrint){
                        System.out.println(LocationReciever.print(pointsToPrint.get(i)));
                        i ++;
                    }

                    break;
                case 3:
                    Hashtable<Integer, List<SaePoint>> saePointHashtable = locationClientService.getAllLocations();
                    System.out.println("time       |latitude          |longitude         |satNr|fix");

                    for (Map.Entry<Integer, List<SaePoint>> entry : saePointHashtable.entrySet()) {
                        for (SaePoint location : saePointHashtable.get(entry.getKey())) {
                            System.out.println(String.format("%-4d | %9s | %9s | %9s | %9s | %4s", entry.getKey(), location.getTime(), location.getLatitude(), location.getLongitude(), location.getSatNr(), location.getFix()));
                        }
                    }

                    break;
            }
            System.out.println("Was möchten Sie tun?");
            System.out.println("Für Letzte Position mit der ID abfragen drücken Sie die [1]");
            System.out.println("Für Position mit der ID abfragen drücken Sie die [2]");
            System.out.println("Für Alle Positionen anzeigen drücken Sie die [3]");
            sinput = in.next();
            iinput  = Integer.parseInt(sinput);
        }
    }

    public static String print(SaePoint point){
        return point.getTime() + "  |" + point.getLatitude() + "|" +  point.getLongitude() + "|" + point.getSatNr() + "|" + point.getFix();

    }
}
