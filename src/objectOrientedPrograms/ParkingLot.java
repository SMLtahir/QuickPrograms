package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParkingLot {

	public static void main(String[] args) {
		ParkingLot parkLot = new ParkingLot(10, 10, 10);
		Motorcycle m1 = new Motorcycle(45123);
		Motorcycle m2 = new Motorcycle(45124);
		Motorcycle m3 = new Motorcycle(45125);
		Motorcycle m4 = new Motorcycle(45126);
		Motorcycle m5 = new Motorcycle(45127);
		
		Car c1 = new Car(24123);
		Car c2 = new Car(24124);
		Car c3 = new Car(24125);
		Car c4 = new Car(24126);
		Car c5 = new Car(24127);
		
		Bus b1 = new Bus(78123);
		Bus b2 = new Bus(78133);
		Bus b3 = new Bus(78143);
		Bus b4 = new Bus(78153);
		Bus b5 = new Bus(78163);
		
		parkLot.Park(b5);
		parkLot.Park(c5);
		parkLot.Park(m5);
		parkLot.Park(b2);
		parkLot.Park(m3);
		
		parkLot.unPark(m3);
	}
	
	public int NUMBER_OF_SMALL_SLOTS;
    public int NUMBER_OF_MEDIUM_SLOTS;
    public int NUMBER_OF_LARGE_SLOTS;
    public Map<Long, Slot> occupiedSlots;
	public List<SmallSlot> smallSlots;
	public List<MediumSlot> mediumSlots;
	public List<LargeSlot> largeSlots;
	
	//Constructor
	ParkingLot(int nrSmallSlots, int nrMidSlots, int nrLargeSlots) {
		this.NUMBER_OF_SMALL_SLOTS = nrSmallSlots;
		this.NUMBER_OF_MEDIUM_SLOTS = nrMidSlots;
		this.NUMBER_OF_LARGE_SLOTS = nrLargeSlots;
		occupiedSlots = new HashMap<Long, Slot>();
		smallSlots = new ArrayList<SmallSlot>(nrSmallSlots);
		mediumSlots = new ArrayList<MediumSlot>(nrMidSlots);
		largeSlots = new ArrayList<LargeSlot>(nrLargeSlots);
		createSlots();
	}
	
	private void createSlots() {
		 
        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
            smallSlots.add(new SmallSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_MEDIUM_SLOTS; i++) {
            mediumSlots.add(new MediumSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
            largeSlots.add(new LargeSlot(i));
        }
 
    }
	
	public long Park(Vehicle vehicle) {
		Slot slot = null;
		long uniqueToken = -1;
		
		if(vehicle.vType == VehicleType.MotorCycle) {
			slot = getFreeSlot(smallSlots);
			if(slot != null) { 
				uniqueToken = getToken(vehicle, slot);
				occupiedSlots.put(vehicle.uniqueVId, slot);
				slot.isOccupied = true;
		    }
			
		} 
		else if(vehicle.vType == VehicleType.Car) {
			slot = getFreeSlot(mediumSlots);
			if(slot != null) { 
				uniqueToken = getToken(vehicle, slot);
				occupiedSlots.put(vehicle.uniqueVId, slot);
				slot.isOccupied = true;
		    }
		} 
		else if(vehicle.vType == VehicleType.Bus) {
			slot = getFreeSlot(largeSlots);
			if(slot != null) { 
				uniqueToken = getToken(vehicle, slot);
				occupiedSlots.put(vehicle.uniqueVId, slot);
				slot.isOccupied = true;
		    }
		}
		if(uniqueToken == -1) { System.out.println("Parking is Full!");}
		else { System.out.println("Vehicle with ID: "+ vehicle.uniqueVId+ " is parked in Slot: "+ slot.slotNumber+ " of type: "+ slot.slotType );}
		return uniqueToken;
	}
	
	public void unPark(Vehicle vehicle) {
		if(!occupiedSlots.containsKey(vehicle.uniqueVId)) {
			System.out.println("This vehicle is not parked in this parking lot!");
			return;
		}
		occupiedSlots.get(vehicle.uniqueVId).isOccupied = false;
		occupiedSlots.remove(vehicle.uniqueVId);
		System.out.println("Vehicle with ID: "+ vehicle.uniqueVId+ " is now out of the parking lot.");
	}
	
	private static Slot getFreeSlot(List<? extends Slot> slots) {
		Iterator<? extends Slot> iter = slots.iterator();
		Slot slot = null;
		while(iter.hasNext()) {
			slot = iter.next();
			if(!slot.isOccupied) {
				break;
			}
		}
		return slot;
	}
	
	private long getToken(Vehicle vehicle, Slot slot) {
		long uniqueToken = -1;
		if(vehicle != null && slot != null) {
			uniqueToken = vehicle.uniqueVId * slot.slotNumber;
		}
		return uniqueToken;
	}
	
}

class Slot {
	
	public boolean isOccupied;
	public int slotNumber;
	public SlotType slotType;
	
	//Constructor
	Slot(int slotNr) {
		isOccupied = false;
		this.slotNumber = slotNr;
	}
}

class SmallSlot extends Slot {

	SmallSlot(int slotNr) { 
		super(slotNr);
		this.slotType = SlotType.Small;
	}	
}

class MediumSlot extends Slot {

	MediumSlot(int slotNr) { 
		super(slotNr);
		this.slotType = SlotType.Medium;
	}	
}

class LargeSlot extends Slot {

	LargeSlot(int slotNr) { 
		super(slotNr);
		this.slotType = SlotType.Large;
	}	
}

abstract class Vehicle {
	public long uniqueVId;
	public VehicleType vType;
	
	Vehicle(long id) {
		this.uniqueVId = id;
	}
}

class Motorcycle extends Vehicle {

	Motorcycle(long id) {
		super(id);
		this.vType = VehicleType.MotorCycle;
	}
}

class Car extends Vehicle {

	Car(long id) {
		super(id);
		this.vType = VehicleType.Car;
	}
}

class Bus extends Vehicle {

	Bus(long id) {
		super(id);
		this.vType = VehicleType.Bus;
	}
}

enum VehicleType {
	MotorCycle,
	Car,
	Bus;
}

enum SlotType {
	Small,
	Medium,
	Large;
}