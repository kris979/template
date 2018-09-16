package com.agisoft.paint.commands;

public class QuitCommand implements Command {

	@Override
	public void execute() {
		System.out.println("GoodBye!");
		System.exit(0);
	}

}
