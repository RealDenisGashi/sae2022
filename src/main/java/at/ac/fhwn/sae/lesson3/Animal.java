package at.ac.fhwn.sae.lesson3;

public abstract class Animal {
    public String name;
    protected String number;

    public abstract String getID();

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


}
