package com.xfdingustc.mediaenumerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/10/26.
 */
public class BrowseVideoActivity extends AppCompatActivity {

    @Bind(R.id.rvVideoList)
    RecyclerView mRvVideoList;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, BrowseVideoActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_browse_video);
        ButterKnife.bind(this);
        setupVideoListRv();
    }

    private void setupVideoListRv() {
        mRvVideoList.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
