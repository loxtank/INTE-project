package org.pucko.core;

public class Program {

	public static void main(String[] args) {
		CommandFactory commandFactory = new CommandFactory();
		CommandRunner commandRunner = new CommandRunner();
		WorkingDirectory workingDirectory = new WorkingDirectory( / );
		
		Controller controller = new Controller(workingDirectory, commandRunner, commandFactory);
		
		Menu menu = new Menu(controller);
		
		menu.run();

	}

}