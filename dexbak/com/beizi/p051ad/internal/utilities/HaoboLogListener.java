package com.beizi.p051ad.internal.utilities;

/* renamed from: com.beizi.ad.internal.utilities.HaoboLogListener */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class HaoboLogListener {

    /* renamed from: com.beizi.ad.internal.utilities.HaoboLogListener$LOG_LEVEL */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
