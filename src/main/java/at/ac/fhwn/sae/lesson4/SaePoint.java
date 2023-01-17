package at.ac.fhwn.sae.lesson4;

public class SaePoint {
    private String time;
    private double latitude;
    private double longitude;
    private String satNr;
    private String fix;

    public SaePoint(){};

    public SaePoint(String time, double latitude, double longitude, String satNr, String fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.satNr = satNr;
        this.fix = fix;
    }

    public String getTime(){return time;}
    public String getLatitude(){return Double.toString(latitude);}
    public String getLongitude(){return Double.toString(longitude);}
    public String getSatNr(){return satNr;}
    public String getFix(){return fix;}
}
