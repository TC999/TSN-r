package com.bytedance.msdk.api.sr.c.w.xv;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private final String f27614a;

    /* renamed from: c  reason: collision with root package name */
    private final String f27615c;
    private final String ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f27616f;
    private final String gd;

    /* renamed from: k  reason: collision with root package name */
    private final String f27617k;

    /* renamed from: p  reason: collision with root package name */
    private final String f27618p;

    /* renamed from: r  reason: collision with root package name */
    private final String f27619r;
    private final String sr;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    private final String f27620w;
    private final String xv;

    public w() {
        this.xv = "";
        this.f27615c = "";
        this.f27620w = "";
        this.sr = "";
        this.ux = "";
        this.f27616f = "";
        this.f27619r = "";
        this.ev = "";
        this.gd = "";
        this.f27618p = "";
        this.f27617k = "";
        this.f27614a = "";
    }

    public ValueSet c() {
        b a4 = b.a();
        a4.i(8003, this.xv);
        a4.i(8534, this.f27615c);
        a4.i(8535, this.f27620w);
        a4.i(8536, this.sr);
        a4.i(8537, this.ux);
        a4.i(8538, this.f27616f);
        a4.i(8539, this.f27619r);
        a4.i(8540, this.ev);
        a4.i(8541, this.gd);
        a4.i(8542, this.f27618p);
        a4.i(8543, this.f27617k);
        a4.i(8544, this.f27614a);
        return a4.l();
    }

    public boolean sr() {
        return TextUtils.equals(this.f27614a, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.f27615c + "', mAppKey='" + this.f27620w + "', mADNName='" + this.xv + "', mAdnInitClassName='" + this.sr + "', mBannerClassName='" + this.ux + "', mInterstitialClassName='" + this.f27616f + "', mRewardClassName='" + this.f27619r + "', mFullVideoClassName='" + this.ev + "', mSplashClassName='" + this.gd + "', mDrawClassName='" + this.f27617k + "', mFeedClassName='" + this.f27618p + "'}";
    }

    @Nullable
    public String w() {
        return this.xv;
    }

    @Nullable
    public String xv() {
        return this.sr;
    }

    public w(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.xv = str;
        this.f27615c = str2;
        this.f27620w = str3;
        this.sr = str4;
        this.ux = str5;
        this.f27616f = str6;
        this.f27619r = str7;
        this.ev = str8;
        this.gd = str9;
        this.f27618p = str10;
        this.f27617k = str11;
        this.f27614a = str12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public c c(int i4, int i5) {
        switch (i4) {
            case 1:
                return new c(this.ux, com.bytedance.msdk.api.sr.c.w.c.w.class);
            case 2:
                return new c(this.f27616f, com.bytedance.msdk.api.sr.c.w.r.w.class);
            case 3:
                return new c(this.gd, com.bytedance.msdk.api.sr.c.w.p.w.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return new c(this.f27618p, com.bytedance.msdk.api.sr.c.w.ev.xv.class);
            case 7:
                if (i5 == 6) {
                    return new c(this.f27619r, com.bytedance.msdk.api.sr.c.w.gd.w.class);
                }
                if (i5 == 7) {
                    return new c(this.ev, com.bytedance.msdk.api.sr.c.w.ux.w.class);
                }
                return new c(this.f27619r, com.bytedance.msdk.api.sr.c.w.gd.w.class);
            case 8:
                return new c(this.ev, com.bytedance.msdk.api.sr.c.w.ux.w.class);
            case 9:
                break;
            case 10:
                if (i5 == 1) {
                    return new c(this.f27616f, com.bytedance.msdk.api.sr.c.w.r.w.class);
                }
                if (i5 == 2) {
                    return new c(this.ev, com.bytedance.msdk.api.sr.c.w.ux.w.class);
                }
                break;
        }
        return new c(this.f27617k, com.bytedance.msdk.api.sr.c.w.sr.w.class);
    }
}
