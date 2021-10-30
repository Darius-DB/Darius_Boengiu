package ro.sci.tema10_ski_biathlon_standings.athlete;

import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.*;

public class AthleteRepositoryTest {

    @Test
    public void testCsvInput() {
        String inputLine = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        Athlete result = AthleteRepository.getAthleteFromCsvLine(inputLine);

        assertEquals(11, result.getAthleteNumber());
        assertEquals("Umar Jorgson", result.getAthleteName());
        assertEquals("SK", result.getCountryCode());
        assertEquals(Duration.parse("PT30M27S"), result.getSkiTimeResults());
        assertEquals("xxxox", result.getFirstShootingRange());
        assertEquals("xxxxx", result.getSecondShootingRange());
        assertEquals("xxoxo", result.getThirdShootingRange());

        assertEquals(Duration.parse("PT30M57S"), result.getFinalResults());
    }

    @Test
    public void testCsvInputWithSpace() {
        String inputLine = "  11  ,  Umar Jorgson  ,  SK  ,  30:27  ,  xxxox  ,  xxxxx , xxoxo ";

        Athlete result = AthleteRepository.getAthleteFromCsvLine(inputLine);

        assertEquals(11, result.getAthleteNumber());
        assertEquals("Umar Jorgson", result.getAthleteName());
        assertEquals("SK", result.getCountryCode());
        assertEquals(Duration.parse("PT30M27S"), result.getSkiTimeResults());
        assertEquals("xxxox", result.getFirstShootingRange());
        assertEquals("xxxxx", result.getSecondShootingRange());
        assertEquals("xxoxo", result.getThirdShootingRange());

        assertEquals(Duration.parse("PT30M57S"), result.getFinalResults());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCsvInputInvalid() {
        String inputLine = "  11  ,  Umar Jorgson  ,  SK  ,  30:27  ,  xxxox  ,  xxxxx";

        Athlete result = AthleteRepository.getAthleteFromCsvLine(inputLine);

        assertEquals(11, result.getAthleteNumber());
        assertEquals("Umar Jorgson", result.getAthleteName());
        assertEquals("SK", result.getCountryCode());
        assertEquals(Duration.parse("PT30M27S"), result.getSkiTimeResults());
        assertEquals("xxxox", result.getFirstShootingRange());
        assertEquals("xxxxx", result.getSecondShootingRange());
        assertEquals("xxoxo", result.getThirdShootingRange());

        assertEquals(Duration.parse("PT30M57S"), result.getFinalResults());
    }

    @Test
    public void testAddAthletes() {
        AthleteRepository.addAthletes();
        assertEquals(3, AthleteRepository.getAthleteList().size());
    }



}