package com.company.Week3.Task2;

public class Money implements Comparable<Money> {
    private int number;
    private String curr;
    private int amnt;
    static final String tenge = "TNG";
    static final String ruble = "RBL";
    static final String dollar = "DLR";
    static final String euro = "EURO";

    public Money(int amnt, String curr, int number) {
        this.amnt = amnt;
        this.curr = curr;
        this.number = number;
    }

    @Override
    public String toString() {
        return number + " pieces " + amnt + " " + curr + " bills = "
                + inTenge() + " tenge";
    }


    @Override
    public int compareTo(Money S){
        if(inTenge() > S.inTenge())
            return 1;
        else if(inTenge() < inTenge())
            return -1;
        return 0;
    }

    public double inTenge(){
        if(curr.equals("TNG"))
            return this.amnt  * this.number;
        else if(curr.equals("RBL"))
            return (this.amnt * 6.1) * this.number;
        else if(curr.equals("DLR"))
            return (this.amnt * 384.0) * this.number;
        else if(curr.equals("EURO"))
            return (this.amnt * 431.0)  * this.number;
        return 0;
    }
}
