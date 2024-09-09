package com.bytedance.sdk.component.ev;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.ev.sr.xv;
import com.bytedance.sdk.component.ev.w.sr;
import com.bytedance.sdk.component.ev.xv.f;
import com.bytedance.sdk.component.ev.xv.r;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.gd;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private a f29718c;

    /* renamed from: w  reason: collision with root package name */
    private f f29719w;
    private int xv;

    /* renamed from: com.bytedance.sdk.component.ev.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0445c {

        /* renamed from: f  reason: collision with root package name */
        private Set<String> f29721f;

        /* renamed from: r  reason: collision with root package name */
        private Bundle f29722r;
        boolean sr = true;
        final List<gd> ux = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        int f29720c = 10000;

        /* renamed from: w  reason: collision with root package name */
        int f29723w = 10000;
        int xv = 10000;

        public C0445c xv(long j4, TimeUnit timeUnit) {
            this.xv = c("timeout", j4, timeUnit);
            return this;
        }

        public C0445c c(long j4, TimeUnit timeUnit) {
            this.f29720c = c("timeout", j4, timeUnit);
            return this;
        }

        public C0445c w(long j4, TimeUnit timeUnit) {
            this.f29723w = c("timeout", j4, timeUnit);
            return this;
        }

        public C0445c c(boolean z3) {
            this.sr = z3;
            return this;
        }

        public C0445c c(gd gdVar) {
            this.ux.add(gdVar);
            return this;
        }

        public C0445c c(Bundle bundle) {
            this.f29722r = bundle;
            return this;
        }

        public C0445c c(Set<String> set) {
            this.f29721f = set;
            return this;
        }

        private static int c(String str, long j4, TimeUnit timeUnit) {
            if (j4 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j4);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || j4 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public c c() {
            return new c(this);
        }
    }

    public void c(Context context, boolean z3, com.bytedance.sdk.component.ev.xv.w wVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (wVar != null) {
            int c4 = wVar.c();
            this.xv = c4;
            f fVar = this.f29719w;
            if (fVar != null) {
                fVar.c(c4);
            }
            r.c().c(this.xv).c(z3);
            r.c().c(this.xv).c(wVar);
            r.c().c(this.xv).c(context, s.c(context));
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
    }

    public com.bytedance.sdk.component.ev.w.c sr() {
        return new com.bytedance.sdk.component.ev.w.c(this.f29718c);
    }

    public a ux() {
        return this.f29718c;
    }

    public sr w() {
        return new sr(this.f29718c);
    }

    public com.bytedance.sdk.component.ev.w.w xv() {
        return new com.bytedance.sdk.component.ev.w.w(this.f29718c);
    }

    private c(C0445c c0445c) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a.c w3 = new a.c().c(c0445c.f29720c, timeUnit).xv(c0445c.xv, timeUnit).w(c0445c.f29723w, timeUnit);
        if (c0445c.sr) {
            f fVar = new f();
            this.f29719w = fVar;
            w3.c(fVar);
        }
        List<gd> list = c0445c.ux;
        if (list != null && list.size() > 0) {
            for (gd gdVar : c0445c.ux) {
                w3.c(gdVar);
            }
        }
        if (c0445c.f29722r != null) {
            w3.c(c0445c.f29722r);
        }
        w3.c(c0445c.f29721f);
        this.f29718c = w3.c();
    }

    public void c(Context context, boolean z3) {
        com.bytedance.sdk.component.ev.xv.c.w(true);
        if (c(context) || (!s.c(context) && z3)) {
            r.c().c(this.xv, context).sr();
            r.c().c(this.xv, context).c();
        }
        if (s.c(context)) {
            r.c().c(this.xv, context).sr();
            r.c().c(this.xv, context).c();
        }
    }

    public static void c() {
        xv.c(xv.c.DEBUG);
    }

    private static boolean c(Context context) {
        String w3 = s.w(context);
        return w3 != null && (w3.endsWith(":push") || w3.endsWith(":pushservice"));
    }

    public boolean c(String str, boolean z3) {
        try {
            return this.f29718c.c(str, z3);
        } catch (Throwable unused) {
            return true;
        }
    }
}
