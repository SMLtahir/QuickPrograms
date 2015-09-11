package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Imagine you have a call center with three levels of employees: fresher, technical lead
(TL), product manager (PM)  There can be multiple employees, but only one TL or PM 
An incoming telephone call must be allocated to a fresher who is free  If a fresher
can’t handle the call, he or she must escalate the call to technical lead  If the TL is
not free or not able to handle it, then the call should be escalated to PM  Design the
classes and data structures for this problem  Implement a method getCallHandler() 
 * 
 * 
 * I have designed this entirely by myself without any reference.
 * Please refer to other material to verify the presence of all required info.
 * This is also implemented in Cracking The Coding Interview for example. 
 * @author Tahir
 *
 */
public class CallCenter {
	int nrOfFreshers;
	
	// TL and PM like this, is not scalable in case more of them have to be added to the system.
	// In that case, having levels/ ranks for the employees will be best.
	List<Fresher> freshers;
	TL techLead;
	PM pm;
	
	LinkedList<Fresher> callQueue;
	
	public CallCenter(int nrOfFreshers, List<Fresher> freshers, TL techLead, PM pm) {
		this.nrOfFreshers = nrOfFreshers;
		
		this.freshers = freshers;
		this.techLead = techLead;
		this.pm = pm;
		
		callQueue = new LinkedList<Fresher>();
		callQueue.addAll(freshers);
	}
	
	public Fresher getCallHandler() {
		Fresher fresher = null;
		int index = 0;
		while(true) { // Instead, there should be a timeOut counter here
			fresher = callQueue.get(index);
			if(fresher.isFree) {
				fresher.takeCall(this);
				callQueue.remove(fresher);
				callQueue.add(fresher);
				break;
			}
			index++;
			if(index == callQueue.size()) { index = 0;}
		}
		return fresher;
	}
}

abstract class Employee {
	boolean isFree;
	EmpType type;
	int empId;
	
	public Employee(int id) {
		isFree = true;
		this.empId = id;
	}
	
	public void takeCall(CallCenter cc) {
		this.isFree = false;
		if(this.handleCall()) {
			System.out.println("Call successfully handled.");
		} else {
			this.escalateCall(cc);
		}
		this.isFree = true;
	}

	public boolean handleCall() {
		// Return true or false depending on whether the employee can successfully handle the call
		return false;
	}
	
	public void escalateCall(CallCenter cc) {
		// This should be implemented by subclass
	}
}

class Fresher extends Employee {

	public Fresher(EmpType type, int id) {
		super(id);
		this.type = type;
	}
	
	public void escalateCall(CallCenter cc) {
		this.isFree = true;
		cc.techLead.takeCall(cc);
	}
	
}

class TL extends Employee {

	public TL(EmpType type, int id) {
		super(id);
		this.type = type;
	}
	
	public void escalateCall(CallCenter cc) {
		this.isFree = true;
		cc.pm.takeCall(cc);
	}
}

class PM extends Employee {

	public PM(EmpType type, int id) {
		super(id);
		this.type = type;
	}
	
	public void escalateCall(CallCenter cc) {
		System.out.println("Sorry Mr. Customer, but we cannot help you on this issue!");
	}
}

enum EmpType {
	Fresher,
	TL,
	PM;
}
