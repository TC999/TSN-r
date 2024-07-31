package com.kuaishou.weapon.p205p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.cy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7245cy {

    /* renamed from: b */
    private static volatile C7245cy f24751b;

    /* renamed from: a */
    private Context f24752a;

    private C7245cy(Context context) {
        this.f24752a = context;
    }

    /* renamed from: a */
    public static C7245cy m34017a(Context context) {
        if (f24751b == null) {
            synchronized (C7245cy.class) {
                if (f24751b == null) {
                    f24751b = new C7245cy(context);
                }
            }
        }
        return f24751b;
    }

    /* renamed from: a */
    public void m34018a(final int i) {
        try {
            C7283h m33888a = C7283h.m33888a(this.f24752a, "re_po_rt");
            final boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            final boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            if ((m33867e || m33867e2) && WeaponHI.f24463as) {
                C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            C7283h m33888a2 = C7283h.m33888a(C7245cy.this.f24752a, "re_po_rt");
                            if (m33888a2.m33878b(C7262df.f24903o, 0) == 1) {
                                if (m33867e || m33867e2) {
                                    long m33985a = C7262df.m33986a(C7245cy.this.f24752a).m33985a(C7262df.f24877bi);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long m33878b = m33888a2.m33878b(C7262df.f24904p, 8) * C7193bi.f24584s;
                                    int m33878b2 = m33888a2.m33878b(C7262df.f24905q, 0);
                                    if (m33985a > 0 && currentTimeMillis - m33985a < WeaponHI.f24464ii * C7193bi.f24584s && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - m33985a >= m33878b || (((i2 = i) == 100 && m33878b2 == 1) || i2 == 106)) {
                                        C7232cp.m34048a(C7245cy.this.f24752a, new C7225ci(C7245cy.this.f24752a, i).m34087a(C7227ck.f24672d), C7227ck.f24672d, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
