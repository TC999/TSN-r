package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3l.u5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ErrorLogManager {

    /* renamed from: a */
    private static WeakReference<LogConfig> f5438a = null;

    /* renamed from: b */
    private static boolean f5439b = true;

    /* renamed from: c */
    private static WeakReference<UpdateStrategy> f5440c;

    /* renamed from: d */
    private static WeakReference<UpdateStrategy> f5441d;

    /* renamed from: e */
    private static String[] f5442e = new String[10];

    /* renamed from: f */
    private static int f5443f;

    /* renamed from: g */
    private static boolean f5444g;

    /* renamed from: h */
    private static int f5445h;

    /* renamed from: i */
    private static SDKInfo f5446i;

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1956a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f5447a;

        /* renamed from: b */
        final /* synthetic */ SDKInfo f5448b;

        /* renamed from: c */
        final /* synthetic */ String f5449c;

        /* renamed from: d */
        final /* synthetic */ String f5450d;

        /* renamed from: e */
        final /* synthetic */ LogConfig f5451e;

        C1956a(Context context, SDKInfo sDKInfo, String str, String str2, LogConfig logConfig) {
            this.f5447a = context;
            this.f5448b = sDKInfo;
            this.f5449c = str;
            this.f5450d = str2;
            this.f5451e = logConfig;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            String m53786b = ErrorLogManager.m53786b(this.f5447a, this.f5448b, this.f5449c, this.f5450d);
            LogConfig logConfig = this.f5451e;
            if (logConfig.f3558e == null) {
                logConfig.f3558e = new ADDNumEncryptProcessor(new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())));
            }
            try {
                LogEngine.m55539c(C1849l4.m54582e(m53786b), C1925p4.m54189o(m53786b), this.f5451e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1957b extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f5452a;

        /* renamed from: b */
        final /* synthetic */ String f5453b;

        /* renamed from: c */
        final /* synthetic */ UpdateStrategy f5454c;

        C1957b(Context context, String str, UpdateStrategy updateStrategy) {
            this.f5452a = context;
            this.f5453b = str;
            this.f5454c = updateStrategy;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                synchronized (ErrorLogManager.class) {
                    LogConfig m54750a = Utils.m54750a(ErrorLogManager.f5438a);
                    Utils.m54745f(this.f5452a, m54750a, this.f5453b, 1000, 4096000, "1");
                    m54750a.f3559f = this.f5454c;
                    if (m54750a.f3560g == null) {
                        m54750a.f3560g = new LogJsonDataStrategy(new HeaderAddStrategy(this.f5452a, new ZipUpdateDataStrategy(), new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C1780e4.m55240j(this.f5452a), DeviceInfo.m54806P(), DeviceInfo.m54796Z(this.f5452a), C1780e4.m55243g(this.f5452a), Build.MODEL, C1780e4.m55245e(this.f5452a), C1780e4.m55242h(this.f5452a), Build.VERSION.RELEASE));
                    }
                    m54750a.f3561h = 3600000;
                    LogEngine.m55541a(m54750a);
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "lg", "pul");
            }
        }
    }

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1958c extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ LogConfig f5455a;

        /* renamed from: b */
        final /* synthetic */ Context f5456b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC1959d f5457c;

        C1958c(LogConfig logConfig, Context context, InterfaceC1959d interfaceC1959d) {
            this.f5455a = logConfig;
            this.f5456b = context;
            this.f5457c = interfaceC1959d;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                synchronized (ErrorLogManager.class) {
                    LogConfig logConfig = this.f5455a;
                    if (logConfig.f3560g == null) {
                        logConfig.f3560g = new LogJsonDataStrategy(new HeaderAddStrategy(this.f5456b, new ZipUpdateDataStrategy(), new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C1780e4.m55240j(this.f5456b), DeviceInfo.m54806P(), DeviceInfo.m54796Z(this.f5456b), C1780e4.m55243g(this.f5456b), Build.MODEL, C1780e4.m55245e(this.f5456b), C1780e4.m55242h(this.f5456b), Build.VERSION.RELEASE));
                    }
                    int m55541a = LogEngine.m55541a(this.f5455a);
                    InterfaceC1959d interfaceC1959d = this.f5457c;
                    if (interfaceC1959d != null) {
                        interfaceC1959d.mo53770a(m55541a);
                    }
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "lg", "pul");
            }
        }
    }

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.u5$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1959d {
        /* renamed from: a */
        void mo53770a(int i);
    }

    /* renamed from: a */
    private static SDKInfo m53787a(String str) {
        List<SDKInfo> m54113b = Log.m54113b();
        if (m54113b == null) {
            m54113b = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (SDKInfo sDKInfo : m54113b) {
                if (Log.m54109f(sDKInfo.m54392i(), str)) {
                    return sDKInfo;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return C1925p4.m54203a();
                } catch (AMapCoreException e) {
                    e.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    SDKInfo m54188p = C1925p4.m54188p();
                    m54188p.m54398c(true);
                    return m54188p;
                } catch (AMapCoreException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ String m53786b(Context context, SDKInfo sDKInfo, String str, String str2) {
        String m54749b = Utils.m54749b();
        String m54748c = Utils.m54748c(context, sDKInfo);
        C1780e4.m55249a(context);
        return Utils.m54746e(m54748c, m54749b, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00f5 -> B:107:0x00f8). Please submit an issue!!! */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m53785c(java.util.List<com.amap.api.col.p0463l.SDKInfo> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.ErrorLogManager.m53785c(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static void m53783e(Context context) {
        String m53785c;
        SDKInfo sDKInfo;
        List<SDKInfo> m54113b = Log.m54113b();
        if (m54113b == null || m54113b.size() == 0 || (m53785c = m53785c(m54113b)) == null || "".equals(m53785c) || (sDKInfo = f5446i) == null) {
            return;
        }
        m53782f(context, sDKInfo, 2, "ANR", m53785c);
    }

    /* renamed from: f */
    private static void m53782f(Context context, SDKInfo sDKInfo, int i, String str, String str2) {
        String str3;
        String m54749b = Utils.m54749b();
        String m54748c = Utils.m54748c(context, sDKInfo);
        C1780e4.m55249a(context);
        String m54747d = Utils.m54747d(m54748c, m54749b, i, str, str2);
        if (m54747d == null || "".equals(m54747d)) {
            return;
        }
        String m54582e = C1849l4.m54582e(str2);
        if (i == 1) {
            str3 = Log.f5119b;
        } else if (i == 2) {
            str3 = Log.f5121d;
        } else if (i != 0) {
            return;
        } else {
            str3 = Log.f5120c;
        }
        String str4 = str3;
        LogConfig m54750a = Utils.m54750a(f5438a);
        Utils.m54745f(context, m54750a, str4, 1000, 4096000, "1");
        if (m54750a.f3558e == null) {
            m54750a.f3558e = new ADDNumEncryptProcessor(new Base64EncryptProcessor(new GZipEncryptProcessor(new RSAAESEncryptProcessor())));
        }
        try {
            LogEngine.m55539c(m54582e, C1925p4.m54189o(m54747d.replaceAll(ShellAdbUtils.f33810d, "<br/>")), m54750a);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    public static void m53781g(Context context, SDKInfo sDKInfo, String str, int i, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        m53782f(context, sDKInfo, i, str2, sb.toString());
    }

    /* renamed from: h */
    public static void m53780h(Context context, SDKInfo sDKInfo, String str, LogConfig logConfig, String str2) {
        try {
            ThreadPool.m53398h().m55654b(new C1956a(context, sDKInfo, str, str2, logConfig));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public static void m53779i(Context context, LogConfig logConfig, InterfaceC1959d interfaceC1959d) {
        try {
            ThreadPool.m53398h().m55654b(new C1958c(logConfig, context, interfaceC1959d));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    private static void m53778j(Context context, UpdateStrategy updateStrategy, String str) {
        ThreadPool.m53398h().m55654b(new C1957b(context, str, updateStrategy));
    }

    /* renamed from: k */
    public static void m53777k(Context context, Throwable th, int i, String str, String str2) {
        String m54199e = C1925p4.m54199e(th);
        SDKInfo m53787a = m53787a(m54199e);
        if (m53775m(m53787a)) {
            String replaceAll = m54199e.replaceAll(ShellAdbUtils.f33810d, "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            m53782f(context, m53787a, i, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static void m53776l(SDKInfo sDKInfo, Context context, String str, String str2) {
        if (!m53775m(sDKInfo) || str == null || "".equals(str)) {
            return;
        }
        m53782f(context, sDKInfo, 1, str, str2);
    }

    /* renamed from: m */
    private static boolean m53775m(SDKInfo sDKInfo) {
        return sDKInfo != null && sDKInfo.m54393h();
    }

    /* renamed from: n */
    private static String m53774n() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = f5443f; i < 10 && i <= 9; i++) {
                sb.append(f5442e[i]);
            }
            for (int i2 = 0; i2 < f5443f; i2++) {
                sb.append(f5442e[i2]);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static void m53773o(Context context) {
        SwitchUpdateStrategy switchUpdateStrategy = new SwitchUpdateStrategy(f5439b);
        f5439b = false;
        m53778j(context, switchUpdateStrategy, Log.f5120c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static void m53772p(Context context) {
        WeakReference<UpdateStrategy> weakReference = f5440c;
        if (weakReference == null || weakReference.get() == null) {
            f5440c = new WeakReference<>(new TimeUpdateStrategy(context, 3600000, "hKey", new WiFiUplateStrategy(context, false)));
        }
        m53778j(context, f5440c.get(), Log.f5121d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static void m53771q(Context context) {
        WeakReference<UpdateStrategy> weakReference = f5441d;
        if (weakReference == null || weakReference.get() == null) {
            f5441d = new WeakReference<>(new TimeUpdateStrategy(context, 3600000, "gKey", new WiFiUplateStrategy(context, false)));
        }
        m53778j(context, f5441d.get(), Log.f5119b);
    }
}
