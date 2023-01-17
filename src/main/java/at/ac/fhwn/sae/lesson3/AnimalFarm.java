package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Willkommen am AnimalFarm-Bauernhof.");
        System.out.println("Was möchten Sie tun?");
        System.out.println("Für Tier hinzufügen drücken Sie die [1]");
        System.out.println("Für Tiere anzeigen drücken Sie die [2]");
        System.out.println("Für Tiere nach Art anzeigen drücken Sie die [3]");
        System.out.println("Für Tier entfernen drücken Sie die [4]");
        System.out.println("Für Programm beenden drücken Sie die [5]");
        String sinput = in.next();
        int iinput  = Integer.parseInt(sinput);
        List<Animal> list = new ArrayList<>();
        System.out.println(iinput);

        while(iinput != 5){
            switch(iinput){
                case 1:
                    System.out.println("Welches Tier möchten Sie hinzufügen?");
                    System.out.println("Für Hund drücken Sie die [1]");
                    System.out.println("Für Katze drücken Sie die [2]");
                    System.out.println("Für Pferd  drücken Sie die [3]");
                    System.out.println("Für Schwein Sie die [4]");
                    String sinput1 = in.next();
                    int iinput1  = Integer.parseInt(sinput1);
                    System.out.println("Geben Sie einen Namen für das Tier ein:");
                    String inputname = in.next();

                    switch(iinput1){
                        case 1:
                            list. add(new Dog(inputname));
                            break;
                        case 2:
                            Cat cat = new Cat(inputname);
                            list.add(cat);
                            break;
                        case 3:
                            Horse horse = new Horse(inputname);
                            list.add(horse);
                            break;

                        case 4:
                            Pig pig = new Pig(inputname);
                            list.add(pig);
                            break;
                    }break;
                case 2:
                    for (Animal animal:list){
                        System.out.println(animal.getID() + " | " + animal.name);
                    }break;
                case 3:

                    System.out.println("Welche Tiere möchten Sie sehen?");
                    System.out.println("Für Hunde drücken Sie die [1]");
                    System.out.println("Für Katzen drücken Sie die [2]");
                    System.out.println("Für Pferde  drücken Sie die [3]");
                    System.out.println("Für Schweine Sie die [4]");
                    String sanimaltype = in.next();
                    int animaltype  = Integer.parseInt(sanimaltype);

                    switch(animaltype){
                        case 1:
                            for (Animal animal:list){
                                if (animal instanceof Dog){
                                    System.out.println(animal.getID() + " | " + animal.name);
                                }
                            }break;
                        case 2:
                            for (Animal animal:list){
                                if (animal instanceof Cat){
                                    System.out.println(animal.getID() + " | " + animal.name);
                                }
                            }break;
                        case 3:
                            for (Animal animal:list){
                                if (animal instanceof Horse){
                                    System.out.println(animal.getID() + " | " + animal.name);
                                }
                            }break;
                        case 4:
                            for (Animal animal:list){
                                if (animal instanceof Pig){
                                    System.out.println(animal.getID() + " | " + animal.name);
                                }
                            }break;
                    }break;

                case 4:
                    System.out.println("Nummer des Tieres das gelöscht werden soll:");
                    String sanimalremovenumber = in.next();
                    int animalremovenumber  = Integer.parseInt(sanimalremovenumber);
                    list.remove(animalremovenumber-1);
                    break;
            }
            System.out.println("Was möchten Sie tun?");
            System.out.println("Für Tier hinzufügen drücken Sie die [1]");
            System.out.println("Für Tiere anzeigen drücken Sie die [2]");
            System.out.println("Für Tiere nach Art anzeigen drücken Sie die [3]");
            System.out.println("Für Tier entfernen drücken Sie die [4]");
            System.out.println("Für Programm beenden drücken Sie die [5]");
            sinput = in.next();
            iinput  = Integer.parseInt(sinput);
        }
    }
}
