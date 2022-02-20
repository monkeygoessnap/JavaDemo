package model.client;

public class Vip extends Client{

    public Vip(String firstName, String lastName, String pin, String username) {
        super(firstName, lastName, pin, username);
    }

    public void setType(){
        this.type = "vip";
    }
}
