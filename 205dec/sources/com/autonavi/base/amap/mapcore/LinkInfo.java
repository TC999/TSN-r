package com.autonavi.base.amap.mapcore;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public void setLength(int i4) {
        this.length = i4;
    }

    public void setState(int i4) {
        this.state = i4;
    }

    public void setTime(int i4) {
        this.time = i4;
    }

    public String toString() {
        return "\u72b6\u6001\uff1a" + this.state + "|\u65f6\u95f4\uff1a" + this.time + "|\u957f\u5ea6\uff1a" + this.length;
    }
}
