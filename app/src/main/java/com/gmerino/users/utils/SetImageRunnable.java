package com.gmerino.users.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
