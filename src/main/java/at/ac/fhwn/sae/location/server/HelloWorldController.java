package at.ac.fhwn.sae.location.server;

import at.ac.fhwn.sae.lesson3.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class HelloWorldController {

    CowService cowService;

    public HelloWorldController(CowService cowService){
        this.cowService = cowService;
    }

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

    @GetMapping("/cow")
    public Dog cow(@RequestParam("index")int index){
        Dog cow = new Dog("Loisi");
        cowService.helloWorld(cow, index);
        return cow;
    }

    @GetMapping("/cows")
    public Hashtable<Integer, Dog> cows(){

        return cowService.getCows();
    }

}
