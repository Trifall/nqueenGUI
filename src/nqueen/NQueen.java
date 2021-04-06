package nqueen;

public class NQueen {
  
  private int N;
  private int board[][];
  private boolean solved;
  
  NQueen(int N){
      this.N=N;
      this.board = new int[N][N];
      solved=solveNQueen(board,0);
  }
  
  int[][] getBoard(){
      return board;    
  }
  boolean getSolved(){
      return solved;
  } 
  int getN(){
      return N;
  }  
  //Check the Safe position on Board. 
  boolean isSafe(int board[][],int row,int col) { //if safe return true, else return false
    for (int i=0;i<N;i++){
        for (int j=0;j<N;j++)
        {
            if (board[i][j]==1)
            {
              if (i==row) return false; //same row
              if (j==col) return false; //same column    
              if (Math.abs(i-row)==Math.abs(j-col)) return false;  //in diagonal 
            } 
        }
    }
    return true;
  }
  //Recurison Function to Solve NQueen Problem.
  boolean solveNQueen(int board[][],int col){
       if (col>=N) return true;
       for (int row=0; row<N ; row++)
       {
           if(isSafe(board,row,col))
           {
              board[row][col]=1; // put queen in position (row, col) -safe     
              if (solveNQueen(board, col+1)) return true; 
              board[row][col]=0; // take queeen out from position (row, col) -not safe 
           }       
       }
       return false;
  }
}
 