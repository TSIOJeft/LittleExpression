package com.fan.littleexpression.data;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Fan on 2018/2/4.
 */

public class Share {
    public Intent shareImage(Context context, String path, int p) {
        AssetManager assetManager = context.getAssets();
        String[] paths = new String[0];
        try {
            paths = assetManager.list(path);
            InputStream inputStream = assetManager.open(path+"/" + paths[p]);
            File file = new File(context.getExternalCacheDir() + "/hh.png");
            Uri uri = FileProvider.getUriForFile(context,"com.we.littleexpression.fileprovider",new AssetsFile().toFile(inputStream,file));
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareIntent.setType("image/*");
            return shareIntent;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
}
