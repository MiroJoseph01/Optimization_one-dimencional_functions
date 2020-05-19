package Interval;

import Function.FunctionExecute;

public class Interval {
    public static final String POSITIVE_DIRECTION = "Positive_Direction";
    public static final String AROUND_POINT = "Around_Point";
    public static final String NEGATIVE_DIRECTION = "Negative_Direction";
    public static final String ERROR = "Error";

    private double a;
    private double b;
    private FunctionExecute f;

    public Interval(double a, double b){
        this.a =a;
        this.b =b;
    }

    public Interval(FunctionExecute f){
        a=0;
        b=0;
        this.f=f;
    };


    //getters/setters
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    //main functions
    public void findInterval(double startPoint, double h) throws Exception {
        switch (findDirection(startPoint,h)){
            case POSITIVE_DIRECTION:{
            findHelper(startPoint,h);
            }break;
            case NEGATIVE_DIRECTION:{
                findHelper(startPoint, -h);
            }break;
            case AROUND_POINT: {
                a=startPoint-Math.abs(h);
                b=startPoint+Math.abs(h);
            }break;
            case ERROR: throw new Exception("Something wrong with interval");
        }
    }

    private void findHelper(double startPoint, double h){
        double hk=h;
        double xk0=startPoint;
        double xk1=startPoint+hk;
        double xk_1=startPoint-h;
        while(! (f.apply(xk1)>f.apply(xk0))){
            hk=2*hk;
            xk_1=xk0;
            xk0=xk1;
            xk1=xk0+hk;
        }
        a= Math.min(xk_1, xk1);
        b=Math.max(xk_1, xk1);
    }

    private String findDirection(double startPoint, double h){
        double Fx0 = f.apply(startPoint);
        double Fx1 = f.apply(startPoint+h);
        if(Fx1<Fx0)
            return POSITIVE_DIRECTION;
        else if(Fx1>Fx0){
            h=-h;
            double newFx1=f.apply(startPoint+h);
            if(newFx1>Fx0){
                return AROUND_POINT;
            }
            else {
                return NEGATIVE_DIRECTION;
            }
        }
        else{
            return ERROR;
        }
    }

    @Override
    public String toString() {
        return "IntervalOfFunction.Interval[" +
                a +
                ", " +
                b +
                ']';
    }
}

