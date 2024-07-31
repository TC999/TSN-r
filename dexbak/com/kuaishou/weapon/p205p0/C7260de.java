package com.kuaishou.weapon.p205p0;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* renamed from: com.kuaishou.weapon.p0.de */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7260de {

    /* renamed from: b */
    private static volatile C7260de f24785b;

    /* renamed from: a */
    private Context f24786a;

    private C7260de(Context context) {
        this.f24786a = context;
    }

    /* renamed from: a */
    public static C7260de m33990a(Context context) {
        if (f24785b == null) {
            synchronized (C7260de.class) {
                if (f24785b == null) {
                    f24785b = new C7260de(context);
                }
            }
        }
        return f24785b;
    }

    /* renamed from: a */
    public void m33991a(final int i) {
        C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C7283h m33888a = C7283h.m33888a(C7260de.this.f24786a, "re_po_rt");
                    if (m33888a.m33878b(C7262df.f24790B, 0) == 1) {
                        long m33985a = C7262df.m33986a(C7260de.this.f24786a).m33985a(C7262df.f24882bn);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - m33985a >= m33888a.m33878b(C7262df.f24793E, 2) * C7193bi.f24584s || i == 106) {
                            try {
                                String m34051a = new C7231co(C7260de.this.f24786a).m34051a(C7227ck.f24676h);
                                int intValue = Integer.valueOf(C7227ck.f24676h).intValue();
                                if (m34051a != null && m34051a.length() > 10) {
                                    new C7186bc(C7260de.this.f24786a, m34051a, intValue).m34292a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            C7262df.m33986a(C7260de.this.f24786a).m33984a(C7262df.f24882bn, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
