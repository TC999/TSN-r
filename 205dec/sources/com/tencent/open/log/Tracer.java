package com.tencent.open.log;

import com.tencent.open.log.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class Tracer {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f51754a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f51755b;

    /* renamed from: c  reason: collision with root package name */
    private g f51756c;

    public Tracer() {
        this(c.f51778a, true, g.f51799a);
    }

    public void a(int i4, Thread thread, long j4, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f51754a, i4)) {
            doTrace(i4, thread, j4, str, str2, th);
        }
    }

    public boolean d() {
        return this.f51755b;
    }

    protected abstract void doTrace(int i4, Thread thread, long j4, String str, String str2, Throwable th);

    public g e() {
        return this.f51756c;
    }

    public Tracer(int i4, boolean z3, g gVar) {
        this.f51754a = c.f51778a;
        this.f51755b = true;
        this.f51756c = g.f51799a;
        a(i4);
        a(z3);
        a(gVar);
    }

    public void a(int i4) {
        this.f51754a = i4;
    }

    public void a(boolean z3) {
        this.f51755b = z3;
    }

    public void a(g gVar) {
        this.f51756c = gVar;
    }
}
