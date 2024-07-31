package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3l.e7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class OfflineLocManager {

    /* renamed from: a */
    static int f3932a = 1000;

    /* renamed from: b */
    static boolean f3933b = false;

    /* renamed from: c */
    private static WeakReference<LogConfig> f3934c = null;

    /* renamed from: d */
    static int f3935d = 20;

    /* renamed from: e */
    private static int f3936e = 10;

    /* renamed from: f */
    static int f3937f;

    @Deprecated
    /* renamed from: b */
    public static synchronized void m55216b(int i, boolean z) {
        synchronized (OfflineLocManager.class) {
            f3932a = i;
            f3933b = z;
        }
    }

    /* renamed from: c */
    public static synchronized void m55215c(int i, boolean z, int i2, int i3) {
        synchronized (OfflineLocManager.class) {
            f3932a = i;
            f3933b = z;
            i2 = (i2 < 10 || i2 > 100) ? 20 : 20;
            f3935d = i2;
            if (i2 / 5 > f3936e) {
                f3936e = i2 / 5;
            }
            f3937f = i3;
        }
    }

    /* renamed from: d */
    public static void m55214d(Context context) {
        ThreadPool.m53398h().m55654b(new C1782a(context, 2));
    }

    /* renamed from: e */
    public static synchronized void m55213e(OfflineLocEntity offlineLocEntity, Context context) {
        synchronized (OfflineLocManager.class) {
            ThreadPool.m53398h().m55654b(new C1782a(context, offlineLocEntity));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineLocManager.java */
    /* renamed from: com.amap.api.col.3l.e7$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1782a extends ThreadTask {

        /* renamed from: a */
        private int f3938a;

        /* renamed from: b */
        private Context f3939b;

        /* renamed from: c */
        private OfflineLocEntity f3940c;

        C1782a(Context context, int i) {
            this.f3939b = context;
            this.f3938a = i;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            int i = this.f3938a;
            if (i == 1) {
                try {
                    synchronized (OfflineLocManager.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        LogConfig m54750a = Utils.m54750a(OfflineLocManager.f3934c);
                        Utils.m54745f(this.f3939b, m54750a, Log.f5126i, OfflineLocManager.f3932a, 2097152, "6");
                        if (m54750a.f3558e == null) {
                            m54750a.f3558e = new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor(new GZipEncryptProcessor())));
                        }
                        LogEngine.m55539c(l, this.f3940c.m55279b(), m54750a);
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    LogConfig m54750a2 = Utils.m54750a(OfflineLocManager.f3934c);
                    Utils.m54745f(this.f3939b, m54750a2, Log.f5126i, OfflineLocManager.f3932a, 2097152, "6");
                    m54750a2.f3561h = 14400000;
                    if (m54750a2.f3560g == null) {
                        m54750a2.f3560g = new LogJsonDataStrategy(new HeaderAddStrategy(this.f3939b, new ZipUpdateDataStrategy(), new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())), new String(ConstConfig.m55235c()), C1780e4.m55240j(this.f3939b), DeviceInfo.m54806P(), DeviceInfo.m54813I(), DeviceInfo.m54816F(this.f3939b), DeviceInfo.m54770n(), Build.MANUFACTURER, Build.DEVICE, DeviceInfo.m54801U(), C1780e4.m55243g(this.f3939b), Build.MODEL, C1780e4.m55242h(this.f3939b), C1780e4.m55245e(this.f3939b), DeviceInfo.m54818D(this.f3939b), DeviceInfo.m54769o(this.f3939b), String.valueOf(Build.VERSION.SDK_INT), AAIDManager.m53660a(this.f3939b).m53659b()));
                    }
                    if (TextUtils.isEmpty(m54750a2.f3562i)) {
                        m54750a2.f3562i = "fKey";
                    }
                    Context context = this.f3939b;
                    m54750a2.f3559f = new TimeUpdateStrategy(context, m54750a2.f3561h, m54750a2.f3562i, new MobileUpdateStrategy(context, OfflineLocManager.f3933b, OfflineLocManager.f3936e * 1024, OfflineLocManager.f3935d * 1024, "offLocKey", OfflineLocManager.f3937f * 1024));
                    LogEngine.m55541a(m54750a2);
                } catch (Throwable th2) {
                    SDKLogHandler.m53863p(th2, "ofm", "uold");
                }
            }
        }

        C1782a(Context context, OfflineLocEntity offlineLocEntity) {
            this(context, 1);
            this.f3940c = offlineLocEntity;
        }
    }
}
