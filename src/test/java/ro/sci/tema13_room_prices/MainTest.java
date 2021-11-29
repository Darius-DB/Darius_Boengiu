package ro.sci.tema13_room_prices;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class MainTest {
    Connection conn;

    @Before
    public void setUp() throws Exception {
        //create h2 DB
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE", "sa", "");
            Statement statement1 = conn.createStatement();
            Statement statement2 = conn.createStatement();
            Statement statement3 = conn.createStatement();


            statement1.execute("CREATE TABLE accomodation\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    type character varying(32) NOT NULL,\n" +
                    "    bed_type character varying(32) NOT NULL,\n" +
                    "    max_guests integer NOT NULL,\n" +
                    "    description character varying(512) NOT NULL,\n" +
                    "    CONSTRAINT accomodation_pkey PRIMARY KEY (id)\n" +
                    ");");


            statement2.execute("CREATE TABLE room_fare\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    value double precision,\n" +
                    "    season character varying(32) ,\n" +
                    "    CONSTRAINT room_fare_pkey PRIMARY KEY (id)\n" +
                    ");");


            statement3.executeUpdate("CREATE TABLE accomodation_fare_relations (\n" +
                    "  id integer,\n" +
                    "  id_accomodation integer NOT NULL,\n" +
                    "  id_room_fare integer NOT NULL,\n" +
                    "  PRIMARY KEY (id),\n" +
                    "  FOREIGN KEY (id_accomodation) REFERENCES accomodation(id)\n" +
                    "                        ON DELETE CASCADE,\n" +
                    "  FOREIGN KEY (id_room_fare) REFERENCES room_fare(id)\n" +
                    "                        ON DELETE CASCADE\n" +
                    ");");


            insertDataIntoAccommodation(conn);
            insertDataIntoRoomFare(conn);
            insertDataIntoAccommodationFareRelation(conn);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void insertDataIntoAccommodation(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO accomodation VALUES (?, ?, ?, ?, ?)");

        insertRowIntoAccommodation(ps, 1, "single", "standard", 1, "desc");
        insertRowIntoAccommodation(ps, 2, "double", "double", 2, "desc1");
        insertRowIntoAccommodation(ps, 3, "triple", "queen", 3, "desc");
        insertRowIntoAccommodation(ps, 4, "quad", "king", 4, "desc");
        insertRowIntoAccommodation(ps, 5, "king", "king", 2, "desc");
        insertRowIntoAccommodation(ps, 6, "queen", "queen", 2, "desc");

    }

    private void insertRowIntoAccommodation(
            PreparedStatement ps,
            int id,
            String type,
            String bed_type,
            int max_guests,
            String description) throws SQLException {

        ps.setInt(1, id);
        ps.setString(2, type);
        ps.setString(3, bed_type);
        ps.setInt(4, max_guests);
        ps.setString(5, description);

        ps.executeUpdate();

    }

    private void insertDataIntoRoomFare(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO room_fare VALUES (?, ?, ?)");

        insertRowIntoRoomFare(ps, 1, 100, "spring");
        insertRowIntoRoomFare(ps, 2, 200, "spring");
        insertRowIntoRoomFare(ps, 3, 300, "spring");
        insertRowIntoRoomFare(ps, 4, 400, "spring");

        insertRowIntoRoomFare(ps, 5, 150, "summer");
        insertRowIntoRoomFare(ps, 6, 250, "summer");
        insertRowIntoRoomFare(ps, 7, 350, "summer");
        insertRowIntoRoomFare(ps, 8, 450, "summer");

        insertRowIntoRoomFare(ps, 9, 200, "fall");
        insertRowIntoRoomFare(ps, 10, 300, "fall");
        insertRowIntoRoomFare(ps, 11, 400, "fall");
        insertRowIntoRoomFare(ps, 12, 500, "fall");

        insertRowIntoRoomFare(ps, 13, 250, "winter");
        insertRowIntoRoomFare(ps, 14, 350, "winter");
        insertRowIntoRoomFare(ps, 15, 450, "winter");
        insertRowIntoRoomFare(ps, 16, 550, "winter");

    }

    private void insertRowIntoRoomFare(PreparedStatement ps, int id, double value, String season) throws SQLException {
        ps.setInt(1, id);
        ps.setDouble(2, value);
        ps.setString(3, season);

        ps.executeUpdate();
    }

    private void insertDataIntoAccommodationFareRelation(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO accomodation_fare_relations VALUES (?,?,?)");

        insertRowIntoAccommodationFareRelation(ps, 1, 1, 1);
        insertRowIntoAccommodationFareRelation(ps, 2, 1, 5);
        insertRowIntoAccommodationFareRelation(ps, 3, 1, 9);
        insertRowIntoAccommodationFareRelation(ps, 4, 1, 13);

        insertRowIntoAccommodationFareRelation(ps, 5, 2, 2);
        insertRowIntoAccommodationFareRelation(ps, 6, 2, 6);
        insertRowIntoAccommodationFareRelation(ps, 7, 2, 10);
        insertRowIntoAccommodationFareRelation(ps, 8, 2, 14);

        insertRowIntoAccommodationFareRelation(ps, 9, 3, 3);
        insertRowIntoAccommodationFareRelation(ps, 10, 3, 7);
        insertRowIntoAccommodationFareRelation(ps, 11, 3, 11);
        insertRowIntoAccommodationFareRelation(ps, 12, 3, 15);

        insertRowIntoAccommodationFareRelation(ps, 13, 4, 4);
        insertRowIntoAccommodationFareRelation(ps, 14, 4, 8);
        insertRowIntoAccommodationFareRelation(ps, 15, 4, 12);
        insertRowIntoAccommodationFareRelation(ps, 16, 4, 16);

        insertRowIntoAccommodationFareRelation(ps, 17, 5, 2);
        insertRowIntoAccommodationFareRelation(ps, 18, 5, 6);
        insertRowIntoAccommodationFareRelation(ps, 19, 5, 10);
        insertRowIntoAccommodationFareRelation(ps, 20, 5, 14);

        insertRowIntoAccommodationFareRelation(ps, 21, 6, 2);
        insertRowIntoAccommodationFareRelation(ps, 22, 6, 6);
        insertRowIntoAccommodationFareRelation(ps, 23, 6, 10);
        insertRowIntoAccommodationFareRelation(ps, 24, 6, 14);

    }

    private void insertRowIntoAccommodationFareRelation(PreparedStatement ps, int id, int id_accommodation, int id_room_fare) throws SQLException {
        ps.setInt(1, id);
        ps.setInt(2, id_accommodation);
        ps.setInt(3, id_room_fare);

        ps.executeUpdate();
    }


    @Test
    public void testSelect() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT " +
                "accomodation.type," +
                "room_fare.value," +
                "room_fare.season " +
                "FROM accomodation_fare_relations " +
                "JOIN accomodation ON accomodation.id = accomodation_fare_relations.id_accomodation " +
                "JOIN room_fare ON room_fare.id = accomodation_fare_relations.id_room_fare");
        ResultSet resultSet =  ps.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("type"));
            System.out.println(resultSet.getDouble("value"));
            System.out.println(resultSet.getString("season"));
            System.out.println("-------------------------");
            System.out.println("-------------------------");
        }
    }


//    @Test
//    public void testSelect2() throws SQLException
//    {
//        PreparedStatement ps = conn.prepareStatement("select * from accomodation");
//        ResultSet resultSet = ps.executeQuery();
//        while (resultSet.next()) {
//            int value = resultSet.getInt("id");
//            String season = resultSet.getString("type");
//            System.out.println(value + " : " + season);
//        }
//    }
//
//    @Test
//    public void testSelect3() throws SQLException
//    {
//        PreparedStatement ps = conn.prepareStatement("select * from accomodation_fare_relations");
//        ResultSet resultSet = ps.executeQuery();
//        while (resultSet.next()) {
//            int value = resultSet.getInt("id");
//            System.out.println(value);
//
//        }
//    }
//
//    @Test
//    public void testSelect4() throws SQLException
//    {
//        PreparedStatement ps = conn.prepareStatement("select * from room_fare");
//        ResultSet resultSet = ps.executeQuery();
//        while (resultSet.next()) {
//            int value = resultSet.getInt("value");
//            String season = resultSet.getString("season");
//            System.out.println(value + " : " + season);
//        }
//    }
}