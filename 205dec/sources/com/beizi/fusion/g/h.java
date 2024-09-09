package com.beizi.fusion.g;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiExecutor.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f14915a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private static volatile h f14916b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14917c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14918d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14919e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f14920f;

    private h() {
        if (f14915a.get()) {
            return;
        }
        a();
    }

    public static void a() {
        AtomicBoolean atomicBoolean = f14915a;
        if (atomicBoolean.get()) {
            return;
        }
        f14917c = l.a();
        f14918d = l.b();
        f14919e = l.c();
        f14920f = l.d();
        atomicBoolean.set(true);
    }

    public static h b() {
        if (f14916b == null) {
            synchronized (h.class) {
                if (f14916b == null) {
                    f14916b = new h();
                }
            }
        }
        return f14916b;
    }

    public ExecutorService c() {
        if (f14917c == null) {
            f14917c = l.a();
        }
        return f14917c;
    }

    public ExecutorService d() {
        if (f14918d == null) {
            f14918d = l.b();
        }
        return f14918d;
    }

    public ExecutorService e() {
        if (f14919e == null) {
            f14919e = l.c();
        }
        return f14919e;
    }

    public ExecutorService f() {
        if (f14920f == null) {
            f14920f = l.d();
        }
        return f14920f;
    }
}
