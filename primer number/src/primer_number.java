public class primer_number {
    public static void main(String[] args){
        for(int i=101;i<=200;i+=2){
            int total =0;
            int j=2;
            for(j=2;j<=i;j++){
                if(i%j==0) {
                    total++;
                }
            }
            if(total==1){
                System.out.println(i);
            }
        }
    }
}
