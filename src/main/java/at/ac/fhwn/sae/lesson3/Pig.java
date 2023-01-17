package at.ac.fhwn.sae.lesson3;

public class Pig extends Animal{

    private static final String  CLASS_DESCRIPTION = "This is a pig class";
    public static final String DEFAULT_PIG_NAME = "default pig name";
    private static final String DEFAULT_ID = "0";
    private static int count = 0;
    private String id;

    /**
     * Parameterless Ctor.
     */

    public Pig(){
        this.name = DEFAULT_PIG_NAME;
        this.id = "P" + getCount();
    }
    public Pig(String name){
        this.name = name;
        this.id = "P" + ++count;
    }

    public String getID() {
        return id;
    }

    public static int getCount(){
        return count;
    }

}
