import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
int [] arr1 = new int[n];
int [] arr2 = new int[(n+1)/2];
        int j =0;

for(int i =0; i<n ; i++){
    arr1[i] = sc.nextInt();

    if(i%2 == 0)
    {

        arr2[j] = arr1[i];
        j++;
    }
}
System.out.println("the alternative elements");
for(int i =0; i<j ;i++)
{
    System.out.println(arr2[i]);
}





    }
}