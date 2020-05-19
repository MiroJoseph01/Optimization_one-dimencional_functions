package Util;

public class Util {
    public Util(){}
    public void printing(double... p){
        StringBuilder res = new StringBuilder();
        for(double i:p) {
            res.append(String.format("%.5g", i)).append("|");
        }
        res.append("\n___________________________________________________\n");
        System.out.print(res.toString());
    }
}

