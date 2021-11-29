package ro.sci.tema13_room_prices.accommodation_fare_relation;

import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataIntoAccommodationFareRelationTable {

    public static void insertDataIntoAFRTable() {
        try (Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS)){
            insertDataIntoAccommodationFareRelation(connection);
//            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void insertDataIntoAccommodationFareRelation(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO accommodation_fare_relation VALUES (?,?,?)");

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

    private static void insertRowIntoAccommodationFareRelation(PreparedStatement ps, int id, int id_accommodation, int id_room_fare) throws SQLException {
        ps.setInt(1, id);
        ps.setInt(2, id_accommodation);
        ps.setInt(3, id_room_fare);

        ps.executeUpdate();
    }
}
