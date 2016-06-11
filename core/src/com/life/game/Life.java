package com.life.game;

import com.badlogic.gdx.math.MathUtils;


public class Life {
	private int[][] board;
	private int sizeX, sizeY;

	public Life(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		this.board = new int[sizeY][sizeY];
	}

	public void init() {
		int i, j;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			
			}
		}
	
		//custom set
		board[2][1] = 1;
		board[2][2] = 1;
		board[2][3] = 1;
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
	public int countN(int[] n){
		int sum = 0;
		for(int z: n){
			sum = sum + z;
		}
		return sum;
	}
	
	public void step() {
		int[][] nb = new int[sizeX][sizeY];
		int[] n;
		int sum;
		for(int i=0; i< board.length; i++){
			for(int j = 0 ; j<board[i].length; j++){
				n = neighbours(i,j);
				sum = countN(n);
				if(sum > 3 || sum < 2){
					nb[i][j] = 0;
					continue;
				}
				if(sum == 3){
					nb[i][j] = 1;
					continue;
				}
				nb[i][j] = board[i][j];
			}
		}
		board = nb;
	}

	public void printBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void initRandom(){
		int i, j;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[i].length; j++) {
				board[i][j] = MathUtils.random(0,1);
			
			}
		}
	}
	
	
	public int[] neighbours(int x, int y) {
		int[] tmparr = new int[8];
		
		if(x==0) {
			tmparr[0] = board[x+1][y];	//below
			tmparr[1] = 0;				//above
		}else if(x == sizeX-1){
			tmparr[0] = 0;				//below
			tmparr[1] = board[x-1][y];  //above
		}	
		else {
			tmparr[0] = board[x+1][y];  //below
			tmparr[1] = board[x-1][y];  //above
		} 
		

		if (y == 0) {
			tmparr[2] = 0;  			//left
			tmparr[3] = board[x][y+1];  //right
		}
		else if(y == sizeY-1){
			tmparr[2] = board[x][y-1];  //left
			tmparr[3] = 0;  			//right
		}
		else{
			tmparr[2] = board[x][y-1];  //left
			tmparr[3] = board[x][y+1];  //right
		}
		
		if(x+1 < sizeX && y+1 < sizeY ){	//bottom right
			tmparr[4] = board[x+1][y+1];	
		}
		else{
			tmparr[4] = 0;
		}
		
		if(x-1 > -1 && y-1 > -1){			//top left
			tmparr[5] = board[x-1][y-1];
		}
		else{
			tmparr[5] = 0;
		}
		
		if(x-1 > -1 && y+1 < sizeY){		//top right
			tmparr[6] = board[x-1][y+1];
		}
		else{
			tmparr[6] = 0;
		}
		
		if(x+1 < sizeX && y-1 > -1){		//bottom left
			tmparr[7] = board[x+1][y-1];
		}
		else{
			tmparr[7] = 0;
		}
		
		return tmparr;
	}
}
