package ro.sci.tema11_java8;

import ro.sci.tema11_java8.person.PersonRepo;

public class Main {
    public static void main(String[] args) {
        PersonRepo.LoadAndWrite("persons.csv", 9, "filtered_persons.csv");

    }
}
