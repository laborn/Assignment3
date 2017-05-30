package facade;

import java.io.IOException;
import java.util.Scanner;

import menus.Menu;
import singleton.Logger;

public class UserInterface {

	static int choice;

	/**
	 * Create a Scanner object for input
	 */
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// Start the logger
		Logger.getInstance();
		Logger.initialize();

		// Call the menu and get the user's choice:
		choice = Menu.mainMenu();
		Menu.mainMenuChoices(choice);

		input.close();

	}
}
