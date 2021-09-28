package com.company.Tools;

import com.company.ClassesInCollection.Coordinates;
import com.company.ClassesInCollection.Country;
import com.company.ClassesInCollection.Location;
import com.company.ClassesInCollection.Person;

import java.util.HashSet;

import static com.company.Tools.ScannerMethods.*;

public class PersonAdder {
    public static Person newPerson(){
        return new Person(personName(),personCoordinates(),personHeight(),personWeight(),personPassportID(),personNationality(),personLocation());
    }

    public static String personName(){
        String message="The name can't be empty or only whitespaces.";
        System.out.println("Enter Person's Name.");
        return inputParser(message,true);
    }

    public static Coordinates personCoordinates(){
        String message="You need to input an integer(int). This field cannot be null.";
        System.out.println("Please type person's X coordinate.");
        String input = "";
        do{
            input=inputParser(message,true);
        }while (checkInt(input));
        int x=convertInt(input);

        message="You need to input an integer(long). This field cannot be null.";
        System.out.println("Please type person's Y coordinate.");
        input = "";
        do{
            input=inputParser(message,true);
        }while (checkLong(input));
        long y=convertLong(input);

        return new Coordinates(x,y);
    }

    public static float personHeight(){
        String message="You need to input an number(float). This field cannot be null and must be higher than 0.";
        System.out.println("Please type person's height.");
        String input = "";
        float personHeight = 0;
        do {
            do {
                input = inputParser(message, true);
            } while (checkFloat(input));
            personHeight = convertFloat(input);
        } while(personHeight<=0);
        return personHeight;
    }

    public static int personWeight(){
        String message="You need to input an integer(int). This field cannot be null and must be higher than 0.";
        System.out.println("Please type person's weight.");
        String input = "";
        int personWeight=0;
        do {
            do{
                input=inputParser(message,true);
            }while (checkInt(input));
            personWeight=convertInt(input);
        } while(personWeight<=0);
        return personWeight;
    }

    public static String personPassportID(){
        String input="";
        String message="The name can't be empty or only whitespaces. The passport ID must be unique.";
        System.out.println("Enter Person's passport ID.");
        boolean passCheck;
        do{
            input=inputParser(message,true);
            passCheck=false;
            for (String i: Person.uniquePassID) {
                if (input.equals(i)) {
                    passCheck=true;
                    break;
                }
            }
        } while (passCheck);
        return input;
    }

    public static Country personNationality(){
        Country[] list = Country.values();
        HashSet<String> countriesList = new HashSet<>();
        String input="";
        System.out.println("Please pick the person's nationality from the given list.");
        for (Country var : list) {
            System.out.println(var);
            countriesList.add(var.toString());
        }
        String message="Type the country name as shown. Makes sure to spell it correctly. Capitalisation matters";
        do {
            input = inputParser(message, true);
        } while (!(countriesList.contains(input)));
        Country personNationality = null;
        for (Country var: list){
            if (var.toString().equals(input)){
                personNationality=var;
                break;
            }
        }
        return personNationality;
    }

    public static Location personLocation(){
        String input = "";

        String message="You need to input an integer(int). This field cannot be null";
        System.out.println("Please type person's Location x variable.");
        do{
            input=inputParser(message,true);
        }while (checkInt(input));
        int x = convertInt(input);

        message="You need to input an number(double). This field cannot be null.";
        System.out.println("Please type person's Location y variable");
        do {
            input = inputParser(message, true);
        } while (checkDouble(input));
        double y = convertDouble(input);

        message="You need to input an number(float). This field cannot be null.";
        System.out.println("Please type person's Location z variable.");
        do {
            input = inputParser(message, true);
        } while (checkFloat(input));
        Float z = convertFloat(input);

        message="The name can be null. Simply press the Enter key (\"\") for the null value. The name can't be empty or only whitespaces - These will be considered as a 'null' value.";
        System.out.println("Enter Person's Location Name.");
        input= inputParser(message,false);
        return new Location(x,y,z,input);
    }
}
