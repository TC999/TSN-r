package com.qq.e.comm.plugin.util.w2;

import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static final String f46701e = "c";

    /* renamed from: a  reason: collision with root package name */
    private final e f46702a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f46703b;

    /* renamed from: c  reason: collision with root package name */
    private b f46704c;

    /* renamed from: d  reason: collision with root package name */
    private a f46705d;

    public c(e eVar) {
        this.f46702a = eVar;
    }

    public void a(b bVar) {
        a(bVar, false);
    }

    public void a(b bVar, boolean z3) {
        this.f46704c = bVar;
        if (z3) {
            this.f46705d = new a(this.f46702a, this);
        }
    }

    public void a(long j4) {
        d1.a(f46701e, "onTimerTick : %s", Long.valueOf(j4));
        this.f46704c.b(j4);
        long c4 = this.f46704c.c();
        if (this.f46703b || j4 < c4) {
            return;
        }
        d1.a(f46701e, "send reward\uff0ccurrentTime: %s, reward time: %s", Long.valueOf(j4), Long.valueOf(c4));
        this.f46703b = true;
        this.f46704c.a(j4);
    }

    public void a() {
        d1.a(f46701e, "destroy");
        a aVar = this.f46705d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
