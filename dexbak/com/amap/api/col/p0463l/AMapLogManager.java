package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0463l.ErrorLogManager;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.stub.StubApp;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* renamed from: com.amap.api.col.3l.a5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AMapLogManager {

    /* renamed from: a */
    private Context f3533a;

    /* renamed from: b */
    private SDKInfo f3534b;

    /* renamed from: c */
    private boolean f3535c = true;

    /* renamed from: d */
    private boolean f3536d = false;

    /* renamed from: e */
    private boolean f3537e = true;

    /* renamed from: f */
    private boolean f3538f = false;

    /* renamed from: g */
    private List<String> f3539g = new ArrayList();

    /* renamed from: h */
    private LogMemCacher f3540h = new LogMemCacher((byte) 0);

    /* renamed from: i */
    private LogMemCacher f3541i = new LogMemCacher();

    /* renamed from: j */
    private ErrorLogManager.InterfaceC1959d f3542j = new C1733a();

    /* renamed from: k */
    private ErrorLogManager.InterfaceC1959d f3543k = new C1735b();

    /* renamed from: l */
    private Handler f3544l = null;

    /* renamed from: m */
    private LogConfig f3545m = null;

    /* renamed from: n */
    private LogConfig f3546n = null;

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1733a implements ErrorLogManager.InterfaceC1959d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.a5$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1734a implements Runnable {
            RunnableC1734a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AMapLogManager.this.m55663s(false);
            }
        }

        C1733a() {
        }

        @Override // com.amap.api.col.p0463l.ErrorLogManager.InterfaceC1959d
        /* renamed from: a */
        public final void mo53770a(int i) {
            if (i > 0 && AMapLogManager.m55680b(AMapLogManager.this) != null) {
                ((AMapRecallLogUpdateStrategy) AMapLogManager.this.m55666p().f3559f).m55544f(i);
                AMapLogManager.m55673i(AMapLogManager.this, "error", String.valueOf(((AMapRecallLogUpdateStrategy) AMapLogManager.this.m55666p().f3559f).m55542h()));
                AMapLogManager.m55680b(AMapLogManager.this).postDelayed(new RunnableC1734a(), 660000L);
            }
        }
    }

    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1735b implements ErrorLogManager.InterfaceC1959d {

        /* compiled from: AMapLogManager.java */
        /* renamed from: com.amap.api.col.3l.a5$b$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1736a implements Runnable {
            RunnableC1736a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AMapLogManager.this.m55660v(false);
            }
        }

        C1735b() {
        }

        @Override // com.amap.api.col.p0463l.ErrorLogManager.InterfaceC1959d
        /* renamed from: a */
        public final void mo53770a(int i) {
            if (i <= 0) {
                return;
            }
            ((AMapRecallLogUpdateStrategy) AMapLogManager.this.m55659w().f3559f).m55544f(i);
            AMapLogManager.m55673i(AMapLogManager.this, "info", String.valueOf(((AMapRecallLogUpdateStrategy) AMapLogManager.this.m55659w().f3559f).m55542h()));
            if (AMapLogManager.m55680b(AMapLogManager.this) == null) {
                return;
            }
            AMapLogManager.m55680b(AMapLogManager.this).postDelayed(new RunnableC1736a(), 660000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapLogManager.java */
    /* renamed from: com.amap.api.col.3l.a5$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1737c {

        /* renamed from: a */
        public static Map<String, AMapLogManager> f3551a = new HashMap();
    }

    private AMapLogManager(SDKInfo sDKInfo) {
        this.f3534b = sDKInfo;
    }

    /* renamed from: A */
    private String m55682A() {
        Context context = this.f3533a;
        if (context == null) {
            return null;
        }
        return m55678d(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f3534b);
    }

    /* renamed from: a */
    private long m55681a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            SPConfigUtil m55294a = SPConfigUtil.m55294a(this.f3534b);
            Context context = this.f3533a;
            return Long.parseLong(m55294a.m55292c(context, "", "", format + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: b */
    static /* synthetic */ Handler m55680b(AMapLogManager aMapLogManager) {
        Context context = aMapLogManager.f3533a;
        if (context == null || context == null) {
            return null;
        }
        if (aMapLogManager.f3544l == null) {
            aMapLogManager.f3544l = new Handler(aMapLogManager.f3533a.getMainLooper());
        }
        return aMapLogManager.f3544l;
    }

    /* renamed from: c */
    public static AMapLogManager m55679c(SDKInfo sDKInfo) {
        if (sDKInfo == null || TextUtils.isEmpty(sDKInfo.m54400a())) {
            return null;
        }
        if (C1737c.f3551a.get(sDKInfo.m54400a()) == null) {
            C1737c.f3551a.put(sDKInfo.m54400a(), new AMapLogManager(sDKInfo));
        }
        return C1737c.f3551a.get(sDKInfo.m54400a());
    }

    /* renamed from: d */
    private static String m55678d(Context context, String str, SDKInfo sDKInfo) {
        String m54583d;
        if (context == null) {
            return null;
        }
        if (sDKInfo != null) {
            try {
                if (!TextUtils.isEmpty(sDKInfo.m54400a())) {
                    m54583d = C1849l4.m54583d(sDKInfo.m54400a());
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir().getAbsolutePath());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb.append(str2);
                    sb.append(str);
                    sb.append(str2);
                    sb.append(m54583d);
                    return sb.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        m54583d = "a";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        String str22 = File.separator;
        sb2.append(str22);
        sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb2.append(str22);
        sb2.append(str);
        sb2.append(str22);
        sb2.append(m54583d);
        return sb2.toString();
    }

    /* renamed from: f */
    private void m55676f(int i) {
        Context context;
        LogMemCacher m55670l = m55670l(i);
        String m53329d = AMapLogEntity.m53329d(m55670l.m55470a());
        if (TextUtils.isEmpty(m53329d) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(m53329d) || (context = this.f3533a) == null) {
            return;
        }
        ErrorLogManager.m53780h(context, this.f3534b, AMapLogEntity.m53330c(i), m55665q(i), m53329d);
        m55670l.m55467d();
    }

    /* renamed from: i */
    static /* synthetic */ void m55673i(AMapLogManager aMapLogManager, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            SPConfigUtil m55294a = SPConfigUtil.m55294a(aMapLogManager.f3534b);
            Context context = aMapLogManager.f3533a;
            m55294a.m55291d(context, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: l */
    private LogMemCacher m55670l(int i) {
        if (i == AMapLogEntity.f5819f) {
            return this.f3541i;
        }
        return this.f3540h;
    }

    /* renamed from: n */
    private void m55668n(boolean z) {
        m55663s(z);
        m55660v(z);
    }

    /* renamed from: o */
    private boolean m55667o() {
        return this.f3533a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public LogConfig m55666p() {
        LogConfig logConfig = this.f3546n;
        if (logConfig != null) {
            return logConfig;
        }
        m55662t();
        return this.f3546n;
    }

    /* renamed from: q */
    private LogConfig m55665q(int i) {
        if (i == AMapLogEntity.f5819f) {
            if (this.f3546n == null) {
                this.f3546n = m55666p();
            }
            return this.f3546n;
        }
        if (this.f3545m == null) {
            this.f3545m = m55659w();
        }
        return this.f3545m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m55663s(boolean z) {
        LogConfig m55665q = m55665q(AMapLogEntity.f5819f);
        if (z) {
            ((AMapRecallLogUpdateStrategy) m55665q.f3559f).m55543g(z);
        }
        Context context = this.f3533a;
        if (context == null) {
            return;
        }
        ErrorLogManager.m53779i(context, m55665q, this.f3542j);
    }

    /* renamed from: t */
    private LogConfig m55662t() {
        if (this.f3533a == null) {
            return null;
        }
        LogConfig logConfig = new LogConfig();
        this.f3546n = logConfig;
        logConfig.f3554a = m55682A();
        LogConfig logConfig2 = this.f3546n;
        logConfig2.f3555b = 512000000L;
        logConfig2.f3557d = 12500;
        logConfig2.f3556c = "1";
        logConfig2.f3561h = -1;
        logConfig2.f3562i = "elkey";
        long m55681a = m55681a("error");
        this.f3546n.f3559f = new AMapRecallLogUpdateStrategy(true, new WiFiUplateStrategy(this.f3533a, this.f3536d), m55681a, PredefinedCaptureConfigurations.f24413w);
        LogConfig logConfig3 = this.f3546n;
        logConfig3.f3560g = null;
        return logConfig3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m55660v(boolean z) {
        LogConfig m55665q = m55665q(AMapLogEntity.f5818e);
        if (z) {
            ((AMapRecallLogUpdateStrategy) m55665q.f3559f).m55543g(z);
        }
        Context context = this.f3533a;
        if (context == null) {
            return;
        }
        ErrorLogManager.m53779i(context, m55665q, this.f3543k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public LogConfig m55659w() {
        LogConfig logConfig = this.f3545m;
        if (logConfig != null) {
            return logConfig;
        }
        m55657y();
        return this.f3545m;
    }

    /* renamed from: y */
    private LogConfig m55657y() {
        if (this.f3533a == null) {
            return null;
        }
        LogConfig logConfig = new LogConfig();
        this.f3545m = logConfig;
        logConfig.f3554a = m55656z();
        LogConfig logConfig2 = this.f3545m;
        logConfig2.f3555b = 512000000L;
        logConfig2.f3557d = 12500;
        logConfig2.f3556c = "1";
        logConfig2.f3561h = -1;
        logConfig2.f3562i = "inlkey";
        long m55681a = m55681a("info");
        this.f3545m.f3559f = new AMapRecallLogUpdateStrategy(this.f3538f, new WiFiUplateStrategy(this.f3533a, this.f3536d), m55681a, 30000000);
        LogConfig logConfig3 = this.f3545m;
        logConfig3.f3560g = null;
        return logConfig3;
    }

    /* renamed from: z */
    private String m55656z() {
        Context context = this.f3533a;
        if (context == null) {
            return null;
        }
        return m55678d(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f3534b);
    }

    /* renamed from: e */
    public final void m55677e() {
        if (m55667o()) {
            m55676f(AMapLogEntity.f5819f);
            m55676f(AMapLogEntity.f5818e);
        }
    }

    /* renamed from: g */
    public final void m55675g(Context context) {
        this.f3533a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: h */
    public final void m55674h(AMapLogEntity aMapLogEntity) {
        if (m55667o() && this.f3535c && AMapLogEntity.m53328e(aMapLogEntity)) {
            boolean z = true;
            if (aMapLogEntity != null) {
                List<String> list = this.f3539g;
                if (list != null && list.size() != 0) {
                    for (int i = 0; i < this.f3539g.size(); i++) {
                        if (!TextUtils.isEmpty(this.f3539g.get(i)) && aMapLogEntity.m53326g().contains(this.f3539g.get(i))) {
                            break;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                return;
            }
            if (this.f3537e || aMapLogEntity.m53332a() != AMapLogEntity.f5818e) {
                LogMemCacher m55670l = m55670l(aMapLogEntity.m53332a());
                if (m55670l.m55468c(aMapLogEntity.m53326g())) {
                    String m53329d = AMapLogEntity.m53329d(m55670l.m55470a());
                    if (this.f3533a == null || TextUtils.isEmpty(m53329d) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(m53329d)) {
                        return;
                    }
                    ErrorLogManager.m53780h(this.f3533a, this.f3534b, aMapLogEntity.m53324i(), m55665q(aMapLogEntity.m53332a()), m53329d);
                    m55668n(false);
                    m55670l.m55467d();
                }
                m55670l.m55469b(aMapLogEntity);
            }
        }
    }

    /* renamed from: j */
    public final void m55672j(boolean z) {
        if (m55667o()) {
            m55668n(z);
        }
    }

    /* renamed from: k */
    public final void m55671k(boolean z, boolean z2, boolean z3, boolean z4, List<String> list) {
        this.f3535c = z;
        this.f3536d = z2;
        this.f3537e = z3;
        this.f3538f = z4;
        this.f3539g = list;
        m55662t();
        m55657y();
    }
}
