package test;
import javax.swing.JOptionPane;
public class Calculate {

	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null,"Please enter the first number",JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null,"Please enter the second number",JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1),num2 = Double.parseDouble(strNum2);
		String strResult = "Sum of two numbers: " + (num1+num2) + "\n";
		strResult += "Difference of two numbers: " + (num1-num2) + "\n";
		strResult += "Product of two numbers: " + (num1*num2) + "\n";
		strResult += "Quotient of two numbers: " + (num1/num2);
		JOptionPane.showMessageDialog(null,strResult,"Result",JOptionPane.INFORMATION_MESSAGE);
		//System.out.println(num1+num2);
	}

}
