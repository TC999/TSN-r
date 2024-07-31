package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.clj.fastble.BleManager;
import com.kwad.components.core.C8531b;
import com.kwad.components.core.p285a.C8527a;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p297h.C8661a;
import com.kwad.components.core.p304n.p311b.C8735b;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p318p.C8770b;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.proxy.C8880a;
import com.kwad.components.core.proxy.C8885b;
import com.kwad.components.core.request.C8918g;
import com.kwad.components.core.webview.tachikoma.C9295g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.p206a.p207a.InterfaceC7326a;
import com.kwad.framework.p346a.C9425a;
import com.kwad.library.solder.lib.C9645i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.collector.InterfaceC9802h;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.components.C9860b;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.C10278a;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.request.model.C10474a;
import com.kwad.sdk.core.request.model.C10475b;
import com.kwad.sdk.core.request.model.C10478d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.C10512c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.webview.p418b.C10606a;
import com.kwad.sdk.crash.online.monitor.C10694a;
import com.kwad.sdk.kgeo.C10839a;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p368b.C9768b;
import com.kwad.sdk.p369c.C9778a;
import com.kwad.sdk.p434g.AbstractC10762b;
import com.kwad.sdk.p438ip.direct.C10808a;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.p439j.C10824b;
import com.kwad.sdk.p445n.C10873e;
import com.kwad.sdk.p445n.C10882k;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.ranger.C10959d;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11024aq;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11034az;
import com.kwad.sdk.utils.C11061bk;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11082f;
import com.kwad.sdk.utils.C11127u;
import com.kwad.sdk.utils.C11137y;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10829k {

    /* renamed from: YZ */
    private long f29662YZ;
    private volatile boolean akT;
    private String akU;
    private int akV;
    private boolean akW;
    @Nullable
    private KsLoadManager akX;
    private long akY;
    private volatile boolean akZ;
    private boolean ala;
    private boolean alb;
    private String alc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10837a {
        private static final C10829k alg = new C10829k((byte) 0);
    }

    /* synthetic */ C10829k(byte b) {
        this();
    }

    /* renamed from: at */
    private static boolean m24711at(Context context) {
        String processName = C11024aq.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    /* renamed from: b */
    public static void m24710b(String str, Map<String, String> map, String str2) {
        C9889d.m27430a(str, map, str2);
    }

    /* renamed from: bY */
    public static String m24709bY(String str) {
        return C9889d.m27429al(str);
    }

    /* renamed from: bZ */
    public static String m24708bZ(String str) {
        return C9889d.getResponseData(str);
    }

    /* renamed from: c */
    public static Object m24707c(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return Integer.valueOf((int) BleManager.f22896l);
            }
            boolean z = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return C10425a.m26107DU().m26101Y(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                C9815b.m27665g((JSONObject) objArr[0]);
                return Boolean.TRUE;
            } else if (!"enableDynamic".equals(str) || ServiceProvider.m24363KO() == null) {
                return null;
            } else {
                if (C11024aq.isInMainProcess(ServiceProvider.m24363KO()) && C9425a.adF.booleanValue()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    /* renamed from: d */
    public static void m24706d(@NonNull Map<String, String> map) {
        C9889d.m27428f(map);
    }

    public static void deleteCache() {
        C10291a.m26395Dc().delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m24705e(SdkConfigData sdkConfigData) {
        m24697zf();
        m24686zq();
        C10251d.m26497yn();
        if ((C10251d.m26527a(C10250c.aqT) && C11024aq.isInMainProcess(ServiceProvider.m24363KO())) || C9425a.f29473md.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.m24363KO());
        }
        if (C10251d.m26537Cr()) {
            C9778a.init(C10887l.m24567Ob());
        }
        m24681zv();
        C11034az.init(getContext());
        C8527a.m30415mr().m30416eF();
        C11082f.m23817a(getContext(), 30000L, new InterfaceC9802h() { // from class: com.kwad.sdk.k.5
            @Override // com.kwad.sdk.collector.InterfaceC9802h
            /* renamed from: c */
            public final void mo24669c(@NonNull JSONArray jSONArray) {
                C8766a.m29888qi().m29899c(jSONArray);
            }
        });
        C10425a.m26107DU().m26099a(C10251d.m26536Cs(), C10251d.m26535Ct());
        C10808a.m24772a(sdkConfigData.httpDnsInfo);
        C11061bk.m23869a(C10251d.m26534Cu(), C10251d.m26533Cv(), ServiceProvider.getContext());
        m24679zx();
        m24683zt();
        C8661a.m30050oE().m30054Y(getContext());
        C10694a.m25102cH(C10251d.m26522a(C10250c.asC));
        ImageLoaderPerfUtil.report();
        C10959d.m24367cH(C10251d.m26522a(C10250c.asI));
        C10512c.m25573cH(C10251d.m26522a(C10250c.asK));
        C10824b.m24720Jt();
        C10887l.m24549x(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new AbstractC10762b<JSONObject, Boolean>() { // from class: com.kwad.sdk.k.6
            /* renamed from: f */
            private static Boolean m24668f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return m24668f(jSONObject);
            }
        })).booleanValue());
        C10839a.m24659dC(C10251d.m26524a(C10250c.atb));
        try {
            C9295g.m29088sy().init();
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    public static String getAppId() {
        return ServiceProvider.m24362KP().appId;
    }

    public static JSONObject getAppInfo() {
        return C10474a.m25996EY();
    }

    public static String getAppName() {
        return ServiceProvider.m24362KP().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return C10475b.m25993Fa().toJson();
    }

    public static String getDid() {
        return C11029av.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return C10478d.m25985Fd().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.m24362KP();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.m24362KP().enableDebug;
    }

    /* renamed from: k */
    public static void m24704k(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) C10973b.m24288h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseCurrentPlayer() {
        C9861c.m27501f(InterfaceC7326a.class);
    }

    public static void resumeCurrentPlayer() {
        C9861c.m27501f(InterfaceC7326a.class);
    }

    public static void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        C9861c.m27501f(InterfaceC7326a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        C9861c.m27501f(InterfaceC7326a.class);
    }

    public static void setThemeMode(int i) {
        C9861c.m27501f(InterfaceC7326a.class);
    }

    /* renamed from: zd */
    public static C10829k m24699zd() {
        return C10837a.alg;
    }

    /* renamed from: ze */
    private void m24698ze() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f29662YZ = elapsedRealtime;
        C10973b.init();
        C10773i.m24878yj();
        m24689zn();
        m24688zo();
        C10848l.m24646Y(this.akY);
        m24696zg();
        m24685zr();
        m24684zs();
        m24678zy();
        m24692zk();
        m24691zl();
        m24695zh();
        m24694zi();
        m24693zj();
        m24687zp();
        m24680zw();
        m24682zu();
        C9679c.m28040zM().m28038zO();
        C10819a.report();
        C8766a.m29888qi().m29887qj();
        C10882k.m24574NZ();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        C10331c.m26254d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        C10331c.m26248i("KSAdSDK", "SDK_VERSION_NAME: 3.3.59.1 TK_VERSION_CODE: 5.1.7 BRIDGE_VERSION: 1.3");
        C10848l.m24645Z(elapsedRealtime2);
        m24715a(ServiceProvider.m24362KP());
        this.akT = true;
    }

    /* renamed from: zf */
    private void m24697zf() {
        try {
            C9815b.m27695a(new C9815b.InterfaceC9818a() { // from class: com.kwad.sdk.k.1
                @Override // com.kwad.sdk.commercial.C9815b.InterfaceC9818a
                /* renamed from: j */
                public final void mo24676j(String str, String str2, boolean z) {
                    C8766a.m29888qi().m29897e(str, str2, false);
                }

                @Override // com.kwad.sdk.commercial.C9815b.InterfaceC9818a
                /* renamed from: zA */
                public final boolean mo24675zA() {
                    return C10251d.m26519b(C10250c.aqV);
                }

                @Override // com.kwad.sdk.commercial.C9815b.InterfaceC9818a
                /* renamed from: zB */
                public final boolean mo24674zB() {
                    return C10251d.m26527a(C10250c.aqU);
                }

                @Override // com.kwad.sdk.commercial.C9815b.InterfaceC9818a
                /* renamed from: zC */
                public final JSONObject mo24673zC() {
                    return C10251d.m26526a(C10250c.arg);
                }

                @Override // com.kwad.sdk.commercial.C9815b.InterfaceC9818a
                /* renamed from: zD */
                public final String mo24672zD() {
                    return C10251d.m26522a(C10250c.atg);
                }
            }, this.akW);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: zg */
    private static void m24696zg() {
        try {
            C9860b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zh */
    private static void m24695zh() {
        try {
            C8571a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zi */
    private void m24694zi() {
        try {
            C9861c.init(getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zj */
    private void m24693zj() {
        try {
            C8735b.init(getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zk */
    private void m24692zk() {
        C11137y.m23601ag(ServiceProvider.getContext(), this.alc);
        this.alc = null;
    }

    /* renamed from: zl */
    private void m24691zl() {
        try {
            C8918g.m29607a(new C8918g.InterfaceC8922a() { // from class: com.kwad.sdk.k.4
                @Override // com.kwad.components.core.request.C8918g.InterfaceC8922a
                /* renamed from: d */
                public final void mo24671d(@NonNull SdkConfigData sdkConfigData) {
                    C10331c.m26248i("KSAdSDK", "onConfigRefresh()");
                    try {
                        C10829k.this.m24705e(sdkConfigData);
                    } catch (Throwable th) {
                        C8571a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.C8918g.InterfaceC8922a
                /* renamed from: qv */
                public final void mo24670qv() {
                    C10331c.m26248i("KSAdSDK", "onCacheLoaded()");
                    C10829k c10829k = C10829k.this;
                    C10829k.m24690zm();
                }
            });
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zm */
    public static void m24690zm() {
        try {
            Map<String, String> parseJSON2MapString = C11127u.parseJSON2MapString(C10250c.asL.getValue());
            for (String str : parseJSON2MapString.keySet()) {
                String str2 = parseJSON2MapString.get(str);
                str2.getClass();
                GlobalThreadPools.m25589r(str, Integer.parseInt(str2));
            }
            GlobalThreadPools.m25608FA();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: zn */
    private static void m24689zn() {
        try {
            C10331c.init(ServiceProvider.m24362KP().enableDebug);
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zo */
    private static void m24688zo() {
        try {
            C10873e.m24602NV().init();
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zp */
    private static void m24687zp() {
        try {
            C10232b.m26625DD().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zq */
    private void m24686zq() {
        try {
            C10606a.m25320GV().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: zr */
    private void m24685zr() {
        try {
            C10425a.m26107DU().init(getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zs */
    private static void m24684zs() {
        try {
            C10296a.m26376aV(ServiceProvider.getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zt */
    private void m24683zt() {
        try {
            C10278a.m26449aU(getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zu */
    private static void m24682zu() {
        try {
            C8950m.m29533re().init();
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zv */
    private static void m24681zv() {
        C8770b.m29881qA();
        C8770b.m29882f(C10251d.m26584BJ(), C10251d.m26583BK());
    }

    /* renamed from: zw */
    private void m24680zw() {
        try {
            C11029av.init(getContext());
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zx */
    private static void m24679zx() {
        try {
            C9768b.m27830Ao().checkInit();
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    /* renamed from: zy */
    private void m24678zy() {
        try {
            C9645i.m28111a(new C9645i.InterfaceC9651a() { // from class: com.kwad.sdk.k.7
                @Override // com.kwad.library.solder.lib.C9645i.InterfaceC9651a
                /* renamed from: b */
                public final void mo24667b(String str, File file) {
                    C10296a.m26378a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.C9645i.InterfaceC9651a
                /* renamed from: d */
                public final void mo24666d(String str, Throwable th) {
                    if (th instanceof Exception) {
                        C10425a.m26107DU().m26084g(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.C9645i.InterfaceC9651a
                public final int getCorePoolSize() {
                    return C10251d.m26581BM();
                }

                @Override // com.kwad.library.solder.lib.C9645i.InterfaceC9651a
                public final int getMaxRetryCount() {
                    return C10251d.m26524a(C10250c.asb);
                }

                @Override // com.kwad.library.solder.lib.C9645i.InterfaceC9651a
                /* renamed from: xh */
                public final boolean mo24665xh() {
                    return C10251d.m26527a(C10250c.asa);
                }
            });
        } catch (Throwable th) {
            C10858m.m24618l(th);
        }
    }

    @NonNull
    public final KsLoadManager getAdManager() {
        if (this.akX == null) {
            this.akX = new C8531b();
        }
        return this.akX;
    }

    public final String getApiVersion() {
        return this.akU;
    }

    public final int getApiVersionCode() {
        return this.akV;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } catch (Throwable th) {
                Log.e("KSAdSDK", "init error", th);
                String stackTraceString = Log.getStackTraceString(th);
                C10858m.m24624a(th, stackTraceString);
                m24714a(sdkConfig, new C10752e(10002, stackTraceString));
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.akT);
                if (this.akT) {
                    ServiceProvider.m24361b(sdkConfig);
                    return;
                }
                ServiceProvider.m24361b(sdkConfig);
                ServiceProvider.m24359bC(context);
                if (m24711at(context)) {
                    Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                    ServiceProvider.m24364KN();
                    C10773i.m24878yj();
                    m24689zn();
                    this.akT = true;
                } else {
                    C10858m.m24617zG();
                    m24698ze();
                }
                return;
            }
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        m24714a(sdkConfig, C10752e.akD);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class m24289g = C10973b.m24289g(cls);
            if (m24289g == null) {
                if (obj instanceof BaseProxyActivity) {
                    m24289g = C8880a.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    m24289g = C8885b.class;
                }
                C8571a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + m24703yp() + "--mIsSdkInit:" + m24700ys() + "--componentClass" + cls));
            }
            return (T) m24289g.newInstance();
        } catch (Exception e) {
            C8571a.reportSdkCaughtException(e);
            C10331c.printStackTrace(e);
            return null;
        }
    }

    public final void setAdxEnable(boolean z) {
        this.alb = z;
    }

    public final void setApiVersion(String str) {
        this.akU = str;
    }

    public final void setApiVersionCode(int i) {
        this.akV = i;
    }

    public final void setAppTag(String str) {
        if (this.akT) {
            C11137y.m23601ag(ServiceProvider.getContext(), this.alc);
        } else {
            this.alc = str;
        }
    }

    public final void setIsExternal(boolean z) {
        this.akW = z;
    }

    public final void setLaunchTime(long j) {
        this.akY = j;
    }

    public final void setPersonalRecommend(boolean z) {
        this.akZ = z;
    }

    public final void setProgrammaticRecommend(boolean z) {
        this.ala = z;
    }

    public final void unInit() {
        C10303b.m26364De().m26353aX(getContext());
    }

    /* renamed from: yp */
    public final boolean m24703yp() {
        return this.akW;
    }

    /* renamed from: yq */
    public final boolean m24702yq() {
        return this.akZ;
    }

    /* renamed from: yr */
    public final boolean m24701yr() {
        return this.ala;
    }

    /* renamed from: ys */
    public final boolean m24700ys() {
        return this.akT;
    }

    /* renamed from: zz */
    public final long m24677zz() {
        return this.f29662YZ;
    }

    private C10829k() {
        this.akT = false;
        this.akU = "";
        this.akZ = true;
        this.ala = true;
        this.alb = false;
    }

    /* renamed from: a */
    private static void m24714a(SdkConfig sdkConfig, final C10752e c10752e) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.k.2
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            KsInitCallback ksInitCallback2 = KsInitCallback.this;
                            C10752e c10752e2 = c10752e;
                            ksInitCallback2.onFail(c10752e2.code, c10752e2.msg);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m24715a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    C11064bn.m23860b(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.k.3
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            KsInitCallback.this.onSuccess();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }
}
