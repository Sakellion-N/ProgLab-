package com.company.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerMethods {

    public static String inputParser(String message, boolean cannotBeNull){
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String output = "";
        do {
            if (message!=null){
                System.out.println(message);
            }
            try {
                output = input.nextLine();  // Read user input
            } catch (InputMismatchException exception) {
                System.out.println("There was an input error. Try again.");
            }
        } while ((output.trim().length() == 0)&&(cannotBeNull));
        if (output.trim().length()==0){output=null;}
        return output;
    }

    public static boolean checkInt(String str) throws NumberFormatException{
        boolean bool = false;
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e){
            bool=true;}
        return bool;
    }
    public  static int convertInt(String str) {
        return Integer.parseInt(str);   }

    public static boolean checkLong(String str) throws NumberFormatException{
        boolean bool = false;
        try {
            long l = Long.parseLong(str);
        } catch (NumberFormatException e){
            bool=true;}
        return bool;
    }
    public  static long convertLong(String str) {
        return Long.parseLong(str);   }

    public static boolean checkFloat(String str) throws NumberFormatException{
        boolean bool = false;
        try {
            float f = Float.parseFloat(str);
        } catch (NumberFormatException e){
            bool=true;}
        return bool;
    }
    public  static float convertFloat(String str) {
        return Float.parseFloat(str);   }

    public static boolean checkDouble(String str) throws NumberFormatException{
        boolean bool = false;
        try {
            double f = Double.parseDouble(str);
        } catch (NumberFormatException e){
            bool=true;}
        return bool;
    }
    public  static double convertDouble(String str) {
        return Double.parseDouble(str);   }
}
