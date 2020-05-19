import Function.FunctionExecute;
import Interval.Interval;
import Optimization_methods.GoldenSection;

public class App {
    public static void main(String[] args) throws Exception {
        //function that's given
        FunctionExecute function = new FunctionExecute((x)->(Math.pow((x/5),x-1)));
        //find interval
        Interval interval = new Interval(function);
        interval.findInterval(4,0.2);
        //method of gold section
        GoldenSection goldenSection = new GoldenSection(interval,(Math.pow(10,-6)),function);
        //find only for min (interval also min)
        goldenSection.find(true);
        System.out.print(goldenSection.toString());
    }
}