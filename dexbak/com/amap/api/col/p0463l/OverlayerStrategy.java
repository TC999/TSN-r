package com.amap.api.col.p0463l;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.col.3l.g3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OverlayerStrategy implements LinkLogStrategy {

    /* renamed from: a */
    private static Map<String, C1817a> f4238a = new ConcurrentHashMap();

    /* compiled from: OverlayerStrategy.java */
    /* renamed from: com.amap.api.col.3l.g3$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1817a {

        /* renamed from: a */
        String f4239a;

        /* renamed from: b */
        String f4240b;

        /* renamed from: c */
        int f4241c;

        /* renamed from: d */
        final AtomicInteger f4242d = new AtomicInteger(0);

        public C1817a(int i, String str, String str2) {
            this.f4239a = str;
            this.f4240b = str2;
            this.f4241c = i;
        }

        /* renamed from: a */
        public final int m54934a() {
            return this.f4242d.incrementAndGet();
        }
    }

    /* renamed from: b */
    private static void m54937b(int i, String str, String str2, int i2) {
        if (i == 0) {
            AMapLogManager m55679c = AMapLogManager.m55679c(C1732a3.m55691s());
            m55679c.m55674h(AMapLogEntity.m53331b(str, str2 + " counter " + i2));
        } else {
            AMapLogManager m55679c2 = AMapLogManager.m55679c(C1732a3.m55691s());
            m55679c2.m55674h(AMapLogEntity.m53331b(str, str2 + " counter " + i2));
        }
        if (LinkLogConfig.f3644b) {
            m54935d(i, str, str2 + " counter " + i2);
        }
    }

    /* renamed from: c */
    private static String m54936c(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: d */
    private static void m54935d(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    @Override // com.amap.api.col.p0463l.LinkLogStrategy
    /* renamed from: a */
    public final void mo54938a(int i, String str, String str2) {
        try {
            String m54936c = m54936c(i, str, str2);
            C1817a c1817a = f4238a.get(m54936c);
            if (c1817a == null) {
                c1817a = new C1817a(i, str, str2);
                f4238a.put(m54936c, c1817a);
            }
            if (c1817a.m54934a() > 100) {
                m54937b(c1817a.f4241c, c1817a.f4239a, c1817a.f4240b, c1817a.f4242d.get());
                f4238a.remove(m54936c);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0463l.LinkLogStrategy
    /* renamed from: a */
    public final void mo54939a() {
        try {
            for (Map.Entry<String, C1817a> entry : f4238a.entrySet()) {
                C1817a value = entry.getValue();
                if (value != null) {
                    m54937b(value.f4241c, value.f4239a, value.f4240b, value.f4242d.get());
                }
            }
            f4238a.clear();
            AMapLogManager.m55679c(C1732a3.m55691s()).m55677e();
        } catch (Throwable unused) {
        }
    }
}
