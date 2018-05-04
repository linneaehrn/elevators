package se.oneagency.codechallenge.elevator.resources;

import java.util.ArrayList;
import java.util.List;



import se.oneagency.codechallenge.elevator.api.Elevator;
import se.oneagency.codechallenge.elevator.api.ElevatorController;

public class ControllerImplement implements ElevatorController {
	
	private List<Elevator> elevatorList;
	
	public ControllerImplement(int elevatorNmb){
		elevatorList = new ArrayList<Elevator>();
		
		 for (int i = 0; i < elevatorNmb; i++){
			
			 
			 elevatorList.add(new ElevatorImplement(i));
		 }
	}

	@Override
	public Elevator requestElevator(int toFloor) {
		int closest = -1;
		int currentDist = Integer.MAX_VALUE;
		for (int i = 0; i < elevatorList.size(); i++){
			if(!elevatorList.get(i).isBusy()){
				int dist = Math.abs(elevatorList.get(i).currentFloor()-toFloor);
				if(dist < currentDist){
					currentDist = dist;
					closest = i;
				}
			}
		}
		if(closest == (-1)){
			
			 //wait and retry
			
		}
		elevatorList.get(closest).moveElevator(toFloor);
		return elevatorList.get(closest);
	}

	@Override
	public List<Elevator> getElevators() {
		return elevatorList;
	}

	@Override
	public void releaseElevator(Elevator elevator) {
		
		while(elevator.isBusy()){
			
			 //wait
			 
		}
		
	}

}
