package models;

public class Gorilla extends Mammals{

	public Gorilla() {
		// TODO Auto-generated constructor stub
		super();
		energy = 100;
	}
	
	public void throwThings() {
		energy -= 5;
	}
	
	public void eatBananas() {
		energy += 10;
	}
	
	public void climb() {
		energy -= 10;
	}
}
