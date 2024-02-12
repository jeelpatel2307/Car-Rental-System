import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Car {
    private String make;
    private String model;
    private int year;
    private boolean available;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

class CarRentalSystem {
    private Map<String, Car> cars;

    public CarRentalSystem() {
        cars = new HashMap<>();
    }

    public void addCar(String make, String model, int year) {
        String key = make + " " + model;
        cars.put(key, new Car(make, model, year));
    }

    public void rentCar(String make, String model) {
        String key = make + " " + model;
        Car car = cars.get(key);
        if (car != null && car.isAvailable()) {
            car.setAvailable(false);
            System.out.println("Rented: " + car);
        } else {
            System.out.println("Car not available for rent.");
        }
    }

    public void returnCar(String make, String model) {
        String key = make + " " + model;
        Car car = cars.get(key);
        if (car != null && !car.isAvailable()) {
            car.setAvailable(true);
            System.out.println("Returned: " + car);
        } else {
            System.out.println("Car already available for rent.");
        }
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars.values()) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }
}

public class CarRentalSystemApp {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        system.addCar("Toyota", "Camry", 2020);
        system.addCar("Honda", "Civic", 2019);
        system.addCar("Ford", "Focus", 2018);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Display available cars");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter make of car to rent: ");
                    String rentMake = scanner.nextLine();
                    System.out.print("Enter model of car to rent: ");
                    String rentModel = scanner.nextLine();
                    system.rentCar(rentMake, rentModel);
                    break;
                case 2:
                    System.out.print("Enter make of car to return: ");
                    String returnMake = scanner.nextLine();
                    System.out.print("Enter model of car to return: ");
                    String returnModel = scanner.nextLine();
                    system.returnCar(returnMake, returnModel);
                    break;
                case 3:
                    system.displayAvailableCars();
                    break;
                case 4:
                    System.out.println("Thank you for using the Car Rental System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
