package de.bitnosie.sdc2012.sample02;

import de.bitnosie.sdc2012.sample02.model.DefaultWindow;
import de.bitnosie.sdc2012.sample02.model.GenericWindow;
import de.bitnosie.sdc2012.sample02.model.SecureWindow;
import de.bitnosie.sdc2012.sample02.model.Window;



public class Main {

	public static void main(String[] args) {
		DefaultWindow fenster1 = new DefaultWindow("fenster1");
		Window fenster2 = new GenericWindow("fenster2");
		SecureWindow fenster3 = new SecureWindow("fenster3");
		
		fenster1.open();
		fenster2.open();
		fenster3.open();
		
		System.out.println(fenster2);
	}

}
