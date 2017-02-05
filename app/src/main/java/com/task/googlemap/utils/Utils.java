package com.task.googlemap.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

import com.task.googlemap.LoginActivity;

/**
 * Created by Rajeesh adambil on 05/02/17
 */
public class Utils {
    private static Utils singleton =new Utils();
    private Snackbar skbar;
    public Utils(){

    }
    public static Utils getInstance( ) {
        return singleton;
    }
    public void CustomMessage(Context context, String message) {
        try {
            View v = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
            Snackbar.make(v, message, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }catch (Exception e)
        {

        }

    }
    public  boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }


    }
    public void logout(final Context context) {
        android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(context)
                .setMessage("Do you want to logout?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPref = context.getSharedPreferences("LOGIN_STATUS", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean("STATUS",false);
                        editor.commit();
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })

                .create();
        dialog.show();

    }
    public void showAbout(Context context) {
        android.support.v7.app.AlertDialog dialog = new android.support.v7.app.AlertDialog.Builder(context)
                .setMessage("Developed by Rajeesh adambil")
                .setCancelable(true)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })

                .create();
        dialog.show();
    }
}

