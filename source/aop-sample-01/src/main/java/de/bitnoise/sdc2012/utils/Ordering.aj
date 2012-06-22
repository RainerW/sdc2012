package de.bitnoise.sdc2012.utils;

public aspect Ordering {
	declare precedence: 
		de.bitnoise.sdc2012.sample03.AuditTrail, 
		de.bitnoise.sdc2012.sample01.Security,
		de.bitnoise.sdc2012.sample02.Logging
		;
}