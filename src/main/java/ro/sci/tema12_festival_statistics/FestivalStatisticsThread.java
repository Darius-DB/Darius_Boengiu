package ro.sci.tema12_festival_statistics;


public class FestivalStatisticsThread extends Thread {

    private int NR_OF_FULL;
    private int NR_OF_FULL_VIP;
    private int NR_OF_FREE_PASS;
    private int NR_OF_ONE_DAY;
    private int NR_OF_ONE_DAY_VIP;
    private int TOTAL_NUMBER_OF_PEOPLE;

    private FestivalGate gate;
    private Thread generateAttendees;

    public FestivalStatisticsThread(FestivalGate gate, Thread generateAttendees) {
        this.gate = gate;
        this.generateAttendees = generateAttendees;
    }

    @Override
    public void run() {
        boolean shouldStillRun = true;
        while (!generateAttendees.getState().equals(State.TERMINATED) || shouldStillRun) {
            resetCalculations();
            calculateNumberOfEachTicketType();
            calculateNumberOfPeople();
            showStats();

            if(generateAttendees.getState().equals(State.TERMINATED)) {
                shouldStillRun = false;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void resetCalculations() {
        NR_OF_ONE_DAY_VIP = 0;
        NR_OF_ONE_DAY = 0;
        NR_OF_FULL_VIP = 0;
        NR_OF_FULL = 0;
        NR_OF_FREE_PASS = 0;
        TOTAL_NUMBER_OF_PEOPLE = 0;
    }

    private void calculateNumberOfEachTicketType() {
        synchronized (this.gate.getValidatedTickets()) {
            for (TicketType ticketType : this.gate.getValidatedTickets()) {
                if (ticketType.equals(TicketType.FULL)) {
                    NR_OF_FULL += 1;
                } else if (ticketType.equals(TicketType.FULL_VIP)) {
                    NR_OF_FULL_VIP += 1;
                } else if (ticketType.equals(TicketType.FREE_PASS)) {
                    NR_OF_FREE_PASS += 1;
                } else if (ticketType.equals(TicketType.ONE_DAY)) {
                    NR_OF_ONE_DAY += 1;
                } else if (ticketType.equals(TicketType.ONE_DAY_VIP)) {
                    NR_OF_ONE_DAY_VIP += 1;
                }
            }
        }
    }


    private void calculateNumberOfPeople() {
        TOTAL_NUMBER_OF_PEOPLE +=
                NR_OF_FULL +
                        NR_OF_FULL_VIP +
                        NR_OF_FREE_PASS +
                        NR_OF_ONE_DAY +
                        NR_OF_ONE_DAY_VIP
        ;
    }

    public void showStats() {
        System.out.println(
                TOTAL_NUMBER_OF_PEOPLE + " people have entered " + "\n" +
                        NR_OF_FULL + " have full tickets " + "\n" +
                        NR_OF_FREE_PASS + " have free passes " + "\n" +
                        NR_OF_FULL_VIP + " have full vip passes " + "\n" +
                        NR_OF_ONE_DAY + " have one day passes " + "\n" +
                        NR_OF_ONE_DAY_VIP + " have one day vip passes"
        );
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
    }


}
