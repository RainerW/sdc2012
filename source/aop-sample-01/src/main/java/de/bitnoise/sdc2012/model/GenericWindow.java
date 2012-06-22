package de.bitnoise.sdc2012.model;

import org.apache.log4j.Logger;

import de.bitnoise.sdc2012.utils.Log;


@Log
public class GenericWindow implements Window {

	String _name;

	public String toString() {
		return _name;
	}
	
	public GenericWindow(String name) {
		_name = name;
	}

	public void open() {
		log.info("GenericWindow '" + _name + "' wird geoeffnet");
	}

}
