package com.company.CommandCenter;

import com.company.ClassesInCollection.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


import static com.company.Tools.IsStringX.isStringDouble;
import static com.company.Tools.IsStringX.isStringInt;
import static com.company.Tools.ScannerMethods.convertDouble;
import static com.company.Tools.ScannerMethods.convertInt;
import static com.company.CommandCenter.ScriptCommands.*;

public class ScriptExecutor {
    public static PriorityQueue<Person> executeScript(String filepath, PriorityQueue<Person> people) {
        BufferedReader file;
        try {
//            filepath="C:\\JavaOutputsInputs\\SakellionNikolaos\\progLab5\\script1.txt";
            file = new BufferedReader(new FileReader(filepath));
            String command = file.readLine();
            System.out.println("Line from script: \""+command+"\"");
            while ((command!=null)) {
                String[] part = command.split(" ", 2);
                switch (part[0]) {
                    case "":
                        break;
                    case "help":
                        help();
                        break;
                    case "info":
                        info(people);
                        break;
                    case "show":
                        show(people);
                        break;
                    case "add":
                        String data="";
                        for(int i = 0; i < 11; ++i){
                            command = file.readLine();
                            data+= command+"\n";
                        }
                        people = add(people,data);
                        break;
                    case "update":
                        if (isStringInt(part[1].trim())) {
                            data= "";
                            for(int i = 0; i < 11; ++i){
                                command = file.readLine();
                                data+= command+"\n";
                            }
                            people = update_id(people, convertInt(part[1]), data);
                        } else {
                            System.out.println("Script did not provide a valid integer.");
                        }
                        break;
                    case "remove_by_id":
                        if (isStringInt(part[1].trim())) {
                            remove_by_id(people, convertInt(part[1]));
                        } else {
                            System.out.println("Script did not provide a valid integer.");
                        }
                        break;
                    case "clear":
                        people = clear(people);
                        break;
                    case "save":
                        save(people);
                        break;
                    case "execute_script":
                        System.out.println("Script cannon call further scripts.");
                        break;
                    case "head":
                        people = head(people);
                        break;
                    case "remove_greater":
                        if (isStringInt(part[1].trim())) {
                            people = remove_greater(people, convertInt(part[1]));
                        } else {
                            System.out.println("Script did not provide a valid integer.");
                        }
                        break;
                    case "history":
                        history(CommandConsole.commandHistory);
                        break;
                    case "filter_greater_than_location":
                        if (isStringDouble(part[1].trim())) {
                            filter_greater_than_location(people, convertDouble(part[1]));
                        } else {
                            System.out.println("Script did not provide a valid double.");
                        }
                        break;
                    case "print_unique_location":
                        print_unique_location();
                        break;
                    case "print_field_descending_passport_i_d":
                        print_field_descending_passport_i_d();
                        break;
                    case "exit":
                        System.exit(1);
//                            Commands.exit();
//                        System.out.println("Exiting the program without saving.");
                        break;
                    default:
                        System.out.println("Command was not recognised");
                }
                command= file.readLine();
                System.out.println("Line from script: \""+command+"\"");
            }
            file.close();
        }
        catch (IndexOutOfBoundsException e){
                System.out.println("There was an error with the script command. Ignoring command.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        } catch (IOException e) {
            System.out.println("There was an error handling the file.");
        } catch (NullPointerException e){
            System.out.println("Command is null.");
        }

    System.out.println("Script executed.");
    return people;
    }
}
