package at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your weight in kg:");
        String input = in.next();
        double weight = Double.parseDouble(input);

        System.out.print("Enter your  in cm:");
        input = in.next();
        double height = Double.parseDouble(input);

        double bmi;
        bmi = weight / (Math.pow((height/100),2));
        System.out.println(String.format("Your Bodymass Index is: %.2f", bmi));

        if(bmi < 18.5){
            System.out.println("You are underweight :(");
        }else if(bmi >= 18.5 && bmi < 25){
            System.out.println("You are normal weight :)");
        }else{
            System.out.println("You are overweight :(");
        }

    }
}
