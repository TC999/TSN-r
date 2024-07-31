package com.acse.ottn.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.acse.ottn.p035b.C1414L;
import com.acse.ottn.p035b.C1423h;
import com.acse.ottn.p035b.C1431o;
import com.acse.ottn.p042d.C1533k;
import com.acse.ottn.util.C1658aa;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1685na;
import com.acse.ottn.util.C1692qa;
import com.acse.ottn.util.C1710ya;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AcseHelpManager {
    public static Application mContext;
    public static boolean mIsDebug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.acse.ottn.activity.AcseHelpManager$2 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C12562 implements OnOpenPermission {

        /* renamed from: a */
        final /* synthetic */ boolean f2081a;

        /* renamed from: b */
        final /* synthetic */ Activity f2082b;

        /* renamed from: c */
        final /* synthetic */ OnCurrentStateCallBack f2083c;

        /* renamed from: d */
        final /* synthetic */ boolean f2084d;

        C12562(boolean z, Activity activity, OnCurrentStateCallBack onCurrentStateCallBack, boolean z2) {
            this.f2081a = z;
            this.f2082b = activity;
            this.f2083c = onCurrentStateCallBack;
            this.f2084d = z2;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z) {
            OnCurrentStateCallBack onCurrentStateCallBack;
            if (!z && !this.f2081a) {
                onCurrentStateCallBack = this.f2083c;
                if (onCurrentStateCallBack == null) {
                    return;
                }
            } else if (!AcseHelpManager.isOPenPermission()) {
                AcseHelpManager.showRunningDialog(this.f2082b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.2.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = C12562.this.f2083c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        C12562 c12562 = C12562.this;
                        if (c12562.f2084d) {
                            AcseHelpManager.showWarningDialog(c12562.f2082b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.2.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12562.this.f2083c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12562.this.f2083c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12562.this.f2083c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = c12562.f2083c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = C12562.this.f2083c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            } else {
                onCurrentStateCallBack = this.f2083c;
                if (onCurrentStateCallBack == null) {
                    return;
                }
            }
            onCurrentStateCallBack.onState("0");
        }
    }

    /* renamed from: com.acse.ottn.activity.AcseHelpManager$3 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C12593 implements OnOpenPermission {

        /* renamed from: a */
        final /* synthetic */ Activity f2087a;

        /* renamed from: b */
        final /* synthetic */ String f2088b;

        /* renamed from: c */
        final /* synthetic */ String f2089c;

        /* renamed from: d */
        final /* synthetic */ String f2090d;

        /* renamed from: e */
        final /* synthetic */ String f2091e;

        /* renamed from: f */
        final /* synthetic */ OnCurrentStateCallBack f2092f;

        /* renamed from: g */
        final /* synthetic */ boolean f2093g;

        /* renamed from: h */
        final /* synthetic */ String f2094h;

        /* renamed from: i */
        final /* synthetic */ String f2095i;

        /* renamed from: j */
        final /* synthetic */ String f2096j;

        /* renamed from: k */
        final /* synthetic */ String f2097k;

        C12593(Activity activity, String str, String str2, String str3, String str4, OnCurrentStateCallBack onCurrentStateCallBack, boolean z, String str5, String str6, String str7, String str8) {
            this.f2087a = activity;
            this.f2088b = str;
            this.f2089c = str2;
            this.f2090d = str3;
            this.f2091e = str4;
            this.f2092f = onCurrentStateCallBack;
            this.f2093g = z;
            this.f2094h = str5;
            this.f2095i = str6;
            this.f2096j = str7;
            this.f2097k = str8;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z) {
            OnCurrentStateCallBack onCurrentStateCallBack;
            if (!z) {
                onCurrentStateCallBack = this.f2092f;
                if (onCurrentStateCallBack == null) {
                    return;
                }
            } else if (!AcseHelpManager.isOPenPermission()) {
                C1431o.m56817a(this.f2087a, this.f2088b, this.f2089c, this.f2090d, this.f2091e, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = C12593.this.f2092f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        C12593 c12593 = C12593.this;
                        if (c12593.f2093g) {
                            AcseHelpManager.showWarningDialog(c12593.f2087a, c12593.f2094h, c12593.f2095i, c12593.f2096j, c12593.f2097k, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12593.this.f2092f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12593.this.f2092f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = C12593.this.f2092f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = c12593.f2092f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = C12593.this.f2092f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            } else {
                onCurrentStateCallBack = this.f2092f;
                if (onCurrentStateCallBack == null) {
                    return;
                }
            }
            onCurrentStateCallBack.onState("0");
        }
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class InitSdk {

        /* renamed from: a */
        private Application f2103a;

        public void build() {
            new AcseHelpManager(this);
            HelpShopAppUtil.init(AcseHelpManager.mContext);
            AcseHelpManager.access$200();
            Application application = AcseHelpManager.mContext;
            if (!(application instanceof Application)) {
                throw new Error("shophelp SDK init activity manager throw a Error");
            }
            C1658aa.m56108a(application);
        }

        public InitSdk isInitWebView(boolean z) {
            Application application = this.f2103a;
            if (application != null && z) {
                AcseHelpManager.setWebViewProcess(application);
            }
            return this;
        }

        public InitSdk setContext(Application application) {
            this.f2103a = application;
            return this;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnAccessiblityStateCallBack {
        void onSuccess(String str);
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnClickCallBack {
        void onClose();

        void onDismiss();

        void onOpen();
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnCurrentStateCallBack {
        void onState(String str);
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnOpenPermission {
        void openPermission(boolean z);
    }

    private AcseHelpManager(InitSdk initSdk) {
        mContext = initSdk.f2103a;
    }

    static /* synthetic */ boolean access$200() {
        return isApkInDebug();
    }

    public static boolean checkAccessiblityState() {
        return C1684n.m55975c().m55965e();
    }

    public static boolean checkBatteryPermission() {
        if (!"".equals(CommonUtil.PACKAGE_NAME) && Build.VERSION.SDK_INT >= 28) {
            return C1533k.m56493a().m56489b(CommonUtil.PACKAGE_NAME);
        }
        return true;
    }

    public static boolean checkFloatWindow() {
        return C1684n.m55975c().m55984b();
    }

    public static void closeAccessiblityPlugIn(Activity activity, OnClickCallBack onClickCallBack) {
        C1423h.m56827a(activity, "关闭辅助功能:", "关闭辅助功能不会影响软件正常使用。但辅助功能可以优化运动轨迹，并能提高软件的稳定性，以及自动查找优惠信息。是否仍要关闭？", "保持开启", "关闭辅助", onClickCallBack);
    }

    public static void closeAccessiblityPlugIn(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        C1423h.m56827a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void close_remind() {
        C1685na.m55943b().m55947a();
    }

    public static void customDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        C1423h.m56827a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static String getGoodsWelfare() {
        return C1663ca.m56080c().m56085a();
    }

    public static void getGoodsWelfare(C1685na.InterfaceC1686a interfaceC1686a) {
        C1685na.m55943b().m55945a(interfaceC1686a);
    }

    public static String getPluninId() {
        return C1684n.m55975c().m55970d();
    }

    private static String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static boolean isApkInDebug() {
        try {
            boolean z = (mContext.getApplicationInfo().flags & 2) != 0 && mContext.getPackageName().equals(CommonUtil.APP_PACKAGE_NAME);
            mIsDebug = z;
            return z;
        } catch (Exception unused) {
            return mIsDebug;
        }
    }

    public static boolean isOPenAllPermission() {
        if (C1710ya.m55883a().m55878d()) {
            return C1684n.m55975c().m55965e() && C1684n.m55975c().m55984b() && C1533k.m56493a().m56489b(CommonUtil.PACKAGE_NAME);
        }
        return true;
    }

    public static void isOPenPermission(final OnOpenPermission onOpenPermission) {
        isShowRunningDialog(new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.1
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z) {
                boolean z2 = true;
                if (z && C1663ca.m56080c().m56077f() && (!C1684n.m55975c().m55965e() || !C1684n.m55975c().m55984b())) {
                    z2 = false;
                }
                OnOpenPermission.this.openPermission(z2);
            }
        });
    }

    public static boolean isOPenPermission() {
        if (C1663ca.m56080c().m56077f()) {
            int m56090b = C1661ba.m56097a() != null ? C1661ba.m56097a().m56090b("location_permission_size") : 0;
            if (!C1684n.m55975c().m55965e() || !C1684n.m55975c().m55984b()) {
                return false;
            }
            if ((!C1692qa.m55930a().m55928a(mContext) || !C1692qa.m55930a().m55925b(mContext)) && m56090b <= 2) {
                return false;
            }
        }
        return true;
    }

    public static void isShowRunningDialog(OnOpenPermission onOpenPermission) {
        C1685na.m55943b().m55942b(onOpenPermission);
    }

    public static void openAccessiblityDialog(Activity activity, OnClickCallBack onClickCallBack) {
        C1423h.m56827a(activity, "提示:", "需要启用辅助功能，才能为您一键开启必要权限。", "立即开启", "再想想", onClickCallBack);
    }

    public static void openAccessiblityView(Activity activity) {
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static void openBatteryPermission(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openFloatWindow(Activity activity) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    public static void openWithOneButton(final Activity activity, final int i, final OnCurrentStateCallBack onCurrentStateCallBack) {
        if (isOPenPermission()) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("5");
            }
        } else if (CommonUtil.CURRENT_ACCESSIBLITY_CLOSE.equals(Boolean.valueOf(C1684n.m55975c().m55965e()))) {
            openAccessiblityDialog(activity, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.4
                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                public void onClose() {
                    OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                    if (onCurrentStateCallBack2 != null) {
                        onCurrentStateCallBack2.onState("02");
                    }
                }

                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                public void onDismiss() {
                    OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                    if (onCurrentStateCallBack2 != null) {
                        onCurrentStateCallBack2.onState("03");
                    }
                }

                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                public void onOpen() {
                    OnCurrentStateCallBack onCurrentStateCallBack2 = OnCurrentStateCallBack.this;
                    if (onCurrentStateCallBack2 != null) {
                        onCurrentStateCallBack2.onState("01");
                    }
                    AcseHelpManager.setGoodsWelfare(CommonUtil.CURRENT_ACCESSIBLITY_OPEN);
                    AcseHelpManager.startAccessibilityIntroduceActivityForResult(activity, i);
                }
            });
        } else {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("4");
            }
            startAccessibilityIntroduceActivityForResult(activity, i);
        }
    }

    public static void running(Activity activity, boolean z, boolean z2, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (Build.VERSION.SDK_INT >= 28) {
            isShowRunningDialog(new C12562(z2, activity, onCurrentStateCallBack, z));
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("0");
        }
    }

    public static void setGoodsWelfare(String str) {
        C1685na.m55943b().m55944a(str);
    }

    public static void setOpenWithOneButtonColorState(Activity activity, OnCurrentStateCallBack onCurrentStateCallBack) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            if (!isOPenPermission()) {
                if (onCurrentStateCallBack != null) {
                    str = "1";
                    onCurrentStateCallBack.onState(str);
                }
                return;
            } else if (onCurrentStateCallBack == null) {
                return;
            }
        } else if (onCurrentStateCallBack == null) {
            return;
        }
        str = "0";
        onCurrentStateCallBack.onState(str);
    }

    public static void setWebViewProcess(Application application) {
        String processName = getProcessName(application);
        if (application.getPackageName().equals(processName) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WebView.setDataDirectorySuffix(processName);
    }

    public static void showFrequentOperationDialog(Activity activity, OnClickCallBack onClickCallBack) {
        C1414L.m56839a(activity, onClickCallBack);
    }

    public static void showRunningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        C1431o.m56818a(activity, onClickCallBack);
    }

    public static void showRunningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        C1431o.m56817a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void showSQJLDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (!activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME)) {
            activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME);
        }
        C1431o.m56818a(activity, onClickCallBack);
    }

    public static void showSQJLDialog(Activity activity, boolean z, OnClickCallBack onClickCallBack) {
        C1431o.m56815a(activity, z, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        C1414L.m56839a(activity, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        C1414L.m56838a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void startAccessibilityIntroduceActivityForResult(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, AccessibiltyTsnPermissionGreenActivity.class), i);
    }

    public static void startRunning(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (Build.VERSION.SDK_INT >= 28) {
            isShowRunningDialog(new C12593(activity, str, str2, str3, str4, onCurrentStateCallBack, z, str5, str6, str7, str8));
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("0");
        }
    }

    public static void startRunning(Activity activity, boolean z, OnCurrentStateCallBack onCurrentStateCallBack) {
        running(activity, z, false, onCurrentStateCallBack);
    }

    public static void startRunning(Activity activity, boolean z, boolean z2, OnCurrentStateCallBack onCurrentStateCallBack) {
        running(activity, z, z2, onCurrentStateCallBack);
    }

    public static void syncUserIdState(String str) {
        C1684n.m55975c().m55986a(str);
        C1684n.m55975c().m55976b(str);
    }
}
