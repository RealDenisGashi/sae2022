
package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson3.Dog;
import at.ac.fhwn.sae.lesson4.SaePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;

@RestController
public class LocationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    LocationService locationService;
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("setLocation")
    public SaePoint addLocation(

            @RequestParam("id") int id,
            @RequestParam("time") String time,
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            //@RequestParam(value = "lon", required = false) double lon,
            @RequestParam("satNr") String sat,
            @RequestParam("fixQ") String fix
    ) {
        SaePoint saePoint = new SaePoint(time, lat, lon, sat, fix );
        locationService.addLocation(id, saePoint);

        logger.info("Point received: " + lat + ";" + lon);
        return saePoint;
    }

    @GetMapping ("/location")
    public SaePoint getLocation(
            @RequestParam("id") int id,
            @RequestParam(value = "index", required = false) Integer index
    ){
            return LocationService.getLocation(id, index);
    }

    @GetMapping ("/locations")
    public List <SaePoint> getLocations(
            @RequestParam("id") int id
    ){
        return LocationService.getLocations(id);
    }

    @GetMapping("/allLocations")
    public Hashtable<Integer, List<SaePoint>> getAllLocations(){
        return LocationService.getAllLocations();
    }
}

