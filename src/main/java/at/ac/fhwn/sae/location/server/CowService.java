package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson3.Dog;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class CowService {

    Hashtable<Integer, Dog> cows = new Hashtable<>();

    public void helloWorld(Dog cow, int index){
        System.out.println("Hello World");
        cows.put(index, cow);
    }

    public Hashtable<Integer, Dog> getCows() {
        return cows;
    }

}
