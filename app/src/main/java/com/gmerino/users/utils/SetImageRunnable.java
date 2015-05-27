package com.gmerino.users.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Dirty (but fast) class, to set an image
 */
public class SetImageRunnable implements Runnable {

    private String url;
    private ImageView v;

    public SetImageRunnable(String url, ImageView v) {
        this.url = url;
        this.v = v;
    }

    @Override
    public void run() {
        URL url = null;
        try {
            url = new URL(this.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (url != null) {
            try {
                final Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                if (v != null) {
                    v.post(new Runnable() {
                        @Override
                        public void run() {
                            v.setImageBitmap(bmp);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
