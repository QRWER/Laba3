import functions.*;
public class Main {
    public static void main(String[] args) {
       double[] value = {1, 2, 3, 4, 5};
       TabulatedFunction obj = new TabulatedFunction(5, 7, value);
       obj.addPoint(new FunctionPoint(1.5,4));
       obj.out();
    }
}