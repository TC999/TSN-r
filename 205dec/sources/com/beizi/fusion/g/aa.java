package com.beizi.fusion.g;

import android.os.Handler;
import android.os.Looper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HandlerUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f14743a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j4) {
        f14743a.postDelayed(runnable, j4);
    }
}
