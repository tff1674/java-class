import java.util.Scanner;
public class scanf {
    public static void main(String[] args){
        int a=0;
        for(int i=0;i<3;i++){
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入1-100的整数：");
            if(scan.hasNextInt()){
                a=scan.nextInt();
                if(a>100 ||a<1){
                    System.out.print("超过输入范围，请输入1到100之间的整数");
                    System.out.print("\n");

                    i=i-1;
                }
                else {
                    System.out.println("整数数据：" + a);
                    System.out.println("这是第" + (i + 1) + "次输入");
                }
            }
            else{
                System.out.print("输入的不是整数");
                System.out.print("\n");

                i--;
            }
        }

    }
}
