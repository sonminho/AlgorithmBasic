package edu.autocar.tourguide.util;

import java.util.List;

import edu.autocar.tourguide.domain.TourGuide;

/**
 * <pre>
 * edu.autocar.tourguide.util
 * TourGuide 객체 출력 클래스
 * </pre>
 */
public class Print {
	/**
	 * @param t
	 * 하나의 TourGuide 객체 출력 
	 */
	public static void print(TourGuide t) {
		System.out.println("번호\t\t\t관광지명\t\t도시명\t\t\t지역명");
		System.out.println("=======================================================================================================================================================");
		System.out.printf("%3s %25s %20s %25s\n", t.getTourNo() ,t.getTourName(), t.getCity(), t.getArea());
		System.out.println();
	}
	
	/**
	 * @param list
	 * TourGuide 타입 리스트의 모든 객체 출력 
	 */
	public static void print(List<TourGuide> list) {
		System.out.println("번호\t\t\t관광지명\t\t도시명\t\t\t지역명");
		System.out.println("=======================================================================================================================================================");
		for(TourGuide t : list)
			System.out.printf("%3s %25s %20s %25s\n", t.getTourNo() ,t.getTourName(), t.getCity(), t.getArea());
		System.out.println();
	}
}
