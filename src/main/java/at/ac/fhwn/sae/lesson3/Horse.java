package at.ac.fhwn.sae.lesson3;

public class Horse extends Animal{

    private static final String  CLASS_DESCRIPTION = "This is a horse class";
    public static final String DEFAULT_HORSE_NAME = "default horse name";
    private static final String DEFAULT_ID = "0";
    private static int count = 0;
    private String id;

    /**
     * Parameterless Ctor.
     */

    public Horse(){
        this.name = DEFAULT_HORSE_NAME;
        this.id = "H" + getCount();
    }
    public Horse(String name){
        this.name = name;
        this.id = "H" + ++count;
    }

    public String getID() {
        return id;
    }

    public static int getCount(){
        return count;
    }

}
