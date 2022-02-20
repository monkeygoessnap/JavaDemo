package model.transaction;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    
    Date dateCreated;
    int amt;
    String owner, to, from, uuid;

    public Transaction(String owner, String to, String from, int amt) {
        this.to = to;
        this.from = from;
        this.amt = amt;
        this.dateCreated = new Date();
        this.owner = owner;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getOwner(){
        return this.owner;
    }

    public String getUUID(){
        return this.uuid;
    }

    public String getTo(){
        return this.to;
    }

    public String getFrom(){
        return this.from;
    }

    public int getAmt(){
        return this.amt;
    }

    public Date getDate(){
        return this.dateCreated;
    }

}
