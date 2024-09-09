package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cy {

    /* renamed from: b  reason: collision with root package name */
    private static volatile cy f38247b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38248a;

    private cy(Context context) {
        this.f38248a = context;
    }

    public static cy a(Context context) {
        if (f38247b == null) {
            synchronized (cy.class) {
                if (f38247b == null) {
                    f38247b = new cy(context);
                }
            }
        }
        return f38247b;
    }

    public void a(final int i4) {
        try {
            h a4 = h.a(this.f38248a, "re_po_rt");
            final boolean e4 = a4.e("a1_p_s_p_s");
            final boolean e5 = a4.e("a1_p_s_p_s_c_b");
            if ((e4 || e5) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i5;
                        try {
                            h a5 = h.a(cy.this.f38248a, "re_po_rt");
                            if (a5.b("plc001_al_s", 0) == 1) {
                                if (e4 || e5) {
                                    long a6 = df.a(cy.this.f38248a).a("apl_a1_1_upl_time");
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b4 = a5.b("plc001_al_i", 8) * 3600000;
                                    int b5 = a5.b("plc001_al_b", 0);
                                    if (a6 > 0 && currentTimeMillis - a6 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - a6 >= b4 || (((i5 = i4) == 100 && b5 == 1) || i5 == 106)) {
                                        cp.a(cy.this.f38248a, new ci(cy.this.f38248a, i4).a(ck.f38168d), ck.f38168d, true, true);
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
