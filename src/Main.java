import functions.*;
public class Main {
    public static void main(String[] args) {
        try {
            double[] values = {1, 2, 3, 4, 5};
            TabulatedFunction test = new LinkedListTabulatedFunction(0, 4, values);
            test.addPoint(new FunctionPoint(5, 1));
            test.deletePoint(0);
            test.setPoint(0, new FunctionPoint(0, 0));
            for(int i = 0; i<test.getPointsCount(); i++) {
                System.out.println(test.getPointX(i));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}