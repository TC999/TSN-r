package com.amap.api.col.p0463l;

import android.os.SystemClock;
import com.amap.api.col.p0463l.CellCollector;
import java.util.List;

/* renamed from: com.amap.api.col.3l.h8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FpsCollector {

    /* renamed from: g */
    private static volatile FpsCollector f4457g;

    /* renamed from: h */
    private static Object f4458h = new Object();

    /* renamed from: c */
    private long f4461c;

    /* renamed from: d */
    private AmapLocationGnss f4462d;

    /* renamed from: f */
    private AmapLocationGnss f4464f = new AmapLocationGnss();

    /* renamed from: a */
    private CellCollector f4459a = new CellCollector();

    /* renamed from: b */
    private WifiCollector f4460b = new WifiCollector();

    /* renamed from: e */
    private FpsBufferBuilder f4463e = new FpsBufferBuilder();

    /* compiled from: FpsCollector.java */
    /* renamed from: com.amap.api.col.3l.h8$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1836a {

        /* renamed from: a */
        public AmapLocationGnss f4465a;

        /* renamed from: b */
        public List<AmapWifi> f4466b;

        /* renamed from: c */
        public long f4467c;

        /* renamed from: d */
        public long f4468d;

        /* renamed from: e */
        public boolean f4469e;

        /* renamed from: f */
        public long f4470f;

        /* renamed from: g */
        public byte f4471g;

        /* renamed from: h */
        public String f4472h;

        /* renamed from: i */
        public List<AmapCell> f4473i;

        /* renamed from: j */
        public boolean f4474j;
    }

    private FpsCollector() {
    }

    /* renamed from: a */
    public static FpsCollector m54743a() {
        if (f4457g == null) {
            synchronized (f4458h) {
                if (f4457g == null) {
                    f4457g = new FpsCollector();
                }
            }
        }
        return f4457g;
    }

    /* renamed from: b */
    public final CollectionData m54742b(C1836a c1836a) {
        CollectionData collectionData = null;
        if (c1836a == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AmapLocationGnss amapLocationGnss = this.f4462d;
        if (amapLocationGnss == null || c1836a.f4465a.m54741a(amapLocationGnss) >= 10.0d) {
            CellCollector.C1822a m54905a = this.f4459a.m54905a(c1836a.f4465a, c1836a.f4474j, c1836a.f4471g, c1836a.f4472h, c1836a.f4473i);
            List<AmapWifi> m54709a = this.f4460b.m54709a(c1836a.f4465a, c1836a.f4466b, c1836a.f4469e, c1836a.f4468d, currentTimeMillis);
            if (m54905a != null || m54709a != null) {
                GpsUtil.m55017a(this.f4464f, c1836a.f4465a, c1836a.f4470f, currentTimeMillis);
                collectionData = new CollectionData(0, this.f4463e.m55274f(this.f4464f, m54905a, c1836a.f4467c, m54709a));
            }
            this.f4462d = c1836a.f4465a;
            this.f4461c = elapsedRealtime;
        }
        return collectionData;
    }
}
