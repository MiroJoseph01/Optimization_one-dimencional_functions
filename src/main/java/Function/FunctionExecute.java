package Function;

public class FunctionExecute {
    private Function f;
    public FunctionExecute(Function f){
        this.f = f;
    }

    public double apply(double x){
        return f.execute(x);
    }

}
