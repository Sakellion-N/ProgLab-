package com.company.CommandCenter;

import com.company.ClassesInCollection.Coordinates;
import com.company.ClassesInCollection.Country;
import com.company.ClassesInCollection.Location;
import com.company.ClassesInCollection.Person;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static com.company.ReaderWriter.XMLWriter.write;

public class ScriptCommands implements CommandsInterf {
    public static void help() {
        System.out.println("This program has lists of people sorted by weight. the commands are as follows:");
        System.out.println("help: display help for available commands");
        System.out.println("info: output to the standard output stream information about the collection (type, initialization date, number of elements)");
        System.out.println("show: output to the standard output stream all the elements of the collection in a string representation");
        System.out.println("add {element}: add a new element to the collection");
        System.out.println("update {id} {element}: update the value of a collection element whose id is equal to the specified one");
        System.out.println("remove_by_id {id}: remove an item from the collection by its id");
        System.out.println("clear: clear the collection");
        System.out.println("save: save the collection to a file");
        System.out.println("execute_script file_name: read and execute the script from the specified file. The script contains commands in the same form as the user enters them interactively.");
        System.out.println("exit: exit the program (without saving it to a file)");
        System.out.println("head: output the first element of the collection");
        System.out.println("remove_greater {element}: remove all elements that exceed the specified value(weight) from the collection");
        System.out.println("history: output the last 15 commands (without their arguments)");
        System.out.println("filter_greater_than_location location: output elements whose location field value is greater than the specified value");
        System.out.println("print_unique_location: print the unique values of the location field of all items in the collection");
        System.out.println("print_field_descending_passport_i_d: print the values of the passportID field of all elements in descending order");
        System.out.println("For all commands, no input(\"\") gives null value. A lot of the fields cannot be null.");
        System.out.println("For all commands, empty spaces at the start and the end will be trimmed. ('a '=='  a  '=='a')");
    }
    public static void info(PriorityQueue<Person> people) {
        System.out.println("Type: " + people.getClass().getName());
        System.out.println("Initialization date: " + Person.getCreationDateTime());
        System.out.println("number of elements: " + people.size());
    }
    public static void show(PriorityQueue<Person> people) {
        if (people.size() != 0) {
            for (Person person : people) {
                System.out.println(person);
                System.out.println("End of list.");
            }
        } else {System.out.println("The list is empty.");}

    }

    public static PriorityQueue<Person>  add(PriorityQueue<Person> people, String data) {
        try {
            System.out.println("New person data, as per script are:\n"+data);
            String[] commands = data.split("\n");
            String name =commands[0];
            Integer corX= Integer.parseInt(commands[1]);
            Long corY= Long.parseLong(commands[2]);
            ZonedDateTime dateTime = ZonedDateTime.now();
            float height= Float.parseFloat(commands[3]);
            int weight= Integer.parseInt(commands[4]);
            String passportID = commands[5];
            Country nationality = null;
            for (Country var: Country.values()){
                if (var.toString().equals(commands[6])){
                    nationality=var;
                    break;
                }
            }
            int locX = Integer.parseInt(commands[7]);
            double locY= Double.parseDouble(commands[8]);
            Float locZ= Float.parseFloat(commands[9]);
            String locName= commands[10];
            if (locName.equals("")){
                locName=null;
            }
            Coordinates c= new Coordinates(corX,corY);
            Location l = new Location(locX,locY,locZ,locName);
            Person p = new Person(name,c,height,weight,passportID,nationality,l);
            System.out.println("New person added. Person details are:\n" + p);
            people.add(p);
        } catch (Exception e){
            System.out.println("There was an error with the script. Person not added");
        }
        return people;
    }
    public static PriorityQueue<Person> update_id(PriorityQueue<Person> people, int id, String data) {
        Person person = Commands.find_id(people, id);
        if (person == null) {
            System.out.println("There is no person with this id.");
        } else {
            try {
                Person.uniquePassID.remove(person.getPassportID());
                Person.uniqueLocations.remove(person.giveLocationMetric());
                System.out.println("Person found. Details are:\n" + person);

                System.out.println("New person data, as per script are:\n" + data);
                String[] commands = data.split("\n");
                String name = commands[0];
                Integer corX = Integer.parseInt(commands[1]);
                Long corY = Long.parseLong(commands[2]);
                ZonedDateTime dateTime = ZonedDateTime.now();
                float height = Float.parseFloat(commands[3]);
                int weight = Integer.parseInt(commands[4]);
                String passportID = commands[5];
                Country nationality = null;
                for (Country var : Country.values()) {
                    if (var.toString().equals(commands[6])) {
                        nationality = var;
                        break;
                    }
                }
                int locX = Integer.parseInt(commands[7]);
                double locY = Double.parseDouble(commands[8]);
                Float locZ = Float.parseFloat(commands[9]);
                String locName = commands[10];
                if (locName.equals("")) {
                    locName = null;
                }
                Coordinates c = new Coordinates(corX, corY);
                Location l = new Location(locX, locY, locZ, locName);
                person.setName(name);
                person.setCoordinates(c);
                person.setHeight(height);
                person.setWeight(weight);
                person.setPassportID(passportID);
                person.setNationality(nationality);
                person.setLocation(l);
                Person.uniquePassID.add(person.getPassportID());
                Person.uniqueLocations.add(person.giveLocationMetric());
                System.out.println("New details added. Person details are:\n" + person);
            } catch (Exception e){
                System.out.println("There was an error updating the entry. Person not updated.");
            }
        }
        return people;
    }
    public static PriorityQueue<Person> remove_by_id(PriorityQueue<Person> people, int id) {
        Person person = Commands.find_id(people, id);
        if (person == null) {
            System.out.println("There is no person with this id.");
        } else {
            Person.uniquePassID.remove(person.getPassportID());
            System.out.println("Person found. Details were:\n" + person + "\nPerson is removed.");
            people.remove(person);
        }
        return people;
    }
    public static PriorityQueue<Person> clear(PriorityQueue<Person> p) {
        p.clear();
        System.out.println("The List is now empty.");
        return p;
    }
    public static void save(PriorityQueue<Person> p) {
        write(p);
    }
    public static PriorityQueue<Person> head(PriorityQueue<Person> people) {
        if (people.size() != 0) {
            System.out.println(people.element());
        }
        return people;
    }
    public static PriorityQueue<Person> remove_greater(PriorityQueue<Person> people, int weight){
        people.removeIf(person -> person.getWeight() > weight);
        System.out.println("Removed people with weight greater than: "+weight);
        return people;
    }
    public static void history(LinkedList<String> h){
        System.out.println("The last 15 commands are:");
        for (String command: h) {
            System.out.println("'" +command+"'" );
        }
        System.out.println("End of list");
    }
    public static void filter_greater_than_location(PriorityQueue<Person> people, double value){
        System.out.println("People with location greater than '"+value+"' are:");
        for (Person p: people) {
            if (p.giveLocationMetric()>value){
                System.out.println(p);
            }
        }
        System.out.println("End of list.");
    }
    public static void print_unique_location(){
        if (Person.uniqueLocations.size()!=0) {
            HashSet<Double> u = new HashSet<Double>(Person.uniqueLocations);
            System.out.println("The Unique locations are:");
            for (Double l : u) {
                System.out.println("'" + l + "'");
            }
            System.out.println("End of list.");
        } else {
            System.out.println("There are no locations saved.");
        }
    }
    public static void print_field_descending_passport_i_d(){
        if (Person.uniquePassID.size()!=0) {
            LinkedList<String> id = new LinkedList<String>(Person.uniquePassID);
            Collections.sort(id);
            System.out.println("Descending order of saved passports:");
            for (String s : Person.uniquePassID) {
                System.out.println("'"+id.removeLast()+"'");
            }
            System.out.println("End of list.");
        } else {
            System.out.println("There are no Passports in this list.");
        }
    }
}
