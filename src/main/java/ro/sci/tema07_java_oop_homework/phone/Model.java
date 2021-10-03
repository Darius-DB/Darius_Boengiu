package ro.sci.tema07_java_oop_homework.phone;

import ro.sci.tema07_java_oop_homework.contact.Contact;
import ro.sci.tema07_java_oop_homework.phone.phone_actions.Call;
import ro.sci.tema07_java_oop_homework.phone.phone_actions.Message;
import ro.sci.tema07_java_oop_homework.util.CheckPhoneNumber;
import ro.sci.tema07_java_oop_homework.util.GetTime;
import ro.sci.tema07_java_oop_homework.util.ImeiGenerator;


import java.util.ArrayList;
import java.util.List;

public class Model extends Manufacturer implements PhoneInterface {

    private int batteryLife;
    private String modelName;
    private String color;
    private String material;
    private long imei;


    private List<Contact> contactList = new ArrayList<>();
    private List<Message> messagesList = new ArrayList<>();
    private List<Call> calls = new ArrayList<>();


    public Model(String modelName, String color, String material, String manufacturer) {
        super(manufacturer);

        this.batteryLife = 100;
        this.modelName = modelName;
        this.color = color;
        this.material = material;
        this.imei = ImeiGenerator.imeiGenerator();

        addModel(this);
    }


    @Override
    public void addContact(int id, String phoneNumber, String firstName, String lastName) {
        if (CheckPhoneNumber.onlyDigits(phoneNumber)) {
            Contact contact = new Contact(id, phoneNumber, firstName, lastName);
            contactList.add(contact);
        } else {
            System.out.println("Phone numbers should contain only digits!");
        }
    }

    @Override
    public void listContacts() {
        System.out.println(contactList);
    }


    public Contact findContactByPhoneNumber(String phoneNumber) {
        Contact foundContact = null;
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                foundContact = contact;
                break;
            }
        }
        return foundContact;
    }


    @Override
    public void sendMessage(String phoneNumber, String message) {
        if (message.length() > 500) {
            System.out.println("Message can't be longer than 500 characters.");
        }

        if (CheckPhoneNumber.onlyDigits(phoneNumber)) {
            Message newMessage = new Message(phoneNumber, message);
            messagesList.add(newMessage);
            this.batteryLife -= 1;
        }
    }


    @Override
    public void listMessages(String phoneNumber) {
        Contact contact = findContactByPhoneNumber(phoneNumber);

        for (Message message : messagesList) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                if (contact != null) {
                    System.out.println(message + " -> " +
                            contact.getLastName() + " " + contact.getFirstName());
                } else {
                    System.out.println(message);
                }
            }
        }

    }


    @Override
    public void call(String phoneNumber) {
        if (CheckPhoneNumber.onlyDigits(phoneNumber)) {
            String callHour = GetTime.getCurrentTime();
            Call newCall = new Call(phoneNumber, callHour);
            calls.add(newCall);
            this.batteryLife -= 2;
        }
    }


    @Override
    public void viewHistory() {
        System.out.println(calls);
    }


    @Override
    public void addModel(Model model) {
        this.getModelList().add(model);
    }



    public String getModelName() {
        return modelName;
    }

    public long getImei() {
        return imei;
    }

    public int getBatteryLife() {
        return batteryLife;
    }


    @Override
    public String toString() {
        return "Model{" +
                "modelName='" + modelName + '\'' +
                '}';
    }
}
