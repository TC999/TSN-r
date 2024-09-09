package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.widget.custom.CustomViewMessageWrap;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MBridgeSDKImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a implements MBridgeSDK {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f40873a;

    /* renamed from: d  reason: collision with root package name */
    private volatile Context f40876d;

    /* renamed from: i  reason: collision with root package name */
    private SDKInitStatusListener f40881i;

    /* renamed from: c  reason: collision with root package name */
    private volatile MBridgeSDK.PLUGIN_LOAD_STATUS f40875c = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40874b = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f40877e = false;

    /* renamed from: f  reason: collision with root package name */
    private BroadcastReceiver f40878f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f40879g = false;

    /* renamed from: h  reason: collision with root package name */
    private BroadcastReceiver f40880h = null;

    /* renamed from: j  reason: collision with root package name */
    private boolean f40882j = false;

    /* renamed from: k  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f40883k = new Application.ActivityLifecycleCallbacks() { // from class: com.mbridge.msdk.system.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            o.a().c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            o.a().d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            int b4 = com.mbridge.msdk.foundation.controller.a.f().b();
            x.d("com.mbridge.msdk", "onActivityPaused currentActivityNum:" + b4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            int b4 = com.mbridge.msdk.foundation.controller.a.f().b();
            x.d("com.mbridge.msdk", "onActivityStarted currentActivityNum:" + b4);
            x.d("com.mbridge.msdk", "onActivityStarted isCoolStart:" + a.this.f40874b);
            if (!a.this.f40874b && b4 == 0) {
                e.a("1");
            }
            a aVar = a.this;
            c.a(activity, b4, aVar.f40874b, aVar.f40876d);
            a.this.f40874b = false;
            com.mbridge.msdk.foundation.controller.a.f().a(b4 + 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int b4 = com.mbridge.msdk.foundation.controller.a.f().b();
            x.d("com.mbridge.msdk", "onActivityStopped currentActivityNum:" + b4);
            if (b4 <= 1) {
                e.a("2");
            }
            com.mbridge.msdk.foundation.controller.a.f().a(b4 - 1);
        }
    };

    static /* synthetic */ void b(a aVar, Context context) {
        if (context == null || aVar.f40877e) {
            return;
        }
        aVar.f40877e = true;
        try {
            aVar.f40878f = (BroadcastReceiver) Class.forName("com.mbridge.msdk.click.AppReceiver").newInstance();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(aVar.f40878f, intentFilter);
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (InstantiationException e6) {
            e6.printStackTrace();
        }
    }

    static /* synthetic */ void c(a aVar, Context context) {
        if (context != null) {
            try {
                if (aVar.f40879g) {
                    return;
                }
                Class<?> cls = Class.forName("com.alphab.receiver.AlphabReceiver");
                if (cls.newInstance() instanceof BroadcastReceiver) {
                    aVar.f40879g = true;
                    aVar.f40880h = (BroadcastReceiver) cls.newInstance();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    context.registerReceiver(aVar.f40880h, intentFilter);
                }
            } catch (ClassNotFoundException e4) {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final boolean getConsentStatus(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.f40875c;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application) {
        this.f40876d = StubApp.getOrigApplicationContext(application.getApplicationContext());
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application) {
        this.f40876d = StubApp.getOrigApplicationContext(application.getApplicationContext());
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preload(Map<String, Object> map) {
        if (this.f40875c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            b.a().a(map, 0);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preloadFrame(Map<String, Object> map) {
        b.a().a(map, 1);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void release() {
        BroadcastReceiver broadcastReceiver;
        BroadcastReceiver broadcastReceiver2;
        if (this.f40875c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            b.a().b();
        }
        Context context = this.f40876d;
        if (context != null && (broadcastReceiver2 = this.f40878f) != null && this.f40877e) {
            this.f40877e = false;
            context.unregisterReceiver(broadcastReceiver2);
        }
        Context context2 = this.f40876d;
        if (context2 != null && (broadcastReceiver = this.f40880h) != null && this.f40879g) {
            this.f40879g = false;
            context2.unregisterReceiver(broadcastReceiver);
        }
        if (this.f40876d instanceof Application) {
            Application application = (Application) this.f40876d;
            x.d("com.mbridge.msdk", "unregisterActivityLifecycleListener:" + application.getPackageName());
            application.unregisterActivityLifecycleCallbacks(this.f40883k);
        }
        com.mbridge.msdk.c.b.a.a().b();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setAllowAcquireIds(boolean z3) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a(z3);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setConsentStatus(Context context, int i4) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(i4);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() || developerTransferIdInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getImei())) {
            com.mbridge.msdk.foundation.tools.e.a(developerTransferIdInfo.getImei());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getImsi())) {
            com.mbridge.msdk.foundation.tools.e.b(developerTransferIdInfo.getImsi());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            t.h(developerTransferIdInfo.getGaid());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getOaid())) {
            com.mbridge.msdk.foundation.tools.e.d(developerTransferIdInfo.getOaid());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getAndroidId())) {
            com.mbridge.msdk.foundation.tools.e.e(developerTransferIdInfo.getAndroidId());
        }
        if (TextUtils.isEmpty(developerTransferIdInfo.getMac())) {
            return;
        }
        com.mbridge.msdk.foundation.tools.e.c(developerTransferIdInfo.getMac());
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDoNotTrackStatus(boolean z3) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z3 ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setThirdPartyFeatures(Map<String, Object> map) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setUserPrivateInfoType(Context context, String str, int i4) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(str, i4);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        com.mbridge.msdk.foundation.controller.a.f().a(weakReference);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final AuthorityInfoBean userPrivateInfo(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return hashMap;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDoNotTrackStatus(Context context, boolean z3) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z3 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str) {
        ActivityInfo[] activityInfoArr;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 2);
                if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (activityInfo != null && str.equals(activityInfo.name)) {
                            return true;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e4) {
                if (MBridgeConstans.DEBUG) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context) {
        this.f40876d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context) {
        this.f40876d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.f40876d = application;
        this.f40881i = sDKInitStatusListener;
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.f40876d = application;
        this.f40881i = sDKInitStatusListener;
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.f40876d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f40881i = sDKInitStatusListener;
        f40873a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.f40876d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f40881i = sDKInitStatusListener;
        f40873a = map;
        a();
    }

    private void a() {
        this.f40882j = false;
        try {
            if (this.f40876d instanceof Application) {
                Application application = (Application) this.f40876d;
                x.d("com.mbridge.msdk", "registerActivityLifecycleListener:" + application.getPackageName());
                application.registerActivityLifecycleCallbacks(this.f40883k);
            }
            b.a().a(f40873a, this.f40876d);
            this.f40875c = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            new Thread(new Runnable() { // from class: com.mbridge.msdk.system.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f40876d != null) {
                        try {
                            CustomViewMessageWrap.copyViewFile(a.this.f40876d, "mbridge_download_dialog_view.xml");
                        } catch (Exception unused) {
                        }
                        a aVar = a.this;
                        if (a.a(aVar, aVar.f40876d)) {
                            a aVar2 = a.this;
                            if (aVar2.a(aVar2.f40876d, "com.mbridge.msdk.click.AppReceiver")) {
                                a aVar3 = a.this;
                                a.b(aVar3, aVar3.f40876d);
                            }
                            a aVar4 = a.this;
                            if (aVar4.a(aVar4.f40876d, "com.alphab.receiver.AlphabReceiver")) {
                                a aVar5 = a.this;
                                a.c(aVar5, aVar5.f40876d);
                            }
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() { // from class: com.mbridge.msdk.system.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    Looper.prepare();
                    com.mbridge.msdk.c.b.a.a().e();
                    Looper.loop();
                }
            }).start();
            d.a().c();
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() { // from class: com.mbridge.msdk.system.a.5
                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getReadableDatabase() {
                    return i.a(com.mbridge.msdk.foundation.controller.a.f().j()).a();
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getWritableDatabase() {
                    return i.a(com.mbridge.msdk.foundation.controller.a.f().j()).b();
                }
            });
            builder.setLogger(new ILogger() { // from class: com.mbridge.msdk.system.a.6
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, String str2) {
                    x.a(str, str2);
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, Exception exc) {
                    x.a(str, exc.getMessage());
                }
            });
            MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.a.f().j(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
            com.mbridge.msdk.foundation.same.report.b.a().b();
            SDKInitStatusListener sDKInitStatusListener = this.f40881i;
            if (sDKInitStatusListener != null && !this.f40882j) {
                this.f40882j = true;
                sDKInitStatusListener.onInitSuccess();
            }
            try {
                o.a().a(StubApp.getOrigApplicationContext(this.f40876d.getApplicationContext()));
            } catch (Exception e4) {
                x.b("com.mbridge.msdk", "INIT", e4);
            }
            try {
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.system.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i4 = 24;
                        int i5 = 1;
                        try {
                            com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
                            if (g4 != null) {
                                int u3 = g4.u();
                                i4 = g4.t();
                                i5 = u3;
                            }
                        } catch (Exception unused) {
                        }
                        if (i5 != 0 || i4 <= 0) {
                            return;
                        }
                        long j4 = 0;
                        try {
                            j4 = ((Long) ae.b(com.mbridge.msdk.foundation.controller.a.f().j(), "is_transmission_time", 0L)).longValue();
                        } catch (Exception unused2) {
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis <= j4 + (i4 * 60 * 60 * 1000)) {
                            return;
                        }
                        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), "is_transmission_time", Long.valueOf(currentTimeMillis));
                        if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                            try {
                                com.mbridge.msdk.foundation.controller.a.f().j().registerReceiver(new ExChangePMBroadcast(), new IntentFilter("mbridge_action_exchange_pm"));
                                com.mbridge.msdk.foundation.controller.a.f().j().registerReceiver(new ExChangeVideoBroadcast(), new IntentFilter("mbridge_action_exchange_pm_receiver"));
                            } catch (Exception unused3) {
                            }
                        }
                        if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("pm-sender", com.mbridge.msdk.foundation.controller.a.f().j().getPackageName());
                            intent.putExtras(bundle);
                            intent.setAction("mbridge_action_exchange_pm");
                            com.mbridge.msdk.foundation.controller.a.f().j().sendOrderedBroadcast(intent, null);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                x.b("com.mbridge.msdk", "\u65e0\u6cd5\u521d\u59cb\u5316MMSDK", e5);
                e5.printStackTrace();
            }
            SDKInitStatusListener sDKInitStatusListener2 = this.f40881i;
            if (sDKInitStatusListener2 == null || this.f40882j) {
                return;
            }
            this.f40882j = true;
            sDKInitStatusListener2.onInitFail(e5.getMessage());
        }
    }

    private void a(Context context) {
        if (com.mbridge.msdk.foundation.controller.a.f().j() != null || context == null) {
            return;
        }
        com.mbridge.msdk.foundation.controller.a.f().b(context);
    }

    static /* synthetic */ boolean a(a aVar, Context context) {
        return (context != null ? t.w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26;
    }
}
