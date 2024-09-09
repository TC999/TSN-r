package com.baidu.idl.face.platform.manager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public void setActiveAnimTime(int i4) {
        this.mActiveAnimTime = i4;
    }
}
