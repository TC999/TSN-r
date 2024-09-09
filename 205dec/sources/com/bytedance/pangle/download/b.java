package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static volatile b f28693e;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Long> f28694a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f28695b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Runnable> f28696c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<String, Runnable> f28697d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f28693e == null) {
            synchronized (b.class) {
                if (f28693e == null) {
                    f28693e = new b();
                }
            }
        }
        return f28693e;
    }
}
