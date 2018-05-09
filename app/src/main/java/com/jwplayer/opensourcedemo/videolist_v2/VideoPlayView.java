package com.jwplayer.opensourcedemo.videolist_v2;

import com.jwplayer.opensourcedemo.R;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.core.PlayerState;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Description 播放view
 */
public class VideoPlayView extends RelativeLayout {

    private JWPlayerView mVideoView;

    private Handler handler = new Handler();

    private boolean isPause;

    private View rView;

    private Context mContext;

    private boolean portrait;

    public VideoPlayView(Context context) {
        super(context);
        mContext = context;
        initData();
        initViews();
    }

    private void initData() {

    }

    private void initViews() {

        rView = LayoutInflater.from(mContext).inflate(R.layout.view_video_item, this, true);
        mVideoView = (JWPlayerView) findViewById(R.id.main_video);
        mVideoView.addOnCompleteListener(new VideoPlayerEvents.OnCompleteListener() {
            @Override
            public void onComplete() {

            }
        });
    }

    public boolean isPlay() {
        return true;
    }

    public void pause() {
        mVideoView.pause();
    }

    public void start(String path) {

    }

    public void seekTo(long msec) {
        mVideoView.seek(msec);
    }

    public void onChanged(Configuration configuration) {
        portrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT;
        doOnConfigurationChanged(portrait);
    }

    public void doOnConfigurationChanged(final boolean portrait) {
        if (mVideoView != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setFullScreen(!portrait);
                    if (portrait) {
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                        setLayoutParams(layoutParams);
                        requestLayout();
                    } else {
                        int heightPixels = ((Activity) mContext).getResources()
                            .getDisplayMetrics().heightPixels;
                        int widthPixels = ((Activity) mContext).getResources()
                            .getDisplayMetrics().widthPixels;
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        layoutParams.height = heightPixels;
                        layoutParams.width = widthPixels;
                        setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void stop() {
        mVideoView.stop();
    }

    public void onDestroy() {
        handler.removeCallbacksAndMessages(null);
    }

    private void setFullScreen(boolean fullScreen) {
        if (mContext != null && mContext instanceof Activity) {
            WindowManager.LayoutParams attrs = ((Activity) mContext).getWindow().getAttributes();
            if (fullScreen) {
                attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
                ((Activity) mContext).getWindow().setAttributes(attrs);
                ((Activity) mContext).getWindow()
                    .addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            } else {
                attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
                ((Activity) mContext).getWindow().setAttributes(attrs);
                ((Activity) mContext).getWindow()
                    .clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
        }

    }

    public void setShowContoller(boolean isShowContoller) {
    }

    public void release() {
    }

    public PlayerState VideoStatus() {
        /**
         IDLE,
         BUFFERING,
         PLAYING,
         PAUSED;
         */
        // TODO: 2018/5/9
        return mVideoView.getState().PAUSED;
    }

    private CompletionListener completionListener;

    public void setCompletionListener(CompletionListener completionListener) {
        this.completionListener = completionListener;
    }

    public JWPlayerView getPlayer() {
        return mVideoView;
    }

    public interface CompletionListener {

        void completion();
    }
}
