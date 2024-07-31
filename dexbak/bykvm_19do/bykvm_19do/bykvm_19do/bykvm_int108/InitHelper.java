package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTAdapterConfigurationManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTSdkInitializationListener;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTAdNetDepend;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTNetClient;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AdvertisingIdHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTApmTagUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTMediationCrashHandler;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class InitHelper {

    /* renamed from: a */
    private static volatile TTAdapterConfigurationManager f627a;

    /* renamed from: b */
    private static long f628b;

    /* renamed from: c */
    private static boolean f629c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InitHelper.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class RunnableC0979a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f630a;

        /* renamed from: b */
        final /* synthetic */ TTSdkInitializationListener f631b;

        /* compiled from: InitHelper.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class C0980a implements TTSdkInitializationListener {
            C0980a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTSdkInitializationListener
            /* renamed from: a */
            public void mo59268a() {
                TTSdkInitializationListener tTSdkInitializationListener = RunnableC0979a.this.f631b;
                if (tTSdkInitializationListener != null) {
                    tTSdkInitializationListener.mo59268a();
                }
            }
        }

        RunnableC0979a(Context context, TTSdkInitializationListener tTSdkInitializationListener) {
            this.f630a = context;
            this.f631b = tTSdkInitializationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            ThirdSdkInit.initTTPangleSDK(this.f630a);
            InitHelper.m59276b();
            Set<String> m59938a = SdkGlobalInfo.m59939B().m59938a();
            Set<String> classNamesSet = DefaultAdapterClasses.getClassNamesSet();
            classNamesSet.addAll(m59938a);
            Map<String, Map<String, String>> m59905h = SdkGlobalInfo.m59939B().m59905h();
            InitHelper.m59274b(m59905h);
            AdNetworkConfValue m59763a = InternalContainer.m59943f().m59763a("klevin");
            if (m59763a != null) {
                ThirdSdkInit.initTTKlevinSDK(this.f630a, m59763a.m59573a());
            }
            AdNetworkConfValue m59763a2 = InternalContainer.m59943f().m59763a("mintegral");
            if (m59763a2 != null) {
                ThirdSdkInit.initTTMintergralSDK(this.f630a, m59763a2.m59573a(), m59763a2.m59572b());
            }
            Map<String, Map<String, String>> m59895r = SdkGlobalInfo.m59939B().m59895r();
            if (this.f631b != null) {
                InitHelper.f627a.m59640a(this.f630a, classNamesSet, m59905h, m59895r, new C0980a());
            } else {
                InitHelper.f627a.m59640a(this.f630a, classNamesSet, m59905h, m59895r, null);
            }
        }
    }

    /* renamed from: b */
    public static void m59276b() {
        if (f627a == null) {
            synchronized (InitHelper.class) {
                if (f627a == null) {
                    f627a = new TTAdapterConfigurationManager();
                }
            }
        }
    }

    /* renamed from: c */
    public static Map<String, ITTAdapterConfiguration> m59273c() {
        m59276b();
        return f627a.m59642a();
    }

    /* renamed from: d */
    public static long m59272d() {
        return f628b;
    }

    /* renamed from: e */
    private static void m59271e() {
        try {
            InternalContainer.m59943f().mo59767a();
        } catch (Throwable th) {
            Logger.m37557e("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
        SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59792a();
    }

    /* renamed from: f */
    private static void m59270f() {
        Context m59945d = InternalContainer.m59945d();
        if (m59945d == null) {
            return;
        }
        try {
            TTNetClient.m59292b().m59293a().m59083a(m59945d, false, true, new TTAdNetDepend(m59945d));
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    public static boolean m59269g() {
        return f629c;
    }

    /* renamed from: a */
    public static void m59281a(Activity activity) {
        ThirdSdkInit.initUnitySDK(activity);
    }

    /* renamed from: a */
    public static String m59277a(Map<String, Object> map, String str) {
        m59276b();
        return f627a.m59641a(InternalContainer.m59945d(), map, str);
    }

    /* renamed from: a */
    public static void m59280a(Context context) {
        f629c = true;
        f628b = SystemClock.elapsedRealtime();
        TTApmTagUtils.m59113a(context);
        m59275b(context);
        IdUtils.m59182m(context);
        m59270f();
        m59271e();
        TTMediationCrashHandler.m59107c();
        AdvertisingIdHelper.m59229c().m59231b();
        InternalContainer.m59950a().m59439a();
        InternalContainer.m59946c().m59439a();
        IntervalShowControl.m59587b().m59594a();
    }

    /* renamed from: b */
    public static void m59275b(Context context) {
        if (context != null) {
            InternalContainer.m59947b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m59274b(Map<String, Map<String, String>> map) {
        AdNetworkConfValue m59763a;
        String m59573a;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        String m59573a2;
        Class<?> cls4;
        String m59573a3;
        Class<?> cls5;
        String m59573a4;
        Class<?> cls6;
        AdNetworkConfValue m59763a2 = InternalContainer.m59943f().m59763a("pangle");
        String m59573a5 = m59763a2 != null ? m59763a2.m59573a() : null;
        if (TextUtils.isEmpty(m59573a5)) {
            m59573a5 = SdkGlobalInfo.m59939B().m59921c();
        }
        Class<?> cls7 = DefaultAdapterClasses.getClass("pangle");
        if (cls7 != null && !TextUtils.isEmpty(m59573a5)) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", m59573a5);
            map.put(cls7.getName(), hashMap);
        }
        AdNetworkConfValue m59763a3 = InternalContainer.m59943f().m59763a("baidu");
        if (m59763a3 != null && (m59573a4 = m59763a3.m59573a()) != null && (cls6 = DefaultAdapterClasses.getClass("baidu")) != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("app_id", m59573a4);
            hashMap2.put(TTBaseAdapterConfiguration.BAIDU_IS_READ_DEVICE_ID, SdkGlobalInfo.m59939B().m59917d() ? "true" : "false");
            map.put(cls6.getName(), hashMap2);
        }
        AdNetworkConfValue m59763a4 = InternalContainer.m59943f().m59763a("admob");
        if (m59763a4 != null && (m59573a3 = m59763a4.m59573a()) != null && (cls5 = DefaultAdapterClasses.getClass("admob")) != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("app_id", m59573a3);
            map.put(cls5.getName(), hashMap3);
        }
        AdNetworkConfValue m59763a5 = InternalContainer.m59943f().m59763a("gdt");
        if (m59763a5 != null && (m59573a2 = m59763a5.m59573a()) != null && (cls4 = DefaultAdapterClasses.getClass("gdt")) != null) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("app_id", m59573a2);
            map.put(cls4.getName(), hashMap4);
        }
        AdNetworkConfValue m59763a6 = InternalContainer.m59943f().m59763a("sigmob");
        if (m59763a6 != null) {
            String m59573a6 = m59763a6.m59573a();
            String m59572b = m59763a6.m59572b();
            if (m59573a6 != null && m59572b != null && (cls3 = DefaultAdapterClasses.getClass("sigmob")) != null) {
                HashMap hashMap5 = new HashMap();
                hashMap5.put("app_id", m59573a6);
                hashMap5.put("app_key", m59572b);
                map.put(cls3.getName(), hashMap5);
            }
        }
        AdNetworkConfValue m59763a7 = InternalContainer.m59943f().m59763a("klevin");
        if (m59763a7 != null) {
            String m59573a7 = m59763a7.m59573a();
            if (!TextUtils.isEmpty(m59573a7) && (cls2 = DefaultAdapterClasses.getClass("klevin")) != null) {
                HashMap hashMap6 = new HashMap();
                hashMap6.put("app_id", m59573a7);
                map.put(cls2.getName(), hashMap6);
            }
        }
        AdNetworkConfValue m59763a8 = InternalContainer.m59943f().m59763a("ks");
        if (m59763a8 != null && (m59573a = m59763a8.m59573a()) != null && (cls = DefaultAdapterClasses.getClass("ks")) != null) {
            HashMap hashMap7 = new HashMap();
            hashMap7.put("app_id", m59573a);
            hashMap7.put("app_name", SdkGlobalInfo.m59939B().m59907g());
            map.put(cls.getName(), hashMap7);
        }
        Class<?> cls8 = DefaultAdapterClasses.getClass("mintegral");
        if (cls8 == null || (m59763a = InternalContainer.m59943f().m59763a("mintegral")) == null) {
            return;
        }
        String m59573a8 = m59763a.m59573a();
        String m59572b2 = m59763a.m59572b();
        HashMap hashMap8 = new HashMap();
        hashMap8.put("app_id", m59573a8);
        hashMap8.put("app_key", m59572b2);
        map.put(cls8.getName(), hashMap8);
    }

    /* renamed from: a */
    public static void m59279a(Context context, TTSdkInitializationListener tTSdkInitializationListener) {
        ThreadHelper.runOnUiThread(new RunnableC0979a(context, tTSdkInitializationListener));
    }
}
