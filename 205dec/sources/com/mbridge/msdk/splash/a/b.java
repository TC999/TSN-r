package com.mbridge.msdk.splash.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.t;

/* compiled from: ReportData.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f40486a;

    /* renamed from: b  reason: collision with root package name */
    private String f40487b;

    /* renamed from: c  reason: collision with root package name */
    private String f40488c;

    /* renamed from: d  reason: collision with root package name */
    private String f40489d;

    /* renamed from: e  reason: collision with root package name */
    private String f40490e;

    /* renamed from: f  reason: collision with root package name */
    private String f40491f;

    /* renamed from: g  reason: collision with root package name */
    private String f40492g;

    /* renamed from: h  reason: collision with root package name */
    private int f40493h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40494i;

    /* renamed from: j  reason: collision with root package name */
    private int f40495j;

    private b() {
    }

    public final b a(boolean z3) {
        this.f40494i = z3;
        return this;
    }

    public final b b(String str) {
        this.f40487b = str;
        return this;
    }

    public final b c(String str) {
        this.f40488c = str;
        return this;
    }

    public final b d(String str) {
        this.f40489d = str;
        return this;
    }

    public final b e(String str) {
        this.f40491f = str;
        return this;
    }

    public final b f(String str) {
        this.f40492g = str;
        return this;
    }

    public final b g(String str) {
        this.f40490e = str;
        return this;
    }

    public static b a() {
        return new b();
    }

    public final b b(int i4) {
        this.f40493h = i4;
        return this;
    }

    public final b a(String str) {
        this.f40486a = str;
        return this;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f40487b)) {
            sb.append("unit_id=");
            sb.append(this.f40487b);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f40488c)) {
            sb.append("cid=");
            sb.append(this.f40488c);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f40489d)) {
            sb.append("rid=");
            sb.append(this.f40489d);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f40490e)) {
            sb.append("rid_n=");
            sb.append(this.f40490e);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f40491f)) {
            sb.append("creative_id=");
            sb.append(this.f40491f);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f40492g)) {
            sb.append("reason=");
            sb.append(this.f40492g);
            sb.append("&");
        }
        if (this.f40493h != 0) {
            sb.append("result=");
            sb.append(this.f40493h);
            sb.append("&");
        }
        if (this.f40494i) {
            sb.append("hb=1");
            sb.append("&");
        }
        if (this.f40495j != 0) {
            sb.append("close_type=");
            sb.append(this.f40495j);
            sb.append("&");
        }
        sb.append("network_type=");
        sb.append(t.D(com.mbridge.msdk.foundation.controller.a.f().j()));
        sb.append("&");
        if (!TextUtils.isEmpty(this.f40486a)) {
            sb.append("key=");
            sb.append(this.f40486a);
        }
        return sb.toString();
    }

    public final void a(int i4) {
        this.f40495j = i4;
    }
}
