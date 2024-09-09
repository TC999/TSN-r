package com.bytedance.msdk.ux.xv;

import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28462c;
    private int xv = -1;

    /* renamed from: w  reason: collision with root package name */
    private wv f28463w = f.ux();

    private c() {
    }

    public static c c() {
        if (f28462c == null) {
            synchronized (c.class) {
                if (f28462c == null) {
                    f28462c = new c();
                }
            }
        }
        return f28462c;
    }

    public synchronized int f() {
        return this.f28463w.w("discard_num", 0);
    }

    public synchronized void r() {
        this.f28463w.c("discard_num", 0);
    }

    public long sr() {
        try {
            long w3 = this.f28463w.w("first_install_time", -1L);
            if (w3 == -1) {
                w3 = f.c().w("first_install_time", -1L);
                if (w3 == -1) {
                    w3 = System.currentTimeMillis();
                }
                this.f28463w.c("first_install_time", w3);
            }
            return w3;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public synchronized void ux() {
        this.f28463w.c("discard_num", this.f28463w.w("discard_num", 0) + 1);
    }

    public int w() {
        return 1;
    }

    public boolean xv() {
        return w() == 1 || w() == 2;
    }

    public void c(long j4) {
        try {
            if (this.f28463w.w("first_install_time", -1L) == -1) {
                long w3 = f.c().w("first_install_time", -1L);
                if (w3 != -1) {
                    j4 = w3;
                }
                this.f28463w.c("first_install_time", j4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
