package com.bytedance.sdk.openadsdk.core.z;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public String f35735c;
    public int ck;

    /* renamed from: n  reason: collision with root package name */
    public int f35740n;

    /* renamed from: s  reason: collision with root package name */
    public List<String> f35744s;

    /* renamed from: w  reason: collision with root package name */
    public int f35747w = 1;
    public int xv = 1;
    public int sr = 2;
    public int ux = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f35736f = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f35743r = 1;
    public int ev = 3;
    public int gd = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f35741p = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f35739k = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f35734a = 1;
    public int bk = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f35745t = 1500;
    public int ys = 0;
    public int fp = 2000;
    public boolean ia = false;
    public int fz = 2;

    /* renamed from: u  reason: collision with root package name */
    public int f35746u = 100;

    /* renamed from: i  reason: collision with root package name */
    public int f35737i = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f35742q = 0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35738j = false;
    public boolean ls = false;
    public long gb = 0;

    private c() {
    }

    public static c c() {
        return new c();
    }

    public c a(int i4) {
        this.xv = i4;
        return this;
    }

    public c bk(int i4) {
        this.sr = i4;
        return this;
    }

    public c ev(int i4) {
        this.gd = i4;
        return this;
    }

    public c f(int i4) {
        this.ys = i4;
        return this;
    }

    public c fp(int i4) {
        this.f35743r = i4;
        return this;
    }

    public c fz(int i4) {
        this.f35746u = i4;
        return this;
    }

    public c gd(int i4) {
        this.f35741p = i4;
        return this;
    }

    public c i(int i4) {
        this.f35742q = i4;
        return this;
    }

    public c ia(int i4) {
        this.f35734a = i4;
        return this;
    }

    public c k(int i4) {
        this.f35747w = i4;
        return this;
    }

    public c p(int i4) {
        this.ev = i4;
        return this;
    }

    public c r(int i4) {
        this.f35739k = i4;
        return this;
    }

    public c s(int i4) {
        this.fz = i4;
        return this;
    }

    public c sr(int i4) {
        this.bk = i4;
        return this;
    }

    public c t(int i4) {
        this.ux = i4;
        return this;
    }

    public c u(int i4) {
        this.f35737i = i4;
        return this;
    }

    public c ux(int i4) {
        this.f35745t = i4;
        return this;
    }

    public int w() {
        return this.ck;
    }

    public int xv() {
        return this.f35740n;
    }

    public c ys(int i4) {
        this.f35736f = i4;
        return this;
    }

    public c c(int i4) {
        this.ck = i4;
        return this;
    }

    public c w(int i4) {
        this.f35740n = i4;
        return this;
    }

    public c xv(int i4) {
        this.fp = i4;
        return this;
    }

    public c c(boolean z3) {
        this.f35738j = z3;
        return this;
    }

    public c w(boolean z3) {
        this.ls = z3;
        return this;
    }

    public c xv(boolean z3) {
        this.ia = z3;
        return this;
    }

    public c c(long j4) {
        this.gb = j4;
        return this;
    }

    public c c(String str) {
        this.f35735c = str;
        return this;
    }

    public c c(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.f35744s = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    this.f35744s.add(jSONArray.get(i4).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
