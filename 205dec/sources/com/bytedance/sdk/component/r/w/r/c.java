package com.bytedance.sdk.component.r.w.r;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile HandlerThread f30092c = new HandlerThread("csj_ad_log", 10);

    /* renamed from: w  reason: collision with root package name */
    private static volatile Handler f30093w = null;
    private static int xv = 3000;

    static {
        f30092c.start();
    }

    public static Handler c() {
        if (f30092c != null && f30092c.isAlive()) {
            if (f30093w == null) {
                synchronized (c.class) {
                    if (f30093w == null) {
                        f30093w = new Handler(f30092c.getLooper());
                    }
                }
            }
        } else {
            synchronized (c.class) {
                if (f30092c == null || !f30092c.isAlive()) {
                    f30092c = new HandlerThread("csj_init_handle", -1);
                    f30092c.start();
                    f30093w = new Handler(f30092c.getLooper());
                }
            }
        }
        return f30093w;
    }

    public static int w() {
        if (xv <= 0) {
            xv = 3000;
        }
        return xv;
    }
}
