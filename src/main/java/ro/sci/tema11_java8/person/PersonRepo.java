package ro.sci.tema11_java8.person;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepo {

    private static List<Person> personsList = new ArrayList<>();
    private static String fullName;

    public static void LoadAndWrite(String inputFilename, int targetMonth, String outputFilename) {
        if (targetMonth < 1 || targetMonth > 12) {
            System.out.println("Month value should be between 1 and 12");
        }

        readPersonsFromCsvFile(inputFilename);
        addFilteredPersonsToCsvFile(outputFilename, targetMonth);
    }

    public static void readPersonsFromCsvFile(String fileName) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/ro/sci/tema11_java8/" + fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    personsList.add(getPersonFromCsvLine(line));
                } catch (IllegalArgumentException e) {
                   e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Person getPersonFromCsvLine(String line) throws IOException {
        String[] persons = line.split(",");

        if (persons.length != 3) {
            throw new IllegalArgumentException("Corrupted data");
        }

        LocalDate dateOfBirth = getDateOfBirth(persons[2]);

        return new Person(persons[0].trim(), persons[1].trim(), dateOfBirth);
    }

    private static LocalDate getDateOfBirth(String person) {
        LocalDate dateOfBirth = null;
        try {
            String birthday = person.trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dateOfBirth = LocalDate.parse(birthday, formatter);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
        return dateOfBirth;
    }


    public static void addFilteredPersonsToCsvFile(String fileName, int month) {
        List<String> personsSortedByName = filterPersonsByMonthThenSortByName(month);
        if (personsSortedByName.isEmpty()) {
            System.out.println("There are no persons born in the " +  month + "th month of any year.");
        } else {
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/main/java/ro/sci/tema11_java8/" + fileName))) {
//            List<String> personsSortedByName = filterPersonsByMonthThenSortByName(month);
                for (String p : personsSortedByName) {
                    bw.write(p + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> filterPersonsByMonthThenSortByName(int month) {
        List<String> sortedPersons = personsList.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == month)
                .map(person -> {
                    fullName = person.getFirstName() + " " + person.getLastName();
                    return fullName;
                })
                .sorted()
                .collect(Collectors.toList());
        return sortedPersons;
    }

    public static List<Person> getPersonsList() {
        return Collections.unmodifiableList(personsList);
    }
}
