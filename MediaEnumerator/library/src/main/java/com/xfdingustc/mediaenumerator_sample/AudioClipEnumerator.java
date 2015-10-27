package com.xfdingustc.mediaenumerator_sample;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/10/27.
 */
public class AudioClipEnumerator implements IMediaEnumerator {
    private Context context;

    public AudioClipEnumerator(Context context) {
        this.context = context;
    }

    @Override
    public List<?> enumerate() {
        List<AudioClip> list = null;
        if (context != null) {
            Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null,
                null, null);
            if (cursor != null) {
                list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                    String title = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                    String album = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                    String artist = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                    String path = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                    String displayName = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                    String mimeType = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));
                    long duration = cursor
                        .getInt(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                    long size = cursor
                        .getLong(cursor
                            .getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                    AudioClip audio = new AudioClip(id, title, album, artist, path,
                        displayName, mimeType, duration, size);
                    list.add(audio);
                }
                cursor.close();
            }
        }
        return list;
    }
}
