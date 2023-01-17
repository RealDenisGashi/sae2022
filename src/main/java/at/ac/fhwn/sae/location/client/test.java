package at.ac.fhwn.sae.location.client;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            System.out.println(scanner.nextLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
