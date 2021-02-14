import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BankProgram {
    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextAcct = 0;
    private int current = -1;

    private boolean done = false;

    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        program.run();
    }

    public void run() {
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.println("Enter command (0=quit, 1=new acct, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    public void processCommand(int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeloan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else System.out.println("Nonsense");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    private void newAccount() {
        current = nextAcct++;
        accounts.put(current, 0);
        System.out.println("Your current account balance is"+current);
    }

    public void select() {
        System.out.println("Enter acct#: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.println("The balance of the acct"+current+" is "+balance);
    }

    public void deposit(){
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(accounts);
        accounts.put(current, balance+amount);
    }

    public void authorizeloan() {
        System.out.print("Enter loan amount: ");
        int loan = scanner.nextInt();
        int balance = accounts.get(current);
        if (balance >= loan / 2) {
            System.out.println("Loan approved");
        }
        else {
            System.out.println("Access denied");
        }
    }
    private void showAll() {
        Set<Integer> accts = accounts.keySet();
        System.out.println("The bank has "+accts.size()+ "accounts");
        for (int i : accts) {
            System.out.println("\tBank Account "+i+" balance="+accounts.get(i));
        }
}
    private void addInterest() {
        Set<Integer> accts = accounts.keySet();
        for (int i : accts) {
            int balance = accounts.get(i);
            int newbalance = (int) (balance * (1 + rate));
            accounts.put(i, newbalance);
        }
    }
}
