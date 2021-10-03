package ro.sci.tema07_java_oop_homework.phone;

public interface PhoneInterface {

    void addContact(int id, String phoneNumber, String firstName, String lastName);

    void listContacts();

    void sendMessage(String phoneNumber, String message);

    void listMessages(String phoneNumber);

    void call(String phoneNumber);

    void viewHistory();

}
