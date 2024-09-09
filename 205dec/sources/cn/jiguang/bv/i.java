package cn.jiguang.bv;

import android.content.Context;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i implements Callable<l> {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<g> f2950a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private k f2951b;

    public i(k kVar) {
        this.f2951b = kVar;
    }

    private LinkedHashSet<g> a(Context context) {
        LinkedHashSet<g> c4 = g.c((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ap()));
        return (c4 == null || c4.isEmpty()) ? g.a(cn.jiguang.bu.a.b()) : c4;
    }

    private void a(p pVar, f fVar) {
        LinkedHashSet<g> a4 = g.a(cn.jiguang.bu.a.a());
        a4.removeAll(this.f2950a);
        boolean e4 = cn.jiguang.cn.a.e(this.f2951b.f2959a);
        List<g> a5 = cn.jiguang.f.i.a(a4);
        if (e4) {
            a5 = cn.jiguang.f.i.a((List<g>) a5);
        }
        for (g gVar : a5) {
            if (a(gVar, pVar, fVar)) {
                return;
            }
        }
        g a6 = g.a((String) cn.jiguang.g.b.a(this.f2951b.f2959a, cn.jiguang.g.a.b(!e4)));
        StringBuilder sb = new StringBuilder();
        sb.append("main sis: last good sis ");
        sb.append(e4 ? "v6" : "v4");
        sb.append(" address=");
        sb.append(a6);
        cn.jiguang.bq.d.c("Sis", sb.toString());
        if (a(a6, pVar, fVar)) {
            return;
        }
        g a7 = g.a((String) cn.jiguang.g.b.a(this.f2951b.f2959a, cn.jiguang.g.a.b(e4)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("main sis: last good sis ");
        sb2.append(e4 ? "v4" : "v6");
        sb2.append(" address=");
        sb2.append(a7);
        cn.jiguang.bq.d.c("Sis", sb2.toString());
        a(a7, pVar, fVar);
    }

    private boolean a(g gVar, p pVar, f fVar) {
        if (pVar.a()) {
            return true;
        }
        if (gVar != null && gVar.a() && !this.f2950a.contains(gVar)) {
            cn.jiguang.by.b a4 = cn.jiguang.by.b.a();
            k kVar = this.f2951b;
            InetAddress[] b4 = a4.b(kVar.f2959a, gVar.f2943a, 3000L, kVar.a());
            if (b4 != null && b4.length != 0) {
                Iterator<InetAddress> it = cn.jiguang.f.i.a(this.f2951b.f2959a, cn.jiguang.f.i.a((Collection) Arrays.asList(b4))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress next = it.next();
                    if (!pVar.a()) {
                        g gVar2 = new g(next, gVar.f2944b);
                        if (!this.f2950a.contains(gVar2) && fVar.a(gVar2)) {
                            this.f2950a.add(gVar2);
                            pVar.a((Callable<?>) new o(this.f2951b, pVar, fVar));
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                this.f2950a.add(gVar);
            }
        }
        return false;
    }

    private void b(p pVar, f fVar) {
        LinkedHashSet<g> a4 = a(this.f2951b.f2959a);
        a4.removeAll(this.f2950a);
        LinkedList<g> a5 = cn.jiguang.f.i.a(a4);
        cn.jiguang.bq.d.c("Sis", "main sis: default sis" + a5);
        for (g gVar : a5) {
            if (a(gVar, pVar, fVar)) {
                return;
            }
        }
        LinkedHashSet<g> a6 = cn.jiguang.bw.l.a().a(cn.jiguang.bu.a.c(), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        a5.clear();
        if (a6 != null) {
            a6.removeAll(this.f2950a);
            a5 = cn.jiguang.f.i.a(a6);
        }
        cn.jiguang.bq.d.c("Sis", "main sis: sis srv" + a5);
        Iterator it = a5.iterator();
        while (it.hasNext() && !a((g) it.next(), pVar, fVar)) {
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public l call() {
        f fVar = new f();
        p pVar = new p(5, 2000, null, "ss");
        a(pVar, fVar);
        cn.jiguang.bq.d.c("Sis", "main sis: after host and last good, wait Result");
        Object a4 = pVar.a(60000L);
        if (a4 instanceof l) {
            return (l) a4;
        }
        b(pVar, fVar);
        cn.jiguang.bq.d.c("Sis", "main sis: after default and srv, wait Result");
        Object a5 = pVar.a(60000L);
        pVar.a(false);
        if (a5 instanceof l) {
            return (l) a5;
        }
        return null;
    }
}
