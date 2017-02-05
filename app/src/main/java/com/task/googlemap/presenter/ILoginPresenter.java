package com.task.googlemap.presenter;

/**
 * Created by Rajeesh adambil on 05/02/17
 */
public interface ILoginPresenter {
	void clear();
	void doLogin(String name, String passwd);
	void setProgressBarVisiblity(int visiblity);
}
