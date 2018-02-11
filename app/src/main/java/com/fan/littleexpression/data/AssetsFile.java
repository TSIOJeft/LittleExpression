package com.fan.littleexpression.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Fan on 2018/2/4.
 */

public class AssetsFile {
    public File toFile(InputStream inputStream,File f){
        try {
            OutputStream outputStream=new FileOutputStream(f);
            byte buffer[]=new byte[1020];
            int length=0;
            while ((length=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            outputStream.close();
            inputStream.close();
            return f;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return null;
    }
}
