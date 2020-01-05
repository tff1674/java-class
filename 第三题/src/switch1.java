import java.util.Scanner;
import java.util.Random;
public class switch1 {
//    void competition(int machine){
//
//    }
    public static void main(String[] args) {
        while(true){
            Random  random = new Random();
            System.out.print("请输入数字，1代表剪刀，2代表石头，3代表布,0表示结束:");
            System.out.print("\n");
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            if(a!=0) {
                switch (a) {
                    case 1:
                        int m = random.nextInt(3) + 1;
                        if (m == 1) {
                            System.out.println("你出的是剪刀，电脑出的是剪刀，结局是平局");
                        } else if (m == 2) {
                            System.out.println("你出的是剪刀，电脑出的是石头，结局是你输了");
                        } else if (m == 3) {
                            System.out.println("你出的是剪刀，电脑出的是布，结局是你赢了");
                        }
                        break;
                    case 2:
                        int n = random.nextInt(3) + 1;
                        if (n == 1) {
                            System.out.println("你出的是石头，电脑出的是剪刀，结局是你赢了");
                        } else if (n == 2) {
                            System.out.println("你出的是石头，电脑出的是石头，结局是平局");
                        } else if (n == 3) {
                            System.out.println("你出的是石头，电脑出的是布，结局是你输了");
                        }
                        break;
                    case 3:
                        int p = random.nextInt(3) + 1;
                        if (p == 1) {
                            System.out.println("你出的是布，电脑出的是剪刀，结局是你输了");
                        } else if (p == 2) {
                            System.out.println("你出的是布，电脑出的是石头，结局是你赢了");
                        } else if (p == 3) {
                            System.out.println("你出的是布，电脑出的是布，结局是平局");
                        }
                        break;


                }
            }
            else{
                break;
            }

            }
            }
    }

