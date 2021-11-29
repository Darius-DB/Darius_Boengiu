package ro.sci.tema12_festival_statistics;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        FestivalGate gate = new FestivalGate();
        final FestivalAttendeeThread[] festivalAttendee = new FestivalAttendeeThread[1];
        final TicketType[] ticketType = new TicketType[1];
        Thread generateAttendees = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    ticketType[0] = TicketType.randomTicket();
                    festivalAttendee[0] = new FestivalAttendeeThread(ticketType[0], gate);
                    festivalAttendee[0].start();
                    try {
                        festivalAttendee[0].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate, generateAttendees);
        statsThread.start();
        generateAttendees.start();

    }
}
