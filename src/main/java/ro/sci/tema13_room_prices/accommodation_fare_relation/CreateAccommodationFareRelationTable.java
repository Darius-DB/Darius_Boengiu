package ro.sci.tema13_room_prices.accommodation_fare_relation;

import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccommodationFareRelationTable {

    public static void createAccommodationFareRelationTable() {
        try (Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS);
             Statement statement = connection.createStatement();
        ){
            String sql = "CREATE TABLE accommodation_fare_relation (\n" +
                    "                    id integer,\n" +
                    "                    id_accommodation integer NOT NULL,\n" +
                    "                    id_room_fare integer NOT NULL,\n" +
                    "                    PRIMARY KEY (id),\n" +
                    "                    FOREIGN KEY (id_accommodation) REFERENCES accommodation(id)\n" +
                    "                      ON DELETE CASCADE,\n" +
                    "                    FOREIGN KEY (id_room_fare) REFERENCES room_fare(id)\n" +
                    "                      ON DELETE CASCADE\n" +
                    "                    );";

            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
