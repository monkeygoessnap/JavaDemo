package model.client;

public abstract class Client {

    String firstName, lastName, pin, type, username;

    public Client(String firstName, String lastName, String pin, String username){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.username = username;
        this.setType();
    }

    public String getUser(){
        return this.username;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getPin() {
        return this.pin;
    }

    public String getType() {
        return this.type;
    };

    public String toString(){
        return "username: "+ this.username + " firstname: " + this.firstName + " lastname: " + this.lastName + " pin: " + this.pin;
    }

    abstract void setType();

}
