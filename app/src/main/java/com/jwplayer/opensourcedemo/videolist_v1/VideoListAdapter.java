package com.jwplayer.opensourcedemo.videolist_v1;

import com.jwplayer.opensourcedemo.R;
import com.jwplayer.opensourcedemo.videolist_v2.VideoAdapter;
import com.jwplayer.opensourcedemo.videolist_v2.VideoItemData;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2018/5/8.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoViewHolder> {

    private List<VideoItemData> list;

    public VideoListAdapter(Context context) {
        list = new ArrayList<>();
    }

    @Override
    public VideoListAdapter.VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoListAdapter.VideoViewHolder holder = new VideoListAdapter.VideoViewHolder(view);
        view.setTag(holder);
        return new VideoListAdapter.VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoListAdapter.VideoViewHolder holder, int position) {
        holder.update(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refresh(List<VideoItemData> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        private JWPlayerView jwPlayerView;

        public VideoViewHolder(View itemView) {
            super(itemView);
            jwPlayerView = (JWPlayerView) itemView.findViewById(R.id.jwplayer);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void update(final int position) {
            title.setText(list.get(position).getTitle());
            title.setText(list.get(position).getVideosource());
            initJwPlayerView(jwPlayerView, list.get(position), position);
        }

        private void initJwPlayerView(final JWPlayerView jwPlayerView, VideoItemData videoItemData,
            int position) {
            PlaylistItem pi = new PlaylistItem.Builder()
                .title(videoItemData.getTitle())
                .file(videoItemData.getM3u8_url())
                .build();
            jwPlayerView.load(pi);
            jwPlayerView.addOnFullscreenListener(new VideoPlayerEvents.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean b) {
                    if (jwPlayerListener != null) {
                        jwPlayerListener.onFullscreen(b, jwPlayerView);
                    }
                }
            });
        }
    }

    JWPlayerListener jwPlayerListener;

    public void setJWPlayerListener(JWPlayerListener jwPlayerListener) {
        this.jwPlayerListener = jwPlayerListener;
    }

    public interface JWPlayerListener {

        void onFullscreen(boolean isFullScreen, JWPlayerView jwPlayerView);
    }
}
