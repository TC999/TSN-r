package com.beizi.ad.lance.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiExecutor.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f14356a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f14357b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14358c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14359d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14360e;

    private c() {
        if (f14356a.get()) {
            return;
        }
        a();
    }

    public static void a() {
        AtomicBoolean atomicBoolean = f14356a;
        if (atomicBoolean.get()) {
            return;
        }
        f14358c = e.a();
        f14359d = e.b();
        f14360e = e.c();
        atomicBoolean.set(true);
    }

    public static c b() {
        if (f14357b == null) {
            synchronized (c.class) {
                if (f14357b == null) {
                    f14357b = new c();
                }
            }
        }
        return f14357b;
    }

    public ExecutorService c() {
        if (f14358c == null) {
            f14358c = e.a();
        }
        return f14358c;
    }

    public ExecutorService d() {
        if (f14360e == null) {
            f14360e = e.c();
        }
        return f14360e;
    }
}
