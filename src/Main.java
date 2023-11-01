import functions.*;
public class Main {
    public static void main(String[] args) {
        try {
            double[] value = {1, 2, 3, 4, 5};
            TabulatedFunction test1 = new LinkedListTabulatedFunction(1, 5, value);
            TabulatedFunction test2 = new ArrayTabulatedFunction(1, 5, value);
            for(int i = 0; i<test1.getPointsCount(); i++)   {
                if(test1.getPointX(i)==test2.getPointX(i))
                    System.out.println("True");
                else
                    System.out.println("False");
                if(test1.getPointY(i)==test2.getPointY(i))
                    System.out.println("True");
                else
                    System.out.println("False");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}