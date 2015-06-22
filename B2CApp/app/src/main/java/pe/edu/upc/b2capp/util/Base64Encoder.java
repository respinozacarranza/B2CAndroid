package pe.edu.upc.b2capp.util;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jose on 21/06/2015.
 */
public class Base64Encoder {

    public static String getEncodedImage(String path) {
        byte[] bytes;
        try {
            InputStream inputStream = new FileInputStream(path);
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            try {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Base64Encoder", e.getMessage());
            }
            bytes = output.toByteArray();
            String temp = Base64.encodeToString(bytes, Base64.NO_WRAP | Base64.URL_SAFE);
            return temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("Base64Encoder", e.getMessage());
        }
        return null;
    }
}
