package com.company.ClassesInCollection;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private Integer id; //The field cannot be null, the field value must be greater than 0, The value of this field must be unique, the value of this field must be generated automatically
    private String name; //The field cannot be null, the string cannot be empty
    private Coordinates coordinates; //The field cannot be null
    private java.time.ZonedDateTime creationDate; //The field cannot be null, the value of this field must be generated automatically
    private float height; //The field value must be greater than 0
    private int weight; //The field value must be greater than 0
    private String passportID; //The string cannot be empty, the value of this field must be unique, the field cannot be null
    private Country nationality; //The field cannot be null
    public Location location; //The field cannot be null

    static public ArrayList<Double> uniqueLocations = new ArrayList<Double>();
    static public HashSet<String> uniquePassID = new HashSet<String>();
    private static int idCounter=1;
    private static String creationDateTime;
    static {
        ZonedDateTime ztm = ZonedDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss - Z");
        creationDateTime = ztm.format(myFormatObj);
    }

    public Person(String name, Coordinates coordinates, float height, int weight, String passportID, Country nationality, Location location) {
        this.id = idCounter++;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate = ZonedDateTime.now(); // Create a date object
        this.height=height;
        this.weight=weight;
        this.passportID=passportID;
        this.nationality=nationality;
        this.location=location;
        uniquePassID.add(this.getPassportID());
        uniqueLocations.add(this.giveLocationMetric());
    }
    public Person(int id, String name, Coordinates coordinates, float height, int weight, String passportID, Country nationality, Location location) {
        this.id = id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate = ZonedDateTime.now(); // Create a date object
        this.height=height;
        this.weight=weight;
        this.passportID=passportID;
        this.nationality=nationality;
        this.location=location;
        uniquePassID.add(this.getPassportID());
        uniqueLocations.add(this.giveLocationMetric());
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    public float getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }
    public String getPassportID(){
        return passportID;
    }
    public Country getNationality(){
        return nationality;
    }
    public Location getLocation(){
        return this.location;
    }
    public static int getIdCounter() {return Person.idCounter;}
    public static String getCreationDateTime(){return creationDateTime;}

    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public static void setIdCounter(int idCounter) {
        Person.idCounter = idCounter;
    }
    public static void setCreationDateTime(String creationDateTime){Person.creationDateTime=creationDateTime;}

    @Override
    public String toString() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss - Z");
        String formattedDate = this.creationDate.format(myFormatObj);
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", " + coordinates +
                ", creationDate=" + formattedDate +
                ", height=" + height +
                ", weight=" + weight +
                ", passportID='" + passportID + '\'' +
                ", nationality=" + nationality +
                ", " + location +
                '}';
    }


    public double giveLocationMetric(){
        return this.location.getZ()*this.location.getX()*this.location.getY();
    }

    @Override
    public int compareTo(Person otherGuy) {
        return Integer.compare(getWeight(), otherGuy.getWeight());
    }
}

