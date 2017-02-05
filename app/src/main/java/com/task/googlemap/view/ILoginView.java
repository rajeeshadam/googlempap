package com.task.googlemap.view;

/**
 * Created by Rajeesh adambil on 05/02/17
 */
public interface ILoginView {
	public void onClearText();
	public void onLoginResult(Boolean result, int code);
	public void onSetProgressBarVisibility(int visibility);
}
