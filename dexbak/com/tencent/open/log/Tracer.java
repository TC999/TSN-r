package com.tencent.open.log;

import com.tencent.open.log.C13039d;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class Tracer {

    /* renamed from: a */
    private volatile int f37354a;

    /* renamed from: b */
    private volatile boolean f37355b;

    /* renamed from: c */
    private C13046g f37356c;

    public Tracer() {
        this(C13038c.f37378a, true, C13046g.f37399a);
    }

    /* renamed from: a */
    public void m15118a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (m15115d() && C13039d.C13040a.m15083a(this.f37354a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }

    /* renamed from: d */
    public boolean m15115d() {
        return this.f37355b;
    }

    protected abstract void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th);

    /* renamed from: e */
    public C13046g m15114e() {
        return this.f37356c;
    }

    public Tracer(int i, boolean z, C13046g c13046g) {
        this.f37354a = C13038c.f37378a;
        this.f37355b = true;
        this.f37356c = C13046g.f37399a;
        m15119a(i);
        m15116a(z);
        m15117a(c13046g);
    }

    /* renamed from: a */
    public void m15119a(int i) {
        this.f37354a = i;
    }

    /* renamed from: a */
    public void m15116a(boolean z) {
        this.f37355b = z;
    }

    /* renamed from: a */
    public void m15117a(C13046g c13046g) {
        this.f37356c = c13046g;
    }
}
