package cn.jiguang.bv;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static k f2958c;

    /* renamed from: a  reason: collision with root package name */
    Context f2959a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<m> f2960b;

    /* renamed from: d  reason: collision with root package name */
    private int f2961d = 0;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f2962e;

    /* renamed from: f  reason: collision with root package name */
    private int f2963f;

    public k(Context context) {
        this.f2959a = context;
        this.f2960b = m.a((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ag()));
    }

    public static k a(Context context) {
        if (f2958c == null) {
            synchronized (k.class) {
                if (f2958c == null) {
                    f2958c = new k(context);
                }
            }
        }
        return f2958c;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.jiguang.bv.n a(int r19) {
        /*
            r18 = this;
            r0 = r18
            android.content.Context r1 = r0.f2959a
            java.lang.String r4 = cn.jiguang.d.a.e(r1)
            android.content.Context r1 = r0.f2959a
            long r6 = cn.jiguang.d.a.f(r1)
            android.content.Context r1 = r0.f2959a
            java.lang.String r8 = cn.jiguang.f.h.b(r1)
            long r1 = java.lang.System.currentTimeMillis()
            android.content.Context r3 = r0.f2959a
            java.lang.String r5 = "get_loc_info"
            r9 = 0
            java.lang.Object r3 = cn.jiguang.bx.e.a(r3, r5, r9)
            boolean r5 = r3 instanceof android.os.Bundle
            r9 = 4641240890982006784(0x4069000000000000, double:200.0)
            if (r5 == 0) goto L4c
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "lat"
            double r11 = r3.getDouble(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "lot"
            double r9 = r3.getDouble(r5)     // Catch: java.lang.Throwable -> L43
            java.lang.String r5 = "time"
            long r1 = r3.getLong(r5)     // Catch: java.lang.Throwable -> L43
            r13 = r1
            r16 = r9
            r9 = r11
            r11 = r16
            goto L4e
        L43:
            r16 = r9
            r9 = r11
            r11 = r16
            goto L4a
        L49:
            r11 = r9
        L4a:
            r13 = r1
            goto L4e
        L4c:
            r13 = r1
            r11 = r9
        L4e:
            r1 = 0
            android.content.Context r2 = r0.f2959a
            boolean r2 = cn.jiguang.bv.c.d(r2)
            if (r2 == 0) goto L5b
            int r1 = cn.jiguang.bk.h.b()
        L5b:
            cn.jiguang.bv.n r15 = new cn.jiguang.bv.n
            java.lang.String r5 = cn.jiguang.a.a.f2010b
            r2 = r15
            r3 = r19
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13)
            cn.jiguang.bv.n r1 = r15.a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.k.a(int):cn.jiguang.bv.n");
    }

    private synchronized void a(m mVar) {
        this.f2960b.add(mVar);
        cn.jiguang.bq.d.c("SisConnContext", "addSisReportInfo:" + mVar.a().toString());
        while (this.f2960b.size() > 30) {
            this.f2960b.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<m> it = this.f2960b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        cn.jiguang.g.b.a(this.f2959a, cn.jiguang.g.a.ag().a((cn.jiguang.g.a<String>) jSONArray.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(InetAddress inetAddress, int i4, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            return cn.jiguang.f.i.c(c.a(c.a(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i4)))) == 0;
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("SisConnContext", "report failed : " + th);
            return false;
        }
    }

    public l a(long j4) {
        FutureTask futureTask = new FutureTask(new i(this));
        this.f2961d = 0;
        cn.jiguang.bt.b.c(futureTask, new int[0]);
        if (j4 < 10) {
            j4 = 10;
        }
        try {
            return (l) futureTask.get(j4, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public void a(int i4, String str, int i5, long j4, long j5, int i6) {
        if (g.a(str, i5)) {
            m mVar = new m();
            mVar.f2975a = cn.jiguang.d.a.e(this.f2959a);
            mVar.f2976b = i4;
            mVar.f2977c = new g(str, i5);
            mVar.f2979e = j4;
            mVar.f2980f = j5;
            mVar.f2985k = i6;
            mVar.f2981g = cn.jiguang.f.h.a(this.f2959a);
            mVar.f2978d = cn.jiguang.d.a.f(this.f2959a);
            mVar.f2982h = 200.0d;
            mVar.f2983i = 200.0d;
            mVar.f2984j = System.currentTimeMillis();
            Object a4 = cn.jiguang.bx.e.a(this.f2959a, "get_loc_info", null);
            if (a4 instanceof Bundle) {
                try {
                    Bundle bundle = (Bundle) a4;
                    mVar.f2982h = bundle.getDouble("lat");
                    mVar.f2983i = bundle.getDouble("lot");
                    mVar.f2984j = bundle.getLong("time");
                } catch (Throwable unused) {
                }
            }
            a(mVar);
        }
    }

    public void a(final g gVar) {
        if (((Boolean) cn.jiguang.g.b.a(this.f2959a, cn.jiguang.g.a.am())).booleanValue()) {
            if (cn.jiguang.f.i.a(((Long) cn.jiguang.g.b.a(this.f2959a, cn.jiguang.g.a.ao())).longValue(), 3600000L)) {
                cn.jiguang.bt.b.a(new cn.jiguang.cm.b("SisConnContext#asyncSisReportIfNeed") { // from class: cn.jiguang.bv.k.1
                    @Override // cn.jiguang.cm.b
                    public void a() {
                        DatagramSocket datagramSocket;
                        Object th;
                        StringBuilder sb;
                        try {
                            datagramSocket = new DatagramSocket();
                        } catch (Throwable th2) {
                            datagramSocket = null;
                            th = th2;
                        }
                        try {
                            String str = (String) cn.jiguang.g.b.a(k.this.f2959a, cn.jiguang.g.a.ag());
                            if (TextUtils.isEmpty(str)) {
                                cn.jiguang.bq.d.c("SisConnContext", "reportInfo is Empty, quit report");
                                try {
                                    datagramSocket.close();
                                    return;
                                } catch (Throwable th3) {
                                    cn.jiguang.bq.d.i("SisConnContext", "sisReport ,close udpsocket error:" + th3.getMessage());
                                    return;
                                }
                            }
                            byte[] a4 = c.a("DG", str);
                            cn.jiguang.bq.d.c("SisConnContext", "sis report data(" + a4.length + ") at " + gVar.f2945c + ":" + gVar.f2944b);
                            k kVar = k.this;
                            g gVar2 = gVar;
                            if (kVar.a(gVar2.f2945c, gVar2.f2944b, datagramSocket, a4)) {
                                cn.jiguang.bq.d.c("SisConnContext", "report succeed : " + str);
                                cn.jiguang.g.b.a(k.this.f2959a, cn.jiguang.g.a.ao().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime())));
                                cn.jiguang.g.b.a(k.this.f2959a, cn.jiguang.g.a.ag().a((cn.jiguang.g.a<String>) null));
                            } else {
                                cn.jiguang.bq.d.i("SisConnContext", "report failed" + str);
                            }
                            try {
                                datagramSocket.close();
                            } catch (Throwable th4) {
                                th = th4;
                                sb = new StringBuilder();
                                sb.append("sisReport ,close udpsocket error:");
                                sb.append(th.getMessage());
                                cn.jiguang.bq.d.i("SisConnContext", sb.toString());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                cn.jiguang.bq.d.i("SisConnContext", "sisReport failed, error:" + th);
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sb = new StringBuilder();
                                        sb.append("sisReport ,close udpsocket error:");
                                        sb.append(th.getMessage());
                                        cn.jiguang.bq.d.i("SisConnContext", sb.toString());
                                    }
                                }
                            } catch (Throwable th7) {
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th8) {
                                        cn.jiguang.bq.d.i("SisConnContext", "sisReport ,close udpsocket error:" + th8.getMessage());
                                    }
                                }
                                throw th7;
                            }
                        }
                    }
                }, new int[0]);
            } else {
                cn.jiguang.bq.d.c("SisConnContext", "sis report: not yet");
            }
        }
    }

    public void a(boolean z3) {
        this.f2961d = (z3 ? 1 : 2) | this.f2961d;
        cn.jiguang.by.c.a().a(this.f2959a, this.f2961d);
    }

    public boolean a() {
        return false;
    }

    public byte[] a(Set<String> set) {
        int a4 = cn.jiguang.f.h.a(this.f2959a);
        if (this.f2962e == null || a4 != this.f2963f) {
            this.f2963f = a4;
            try {
                this.f2962e = c.a("UG", a(a4).a(set).toString());
            } catch (Exception e4) {
                throw new cn.jiguang.bx.f(2, "Failed to package data - " + e4);
            }
        }
        return this.f2962e;
    }

    public int b() {
        this.f2961d = 3;
        int b4 = cn.jiguang.cn.a.e(this.f2959a) ? 3 : cn.jiguang.by.c.a().b(this.f2961d);
        cn.jiguang.bq.d.c("SisConnContext", "ipvsupport=" + this.f2961d + ", prefer=" + b4);
        return b4;
    }
}
