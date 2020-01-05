public class point {
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    point(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
}
class line{
    static void calculate(){
        int X1=point.x1;
        int Y1=point.y1;
        int X2=point.x2;
        int Y2=point.y2;
        double length=Math.sqrt(Math.pow(X1-X2,2)+Math.pow(Y1-Y2,2));
        System.out.println(length);
    }
}
class result{
    public static void main(String []args){
        point p=new point(1,2,3,5);
        line l=new line();
        l.calculate();

    }
}