/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author sheehantoufiq
 * 
 * Documentation:
 * The following program takes 2 matrices, generates random numbers for each 
 * position is the matrix and multiplies them into an output.
 * 
 * The multiplication logic is a while loop that runs, conditional statements
 * check to see if any of the user inputs are illegal. If so than the while 
 * loop reruns.
 *
 * The first matrix is stored into the "first" array and the second matrix is 
 * stored into the "second" array.
 * 
 * The two arrays are multiplied and stored into the "multiply" array, which is
 * printed out to the user along with the elapsed time.
 * 
 * The user has the option to run the program again, which will run the 
 * while loop again.
 * 
 * 
 */
import java.util.Scanner;

public class Matrix {

   public static void main(String args[])
   {
      long startTime = System.currentTimeMillis();
      multiplyMatrix: while(true) {
          int m, n, p, q, c, d, k;
          int sum = 0;
          
          Scanner in = new Scanner(System.in);
          
          System.out.println("Enter the number of rows of first matrix (Minimum: 50)");
          m = in.nextInt();
          System.out.println("Enter the number of columns of first matrix (Minimum: 50)");
          n = in.nextInt();
          
          int first[][] = new int[m][n];
                  
          if ( m < 50 || n < 50 ) {
              System.out.println("The number of rows and columns must be more than 50.");
              continue;
          } else {
              for ( c = 0 ; c < m ; c++ )
                  for ( d = 0 ; d < n ; d++ )
                      first[c][d] = (int)(Math.random() * 99) + 1;
          }
          
          System.out.println("Enter the number of rows of second matrix (Minimum: 50)");
          p = in.nextInt();
          
          System.out.println("Enter the number of columns of second matrix (Minimum: 50)");
          q = in.nextInt();
          
          if (p < 50 || q < 50) {
              System.out.println("The number of rows and columns must be more than 50.");
              continue;
          } else {
              if ( m != p || n != q ) {
                  System.out.println("Matrices with entered orders can't be multiplied with each other.");
                  continue;
              } else {
                  int second[][] = new int[p][q];
                  int multiply[][] = new int[m][q];
                  
                  for ( c = 0 ; c < p ; c++ )
                      for ( d = 0 ; d < q ; d++ )
                          second[c][d] = (int)(Math.random() * 99) + 1;
                  
                  for ( c = 0 ; c < m ; c++ )
                      for ( d = 0 ; d < q ; d++ )
                          for ( k = 0 ; k < p ; k++ )
                              multiply[c][d] = first[c][k]*second[k][d];
                  
                  System.out.println("Product of entered matrices:-");
                  
                  for ( c = 0 ; c < m ; c++ ) {
                    for ( d = 0 ; d < q ; d++ )
                        System.out.print(multiply[c][d]+"\t");
                        System.out.print("\n");
                    }
                  }
                  long stopTime = System.currentTimeMillis();
                  System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");
                  
                  System.out.println("Would you like to repeat the program? (y/n)");
                  String input = in.next();
                  
                  if (input.equals("n")) {
                      System.out.println("Thank you!");
                      break;
                  } else {
                      continue multiplyMatrix;
                  }
                  
            }
      }
   }
}