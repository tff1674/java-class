public class two {
    static double x;
    int y;
    void get1(double x,int y){  //实例方法
        two.x=x;
        this.y=y;
    }
    static void get(double a){   //类方法
        x=a;
    }
}
class get{
    public static void main(String []args){
        two t=new two();
        t.get1(5.8,6);
        t.get(6.6);
        System.out.println("x的值为："+t.x);
        System.out.println("y的值为："+t.y);
    }
}
