package com.company.Week3.Task2;

public class Wallet implements Comparable<Wallet> {
    private Money[] money;
    private int size = 0;
    private int currentSize = 5;

    public Wallet(){this.money =  new Money[currentSize]; }

    public Wallet(int size) {
        this.size = size;
        this.money =  new Money[currentSize];
    }

    public Money get(int index){
        return money[index];

    }

    public void increse(){
        this.currentSize += 10;
        Money []money1 = new Money[currentSize];

        for(int i =0; i < size; i++)
            money1[i] = money[i];

        this.money = money1;
    }

    public void add(Money M){
        if(size >= currentSize)
            increse();
        money[size] = M;
        ++size;
    }

    public double Sum(){
        double sum = 0;
        for(int i = 0; i < size; i++){
            sum += money[i].inTenge();
        }
        return sum;
    }

    public int size(){
        return size;
    }
    
    public void sort(){
        Money temp;
        int done = 0;
        int i;
        for (i = size - 1; i >= 0; i--){
//            System.out.println("i = " + i);
            for (int j = 0; j < i; j++){
                if(money[j].compareTo(money[j+1]) > 0){
                    temp = money[j];
                    money[j] = money[j+1];
                    money[j+1] = temp;
                    done += 1;
                }
            }
            if(done == 0) break;

            done = 0;
        }
    }

    @Override
    public String toString() {
        return "Wallet = " + Sum() + " tenge";
    }

    @Override
    public int compareTo(Wallet S){
        if(Sum() > S.Sum())
            return 1;
        else if(Sum() < S.Sum())
            return -1;
        return 0;
    }
}
