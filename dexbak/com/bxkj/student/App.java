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
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.acse.ottn.activity.AcseHelpManager;
import com.amap.api.location.AMapLocationClient;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.beizi.fusion.BeiZis;
import com.bxkj.base.BaseApp;
import com.bxkj.base.chat.p084db.ChatMessageDb;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.App;
import com.bxkj.student.common.p088db.HomeMenuDB;
import com.bxkj.student.common.versionupdate.VersionUpdate;
import com.bxkj.student.home.teaching.learning.detail.p090db.ReadExceptionDataDB;
import com.bxkj.student.p094v2.common.utils.ActivityManager;
import com.bxkj.student.p094v2.common.utils.AppSecretUtils;
import com.bxkj.student.p094v2.common.utils.WechatUtils;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.splash.SplashActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.C11792j;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.PrettyFormatStrategy;
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
import p638r0.DefaultRefreshFooterCreater;
import p638r0.DefaultRefreshHeaderCreater;
import p638r0.RefreshFooter;
import p638r0.RefreshHeader;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class App extends BaseApp {

    /* renamed from: d */
    private static App f15886d;

    /* renamed from: e */
    private static Context f15887e;

    /* renamed from: c */
    private Long f15888c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4199a extends Thread {
        C4199a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            SQLiteDbUtil.m57474h().m57468n(App.f15887e, "xiaowei");
            SQLiteDbUtil.m57474h().m57480b(ChatMessageDb.class);
            SQLiteDbUtil.m57474h().m57480b(HomeMenuDB.class);
            SQLiteDbUtil.m57474h().m57480b(ReadExceptionDataDB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4200b implements DefaultRefreshHeaderCreater {
        C4200b() {
        }

        @Override // p638r0.DefaultRefreshHeaderCreater
        /* renamed from: a */
        public RefreshHeader mo2123a(Context context, RefreshLayout layout) {
            layout.mo2072H(false);
            return new MaterialHeader(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4201c implements DefaultRefreshFooterCreater {
        C4201c() {
        }

        @Override // p638r0.DefaultRefreshFooterCreater
        /* renamed from: a */
        public RefreshFooter mo2124a(Context context, RefreshLayout layout) {
            layout.mo2022s(true);
            return new ClassicsFooter(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4202d extends AndroidLogAdapter {
        C4202d(FormatStrategy formatStrategy) {
            super(formatStrategy);
        }

        @Override // com.orhanobut.logger.AndroidLogAdapter, com.orhanobut.logger.LogAdapter
        /* renamed from: b */
        public boolean mo20474b(int priority, @Nullable @org.jetbrains.annotations.Nullable String tag) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4203e implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        private View.OnLayoutChangeListener f15894a;

        C4203e() {
        }

        /* renamed from: b */
        private void m42993b(Activity activity) {
            View findViewById = activity.getWindow().findViewById(App.this.getResources().getIdentifier("statusBarBackground", "id", FaceEnvironment.f8430OS));
            if (findViewById != null) {
                findViewById.setBackgroundResource(C4215R.C4218drawable.statusbar_bg_color);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m42992c(Activity activity, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            m42993b(activity);
        }

        /* renamed from: d */
        private void m42991d(final Activity activity) {
            this.f15894a = new View.OnLayoutChangeListener() { // from class: com.bxkj.student.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    App.C4203e.this.m42992c(activity, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            };
            activity.getWindow().getDecorView().addOnLayoutChangeListener(this.f15894a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            activity.setRequestedOrientation(1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            activity.getWindow().getDecorView().removeOnLayoutChangeListener(this.f15894a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (LoginUser.getLoginUser().isAgreement()) {
                MobclickAgent.onPause(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ActivityManager.f20090a.m39149b(activity);
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
            View findViewById = activity.findViewById(2131232779);
            if (activity instanceof MainActivity) {
                findViewById = activity.findViewById(C4215R.C4219id.toolbar2);
            }
            if ((activity instanceof BaseActivity) || findViewById == null || findViewById.getVisibility() != 0) {
                return;
            }
            findViewById.setBackgroundResource(C4215R.C4218drawable.statusbar_bg_color);
            m42991d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.App$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C4204f implements IInitCallback {
        C4204f() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i, String s) {
            C11792j.m20468e("FaceSDKManager初始化失败i=" + i + "s=" + s, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            C11792j.m20470c("FaceSDKManager初始化成功");
        }
    }

    /* renamed from: com.bxkj.student.App$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C4205g implements VersionUpdate.InterfaceC4268d {

        /* renamed from: a */
        final /* synthetic */ VersionUpdate f15897a;

        /* renamed from: b */
        final /* synthetic */ Context f15898b;

        C4205g(final VersionUpdate val$versionUpdate, final Context val$mContext) {
            this.f15897a = val$versionUpdate;
            this.f15898b = val$mContext;
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: a */
        public void mo38646a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            Dialog dialog;
            if (hasNewVersion) {
                MainActivity mainActivity = (MainActivity) AppManager.m57776n().getActivity(MainActivity.class);
                if (mainActivity == null || (dialog = mainActivity.f15971q) == null || !dialog.isShowing()) {
                    this.f15897a.m42763d(versionName, downLoadUrl, instruction);
                    return;
                }
                return;
            }
            new iOSOneButtonDialog(this.f15898b).setMessage("当前已是最新版本").show();
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: b */
        public void mo38645b() {
        }
    }

    /* renamed from: n */
    public static App m43006n() {
        return f15886d;
    }

    /* renamed from: o */
    public static Context m43005o() {
        return f15887e;
    }

    /* renamed from: p */
    private static String m43004p(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: q */
    private void m43003q() {
        LoginUser.getLoginUser().setUserType(1);
        Http.getHttp().setDebugMode(false);
        Http.getHttp().setLoadingDialog(C4215R.C4221layout.dialog_loading_view);
        m43002r();
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new C4200b());
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new C4201c());
        if (LoginUser.getLoginUser().isAgreement()) {
            m43008l();
        }
        m42997w();
        m42999u();
        m42998v();
    }

    /* renamed from: r */
    private void m43002r() {
        try {
            new C4199a().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: s */
    private void m43001s() {
        try {
            m42996x();
            FaceSDKManager.getInstance().initialize(this, "XiaoWeiFaceDetection-face-android", "baidu-idl-license.face-android", new C4204f());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: t */
    private void m43000t() {
        PrettyFormatStrategy m20443a = PrettyFormatStrategy.m20444k().m20438f("TSNAPP").m20443a();
        C11792j.m20471b();
        C11792j.m20472a(new C4202d(m20443a));
    }

    /* renamed from: u */
    private void m42999u() {
    }

    /* renamed from: v */
    private void m42998v() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.App.4
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void onMoveToBackground() {
                C11792j.m20470c("app moved to background");
                App.this.f15888c = Long.valueOf(System.currentTimeMillis());
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void onMoveToForeground() {
                C11792j.m20470c("app moved to foreground");
                if (App.this.f15888c != null) {
                    C11792j.m20470c("System.currentTimeMillis()-lastResumeTime=" + (((System.currentTimeMillis() - App.this.f15888c.longValue()) / 1000) / 60) + "分钟");
                    if (System.currentTimeMillis() - App.this.f15888c.longValue() <= 1800000 || LoggedInUser.f15182b.m43634a().m43690A() != 1) {
                        return;
                    }
                    App.this.startActivity(new Intent(BaseApp.m44341b(), SplashActivity.class).setFlags(268435456).putExtra("onlyOpenAd", true));
                }
            }
        });
    }

    /* renamed from: w */
    private void m42997w() {
        registerActivityLifecycleCallbacks(new C4203e());
    }

    /* renamed from: x */
    private void m42996x() {
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

    /* renamed from: y */
    public static void m42995y(Application application) {
        String m43004p = m43004p(application);
        if (application.getPackageName().equals(m43004p) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WebView.setDataDirectorySuffix(m43004p);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override // com.bxkj.base.BaseApp
    /* renamed from: h */
    public void mo43012h(Context mContext) {
        VersionUpdate versionUpdate = new VersionUpdate(mContext);
        versionUpdate.m42765b(new C4205g(versionUpdate, mContext));
    }

    /* renamed from: l */
    public void m43008l() {
        m43001s();
        AMapLocationClient.updatePrivacyShow(f15887e, true, true);
        AMapLocationClient.updatePrivacyAgree(f15887e, true);
        CrashReport.initCrashReport(StubApp.getOrigApplicationContext(getApplicationContext()), "ae6e27150a", false);
        UMConfigure.preInit(this, "59a61305a3251138c9000c17", m43007m(this));
        UMConfigure.submitPolicyGrantResult(this, true);
        UMConfigure.setLogEnabled(false);
        UMConfigure.init(this, "59a61305a3251138c9000c17", m43007m(this), 1, "");
        PlatformConfig.setWeixin(WechatUtils.f20153b, "505a323b2213d09ca75c989ac6946943");
        PlatformConfig.setWXFileProvider("com.bxkj.student.provider");
        PlatformConfig.setQQZone("1106200175", "pTNnuKKrFFrM9SFa");
        PlatformConfig.setQQFileProvider("com.bxkj.student.provider");
        Tencent.setIsPermissionGranted(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        BeiZis.init(this, "21335");
        new AcseHelpManager.InitSdk().isInitWebView(true).setContext(this).build();
        AppSecretUtils.f20093a.m39147b();
    }

    /* renamed from: m */
    public String m43007m(Context ctx) {
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
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? "Unknown" : str;
    }

    @Override // com.bxkj.base.BaseApp, android.app.Application
    public void onCreate() {
        super.onCreate();
        f15886d = this;
        f15887e = this;
        if (m44338e()) {
            m43003q();
        }
        m42995y(this);
        m43000t();
    }
}
