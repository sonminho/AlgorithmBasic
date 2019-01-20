package edu.autocar.tourguide.command;

/**
 * <pre>
 * edu.autocar.tourguide.command
 * Command 인터페이스로써
 * 사용자는 입력 별로 execute 메서드를 정의해야한다.
 * </pre>
 */
public interface Command {
	void execute() throws Exception;
}
