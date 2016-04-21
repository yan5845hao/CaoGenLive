package com.ylsna.entity;

import android.graphics.Bitmap;

/**
 * Created by halsey on 16-4-21.
 */
public class UserInfo {
    /**
     * 用户ID
     */
    private int ID;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 电话号码
     */
    private int phone;
    /**
     * 房间号
     */
    private String roomNum;
    /**
     * 自我简介
     */
    private String selfIntroduce;
    /**
     * 头像
     */
    private Bitmap head;
    /**
     * 是否认证
     */
    private boolean authentication;
    /**
     * 关注数量
     */
    private int focusNum;
    /**
     * 粉丝数量
     */
    private int fansNum;
    /**
     * 直播时间
     */
    private int liveTime;

    public UserInfo() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce;
    }

    public Bitmap getHead() {
        return head;
    }

    public void setHead(Bitmap head) {
        this.head = head;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public int getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(int focusNum) {
        this.focusNum = focusNum;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public int getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(int liveTime) {
        this.liveTime = liveTime;
    }
}
