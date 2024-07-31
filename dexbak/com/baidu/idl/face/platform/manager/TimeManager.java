package com.baidu.idl.face.platform.manager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TimeManager {
    private static TimeManager instance;
    private int mActiveAnimTime;

    private TimeManager() {
    }

    public static TimeManager getInstance() {
        if (instance == null) {
            synchronized (TimeManager.class) {
                if (instance == null) {
                    instance = new TimeManager();
                }
            }
        }
        return instance;
    }

    public int getActiveAnimTime() {
        return this.mActiveAnimTime;
    }

    public void setActiveAnimTime(int i) {
        this.mActiveAnimTime = i;
    }
}
