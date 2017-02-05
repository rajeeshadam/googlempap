package com.task.googlemap.model;

/**
 * Created by Rajeesh adambil on 05/02/17
 */
public interface IUser {
	String getName();

	String getPasswd();

	int checkUserValidity(String name, String passwd);
}
