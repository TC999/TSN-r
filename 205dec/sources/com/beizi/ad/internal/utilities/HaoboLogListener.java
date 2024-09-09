package com.beizi.ad.internal.utilities;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class HaoboLogListener {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum LOG_LEVEL {
        V,
        D,
        I,
        W,
        E
    }

    public abstract LOG_LEVEL getLogLevel();

    public abstract void onReceiveMessage(LOG_LEVEL log_level, String str, String str2);

    public abstract void onReceiveMessage(LOG_LEVEL log_level, String str, String str2, Throwable th);
}
