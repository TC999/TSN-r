package com.kuaishou.weapon.p205p0;

import android.content.Context;

/* renamed from: com.kuaishou.weapon.p0.dc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7256dc {

    /* renamed from: b */
    private static volatile C7256dc f24777b;

    /* renamed from: a */
    private Context f24778a;

    private C7256dc(Context context) {
        this.f24778a = context;
    }

    /* renamed from: a */
    public static C7256dc m33996a(Context context) {
        if (f24777b == null) {
            synchronized (C7256dc.class) {
                if (f24777b == null) {
                    f24777b = new C7256dc(context);
                }
            }
        }
        return f24777b;
    }

    /* renamed from: a */
    public void m33997a(final int i) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7283h m33888a = C7283h.m33888a(C7256dc.this.f24778a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24857ap, 1) == 1) {
                        long m33985a = C7262df.m33986a(C7256dc.this.f24778a).m33985a(C7262df.f24880bl);
                        long currentTimeMillis = System.currentTimeMillis();
                        int m33878b = m33888a.m33878b(C7262df.f24860as, 0);
                        long j = currentTimeMillis - m33985a;
                        if (j >= m33888a.m33878b(C7262df.f24859ar, 6) * C7193bi.f24584s || (i == 100 && m33878b == 1 && j >= 14400000)) {
                            C7222cg.m34091a(C7256dc.this.f24778a, new C7208bw(C7256dc.this.f24778a, i, false).m34122a(C7227ck.f24673e), C7227ck.f24673e, true);
                            C7262df.m33986a(C7256dc.this.f24778a).m33984a(C7262df.f24880bl, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
