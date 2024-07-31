package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.C9785b;
import com.kwad.sdk.collector.C9791c;
import com.kwad.sdk.collector.C9803i;
import com.kwad.sdk.collector.C9804j;
import com.kwad.sdk.collector.InterfaceC9802h;
import com.kwad.sdk.collector.model.C9809c;
import com.kwad.sdk.collector.model.InterfaceC9808b;
import com.kwad.sdk.collector.p371b.C9787a;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.threads.C10512c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.utils.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11082f {

    /* renamed from: Ym */
    private static Handler f29680Ym;
    private static Messenger aOi;
    private static volatile ExecutorService aOj;
    private static volatile AppStatusRules aOk;
    private static WeakReference<Context> aOl;
    private static InterfaceC9802h aOm;
    private static ServiceConnection axa = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (C11082f.access$000()) {
                    obtain.replyTo = C11082f.aOi;
                    try {
                        messenger.send(obtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                C10331c.m26246w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e) {
                C10331c.printStackTraceOnly(e);
                C10974c.gatherException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.f$2 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C110842 extends AbstractRunnableC11033ay {

        /* renamed from: gq */
        final /* synthetic */ Context f29681gq;

        C110842(Context context) {
            this.f29681gq = context;
        }

        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
        public final void doTask() {
            C9791c.m27770a(this.f29681gq, new C9791c.InterfaceC9795a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.C9791c.InterfaceC9795a
                /* renamed from: b */
                public final void mo23803b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(C110842.this.f29681gq);
                    AppStatusRules unused = C11082f.aOk = appStatusRules;
                    C11082f.m23814b(C110842.this.f29681gq, C11082f.aOk);
                    C11082f.m23813bH(C110842.this.f29681gq);
                    boolean m23877di = C11059bi.m23877di(C110842.this.f29681gq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(C11082f.aOk);
                    C10331c.m26254d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + m23877di);
                    if (m23877di && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = C11082f.aOk.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            C11082f.m23806c(C110842.this.f29681gq, obtainDefaultScanInterval);
                        } else {
                            C11082f.m23811bJ(C110842.this.f29681gq);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(C11082f.aOk);
                    boolean z = C11082f.aOk.obtainUploadConfigFileMaxSize() > 0;
                    C10331c.m26254d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && m23877di) {
                        C11082f.m23826KT();
                        C11082f.aOj.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    C9804j.m27744a(C110842.this.f29681gq, C11082f.aOk);
                                } catch (Throwable th) {
                                    C10974c.gatherException(th);
                                    C10331c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.C9791c.InterfaceC9795a
                /* renamed from: p */
                public final void mo23802p(int i, String str) {
                    C10331c.m26250e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.utils.f$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11090b {
        /* renamed from: u */
        void mo23792u(List<InterfaceC9808b> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.f$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class HandlerC11091c extends Handler {
        public HandlerC11091c(@NonNull Looper looper) {
            super(looper);
        }

        /* renamed from: N */
        private static void m23798N(List<C11089a> list) {
            if (list == null) {
                return;
            }
            C11082f.aOm.mo24669c(C11126t.m23681O(list));
        }

        /* renamed from: b */
        private static void m23797b(ArrayList<InterfaceC9808b> arrayList) {
            JSONArray m23801L;
            if (arrayList == null || (m23801L = C11089a.m23801L(arrayList)) == null) {
                return;
            }
            C11082f.aOm.mo24669c(m23801L);
        }

        /* renamed from: c */
        private void m23796c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = C11126t.m23680a(data.getString("resultJson"), new InterfaceC10229c<C11089a>() { // from class: com.kwad.sdk.utils.f.c.1
                            /* renamed from: Lc */
                            private static C11089a m23795Lc() {
                                return new C11089a();
                            }

                            @Override // com.kwad.sdk.core.InterfaceC10229c
                            /* renamed from: AW */
                            public final /* synthetic */ C11089a mo23794AW() {
                                return m23795Lc();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    C10331c.m26254d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    m23797b(arrayList);
                }
                if (list != null) {
                    m23798N(list);
                }
            }
            if (C11082f.aOl != null && C11082f.aOl.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = C11126t.m23680a(string, new InterfaceC10229c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            /* renamed from: Ld */
                            private static AppStatusRules.Strategy m23793Ld() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.InterfaceC10229c
                            /* renamed from: AW */
                            public final /* synthetic */ AppStatusRules.Strategy mo23794AW() {
                                return m23793Ld();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            C9803i.m27748a((Context) C11082f.aOl.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (C11082f.aOl == null || C11082f.axa == null) {
                return;
            }
            C10331c.m26254d("AppStatusHelper", "unbindASService");
            C9787a.m27773b((Context) C11082f.aOl.get(), C11082f.axa);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                m23796c(message);
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.f$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11094d implements InterfaceC11090b {
        private InterfaceC11090b aOu = null;

        public C11094d(InterfaceC11090b interfaceC11090b) {
        }

        @Override // com.kwad.sdk.utils.C11082f.InterfaceC11090b
        /* renamed from: u */
        public final void mo23792u(List<InterfaceC9808b> list) {
            JSONArray m23801L = C11089a.m23801L(list);
            if (m23801L != null) {
                C11082f.aOm.mo24669c(m23801L);
            }
            InterfaceC11090b interfaceC11090b = this.aOu;
            if (interfaceC11090b != null) {
                interfaceC11090b.mo23792u(list);
            }
        }
    }

    /* renamed from: K */
    private static List<InterfaceC9808b> m23829K(List<InterfaceC9808b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    /* renamed from: KR */
    public static AppStatusRules m23828KR() {
        return aOk;
    }

    /* renamed from: KS */
    private static boolean m23827KS() {
        if (aOi == null) {
            try {
                aOi = new Messenger(new HandlerC11091c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return aOi != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: KT */
    public static void m23826KT() {
        if (aOj == null) {
            synchronized (C11082f.class) {
                if (aOj == null) {
                    ExecutorService m25599FJ = GlobalThreadPools.m25599FJ();
                    aOj = m25599FJ;
                    C10512c.m25576a((ThreadPoolExecutor) m25599FJ, "appStatusHelper");
                }
            }
        }
    }

    /* renamed from: KU */
    private static boolean m23825KU() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e) {
            C10331c.printStackTraceOnly(e);
            return false;
        }
    }

    /* renamed from: a */
    public static void m23817a(Context context, long j, InterfaceC9802h interfaceC9802h) {
        if (C11028au.m24065Mr() || C10251d.m26528X(8192L) || context == null || C11077c.m23839bF(context)) {
            return;
        }
        aOm = interfaceC9802h;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        C10331c.m26254d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            aOl = new WeakReference<>(context);
            if (f29680Ym == null) {
                f29680Ym = new Handler(Looper.getMainLooper());
            }
            f29680Ym.postDelayed(new C110842(context), 30000L);
        }
    }

    static /* synthetic */ boolean access$000() {
        return m23827KS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: b */
    public static void m23814b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        C10747h.m24939k(file.getAbsolutePath(), C9886c.m27439dH(jSONObject), false);
    }

    @WorkerThread
    /* renamed from: bH */
    public static void m23813bH(Context context) {
        if (aOk == null) {
            aOk = m23812bI(context);
        }
    }

    @Nullable
    @WorkerThread
    /* renamed from: bI */
    private static AppStatusRules m23812bI(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (file.exists()) {
            try {
                String m24957I = C10747h.m24957I(file);
                if (TextUtils.isEmpty(m24957I)) {
                    return null;
                }
                if (C9886c.m27437dJ(m24957I)) {
                    m24957I = C9886c.m27438dI(m24957I);
                }
                JSONObject jSONObject = new JSONObject(m24957I);
                AppStatusRules appStatusRules = new AppStatusRules();
                appStatusRules.parseJson(jSONObject);
                return appStatusRules;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bJ */
    public static void m23811bJ(Context context) {
        if (context == null) {
            return;
        }
        boolean m23825KU = m23825KU();
        C10331c.m26254d("AppStatusHelper", "isServiceAvailable: " + m23825KU);
        if (m23825KU) {
            C9787a.m27778a(context, axa);
        } else {
            m23816a(context, new C11094d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: bK */
    public static List<InterfaceC9808b> m23810bK(Context context) {
        if (!C11059bi.m23877di(context)) {
            return new ArrayList();
        }
        if (aOk == null) {
            aOk = m23812bI(context);
        }
        return m23809bL(context);
    }

    @RequiresPermission(C7282g.f24952j)
    /* renamed from: bL */
    private static List<InterfaceC9808b> m23809bL(Context context) {
        ArrayList arrayList = new ArrayList();
        if (C11028au.m24065Mr() || C10251d.m26528X(8192L) || C11077c.m23839bF(context)) {
            return arrayList;
        }
        AppStatusRules m23828KR = m23828KR();
        for (AppStatusRules.Strategy strategy : C9803i.m27746c(m23828KR)) {
            arrayList.addAll(m23815a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy m27745d = C9803i.m27745d(m23828KR);
        arrayList.addAll(m23815a(m27745d));
        m27745d.setNeedSaveLaunchTime(System.currentTimeMillis());
        return m23829K(arrayList);
    }

    /* renamed from: c */
    public static void m23806c(final Context context, final long j) {
        if (f29680Ym == null) {
            f29680Ym = new Handler(Looper.getMainLooper());
        }
        f29680Ym.post(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.f.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11082f.m23811bJ(context);
                C11082f.f29680Ym.postDelayed(this, j);
            }
        });
    }

    /* renamed from: com.kwad.sdk.utils.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11089a implements InterfaceC9914b {
        private List<Long> aOs = new ArrayList();
        private String appName;
        private String packageName;

        private C11089a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        /* renamed from: L */
        public static JSONArray m23801L(List<InterfaceC9808b> list) {
            List<C11089a> list2;
            try {
                list2 = m23800M(list);
            } catch (Exception e) {
                C10974c.gatherException(e);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (C11089a c11089a : list2) {
                jSONArray.put(c11089a.toJson());
            }
            return jSONArray;
        }

        @Nullable
        /* renamed from: M */
        private static List<C11089a> m23800M(List<InterfaceC9808b> list) {
            C11089a c11089a;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (InterfaceC9808b interfaceC9808b : list) {
                        String m27729b = C9809c.m27729b(interfaceC9808b);
                        if (hashMap.containsKey(m27729b)) {
                            c11089a = (C11089a) hashMap.get(m27729b);
                        } else {
                            C11089a c11089a2 = new C11089a(C9809c.m27733a(interfaceC9808b), C9809c.m27729b(interfaceC9808b));
                            hashMap.put(m27729b, c11089a2);
                            c11089a = c11089a2;
                        }
                        long m27727c = C9809c.m27727c(interfaceC9808b) / 1000;
                        if (c11089a != null) {
                            c11089a.m23799aE(m27727c);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e) {
                    C10331c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        /* renamed from: aE */
        private void m23799aE(long j) {
            this.aOs.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.aOs.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.aOs.add(Long.valueOf(optJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        C10331c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "appName", this.appName);
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, this.packageName);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.aOs) {
                jSONArray.put(l.longValue());
            }
            C11126t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public C11089a() {
        }
    }

    /* renamed from: a */
    public static void m23816a(final Context context, final InterfaceC11090b interfaceC11090b) {
        if (context == null || C11028au.m24065Mr() || C10251d.m26528X(8192L) || C11077c.m23839bF(context)) {
            return;
        }
        m23826KT();
        aOj.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List m23810bK;
                try {
                    HashSet hashSet = new HashSet();
                    if (!C11059bi.m23877di(context) || (m23810bK = C11082f.m23810bK(context)) == null) {
                        return;
                    }
                    Iterator it = m23810bK.iterator();
                    while (it.hasNext()) {
                        C10331c.m26254d("AppStatusHelper", "AppRunningInfo: " + ((InterfaceC9808b) it.next()));
                    }
                    hashSet.addAll(m23810bK);
                    if (interfaceC11090b != null) {
                        interfaceC11090b.mo23792u(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                    C10974c.gatherException(th);
                }
            }
        });
    }

    @NonNull
    /* renamed from: a */
    private static List<InterfaceC9808b> m23815a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        C10331c.m26254d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return C9785b.m27780Av().mo27777a(strategy);
    }
}
