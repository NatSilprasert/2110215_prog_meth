package logic;

import java.util.ArrayList;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template) {
        this.channelList = new ArrayList<Channel>();
        this.memberList = new ArrayList<User>();

        this.owner = owner;
        memberList.add(owner);
        owner.addJoinedServersList(this);

        setName(name);

        if (template == TemplateType.BASIC) {
            channelList.add(new Channel("general"));
        }
        else if (template == TemplateType.GAMING) {
            channelList.add(new Channel("gaming"));
        }
        else if (template == TemplateType.STUDY) {
            channelList.add(new Channel("homework-help"));
        }
    }

    public Channel addChannel(User user, String channelName) {
        if (user == this.owner) {
            Channel channel = new Channel(channelName);
            this.channelList.add(channel);
            return channel;
        }
        return null;
    }

    public User addUser(User user) {
        if (!this.memberList.contains(user)) {
            this.memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }
        return null;
    }

    public boolean kickUser(User kicker, User kicked) throws Exception {
        if (kicker != this.owner) {
            throw new Exception();
        }
        else {
            if  (!this.memberList.contains(kicked) || kicked == this.owner) {
                return false;
            }
            else {
                kicked.getJoinedServersList().remove(this);
                this.memberList.remove(kicked);
                return true;
            }
        }
    }

    public void setName(String name) {
        this.name = name.isBlank() ? this.owner.getName() + " home" : name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public boolean isMemberInServer(User user) {
        return this.memberList.contains(user);
    }
}
