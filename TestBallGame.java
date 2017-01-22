package com.huristic.game;
import java.util.Scanner;
import java.util.Stack;

public class TestBallGame {
public static void main(String[] args){
	BallGame ballGame = new BallGame();
	int rowSize,colSize,row,col;
	Scanner in = new Scanner(System.in);
	
	 
     int[][] grid = new int[3][3];
     for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
             grid[i][j] = in.nextInt();
         }
     }
	
    row = in.nextInt();
    col =in.nextInt();
    in.close();
    rowSize=3;
	colSize=3;
	
	Stack<Cordinate> result = ballGame.findlongestpath(grid, row, col, rowSize, colSize);
	
	while(!result.isEmpty()){
		Cordinate cordinate = result.pop();
		System.out.print("("+cordinate.row+","+cordinate.column+")");
	}
	
}
}
