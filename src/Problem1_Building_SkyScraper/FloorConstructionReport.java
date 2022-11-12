package Problem1_Building_SkyScraper;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FloorConstructionReport {

	public static final String TEXT_RED = "\u001B[31m";

	// Main method for Reporting Floor Construction :
	public static void main(String[] args) {

		int numFloor;
		int[] floorOrderByDay;
		PriorityQueue<Integer> pastOrder = new PriorityQueue<>(Comparator.reverseOrder()),
				               futureOrder = new PriorityQueue<>(Comparator.reverseOrder());
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building");
		numFloor = sc.nextInt();
		//Extreme case handling
		if (numFloor < 0) {
			System.out.println(TEXT_RED +" -> A Negative value as number of floors is not possible.\n"
					+ "\nSorry Exiting the Program---*---");
			sc.close();
			System.exit(0);
		}
		floorOrderByDay = new int[numFloor];
        System.out.println("Enter the floor size provided day by day from factories :\n");

		for (int i = 0; i < numFloor; i++) 
		{
			System.out.println("Enter the floor size given on Day: "+(i + 1));
			int floorSize = sc.nextInt();
			if (floorSize < 0) {
			System.out.println(" ---- Negative value as floor size is not possible.\n");
				i=i-1;		
				continue;
			}
			floorOrderByDay[i] = floorSize;
			futureOrder.add(floorSize);
		}

		// Daily workflow of construction is as:
		System.out.println("\nReport of daily work done on construction as:\n");
	
		for (int i = 0; i < floorOrderByDay.length; i++) {
			int floorSize = floorOrderByDay[i];
			pastOrder.add(floorSize);

		if ((pastOrder.size()>0 && futureOrder.size()>0 && pastOrder.peek()>=futureOrder.peek())){
				System.out.println(" Work assembled on Day: " + (i + 1));
				
		  while(pastOrder.size()>0 && futureOrder.size()>0 && pastOrder.peek()>=futureOrder.peek())
			     {
				 System.out.print(" "+pastOrder.poll());
				 futureOrder.poll();
				 }
		   } 
		   else
			   System.out.println(" Work assembled on Day: " + (i + 1));
			
		  System.out.println();
		}
		// Closing input stream
		sc.close();
		System.out.println("\n-----Program Completed Successfully-----");
	}
}
