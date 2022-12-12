package com.Test4;

public class Point {

	public Point() {
		// TODO Auto-generated constructor stub
	}
		
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	// field
	private int x;
	private int y;
	
	//field가 private 이기때문에 getter & setter 필요
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}//
