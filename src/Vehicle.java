public class Vehicle {

    private int currentSpeed;
    private int maxSpeed;
    private int amountOfPassengers;
    private int maxAmountOfPassengers;
    private String ownersNameAndSurname;

    public Vehicle(int currentSpeed, int maxSpeed, int amountOfPassengers, int maxAmountOfPassengers, String ownersNameAndSurname) {
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        this.amountOfPassengers = amountOfPassengers;
        this.maxAmountOfPassengers = maxAmountOfPassengers;
        this.ownersNameAndSurname = ownersNameAndSurname;

    }

    public void accelerate(int amount) {
        if (currentSpeed + amount < maxSpeed) {
            currentSpeed += amount;
        } else if (currentSpeed + amount == maxSpeed) {
            currentSpeed = maxSpeed;
        } else {
            System.out.println("This vehicle can't go any faster than " + maxSpeed);
        }

    }

    public void slowDown(int amount) {
        if (currentSpeed - amount > 0) {
            currentSpeed -= amount;
        } else if (currentSpeed - amount == 0) {
            currentSpeed = 0;
        } else {
            System.out.println("This vehicle had already stopped");
        }
    }

    public void getIntoVehicle(int amount) {
        if (amountOfPassengers + amount < maxAmountOfPassengers) {
            amountOfPassengers += amount;
        } else if (amountOfPassengers + amount == maxAmountOfPassengers) {
            amountOfPassengers = maxAmountOfPassengers;
        } else {
            System.out.println("This vehicle is already full of capacity");
        }
    }

    public void getOutOfVehicle(int amount) {
        if (amountOfPassengers - amount > 0) {
            amountOfPassengers -= amount;
        } else if (amountOfPassengers - amount == 0) {
            amountOfPassengers = 0;
        } else {
            System.out.println("This vehicle must have a driver");
        }
    }

    public void setOwnersNameAndSurname(String ownersNameAndSurname) {
        this.ownersNameAndSurname = ownersNameAndSurname;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxAmountOfPassengers() {
        return maxAmountOfPassengers;
    }

    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    public String getOwnersNameAndSurname() {
        return ownersNameAndSurname;
    }

    @Override
    public String toString() {

        return "current speed=" + currentSpeed + "; max speed=" + maxSpeed + "; amount of passengers=" + amountOfPassengers + "; max amount of passengers=" + maxAmountOfPassengers + "; owner's name and surname=" + ownersNameAndSurname;
    }

}
