package model.account;

public class CurrentAcc extends Account{
    
    public CurrentAcc(String owner, String accNum, int bal){
        super(owner, accNum, bal);
    }

    public void setType(){
        this.type = "currentacc";
    }

    public void setDefaultLimit(){
        this.wdLimit = 20000;
        this.txLimit = 100000;
    }

}
