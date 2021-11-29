package ro.sci.tema13_room_prices.room_fare;

public class RoomFare {
    private int id;
    private double value;
    private String season;

    public RoomFare(int id, double value, String season) {
        this.id = id;
        this.value = value;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
