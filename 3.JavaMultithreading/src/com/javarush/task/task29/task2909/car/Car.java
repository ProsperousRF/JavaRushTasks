package com.javarush.task.task29.task2909.car;

import java.util.Date;

public class Car {
  public static final int TRUCK = 0;
  public static final int SEDAN = 1;
  public static final int CABRIOLET = 2;
  public double summerFuelConsumption;
  public double winterFuelConsumption;
  public double winterWarmingUp;
  double fuel;
  private int type;

  private boolean driverAvailable;
  private int numberOfPassengers;

  protected Car(int type, int numberOfPassengers) {
    this.type = type;
    this.numberOfPassengers = numberOfPassengers;
  }

  public static Car create(int type, int numberOfPassengers) {
    switch (type) {
      case TRUCK:
        return new Truck(numberOfPassengers);
      case SEDAN:
        return new Sedan(numberOfPassengers);
      case CABRIOLET:
        return new Cabriolet(numberOfPassengers);
      default:
        throw new IllegalArgumentException("Unknown Car type");
    }
  }

  public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
    return date.before(summerEnd) && date.after(summerStart);
  }

  public void fill(double numberOfLiters) throws Exception {
    if (numberOfLiters < 0) {
      throw new Exception("Wrong amount of fuel");
    }

    fuel += numberOfLiters;
  }

  public int getNumberOfPassengersCanBeTransferred() {
    if (!isDriverAvailable()) return 0;
    if (fuel <= 0) return 0;

    return numberOfPassengers;
  }

  public boolean isDriverAvailable() {
    return driverAvailable;
  }

  public void setDriverAvailable(boolean driverAvailable) {
    this.driverAvailable = driverAvailable;
  }

  public void startMoving() {
    if (numberOfPassengers > 0) {
      fastenPassengersBelts();
      fastenDriverBelt();
    } else {
      fastenDriverBelt();
    }
  }

  public void fastenPassengersBelts() {}

  public void fastenDriverBelt() {}

  public int getMaxSpeed() {
    if (type == TRUCK) return 80;
    if (type == SEDAN) return 120;
    return 90;
  }

  public double getWinterConsumption(int length) {
    return length * winterFuelConsumption + winterWarmingUp;
  }

  public double getSummerConsumption(int length) {
    return length * summerFuelConsumption;
  }

  public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
    return isSummer(date, SummerStart, SummerEnd)
        ? getSummerConsumption(length)
        : getWinterConsumption(length);
  }
}
