package de.bitnosie.sdc2012.sample02.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


@Log4j
@ToString
@AllArgsConstructor
public class DefaultWindow implements Window {

	String _name;

	public void open() {
		print();
	}

	void print() {
		log.info("DefaultWindow '" + _name + "' wird geoeffnet");		
	}

}
