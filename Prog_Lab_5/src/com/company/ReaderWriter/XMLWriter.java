package com.company.ReaderWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

import com.company.ClassesInCollection.Person;

public class XMLWriter {
    public static final String xmlFilePath = "C:\\JavaOutputsInputs\\SakellionNikolaos\\progLab5\\people.xml";

    public static void write(PriorityQueue<Person> people) {

        try {

            FileWriter writer = new FileWriter(xmlFilePath);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            buffer.write("<people idCounter=\""+ Person.getIdCounter() +"\" ");
            buffer.write("listCreationDate=\""+Person.getCreationDateTime() +"\">\n");

            for (Person p: people) {
                String indentation= "  ";
                String currentIndent="  ";
                buffer.write(currentIndent+"<person id=\""+p.getId()+"\">\n");
                currentIndent += indentation;
                buffer.write(currentIndent+"<name>"+p.getName()+"</name>\n");
                buffer.write(currentIndent+"<coordinates>"+p.getCoordinates()+"</coordinates>\n");
                buffer.write(currentIndent+"<creationDate>"+p.getCreationDate()+"</creationDate>\n");
                buffer.write(currentIndent+"<height>"+p.getHeight()+"</height>\n");
                buffer.write(currentIndent+"<weight>"+p.getWeight()+"</weight>\n");
                buffer.write(currentIndent+"<passportID>"+p.getPassportID()+"</passportID>\n");
                buffer.write(currentIndent+"<nationality>"+p.getNationality()+"</nationality>\n");
                buffer.write(currentIndent+"<location>"+p.getLocation()+"</location>\n");
                currentIndent = indentation;
                buffer.write(currentIndent+"</person>\n");
                System.out.println("Wrote person "+p.getId());
            }
            buffer.write("</people>");
            buffer.close();
            System.out.println("People successfully saved");

            } catch (IOException e) {
            System.out.println("There was a problem with saving the file.");
        }
    }
}
