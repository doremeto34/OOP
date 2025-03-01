import java.util.Scanner;
public class ArraySum {
	public static void quickSort(double a[],int low,int high) {
		if(high<=low)return;
		int i,j=low;
		double pivot=a[high],temp;
		for(i=low;i<=high;++i) {
			if(a[i]<=pivot) {
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				++j;
			}
		}
		quickSort(a,low,j-2);
		quickSort(a,j,high);
	}
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter array size");
		int n = keyboard.nextInt();
		System.out.println("Enter array elements");
		double[] a = new double[n];
		for(int i=0;i<n;++i) {
			a[i] = keyboard.nextDouble();
		}
		quickSort(a,0,n-1);
		System.out.println("Sorted array");
		double sum=0;
		for(int i=0;i<n;++i) {
			System.out.print(a[i]+" ");
			sum+=a[i];
		}
		System.out.println();
		System.out.print("Average value: "+ (sum/n));
	}

}
