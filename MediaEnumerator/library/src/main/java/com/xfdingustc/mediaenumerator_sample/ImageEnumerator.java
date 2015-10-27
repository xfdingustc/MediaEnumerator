package com.xfdingustc.mediaenumerator_sample;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/10/27.
 */
public class ImageEnumerator implements IMediaEnumerator {
    private Context context;

    public ImageEnumerator(Context context) {
        this.context = context;
    }

    @Override
    public List<?> enumerate() {
        List<Image> list = null;
        if (context != null) {
            Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null,
                null, null);
            if (cursor != null) {
                list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    int id = cursor
                        .getInt(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media._ID));
                    String title = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.TITLE));
                    String path = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                    String displayName = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                    String mimeType = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE));
                    long size = cursor
                        .getLong(cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.SIZE));
                    Image audio = new Image(id, title, displayName, mimeType,
                        path, size);
                    list.add(audio);
                }
                cursor.close();
            }
        }
        return list;
    }
}
