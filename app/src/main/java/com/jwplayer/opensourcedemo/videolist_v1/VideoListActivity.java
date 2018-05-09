package com.jwplayer.opensourcedemo.videolist_v1;

import com.google.gson.Gson;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jwplayer.opensourcedemo.R;
import com.jwplayer.opensourcedemo.videolist_v2.VideoListData;
import com.jwplayer.opensourcedemo.videolist_v2.VideoListLayout;
import com.longtailvideo.jwplayer.JWPlayerView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VideoListActivity extends AppCompatActivity implements VideoListAdapter
    .JWPlayerListener {

    private RecyclerView videoList;

    private VideoListLayout videoListFix;

    private VideoListData listData;

    private boolean isFullScreen;

    private JWPlayerView jwPlayerView;

    private VideoListAdapter videoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        initVideoList();
        // TODO: 2018/5/9  This is a plan for repair as a reference.
        // TODO: 2018/5/9  or you can do it yourself with other plan.
//        initVideoListFix();
    }

    private void initVideoListFix() {
        videoListFix = findViewById(R.id.rv_video_list_fix);
    }

    private void initVideoList() {
        videoList = findViewById(R.id.video_list);
        videoList.setLayoutManager(new LinearLayoutManager(this));
        videoListAdapter = new VideoListAdapter(this);
        videoListAdapter.setJWPlayerListener(this);
        videoList.setAdapter(videoListAdapter);
        String data = readTextFileFromRawResourceId(this, R.raw.video_list);
        listData = new Gson().fromJson(data, VideoListData.class);
        videoListAdapter.refresh(listData.getList());
    }

    public String readTextFileFromRawResourceId(Context context, int resourceId) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(context.getResources().openRawResource(
                resourceId)));
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                builder.append(line).append("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    @Override
    public void onFullscreen(boolean isFullScreen, JWPlayerView jwPlayerView) {
        this.isFullScreen = isFullScreen;
        this.jwPlayerView = jwPlayerView;
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (isFullScreen) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (jwPlayerView != null && isFullScreen) {
            jwPlayerView.setFullscreen(false, true);
        } else {
            super.onBackPressed();
        }
    }
}
