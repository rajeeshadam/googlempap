package com.task.googlemap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import com.task.googlemap.presenter.ILoginPresenter;
import com.task.googlemap.presenter.LoginPresenterCompl;
import com.task.googlemap.view.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by Rajeesh adambil on 05/02/17
 */

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
	@Bind(R.id.txtname)
	protected AutoCompleteTextView editUser;
	@Bind(R.id.txtpassword)
	protected AutoCompleteTextView editPass;
	@Bind(R.id.btnSignUp)
	protected Button btnLogin;
	@Bind(R.id.btnClear)
	protected Button btnClear;
	@Bind(R.id.progress_login)
	protected ProgressBar progressBar;

	ILoginPresenter loginPresenter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ButterKnife.bind(this);
		//set listener
		btnLogin.setOnClickListener(this);
		btnClear.setOnClickListener(this);

		//init
		loginPresenter = new LoginPresenterCompl(this);
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btnClear:
				loginPresenter.clear();
				break;
			case R.id.btnSignUp:
                InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				loginPresenter.setProgressBarVisiblity(View.VISIBLE);
				btnLogin.setEnabled(false);
				btnClear.setEnabled(false);
				loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
				break;
		}
	}

	@Override
	public void onClearText() {
		editUser.setText("");
		editPass.setText("");
        editUser.refreshDrawableState();
        editPass.refreshDrawableState();
        editUser.requestFocus();
	}

	@Override
	public void onLoginResult(Boolean result, int code) {
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
		btnLogin.setEnabled(true);
		btnClear.setEnabled(true);
		switch (code) {
			case 1:
                editUser.setError("Please enter your name");
                editUser.requestFocus();
				break;
            case 2:
                editPass.setError("Please enter your password");
                editPass.requestFocus();
                break;
            case 3:
                editUser.setError("User name is wrong");
                editUser.requestFocus();
                break;
            case 4:
                editPass.setError("Password is wrong");
                editPass.requestFocus();
                break;
            case 5:
                SharedPreferences sharedPref = getSharedPreferences("LOGIN_STATUS", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor;
                editor = sharedPref.edit();
                editor.putBoolean("STATUS",true);
                editor.commit();
                Intent intent= new Intent(LoginActivity.this,MapsActivity.class);
                startActivity(intent);
                finish();
                break;
		}


	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onSetProgressBarVisibility(int visibility) {
		progressBar.setVisibility(visibility);
	}
	
}
