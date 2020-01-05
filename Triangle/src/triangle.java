import java.util.Scanner;
public class triangle {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入三角形的三条边：");
        double a=input.nextDouble();
        double b=input.nextDouble();
        double e=input.nextDouble();
        trian tr = new trian();
        tr.changetriangle(a, b, e);
        tr.circum();
        tr.istriangle();
        System.out.println("请输入圆的半径：");
        double d=input.nextDouble();
        Circle ci=new Circle();
        ci.Circle(d);
        ci.S();
        System.out.println("请输入圆锥的半径和高：");
        double f=input.nextDouble();
        double g=input.nextDouble();
        Cone c=new Cone();
        c.Cone(f,g);
        c.scone();

    }
}
    class trian{
        double edge1;
        double edge2;
        double edge3;
        double circumference;
        public trian(){}
        public void changetriangle(double e1,double e2,double e3){
            edge1=e1;
            edge2=e2;
            edge3=e3;
        }
        public double circum(){
            circumference=edge1+edge2+edge3;
            System.out.println("三角形的周长为："+circumference);
            return circumference;
        }
        public boolean istriangle(){
            if((edge1+edge2>edge3)&&(Math.abs(edge1-edge2)<edge3)){
                return true;}
            else{
                System.out.println("三角形不存在");
                return false;}
        }
    }
    class Circle{
         double radius;
         double area;
         public Circle(){}
         public void Circle(double r){
             radius=r;
         }
         public double S(){
             area=Math.PI*radius*radius;
             System.out.println("圆的面积为："+area);
             return area;
         }
        }
    class Cone{
         double radius;
         double length;
         double scone;
         public Cone(){}
         public void Cone(double r,double l)
         {
             radius=r;
             length=l;
         }
         public double scone(){
             scone=Math.PI*radius*radius*length/3;
             System.out.println("圆锥体的体积为:"+scone);
             return scone;
         }
    }
