package com.company.ClassesInCollection;

public class Location {
    private int x;
    private double y;
    private Float z; //The field cannot be null
    private String name; //The field can be null

    public Location(int x, double y, Float z, String name){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
    }
    public Location(double y, Float z, String name){
        this.y=y;
        this.z=z;
        this.name=name;
    }public Location(int x, Float z, String name){
        this.x=x;
        this.z=z;
        this.name=name;
    }public Location(Float z, String name){
        this.z=z;
        this.name=name;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setZ(Float z) {
        this.z = z;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public Float getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Location name=" + name +
                ", Location x=" + x +
                ", Location y=" + y +
                ", Location z=" + z +
                '}';
    }
}
