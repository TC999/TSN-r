package com.kwad.components.core.p288d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.C10858m;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10472t;
import com.kwad.sdk.crash.C10656b;
import com.kwad.sdk.crash.C10668c;
import com.kwad.sdk.crash.C10670d;
import com.kwad.sdk.crash.InterfaceC10673f;
import com.kwad.sdk.crash.InterfaceC10677h;
import com.kwad.sdk.crash.model.C10691b;
import com.kwad.sdk.crash.model.message.C10693a;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.C10720h;
import com.kwad.sdk.crash.utils.C10745g;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11102k;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8571a {

    /* renamed from: JA */
    private static boolean f28128JA;

    /* renamed from: JC */
    private static List<Throwable> f28130JC;

    /* renamed from: JD */
    private static Map<String, String> f28131JD;

    /* renamed from: JB */
    private static final AtomicBoolean f28129JB = new AtomicBoolean(false);

    /* renamed from: JE */
    private static final List<InterfaceC8577b> f28132JE = new CopyOnWriteArrayList();

    /* renamed from: JF */
    private static final List<InterfaceC8578c> f28133JF = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8576a {
        /* renamed from: W */
        public static String m30324W(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    /* renamed from: com.kwad.components.core.d.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8577b {
        String getKey();

        JSONObject getValue();
    }

    /* renamed from: com.kwad.components.core.d.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8578c {
        void onCrashOccur(int i, String str);
    }

    /* renamed from: a */
    public static void m30344a(InterfaceC8577b interfaceC8577b) {
        f28132JE.add(interfaceC8577b);
    }

    /* renamed from: aa */
    private static C10691b m30342aa(String str) {
        if (TextUtils.isEmpty(str)) {
            return new C10691b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C10691b c10691b = new C10691b();
            c10691b.parseJson(jSONObject);
            return c10691b;
        } catch (Exception e) {
            C10331c.m26245w("KsAdExceptionCollectorHelper", e);
            return new C10691b();
        }
    }

    /* renamed from: ab */
    private static String m30341ab(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* renamed from: b */
    private static void m30340b(Throwable th) {
        if (f28130JC == null) {
            f28130JC = new CopyOnWriteArrayList();
        }
        f28130JC.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (C8571a.class) {
            if (context != null) {
                if (!f28129JB.get() && !f28128JA) {
                    f28128JA = true;
                    C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            if (C10251d.m26519b(C10250c.aqw)) {
                                C10331c.m26254d("KsAdExceptionCollectorHelper", "init");
                                C10656b.m25214a(C8571a.m30331mV());
                                C8571a.f28129JB.set(true);
                                C8571a.m30336mQ();
                                C8571a.m30335mR();
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: j */
    public static void m30339j(String str, String str2) {
        if (!f28129JB.get()) {
            m30338k(str, str2);
        } else {
            C10720h.m25030ah(str, str2);
        }
    }

    /* renamed from: k */
    private static void m30338k(String str, String str2) {
        if (f28131JD == null) {
            f28131JD = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f28131JD.put(str, str2);
    }

    /* renamed from: mP */
    private static boolean m30337mP() {
        return C10251d.m26519b(C10250c.aqx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mQ */
    public static void m30336mQ() {
        if (f28130JC == null || !m30337mP()) {
            return;
        }
        for (Throwable th : f28130JC) {
            C10656b.m25209n(th);
        }
        f28130JC.clear();
        f28130JC = null;
        ServiceProvider.m24358d(new InterfaceC10761a<Throwable>() { // from class: com.kwad.components.core.d.a.2
            /* renamed from: c */
            private static void m30325c(Throwable th2) {
                C10656b.m25209n(th2);
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(Throwable th2) {
                m30325c(th2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mR */
    public static void m30335mR() {
        Map<String, String> map = f28131JD;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                C10720h.m25030ah(entry.getKey(), entry.getValue());
            }
        }
        f28131JD.clear();
    }

    @NonNull
    /* renamed from: mS */
    private static C10668c m30334mS() {
        String m26522a = C10251d.m26522a(C10250c.arO);
        C10331c.m26254d("KsAdExceptionCollectorHelper", "configStr:" + m26522a);
        C10691b m30342aa = m30342aa(m26522a);
        String str = m30342aa.aGj;
        String str2 = m30342aa.aGk;
        boolean m24991a = C10745g.m24991a(m30342aa);
        boolean m24974b = C10745g.m24974b(m30342aa);
        final Context context = ServiceProvider.getContext();
        String m30324W = C8576a.m30324W(context);
        C10668c.C10669a m25175eZ = new C10668c.C10669a().m25187bv(context).m25186bx(m24991a).m25185by(m24974b).m25184bz(C10829k.m24699zd().m24703yp()).m25173fa(str).m25175eZ(str2);
        C10829k.m24699zd();
        C10668c.C10669a m25166fh = m25175eZ.m25166fh(ExceptionMessage.getSdkCrashVersionName(C10829k.getSDKVersion(), 1));
        C10829k.m24699zd();
        return m25166fh.m25179dy(BuildConfig.VERSION_CODE).m25165fi(ExceptionMessage.getSdkCrashVersionName(C10829k.m24699zd().getApiVersion(), 1)).m25178dz(C10829k.m24699zd().getApiVersionCode()).m25180dA(1).m25167fg("com.kwad.sdk").m25164fj(context.getPackageName()).m25163fk(ServiceProvider.m24362KP().appId).m25162fl(ServiceProvider.m24362KP().appName).m25161fm(C11102k.m23780bQ(context)).m25160fn(m30342aa.aGg).m25170fd(C11029av.getDeviceId()).m25169fe(ServiceProvider.m24362KP().appId).m25171fc(m30342aa.version).m25159fo(m30342aa.aGi).m25158fp(m30342aa.aGh).m25172fb("Android").m25168ff(m30324W).m25189a(new InterfaceC10677h() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.InterfaceC10677h
            /* renamed from: nb */
            public final C10693a mo25114nb() {
                C10693a c10693a = new C10693a();
                c10693a.m25104fq(C10472t.m26005ET());
                c10693a.putString("mKsadAppId", ServiceProvider.m24362KP().appId);
                c10693a.putString("mKsadAppName", ServiceProvider.m24362KP().appName);
                c10693a.putString("mKsadAppPackageName", context.getPackageName());
                c10693a.putString("mKsadAppVersion", C11102k.m23780bQ(context));
                c10693a.putString("mKsadSdkName", "com.kwad.sdk");
                C10829k.m24699zd();
                c10693a.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(C10829k.getSDKVersion(), 1));
                C10829k.m24699zd();
                c10693a.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                c10693a.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(C10829k.m24699zd().getApiVersion(), 1));
                c10693a.putInt("mKsadSdKApiVersionCode", C10829k.m24699zd().getApiVersionCode());
                c10693a.putInt("mKsadSdkType", 1);
                c10693a.putInt("mBuildNumber", 616);
                for (InterfaceC8577b interfaceC8577b : C8571a.f28132JE) {
                    String key = interfaceC8577b.getKey();
                    JSONObject value = interfaceC8577b.getValue();
                    if (key != null && value != null) {
                        c10693a.m25105a(interfaceC8577b.getKey(), interfaceC8577b.getValue());
                    }
                }
                return c10693a;
            }
        }).m25190a(new InterfaceC10673f() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.crash.InterfaceC10673f
            /* renamed from: a */
            public final void mo25125a(int i, ExceptionMessage exceptionMessage) {
                C10858m.m24623au(context);
                if (i == 1 || i == 3 || i == 4) {
                    C10331c.m26254d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                for (InterfaceC8578c interfaceC8578c : C8571a.f28133JF) {
                    interfaceC8578c.onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).m25181d(m30333mT()).m25176e(m30332mU()).m25193E(C10251d.m26589BE()).m25151m(C10251d.m26525a(C10250c.asM)).m25192Ht();
    }

    /* renamed from: mT */
    private static String[] m30333mT() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(m30341ab(KsAdSDKImpl.class.getName()));
            arrayList.add(m30341ab(DownloadTask.class.getName()));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(m30341ab(CpuMemoryProfiler.class.getName()));
            arrayList.add(m30341ab(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: mU */
    private static String[] m30332mU() {
        String[] strArr = new String[1];
        try {
            String name = C10670d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        return strArr;
    }

    /* renamed from: mV */
    static /* synthetic */ C10668c m30331mV() {
        return m30334mS();
    }

    public static void reportSdkCaughtException(Throwable th) {
        C10331c.printStackTrace(th);
        if (!f28129JB.get()) {
            m30340b(th);
        } else if (m30337mP()) {
            C10656b.m25209n(th);
        }
    }

    /* renamed from: a */
    public static void m30343a(InterfaceC8578c interfaceC8578c) {
        f28133JF.add(interfaceC8578c);
    }
}
