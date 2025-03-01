import java.util.Scanner;
public class AddMatrix {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter matrices size of n * m");
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		double a[][] = new double[n][m],b[][] = new double[n][m];
		System.out.println("Enter the first matrix");
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				a[i][j]=keyboard.nextDouble();
			}
		}
		System.out.println("Enter the second matrix");
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				b[i][j]=keyboard.nextDouble();
			}
		}
		System.out.println("Sum of two matrices");
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				System.out.print((a[i][j]+b[i][j]) + " ");
			}
			System.out.println();
		}
	}

}
