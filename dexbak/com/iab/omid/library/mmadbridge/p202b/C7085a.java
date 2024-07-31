package com.iab.omid.library.mmadbridge.p202b;

import com.iab.omid.library.mmadbridge.adsession.C7081h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.mmadbridge.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7085a {

    /* renamed from: c */
    private static C7085a f24226c = new C7085a();

    /* renamed from: a */
    private final ArrayList<C7081h> f24227a = new ArrayList<>();

    /* renamed from: b */
    private final ArrayList<C7081h> f24228b = new ArrayList<>();

    private C7085a() {
    }

    /* renamed from: a */
    public static C7085a m34757a() {
        return f24226c;
    }

    /* renamed from: b */
    public void m34756b(C7081h c7081h) {
        this.f24227a.add(c7081h);
    }

    /* renamed from: c */
    public Collection<C7081h> m34755c() {
        return Collections.unmodifiableCollection(this.f24227a);
    }

    /* renamed from: d */
    public void m34754d(C7081h c7081h) {
        boolean m34751g = m34751g();
        this.f24228b.add(c7081h);
        if (m34751g) {
            return;
        }
        C7092f.m34717b().m34715d();
    }

    /* renamed from: e */
    public Collection<C7081h> m34753e() {
        return Collections.unmodifiableCollection(this.f24228b);
    }

    /* renamed from: f */
    public void m34752f(C7081h c7081h) {
        boolean m34751g = m34751g();
        this.f24227a.remove(c7081h);
        this.f24228b.remove(c7081h);
        if (!m34751g || m34751g()) {
            return;
        }
        C7092f.m34717b().m34714e();
    }

    /* renamed from: g */
    public boolean m34751g() {
        return this.f24228b.size() > 0;
    }
}
