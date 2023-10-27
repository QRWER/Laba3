package functions;
public class TabulatedFunction {
    private FunctionPoint[] array;
    private int length;
    public TabulatedFunction(double leftX, double rightX, int pointsCount){
        array = new FunctionPoint[pointsCount+5];
        length = pointsCount;
        double j = (rightX-leftX)/(pointsCount-1);
        for (int i = 0;i<pointsCount;i++){
            array[i] = new FunctionPoint(leftX,0);
            leftX+=j;
        }
    }
    public TabulatedFunction(double leftX, double rightX, double[] values){
        array = new FunctionPoint[values.length+5];
        length = values.length;
        double j = (rightX-leftX)/(values.length-1);
        for (int i = 0;i< values.length;i++){
            array[i] = new FunctionPoint(leftX, values[i]);
            leftX+=j;
        }
    }
    public double getLeftDomainBorder(){
        return array[0].getY();
    }
    public double getRightDomainBorder(){
        return array[length-1].getY();
    }
    public double getFunctionValue(double x){
        if(x>=array[0].getX() & x<=array[length-1].getX()){
            double x1 = array[0].getX();
            double x2 = array[length-1].getX();
            double y1 = getLeftDomainBorder();
            double y2 = getRightDomainBorder();
            return (((x-x1)*(y2-y1))/(x2-x1))-y1;
        }
        else
            return Double.NaN;
    }
    public int getPointsCount(){
        return length;
    }
    public FunctionPoint getPoint(int index){
        FunctionPoint tmp = new FunctionPoint(array[index].getX(), array[index].getY());
        return tmp;
    }
    public void setPoint(int index, FunctionPoint point){
        if(index == length-1 || index == 0){
            if(index == 0 && point.getX() < array[index+1].getX()) {
                array[index] = new FunctionPoint(point);
            }
            else if(point.getX() > array[index-1].getX()){
                array[index] = new FunctionPoint(point);
            }
        }
        else if(point.getX() > array[index-1].getX() && point.getX() < array[index+1].getX()){
            array[index] = new FunctionPoint(point);
        }
    }
    public double getPointX(int index){
        return array[index].getX();
    }
    public void setPointX(int index, double x){
        if(index == length-1 || index == 0){
            if(index == 0 && x < array[index+1].getX()) {
                array[index].setX(x);
            }
            else if(x > array[index-1].getX()){
                array[index].setX(x);
            }
        }
        else if(x > array[index-1].getX() && x < array[index+1].getX()){
            array[index].setX(x);
        }
    }
    public double getPointY(int index){
        return array[index].getY();
    }
    public void setPointY(int index, double y) {
        array[index].setY(y);
    }
    public void deletePoint(int index){
        System.arraycopy(array, index+1, array, index, length-index-1);
        length--;
    }
    public void addPoint(FunctionPoint point){
        int index;
        if(point.getX() <= array[length-1].getX()){
            for(index = 0; point.getX() > array[index].getX(); index++){;}
        }
        else{
            index = length;
        }
        if(length != array.length){
            System.arraycopy(array, index, array, index+1, length-index);
            array[index] = new FunctionPoint(point);
        }
        else {
            FunctionPoint[] NewArray = new FunctionPoint[length+6];
            System.arraycopy(array, 0, NewArray, 0, index);
            NewArray[index] = new FunctionPoint(point);
            System.arraycopy(array, index, NewArray, index+1, length-index);
            array=NewArray;
        }
        length++;
    }
    public void out() {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i].getX() + " ");
            System.out.print(array[i].getY());
            System.out.println();
        }
    }
}
