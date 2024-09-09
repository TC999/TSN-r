package cn.jiguang.af;

import android.content.Context;
import android.os.Message;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f2131a;

    /* renamed from: b  reason: collision with root package name */
    private cn.jiguang.ad.a f2132b;

    /* renamed from: c  reason: collision with root package name */
    private cn.jiguang.ae.a f2133c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.ae.b f2134d;

    /* renamed from: e  reason: collision with root package name */
    private long f2135e = System.currentTimeMillis();

    private synchronized cn.jiguang.ae.a a(Context context) {
        cn.jiguang.ae.b bVar = this.f2134d;
        if (bVar == null || bVar.getState() == Thread.State.TERMINATED) {
            this.f2134d = new cn.jiguang.ae.b("jg_wk_thread");
        }
        if (this.f2134d.getState() == Thread.State.NEW) {
            this.f2134d.start();
            this.f2133c = null;
        }
        if (this.f2133c == null) {
            this.f2133c = new cn.jiguang.ae.a(context, this.f2134d.getLooper());
        }
        return this.f2133c;
    }

    public static f a() {
        if (f2131a == null) {
            synchronized (f.class) {
                if (f2131a == null) {
                    f2131a = new f();
                }
            }
        }
        return f2131a;
    }

    private void a(Context context, cn.jiguang.ad.c cVar) {
        long max = Math.max(0L, (cVar.f2104k * 1000) - Math.max(0L, System.currentTimeMillis() - this.f2135e));
        Message obtain = Message.obtain();
        obtain.what = 1000;
        obtain.obj = cVar;
        a(context).sendMessageDelayed(obtain, max);
        cn.jiguang.w.a.b("JWakeTaskHelper", "add delay w task, delayTime: " + max + ", tPkg: " + cVar.f2094a);
    }

    private void b(Context context, cn.jiguang.ad.c cVar) {
        cn.jiguang.w.a.b("JWakeTaskHelper", "the delay w task time up, start to process it, tPkg: " + cVar.f2094a);
        List<cn.jiguang.ad.b> a4 = cn.jiguang.ac.a.a(context, (List<cn.jiguang.ad.c>) new ArrayList<cn.jiguang.ad.c>(cVar) { // from class: cn.jiguang.af.f.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ cn.jiguang.ad.c f2136a;

            {
                this.f2136a = cVar;
                add(cVar);
            }
        });
        if (a4 == null || a4.isEmpty()) {
            return;
        }
        c.a(context, this.f2132b, a4);
    }

    public void a(Context context, int i4, Object obj) {
        if (i4 == 1000 && (obj instanceof cn.jiguang.ad.c)) {
            b(context, (cn.jiguang.ad.c) obj);
        }
    }

    public void a(Context context, cn.jiguang.ad.a aVar, List<cn.jiguang.ad.c> list) {
        this.f2132b = aVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (cn.jiguang.ad.c cVar : list) {
                if (a(cVar.f2104k * 1000)) {
                    arrayList.add(cVar);
                    a(context, cVar);
                }
            }
            if (!arrayList.isEmpty()) {
                list.removeAll(arrayList);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("start w task, wakeTarget size: ");
        sb.append(list != null ? list.size() : 0);
        sb.append(", dWakeTarget size: ");
        sb.append(arrayList.size());
        cn.jiguang.w.a.b("JWakeTaskHelper", sb.toString());
        c.a(context, this.f2132b, cn.jiguang.ac.a.a(context, list));
    }

    public void a(Context context, boolean z3) {
        if (z3) {
            this.f2135e = System.currentTimeMillis();
        }
    }

    public boolean a(int i4) {
        return cn.jiguang.ah.d.e() && i4 > 0 && System.currentTimeMillis() - this.f2135e < ((long) i4);
    }
}
