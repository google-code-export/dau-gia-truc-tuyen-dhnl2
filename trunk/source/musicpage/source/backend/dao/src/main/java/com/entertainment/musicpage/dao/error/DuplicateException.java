package com.entertainment.musicpage.dao.error;

public class DuplicateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException(String whatError) {
		super(whatError);
	}
	
	
}
