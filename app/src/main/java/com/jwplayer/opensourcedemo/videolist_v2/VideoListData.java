package com.jwplayer.opensourcedemo.videolist_v2;

import java.io.Serializable;
import java.util.List;

public class VideoListData implements Serializable {

    private List<VideoItemData> list;

    public List<VideoItemData> getList() {
        return list;
    }

    public void setList(List<VideoItemData> list) {
        this.list = list;
    }
}
