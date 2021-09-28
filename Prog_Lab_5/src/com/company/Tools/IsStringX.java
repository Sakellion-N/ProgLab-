package com.company.Tools;

public class IsStringX {
    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
    public static boolean isStringDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
