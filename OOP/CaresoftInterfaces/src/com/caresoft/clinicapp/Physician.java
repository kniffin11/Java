package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
		
	
    // TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		// checks length of pin by value 
		if((pin < 999) || (pin > 9999)) {
			return false;
		}
		return true;
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id == confirmedAuthID){
			return true;
		}
		return false;
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

}