package com.company;
import com.company.CommandCenter.CommandConsole;
import com.company.ClassesInCollection.Person;

import java.io.IOException;
import java.util.PriorityQueue;

import static com.company.ReaderWriter.XMLReader.xmlReader;

public class Main {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Person> people = xmlReader();
        CommandConsole.commandTranslator(people);
    }
}
