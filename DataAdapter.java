package adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.InputMismatchException;
import java.util.Scanner;

import singleton.Logger;

public class DataAdapter {

	public DataAdapter() {
	}
	public static Scanner input = new Scanner(System.in);
	
	public static void tradesMenu() throws IOException {

		System.out.println("Enter one or more stock or mutual fund symbols separated by commas: ");
		// Get the investment symbols and statistics request from the user:
		try {
			String ticker = input.next();
			String symbol = "\"" + ticker + "\"";
			String statistics = "";

			System.out.println("\n" + "Requested the following: " + symbol + "\n");

			String menuChoice = statisticsMenu();
			System.out.println(menuChoice);

			statistics = statisticsChoice(menuChoice);
			YahooFinance yf = new YahooFinance(symbol, statistics);
			//System.out.println("URL for Yahoo:   " + yf.getURL(symbol, statistics) + "\n");
			URLConnection urlConn = yf.getURL(symbol, statistics).openConnection();
			InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
			BufferedReader buffer = new BufferedReader(inStream);
			String line = buffer.readLine();
			while (line != null) {
				Logger.append(line);
				System.out.println("Yahoo stats (Symbol, Name, Last Trade Price, Time, P/E, PEG: " + line + "\n");
				System.out.println();
				line = buffer.readLine();
			}
			GoogleFinance gf = new GoogleFinance(symbol, statistics);
			System.out.println("URL for Google:     " + gf.getURL(symbol, statistics));
		} catch (InputMismatchException e) {
			System.out.println("Not investment symbols. Try again.");
		}
	}

	public static String statisticsChoice(String menuChoice) throws IOException {

		String statistics = "sn";

		for (int i = 0; i < menuChoice.length(); i++) {
			if (menuChoice.charAt(i) == '1') {
				statistics = statistics + "l1t1";
				Logger.append("Chose last trade price\n");
			} else if (menuChoice.charAt(i) == '2') {
				statistics = statistics + "r";
				Logger.append("Chose P/E ratio\n");
			} else if (menuChoice.charAt(i) == '3') {
				statistics = statistics + "r5";
				Logger.append("Chose PEG ratio\n");
			} else if (menuChoice.charAt(i) == ',') {
				Logger.append("Comma found\n");
			}
		}
		return statistics;
	}

	public static String statisticsMenu() throws InputMismatchException {

		System.out.println("Choose statistics by number separated by commas: ");
		System.out.println("1. Last Trade Price");
		System.out.println("2. P/E Ratio");
		System.out.println("3. PEG");

		// Get user's choice:
		try {
			String statsChoice = input.next();
			return statsChoice;
		} catch (InputMismatchException e) {
			System.out.println("Not numbers from 1 to 3 separated by commas. Try again.");
			return null;
		}
	}

}
