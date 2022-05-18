package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CycleDao;
import entities.Bike;

public class Menu {

	
	private CycleDao CycleDao = new CycleDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Bikes", "Add Bike", "Delete Bike",
			"Update Bike", "EXIT");

	public void start() {
		String selection = "";

		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					displayBikes();
				} else if (selection.equals("2")) {
					addBike();					
				}else if (selection.equals("3")) {
					deleteBike();
				}else if (selection.equals("4")) {
					updateBike();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}


			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("5"));
	}


	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}


	private void displayBikes() throws SQLException {
		List<Bike> bikes = CycleDao.getBikes();
		System.out.println("Year\t" + "Make\t" + "Model\t" + "CC\t" + "ID");
		for (Bike bike : bikes) {
			System.out.println(
					bike.getYear() + "\t" + bike.getMake() + " "
							+ bike.getModel() + "\t "
							+ bike.getEngineSize() + "\t" + bike.getId());
		}
	}

	private void addBike() throws SQLException {
		System.out.print("Enter year of new Bike: ");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter make of new Bike: ");
		String make = scanner.nextLine();
		System.out.print("Enter model of new Bike: ");
		String model = scanner.nextLine();
		System.out.print("Enter engine size of new Bike: ");
		int engineSize = Integer.parseInt(scanner.nextLine());
		CycleDao.createNewBike(year, make, model, engineSize);
	}

	private void deleteBike() throws SQLException {
		System.out.print("Enter BIke ID to Delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		CycleDao.deleteBikeById(id);
	}
//
	private void updateBike() throws SQLException {
		System.out.print("Enter year of Bike to change: ");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter make of Bike to change: ");
		String make = scanner.nextLine();
		System.out.print("Enter model of new Bike to change: ");
		String model = scanner.nextLine();
		System.out.print("Enter engine size of Bike to change: ");
		int engineSize = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter ID of bike you wish to change: ");
		int id = Integer.parseInt(scanner.nextLine());
		CycleDao.updateBikeById(id, year, make, model, engineSize);
	}

}


