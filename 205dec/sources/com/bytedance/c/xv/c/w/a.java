package com.bytedance.c.xv.c.w;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f26655a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f26656b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f26657c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ScheduledExecutorService f26658d;

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap<String, d> f26659e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentHashMap<String, d> f26660f = new ConcurrentHashMap<>();

    private a() {
        f26656b = c.a();
        f26657c = c.b();
        f26658d = c.c();
    }

    public static a a() {
        if (f26655a == null) {
            synchronized (a.class) {
                if (f26655a == null) {
                    f26655a = new a();
                }
            }
        }
        return f26655a;
    }

    public void b(d dVar) {
        if (dVar != null) {
            if (f26656b != null) {
                f26656b.execute(dVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("param is not be null");
    }
}
