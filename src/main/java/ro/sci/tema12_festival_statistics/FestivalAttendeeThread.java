package ro.sci.tema12_festival_statistics;


public class FestivalAttendeeThread extends Thread {

    TicketType ticketType;
    FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    @Override
    public synchronized void run() {
        this.festivalGate.getValidatedTickets().add(ticketType);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
