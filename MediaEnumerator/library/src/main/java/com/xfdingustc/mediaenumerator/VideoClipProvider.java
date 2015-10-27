package com.xfdingustc.mediaenumerator;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/10/27.
 */
public class VideoClipProvider implements IMediaProvider {
    private Context context;

    public VideoClipProvider(Context context) {
        this.context = context;
    }

    @Override
    public List<?> getList() {
        List<VideoClip> list = null;
        if (context != null) {
            Cursor cursor = context.getContentResolver().query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null,
                null, null);
            if (cursor != null) {
                list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media._ID));
                    String title = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
                    String album = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM));
                    String artist = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST));
                    String displayName = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                    String mimeType = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE));
                    String path = cursor
                        .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                    long duration = cursor
                        .getInt(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
                    long size = cursor
                        .getLong(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                    VideoClip video = new VideoClip(id, title, album, artist, displayName,
                        mimeType, path, size, duration);
                    list.add(video);
                }
                cursor.close();
            }
        }
        return list;
    }
}
