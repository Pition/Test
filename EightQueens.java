package exercise1;

public class EightQueens {
	static int count=0;
	public static int CHESSBOARD_SIZE = 3;
	
	public static void main(String[] args) {
		int[][] chess = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
		for(int m=0;m<CHESSBOARD_SIZE;m++) {
			for(int n=0;n<CHESSBOARD_SIZE;n++) {
				chess[m][n]= 0;
			}
		}
		nextFloor(chess,0,0);
		System.out.println("在 "+CHESSBOARD_SIZE+" X "+CHESSBOARD_SIZE+" 的棋盘上放 "+CHESSBOARD_SIZE+" 颗棋子有 "+count+" 种不同的方法");
	}
	
	public static void nextFloor(int[][] a, int i, int j) {
		
		//排除右上角
		for(int m=i-2, n=j+1; m>=0&& n<CHESSBOARD_SIZE; m--, n++) {
			if(a[m][n]==1) {
				return;
			}
		}
		
		//排除左上角
		for(int m=i-2, n=j-1; m>=0&& n>=0; m--, n--) {
			if(a[m][n]==1) {
				return;
			}
		}
		
		//排除正上方
		for(int m=i-2; m>=0; m--) {
			if(a[m][j]==1) {
				return;
			}
		}
		
		if(i==CHESSBOARD_SIZE) {
//			for(int m=0;m<CHESSBOARD_SIZE;m++) {
//				for(int n=0;n<CHESSBOARD_SIZE;n++) {
//					System.out.print(a[m][n]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			count++;
			return;
		}
		
		for(j=0; j<CHESSBOARD_SIZE ; j++) {
			a[i][j] = 1;
			nextFloor(a,i+1,j);
			a[i][j]=0;
		}
		return;
	}
}
