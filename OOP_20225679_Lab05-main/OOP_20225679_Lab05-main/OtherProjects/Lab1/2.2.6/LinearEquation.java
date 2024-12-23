import java.util.Scanner;

public class solveLinearEquation {
    public static void main( String args[]){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input a: ");
        double a = scanner.nextDouble();
                
        System.out.println("Input b: ");
        double b = scanner.nextDouble();

        solve(a, b);
        
    }
    public static double solve(double a, double b){
        double x = 0;
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            x = -b / a;
            System.out.println("The result for Lỉnear Equation is" + x);
        }
        return x;
    }
}
