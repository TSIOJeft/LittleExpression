package com.fan.littleexpression.data;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;

/**
 * Created by Fan on 2018/2/7.
 */

public class AssetsFileName {
    public static String[] getFileName(Context context,String p){
        AssetManager assets = context.getAssets();
        try {
            String[] paths = assets.list(p);
            return paths;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
