package com.qq.e.comm.plugin.n0;

import com.qq.e.comm.plugin.util.c1;
import com.qq.e.comm.plugin.util.v0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<e> f44818a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    private static final Queue<h> f44819b = new ConcurrentLinkedQueue();

    public static void a(e eVar) {
        a(eVar, false);
    }

    public static void b(int i4, c cVar, Integer num) {
        b(i4, cVar, num, null);
    }

    public static void a(e eVar, boolean z3) {
        if (!c1.b()) {
            f44818a.add(eVar);
        } else if (eVar != null) {
            if (z3 || i.a(eVar.c())) {
                eVar.a(v0.b());
                g.a(eVar);
                boolean a4 = i.a(z3, eVar.c());
                t.c().a(m.a(eVar), a4);
                com.qq.e.comm.plugin.edgeanalytics.b.c().a(eVar, false);
            }
        }
    }

    public static void b(int i4, c cVar, Integer num, d dVar) {
        a(i4, cVar, null, num, dVar);
    }

    public static void a(int i4, c cVar) {
        a(i4, cVar, null, null, null);
    }

    public static void a(int i4, c cVar, Integer num, Integer num2, d dVar) {
        a(i4, cVar, num, num2, dVar, false);
    }

    public static void a(int i4, c cVar, Integer num, Integer num2, d dVar, boolean z3) {
        e eVar = new e(i4);
        if (num != null) {
            eVar.c(num.intValue());
        }
        eVar.a(cVar);
        eVar.a(dVar);
        if (num2 != null) {
            eVar.d(num2.intValue());
        }
        a(eVar, z3);
    }

    public static void a(int i4, c cVar, Integer num) {
        a(i4, cVar, num, null);
    }

    public static void a(int i4, c cVar, Integer num, d dVar) {
        a(i4, cVar, num, null, dVar);
    }

    public static void a(h hVar) {
        if (!c1.b()) {
            f44819b.add(hVar);
        } else if (hVar == null || hVar.c() == 0 || !i.l()) {
        } else {
            hVar.a(v0.b());
            g.a(hVar);
            t.c().a(q.a(hVar));
        }
    }

    public static void a() {
        while (true) {
            e poll = f44818a.poll();
            if (poll == null) {
                break;
            }
            a(poll, false);
        }
        while (true) {
            h poll2 = f44819b.poll();
            if (poll2 == null) {
                return;
            }
            a(poll2);
        }
    }
}
