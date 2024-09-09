package com.tencent.turingfd.sdk.ams.au;

import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.package  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Cpackage extends Draco implements Cloneable {

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, String> f52331j;

    /* renamed from: k  reason: collision with root package name */
    public static Map<Integer, Integer> f52332k;

    /* renamed from: l  reason: collision with root package name */
    public static Map<String, String> f52333l;

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ boolean f52334m = !Cpackage.class.desiredAssertionStatus();

    /* renamed from: c  reason: collision with root package name */
    public long f52335c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52336d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f52337e = 0;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f52338f = null;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, Integer> f52339g = null;

    /* renamed from: h  reason: collision with root package name */
    public long f52340h = 0;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f52341i = null;

    static {
        HashMap hashMap = new HashMap();
        f52331j = hashMap;
        hashMap.put("", "");
        f52332k = new HashMap();
        f52332k.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f52333l = hashMap2;
        hashMap2.put("", "");
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f52335c, 0);
        dorado.a(this.f52336d ? (byte) 1 : (byte) 0, 1);
        dorado.a(this.f52337e, 2);
        dorado.a((Map) this.f52338f, 3);
        dorado.a((Map) this.f52339g, 4);
        dorado.a(this.f52340h, 5);
        Map<String, String> map = this.f52341i;
        if (map != null) {
            dorado.a((Map) map, 6);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f52334m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Cpackage cpackage = (Cpackage) obj;
        if (Eridanus.a(this.f52335c, cpackage.f52335c)) {
            return (this.f52336d == cpackage.f52336d) && Eridanus.a(this.f52337e, cpackage.f52337e) && this.f52338f.equals(cpackage.f52338f) && this.f52339g.equals(cpackage.f52339g) && Eridanus.a(this.f52340h, cpackage.f52340h) && this.f52341i.equals(cpackage.f52341i);
        }
        return false;
    }

    public int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        this.f52335c = cygnus.a(this.f52335c, 0, true);
        this.f52336d = cygnus.a(this.f52336d, 1, true);
        this.f52337e = cygnus.a(this.f52337e, 2, true);
        this.f52338f = (Map) cygnus.a((Cygnus) f52331j, 3, true);
        this.f52339g = (Map) cygnus.a((Cygnus) f52332k, 4, true);
        this.f52340h = cygnus.a(this.f52340h, 5, true);
        this.f52341i = (Map) cygnus.a((Cygnus) f52333l, 6, false);
    }
}
