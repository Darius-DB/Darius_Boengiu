package ro.sci.tema07_java_oop_homework.phone.phone_actions;


public class Message {

    private String phoneNumber;
    private String content;


    public Message(String phoneNumber, String content) {
        this.phoneNumber = phoneNumber;
        this.content = content;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber=" + this.getPhoneNumber() +
                ", content='" + content + '\'' +
                '}';
    }
}
