package com.bytedance.msdk.api;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: a  reason: collision with root package name */
    private String f27654a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private int f27655c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f27656f;
    private final Map<String, String> fp = new HashMap();
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f27657k;

    /* renamed from: p  reason: collision with root package name */
    private String f27658p;

    /* renamed from: r  reason: collision with root package name */
    private int f27659r;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private String f27660t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f27661w;
    private String xv;
    private String ys;

    @Nullable
    public String a() {
        return this.f27656f;
    }

    @Nullable
    public String bk() {
        return this.ux;
    }

    public void c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.fp.clear();
        this.fp.putAll(map);
    }

    @Nullable
    public String ev() {
        return this.f27661w;
    }

    @Nullable
    public String f() {
        return this.f27660t;
    }

    @Nullable
    public String fp() {
        return this.gd;
    }

    @Nullable
    public String gd() {
        return this.xv;
    }

    @Nullable
    public String k() {
        return TextUtils.isEmpty(this.xv) ? this.f27661w : this.xv;
    }

    @Nullable
    public String p() {
        return this.sr;
    }

    @Nullable
    public String r() {
        return this.ys;
    }

    @Nullable
    public String sr() {
        return this.f27654a;
    }

    public int t() {
        return this.f27659r;
    }

    public String toString() {
        return "{mSdkNum='" + this.f27655c + "', mSlotId='" + this.sr + "', mLevelTag='" + this.ux + "', mEcpm=" + this.f27656f + ", mReqBiddingType=" + this.f27659r + "', mRequestId=" + this.gd + '}';
    }

    @Nullable
    public String ux() {
        return this.bk;
    }

    @Nullable
    public String w() {
        return this.f27658p;
    }

    @Nullable
    public String xv() {
        return this.f27657k;
    }

    @Nullable
    public String ys() {
        return this.ev;
    }

    public void a(String str) {
        this.ev = str;
    }

    public void bk(String str) {
        this.gd = str;
    }

    public void ev(String str) {
        this.xv = str;
    }

    public void f(String str) {
        this.ys = str;
    }

    public void gd(String str) {
        this.sr = str;
    }

    public void k(String str) {
        this.ux = str;
    }

    public void p(String str) {
        this.f27656f = str;
    }

    public void r(String str) {
        this.f27661w = str;
    }

    public void sr(String str) {
        this.bk = str;
    }

    public void ux(String str) {
        this.f27660t = str;
    }

    public void w(String str) {
        this.f27657k = str;
    }

    public void xv(String str) {
        this.f27654a = str;
    }

    public void w(int i4) {
        this.f27659r = i4;
    }

    public Map<String, String> c() {
        return this.fp;
    }

    public void c(String str) {
        this.f27658p = str;
    }

    public void c(int i4) {
        this.f27655c = i4;
    }
}
