package de.bitnoise.sdc2012;


import de.bitnoise.sdc2012.model.DefaultWindow;
import de.bitnoise.sdc2012.model.GenericWindow;
import de.bitnoise.sdc2012.model.SecureWindow;
import de.bitnoise.sdc2012.model.Window;

public class Main {

	public static void main(String[] args) {
		DefaultWindow fenster1 = new DefaultWindow("fenster1");
		Window fenster2 = new GenericWindow("fenster2");
		SecureWindow fenster3 = new SecureWindow("fenster3");
		
		fenster1.open();
		fenster2.open();
		fenster3.open();
	}

}
