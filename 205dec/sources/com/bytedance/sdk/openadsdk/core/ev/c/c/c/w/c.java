package com.bytedance.sdk.openadsdk.core.ev.c.c.c.w;

import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.ia;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends p {

    /* renamed from: c  reason: collision with root package name */
    protected ia f33414c;

    /* renamed from: f  reason: collision with root package name */
    String f33415f;

    /* renamed from: r  reason: collision with root package name */
    private final String f33416r;
    long sr;
    String ux;

    /* renamed from: w  reason: collision with root package name */
    String f33417w;
    long xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, long j4, long j5, String str2, String str3, String str4) {
        super("DownloadCallbackRunnable");
        this.f33417w = str;
        this.xv = j4;
        this.sr = j5;
        this.ux = str2;
        this.f33415f = str3;
        this.f33416r = str4;
    }

    public void c(String str) {
        this.f33417w = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            w().c(this.f33416r, this.f33417w, this.xv, this.sr, this.ux, this.f33415f);
        } catch (Throwable unused) {
        }
    }

    public void w(long j4) {
        this.sr = j4;
    }

    public void xv(String str) {
        this.f33415f = str;
    }

    public void c(long j4) {
        this.xv = j4;
    }

    public void w(String str) {
        this.ux = str;
    }

    protected ia w() {
        if (this.f33414c == null) {
            this.f33414c = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(ls.getContext()).c(3));
        }
        return this.f33414c;
    }
}
