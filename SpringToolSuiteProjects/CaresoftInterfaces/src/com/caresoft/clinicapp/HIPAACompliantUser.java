package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	abstract boolean accessAuthorized(Integer confirmedAuthID);
	abstract boolean assignPin(int pin);
}