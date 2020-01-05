import java.util.Scanner;
public class sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组数据：");
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] b = new int[arr.length];
        for (int j = 0; j < b.length; j++) {
            b[j] = Integer.parseInt(arr[j]);
            //System.out.print(b[j] + " ");
        }
        QuickSort qs=new QuickSort();
        qs.quickSort(b,0,b.length-1);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.print("\n");
        System.out.println("请输入一个数字：");
        int h=scanner.nextInt();
        find fd=new find();
        int position=fd.Find(b,h,0,b.length-1);
        if(position==-1){
            System.out.println("数组中不存在");
        }
        else{
            System.out.println(position);
        }
    }
}
 class QuickSort {

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }
}

class find{
    public static int Find(int[] a,int g,int low,int high){
        if(g>a[high]||g<a[low]||low>high){
            return -1;
        }
        int med=(high+low)/2;
        if(g>a[med]){
            return Find(a,g,med+1,high);
        }
        else if(g<a[med]){
            return Find(a,g,low,med-1);
        }
        else{
            return med;
        }
    }
}
