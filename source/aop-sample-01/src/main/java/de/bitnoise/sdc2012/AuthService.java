package de.bitnoise.sdc2012;

import de.bitnoise.sdc2012.model.Right;

public enum AuthService {
	INSTANCE;

	Right current;

	public boolean hasRight(Right right) {
		return current != null && current.equals(right);
	}

	public void makeAdmin() {
		current = Right.ADMIN;
	}

	public void makeUser() {
		current = Right.USER;
	}

	public void needs(Right needed) {
		if(!hasRight(needed)) {
			throw new SecurityException();
		}
	}

}
