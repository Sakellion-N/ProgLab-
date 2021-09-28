package com.company.ReaderWriter;

import com.company.ClassesInCollection.Coordinates;
import com.company.ClassesInCollection.Country;
import com.company.ClassesInCollection.Location;
import com.company.ClassesInCollection.Person;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.PriorityQueue;

public class XMLReader {
    private static final String xmlFilePath = "C:\\JavaOutputsInputs\\SakellionNikolaos\\progLab5\\people.xml";

    public static PriorityQueue<Person> xmlReader(){
        PriorityQueue<Person> people = new PriorityQueue<Person>();
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(xmlFilePath));
            String line= file.readLine();
            if (!(line.equals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"))){
                throw new Exception();
            }
            line= file.readLine();
            int idCounter = Integer.parseInt(line.split("\"")[1]);
            String lsCrDate= line.split("\"")[3];
            line= file.readLine();
            while (line!=null){
                if (line.split("\"")[0].equals("  <person id=")){
                    int id;
                    String name;
                    Integer corX;
                    Long corY;
                    ZonedDateTime dateTime;
                    float height;
                    int weight;
                    String passportID;
                    Country nationality = null;
                    int locX;
                    double locY;
                    Float locZ;
                    String locName;

                    id = Integer.parseInt(line.split("\"")[1]);

                    line= file.readLine();
                    name = line.split(">")[1].split("<")[0];

                    line= file.readLine();
                    corX = Integer.parseInt(line.split("=")[1].split(",")[0]);
                    corY = Long.parseLong(line.split("=")[2].split("}")[0]);

                    line= file.readLine();
                    dateTime = ZonedDateTime.parse(line.split(">")[1].split("<")[0]);

                    line= file.readLine();
                    height=Float.parseFloat(line.split(">")[1].split("<")[0]);

                    line= file.readLine();
                    weight=Integer.parseInt(line.split(">")[1].split("<")[0]);

                    line= file.readLine();
                    passportID=line.split(">")[1].split("<")[0];


                    line= file.readLine();
                    line=line.split(">")[1].split("<")[0];
                    for (Country var: Country.values()){
                        if (var.toString().equals(line)){
                            nationality=var;
                            break;
                        }
                    }

                    line= file.readLine();
                    locName=line.split("=")[1].split(",")[0];
                    if (locName.equals("null")){
                        locName=null;
                    }
                    locX=Integer.parseInt(line.split("=")[2].split(",")[0]);
                    locY=Double.parseDouble(line.split("=")[3].split(",")[0]);
                    locZ=Float.parseFloat(line.split("=")[4].split("}")[0]);

                    line= file.readLine();
                    if (!(line.equals("  </person>"))){
                        throw  new Exception();
                    }
                    Coordinates c = new Coordinates(corX, corY);
                    Location l = new Location(locX,locY,locZ,locName);
                    Person p = new Person(id,name, c, height,weight,passportID, nationality,l);
                    people.add(p);
                }
                line= file.readLine();
            }
            Person.setIdCounter(idCounter);
            Person.setCreationDateTime(lsCrDate);
        } catch (Exception e){
            System.out.println("There was a problem reading the file.");
        }

        return people;
    }

}


