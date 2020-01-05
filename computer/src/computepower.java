public class computepower {
    static void multiple(double x1,double x2){
        System.out.print("平方后得到的值为："+x1*x1);
        System.out.println(" "+x2*x2);
        System.out.println("两个参数的值分别为："+x1+" "+x2);
    }
    static void multiple(){
        //parameter i=new parameter();
        System.out.print("平方后得到的值为："+parameter.a*parameter.a);
        System.out.println(" "+parameter.b*parameter.b);
        System.out.println("两个参数的值分别为："+parameter.a+" "+parameter.b);
    }
}
class parameter{
    static double a;
    static double b;
}
class computepowertest{
    public static void main(String []args){
        double c=1.2;
        double d=2.0;
        computepower cp=new computepower();
        cp.multiple(c,d);
        System.out.println(c);
        System.out.println(d);
        parameter pr=new parameter();
        pr.a=6.0;
        pr.b=1.5;
        cp.multiple();
        System.out.println(pr.a);
        System.out.println(pr.b);
        pr.a=pr.a*pr.a+pr.b*pr.b;
        System.out.println(pr.a);

    }
}