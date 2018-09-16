package com.agisoft.paint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.agisoft.paint.commands.Command;

public class Main {
	
	private InputConverter converter = new InputConverter();

	public void run() {
		System.out.print("Enter command:");
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while (scanner.hasNext()) {
			execute(scanner);
		}
		scanner.close();
	}

	private void execute(Scanner scanner) {
		String input = scanner.nextLine();
		Command cmd = converter.convert(input);
		cmd.execute();
		System.out.print("\nEnter command:");
	}
	
	public static void main(String[] args) {
		Main paint = new Main();
		paint.run();
	}
}
