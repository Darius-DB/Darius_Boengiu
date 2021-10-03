package ro.sci.tema07_java_oop_homework;

import ro.sci.tema07_java_oop_homework.phone.Manufacturer;
import ro.sci.tema07_java_oop_homework.phone.Model;


public class Main {
    public static void main(String[] args) {

//        Model s21 = new Model("S21", "Black", "Glass", "Samsung");
//        Model s20 = new Model("S20", "Grey", "Glass", "Samsung");
//
//        Model iPhone13 = new Model("iPhone 13", "Blue", "Aluminum", "Apple");
//        Model iPhone12 = new Model("iPhone 12", "White", "Ceramic", "Apple");
//
//        System.out.println(s20.getManufacturerName());
//        System.out.println(iPhone12.getManufacturerName());
//        Manufacturer.listModels("Samsung");
//        Manufacturer.listModels("Apple");
//
//        s21.addContact(1, "0987654", "John", "Doe");
//        s21.addContact(3, "539852", "John", "Smith");
//
//
//        s21.addContact(3, "ldghsdklg", "ds", "h");
//
//        s21.sendMessage("539852", "Hello");
//        s21.sendMessage("539852", "there");
//        s21.listMessages("539852");
//
//        s21.call("0987654");
//        s21.call("539852");
//        s21.viewHistory();
//
//
//
//        System.out.println(s20.getImei());
//        System.out.println(s21.getImei());
//        System.out.println(iPhone12.getImei());
//        System.out.println(iPhone13.getImei());
//
//        System.out.println(s21.getBatteryLife());
//        s21.listContacts();
//
//        iPhone12.addContact(s21.getContactList().get(0).getId(),
//                s21.getContactList().get(0).getPhoneNumber(),
//                s21.getContactList().get(0).getFirstName(),
//                s21.getContactList().get(0).getLastName()
//        );
//
//        iPhone12.sendMessage(iPhone12.getContactList().get(0).getPhoneNumber(), "Holla");
//        iPhone12.listMessages(iPhone12.getContactList().get(0).getPhoneNumber());
//
//        iPhone12.call(iPhone12.getContactList().get(0).getPhoneNumber());
//        iPhone12.viewHistory();
//
//
//        iPhone12.listContacts();
//        System.out.println(iPhone12.getBatteryLife());

        System.out.println("--------------------------------------------------------------------");

        Model onePlus9 = new OnePlus9(
                "OnePlus 9",
                "Oceanic Blue",
                "Plastic",
                "OnePlus"
        );

        System.out.println(onePlus9.getManufacturerName());
        Manufacturer.listModels("OnePlus");

        onePlus9.addContact(1, "123", "John", "Smith");
        onePlus9.addContact(2, "321", "Jane", "Smith");

        onePlus9.listContacts();

        onePlus9.sendMessage("123", "Hello");
        onePlus9.sendMessage("123", "there");
        onePlus9.sendMessage("5678", "how are you");
        onePlus9.sendMessage("skdnlg", "gsbgb");
        onePlus9.listMessages("123");
        onePlus9.listMessages("5678");
        onePlus9.listMessages("12343345");
        onePlus9.listMessages("grarheah");

        onePlus9.call("123");
        onePlus9.call("321");
        onePlus9.viewHistory();

        System.out.println(onePlus9.getImei());
        System.out.println(onePlus9.getBatteryLife());

        //onePlus9.sendMessage("123", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjHellogrehgluiarehighjskrhgluieabuerghuierguirehugibreauihgureailbgiulerahbeabugirhgurdnguareuigburlgrebguiarehgirhguigkjhesuigrigireayhianhjseiguehhreauilhguiahreguairbgirnhitriohnraueihgrzi;agznyi;ahgeirhneianhinaehnrigjkhgkdhjfkjghrehgrehgjdnrgjheruighjsndfgshguisrhngjharlgjkrhgajkerhnsghrjsgnjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");




    }
}
