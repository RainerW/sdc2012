package de.bitnosie.sdc2012.sample02.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;



@Log
@ToString
@AllArgsConstructor
public class GenericWindow implements Window {

	String _name;

	public void open() {
		log.info("GenericWindow '" + _name + "' wird geoeffnet");
	}

}
