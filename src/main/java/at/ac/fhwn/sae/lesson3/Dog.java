package at.ac.fhwn.sae.lesson3;

public class Dog extends Animal{

    private static final String  CLASS_DESCRIPTION = "This is a dog class";
    public static final String DEFAULT_DOG_NAME = "default dog name";
    private static final String DEFAULT_ID = "0";
    private static int count = 0;
    private String id;

    /**
     * Parameterless Ctor.
     */

    public Dog(){
        this.name = DEFAULT_DOG_NAME;
        this.id = "D" + getCount();
    }
    public Dog(String name){
        this.name = name;
        this.id = "D" + ++count;
    }

    public void bark(){
        System.out.println("Wuff");
    }

    public String getID() {
        return id;
    }

    public static int getCount(){
        return count;
    }

}
