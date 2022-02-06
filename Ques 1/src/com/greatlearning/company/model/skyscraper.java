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
		// get the no. of floors
		System.out.println("enter the total no of floors in the building");
		noOfFloors = scanner.nextInt();

		// initialize the floorSizePerDay array
		floorSizePerDay = new int[noOfFloors];

		// get the size of the floor per day
		getFloorSizePerDay();
		scanner.close();

		// store the size of floor per day in ascending order
		storeFloorSizeInAscOrder();

		// store the size of floors in a stack so that I can get the largest floor when
		// needed
		storeFloorSizeInStack();

		// run the algorithm to display the size of floors in each day
		displayFloorsToBeConstructed();
	}

	// function to get the size of the floor per day
	private void getFloorSizePerDay() {
		for (int i = 0; i < noOfFloors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			floorSizePerDay[i] = scanner.nextInt();
		}
	}

	// function to store the size of floor per day in ascending order
	private void storeFloorSizeInAscOrder() {
		floorSizeInAscOrder = floorSizePerDay.clone();
		SortingService.sort(floorSizeInAscOrder, 0, floorSizeInAscOrder.length - 1);
	}

	// function to store the size of floors in a stack so that I can get the largest
	// floor when needed
	private void storeFloorSizeInStack() {
		floorSizeInStack = new Stack<>();
		for (int size : floorSizeInAscOrder) {
			floorSizeInStack.push(size);
		}
	}

	// function to run the algorithm to display the size of floors in each day
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
