package de.bitnoise.sdc2012.model;

import org.apache.log4j.Logger;

import de.bitnoise.sdc2012.AuthService;
import de.bitnoise.sdc2012.utils.Audit;
import de.bitnoise.sdc2012.utils.Log;

@Log
public class SecureWindow extends GenericWindow {

	public SecureWindow(String name) {
		super(name);
	}

	@Audit
	public void open() {
		AuthService.INSTANCE.needs(Right.ADMIN);
		log.info("SecureWindow '" + _name + "' wird geoeffnet");
	}
}
