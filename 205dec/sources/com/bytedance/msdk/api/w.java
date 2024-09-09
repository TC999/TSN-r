package com.bytedance.msdk.api;

import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private String f27649c;

    /* renamed from: f  reason: collision with root package name */
    private String f27650f;
    private String sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f27651w;
    private String xv;

    @Nullable
    public String c() {
        return this.sr;
    }

    @Nullable
    public String f() {
        return this.f27650f;
    }

    @Nullable
    public String sr() {
        return this.xv;
    }

    public String toString() {
        return "{mediationRit='" + this.f27649c + "', adnName='" + this.f27651w + "', customAdnName='" + this.xv + "', adType='" + this.sr + "', errCode=" + this.ux + ", errMsg=" + this.f27650f + '}';
    }

    public int ux() {
        return this.ux;
    }

    @Nullable
    public String w() {
        return this.f27649c;
    }

    @Nullable
    public String xv() {
        return this.f27651w;
    }

    public w c(String str) {
        this.sr = str;
        return this;
    }

    public w sr(String str) {
        this.xv = str;
        return this;
    }

    public w ux(String str) {
        this.f27650f = str;
        return this;
    }

    public w w(String str) {
        this.f27649c = str;
        return this;
    }

    public w xv(String str) {
        this.f27651w = str;
        return this;
    }

    public w c(int i4) {
        this.ux = i4;
        return this;
    }
}
