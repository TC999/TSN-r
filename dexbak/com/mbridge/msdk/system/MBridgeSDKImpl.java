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
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.p459b.ActiveAppUtil;
import com.mbridge.msdk.widget.custom.CustomViewMessageWrap;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mbridge.msdk.system.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MBridgeSDKImpl implements MBridgeSDK {

    /* renamed from: a */
    public static Map<String, String> f32123a;

    /* renamed from: d */
    private volatile Context f32126d;

    /* renamed from: i */
    private SDKInitStatusListener f32131i;

    /* renamed from: c */
    private volatile MBridgeSDK.PLUGIN_LOAD_STATUS f32125c = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;

    /* renamed from: b */
    public boolean f32124b = true;

    /* renamed from: e */
    private boolean f32127e = false;

    /* renamed from: f */
    private BroadcastReceiver f32128f = null;

    /* renamed from: g */
    private boolean f32129g = false;

    /* renamed from: h */
    private BroadcastReceiver f32130h = null;

    /* renamed from: j */
    private boolean f32132j = false;

    /* renamed from: k */
    private final Application.ActivityLifecycleCallbacks f32133k = new Application.ActivityLifecycleCallbacks() { // from class: com.mbridge.msdk.system.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            MIMManager.m21838a().m21826c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            MIMManager.m21838a().m21824d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            int m22877b = MBSDKContext.m22865f().m22877b();
            SameLogTool.m21733d("com.mbridge.msdk", "onActivityPaused currentActivityNum:" + m22877b);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            int m22877b = MBSDKContext.m22865f().m22877b();
            SameLogTool.m21733d("com.mbridge.msdk", "onActivityStarted currentActivityNum:" + m22877b);
            SameLogTool.m21733d("com.mbridge.msdk", "onActivityStarted isCoolStart:" + MBridgeSDKImpl.this.f32124b);
            if (!MBridgeSDKImpl.this.f32124b && m22877b == 0) {
                C11385e.m22064a("1");
            }
            MBridgeSDKImpl mBridgeSDKImpl = MBridgeSDKImpl.this;
            CommonClickUtil.m23079a(activity, m22877b, mBridgeSDKImpl.f32124b, mBridgeSDKImpl.f32126d);
            MBridgeSDKImpl.this.f32124b = false;
            MBSDKContext.m22865f().m22887a(m22877b + 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int m22877b = MBSDKContext.m22865f().m22877b();
            SameLogTool.m21733d("com.mbridge.msdk", "onActivityStopped currentActivityNum:" + m22877b);
            if (m22877b <= 1) {
                C11385e.m22064a("2");
            }
            MBSDKContext.m22865f().m22887a(m22877b - 1);
        }
    };

    /* renamed from: b */
    static /* synthetic */ void m20935b(MBridgeSDKImpl mBridgeSDKImpl, Context context) {
        if (context == null || mBridgeSDKImpl.f32127e) {
            return;
        }
        mBridgeSDKImpl.f32127e = true;
        try {
            mBridgeSDKImpl.f32128f = (BroadcastReceiver) Class.forName("com.mbridge.msdk.click.AppReceiver").newInstance();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(mBridgeSDKImpl.f32128f, intentFilter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m20934c(MBridgeSDKImpl mBridgeSDKImpl, Context context) {
        if (context != null) {
            try {
                if (mBridgeSDKImpl.f32129g) {
                    return;
                }
                Class<?> cls = Class.forName("com.alphab.receiver.AlphabReceiver");
                if (cls.newInstance() instanceof BroadcastReceiver) {
                    mBridgeSDKImpl.f32129g = true;
                    mBridgeSDKImpl.f32130h = (BroadcastReceiver) cls.newInstance();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    context.registerReceiver(mBridgeSDKImpl.f32130h, intentFilter);
                }
            } catch (ClassNotFoundException e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final boolean getConsentStatus(Context context) {
        m20940a(context);
        return SDKAuthorityController.m22842a().m22830e();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.f32125c;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application) {
        this.f32126d = StubApp.getOrigApplicationContext(application.getApplicationContext());
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application) {
        this.f32126d = StubApp.getOrigApplicationContext(application.getApplicationContext());
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preload(Map<String, Object> map) {
        if (this.f32125c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            SDKController.m22827a().m22824a(map, 0);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preloadFrame(Map<String, Object> map) {
        SDKController.m22827a().m22824a(map, 1);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void release() {
        BroadcastReceiver broadcastReceiver;
        BroadcastReceiver broadcastReceiver2;
        if (this.f32125c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            SDKController.m22827a().m22822b();
        }
        Context context = this.f32126d;
        if (context != null && (broadcastReceiver2 = this.f32128f) != null && this.f32127e) {
            this.f32127e = false;
            context.unregisterReceiver(broadcastReceiver2);
        }
        Context context2 = this.f32126d;
        if (context2 != null && (broadcastReceiver = this.f32130h) != null && this.f32129g) {
            this.f32129g = false;
            context2.unregisterReceiver(broadcastReceiver);
        }
        if (this.f32126d instanceof Application) {
            Application application = (Application) this.f32126d;
            SameLogTool.m21733d("com.mbridge.msdk", "unregisterActivityLifecycleListener:" + application.getPackageName());
            application.unregisterActivityLifecycleCallbacks(this.f32133k);
        }
        ActiveAppUtil.m23238a().m23236b();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setAllowAcquireIds(boolean z) {
        SDKAuthorityController.m22838a(z);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setConsentStatus(Context context, int i) {
        m20940a(context);
        SDKAuthorityController.m22842a().m22841a(i);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (SDKAuthorityController.m22828g() || developerTransferIdInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getImei())) {
            DomainSameDiTool.m21920a(developerTransferIdInfo.getImei());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getImsi())) {
            DomainSameDiTool.m21917b(developerTransferIdInfo.getImsi());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            SameDiTool.m21778h(developerTransferIdInfo.getGaid());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getOaid())) {
            DomainSameDiTool.m21911d(developerTransferIdInfo.getOaid());
        }
        if (!TextUtils.isEmpty(developerTransferIdInfo.getAndroidId())) {
            DomainSameDiTool.m21908e(developerTransferIdInfo.getAndroidId());
        }
        if (TextUtils.isEmpty(developerTransferIdInfo.getMac())) {
            return;
        }
        DomainSameDiTool.m21914c(developerTransferIdInfo.getMac());
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDoNotTrackStatus(boolean z) {
        SDKAuthorityController.m22842a().m22836b(z ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setThirdPartyFeatures(Map<String, Object> map) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setUserPrivateInfoType(Context context, String str, int i) {
        m20940a(context);
        SDKAuthorityController.m22842a().m22839a(str, i);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        MBSDKContext.m22865f().m22880a(weakReference);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final AuthorityInfoBean userPrivateInfo(Context context) {
        m20940a(context);
        return SDKAuthorityController.m22842a().m22837b();
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
    public final void setDoNotTrackStatus(Context context, boolean z) {
        m20940a(context);
        SDKAuthorityController.m22842a().m22836b(z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20939a(Context context, String str) {
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
            } catch (PackageManager.NameNotFoundException e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context) {
        this.f32126d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context) {
        this.f32126d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.f32126d = application;
        this.f32131i = sDKInitStatusListener;
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.f32126d = application;
        this.f32131i = sDKInitStatusListener;
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.f32126d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f32131i = sDKInitStatusListener;
        f32123a = map;
        m20941a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.f32126d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f32131i = sDKInitStatusListener;
        f32123a = map;
        m20941a();
    }

    /* renamed from: a */
    private void m20941a() {
        this.f32132j = false;
        try {
            if (this.f32126d instanceof Application) {
                Application application = (Application) this.f32126d;
                SameLogTool.m21733d("com.mbridge.msdk", "registerActivityLifecycleListener:" + application.getPackageName());
                application.registerActivityLifecycleCallbacks(this.f32133k);
            }
            SDKController.m22827a().m22823a(f32123a, this.f32126d);
            this.f32125c = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            new Thread(new Runnable() { // from class: com.mbridge.msdk.system.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (MBridgeSDKImpl.this.f32126d != null) {
                        try {
                            CustomViewMessageWrap.copyViewFile(MBridgeSDKImpl.this.f32126d, "mbridge_download_dialog_view.xml");
                        } catch (Exception unused) {
                        }
                        MBridgeSDKImpl mBridgeSDKImpl = MBridgeSDKImpl.this;
                        if (MBridgeSDKImpl.m20937a(mBridgeSDKImpl, mBridgeSDKImpl.f32126d)) {
                            MBridgeSDKImpl mBridgeSDKImpl2 = MBridgeSDKImpl.this;
                            if (mBridgeSDKImpl2.m20939a(mBridgeSDKImpl2.f32126d, "com.mbridge.msdk.click.AppReceiver")) {
                                MBridgeSDKImpl mBridgeSDKImpl3 = MBridgeSDKImpl.this;
                                MBridgeSDKImpl.m20935b(mBridgeSDKImpl3, mBridgeSDKImpl3.f32126d);
                            }
                            MBridgeSDKImpl mBridgeSDKImpl4 = MBridgeSDKImpl.this;
                            if (mBridgeSDKImpl4.m20939a(mBridgeSDKImpl4.f32126d, "com.alphab.receiver.AlphabReceiver")) {
                                MBridgeSDKImpl mBridgeSDKImpl5 = MBridgeSDKImpl.this;
                                MBridgeSDKImpl.m20934c(mBridgeSDKImpl5, mBridgeSDKImpl5.f32126d);
                            }
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() { // from class: com.mbridge.msdk.system.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    Looper.prepare();
                    ActiveAppUtil.m23238a().m23233e();
                    Looper.loop();
                }
            }).start();
            RequestUrlUtil.m22248a().m22242c();
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() { // from class: com.mbridge.msdk.system.a.5
                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getReadableDatabase() {
                    return CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()).m22723a();
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getWritableDatabase() {
                    return CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()).m22722b();
                }
            });
            builder.setLogger(new ILogger() { // from class: com.mbridge.msdk.system.a.6
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, String str2) {
                    SameLogTool.m21738a(str, str2);
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, Exception exc) {
                    SameLogTool.m21738a(str, exc.getMessage());
                }
            });
            MBDownloadManager.getInstance().initialize(MBSDKContext.m22865f().m22861j(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
            MBBatchReportManager.m22142a().m22138b();
            SDKInitStatusListener sDKInitStatusListener = this.f32131i;
            if (sDKInitStatusListener != null && !this.f32132j) {
                this.f32132j = true;
                sDKInitStatusListener.onInitSuccess();
            }
            try {
                MIMManager.m21838a().m21837a(StubApp.getOrigApplicationContext(this.f32126d.getApplicationContext()));
            } catch (Exception e) {
                SameLogTool.m21735b("com.mbridge.msdk", "INIT", e);
            }
            try {
                ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.system.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = 24;
                        int i2 = 1;
                        try {
                            Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
                            if (m23241g != null) {
                                int m23283u = m23241g.m23283u();
                                i = m23241g.m23285t();
                                i2 = m23283u;
                            }
                        } catch (Exception unused) {
                        }
                        if (i2 != 0 || i <= 0) {
                            return;
                        }
                        long j = 0;
                        try {
                            j = ((Long) C11400ae.m21961b(MBSDKContext.m22865f().m22861j(), "is_transmission_time", 0L)).longValue();
                        } catch (Exception unused2) {
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis <= j + (i * 60 * 60 * 1000)) {
                            return;
                        }
                        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), "is_transmission_time", Long.valueOf(currentTimeMillis));
                        if (MBSDKContext.m22865f().m22861j() != null) {
                            try {
                                MBSDKContext.m22865f().m22861j().registerReceiver(new ExChangePMBroadcast(), new IntentFilter("mbridge_action_exchange_pm"));
                                MBSDKContext.m22865f().m22861j().registerReceiver(new ExChangeVideoBroadcast(), new IntentFilter("mbridge_action_exchange_pm_receiver"));
                            } catch (Exception unused3) {
                            }
                        }
                        if (MBSDKContext.m22865f().m22861j() != null) {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("pm-sender", MBSDKContext.m22865f().m22861j().getPackageName());
                            intent.putExtras(bundle);
                            intent.setAction("mbridge_action_exchange_pm");
                            MBSDKContext.m22865f().m22861j().sendOrderedBroadcast(intent, null);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                SameLogTool.m21735b("com.mbridge.msdk", "无法初始化MMSDK", e2);
                e2.printStackTrace();
            }
            SDKInitStatusListener sDKInitStatusListener2 = this.f32131i;
            if (sDKInitStatusListener2 == null || this.f32132j) {
                return;
            }
            this.f32132j = true;
            sDKInitStatusListener2.onInitFail(e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m20940a(Context context) {
        if (MBSDKContext.m22865f().m22861j() != null || context == null) {
            return;
        }
        MBSDKContext.m22865f().m22875b(context);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m20937a(MBridgeSDKImpl mBridgeSDKImpl, Context context) {
        return (context != null ? SameDiTool.m21767w(context) : 0) >= 26 && Build.VERSION.SDK_INT >= 26;
    }
}
