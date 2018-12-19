package edu.autocar.contact.command;

public class ExitCommand implements Command {

	@Override
	public void execute() throws Exception {
		System.out.println("종료합니다.");
		System.exit(0);
	}

}
