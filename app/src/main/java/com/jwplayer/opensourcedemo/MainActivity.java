package com.jwplayer.opensourcedemo;

import com.jwplayer.opensourcedemo.videolist_v1.VideoListActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToListDemo(View view) {
        startActivity(new Intent(this, VideoListActivity.class));
    }

    public void goToJWPlayerDemo(View view) {
        startActivity(new Intent(this, JWPlayerViewExample.class));

    }
}
