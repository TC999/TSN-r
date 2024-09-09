package com.bytedance.sdk.openadsdk.core.q;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile long f34491c = 0;

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f34492w = "0";

    /* renamed from: com.bytedance.sdk.openadsdk.core.q.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0504c implements gd {
        @Override // com.bytedance.sdk.component.w.c.gd
        public fp c(gd.c cVar) throws IOException {
            ia f4;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            t c4 = cVar.c();
            fp c5 = cVar.c(c4);
            if (!"GET".equalsIgnoreCase(c4.xv()) || (f4 = c5.f()) == null) {
                return c5;
            }
            long c6 = f4.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 > 0 && c6 > 10240) {
                double d4 = c6;
                Double.isNaN(d4);
                double d5 = elapsedRealtime2;
                Double.isNaN(d5);
                String unused = c.f34492w = String.format("%.2f", Double.valueOf(((d4 / 1024.0d) / d5) * 1000.0d));
                long unused2 = c.f34491c = System.currentTimeMillis();
                a.w("speed", "update to:" + c.f34492w);
            }
            return c5;
        }
    }

    public static String c() {
        return System.currentTimeMillis() - f34491c < 7200000 ? f34492w : "0";
    }
}
