package com.jwplayer.opensourcedemo.videolist_v2;

import java.io.Serializable;

public class VideoItemData implements Serializable {

    /**
     * topicImg : http://vimg1.ws.126.net/image/snapshot/2016/4/7/G/VBILRDA7G.jpg
     * replyCount : 0
     * mp4Hd_url : null
     * topicDesc : 此诚哥非彼诚哥
     * topicSid : VBILRDA7E
     * replyBoard : video_bbs
     * videoTopic : {"alias":"此诚哥非彼诚哥","tname":"诚哥讲笑话","ename":"T1460515708449",
     * "tid":"T1460515708449"}
     * sectiontitle :
     * description : 我的天，他是怎么做到的。。。
     * replyid : BKQP3436008535RB
     * playersize : 1
     * m3u8Hd_url : null
     * m3u8_url : http://flv2.bn.netease.com/videolib3/1604/28/fVobI0704/SD/movie_index.m3u8
     * topicName : 诚哥讲笑话
     */

    int type;

    String cover;

    int playCount;

    String title;

    String mp4_url;

    String ptime;

    String vid;

    int length;

    String videosource;

    private String topicImg;

    private int replyCount;

    private Object mp4Hd_url;

    private String topicDesc;

    private String topicSid;

    private String replyBoard;

    private VideoTopicBean videoTopic;

    private String sectiontitle;

    private String description;

    private String replyid;

    private int playersize;

    private Object m3u8Hd_url;

    private String m3u8_url;

    private String topicName;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    boolean isPlaying;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    int currentPositon;

    public int getCurrentPositon() {
        return currentPositon;
    }

    public void setCurrentPositon(int currentPositon) {
        this.currentPositon = currentPositon;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Object getMp4Hd_url() {
        return mp4Hd_url;
    }

    public void setMp4Hd_url(Object mp4Hd_url) {
        this.mp4Hd_url = mp4Hd_url;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicSid() {
        return topicSid;
    }

    public void setTopicSid(String topicSid) {
        this.topicSid = topicSid;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public VideoTopicBean getVideoTopic() {
        return videoTopic;
    }

    public void setVideoTopic(VideoTopicBean videoTopic) {
        this.videoTopic = videoTopic;
    }

    public String getSectiontitle() {
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle) {
        this.sectiontitle = sectiontitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public int getPlayersize() {
        return playersize;
    }

    public void setPlayersize(int playersize) {
        this.playersize = playersize;
    }

    public Object getM3u8Hd_url() {
        return m3u8Hd_url;
    }

    public void setM3u8Hd_url(Object m3u8Hd_url) {
        this.m3u8Hd_url = m3u8Hd_url;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public static class VideoTopicBean {

        /**
         * alias : 此诚哥非彼诚哥
         * tname : 诚哥讲笑话
         * ename : T1460515708449
         * tid : T1460515708449
         */

        private String alias;

        private String tname;

        private String ename;

        private String tid;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }
}
