package com.qq.e.comm.plugin.util;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class r1 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Boolean f46598c;

    private boolean a() {
        if (f46598c == null) {
            f46598c = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("ctraet", 0) == 1);
        }
        return f46598c.booleanValue();
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        boolean a4;
        try {
            b();
        } finally {
            if (a4) {
            }
        }
    }
}
