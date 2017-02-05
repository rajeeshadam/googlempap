package com.task.googlemap.model;

/**
 * Created by Rajeesh adambil on 05/02/17
 */
public class UserModel implements IUser {
	String name;
	String passwd;

	public UserModel(String name, String passwd) {
		this.name = name;
		this.passwd = passwd;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPasswd() {
		return passwd;
	}

	@Override
	public int checkUserValidity(String name, String passwd){
		if (name==null || name.isEmpty()){
			return 1;
		}else if(passwd==null || passwd.isEmpty()){
			return 2;
		}
		else if(!name.equals(getName())){
			return 3;

		}else if(!passwd.equals(getPasswd())){
			return 4;
		}else{

			return 5;
		}

	}
}
