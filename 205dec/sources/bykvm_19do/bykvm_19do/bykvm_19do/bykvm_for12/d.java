package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdEventModel.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected String f569a;

    /* renamed from: b  reason: collision with root package name */
    protected String f570b;

    /* renamed from: c  reason: collision with root package name */
    protected String f571c;

    /* renamed from: d  reason: collision with root package name */
    protected String f572d;

    /* renamed from: e  reason: collision with root package name */
    protected String f573e;

    /* renamed from: f  reason: collision with root package name */
    protected String f574f;

    /* renamed from: g  reason: collision with root package name */
    protected String f575g;

    /* renamed from: h  reason: collision with root package name */
    protected String f576h;

    /* renamed from: i  reason: collision with root package name */
    protected long f577i;

    /* renamed from: j  reason: collision with root package name */
    protected String f578j;

    /* renamed from: k  reason: collision with root package name */
    protected String f579k;

    /* renamed from: l  reason: collision with root package name */
    protected String f580l;

    /* renamed from: m  reason: collision with root package name */
    protected String f581m;

    /* renamed from: n  reason: collision with root package name */
    protected int f582n;

    /* renamed from: o  reason: collision with root package name */
    protected String f583o;

    /* renamed from: p  reason: collision with root package name */
    protected String f584p;

    /* renamed from: q  reason: collision with root package name */
    protected int f585q;

    /* renamed from: r  reason: collision with root package name */
    protected long f586r;

    /* renamed from: u  reason: collision with root package name */
    protected String f589u;

    /* renamed from: s  reason: collision with root package name */
    protected int f587s = -1;

    /* renamed from: t  reason: collision with root package name */
    protected int f588t = -1;

    /* renamed from: v  reason: collision with root package name */
    protected Map<String, Object> f590v = new HashMap();

    protected d() {
    }

    public static d a() {
        return new d();
    }

    public d a(int i4) {
        this.f581m = String.valueOf(i4);
        return this;
    }

    public d a(long j4) {
        this.f586r = j4;
        return this;
    }

    public d a(String str) {
        this.f572d = str;
        return this;
    }

    public d a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f590v.put(str, obj);
        }
        return this;
    }

    public d a(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.f590v.putAll(map);
        }
        return this;
    }

    public d b(int i4) {
        this.f585q = i4;
        return this;
    }

    public d b(long j4) {
        this.f577i = j4;
        return this;
    }

    public d b(String str) {
        this.f571c = str;
        return this;
    }

    public d c(int i4) {
        this.f582n = i4;
        return this;
    }

    public d c(String str) {
        this.f574f = str;
        return this;
    }

    public d d(int i4) {
        this.f583o = String.valueOf(i4);
        return this;
    }

    public d d(String str) {
        this.f579k = str;
        return this;
    }

    public d e(int i4) {
        this.f587s = i4;
        return this;
    }

    public d e(String str) {
        this.f569a = str;
        return this;
    }

    public d f(int i4) {
        this.f584p = String.valueOf(i4);
        return this;
    }

    public d f(String str) {
        this.f589u = str;
        return this;
    }

    public d g(int i4) {
        this.f588t = i4;
        return this;
    }

    public d g(String str) {
        this.f570b = str;
        return this;
    }

    public d h(String str) {
        this.f573e = str;
        return this;
    }

    public d i(String str) {
        this.f576h = str;
        return this;
    }

    public d j(String str) {
        this.f575g = str;
        return this;
    }

    public d k(String str) {
        this.f578j = str;
        return this;
    }
}
