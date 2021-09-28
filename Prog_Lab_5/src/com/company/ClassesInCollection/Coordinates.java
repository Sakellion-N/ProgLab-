package com.company.ClassesInCollection;

public class Coordinates {
    private Integer x; //The field cannot be null
    private Long y; //The field cannot be null

    public Coordinates(Integer x, Long y){
        this.x=x;
        this.y=y;
    }
    public Integer getCorX() {
        return x;
    }
    public Long getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }
    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                " x=" + x +
                ", y=" + y +
                '}';
    }
}
