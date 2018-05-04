package se.oneagency.codechallenge.elevator.resources;

import se.oneagency.codechallenge.elevator.api.Elevator;


public class ElevatorImplement implements Elevator {
	
	private int Id;
	private DirectionEnum dir;
	private int AdFloor;
	private int CurFloor;
	private boolean busy;
	
	public ElevatorImplement(int newId){
		Id = newId;
		dir = DirectionEnum.NONE;
		CurFloor = 1;
		AdFloor = 1;
		busy = false;
	}
		

	@Override
	public DirectionEnum getDirection() {
		return dir;
	}

	@Override
	public int getAddressedFloor() {
		return AdFloor;
	}

	@Override
	public int getId() {
		return Id;
	}

	@Override
	public void moveElevator(int toFloor) {
		if(CurFloor < toFloor){
			dir = DirectionEnum.UP;
			busy = true;
		} else if(CurFloor > toFloor){
			dir = DirectionEnum.DOWN;
			busy = true;
		}
		
		
		  //wait for elevator to get to destination floor
		 
		
		CurFloor = toFloor;
		busy = false;
	}

	@Override
	public boolean isBusy() {		
		return busy;
	}

	@Override
	public int currentFloor() {
		return CurFloor;
	}

}
