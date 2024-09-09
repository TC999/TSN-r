package com.bytedance.msdk.xv;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: a  reason: collision with root package name */
    public String f28496a;
    public String bk;

    /* renamed from: c  reason: collision with root package name */
    public String f28497c;
    public String ev;

    /* renamed from: f  reason: collision with root package name */
    public String f28498f;
    public String fp;
    public long gd;

    /* renamed from: i  reason: collision with root package name */
    public String f28499i;
    public int ia;

    /* renamed from: k  reason: collision with root package name */
    public String f28501k;

    /* renamed from: p  reason: collision with root package name */
    public String f28502p;

    /* renamed from: r  reason: collision with root package name */
    public String f28504r;

    /* renamed from: s  reason: collision with root package name */
    public long f28505s;
    public String sr;

    /* renamed from: t  reason: collision with root package name */
    public int f28506t;
    public String ux;

    /* renamed from: w  reason: collision with root package name */
    public String f28508w;
    public String xv;
    public String ys;
    public int fz = -1;

    /* renamed from: u  reason: collision with root package name */
    public int f28507u = -1;

    /* renamed from: q  reason: collision with root package name */
    public Map<String, Object> f28503q = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    private long f28500j = -1;

    protected sr() {
    }

    public sr c(int i4) {
        this.bk = String.valueOf(i4);
        return this;
    }

    public sr ev(String str) {
        this.f28498f = str;
        return this;
    }

    public sr f(String str) {
        this.sr = str;
        return this;
    }

    public sr gd(String str) {
        this.f28504r = str;
        return this;
    }

    public sr k(String str) {
        this.f28499i = str;
        return this;
    }

    public sr p(String str) {
        this.f28501k = str;
        return this;
    }

    public sr r(String str) {
        this.ux = str;
        return this;
    }

    public sr setResult(int i4) {
        this.fz = i4;
        return this;
    }

    public sr sr(String str) {
        this.f28508w = str;
        return this;
    }

    public sr ux(String str) {
        this.xv = str;
        return this;
    }

    public sr w(String str) {
        this.ev = str;
        return this;
    }

    public sr xv(String str) {
        this.f28502p = str;
        return this;
    }

    public sr c(long j4) {
        this.f28505s = j4;
        return this;
    }

    public sr f(int i4) {
        this.f28507u = i4;
        return this;
    }

    public sr sr(int i4) {
        this.fp = String.valueOf(i4);
        return this;
    }

    public sr ux(int i4) {
        this.ia = i4;
        return this;
    }

    public sr w(long j4) {
        this.gd = j4;
        return this;
    }

    public sr xv(int i4) {
        this.ys = String.valueOf(i4);
        return this;
    }

    public sr c(String str) {
        this.f28497c = str;
        return this;
    }

    public sr w(int i4) {
        this.f28506t = i4;
        return this;
    }

    public sr xv(long j4) {
        this.f28500j = j4;
        return this;
    }

    public static sr w() {
        return new sr();
    }

    public static sr xv() {
        sr srVar = new sr();
        srVar.xv(System.currentTimeMillis());
        return srVar;
    }

    public sr c(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f28503q.put(str, obj);
        }
        return this;
    }

    public sr c(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.f28503q.putAll(map);
        }
        return this;
    }

    public long c() {
        return this.f28500j;
    }
}
