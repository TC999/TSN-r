package com.bytedance.msdk.ux.w;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.sr.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w {

    /* renamed from: c  reason: collision with root package name */
    private final String f28460c = c.class.getSimpleName();
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private long f28461w;
    private long xv;

    @Override // com.bytedance.msdk.ux.w.w
    public void a() {
        this.xv = System.currentTimeMillis();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long bk() {
        long j4 = this.xv - this.f28461w;
        String str = this.f28460c;
        xv.w(str, "InitMethodDuration = " + j4);
        return j4;
    }

    @Override // com.bytedance.msdk.ux.w.w
    public boolean fp() {
        return TextUtils.isEmpty(this.sr);
    }

    @Override // com.bytedance.msdk.ux.w.w
    public boolean ia() {
        String str = this.sr;
        String str2 = com.bytedance.msdk.xv.c.xv;
        boolean equals = TextUtils.equals(str, str2);
        String str3 = this.f28460c;
        xv.w(str3, "canUploadInitDuration = " + equals + " \u5f53sessionId = " + str2 + " \u5b58\u50a8\u7684sessionId = " + this.sr);
        return !equals;
    }

    @Override // com.bytedance.msdk.ux.w.w
    public void k() {
        this.f28461w = System.currentTimeMillis();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long t() {
        long currentTimeMillis = System.currentTimeMillis() - this.f28461w;
        String str = this.f28460c;
        xv.w(str, "SplashRequestDuration = " + currentTimeMillis);
        return currentTimeMillis;
    }

    @Override // com.bytedance.msdk.ux.w.w
    public void xv(String str) {
        this.sr = str;
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long ys() {
        long currentTimeMillis = System.currentTimeMillis() - this.f28461w;
        String str = this.f28460c;
        xv.w(str, "SplashFillDuration = " + currentTimeMillis);
        return currentTimeMillis;
    }
}
