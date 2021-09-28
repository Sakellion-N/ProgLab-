package com.company.CommandCenter;

import com.company.ClassesInCollection.Person;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static com.company.Tools.IsStringX.isStringDouble;
import static com.company.Tools.IsStringX.isStringInt;
import static com.company.Tools.ScannerMethods.*;

public class CommandConsole {
    public static LinkedList<String> commandHistory = new LinkedList <>();

    public static void commandTranslator(PriorityQueue<Person> people) throws IOException {

            String command ="";
            String[] part;
            String message ="Please type a valid command. You can type \'help\' to see available commands or 'exit to close the program";
            while (!command.equals("exit")) {
                command = inputParser(message,true);
                part = command.split(" ", 2);
                commandHistoryAdder(part[0]);
                try {
                    switch (part[0]) {
                        case "": break;
                        case "help":
                            Commands.help();
                            break;
                        case "info":
                            Commands.info(people);
                            break;
                        case "show":
                            Commands.show(people);
                            break;
                        case "add":
                            people= Commands.add(people);
                            break;
                        case "update":
                            if (isStringInt(part[1].trim())){
                                people =Commands.update_id(people, convertInt(part[1]));}
                            else {System.out.println("You did not provide a valid integer. Please try again.");}
                            break;
                        case "remove_by_id":
                            if (isStringInt(part[1].trim())){
                                Commands.remove_by_id(people, convertInt(part[1]));}
                            else {System.out.println("You did not provide a valid integer. Please try again.");}
                            break;
                        case "clear":
                            people = Commands.clear(people);
                            break;
                        case "save":
                            Commands.save(people);
                            break;
                        case "execute_script":
                            people = Commands.execute_script(part[1].trim(),people);
                            break;
                        case "head":
                            people = Commands.head(people);
                            break;
                        case "remove_greater":
                            if (isStringInt(part[1].trim())){
                                people = Commands.remove_greater(people, convertInt(part[1]));}
                            else {System.out.println("You did not provide a valid integer. Please try again.");}
                            break;
                        case "history":
                            Commands.history(commandHistory);
                            break;
                        case "filter_greater_than_location":
                            if (isStringDouble(part[1].trim())){
                                Commands.filter_greater_than_location(people,convertDouble(part[1]));}
                            else {System.out.println("You did not provide a valid double. Please try again.");}
                            break;
                        case "print_unique_location":
                            Commands.print_unique_location();
                            break;
                        case "print_field_descending_passport_i_d":
                            Commands.print_field_descending_passport_i_d();
                            break;
                        case "exit":
//                            Commands.exit();
                            System.out.println("Exiting the program without saving.");
                            System.exit(1);
                            break;
                    }
                }   catch (IndexOutOfBoundsException e) {
                    System.out.println("There was an error with your command. Please try again.");
                    }
                }
    }

    private static void commandHistoryAdder(String command){
        CommandConsole.commandHistory.addLast(command);
        if (CommandConsole.commandHistory.size()>15){CommandConsole.commandHistory.removeFirst();}
    }


}
