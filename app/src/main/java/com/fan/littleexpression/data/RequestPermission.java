package com.fan.littleexpression.data;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.fan.littleexpression.R;

/**
 * Created by Fan on 2018/2/7.
 */

public class RequestPermission {

    public static boolean checkPermission(Activity activity) {
        String PERMISSiON = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        if (ActivityCompat.checkSelfPermission(activity, PERMISSiON) != PackageManager.PERMISSION_GRANTED) {
            showPermission(activity);
            return false;
        }
        return true;
    }
    public static void showPermission(Activity activity){
        boolean is= ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(!is){
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},321);
        }else {
            Toast.makeText(activity,activity.getString(R.string.request_mes),Toast.LENGTH_SHORT).show();
        }

    }
}
