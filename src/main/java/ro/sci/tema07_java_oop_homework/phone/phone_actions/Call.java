package ro.sci.tema07_java_oop_homework.phone.phone_actions;

import ro.sci.tema07_java_oop_homework.contact.Contact;

public class Call {

    private String phoneNumber;
    private String hourCalled;


    public Call(String phoneNumber, String hourCalled) {
        this.hourCalled = hourCalled;
        this.phoneNumber =phoneNumber;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Call{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", hourCalled='" + hourCalled + '\'' +
                '}';
    }
}
