import server.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Bank newBank = new Bank();
        // newBank.printAcc();
        // newBank.printClient();
        Server bankServer = new Server();
        bankServer.run();
    }
}
