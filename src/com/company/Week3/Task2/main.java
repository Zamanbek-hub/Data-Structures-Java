package com.company.Week3.Task2;

//import com.company.Task3.Task1.Student;
//import com.company.Task3.Task1;
import com.company.Week3.Task1.Vector;

public class main {
    public static void main(String[] args) {
        Vector<Wallet> wallets  = new Vector<>();
        Wallet wallet = new Wallet();
        wallet.add(new Money(50, Money.tenge, 8));
        wallet.add(new Money(130, Money.euro, 3));
        wallet.add(new Money(500, Money.dollar, 3));
        wallet.add(new Money(1000, Money.ruble, 50));
        wallet.add(new Money(1300, Money.dollar, 8));
        wallet.add(new Money(5000, Money.ruble, 5));
        System.out.println(wallet.get(2));
//        System.out.println(wallet);
        System.out.println();
        wallet.sort();
        for(int i = 0; i < wallet.size(); i++)
            System.out.println(wallet.get(i));
        System.out.println(wallet.size());

        Wallet wallet1 = new Wallet();
        wallet1.add(new Money(1300, Money.ruble, 7));
        wallet1.add(new Money(50, Money.dollar, 7));
        wallet1.add(new Money(500, Money.euro, 1));
        wallet1.add(new Money(1000, Money.tenge, 3));
        wallet1.add(new Money(5000, Money.ruble, 4));
        wallet1.sort();
        System.out.println(wallet1);

        wallet.sort();
        for(int i = 0; i < wallet1.size(); i++)
            System.out.println(wallet1.get(i));
        System.out.println(wallet1.size());


        wallets.add(wallet);
        wallets.add(wallet1);
        wallets.sort();
        for(int i = 0; i < wallets.size(); i++)
            System.out.println(wallets.get(i));

    }
}
