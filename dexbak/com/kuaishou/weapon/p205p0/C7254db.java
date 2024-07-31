package com.kuaishou.weapon.p205p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.db */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7254db {

    /* renamed from: b */
    private static volatile C7254db f24772b;

    /* renamed from: a */
    private Context f24773a;

    private C7254db(Context context) {
        this.f24773a = context;
    }

    /* renamed from: a */
    public static C7254db m33999a(Context context) {
        if (f24772b == null) {
            synchronized (C7254db.class) {
                if (f24772b == null) {
                    f24772b = new C7254db(context);
                }
            }
        }
        return f24772b;
    }

    /* renamed from: a */
    public void m34000a(final int i, final int i2) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                long j;
                int i3;
                try {
                    C7283h m33888a = C7283h.m33888a(C7254db.this.f24773a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24804P, 1) == 1) {
                        long m33985a = C7262df.m33986a(C7254db.this.f24773a).m33985a(C7262df.f24878bj);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m33878b = m33888a.m33878b(C7262df.f24806R, 1) * C7193bi.f24584s;
                        long m33878b2 = m33888a.m33878b(C7262df.f24807S, 5) * 60000;
                        int m33878b3 = m33888a.m33878b(C7262df.f24808T, 0);
                        if (m33985a > 0) {
                            j = m33985a;
                            if (currentTimeMillis - m33985a < WeaponHI.f24464ii * C7193bi.f24584s && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb = new StringBuilder();
                                sb.append(hours);
                                if (list.contains(sb.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j = m33985a;
                        }
                        long j2 = currentTimeMillis - j;
                        if (j2 >= m33878b || (((i3 = i) == 100 && m33878b3 == 1) || i3 == 106 || (i3 != 100 && i3 > 0 && j2 >= m33878b2))) {
                            C7232cp.m34048a(C7254db.this.f24773a, new C7228cl(C7254db.this.f24773a, i, i2).m34083a(C7227ck.f24671c), C7227ck.f24671c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
