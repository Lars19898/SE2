package com.example.control;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.Hotel;

public class HotelSearch {
	
	
	Hotel hotel1=new Hotel("Kameha",1, "Bonn", "*****");
	Hotel hotel4=new Hotel("Hotel Königshof",2, "Bonn", "*****");
	Hotel hotel2=new Hotel("4Seasons",2, "Hamburg", "*****");
	Hotel hotel3=new Hotel("Bayerischer Hof",3, "München", "*****");
	private static HotelSearch search = null;

	private HotelSearch() {

	}

	public static HotelSearch getinstance() {
		if (search == null) {
			search = new HotelSearch();
		}

		return search;
	}
	
	
	public List <Hotel> getHotelbyOrt(String or){
		List <Hotel> hotelliste=new ArrayList<>();
		
		if(or.equals("Bonn"))hotelliste.add(hotel1); hotelliste.add(hotel4);
		if(or.equals("Hamburg"))hotelliste.add(hotel2);
		if(or.equals("München"))hotelliste.add(hotel3);
		
		return hotelliste;
	}

}
