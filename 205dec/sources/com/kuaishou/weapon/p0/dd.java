package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dd {

    /* renamed from: b  reason: collision with root package name */
    private static volatile dd f38277b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38278a;

    private dd(Context context) {
        this.f38278a = context;
    }

    public static dd a(Context context) {
        if (f38277b == null) {
            synchronized (dd.class) {
                if (f38277b == null) {
                    f38277b = new dd(context);
                }
            }
        }
        return f38277b;
    }

    public void a(final int i4) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a4 = h.a(dd.this.f38278a, "re_po_rt");
                    if (a4.b("plc001_b_s", 1) == 1) {
                        long a5 = df.a(dd.this.f38278a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a4.b("plc001_b_i", 8) * 3600000;
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
                            cp.a(dd.this.f38278a, new cn(dd.this.f38278a, i4).a(ck.f38166b), ck.f38166b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
