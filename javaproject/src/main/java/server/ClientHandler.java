package server;

import controller.*;
import model.client.*;
import model.account.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {

    final DataInputStream din;
    final DataOutputStream dout;
    final Socket s;
    Bank abcBank;

    public ClientHandler(Socket s, DataInputStream din, DataOutputStream dout, Bank abcBank) {
        this.s = s;
        this.din = din;
        this.dout = dout;
        this.abcBank = abcBank;
    }

    public void run(){
        
        //Bank abcBank;
        String input;
        String sessUser;
        Client client;
        LinkedList<Account> accounts;

        // //init data store
        // try {
        //     //abcBank = new Bank();
        //     System.out.println("Datastore init success");
        // } catch(Exception e) {
        //     this.err(e);
        //     return;
        // }

        //main program
        while (true) {
            //landing page, check username
            try {
                dout.writeUTF("Welcome to ABC Bank!\nPlease enter your username: ");
                while (true) {
                    input = din.readUTF();
                    if (!this.abcBank.checkAcc(input)) {
                        dout.writeUTF("Invalid username!\nPlease re-enter: ");
                    } else {
                        sessUser = input;
                        break;
                    }
                }
            } catch (Exception e) {
                this.err(e);
                return;
            }
            //check pin
            try {
                dout.writeUTF("Please enter your pin no.: ");
                while (true) {
                    int exitFlag = 0;
                    input = din.readUTF();
                    if(!this.abcBank.checkPin(sessUser, input)){
                        dout.writeUTF("Invalid Pin\nRe-enter pin no.: ");
                        exitFlag++;
                    }
                    if (exitFlag > 2) {
                        //exits thread if pin wrongly entered more than 3 times
                        dout.writeUTF("Pin has been entered wrongly more than 3 times, exiting.. ");
                        return;
                    } else {
                        client = this.abcBank.getClient(sessUser);
                        accounts = this.abcBank.getAccounts(sessUser);
                        break;
                    }
                }
            } catch (Exception e) {
                this.err(e);
                return;
            }
            //home page
            try {
                while (true) {
                    dout.writeUTF("Welcome! " + client.getName() + "\nWhat would you like to do today?\n1.View Balance\n2.View Transactions\n3.Withdraw Money\n4.Deposit Money\n5.Transfer money\n6.Logout");
                    input = din.readUTF();
                    switch (input) {
                        case "1":
                        dout.writeUTF("Your balance is: " + this.abcBank.getTotalBal(accounts) + "\nEnter to return to main menu.");
                        break;
                        case "2":
                        dout.writeUTF("Your transactions are: \nEnter to return to main menu.");
                        break;
                        case "3":
                        dout.writeUTF("From which account?\nHow much?\nEnter to return to main menu.");
                        break;
                        case "4":
                        dout.writeUTF("To which account?\nHow much?\nEnter to return to main menu.");
                        break;
                        case "5":
                        dout.writeUTF("Transfer to who?\nFrom which account?\nHow much?\nEnter to return to main menu.");
                        break;
                        case "6":
                        dout.writeUTF("Thank you for banking with us.");
                        System.out.println("Client disconnecting..");
                        return;
                        default:
                        dout.writeUTF("Invalid selection.\nEnter to return to main menu.");
                    }
                    din.readUTF();
                }
            } catch (Exception e) {
                this.err(e);
                return;
            }
        }
    }

    public void err(Exception e) {
        e.printStackTrace();
        System.out.println("Error, exiting thread.. ");
    }

}
