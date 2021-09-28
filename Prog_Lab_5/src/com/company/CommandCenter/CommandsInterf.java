package com.company.CommandCenter;

import com.company.ClassesInCollection.Person;

import java.util.LinkedList;
import java.util.PriorityQueue;

import static com.company.ReaderWriter.XMLWriter.write;

public interface CommandsInterf {
    public static void print_field_descending_passport_i_d() {    }
    public static void print_unique_location(){}
    public static void filter_greater_than_location(PriorityQueue<Person> people, double value){}
    public static void history(LinkedList<String> h){}
    public static PriorityQueue<Person> remove_greater(PriorityQueue<Person> people, int weight){
        return people;
    }
    public static PriorityQueue<Person> head(PriorityQueue<Person> people) {
        return people;
    }
    public static void save(PriorityQueue<Person> p) {    }
    public static PriorityQueue<Person> clear(PriorityQueue<Person> p) {return p;}
    public static PriorityQueue<Person> remove_by_id(PriorityQueue<Person> people, int id) {return people;}
    public static PriorityQueue<Person> update_id(PriorityQueue<Person> people, int id) {return people;}
    public static PriorityQueue<Person>  add(PriorityQueue<Person> people) {return people;}
    public static void show(PriorityQueue<Person> people) {}
    public static void info(PriorityQueue<Person> people) {}
    public static void help() {}
    }
