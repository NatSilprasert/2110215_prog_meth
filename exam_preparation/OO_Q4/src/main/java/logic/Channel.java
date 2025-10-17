package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Channel {
    private String name;
    ArrayList<Message> messageList;

    public Channel(String name) {
        setName(name);
        this.messageList = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        this.messageList.add(message);
    }

    public void setName(String name) {
        this.name = name.isBlank() ? "off-topic" : name;
    }

    public int getMessageCount() {
        return this.messageList.size();
    }

    public String getName() {
        return name;
    }
    public ArrayList<Message> getMessageList() {
        return messageList;
    }
}
