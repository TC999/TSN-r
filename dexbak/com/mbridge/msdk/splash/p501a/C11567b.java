package com.mbridge.msdk.splash.p501a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameDiTool;

/* compiled from: ReportData.java */
/* renamed from: com.mbridge.msdk.splash.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11567b {

    /* renamed from: a */
    private String f31714a;

    /* renamed from: b */
    private String f31715b;

    /* renamed from: c */
    private String f31716c;

    /* renamed from: d */
    private String f31717d;

    /* renamed from: e */
    private String f31718e;

    /* renamed from: f */
    private String f31719f;

    /* renamed from: g */
    private String f31720g;

    /* renamed from: h */
    private int f31721h;

    /* renamed from: i */
    private boolean f31722i;

    /* renamed from: j */
    private int f31723j;

    private C11567b() {
    }

    /* renamed from: a */
    public final C11567b m21290a(boolean z) {
        this.f31722i = z;
        return this;
    }

    /* renamed from: b */
    public final C11567b m21287b(String str) {
        this.f31715b = str;
        return this;
    }

    /* renamed from: c */
    public final C11567b m21286c(String str) {
        this.f31716c = str;
        return this;
    }

    /* renamed from: d */
    public final C11567b m21285d(String str) {
        this.f31717d = str;
        return this;
    }

    /* renamed from: e */
    public final C11567b m21284e(String str) {
        this.f31719f = str;
        return this;
    }

    /* renamed from: f */
    public final C11567b m21283f(String str) {
        this.f31720g = str;
        return this;
    }

    /* renamed from: g */
    public final C11567b m21282g(String str) {
        this.f31718e = str;
        return this;
    }

    /* renamed from: a */
    public static C11567b m21293a() {
        return new C11567b();
    }

    /* renamed from: b */
    public final C11567b m21288b(int i) {
        this.f31721h = i;
        return this;
    }

    /* renamed from: a */
    public final C11567b m21291a(String str) {
        this.f31714a = str;
        return this;
    }

    /* renamed from: b */
    public final String m21289b() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f31715b)) {
            sb.append("unit_id=");
            sb.append(this.f31715b);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f31716c)) {
            sb.append("cid=");
            sb.append(this.f31716c);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f31717d)) {
            sb.append("rid=");
            sb.append(this.f31717d);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f31718e)) {
            sb.append("rid_n=");
            sb.append(this.f31718e);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f31719f)) {
            sb.append("creative_id=");
            sb.append(this.f31719f);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.f31720g)) {
            sb.append("reason=");
            sb.append(this.f31720g);
            sb.append("&");
        }
        if (this.f31721h != 0) {
            sb.append("result=");
            sb.append(this.f31721h);
            sb.append("&");
        }
        if (this.f31722i) {
            sb.append("hb=1");
            sb.append("&");
        }
        if (this.f31723j != 0) {
            sb.append("close_type=");
            sb.append(this.f31723j);
            sb.append("&");
        }
        sb.append("network_type=");
        sb.append(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j()));
        sb.append("&");
        if (!TextUtils.isEmpty(this.f31714a)) {
            sb.append("key=");
            sb.append(this.f31714a);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final void m21292a(int i) {
        this.f31723j = i;
    }
}
