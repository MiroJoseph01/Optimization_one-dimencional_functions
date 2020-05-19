import Function.FunctionExecute;
import Interval.Interval;
import Optimization_methods.GoldenSection;
import Optimization_methods.HalfDivision;

public class App {
    public static void main(String[] args) throws Exception {
        CalculateYourVariant(6);
        //function that's given
        FunctionExecute function = new FunctionExecute((x)->(Math.pow((x/5),x-1)));
        //find interval
        Interval interval = new Interval(function);
        interval.findInterval(4,0.2);
        Interval interval2 = new Interval(function);
        interval2.findInterval(4,0.2);
        //method of gold section
        GoldenSection goldenSection = new GoldenSection(interval,(Math.pow(10,-6)),function);
        //find only for min (interval also min)
        goldenSection.find(false);
        System.out.println(goldenSection.toString());
        //method of half division
        HalfDivision halfDivision = new HalfDivision(interval2,(Math.pow(10,-6)),function);
        halfDivision.find(true);
        System.out.print(halfDivision.toString());

    }

    public static void CalculateYourVariant(int N){
        System.out.printf("num_of_fun = %d, num_of_method = %d\n",
                (N-1)%6+1, 1+((N-1)/6));
    }
}