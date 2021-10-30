package ro.sci.tema10_ski_biathlon_standings.athlete;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;


public class Athlete implements Comparable<Athlete> {

    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private Duration skiTimeResults;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    private Duration finalResults;

    public Athlete(int athleteNumber, String athleteName, String countryCode, Duration skiTimeResults,
                   String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResults = skiTimeResults;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;

        this.finalResults = calculateFinalResults();
    }

    private Duration calculateFinalResults() {
        long totalPenalties = getTotalPenalties();

        return skiTimeResults.plusSeconds(totalPenalties * 10);

    }

    protected long getTotalPenalties() {
        int countFirstShootingRange = StringUtils.countMatches(firstShootingRange, "o");
        int countSecondShootingRange = StringUtils.countMatches(secondShootingRange, "o");
        int countThirdShootingRange = StringUtils.countMatches(thirdShootingRange, "o");

        return countFirstShootingRange + countSecondShootingRange + countThirdShootingRange;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public Duration getFinalResults() {
        return finalResults;
    }

    public Duration getSkiTimeResults() {
        return skiTimeResults;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResults=" + skiTimeResults + '\'' +
                ", finalResults=" + finalResults +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;

        Athlete athlete = (Athlete) o;

        if (athleteNumber != athlete.athleteNumber) return false;
        if (!athleteName.equals(athlete.athleteName)) return false;
        if (!countryCode.equals(athlete.countryCode)) return false;
        if (!skiTimeResults.equals(athlete.skiTimeResults)) return false;
        if (!firstShootingRange.equals(athlete.firstShootingRange)) return false;
        if (!secondShootingRange.equals(athlete.secondShootingRange)) return false;
        if (!thirdShootingRange.equals(athlete.thirdShootingRange)) return false;
        return finalResults.equals(athlete.finalResults);
    }

    @Override
    public int hashCode() {
        int result = athleteNumber;
        result = 31 * result + athleteName.hashCode();
        result = 31 * result + countryCode.hashCode();
        result = 31 * result + skiTimeResults.hashCode();
        result = 31 * result + firstShootingRange.hashCode();
        result = 31 * result + secondShootingRange.hashCode();
        result = 31 * result + thirdShootingRange.hashCode();
        result = 31 * result + finalResults.hashCode();
        return result;
    }

    @Override
    public int compareTo(Athlete o) {
        return this.finalResults.compareTo(o.finalResults);
    }
}
