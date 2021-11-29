package ro.sci.tema13_room_prices.room_fare;

import ro.sci.tema13_room_prices.room_fare.RoomFare;
import ro.sci.tema13_room_prices.util.ConnectToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InsertDaraIntoRoomFareTable {

    static RoomFare roomFare1 = new RoomFare(1, 100, "spring");
    static RoomFare roomFare2 = new RoomFare(2, 200, "spring");
    static RoomFare roomFare3 = new RoomFare(3, 300, "spring");
    static RoomFare roomFare4 = new RoomFare(4, 400, "spring");

    static RoomFare roomFare5 = new RoomFare(5, 150, "summer");
    static RoomFare roomFare6 = new RoomFare(6, 250, "summer");
    static RoomFare roomFare7 = new RoomFare(7, 350, "summer");
    static RoomFare roomFare8 = new RoomFare(8, 450, "summer");

    static RoomFare roomFare9 = new RoomFare(9, 200, "fall");
    static RoomFare roomFare10 = new RoomFare(10, 300, "fall");
    static RoomFare roomFare11 = new RoomFare(11, 400, "fall");
    static RoomFare roomFare12 = new RoomFare(12, 500, "fall");

    static RoomFare roomFare13 = new RoomFare(13, 250, "winter");
    static RoomFare roomFare14 = new RoomFare(14, 350, "winter");
    static RoomFare roomFare15 = new RoomFare(15, 450, "winter");
    static RoomFare roomFare16 = new RoomFare(16, 550, "winter");

    static List<RoomFare> roomFareList = Arrays.asList(
            roomFare1, roomFare2, roomFare3, roomFare4, roomFare5, roomFare6, roomFare7, roomFare8,
            roomFare9, roomFare10, roomFare11, roomFare12, roomFare13, roomFare14, roomFare15, roomFare16
    );

    static String sql = "INSERT INTO room_fare VALUES (?, ?, ?)";

   public static void insertDataIntoRoomFareTable() {
       try (
               Connection connection = DriverManager.getConnection(ConnectToDb.DB_URL, ConnectToDb.USER, ConnectToDb.PASS);
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               ){
           for (RoomFare rf : roomFareList) {
                preparedStatement.setInt(1, rf.getId());
                preparedStatement.setDouble(2, rf.getValue());
                preparedStatement.setString(3,rf.getSeason());

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();


       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

   }





}
