package model.account;

public abstract class Account {

    String owner, accNum, type; 
    int bal, wdLimit, txLimit;

    public Account(String owner, String accNum, int bal) {
        this.owner = owner;
        this.accNum = accNum;
        this.bal = bal;
        this.setType();
        this.setDefaultLimit();
    }

    public String getOwner(){
        return this.owner;
    }

    public String getAccNum(){
        return this.accNum;
    }

    public int getBal(){
        return this.bal;
    }

    public void setBal(int newBal){
        this.bal = newBal;
    }

    public int getWdLimit(){
        return this.wdLimit;
    }

    public void setWdLimit(int newLimit){
        this.wdLimit = newLimit;
    }
    
    public int getTxLimit(){
        return this.txLimit;
    }

    public void setTxLimit(int newLimit) {
        this.txLimit = newLimit;
    }

    public String toString(){
        return "owner: "+ this.owner + " accnum: " + this.accNum + " acctype: " + this.type + " bal: " + this.bal;
    }

    abstract void setType();
    abstract void setDefaultLimit();
}
