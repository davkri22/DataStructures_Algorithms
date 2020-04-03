package Unit8.Vehicle.Cars;

import java.util.List;

public abstract class Car {
	/**
	 * Creates a car with a starting mileage on the odometer.
	 *
	 * @throws IllegalArgumentException if startingMileage is negative
	 */
	private String make;
	private String model;
	private double mileage;

	public Car(String make, String model, double startingMileage) {
		this.make = make;
		this.model = model;
		if (startingMileage < 0) {
			throw new IllegalArgumentException();
		}
		this.mileage = startingMileage;
	}

	/** Starting mileage is 0. */
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
		this.mileage = 0;
	}

	/** If able to drive the full given number of miles, returns true.
	 If not, returns false.
	 @throws IllegalArgumentException if miles is negative.*/
	public boolean canDrive(double miles) {
		if (miles < 0) {
			throw new IllegalArgumentException("Miles is negative.");
		}
		return getRemainingRange() >= miles;
	}

	/** Drives the full given number of miles.
	 @throws IllegalArgumentException if miles is negative or if miles
	 is too high given the current fuel.*/
	public abstract void drive(double miles);

	/** Gives String representation of Car as
	 "< make and model> (<mileage> mi) "*/
	public String toString() {
		return this.make + " " + this.model + " (" + String.format("%.1f", this.mileage) + " mi)";
	}

	/** Returns how many miles have been driven so far (odometer). */
	public double getMileage() {
		return this.mileage;
	}

	/** Returns how many more miles the car can currently go given the
	 remaining fuel/energy reserves. */
	public abstract double getRemainingRange();

	/** Adds mileage to the odometer.
	 @throws IllegalArgumentException if miles is negative. */
	protected void addMileage(double miles) {
		if (miles < 0) {
			throw new IllegalArgumentException();
		}
		this.mileage = this.mileage + miles;
	}

	/** The car attempts to drive, in order, each of the daily number
	 of miles in the list milesEachDay. Once the car cannot drive one of
	 the day’s distance, no more days are attempted. Returns the number
	 of days successfully driven.
	 @throws IllegalArgumentException if miles is negative for any of
	 the attempted days.*/
	public int roadTrip(List<Double> milesEachDay) {
		int days = 0;
		for (double miles : milesEachDay) {
			if (miles < 0) {
				throw new IllegalArgumentException();
			}
			if (canDrive(miles)) {
				days++;
			}
			else {
				return days;
			}
		}
		return days;
	}
}






