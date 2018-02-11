package com.fan.littleexpression.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import com.fan.littleexpression.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Fan on 2018/2/7.
 */

public class SaveBit {
    public static void save(BitmapDrawable bit, String filename, Context context){
        String dir= Environment.getExternalStorageDirectory().toString()+"/tencent/QQ_Favorite/";
        File file=new File(dir,filename);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            Bitmap bitmap=bit.getBitmap();
            bitmap.compress(Bitmap.CompressFormat.PNG,85,fileOutputStream);
            fileOutputStream.flush();;
            fileOutputStream.close();
            MediaStore.Images.Media.insertImage(context.getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
            Toast.makeText(context,context.getString(R.string.save_ok),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
