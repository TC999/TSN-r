package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class db {

    /* renamed from: b  reason: collision with root package name */
    private static volatile db f38268b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38269a;

    private db(Context context) {
        this.f38269a = context;
    }

    public static db a(Context context) {
        if (f38268b == null) {
            synchronized (db.class) {
                if (f38268b == null) {
                    f38268b = new db(context);
                }
            }
        }
        return f38268b;
    }

    public void a(final int i4, final int i5) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                long j4;
                int i6;
                try {
                    h a4 = h.a(db.this.f38269a, "re_po_rt");
                    if (a4.b("plc001_r_s", 1) == 1) {
                        long a5 = df.a(db.this.f38269a).a("es_a1_1_upl_time");
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a4.b("plc001_r_i", 1) * 3600000;
                        long b5 = a4.b("plc001_r_o", 5) * 60000;
                        int b6 = a4.b("plc001_r_b", 0);
                        if (a5 > 0) {
                            j4 = a5;
                            if (currentTimeMillis - a5 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb = new StringBuilder();
                                sb.append(hours);
                                if (list.contains(sb.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j4 = a5;
                        }
                        long j5 = currentTimeMillis - j4;
                        if (j5 >= b4 || (((i6 = i4) == 100 && b6 == 1) || i6 == 106 || (i6 != 100 && i6 > 0 && j5 >= b5))) {
                            cp.a(db.this.f38269a, new cl(db.this.f38269a, i4, i5).a(ck.f38167c), ck.f38167c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
