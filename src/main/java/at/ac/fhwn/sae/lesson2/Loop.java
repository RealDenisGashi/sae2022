package at.ac.fhwn.sae.lesson2;

public class Loop {
    public static void main(String[] args){

        int month = 7;
        String monthString;

        switch (month){
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid Month";
                break;
        }

//        String monthString = switch (month) {
//            case 1 -> "January";
//            case 2 -> "February";
//            case 3 -> "March";
//            case 4 -> "April";
//            case 5 -> "May";
//            case 6 -> "June";
//            case 7 -> "July";
//            case 8 -> "August";
//            case 9 -> "September";
//            case 10 -> "October";
//            case 11 -> "November";
//            case 12 -> "December";
//            default -> "Invalid Month";
//        };

        System.out.println(monthString);
        System.out.println("");

//        for (int i = 0; i < 10; i++){
//            System.out.println(i);
//        }
        int i = 0;
        while(i<10){
            System.out.println(i);
            i++;
        }
        // i == 10;
        do{
            System.out.println(i);
            i--;
        }while(i>-1);
        // i == -1;

        System.out.println(add(12,3));
        System.out.println(add(12,3,4));
        System.out.println(add("12",3,4));

        int[] intArr = new int[10];
        System.out.println(intArr[0]);
        intArr[0] = 42;

        //foreach-loop:
        for(int value: intArr){
            System.out.println(value);
        }

        System.out.println("Max number: " + getMaxOfBits(4));


    }

    public static long getMaxOfBits(int numberOfBits){
        return getMaxOfBits(1, numberOfBits);
    }

    private static long getMaxOfBits(long number, int numberOfBitsLeft){
        if(numberOfBitsLeft > 0){
            return getMaxOfBits(number*2, --numberOfBitsLeft);
        }
        return number;
    }

    public static int add(int number1, int number2){
        return number1 + number2;
    }

    public static int add(int number1, int number2, int number3){
        return add(add(number1, number2),number3);
    }

    public static int add(String number1, int number2, int number3){
        return add(add(Integer.parseInt(number1), number2),number3);
    }

    public static long getFibonnacci(int position){
        int [] Arr = new int [1000];
        Arr[0] = 0;
        Arr[1] = 1;
        int number1 = Arr[0] + Arr[1];
        for(int i1 = 2; i1 <= position; i1++){
            number1 = number1 + i1;
            Arr[i1] = number1;
        }
        return number1;

    }
}
