package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dc {

    /* renamed from: b  reason: collision with root package name */
    private static volatile dc f38273b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38274a;

    private dc(Context context) {
        this.f38274a = context;
    }

    public static dc a(Context context) {
        if (f38273b == null) {
            synchronized (dc.class) {
                if (f38273b == null) {
                    f38273b = new dc(context);
                }
            }
        }
        return f38273b;
    }

    public void a(final int i4) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a4 = h.a(dc.this.f38274a, "re_po_rt");
                    if (a4.b("plc001_c_s", 1) == 1) {
                        long a5 = df.a(dc.this.f38274a).a("fp_a1_1_upl_time");
                        long currentTimeMillis = System.currentTimeMillis();
                        int b4 = a4.b("plc001_c_b", 0);
                        long j4 = currentTimeMillis - a5;
                        if (j4 >= a4.b("plc001_c_i", 6) * 3600000 || (i4 == 100 && b4 == 1 && j4 >= 14400000)) {
                            cg.a(dc.this.f38274a, new bw(dc.this.f38274a, i4, false).a(ck.f38169e), ck.f38169e, true);
                            df.a(dc.this.f38274a).a("fp_a1_1_upl_time", currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
