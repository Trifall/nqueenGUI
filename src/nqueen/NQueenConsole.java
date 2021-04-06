package nqueen;

import java.util.*;
/*
N=2 
      1   0  
      0   0           no solution!
N=3       
      1   0   0
      0   0   0
      0   0   0       no solution!    
N=4      
      1   0   0   0
      0   0   0   0
      0   0   0   0
      0   0   0   0   has solution   
            
*/

public class NQueenConsole {
  static int N;
  static int board[][];
    
  static boolean isSafe(int board[][],int row,int col) {
    //If the position (row, col) is safe, return true
    //If the position (row, col) is not safe, return false       
    //Insert Your Codes in here!! 
    for (int i=0;i<N;i++) {
       for(int j=0;j<N;j++) {
            if (board[i][j]==1) {
               if (row==i) return false;
               if (col==j) return false;
               if (Math.abs(row-i)==Math.abs(col-j)) return false;
            }   
       }
    }
    return true;   
  }
  
  static boolean solveNQueen(int board[][],int col){
     //Same as the algorithm in lecture.  
       if (col>=N) return true;
       for (int row=0; row<N ; row++)
       {
           if(isSafe(board,row,col))
           {
              board[row][col]=1;
              if (solveNQueen(board, col+1)) return true;
              board[row][col]=0;
           }       
       }
       return false;
  }

  static void display(int board[][]){
       for (int i=0;i<N;i++){
          for (int j=0;j<N;j++){
              System.out.print(board[i][j]+" ");
          }
          System.out.println();
       }    
  }

  public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
       System.out.print("Enter Board Size(N): ");
       N=console.nextInt();
       board =new int[N][N];
       if(solveNQueen(board,0)) {
          System.out.println("Has solution");       
          display(board);   
       }
       else
          System.out.println("No solution");   
       console.close();   
   
  }
}
