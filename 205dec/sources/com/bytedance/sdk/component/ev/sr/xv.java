package com.bytedance.sdk.component.ev.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private c f29726c;

    /* renamed from: w  reason: collision with root package name */
    private w f29727w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(String str, String str2);

        void w(String str, String str2);

        void xv(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.component.ev.sr.xv$xv  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class C0446xv {

        /* renamed from: c  reason: collision with root package name */
        private static final xv f29730c = new xv();
    }

    public static void c(c cVar) {
        synchronized (xv.class) {
            C0446xv.f29730c.f29726c = cVar;
        }
    }

    public static void w(String str, String str2) {
        if (C0446xv.f29730c.f29726c.compareTo(c.INFO) <= 0) {
            C0446xv.f29730c.f29727w.xv(str, str2);
        }
    }

    public static void xv(String str, String str2) {
        if (C0446xv.f29730c.f29726c.compareTo(c.DEBUG) <= 0) {
            C0446xv.f29730c.f29727w.w(str, str2);
        }
    }

    private xv() {
        this.f29726c = c.OFF;
        this.f29727w = new com.bytedance.sdk.component.ev.sr.w();
    }

    public static void c(String str, String str2) {
        if (C0446xv.f29730c.f29726c.compareTo(c.ERROR) <= 0) {
            C0446xv.f29730c.f29727w.c(str, str2);
        }
    }
}
