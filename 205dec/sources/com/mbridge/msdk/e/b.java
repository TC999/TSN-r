package com.mbridge.msdk.e;

import com.mbridge.msdk.e.a;

/* compiled from: TimerController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* compiled from: TimerController.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        static b f39018a = new b();
    }

    public static b getInstance() {
        return a.f39018a;
    }

    public void addInterstitialList(String str, String str2) {
        a.C0733a.f39017a.b(str, str2);
    }

    public void addRewardList(String str, String str2) {
        a.C0733a.f39017a.a(str, str2);
    }

    public void start() {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        int q3 = b4.q();
        if (q3 > 0) {
            a.C0733a.f39017a.a(q3 * 1000);
        }
    }

    private b() {
    }
}
