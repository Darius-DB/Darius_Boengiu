package ro.sci.tema13_room_prices;


import ro.sci.tema13_room_prices.accommodation.CreateAccommodationTable;
import ro.sci.tema13_room_prices.accommodation.InsertDataIntoAccommodationTable;
import ro.sci.tema13_room_prices.accommodation_fare_relation.CreateAccommodationFareRelationTable;
import ro.sci.tema13_room_prices.accommodation_fare_relation.InsertDataIntoAccommodationFareRelationTable;
import ro.sci.tema13_room_prices.room_fare.CreateRoomFareTable;
import ro.sci.tema13_room_prices.room_fare.InsertDaraIntoRoomFareTable;
import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.*;

public class Main {

    static String queryDatabase =
            "SELECT " +
                    "accommodation.type," +
                    "room_fare.value," +
                    "room_fare.season " +
                    "FROM accommodation_fare_relation " +
                    "JOIN accommodation ON accommodation.id = accommodation_fare_relation.id_accommodation " +
                    "JOIN room_fare ON room_fare.id = accommodation_fare_relation.id_room_fare"
            ;

    public static void main(String[] args) {
        CreateAccommodationTable.createAccommodationTable();
        InsertDataIntoAccommodationTable.insertDataIntoAccommodationTable();

        CreateRoomFareTable.createRoomFareTable();
        InsertDaraIntoRoomFareTable.insertDataIntoRoomFareTable();

        CreateAccommodationFareRelationTable.createAccommodationFareRelationTable();
        InsertDataIntoAccommodationFareRelationTable.insertDataIntoAFRTable();

        try (Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS);
             Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(queryDatabase);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("type"));
                System.out.println(resultSet.getDouble("value"));
                System.out.println(resultSet.getString("season"));
                System.out.println("-------------------------");
                System.out.println("-------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
