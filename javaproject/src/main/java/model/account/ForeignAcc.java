package model.account;

public class ForeignAcc extends Account{

    public ForeignAcc(String owner, String accNum, int bal){
        super(owner, accNum, bal);
    }

    public void setType(){
        this.type = "foreignacc";
    }

    public void setDefaultLimit(){
        this.wdLimit = 10000;
        this.txLimit = 50000;
    }

}
