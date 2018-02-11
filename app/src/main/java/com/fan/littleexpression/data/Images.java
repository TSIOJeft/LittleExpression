package com.fan.littleexpression.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Fan on 2018/2/4.
 */

public class Images {
    public static ArrayList<BitmapDrawable> getImages(Context context, String p){
    ArrayList<BitmapDrawable>data=new ArrayList<>();
        if (context != null && data.isEmpty()) {
            try {
                AssetManager assets = context.getAssets();
                String[] paths = assets.list(p);
                for (String path : paths) {
                    InputStream image = assets.open(p+"/" + path);
                    data.add(new BitmapDrawable(context.getResources(), image));
                }
                return data;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
