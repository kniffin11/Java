package models;

public class Bat extends Mammals{
	public Bat() {
		energy = 300;
	}
	
	public void fly() {
		System.out.println("Swoosh");
		energy -= 50;
	}
	
	public void eatHumans() {
		energy += 25;
	}
	
	public void attackTown() {
		System.out.println("Crackle");
		energy -= 100;
	}
}
