package com.kuaishou.weapon.p205p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.cx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7243cx {

    /* renamed from: b */
    private static volatile C7243cx f24747b;

    /* renamed from: a */
    private Context f24748a;

    private C7243cx(Context context) {
        this.f24748a = context;
    }

    /* renamed from: a */
    public static C7243cx m34020a(Context context) {
        if (f24747b == null) {
            synchronized (C7243cx.class) {
                if (f24747b == null) {
                    f24747b = new C7243cx(context);
                }
            }
        }
        return f24747b;
    }

    /* renamed from: a */
    public void m34021a(final int i) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    C7283h m33888a = C7283h.m33888a(C7243cx.this.f24748a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24913y, 0) == 1) {
                        long m33985a = C7262df.m33986a(C7243cx.this.f24748a).m33985a(C7262df.f24876bh);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m33878b = m33888a.m33878b(C7262df.f24914z, 8) * C7193bi.f24584s;
                        int m33878b2 = m33888a.m33878b(C7262df.f24905q, 0);
                        if (m33985a > 0 && currentTimeMillis - m33985a < WeaponHI.f24464ii * C7193bi.f24584s && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - m33985a >= m33878b || (i2 = i) == 106 || (i2 == 100 && m33878b2 == 1)) {
                            C7232cp.m34048a(C7243cx.this.f24748a, new C7224ch(C7243cx.this.f24748a, i).m34089a(C7227ck.f24677i), C7227ck.f24677i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
