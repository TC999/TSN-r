package com.kuaishou.weapon.p205p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.dd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7258dd {

    /* renamed from: b */
    private static volatile C7258dd f24781b;

    /* renamed from: a */
    private Context f24782a;

    private C7258dd(Context context) {
        this.f24782a = context;
    }

    /* renamed from: a */
    public static C7258dd m33993a(Context context) {
        if (f24781b == null) {
            synchronized (C7258dd.class) {
                if (f24781b == null) {
                    f24781b = new C7258dd(context);
                }
            }
        }
        return f24781b;
    }

    /* renamed from: a */
    public void m33994a(final int i) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7283h m33888a = C7283h.m33888a(C7258dd.this.f24782a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24818aC, 1) == 1) {
                        long m33988a = C7262df.m33986a(C7258dd.this.f24782a).m33988a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long m33878b = m33888a.m33878b(C7262df.f24820aE, 8) * C7193bi.f24584s;
                        if (m33988a > 0 && currentTimeMillis - m33988a < WeaponHI.f24464ii * C7193bi.f24584s && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - m33988a >= m33878b || i == 106) {
                            C7232cp.m34048a(C7258dd.this.f24782a, new C7230cn(C7258dd.this.f24782a, i).m34053a(C7227ck.f24670b), C7227ck.f24670b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
