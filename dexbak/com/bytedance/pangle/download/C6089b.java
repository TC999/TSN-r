package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.pangle.download.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6089b {

    /* renamed from: e */
    private static volatile C6089b f21932e;

    /* renamed from: a */
    final Map<String, Long> f21933a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Handler f21934b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public final Map<String, Runnable> f21935c = new ConcurrentHashMap();

    /* renamed from: d */
    final Map<String, Runnable> f21936d = new ConcurrentHashMap();

    private C6089b() {
    }

    /* renamed from: a */
    public static C6089b m37205a() {
        if (f21932e == null) {
            synchronized (C6089b.class) {
                if (f21932e == null) {
                    f21932e = new C6089b();
                }
            }
        }
        return f21932e;
    }
}
