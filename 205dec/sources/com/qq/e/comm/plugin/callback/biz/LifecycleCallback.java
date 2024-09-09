package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.h.b;
import com.qq.e.comm.plugin.h.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface LifecycleCallback extends b {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum a {
        AFTER_CREATED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED
    }

    c<a> l();
}
