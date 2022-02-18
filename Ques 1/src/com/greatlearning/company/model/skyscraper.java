package com.greatlearning.company.model;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import com.greatlearning.company.service.SortingService;

public class skyscraper {
	
	private int noOfFloors = 0;
	private int[] floorSizePerDay, floorSizeInAscOrder;
	private Stack<Integer> floorSizeInStack;
	Scanner scanner = new Scanner(System.in);

	public void implementSkyscraperApp() {
		
		System.out.println("enter the total no of floors in the building");
		noOfFloors = scanner.nextInt();

		
		floorSizePerDay = new int[noOfFloors];

		
		getFloorSizePerDay();
		scanner.close();
		
		storeFloorSizeInAscOrder();

		storeFloorSizeInStack();

		displayFloorsToBeConstructed();
	}

	private void getFloorSizePerDay() {
		for (int i = 0; i < noOfFloors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			floorSizePerDay[i] = scanner.nextInt();
		}
	}

	private void storeFloorSizeInAscOrder() {
		floorSizeInAscOrder = floorSizePerDay.clone();
		SortingService.sort(floorSizeInAscOrder, 0, floorSizeInAscOrder.length - 1);
	}


	private void storeFloorSizeInStack() {
		floorSizeInStack = new Stack<>();
		for (int size : floorSizeInAscOrder) {
			floorSizeInStack.push(size);
		}
	}

ay
	private void displayFloorsToBeConstructed() {
		System.out.println();
		System.out.println("The order of construction is as follows");

		Stack<Integer> tempStack = new Stack<>();
		for (int i = 0; i < noOfFloors; i++) {
			System.out.println("Day " + (i + 1));
			int floorSizeOfTheDay = floorSizePerDay[i];

			int largestFloorSize = floorSizeInStack.peek();
			if (floorSizeOfTheDay != largestFloorSize) {
				tempStack.push(floorSizeOfTheDay);
			} else {
				System.out.print(floorSizeInStack.pop() + " ");
				while (!tempStack.isEmpty() && Objects.equals(floorSizeInStack.peek(), tempStack.peek())) {
					System.out.print(floorSizeInStack.pop() + " ");
					tempStack.pop();
				}
			}
			System.out.println();
		}
	}
	

}
