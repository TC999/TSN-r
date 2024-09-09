package cn.jiguang.bv;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    private k f2953b;

    /* renamed from: c  reason: collision with root package name */
    private h f2954c;

    /* renamed from: f  reason: collision with root package name */
    private o f2957f;

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<g> f2952a = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private p f2955d = new p(5, 2000, null, "ssn");

    /* renamed from: e  reason: collision with root package name */
    private f f2956e = new f();

    public j(k kVar) {
        this.f2953b = kVar;
    }

    private void a(LinkedHashSet<g> linkedHashSet) {
        linkedHashSet.removeAll(this.f2952a);
        if (linkedHashSet.isEmpty()) {
            return;
        }
        LinkedHashSet<g> a4 = e.a(this.f2953b.f2959a, linkedHashSet, 0L);
        cn.jiguang.bq.d.c("SisConn", "connect: last good sis info" + a4);
        Iterator<g> it = a4.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.LinkedHashSet<cn.jiguang.bv.g> r13, long r14) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.j.a(java.util.LinkedHashSet, long):void");
    }

    private boolean a() {
        return (a(this.f2953b.f2959a, cn.jiguang.f.h.c(this.f2953b.f2959a)) || cn.jiguang.f.i.a(((Long) cn.jiguang.g.b.a(this.f2953b.f2959a, cn.jiguang.g.a.an())).longValue(), 180000L)) ? false : true;
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.af());
        cn.jiguang.bq.d.c("SisConn", "newType=" + str + " last=" + str2);
        return !str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r11.f2952a.add(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(cn.jiguang.bv.g r12) {
        /*
            r11 = this;
            cn.jiguang.bv.h r0 = r11.f2954c
            boolean r0 = r0.f2946a
            r1 = 0
            r2 = -991(0xfffffffffffffc21, float:NaN)
            r3 = 1
            if (r0 == 0) goto L15
            cn.jiguang.bx.f r12 = new cn.jiguang.bx.f
            r12.<init>(r2, r1)
        Lf:
            cn.jiguang.bv.p r0 = r11.f2955d
            r0.a(r12)
            return r3
        L15:
            cn.jiguang.bv.p r0 = r11.f2955d
            boolean r0 = r0.a()
            if (r0 == 0) goto L1e
            return r3
        L1e:
            r0 = 0
            if (r12 == 0) goto Lb1
            boolean r4 = r12.a()
            if (r4 == 0) goto Lb1
            java.util.LinkedHashSet<cn.jiguang.bv.g> r4 = r11.f2952a
            boolean r4 = r4.contains(r12)
            if (r4 == 0) goto L31
            goto Lb1
        L31:
            cn.jiguang.by.b r5 = cn.jiguang.by.b.a()
            cn.jiguang.bv.k r4 = r11.f2953b
            android.content.Context r6 = r4.f2959a
            java.lang.String r7 = r12.f2943a
            r8 = 3000(0xbb8, double:1.482E-320)
            boolean r10 = r4.a()
            java.net.InetAddress[] r4 = r5.b(r6, r7, r8, r10)
            if (r4 == 0) goto Lb1
            int r5 = r4.length
            if (r5 != 0) goto L4b
            goto Lb1
        L4b:
            java.util.List r4 = java.util.Arrays.asList(r4)
            java.util.LinkedList r4 = cn.jiguang.f.i.a(r4)
            cn.jiguang.bv.k r5 = r11.f2953b
            android.content.Context r5 = r5.f2959a
            java.util.LinkedList r4 = cn.jiguang.f.i.a(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L5f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lac
            java.lang.Object r5 = r4.next()
            java.net.InetAddress r5 = (java.net.InetAddress) r5
            cn.jiguang.bv.h r6 = r11.f2954c
            boolean r6 = r6.f2946a
            if (r6 == 0) goto L77
            cn.jiguang.bx.f r12 = new cn.jiguang.bx.f
            r12.<init>(r2, r1)
            goto Lf
        L77:
            cn.jiguang.bv.p r6 = r11.f2955d
            boolean r6 = r6.a()
            if (r6 == 0) goto L80
            return r3
        L80:
            cn.jiguang.bv.g r6 = new cn.jiguang.bv.g
            int r7 = r12.f2944b
            r6.<init>(r5, r7)
            java.util.LinkedHashSet<cn.jiguang.bv.g> r5 = r11.f2952a
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L5f
            cn.jiguang.bv.f r5 = r11.f2956e
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto L5f
            java.util.LinkedHashSet<cn.jiguang.bv.g> r1 = r11.f2952a
            r1.add(r6)
            cn.jiguang.bv.p r1 = r11.f2955d
            cn.jiguang.bv.b r2 = new cn.jiguang.bv.b
            cn.jiguang.bv.k r3 = r11.f2953b
            cn.jiguang.bv.f r4 = r11.f2956e
            cn.jiguang.bv.h r5 = r11.f2954c
            r2.<init>(r3, r1, r4, r5)
            r1.a(r2)
        Lac:
            java.util.LinkedHashSet<cn.jiguang.bv.g> r1 = r11.f2952a
            r1.add(r12)
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.j.a(cn.jiguang.bv.g):boolean");
    }

    private void b() {
        boolean e4 = cn.jiguang.cn.a.e(this.f2953b.f2959a);
        g a4 = g.a((String) cn.jiguang.g.b.a(this.f2953b.f2959a, cn.jiguang.g.a.c(!e4)));
        StringBuilder sb = new StringBuilder();
        sb.append("connect: use last good");
        sb.append(e4 ? "v6" : "v4");
        sb.append(" address=");
        sb.append(a4);
        cn.jiguang.bq.d.c("SisConn", sb.toString());
        if (a(a4)) {
            return;
        }
        g a5 = g.a((String) cn.jiguang.g.b.a(this.f2953b.f2959a, cn.jiguang.g.a.c(e4)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect: use last good");
        sb2.append(e4 ? "v4" : "v6");
        sb2.append(" address=");
        sb2.append(a5);
        cn.jiguang.bq.d.c("SisConn", sb2.toString());
        if (a(a5)) {
            return;
        }
        LinkedHashSet<g> c4 = c();
        if (c4 != null) {
            c4.removeAll(this.f2952a);
        }
        LinkedList a6 = cn.jiguang.f.i.a(c4);
        cn.jiguang.bq.d.c("SisConn", "connect: use defaultConn=" + a6);
        Iterator it = a6.iterator();
        while (it.hasNext()) {
            if (a((g) it.next())) {
                return;
            }
        }
        LinkedHashSet<g> a7 = cn.jiguang.bw.l.a().a(cn.jiguang.bu.a.b(this.f2953b.f2959a), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        a6.clear();
        if (a7 != null) {
            a7.removeAll(this.f2952a);
            a6 = cn.jiguang.f.i.a(a7);
        }
        cn.jiguang.bq.d.c("SisConn", "connect: use srv address" + a6);
        Iterator it2 = a6.iterator();
        while (it2.hasNext() && !a((g) it2.next())) {
        }
    }

    private LinkedHashSet<g> c() {
        String a4;
        LinkedList a5;
        try {
            a4 = cn.jiguang.bu.a.a(this.f2953b.f2959a);
            cn.jiguang.bq.d.c("SisConn", "load Default Conn, from host=" + a4);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(a4)) {
            return null;
        }
        cn.jiguang.by.b a6 = cn.jiguang.by.b.a();
        k kVar = this.f2953b;
        InetAddress[] b4 = a6.b(kVar.f2959a, a4, 3000L, kVar.a());
        if (b4 != null && b4.length != 0 && (a5 = cn.jiguang.f.i.a((Collection) Arrays.asList(b4))) != null && !a5.isEmpty()) {
            String hostAddress = ((InetAddress) a5.get(0)).getHostAddress();
            LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add(new g(hostAddress, 7000));
            linkedHashSet.add(new g(hostAddress, 7002));
            linkedHashSet.add(new g(hostAddress, 7003));
            linkedHashSet.add(new g(hostAddress, 7004));
            linkedHashSet.add(new g(hostAddress, 7005));
            linkedHashSet.add(new g(hostAddress, 7006));
            linkedHashSet.add(new g(hostAddress, 7007));
            linkedHashSet.add(new g(hostAddress, 7008));
            linkedHashSet.add(new g(hostAddress, 7009));
            return linkedHashSet;
        }
        return null;
    }

    public cn.jiguang.ca.a a(h hVar) {
        this.f2954c = hVar;
        cn.jiguang.bq.d.e("SisConn", "start sisAndConnect...");
        this.f2956e = new f();
        long uptimeMillis = SystemClock.uptimeMillis() + 12000;
        boolean d4 = c.d(this.f2953b.f2959a);
        LinkedHashSet<g> c4 = g.c((String) cn.jiguang.g.b.a(this.f2953b.f2959a, d4 ? cn.jiguang.g.a.al() : cn.jiguang.g.a.ak()));
        boolean z3 = (c4 == null || c4.isEmpty()) ? false : true;
        boolean a4 = a();
        if (z3 && a4) {
            a(c4);
        }
        l a5 = this.f2953b.a(12000L);
        LinkedHashSet<g> linkedHashSet = a5 != null ? d4 ? a5.f2967b : a5.f2966a : null;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            this.f2953b.a(a5.f2972g);
            a(linkedHashSet, uptimeMillis);
        } else if (z3 && !a4) {
            a(c4);
        }
        b();
        cn.jiguang.bq.d.c("SisConn", "wait final result...");
        Object a6 = this.f2955d.a(60000L);
        this.f2955d.a(false);
        if (a6 instanceof cn.jiguang.ca.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("connect succeed connResult hostName=");
            cn.jiguang.ca.a aVar = (cn.jiguang.ca.a) a6;
            sb.append(aVar.f3213h);
            sb.append(" port=");
            sb.append(aVar.f3214i);
            cn.jiguang.bq.d.e("SisConn", sb.toString());
            return aVar;
        } else if (a6 instanceof Exception) {
            cn.jiguang.bq.d.e("SisConn", "all sis and connect failed, e:" + a6);
            throw ((Exception) a6);
        } else {
            cn.jiguang.bq.d.k("SisConn", "all sis and connect failed:" + a6);
            throw new cn.jiguang.bx.f(1, null);
        }
    }
}
