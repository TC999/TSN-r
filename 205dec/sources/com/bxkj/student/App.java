package com.bxkj.student;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.jiguang.api.utils.JCollectionAuth;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushCollectControl;
import com.acse.ottn.activity.AcseHelpManager;
import com.amap.api.location.AMapLocationClient;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.bxkj.base.BaseApp;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.bxkj.student.App;
import com.bxkj.student.common.db.HomeMenuDB;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.splash.SplashActivity;
import com.bxkj.student.v2.common.view.FloatActionView;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.orhanobut.logger.j;
import com.orhanobut.logger.l;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.stub.StubApp;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.tauth.Tencent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import java.util.ArrayList;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class App extends BaseApp {

    /* renamed from: d  reason: collision with root package name */
    private static App f19365d;

    /* renamed from: e  reason: collision with root package name */
    private static Context f19366e;

    /* renamed from: c  reason: collision with root package name */
    private Long f19367c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            cn.bluemobi.dylan.sqlitelibrary.c.h().n(App.f19366e, "xiaowei");
            cn.bluemobi.dylan.sqlitelibrary.c.h().b(ChatMessageDb.class);
            cn.bluemobi.dylan.sqlitelibrary.c.h().b(HomeMenuDB.class);
            cn.bluemobi.dylan.sqlitelibrary.c.h().b(ReadExceptionDataDB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b implements j1.b {
        b() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.scwang.smartrefresh.header.MaterialHeader, j1.e] */
        @Override // j1.b
        public j1.e a(Context context, j1.h layout) {
            layout.E(false);
            return new MaterialHeader(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class c implements j1.a {
        c() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.scwang.smartrefresh.layout.footer.ClassicsFooter, j1.d] */
        @Override // j1.a
        public j1.d a(Context context, j1.h layout) {
            layout.r(true);
            return new ClassicsFooter(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class d extends com.orhanobut.logger.a {
        d(com.orhanobut.logger.f formatStrategy) {
            super(formatStrategy);
        }

        @Override // com.orhanobut.logger.a, com.orhanobut.logger.g
        public boolean b(int priority, @Nullable @org.jetbrains.annotations.Nullable String tag) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class e implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private View.OnLayoutChangeListener f19373a;

        e() {
        }

        private void b(Activity activity) {
            View findViewById = activity.getWindow().findViewById(App.this.getResources().getIdentifier("statusBarBackground", "id", "android"));
            if (findViewById != null) {
                findViewById.setBackgroundResource(2131165936);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Activity activity, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            b(activity);
        }

        private void d(final Activity activity) {
            this.f19373a = new View.OnLayoutChangeListener() { // from class: com.bxkj.student.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    App.e.this.c(activity, view, i4, i5, i6, i7, i8, i9, i10, i11);
                }
            };
            activity.getWindow().getDecorView().addOnLayoutChangeListener(this.f19373a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            activity.setRequestedOrientation(1);
            try {
                new FloatActionView(activity).n();
            } catch (Exception e4) {
                j.e("FloatActionView\uff1a=" + e4.getMessage(), new Object[0]);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            activity.getWindow().getDecorView().removeOnLayoutChangeListener(this.f19373a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (LoginUser.getLoginUser().isAgreement()) {
                MobclickAgent.onPause(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            com.bxkj.student.v2.common.utils.a.f23334a.b(activity);
            if (LoginUser.getLoginUser().isAgreement()) {
                MobclickAgent.onResume(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if ((activity instanceof SplashActivity) || (activity instanceof SelectSchoolV2Activity) || (activity instanceof H5AppActivity)) {
                return;
            }
            View findViewById = activity.findViewById(2131232865);
            if (activity instanceof MainActivity) {
                findViewById = activity.findViewById(2131232866);
            }
            if ((activity instanceof BaseActivity) || findViewById == null || findViewById.getVisibility() != 0) {
                return;
            }
            findViewById.setBackgroundResource(2131165936);
            d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class f implements IAMPSInitCallback {
        f() {
        }

        @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
        public void failCallback(AMPSError ampsError) {
            j.g("BeiZisDemo->initAMPSSDK failCallback ampsError : " + ampsError.toString(), new Object[0]);
        }

        @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
        public void successCallback() {
            j.g("BeiZisDemo->initAMPSSDK successCallback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class g implements IInitCallback {
        g() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i4, String s3) {
            j.e("FaceSDKManager\u521d\u59cb\u5316\u5931\u8d25i=" + i4 + "s=" + s3, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            j.c("FaceSDKManager\u521d\u59cb\u5316\u6210\u529f");
        }
    }

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class h implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f19377a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19378b;

        h(final com.bxkj.student.common.versionupdate.a val$versionUpdate, final Context val$mContext) {
            this.f19377a = val$versionUpdate;
            this.f19378b = val$mContext;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            Dialog dialog;
            if (hasNewVersion) {
                MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
                if (mainActivity == null || (dialog = mainActivity.f19426q) == null || !dialog.isShowing()) {
                    this.f19377a.d(versionName, downLoadUrl, instruction);
                    return;
                }
                return;
            }
            new iOSOneButtonDialog(this.f19378b).setMessage("\u5f53\u524d\u5df2\u662f\u6700\u65b0\u7248\u672c").show();
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
        }
    }

    public static App n() {
        return f19365d;
    }

    public static Context o() {
        return f19366e;
    }

    private static String p(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private void q() {
        LoginUser.getLoginUser().setUserType(1);
        Http.getHttp().setDebugMode(false);
        Http.getHttp().setLoadingDialog(2131427616);
        r();
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new b());
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new c());
        if (LoginUser.getLoginUser().isAgreement()) {
            l();
        }
        w();
        u();
        v();
    }

    private void r() {
        try {
            new a().start();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void s() {
        x();
        FaceSDKManager.getInstance().initialize(this, "XiaoWeiFaceDetection-face-android", "baidu-idl-license.face-android", new g());
    }

    private void t() {
        l a4 = l.k().f("TSNAPP").a();
        j.b();
        j.a(new d(a4));
    }

    private void u() {
    }

    private void v() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.App.4
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void onMoveToBackground() {
                j.c("app moved to background");
                App.this.f19367c = Long.valueOf(System.currentTimeMillis());
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void onMoveToForeground() {
                j.c("app moved to foreground");
                try {
                    if (com.bxkj.base.v2.data.a.f18673h.a().K()) {
                        App.this.startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 1));
                    }
                } catch (Exception unused) {
                    j.e("startService\uff1a+e.message", new Object[0]);
                }
                if (App.this.f19367c != null) {
                    j.c("System.currentTimeMillis()-lastResumeTime=" + (((System.currentTimeMillis() - App.this.f19367c.longValue()) / 1000) / 60) + "\u5206\u949f");
                    if (System.currentTimeMillis() - App.this.f19367c.longValue() <= 1800000 || com.bxkj.base.v2.data.a.f18673h.a().I() != 1) {
                        return;
                    }
                    App.this.startActivity(new Intent(BaseApp.b(), SplashActivity.class).setFlags(268435456).putExtra("onlyOpenAd", true));
                }
            }
        });
    }

    private void w() {
        registerActivityLifecycleCallbacks(new e());
    }

    private void x() {
        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
        faceConfig.setMinFaceSize(200);
        faceConfig.setNotFaceValue(0.6f);
        faceConfig.setBlurnessValue(0.4f);
        faceConfig.setBrightnessValue(0.0f);
        faceConfig.setBrightnessMaxValue(255.0f);
        faceConfig.setOcclusionValue(0.5f);
        faceConfig.setHeadPitchValue(15);
        faceConfig.setHeadYawValue(15);
        faceConfig.setHeadRollValue(15);
        faceConfig.setEyeClosedValue(0.4f);
        faceConfig.setCacheImageNum(1);
        faceConfig.setOpenMask(false);
        faceConfig.setMaskValue(0.7f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(LivenessTypeEnum.Eye);
        arrayList.add(LivenessTypeEnum.Mouth);
        arrayList.add(LivenessTypeEnum.HeadDown);
        faceConfig.setLivenessTypeList(arrayList);
        faceConfig.setLivenessRandom(true);
        faceConfig.setLivenessRandomCount(3);
        faceConfig.setSound(true);
        faceConfig.setScale(1.0f);
        faceConfig.setCropHeight(640);
        faceConfig.setEnlargeRatio(1.5f);
        faceConfig.setSecType(0);
        FaceSDKManager.getInstance().setFaceConfig(faceConfig);
    }

    public static void y(Application application) {
        String p3 = p(application);
        if (application.getPackageName().equals(p3) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WebView.setDataDirectorySuffix(p3);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override // com.bxkj.base.BaseApp
    public void h(Context mContext) {
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(mContext);
        aVar.b(new h(aVar, mContext));
    }

    public void l() {
        s();
        AMapLocationClient.updatePrivacyShow(f19366e, true, true);
        AMapLocationClient.updatePrivacyAgree(f19366e, true);
        CrashReport.initCrashReport(StubApp.getOrigApplicationContext(getApplicationContext()), "ae6e27150a", false);
        UMConfigure.preInit(this, "59a61305a3251138c9000c17", m(this));
        UMConfigure.submitPolicyGrantResult(this, true);
        UMConfigure.setLogEnabled(false);
        UMConfigure.init(this, "59a61305a3251138c9000c17", m(this), 1, "");
        PlatformConfig.setWeixin("wxc9214f296e1fba92", "505a323b2213d09ca75c989ac6946943");
        PlatformConfig.setWXFileProvider("com.bxkj.student.provider");
        PlatformConfig.setQQZone("1106200175", "pTNnuKKrFFrM9SFa");
        PlatformConfig.setQQFileProvider("com.bxkj.student.provider");
        Tencent.setIsPermissionGranted(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        AMPSSDK.init(this, new AMPSInitConfig.Builder().setAppId(com.bxkj.student.v2.common.data.a.f23123b).setAppName(getResources().getString(2131820628)).build(), new f());
        new AcseHelpManager.InitSdk().isInitWebView(true).setContext(this).build();
        com.bxkj.student.v2.common.utils.c.f23337a.b();
        if (com.bxkj.base.v2.data.a.f18673h.a().L() == 1) {
            JPushInterface.setDebugMode(false);
            JPushInterface.setSmartPushEnable(f19366e, false);
            JPushInterface.setGeofenceEnable(f19366e, false);
            JCollectionAuth.enableAutoWakeup(f19366e, false);
            JPushInterface.setLinkMergeEnable(f19366e, false);
            JCollectionAuth.enableAppTerminate(f19366e, false);
            JPushCollectControl.Builder builder = new JPushCollectControl.Builder();
            builder.ssid(false);
            builder.bssid(false);
            builder.wifi(false);
            JPushCollectControl build = builder.build();
            j.c("build.getEnableDatas()=" + build.getEnableDatas());
            JPushInterface.setCollectControl(f19366e, build);
            JCollectionAuth.setAuth(f19366e, true);
            JPushInterface.init(this);
            JPushInterface.resumePush(this);
            j.c("JPushInterface.getRegistrationID(getContext())=" + JPushInterface.getRegistrationID(f19366e));
            return;
        }
        JPushInterface.stopPush(this);
    }

    public String m(Context ctx) {
        ApplicationInfo applicationInfo;
        String str = null;
        if (ctx == null) {
            return null;
        }
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), 128)) != null && applicationInfo.metaData != null) {
                str = applicationInfo.metaData.get("UMENG_CHANNEL") + "";
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? "Unknown" : str;
    }

    @Override // com.bxkj.base.BaseApp, android.app.Application
    public void onCreate() {
        try {
            super.onCreate();
            f19365d = this;
            f19366e = this;
            t();
            if (e()) {
                q();
            }
            y(this);
        } catch (Exception e4) {
            e4.printStackTrace();
            j.c("\u521d\u59cb\u5316\u5f02\u5e38" + e4.getMessage());
            CrashReport.postCatchedException(e4);
        }
    }
}
