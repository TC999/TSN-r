package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.k;
import com.kwad.sdk.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static boolean JA;
    private static List<Throwable> JC;
    private static Map<String, String> JD;
    private static final AtomicBoolean JB = new AtomicBoolean(false);
    private static final List<b> JE = new CopyOnWriteArrayList();
    private static final List<c> JF = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0626a {
        public static String W(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i4 >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        String getKey();

        JSONObject getValue();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void onCrashOccur(int i4, String str);
    }

    public static void a(b bVar) {
        JE.add(bVar);
    }

    private static com.kwad.sdk.crash.model.b aa(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.w("KsAdExceptionCollectorHelper", e4);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    private static String ab(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static void b(Throwable th) {
        if (JC == null) {
            JC = new CopyOnWriteArrayList();
        }
        JC.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!JB.get() && !JA) {
                    JA = true;
                    g.execute(new ay() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            if (d.b(com.kwad.sdk.core.config.c.aqw)) {
                                com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "init");
                                com.kwad.sdk.crash.b.a(a.mV());
                                a.JB.set(true);
                                a.mQ();
                                a.mR();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void j(String str, String str2) {
        if (!JB.get()) {
            k(str, str2);
        } else {
            h.ah(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (JD == null) {
            JD = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JD.put(str, str2);
    }

    private static boolean mP() {
        return d.b(com.kwad.sdk.core.config.c.aqx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mQ() {
        if (JC == null || !mP()) {
            return;
        }
        for (Throwable th : JC) {
            com.kwad.sdk.crash.b.n(th);
        }
        JC.clear();
        JC = null;
        ServiceProvider.d(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.2
            private static void c(Throwable th2) {
                com.kwad.sdk.crash.b.n(th2);
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th2) {
                c(th2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mR() {
        Map<String, String> map = JD;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                h.ah(entry.getKey(), entry.getValue());
            }
        }
        JD.clear();
    }

    @NonNull
    private static com.kwad.sdk.crash.c mS() {
        String a4 = d.a(com.kwad.sdk.core.config.c.arO);
        com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "configStr:" + a4);
        com.kwad.sdk.crash.model.b aa = aa(a4);
        String str = aa.aGj;
        String str2 = aa.aGk;
        boolean a5 = com.kwad.sdk.crash.utils.g.a(aa);
        boolean b4 = com.kwad.sdk.crash.utils.g.b(aa);
        final Context context = ServiceProvider.getContext();
        String W = C0626a.W(context);
        c.a eZ = new c.a().bv(context).bx(a5).by(b4).bz(k.zd().yp()).fa(str).eZ(str2);
        k.zd();
        c.a fh = eZ.fh(ExceptionMessage.getSdkCrashVersionName(k.getSDKVersion(), 1));
        k.zd();
        return fh.dy(BuildConfig.VERSION_CODE).fi(ExceptionMessage.getSdkCrashVersionName(k.zd().getApiVersion(), 1)).dz(k.zd().getApiVersionCode()).dA(1).fg("com.kwad.sdk").fj(context.getPackageName()).fk(ServiceProvider.KP().appId).fl(ServiceProvider.KP().appName).fm(com.kwad.sdk.utils.k.bQ(context)).fn(aa.aGg).fd(av.getDeviceId()).fe(ServiceProvider.KP().appId).fc(aa.version).fo(aa.aGi).fp(aa.aGh).fb("Android").ff(W).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a nb() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fq(t.ET());
                aVar.putString("mKsadAppId", ServiceProvider.KP().appId);
                aVar.putString("mKsadAppName", ServiceProvider.KP().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", com.kwad.sdk.utils.k.bQ(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                k.zd();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(k.getSDKVersion(), 1));
                k.zd();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(k.zd().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", k.zd().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH);
                for (b bVar : a.JE) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i4, ExceptionMessage exceptionMessage) {
                m.au(context);
                if (i4 == 1 || i4 == 3 || i4 == 4) {
                    com.kwad.sdk.core.e.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i4);
                }
                for (c cVar : a.JF) {
                    cVar.onCrashOccur(i4, exceptionMessage.mCrashDetail);
                }
            }
        }).d(mT()).e(mU()).E(d.BE()).m(d.a(com.kwad.sdk.core.config.c.asM)).Ht();
    }

    private static String[] mT() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ab(KsAdSDKImpl.class.getName()));
            arrayList.add(ab(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(ab(CpuMemoryProfiler.class.getName()));
            arrayList.add(ab(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] mU() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    static /* synthetic */ com.kwad.sdk.crash.c mV() {
        return mS();
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTrace(th);
        if (!JB.get()) {
            b(th);
        } else if (mP()) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    public static void a(c cVar) {
        JF.add(cVar);
    }
}
