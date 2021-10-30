package ro.sci.tema10_ski_biathlon_standings.athlete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AthleteRepository {
    private static List<Athlete> athleteList = new ArrayList<>();

    public static void addAthletes() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/ro/sci/tema10_ski_biathlon_standings/standings.csv"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                try {
                    athleteList.add(getAthleteFromCsvLine(line));
                }
                catch (IllegalArgumentException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Athlete getAthleteFromCsvLine(String line) {

        String[] athleteAttributes = line.split(",");

        if (athleteAttributes.length != 7) {
            throw new IllegalArgumentException("Corrupted data");
        }

        int athleteNumber = Integer.parseInt(athleteAttributes[0].trim());

        Duration duration = getSkiTimeResults(athleteAttributes[3]);

        return new Athlete(
                athleteNumber,
                athleteAttributes[1].trim(),
                athleteAttributes[2].trim(),
                duration,
                athleteAttributes[4].trim(),
                athleteAttributes[5].trim(),
                athleteAttributes[6].trim()
        );

    }

    private static Duration getSkiTimeResults(String athleteAttribute) {
        String[] components = athleteAttribute.trim().split(":");
        String durationStr = String.format("PT%sM%sS", components[0].trim(), components[1].trim());
        return Duration.parse(durationStr);
    }

    public static void showAthletes() {
        System.out.println(sortAthletes());
    }

    public static void showPodium() {
        List<Athlete> athletes = sortAthletes();

        if (athletes.size() >= 3) {
            System.out.println("Winner - " + athletes.get(0).getAthleteName() + " "
                    + athletes.get(0).getFinalResults() + " (" +
                    athletes.get(0).getSkiTimeResults() + " + "
                    + athletes.get(0).getTotalPenalties() * 10 + ")");

            System.out.println("Runner-up - " + athletes.get(1).getAthleteName() + " "
                    + athletes.get(1).getFinalResults() + " (" +
                    athletes.get(1).getSkiTimeResults() + " + "
                    + athletes.get(1).getTotalPenalties() * 10 + ")");

            System.out.println("Third place - " + athletes.get(2).getAthleteName() + " "
                    + athletes.get(2).getFinalResults() + " (" +
                    athletes.get(2).getSkiTimeResults() + " + "
                    + athletes.get(2).getTotalPenalties() * 10 + ")");
        }
    }

    private static List<Athlete> sortAthletes() {
        List<Athlete> athletes = new ArrayList<>(athleteList);
        Collections.sort(athletes);
        return athletes;
    }

    public static List<Athlete> getAthleteList() {
        return Collections.unmodifiableList(athleteList);
    }
}
