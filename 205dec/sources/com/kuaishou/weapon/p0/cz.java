package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cz {

    /* renamed from: b  reason: collision with root package name */
    private static volatile cz f38253b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38254a;

    private cz(Context context) {
        this.f38254a = context;
    }

    public static cz a(Context context) {
        if (f38253b == null) {
            synchronized (cz.class) {
                if (f38253b == null) {
                    f38253b = new cz(context);
                }
            }
        }
        return f38253b;
    }

    public void a(final int i4) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a4 = h.a(cz.this.f38254a, "re_po_rt");
                    if (a4.b("plc002_pp_s", 1) == 1) {
                        long a5 = df.a(cz.this.f38254a).a("cpgc_a1_1_upl_time");
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a4.b("plc002_pp_i", 12) * 3600000;
                        if (a5 > 0 && currentTimeMillis - a5 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a5 >= b4 || i4 == 106) {
                            cp.a(cz.this.f38254a, new cj(cz.this.f38254a).a(ck.f38171g), ck.f38171g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
