package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cx {

    /* renamed from: b  reason: collision with root package name */
    private static volatile cx f38243b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38244a;

    private cx(Context context) {
        this.f38244a = context;
    }

    public static cx a(Context context) {
        if (f38243b == null) {
            synchronized (cx.class) {
                if (f38243b == null) {
                    f38243b = new cx(context);
                }
            }
        }
        return f38243b;
    }

    public void a(final int i4) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i5;
                try {
                    h a4 = h.a(cx.this.f38244a, "re_po_rt");
                    if (a4.b("plc001_act_s", 0) == 1) {
                        long a5 = df.a(cx.this.f38244a).a("act_a1_1_upl_time");
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a4.b("plc001_act_i", 8) * 3600000;
                        int b5 = a4.b("plc001_al_b", 0);
                        if (a5 > 0 && currentTimeMillis - a5 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a5 >= b4 || (i5 = i4) == 106 || (i5 == 100 && b5 == 1)) {
                            cp.a(cx.this.f38244a, new ch(cx.this.f38244a, i4).a(ck.f38173i), ck.f38173i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
