package de.bitnoise.sdc2012.sample01;

import org.apache.log4j.Logger;

import de.bitnoise.sdc2012.AuthService;
import de.bitnoise.sdc2012.model.Right;
import de.bitnoise.sdc2012.model.Window;

public aspect Security {
	pointcut fensterOpen() : execution(* Window2.open(..) );

	Logger log = Logger.getLogger(Security.class);

	before() : fensterOpen()  {
		log.info("open() : before " + thisJoinPoint.getThis());
		AuthService.INSTANCE.needs(Right.ADMIN);
	}

	// after, after returning, after throwing
	after(Window _this) : fensterOpen() && this(_this) {
		log.info("open() : after " + _this.toString());
	}
}
