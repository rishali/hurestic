package com.huristic.game;

import java.util.Stack;
import com.huristic.game.Cordinate;

public class BallGame {

	int resultantLen;
	Stack<Cordinate> resultantStack;

 public BallGame() {
		// TODO Auto-generated constructor stub
		resultantLen = -1;
		resultantStack = new Stack<Cordinate>();
	}

	private void executeBallGame(int grid[][], int rowSize, int colSize, int currLen,
			Stack<Cordinate> tempStack,Stack<Cordinate> tempStack2) {

		if (currLen > resultantLen) {
			resultantLen = currLen;
			resultantStack.clear();
			resultantStack.addAll(tempStack2);
		}
		if (!tempStack.isEmpty()) {
			Cordinate cordinate = tempStack.pop();
			int row = cordinate.row;
			int col = cordinate.column;
			if (isCorrect(row + 1,col, rowSize, colSize) && grid[row + 1][col] < grid[row][col]) {
				tempStack.push(new Cordinate(row + 1, col));
				tempStack2.push(new Cordinate(row + 1, col));
				executeBallGame(grid, rowSize, colSize, currLen + 1, tempStack,tempStack2);
				tempStack2.pop();
			}
			if (isCorrect(row, col + 1, rowSize, colSize) && grid[row][col + 1] < grid[row][col]) {
				tempStack.push(new Cordinate(row, col + 1));
				tempStack2.push(new Cordinate(row, col + 1));
				executeBallGame(grid,rowSize, colSize, currLen+1, tempStack,tempStack2);
				tempStack2.pop();
			}
			if (isCorrect(row - 1, col, rowSize, colSize) && grid[row - 1][col] < grid[row][col]) {
				tempStack.push(new Cordinate(row - 1, col));
				tempStack2.push(new Cordinate(row - 1, col));
				executeBallGame(grid, rowSize, colSize, currLen+1, tempStack,tempStack2);
				tempStack2.pop();
			}
			if (isCorrect(row, col - 1, rowSize, colSize) && grid[row][col - 1] < grid[row][col]) {
				
				tempStack.push(new Cordinate(row, col - 1));
				tempStack2.push(new Cordinate(row, col - 1));
				executeBallGame(grid, rowSize, colSize, currLen+1, tempStack,tempStack2);
				tempStack2.pop();
			}
		}

	}
	public Stack<Cordinate> findlongestpath(int grid[][],int row,int col,int rowSize,int colSize)
	{
		Stack<Cordinate> tempStack = new Stack<Cordinate>();
		Stack<Cordinate> tempStack2 = new Stack<Cordinate>();
		
		Cordinate cordinate = new Cordinate(row,col);
		tempStack.push(cordinate);
		tempStack2.push(cordinate);
		executeBallGame(grid, rowSize, colSize, 0, tempStack,tempStack2);
		return resultantStack;
	 }
	private boolean isCorrect(int row,int col,int rowSize,int colSize)
	{
		if(row>=0 && col>=0 && row<rowSize && col<colSize )
			return true;
		else
			return false;
     }
	}
