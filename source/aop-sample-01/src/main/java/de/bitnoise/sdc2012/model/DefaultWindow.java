package de.bitnoise.sdc2012.model;

import org.apache.log4j.Logger;

import de.bitnoise.sdc2012.utils.Audit;
import de.bitnoise.sdc2012.utils.Log;


@Log
public class DefaultWindow implements Window {

	String _name;

	public String toString() {
		return _name;
	}

	public DefaultWindow(String name) {
		_name = name;
	}

	@Audit
	public void open() {
		print();
	}

	void print() {
		log.info("DefaultWindow '" + _name + "' wird geoeffnet");		
	}

}
