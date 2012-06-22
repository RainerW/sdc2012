package de.bitnoise.sdc2012.sample02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.apache.log4j.Logger;
import de.bitnoise.sdc2012.utils.Log;

import de.bitnoise.sdc2012.model.Window;
import de.bitnoise.sdc2012.model.DefaultWindow;

public aspect Logging {

	public interface HasLogger {}

	public Logger HasLogger.log;

	Logger around() : get(Logger HasLogger.log) {
		Logger current = proceed();
		if (current == null) {
			current = Logger.getLogger(thisEnclosingJoinPointStaticPart
					.getSignature().getDeclaringType());
		}
		return current;
	}

	declare parents : @Log * implements HasLogger;

	pointcut methodsToLog() : execution(* *.*(..)) && cflow( within(@Log *) );

	StringBuilder depth = new StringBuilder();

	before() : methodsToLog() {
		Class clazz = thisEnclosingJoinPointStaticPart.getSignature()
				.getDeclaringType();
		Logger logger = Logger.getLogger(clazz);
		logger.info("> entering " + thisJoinPoint);
		depth.append("  ");
	}

	after() : methodsToLog() {
		int ende = depth.length();
		depth.delete(ende - 2, ende);
		Class clazz = thisEnclosingJoinPointStaticPart.getSignature()
				.getDeclaringType();
		Logger logger = Logger.getLogger(clazz);
		logger.info("< leaving  " + thisJoinPoint);
	}

	pointcut identLog(String param) : call(* Logger.*(..)) && args(param);

	Object around(String param) : identLog(param) {
		return proceed("| " + depth.toString() + param);
	}
}
