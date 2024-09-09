package com.iab.omid.library.mmadbridge.b;

import com.iab.omid.library.mmadbridge.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f37708c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<h> f37709a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<h> f37710b = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f37708c;
    }

    public void b(h hVar) {
        this.f37709a.add(hVar);
    }

    public Collection<h> c() {
        return Collections.unmodifiableCollection(this.f37709a);
    }

    public void d(h hVar) {
        boolean g4 = g();
        this.f37710b.add(hVar);
        if (g4) {
            return;
        }
        f.b().d();
    }

    public Collection<h> e() {
        return Collections.unmodifiableCollection(this.f37710b);
    }

    public void f(h hVar) {
        boolean g4 = g();
        this.f37709a.remove(hVar);
        this.f37710b.remove(hVar);
        if (!g4 || g()) {
            return;
        }
        f.b().e();
    }

    public boolean g() {
        return this.f37710b.size() > 0;
    }
}
