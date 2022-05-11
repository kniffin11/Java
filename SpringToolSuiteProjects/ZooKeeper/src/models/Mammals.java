package models;

public class Mammals {
	int energy;
	
	public Mammals() {
		energy = 100;
	}
	
	public int displayEnergy() {
		System.out.println(energy);
		return energy;
	}
	
	// for gorilla class
	public int getEnergy() {
		return energy;
	}
}
