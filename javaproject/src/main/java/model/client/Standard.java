package model.client;

public class Standard extends Client{

    public Standard(String firstName, String lastName, String pin, String username) {
        super(firstName, lastName, pin, username);
    }

    public void setType(){
        this.type = "standard";
    }

}
