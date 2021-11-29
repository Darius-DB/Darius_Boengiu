package ro.sci.tema13_room_prices.accommodation;

import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccommodationTable {



//    static final String DB_URL = "jdbc:postgresql:booking_app";
//    static final String USER = "postgres";
//    static final String PASS = "darius123qaz";

    public static void createAccommodationTable() {
        try (Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS);
             Statement statement = connection.createStatement();
        ) {
            String sql = "CREATE TABLE accommodation\n" +
                    "                    (\n" +
                    "                    id integer NOT NULL,\n" +
                    "                    type character varying(32) NOT NULL,\n" +
                    "                    bed_type character varying(32) NOT NULL,\n" +
                    "                    max_guests integer NOT NULL,\n" +
                    "                    description character varying(512) NOT NULL,\n" +
                    "                    CONSTRAINT accommodation_pkey PRIMARY KEY (id)\n" +
                    "                    );";

            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
