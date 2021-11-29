package ro.sci.tema13_room_prices.accommodation;

import ro.sci.tema13_room_prices.accommodation.Accommodation;
import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InsertDataIntoAccommodationTable {

//    static final String DB_URL = "jdbc:postgresql:booking_app";
//    static final String USER = "postgres";
//    static final String PASS = "darius123qaz";

    static Accommodation accommodation1 = new Accommodation(1, "single", "standard", 1, "desc");
    static Accommodation accommodation2 = new Accommodation(2, "double", "double", 2, "desc");
    static Accommodation accommodation3 = new Accommodation(3, "triple", "queen", 3, "desc");
    static Accommodation accommodation4 = new Accommodation(4, "quad", "king", 4, "desc");
    static Accommodation accommodation5 = new Accommodation(5, "king", "king", 2, "desc");
    static Accommodation accommodation6 = new Accommodation(6, "queen", "queen", 2, "desc");

    static List<Accommodation> accommodationList = Arrays.asList(
            accommodation1,
            accommodation2,
            accommodation3,
            accommodation4,
            accommodation5,
            accommodation6
    );

    static String sql = "INSERT INTO accommodation VALUES (?, ?, ?, ?, ?)";

    public static void insertDataIntoAccommodationTable() {
        try (
                Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            for (Accommodation a : accommodationList) {
                preparedStatement.setInt(1, a.getId());
                preparedStatement.setString(2, a.getType());
                preparedStatement.setString(3, a.getBed_type());
                preparedStatement.setInt(4, a.getMax_guests());
                preparedStatement.setString(5, a.getDescription());

                preparedStatement.addBatch();

                preparedStatement.executeBatch();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
