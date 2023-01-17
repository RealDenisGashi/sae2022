package at.ac.fhwn.sae.location.client;

import at.ac.fhwn.sae.lesson4.SaePoint;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LocationClientService{

    private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
    private static final String REQUEST_METHOD_GET_LOCATION = "/location";
    private static final String REQUEST_METHOD_GET_LOCATIONS = "/locations";
    private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/allLocations";
    private static final String BASE_URL = "https://location-server-ortner-location-app-api.azuremicroservices.io";

    private String getResponseString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()){
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }


    public SaePoint sendLocation(int id, SaePoint saePoint){

        String params = String.format("?id=%s&lat=%s&lon=%s&time=%s&satNr=%s&fixQ=%s",
                id,
                saePoint.getLatitude(),
                saePoint.getLongitude(),
                saePoint.getTime(),
                saePoint.getSatNr(),
                saePoint.getFix()
                );

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL+REQUEST_METHOD_SET_LOCATION+params).openConnection();

            Scanner scanner = new Scanner(connection.getInputStream());
            System.out.println(scanner.nextLine());
            return saePoint;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public SaePoint getLocation(int id){
        String sid = Integer.toString (id);

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL + REQUEST_METHOD_GET_LOCATION + "?id=" + sid).openConnection();
            String json = getResponseString(connection.getInputStream());

            return new ObjectMapper().readValue(json, SaePoint.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public List<SaePoint> getLocations(int id){
        String sid = Integer.toString (id);

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL + REQUEST_METHOD_GET_LOCATIONS + "?id=" + sid).openConnection();
            String jsonArray = getResponseString(connection.getInputStream());

            return new ObjectMapper().readValue(jsonArray , new TypeReference<List<SaePoint>>(){});
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public Hashtable<Integer,List<SaePoint>> getAllLocations(){

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL + REQUEST_METHOD_GET_ALL_LOCATIONS).openConnection();
            String jsonArray = getResponseString(connection.getInputStream());

            return new ObjectMapper().readValue(jsonArray , new TypeReference<Hashtable<Integer,List<SaePoint>>>(){});
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
