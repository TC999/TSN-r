package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class de {

    /* renamed from: b  reason: collision with root package name */
    private static volatile de f38281b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38282a;

    private de(Context context) {
        this.f38282a = context;
    }

    public static de a(Context context) {
        if (f38281b == null) {
            synchronized (de.class) {
                if (f38281b == null) {
                    f38281b = new de(context);
                }
            }
        }
        return f38281b;
    }

    public void a(final int i4) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a4 = h.a(de.this.f38282a, "re_po_rt");
                    if (a4.b("plc002_soc_s", 0) == 1) {
                        long a5 = df.a(de.this.f38282a).a("soc_a1_1_upl_time");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a5 >= a4.b("plc002_soc_i", 2) * 3600000 || i4 == 106) {
                            try {
                                String a6 = new co(de.this.f38282a).a(ck.f38172h);
                                int intValue = Integer.valueOf(ck.f38172h).intValue();
                                if (a6 != null && a6.length() > 10) {
                                    new bc(de.this.f38282a, a6, intValue).a("1000");
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f38282a).a("soc_a1_1_upl_time", currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
