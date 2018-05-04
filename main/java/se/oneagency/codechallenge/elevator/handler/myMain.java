package se.oneagency.codechallenge.elevator.handler;
import java.util.Scanner;

import se.oneagency.codechallenge.elevator.resources.ControllerImplement;

public class myMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elevators (Max 20)");
		int n = scan.nextInt();
		while (n > 20 || n < 1){
			System.out.println("Please enter a number between 1 and 20");
			n = scan.nextInt();
		}
		
		ControllerImplement control = new ControllerImplement(n);
		
		while(true){
			
			System.out.println("Choose 1 to request elevator" + '\n' + 
			"Choose 2 for list of all elevators" + '\n' +
			"Choose 9 to exit");
			System.out.println("Enter choice");
			int choice = scan.nextInt();

			switch(choice){
				case 1: 
					System.out.println("To which floor?");
					int curFloor = scan.nextInt();
					System.out.println("Elevator number " + control.requestElevator(curFloor).getId() + " has arrived on Floor " + curFloor);
					break;
			
				case 2:										
					for(int i = 0; i < n; i++){
						System.out.println("Elevator number " + control.getElevators().get(i).getId() + " is currently on floor " + 
						control.getElevators().get(i).currentFloor());
					}
					break;
				
				case 9:
					scan.close();
					System.exit(0);

				}

			}


		
	}

}
