package com.bytedance.msdk.core.gd;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr {

    /* renamed from: c  reason: collision with root package name */
    protected String f28011c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28012f;
    protected String sr;
    protected int ux;

    /* renamed from: w  reason: collision with root package name */
    protected String f28013w;
    protected String xv;

    public sr(String str, String str2, String str3, String str4, int i4) {
        this.f28011c = str;
        this.xv = str3;
        this.ux = i4;
        this.f28013w = str2;
        this.f28012f = !TextUtils.isEmpty(str2);
        this.sr = str4;
    }

    public boolean c() {
        return this.f28012f;
    }

    public boolean ev() {
        return this.ux == 1;
    }

    public String f() {
        return this.sr;
    }

    public int r() {
        return this.ux;
    }

    public String sr() {
        if (TextUtils.isEmpty(this.f28013w)) {
            return this.f28011c;
        }
        return this.f28011c + "_" + this.f28013w;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f28011c + "', showRulesVersion='" + this.xv + "', timingMode=" + this.ux + '}';
    }

    public String ux() {
        return this.xv;
    }

    public String w() {
        return this.f28011c;
    }

    public String xv() {
        return this.f28013w;
    }
}
