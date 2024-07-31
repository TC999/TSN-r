package com.beizi.fusion.p072g;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BeiZiExecutor.java */
/* renamed from: com.beizi.fusion.g.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3145h {

    /* renamed from: a */
    private static final AtomicBoolean f11360a = new AtomicBoolean();

    /* renamed from: b */
    private static volatile C3145h f11361b;

    /* renamed from: c */
    private static volatile ThreadPoolExecutor f11362c;

    /* renamed from: d */
    private static volatile ThreadPoolExecutor f11363d;

    /* renamed from: e */
    private static volatile ThreadPoolExecutor f11364e;

    /* renamed from: f */
    private static volatile ThreadPoolExecutor f11365f;

    private C3145h() {
        if (f11360a.get()) {
            return;
        }
        m48265a();
    }

    /* renamed from: a */
    public static void m48265a() {
        AtomicBoolean atomicBoolean = f11360a;
        if (atomicBoolean.get()) {
            return;
        }
        f11362c = C3156l.m48242a();
        f11363d = C3156l.m48241b();
        f11364e = C3156l.m48240c();
        f11365f = C3156l.m48239d();
        atomicBoolean.set(true);
    }

    /* renamed from: b */
    public static C3145h m48264b() {
        if (f11361b == null) {
            synchronized (C3145h.class) {
                if (f11361b == null) {
                    f11361b = new C3145h();
                }
            }
        }
        return f11361b;
    }

    /* renamed from: c */
    public ExecutorService m48263c() {
        if (f11362c == null) {
            f11362c = C3156l.m48242a();
        }
        return f11362c;
    }

    /* renamed from: d */
    public ExecutorService m48262d() {
        if (f11363d == null) {
            f11363d = C3156l.m48241b();
        }
        return f11363d;
    }

    /* renamed from: e */
    public ExecutorService m48261e() {
        if (f11364e == null) {
            f11364e = C3156l.m48240c();
        }
        return f11364e;
    }

    /* renamed from: f */
    public ExecutorService m48260f() {
        if (f11365f == null) {
            f11365f = C3156l.m48239d();
        }
        return f11365f;
    }
}
