package util;

import java.security.NoSuchAlgorithmException;

import beans.User;

public class Authenticate {
	public static boolean equal(User usr,String hashPass) throws NoSuchAlgorithmException {
		return hashPass.equals(usr.getPassword());
	}
}
