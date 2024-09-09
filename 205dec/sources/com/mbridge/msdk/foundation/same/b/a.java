package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Directory.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private c f39419a;

    /* renamed from: b  reason: collision with root package name */
    private String f39420b;

    /* renamed from: c  reason: collision with root package name */
    private a f39421c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f39422d;

    public final c a() {
        return this.f39419a;
    }

    public final String b() {
        return this.f39420b;
    }

    public final a c() {
        return this.f39421c;
    }

    public final List<a> d() {
        return this.f39422d;
    }

    public final void a(c cVar) {
        this.f39419a = cVar;
    }

    public final void a(String str) {
        this.f39420b = str;
    }

    private void a(a aVar) {
        if (this.f39422d == null) {
            this.f39422d = new ArrayList();
        }
        aVar.f39421c = this;
        this.f39422d.add(aVar);
    }

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.f39419a = cVar;
        aVar.f39420b = str;
        a(aVar);
    }

    public final void a(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (a aVar : list) {
            a(aVar);
        }
    }
}
