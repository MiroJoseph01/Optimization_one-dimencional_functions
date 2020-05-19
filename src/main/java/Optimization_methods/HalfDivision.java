package Optimization_methods;

import Function.FunctionExecute;
import Interval.Interval;
import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class HalfDivision {
    private Interval i;
    private double pres;
    private double res_x;
    private double res_y;
    private FunctionExecute f;

    public HalfDivision(Interval i, double pres, FunctionExecute f){
        this.i=i;
        this.pres=pres;
        this.f=f;
        res_x=0;
        res_y=0;
    }

    public void find(boolean printing){
        double h,x1,x2,x3, itt=1;
        if (printing)
            printHead();
        do {
            h = (i.getB()-i.getA())/4;
            x1 = i.getA()+h;
            x2= x1+h;
            x3= x2+h;
            if(printing){
            new Util().printing(i.getA(), x1,x2,x3,i.getB(),
                    f.apply(x1),f.apply(x2),f.apply(x3), itt);}

        if(f.apply(x1)>f.apply(x2)&&f.apply(x2)>f.apply(x3)){
            i.setA(x2);
        }
        else if (f.apply(x1)<f.apply(x2)&&f.apply(x2)<f.apply(x3)) {
           i.setB(x2);
        }
        else {
            i.setA(x1);
            i.setB(x3);
        }
        itt++;
        }while(Math.abs(i.getB()-i.getA())<pres
                &&Math.abs(f.apply(i.getB()-i.getA()))<f.apply(pres));

        res_y=Math.min(Math.min(f.apply(x1),f.apply(x2)),f.apply(x3));
        res_x= (double) Stream.of(x1,x2,x3).filter(x->f.apply(x)==res_y).toArray()[0];
    }


    public void printHead(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("%6s", "a")).append("|")
                .append(String.format("%6s", "x1")+"|")
                .append(String.format("%6s", "x2")+"|")
                .append(String.format("%6s", "x3")+"|")
                .append(String.format("%6s", "b")+"|")
                .append(String.format("%7s", "f1")+"|")
                .append(String.format("%7s", "f2")+"|")
                .append(String.format("%7s", "f3")+"|")
                .append(String.format("%6s", "itter")+"|\n");
        System.out.print(res.toString());
    }

    @Override
    public String toString() {
        return "HalfDivisionResult\t" +
                "x=" + res_x +
                ", y=" + res_y+"\n";
    }
}
