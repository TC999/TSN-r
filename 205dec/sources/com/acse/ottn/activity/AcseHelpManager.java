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
import com.acse.ottn.f1;
import com.acse.ottn.g1;
import com.acse.ottn.h1;
import com.acse.ottn.j0;
import com.acse.ottn.k1;
import com.acse.ottn.m3;
import com.acse.ottn.n0;
import com.acse.ottn.p4;
import com.acse.ottn.q4;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.w2;
import com.acse.ottn.y1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AcseHelpManager {
    public static Application mContext;
    public static boolean mIsDebug;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: com.acse.ottn.activity.AcseHelpManager$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class AnonymousClass2 implements OnOpenPermission {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f4636a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f4637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OnCurrentStateCallBack f4638c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f4639d;

        public AnonymousClass2(boolean z3, Activity activity, OnCurrentStateCallBack onCurrentStateCallBack, boolean z4) {
            this.f4636a = z3;
            this.f4637b = activity;
            this.f4638c = onCurrentStateCallBack;
            this.f4639d = z4;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z3) {
            if (!z3 && !this.f4636a) {
                OnCurrentStateCallBack onCurrentStateCallBack = this.f4638c;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                }
            } else if (!AcseHelpManager.isOPenPermission()) {
                AcseHelpManager.showRunningDialog(this.f4637b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.2.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass2.this.f4638c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (anonymousClass2.f4639d) {
                            AcseHelpManager.showWarningDialog(anonymousClass2.f4637b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.2.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass2.this.f4638c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass2.this.f4638c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass2.this.f4638c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = anonymousClass2.f4638c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass2.this.f4638c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
            } else {
                OnCurrentStateCallBack onCurrentStateCallBack2 = this.f4638c;
                if (onCurrentStateCallBack2 != null) {
                    onCurrentStateCallBack2.onState("0");
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: com.acse.ottn.activity.AcseHelpManager$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class AnonymousClass3 implements OnOpenPermission {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f4642a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4643b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4644c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4645d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnCurrentStateCallBack f4647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f4648g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4649h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4650i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4651j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f4652k;

        public AnonymousClass3(Activity activity, String str, String str2, String str3, String str4, OnCurrentStateCallBack onCurrentStateCallBack, boolean z3, String str5, String str6, String str7, String str8) {
            this.f4642a = activity;
            this.f4643b = str;
            this.f4644c = str2;
            this.f4645d = str3;
            this.f4646e = str4;
            this.f4647f = onCurrentStateCallBack;
            this.f4648g = z3;
            this.f4649h = str5;
            this.f4650i = str6;
            this.f4651j = str7;
            this.f4652k = str8;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z3) {
            if (z3) {
                if (!AcseHelpManager.isOPenPermission()) {
                    m3.a(this.f4642a, this.f4643b, this.f4644c, this.f4645d, this.f4646e, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1
                        @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                        public void onClose() {
                            OnCurrentStateCallBack onCurrentStateCallBack = AnonymousClass3.this.f4647f;
                            if (onCurrentStateCallBack != null) {
                                onCurrentStateCallBack.onState("4");
                            }
                        }

                        @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                        public void onDismiss() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            if (anonymousClass3.f4648g) {
                                AcseHelpManager.showWarningDialog(anonymousClass3.f4642a, anonymousClass3.f4649h, anonymousClass3.f4650i, anonymousClass3.f4651j, anonymousClass3.f4652k, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1.1
                                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                    public void onClose() {
                                        OnCurrentStateCallBack onCurrentStateCallBack = AnonymousClass3.this.f4647f;
                                        if (onCurrentStateCallBack != null) {
                                            onCurrentStateCallBack.onState("4");
                                        }
                                    }

                                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                    public void onDismiss() {
                                        OnCurrentStateCallBack onCurrentStateCallBack = AnonymousClass3.this.f4647f;
                                        if (onCurrentStateCallBack != null) {
                                            onCurrentStateCallBack.onState("3");
                                        }
                                    }

                                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                    public void onOpen() {
                                        OnCurrentStateCallBack onCurrentStateCallBack = AnonymousClass3.this.f4647f;
                                        if (onCurrentStateCallBack != null) {
                                            onCurrentStateCallBack.onState("2");
                                        }
                                    }
                                });
                                return;
                            }
                            OnCurrentStateCallBack onCurrentStateCallBack = anonymousClass3.f4647f;
                            if (onCurrentStateCallBack != null) {
                                onCurrentStateCallBack.onState("0");
                            }
                        }

                        @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                        public void onOpen() {
                            OnCurrentStateCallBack onCurrentStateCallBack = AnonymousClass3.this.f4647f;
                            if (onCurrentStateCallBack != null) {
                                onCurrentStateCallBack.onState("1");
                            }
                        }
                    });
                    return;
                }
                OnCurrentStateCallBack onCurrentStateCallBack = this.f4647f;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                    return;
                }
                return;
            }
            OnCurrentStateCallBack onCurrentStateCallBack2 = this.f4647f;
            if (onCurrentStateCallBack2 != null) {
                onCurrentStateCallBack2.onState("0");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class InitSdk {

        /* renamed from: a  reason: collision with root package name */
        public Application f4658a;

        public void build() {
            new AcseHelpManager(this);
            HelpShopAppUtil.init(AcseHelpManager.mContext);
            AcseHelpManager.access$200();
            Application application = AcseHelpManager.mContext;
            if (application instanceof Application) {
                f1.a(application);
                return;
            }
            throw new Error("shophelp SDK init activity manager throw a Error");
        }

        public InitSdk isInitWebView(boolean z3) {
            Application application = this.f4658a;
            if (application != null && z3) {
                AcseHelpManager.setWebViewProcess(application);
            }
            return this;
        }

        public InitSdk setContext(Application application) {
            this.f4658a = application;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnAccessiblityStateCallBack {
        void onSuccess(String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnClickCallBack {
        void onClose();

        void onDismiss();

        void onOpen();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnCurrentStateCallBack {
        void onState(String str);
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnIndividuationCallBack {
        void onIndividuationState(boolean z3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnOpenPermission {
        void openPermission(boolean z3);
    }

    public static /* synthetic */ boolean access$200() {
        return isApkInDebug();
    }

    public static boolean checkAccessiblityState() {
        return com.acse.ottn.b.d().f();
    }

    public static boolean checkBatteryPermission() {
        if (!"".equals(j0.f5781w) && Build.VERSION.SDK_INT >= 28) {
            return q4.a().b(j0.f5781w);
        }
        return true;
    }

    public static boolean checkFloatWindow() {
        return com.acse.ottn.b.d().b();
    }

    public static void closeAccessiblityPlugIn(Activity activity, OnClickCallBack onClickCallBack) {
        n0.a(activity, "\u5173\u95ed\u8f85\u52a9\u529f\u80fd:", "\u5173\u95ed\u8f85\u52a9\u529f\u80fd\u4e0d\u4f1a\u5f71\u54cd\u8f6f\u4ef6\u6b63\u5e38\u4f7f\u7528\u3002\u4f46\u8f85\u52a9\u529f\u80fd\u53ef\u4ee5\u4f18\u5316\u8fd0\u52a8\u8f68\u8ff9\uff0c\u5e76\u80fd\u63d0\u9ad8\u8f6f\u4ef6\u7684\u7a33\u5b9a\u6027\uff0c\u4ee5\u53ca\u81ea\u52a8\u67e5\u627e\u4f18\u60e0\u4fe1\u606f\u3002\u662f\u5426\u4ecd\u8981\u5173\u95ed\uff1f", "\u4fdd\u6301\u5f00\u542f", "\u5173\u95ed\u8f85\u52a9", onClickCallBack);
    }

    public static void close_remind() {
        k1.b().a();
    }

    public static void customDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        n0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void getGoodsWelfare(OnIndividuationCallBack onIndividuationCallBack) {
        k1.b().a(onIndividuationCallBack);
    }

    public static String getPluninId() {
        return com.acse.ottn.b.d().e();
    }

    private static String getProcessName(Context context) {
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

    private static boolean isApkInDebug() {
        try {
            boolean z3 = (mContext.getApplicationInfo().flags & 2) != 0 && mContext.getPackageName().equals(j0.f5773o);
            mIsDebug = z3;
            return z3;
        } catch (Exception unused) {
            return mIsDebug;
        }
    }

    public static boolean isOPenAllPermission() {
        if (w2.a().d()) {
            return com.acse.ottn.b.d().f() && com.acse.ottn.b.d().b() && q4.a().b(j0.f5781w);
        }
        return true;
    }

    public static boolean isOPenPermission() {
        if (h1.c().f()) {
            int b4 = g1.a() != null ? g1.a().b("location_permission_size") : 0;
            if (!com.acse.ottn.b.d().f() || !com.acse.ottn.b.d().b()) {
                return false;
            }
            if ((!y1.a().a(mContext) || !y1.a().b(mContext)) && b4 <= 2) {
                return false;
            }
        }
        return true;
    }

    public static void isShowRunningDialog(OnOpenPermission onOpenPermission) {
        k1.b().b(onOpenPermission);
    }

    public static boolean isTargetProcess(Application application) {
        return getProcessName(application).equals(".LoadingActivity");
    }

    public static void openAccessiblityDialog(Activity activity, OnClickCallBack onClickCallBack) {
        n0.a(activity, "\u63d0\u793a:", "\u9700\u8981\u542f\u7528\u8f85\u52a9\u529f\u80fd\uff0c\u624d\u80fd\u4e3a\u60a8\u4e00\u952e\u5f00\u542f\u5fc5\u8981\u6743\u9650\u3002", "\u7acb\u5373\u5f00\u542f", "\u518d\u60f3\u60f3", onClickCallBack);
    }

    public static void openAccessiblityView(Activity activity) {
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static void openBatteryPermission(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j0.f5781w, null));
        try {
            activity.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void openFloatWindow(Activity activity) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    public static void openWithOneButton(final Activity activity, final int i4, final OnCurrentStateCallBack onCurrentStateCallBack) {
        if (isOPenPermission()) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("5");
            }
        } else if (j0.f5768j.equals(Boolean.valueOf(com.acse.ottn.b.d().f()))) {
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
                    AcseHelpManager.setGoodsWelfare(j0.f5767i);
                    AcseHelpManager.startAccessibilityIntroduceActivityForResult(activity, i4);
                }
            });
        } else {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("4");
            }
            startAccessibilityIntroduceActivityForResult(activity, i4);
        }
    }

    public static void running(Activity activity, boolean z3, boolean z4, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (Build.VERSION.SDK_INT >= 28) {
            isShowRunningDialog(new AnonymousClass2(z4, activity, onCurrentStateCallBack, z3));
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("0");
        }
    }

    public static void setGoodsWelfare(String str) {
        k1.b().a(str);
    }

    public static void setOpenWithOneButtonColorState(Activity activity, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (Build.VERSION.SDK_INT < 28) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("0");
            }
        } else if (isOPenPermission()) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("0");
            }
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("1");
        }
    }

    public static void setWebViewProcess(Application application) {
        String processName = getProcessName(application);
        if (application.getPackageName().equals(processName) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WebView.setDataDirectorySuffix(processName);
    }

    public static void showFrequentOperationDialog(Activity activity, OnClickCallBack onClickCallBack) {
        p4.a(activity, onClickCallBack);
    }

    public static void showRunningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        m3.a(activity, onClickCallBack);
    }

    public static void showSQJLDialog(Activity activity, OnClickCallBack onClickCallBack) {
        m3.a(activity, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        p4.a(activity, onClickCallBack);
    }

    public static void startAccessibilityIntroduceActivityForResult(Activity activity, int i4) {
        activity.startActivityForResult(new Intent(activity, AccessibiltyTsnPermissionGreenActivity.class), i4);
    }

    public static void startRunning(Activity activity, boolean z3, boolean z4, OnCurrentStateCallBack onCurrentStateCallBack) {
        running(activity, z3, z4, onCurrentStateCallBack);
    }

    public static void syncUserIdState(String str) {
        com.acse.ottn.b.d().a(str);
        com.acse.ottn.b.d().b(str);
    }

    private AcseHelpManager(InitSdk initSdk) {
        mContext = initSdk.f4658a;
    }

    public static void closeAccessiblityPlugIn(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        n0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static String getGoodsWelfare() {
        return h1.c().a();
    }

    public static void showRunningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        m3.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void showSQJLDialog(Activity activity, boolean z3, OnClickCallBack onClickCallBack) {
        m3.a(activity, z3, onClickCallBack);
    }

    public static void showWarningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        p4.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void startRunning(Activity activity, boolean z3, OnCurrentStateCallBack onCurrentStateCallBack) {
        running(activity, z3, false, onCurrentStateCallBack);
    }

    public static void startRunning(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z3, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (Build.VERSION.SDK_INT >= 28) {
            isShowRunningDialog(new AnonymousClass3(activity, str, str2, str3, str4, onCurrentStateCallBack, z3, str5, str6, str7, str8));
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("0");
        }
    }

    public static void isOPenPermission(final OnOpenPermission onOpenPermission) {
        isShowRunningDialog(new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.1
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z3) {
                boolean z4 = true;
                if (z3) {
                    if (h1.c().f()) {
                        OnOpenPermission.this.openPermission((com.acse.ottn.b.d().f() && com.acse.ottn.b.d().b()) ? false : false);
                        return;
                    } else {
                        OnOpenPermission.this.openPermission(true);
                        return;
                    }
                }
                OnOpenPermission.this.openPermission(true);
            }
        });
    }
}
