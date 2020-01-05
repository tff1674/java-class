public class divide {
    public static void main(String[] args){
        int a=0;
        for(int i=1;i<=100;i++){
            if(a<5) {
                if (i % 3 == 0) {
                    System.out.println(i);
                    a++;
                }
            }
        }
    }
}
