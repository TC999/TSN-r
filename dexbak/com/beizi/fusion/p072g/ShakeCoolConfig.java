package com.beizi.fusion.p072g;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.beizi.fusion.g.aq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShakeCoolConfig {

    /* renamed from: a */
    private static volatile ShakeCoolConfig f11320a;

    /* renamed from: b */
    private Map<String, Long> f11321b = new HashMap();

    /* renamed from: a */
    public static ShakeCoolConfig m48369a() {
        if (f11320a == null) {
            synchronized (ShakeCoolConfig.class) {
                if (f11320a == null) {
                    f11320a = new ShakeCoolConfig();
                }
            }
        }
        return f11320a;
    }

    /* renamed from: b */
    public long m48366b(String str) {
        if (this.f11321b.containsKey(str)) {
            return this.f11321b.get(str).longValue();
        }
        return 0L;
    }

    /* renamed from: a */
    public void m48367a(String str, long j) {
        this.f11321b.put(str, Long.valueOf(j));
    }

    /* renamed from: a */
    public void m48368a(String str) {
        if (this.f11321b.containsKey(str)) {
            this.f11321b.remove(str);
        }
    }
}
