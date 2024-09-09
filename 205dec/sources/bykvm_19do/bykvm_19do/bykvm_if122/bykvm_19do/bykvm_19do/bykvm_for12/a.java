package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: NetClient.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private v f689a;

    /* renamed from: b  reason: collision with root package name */
    private g f690b;

    /* renamed from: c  reason: collision with root package name */
    private int f691c;

    /* compiled from: NetClient.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f692a;

        /* renamed from: b  reason: collision with root package name */
        int f693b;

        /* renamed from: c  reason: collision with root package name */
        int f694c;

        /* renamed from: d  reason: collision with root package name */
        boolean f695d = true;

        public b() {
            new ArrayList();
            this.f692a = 10000;
            this.f693b = 10000;
            this.f694c = 10000;
        }

        public b a(long j4, TimeUnit timeUnit) {
            this.f692a = a("timeout", j4, timeUnit);
            return this;
        }

        public b b(long j4, TimeUnit timeUnit) {
            this.f693b = a("timeout", j4, timeUnit);
            return this;
        }

        public b c(long j4, TimeUnit timeUnit) {
            this.f694c = a("timeout", j4, timeUnit);
            return this;
        }

        public b a(boolean z3) {
            this.f695d = z3;
            return this;
        }

        private static int a(String str, long j4, TimeUnit timeUnit) {
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j4);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i4 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public a a() {
            return new a(this);
        }
    }

    public static void c() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.a(b.EnumC0027b.DEBUG);
    }

    public void a(Context context, boolean z3, boolean z4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (bVar != null) {
            int c4 = bVar.c();
            this.f691c = c4;
            g gVar = this.f690b;
            if (gVar != null) {
                gVar.a(c4);
            }
            h.a().a(this.f691c).a(z4);
            h.a().a(this.f691c).a(bVar);
            h.a().a(this.f691c).a(context, f.b(context));
            if (f.c(context) || (!f.b(context) && z3)) {
                h.a().a(this.f691c, context).d();
                h.a().a(this.f691c, context).f();
            }
            if (f.b(context)) {
                h.a().a(this.f691c, context).d();
                h.a().a(this.f691c, context).f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
    }

    public c b() {
        return new c(this.f689a);
    }

    private a(b bVar) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v.b b4 = new v.b().a(bVar.f692a, timeUnit).c(bVar.f694c, timeUnit).b(bVar.f693b, timeUnit);
        if (bVar.f695d) {
            g gVar = new g();
            this.f690b = gVar;
            b4.a(gVar);
        }
        this.f689a = b4.a();
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a a() {
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a(this.f689a);
    }
}
