package cn.jiguang.bv;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements Callable<cn.jiguang.ca.a> {

    /* renamed from: a  reason: collision with root package name */
    private final k f2926a;

    /* renamed from: b  reason: collision with root package name */
    private final p f2927b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2928c;

    /* renamed from: d  reason: collision with root package name */
    private final h f2929d;

    public b(k kVar, p pVar, f fVar, h hVar) {
        this.f2927b = pVar;
        this.f2926a = kVar;
        this.f2928c = fVar;
        this.f2929d = hVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public cn.jiguang.ca.a call() {
        try {
            if (this.f2928c != null) {
                return a(this.f2928c.a(this.f2926a.b()));
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ConnTask", "run e:" + th);
            return null;
        }
    }

    public cn.jiguang.ca.a a(g gVar) {
        cn.jiguang.ca.a cVar;
        if (this.f2927b.a()) {
            return null;
        }
        h hVar = this.f2929d;
        if (hVar == null || hVar.f2946a) {
            this.f2927b.a(new cn.jiguang.bx.f(-991, null));
            return null;
        } else if (gVar == null) {
            return null;
        } else {
            if (!TextUtils.isEmpty(cn.jiguang.bu.a.f2916n)) {
                String str = cn.jiguang.bu.a.f2916n;
                gVar.f2943a = str;
                gVar.f2945c = InetAddress.getByName(str);
            }
            int i4 = cn.jiguang.bu.a.f2917o;
            if (i4 > 0) {
                gVar.f2944b = i4;
            }
            cn.jiguang.bq.d.d("ConnTask", "Open connection with ip=" + gVar.f2945c + ", port:" + gVar.f2944b);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (c.d(this.f2926a.f2959a)) {
                cn.jiguang.bq.d.d("ConnTask", "start connect ssl socket");
                cVar = new cn.jiguang.ca.b(8128, 20);
            } else {
                cVar = new cn.jiguang.ca.c(8128, 20);
            }
            String a4 = cn.jiguang.cf.c.a().a(gVar.f2943a, gVar.f2944b, cVar.f3212g);
            int a5 = cVar.a(gVar.f2943a, gVar.f2944b);
            if (this.f2927b.a()) {
                cn.jiguang.f.i.a(cVar);
                cn.jiguang.cf.c.a().d(a4, -991);
                return null;
            } else if (this.f2929d.f2946a) {
                this.f2927b.a(new cn.jiguang.bx.f(-991, null));
                cn.jiguang.f.i.a(cVar);
                cn.jiguang.cf.c.a().d(a4, -991);
                return null;
            } else {
                cn.jiguang.cf.c.a().d(a4, a5);
                if (a5 == 0) {
                    cn.jiguang.g.b.a(this.f2926a.f2959a, cn.jiguang.g.a.c((gVar.f2945c instanceof Inet4Address) || cn.jiguang.f.g.f(gVar.f2943a)).a((cn.jiguang.g.a<String>) gVar.toString()));
                    cn.jiguang.bq.d.g("ConnTask", "Succeed to open connection - ip:" + gVar.f2945c + ", port:" + gVar.f2944b);
                    this.f2927b.a(cVar);
                    e.a(this.f2926a.f2959a, gVar, 1, 0L);
                    return cVar;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                this.f2926a.a(2, gVar.f2943a, gVar.f2944b, cn.jiguang.d.b.b(this.f2926a.f2959a), uptimeMillis2, a5);
                cn.jiguang.bq.d.f("ConnTask", "Failed(" + a5 + ") to open connection - ip:" + gVar.f2945c + ", port:" + gVar.f2944b + ", cost:" + uptimeMillis2);
                e.a(this.f2926a.f2959a, gVar, -1, uptimeMillis2);
                cn.jiguang.f.i.a(cVar);
                return null;
            }
        }
    }
}
