package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class LocationService {

    static Hashtable<Integer, List<SaePoint>> location = new Hashtable<>();

    public void addLocation(int id, SaePoint saePoint){
        if(location.containsKey(id)){
            location.get(id).add(saePoint);
        }else{
            List<SaePoint> saePointList = new ArrayList<>();
            saePointList.add(saePoint);
            location.put(id, saePointList);
        }
    }

    public static SaePoint getLocation(int id, Integer index){
        if(index == null){
            return location.get(id).get(location.get(id).size()-1);
        }else{
            return location.get(id).get(index);
        }
    }

    public static List<SaePoint> getLocations(int id){
        return location.get(id);
    }

    public static Hashtable<Integer, List<SaePoint>> getAllLocations() {
       return location;
    }
}
