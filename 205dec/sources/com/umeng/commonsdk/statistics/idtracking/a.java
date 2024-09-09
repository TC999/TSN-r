package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AbstractIdTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f53610a = 10;

    /* renamed from: b  reason: collision with root package name */
    private final int f53611b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final String f53612c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f53613d;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f53614e;

    public a(String str) {
        this.f53612c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f53614e;
        String b4 = bVar == null ? null : bVar.b();
        int h4 = bVar == null ? 0 : bVar.h();
        String a4 = a(f());
        if (a4 == null || a4.equals(b4)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a4);
        bVar.a(System.currentTimeMillis());
        bVar.a(h4 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f53612c);
        aVar.c(a4);
        aVar.b(b4);
        aVar.a(bVar.e());
        if (this.f53613d == null) {
            this.f53613d = new ArrayList(2);
        }
        this.f53613d.add(aVar);
        if (this.f53613d.size() > 10) {
            this.f53613d.remove(0);
        }
        this.f53614e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f53612c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f53614e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f53614e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f53613d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f53614e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f53613d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f53614e = cVar.c().get(this.f53612c);
        List<com.umeng.commonsdk.statistics.proto.a> h4 = cVar.h();
        if (h4 == null || h4.size() <= 0) {
            return;
        }
        if (this.f53613d == null) {
            this.f53613d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h4) {
            if (this.f53612c.equals(aVar.f53676a)) {
                this.f53613d.add(aVar);
            }
        }
    }
}
