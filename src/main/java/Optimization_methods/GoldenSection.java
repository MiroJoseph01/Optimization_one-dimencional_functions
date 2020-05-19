package Optimization_methods;

import Function.FunctionExecute;
import Interval.Interval;

public class GoldenSection {
    private Interval i;
    private double pres;
    private double res_x;
    private double res_y;
    private FunctionExecute f;

    private static final double proportion = (1 + Math.sqrt(5)) / 2;

    public GoldenSection(Interval i, double pres, FunctionExecute f){
        this.i=i;
        this.pres=pres;
        this.f=f;
        res_x=0;
        res_y=0;
    }

    public GoldenSection find(boolean printing){
        double x1, x2;
        if(printing){ printHead();}
        int itterations = 1;
        do {
            x1 = i.getB() - (i.getB() - i.getA()) / proportion;
            x2 = i.getA() + (i.getB() - i.getA()) / proportion;
            if(printing){
                printing(i.getA(), x1, x2, i.getB(), f.apply(x1), f.apply(x2), itterations);}
            if (f.apply(x1) >= f.apply(x2))
                i.setA(x1);
            else
                i.setB(x2);
            itterations++;
        } while (!(Math.abs(i.getB() - i.getA()) < pres));
        res_x=(i.getA() + i.getB()) / 2;
        res_y=f.apply(res_x);
        return this;
    }

    private void printing(double ... p){
        StringBuilder res = new StringBuilder();
        for(double i:p) {
            res.append(String.format("%.5g", i)).append("|");
        }
        res.append("\n___________________________________________________\n");
        System.out.print(res.toString());
    }

    @Override
    public String toString() {
        return "GoldenSectionResult" +
                "x=" + res_x +
                ", y=" + res_y;
    }

    public void printHead(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("%6s", "a")).append("|")
                .append(String.format("%6s", "x1")+"|")
                .append(String.format("%6s", "x2")+"|")
                .append(String.format("%6s", "b")+"|")
                .append(String.format("%7s", "f1")+"|")
                .append(String.format("%7s", "f2")+"|")
                .append(String.format("%6s", "itter")+"|\n");
        System.out.print(res.toString());
    }
}
