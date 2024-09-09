package cn.jiguang.bv;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o implements Callable<l> {

    /* renamed from: a  reason: collision with root package name */
    private final k f2997a;

    /* renamed from: b  reason: collision with root package name */
    private final p f2998b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2999c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f3000d;

    /* renamed from: e  reason: collision with root package name */
    private g f3001e;

    public o(k kVar, g gVar, Set<String> set) {
        this.f2997a = kVar;
        this.f2998b = null;
        this.f2999c = null;
        this.f3001e = gVar;
        this.f3000d = set;
    }

    public o(k kVar, p pVar, f fVar) {
        this.f2997a = kVar;
        this.f2998b = pVar;
        this.f2999c = fVar;
    }

    private static void a(Context context, l lVar) {
        if (lVar == null || lVar.a()) {
            return;
        }
        String a4 = g.a(lVar.f2966a);
        String a5 = g.a(lVar.f2967b);
        String c4 = cn.jiguang.f.h.c(context);
        cn.jiguang.bq.d.c("SisTask", "updateSisInfo ips=" + a4 + " sslIps=" + a5 + " net=" + c4);
        a(context, a4, a5);
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[6];
        aVarArr[0] = cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) g.a(lVar.f2968c));
        aVarArr[1] = cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) g.a(lVar.f2969d));
        aVarArr[2] = cn.jiguang.g.a.ap().a((cn.jiguang.g.a<String>) g.a(lVar.f2970e));
        cn.jiguang.g.a<String> as = cn.jiguang.g.a.as();
        JSONObject jSONObject = lVar.f2971f;
        aVarArr[3] = as.a((cn.jiguang.g.a<String>) (jSONObject != null ? jSONObject.toString() : null));
        aVarArr[4] = cn.jiguang.g.a.am().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(lVar.f2973h));
        aVarArr[5] = cn.jiguang.g.a.an().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()));
        cn.jiguang.g.b.a(context, aVarArr);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.af().a((cn.jiguang.g.a<String>) c4));
        cn.jiguang.bk.h.a(context, lVar.f2974i);
    }

    private static void a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.al());
        String str4 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ak());
        if (TextUtils.isEmpty(str4)) {
            cn.jiguang.g.a<String> ak = cn.jiguang.g.a.ak();
            cn.jiguang.g.b.a(context, ak.a((cn.jiguang.g.a<String>) (str + "-sis-" + currentTimeMillis)));
        } else {
            String[] split = str4.split("-sis-");
            if (split == null || split.length <= 0) {
                cn.jiguang.g.a<String> ak2 = cn.jiguang.g.a.ak();
                cn.jiguang.g.b.a(context, ak2.a((cn.jiguang.g.a<String>) (str + "-sis-" + currentTimeMillis)));
            } else if (!TextUtils.equals(split[0], str)) {
                cn.jiguang.g.a<String> ak3 = cn.jiguang.g.a.ak();
                cn.jiguang.g.b.a(context, ak3.a((cn.jiguang.g.a<String>) (str + "-sis-" + currentTimeMillis)));
            } else if (split.length > 1 && g.b(split[1])) {
                cn.jiguang.g.a<String> ak4 = cn.jiguang.g.a.ak();
                cn.jiguang.g.b.a(context, ak4.a((cn.jiguang.g.a<String>) (str + "-sis-" + currentTimeMillis)));
            }
        }
        if (TextUtils.isEmpty(str3)) {
            cn.jiguang.g.a<String> al = cn.jiguang.g.a.al();
            cn.jiguang.g.b.a(context, al.a((cn.jiguang.g.a<String>) (str2 + "-sis-" + currentTimeMillis)));
            return;
        }
        String[] split2 = str3.split("-sis-");
        if (split2 == null || split2.length <= 0) {
            cn.jiguang.g.a<String> al2 = cn.jiguang.g.a.al();
            cn.jiguang.g.b.a(context, al2.a((cn.jiguang.g.a<String>) (str2 + "-sis-" + currentTimeMillis)));
        } else if (!TextUtils.equals(split2[0], str2)) {
            cn.jiguang.g.a<String> al3 = cn.jiguang.g.a.al();
            cn.jiguang.g.b.a(context, al3.a((cn.jiguang.g.a<String>) (str2 + "-sis-" + currentTimeMillis)));
        } else if (split2.length <= 1 || !g.b(split2[1])) {
        } else {
            cn.jiguang.g.a<String> al4 = cn.jiguang.g.a.al();
            cn.jiguang.g.b.a(context, al4.a((cn.jiguang.g.a<String>) (str2 + "-sis-" + currentTimeMillis)));
        }
    }

    private Object[] a(DatagramSocket datagramSocket, InetAddress inetAddress, int i4) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] a4 = this.f2997a.a(this.f3000d);
            String b4 = cn.jiguang.cf.c.a().b(inetAddress.getHostAddress(), i4);
            cn.jiguang.cf.b a5 = cn.jiguang.cf.b.a();
            a5.b(inetAddress.getHostAddress() + ":" + i4, "sis", a4.length);
            DatagramPacket datagramPacket = new DatagramPacket(a4, a4.length, inetAddress, i4);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] a6 = c.a(datagramSocket, datagramPacket);
                cn.jiguang.cf.b a7 = cn.jiguang.cf.b.a();
                a7.c(inetAddress.getHostAddress() + ":" + i4, "sis", a6.length);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                try {
                    l lVar = new l(new String(c.a(a6)));
                    if (lVar.a()) {
                        objArr[0] = 6;
                        cn.jiguang.cf.c.a().c(b4, 6);
                        return objArr;
                    }
                    cn.jiguang.cf.c.a().c(b4, 0);
                    a(this.f2997a.f2959a, lVar);
                    lVar.f2972g = new g(inetAddress, i4);
                    objArr[0] = lVar;
                    return objArr;
                } catch (cn.jiguang.bx.f e4) {
                    objArr[0] = Integer.valueOf(e4.a());
                    cn.jiguang.cf.c.a().c(b4, e4.a());
                    return objArr;
                }
            } catch (Exception unused) {
                cn.jiguang.cf.c.a().c(b4, 3);
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                return objArr;
            }
        } catch (cn.jiguang.bx.f e5) {
            objArr[0] = Integer.valueOf(e5.a());
            return objArr;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public l call() {
        try {
            if (this.f2999c != null) {
                return a(this.f2999c.a(this.f2997a.b()));
            }
            return a(this.f3001e);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("SisTask", "run e:" + th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f5, code lost:
        if (r5 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.bv.l a(cn.jiguang.bv.g r20) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.o.a(cn.jiguang.bv.g):cn.jiguang.bv.l");
    }
}
