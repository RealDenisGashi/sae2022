package at.ac.fhwn.sae.lesson3;

public class Cat extends Animal{

    private static final String  CLASS_DESCRIPTION = "This is a cat class";
    public static final String DEFAULT_CAT_NAME = "default cat name";
    private static final String DEFAULT_ID = "0";
    private static int count = 0;
    private String id;

    /**
     * Parameterless Ctor.
     */

    public Cat(){
        this.name = DEFAULT_CAT_NAME;
        this.id = "D" + getCount();
    }
    public Cat(String name){
        this.name = name;
        this.id = "D" + ++count;
    }

    public String getID() {
        return id;
    }
    public static int getCount(){
        return count;
    }

}