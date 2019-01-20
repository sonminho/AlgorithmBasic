package edu.autocar.tourguide.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourGuide {
	private String tourNo;
	private String tourName;
	private String city;
	private String area;
	private String content;
	private String location;
	private String homePage;
}
