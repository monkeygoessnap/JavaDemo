package controller;

import model.account.*;
import model.client.*;
import model.transaction.*;

import java.util.*;
import java.io.*;

public class Bank {

    private static final String dataFilePath = "./data/testset_1.csv";

    HashMap<String, LinkedList<Account>> accountStore;
    HashMap<String, Client> clientStore;
    HashMap<String, LinkedList<Transaction>> tStore;

    public Bank(){
        accountStore = new HashMap<String, LinkedList<Account>>();
        clientStore = new HashMap<String, Client>();
        this.load();
    }

    public void load() {
        try{
            //open file scanner
            Scanner sc = new Scanner(new File(dataFilePath));
            //skips file header
            sc.nextLine();
            while (sc.hasNextLine()) {
                //open line scanner
                Scanner ss = new Scanner(sc.nextLine());
                ss.useDelimiter(",");
                //get values from each line
                String username = ss.next();
                String firstName = ss.next();
                String lastName = ss.next();
                String accNum = ss.next();
                String pin = ss.next();
                int bal = ss.nextInt();
                String accType = ss.next();                
                //create new client
                Client newClient = new Standard(firstName, lastName, pin, username);
                //create new account
                Account newAcc;
                switch (accType) {
                    case "SAVINGS":
                    newAcc = new SavingAcc(username,accNum,bal);
                    break;
                    case "CURRENT":
                    newAcc = new CurrentAcc(username,accNum,bal);
                    break;
                    case "FOREIGN":
                    newAcc = new ForeignAcc(username,accNum,bal);
                    break;
                    default:
                    newAcc = new SavingAcc(username,accNum,bal);
                }
                //store in memory hashmap
                this.clientStore.put(username, newClient);
                //checks whether accountStore already has an account tagged to the username, adds to linkedlist if so, if not create new linkedlist and append to it
                LinkedList<Account> acc = this.accountStore.get(username);
                if (acc != null) {
                    acc.add(newAcc);
                } else {
                    LinkedList<Account> newAccLl = new LinkedList<Account>();
                    newAccLl.add(newAcc);
                    this.accountStore.put(username, newAccLl);
                }
                //close line scanner
                ss.close();
            }
            //close file scanner
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void printAcc() throws Exception {
        for(Map.Entry<String,LinkedList<Account>>m:this.accountStore.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue().toString());
        }
    }

    public void printClient() throws Exception {
        for(Map.Entry<String,Client>m:this.clientStore.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue().toString());
        }
    }

    public boolean createClient(){
        return false;
    }

    public boolean deleteClient(){
        return false;
    }

    public boolean checkAcc(String username) {
        return clientStore.get(username) != null;
    }

    public boolean checkPin(String username, String input) {
        return clientStore.get(username).getPin().equals(input);
    }

    public Client getClient(String username) {
        return clientStore.get(username);
    }

    public LinkedList<Account> getAccounts(String username) {
        return accountStore.get(username);
    }

    public int getTotalBal(LinkedList<Account> accounts) {
        int balance = 0;

        for (int i = 0; i < accounts.size();i++){
            balance += accounts.get(i).getBal();
        }
        return balance;
    }

    public int getBal(String username, String accNum) {
        return 1;
    }

}
