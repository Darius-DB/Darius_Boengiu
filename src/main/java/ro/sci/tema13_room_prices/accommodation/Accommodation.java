package ro.sci.tema13_room_prices.accommodation;

public class Accommodation {
    private int id;
    private String type;
    private String bed_type;
    private int max_guests;
    private String description;

    public Accommodation(int id, String type, String bed_type, int max_guests, String description) {
        this.id = id;
        this.type = type;
        this.bed_type = bed_type;
        this.max_guests = max_guests;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBed_type() {
        return bed_type;
    }

    public int getMax_guests() {
        return max_guests;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
