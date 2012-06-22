package de.bitnoise.sdc2012.sample03;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.JoinPoint.EnclosingStaticPart;

import de.bitnoise.sdc2012.utils.Audit;

public aspect AuditTrail {

	pointcut trail() :  execution(@Audit * *.*(..));

	Object around() : trail() {
		Signature sig = thisEnclosingJoinPointStaticPart.getSignature();
		Logger logger = Logger.getLogger(sig.getDeclaringType());
		logger.info("Audit Trail - entering " + pretty(sig));
		Object result = proceed();
		logger.info("Audit Trail - leaving " + pretty(sig));
		return result;
	}

	after() throwing (Throwable ex) : trail() {
		Signature sig = thisEnclosingJoinPointStaticPart.getSignature();
		Logger logger = Logger.getLogger(sig.getDeclaringType());
		logger.error("Audit Trail - leaving with exception '" + ex.toString()
				+ "' " + pretty(thisEnclosingJoinPointStaticPart));
	}

	String pretty(Signature sig) {
		return sig.getDeclaringTypeName() + "::" + sig.getName() + "()";
	}

	String pretty(StaticPart sp) {
		Signature sig = sp.getSignature();
		return pretty(sig) + " at " + sp.getSourceLocation();
	}
}
