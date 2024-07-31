package com.autonavi.base.amap.mapcore;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LinkInfo {
    private int state = 0;
    private int time = 0;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public String toString() {
        return "状态：" + this.state + "|时间：" + this.time + "|长度：" + this.length;
    }
}
