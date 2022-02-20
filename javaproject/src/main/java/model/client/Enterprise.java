package model.client;

public class Enterprise extends Client{

    public Enterprise(String firstName, String lastName, String pin, String username) {
        super(firstName, lastName, pin, username);
    }

    public void setType(){
        this.type = "enterprise";
    }
}
