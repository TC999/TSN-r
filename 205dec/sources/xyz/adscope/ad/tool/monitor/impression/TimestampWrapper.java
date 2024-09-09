package xyz.adscope.ad.tool.monitor.impression;

import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TimestampWrapper<T> {
    public long mCreatedTimestamp = SystemClock.uptimeMillis();
    public final T mInstance;

    public TimestampWrapper(T t3) {
        this.mInstance = t3;
    }
}
