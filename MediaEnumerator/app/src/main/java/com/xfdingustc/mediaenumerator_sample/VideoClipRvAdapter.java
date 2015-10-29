package com.xfdingustc.mediaenumerator_sample;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xfdingustc.mediaenumerator.VideoClip;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/10/27.
 */
public class VideoClipRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private List<VideoClip> mVideoClipList;

    public VideoClipRvAdapter(Context context) {
        this.mContext = context;
    }

    public void setVideoClipList(List<VideoClip> videoClipList) {
        this.mVideoClipList = videoClipList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_video_clip, parent, false);
        return new VideoClipRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContentResolver contentResolver = mContext.getContentResolver();

        VideoClip videoClip = mVideoClipList.get(position);
        Bitmap bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, videoClip.getId(),
            MediaStore.Images.Thumbnails.MINI_KIND, null);

        VideoClipRvViewHolder viewHolder = (VideoClipRvViewHolder)holder;
        viewHolder.mIvVideoThumbnail.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return mVideoClipList == null ? 0 : mVideoClipList.size();
    }



    public class VideoClipRvViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ivVideoThumbnail)
        ImageView mIvVideoThumbnail;

        public VideoClipRvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
