package de.bitnosie.sdc2012.sample02.model;

import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
public class SecureWindow extends GenericWindow {

	public SecureWindow(String name) {
		super(name);
	}
	public void open() {
		log.info("SecureWindow '" + _name + "' wird geoeffnet");
	}
}
