import java.util.Scanner;
public class DisplayTriangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter n");
		int n = keyboard.nextInt();
		if(n<=0) {
			System.out.println("That's skibidi");
		}else {
			int i,j;
			for(i=0;i<n;++i) {
				for(j=0;j<(n-i)-1;++j)System.out.print(" ");
				for(j=0;j<2*i+1;++j)System.out.print("*");
				for(j=0;j<(n-i)-1;++j)System.out.print(" ");
				System.out.print("\n");
			}
		}
	}

}
