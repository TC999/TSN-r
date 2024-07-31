package com.kuaishou.weapon.p205p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.cz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7247cz {

    /* renamed from: b */
    private static volatile C7247cz f24757b;

    /* renamed from: a */
    private Context f24758a;

    private C7247cz(Context context) {
        this.f24758a = context;
    }

    /* renamed from: a */
    public static C7247cz m34014a(Context context) {
        if (f24757b == null) {
            synchronized (C7247cz.class) {
                if (f24757b == null) {
                    f24757b = new C7247cz(context);
                }
            }
        }
        return f24757b;
    }

    /* renamed from: a */
    public void m34015a(final int i) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7283h m33888a = C7283h.m33888a(C7247cz.this.f24758a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24795G, 1) == 1) {
                        long m33985a = C7262df.m33986a(C7247cz.this.f24758a).m33985a(C7262df.f24881bm);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m33878b = m33888a.m33878b(C7262df.f24797I, 12) * C7193bi.f24584s;
                        if (m33985a > 0 && currentTimeMillis - m33985a < WeaponHI.f24464ii * C7193bi.f24584s && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - m33985a >= m33878b || i == 106) {
                            C7232cp.m34048a(C7247cz.this.f24758a, new C7226cj(C7247cz.this.f24758a).m34085a(C7227ck.f24675g), C7227ck.f24675g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
