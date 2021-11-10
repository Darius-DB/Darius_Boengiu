package ro.sci.tema11_java8.person;

import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonRepoTest {


    @Test
    public void testCsvInput() throws IOException {
        String inputLine = "John  , Doe, 01-10-2010";

        Person result = PersonRepo.getPersonFromCsvLine(inputLine);

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(LocalDate.of(2010, 10, 1), result.getDateOfBirth());

    }


    @Test(expected = IOException.class)
    public void testCsvInputInvalid() throws IOException {
        String inputLine = "John  , Doe,";

        Person result = PersonRepo.getPersonFromCsvLine(inputLine);

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(LocalDate.of(2010, 10, 1), result.getDateOfBirth());
    }


}