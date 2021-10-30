package ro.sci.tema10_ski_biathlon_standings;

import ro.sci.tema10_ski_biathlon_standings.athlete.AthleteRepository;


public class Main {
    public static void main(String[] args) {


        AthleteRepository.addAthletes();
        AthleteRepository.showAthletes();
        AthleteRepository.showPodium();
    }
}
