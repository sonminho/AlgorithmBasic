package edu.autocar.tourguide.command;

import edu.autocar.tourguide.dao.ConnectionProvider;

/**
 * <pre>
 * edu.autocar.tourguide.command
 * 애플리케이션을 종료하는 클래스이다.
 * </pre>
 */
public class ExitCommand implements Command{

	@Override
	public void execute() throws Exception {
		System.out.println("\n종료합니다.\n");
		ConnectionProvider.getSqlSession().close();
		System.exit(0);
	}

}
