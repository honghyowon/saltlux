package com.uni;

public class Human {

	//constructor
	public Human() {

	}
	
//	직접입력
//	public Human(String name, int age, int height, int weight) {
//		this.name = name;
//		this.age = age;
//		this.height = height;
//		this.weight = weight;
//	}
//
	//이클립스 이용해서 입력
	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	//field
	private String name;
	private int age;
	private int height;
	private int weight;
	
	
	//getter & setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	//method
	public String printInformation() {
		return name + " " + age + " " + height + " " + weight + " " ;
	}


	
	
	
}//



















