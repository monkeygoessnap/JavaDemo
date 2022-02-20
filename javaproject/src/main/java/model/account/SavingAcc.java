package model.account;

public class SavingAcc extends Account {

    public SavingAcc(String owner, String accNum, int bal){
        super(owner, accNum, bal);
    }

    public void setType(){
        this.type = "savingacc";
    }

    public void setDefaultLimit(){
        this.wdLimit = 10000;
        this.txLimit = 50000;
    }

}
