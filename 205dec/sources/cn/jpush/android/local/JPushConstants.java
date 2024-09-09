package cn.jpush.android.local;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ad.a;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.x.b;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushConstants {
    public static int BUILD_ID = 391;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final int FORE_GROUND = 0;
    public static final int FORE_GROUND_NO = 1;
    public static final int FORE_GROUND_UNKNOWN = -1;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static final boolean IG = false;
    public static boolean IS_HB_PERIOD_ENABLE = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JPUSH";
    public static int SDK_VERSION_CODE = 540;
    public static String SDK_VERSION_NAME = "5.4.0";
    public static boolean SUPPORT_DY = true;
    private static final String TAG = "JPushConstants";
    public static boolean THIRD_ENABLE = true;
    private static final String USER_MESSAGE_RECEIVER_ACTION = "cn.jpush.android.intent.RECEIVER_MESSAGE";
    private static Bundle configBundle = null;
    public static int isForeGround = -1;
    private static boolean isInitLife;
    private static Boolean isSameProcessWithJCommonReceiver;
    private static boolean isTestAndroidQ;
    private static JPushMessageReceiver jPushMessageReceiver;
    public static Context mApplicationContext;
    private static String messageReceiverClass;
    private static String messageReceiverProcess;
    private static boolean tcpConnected;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class TEST_CONFIG {
        public static String TEST_FILE_URL = "";
        public static String TEST_FILE_VERSION = "";
    }

    public static boolean canGetLbsInBackGround(Context context) {
        String str;
        if (isAndroidQ(context, true, "canGetLbsInBackGround")) {
            if (isForeGround != 1 || a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                str = (isForeGround == -1 && !a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION" : "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION";
            } else {
                str = "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            Logger.ww(TAG, str);
            return false;
        }
        return true;
    }

    public static void changeForegroudStat(Context context, boolean z3) {
        Logger.d(TAG, "changeForegroudStat:" + z3);
        isForeGround = !z3 ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z3);
        JCoreHelper.runActionWithService(context, SDK_TYPE, "change_foreground", bundle);
    }

    private static void defaultRegister(Context context, ActivityLifeCallBack activityLifeCallBack) {
        Activity j4;
        if (context instanceof Application) {
            String c4 = a.c(context);
            String packageName = context.getPackageName();
            if (c4 == null || packageName == null || !context.getPackageName().equals(c4)) {
                Logger.d(TAG, "need not initPageLifecycle in other process :" + c4);
                d dVar = new d();
                dVar.f4141r = 1;
                b.a(context, "sync_reg_lifecycle", dVar, (Intent) null);
                return;
            }
            ((Application) context).registerActivityLifecycleCallbacks(activityLifeCallBack);
            if (ActivityLifeCallBack.activityTaskCount == 0 && (j4 = a.j(context)) != null) {
                activityLifeCallBack.onActivityCreated(j4, null);
                activityLifeCallBack.onActivityStarted(j4);
                activityLifeCallBack.onActivityResumed(j4);
            }
            Logger.d(TAG, "initPageLifecycle in main process, packageName:" + packageName + ", currentProcessName:" + c4);
        }
    }

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return mApplicationContext;
    }

    public static Bundle getBundle() {
        return configBundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d1, code lost:
        cn.jpush.android.local.JPushConstants.messageReceiverClass = r4;
        cn.jpush.android.local.JPushConstants.messageReceiverProcess = r3.activityInfo.processName;
        cn.jpush.android.helper.Logger.ii(cn.jpush.android.local.JPushConstants.TAG, "found messageReceiverClass :" + cn.jpush.android.local.JPushConstants.messageReceiverClass + " at " + cn.jpush.android.local.JPushConstants.messageReceiverProcess + " by getCommonReceiverNames");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00fc, code lost:
        r0 = cn.jpush.android.local.JPushConstants.messageReceiverProcess;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00fe, code lost:
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0108, code lost:
        if (r0.equals(cn.jpush.android.ad.a.c(r11)) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010a, code lost:
        cn.jpush.android.local.JPushConstants.jPushMessageReceiver = (cn.jpush.android.service.JPushMessageReceiver) r5.newInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMessageReceiverClass(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.getMessageReceiverClass(android.content.Context):java.lang.String");
    }

    public static JPushMessageReceiver getPushMessageReceiver(Context context) {
        getMessageReceiverClass(getAppContext(context));
        return jPushMessageReceiver;
    }

    public static void init(Context context) {
        initPageLifecycle(context);
    }

    private static void initPageLifecycle(Context context) {
        if (context == null) {
            Logger.w(TAG, "[initPageLifecycle] context is null");
            return;
        }
        Logger.d(TAG, "initPageLifecycle init, isInitLife: " + isInitLife);
        if (isInitLife) {
            return;
        }
        StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            isInitLife = true;
            JCoreManager.addActivityLifeCallback(new ActivityLifeCallBack());
            Logger.d(TAG, "initPageLifecycle init to JCore ");
        } catch (Throwable th) {
            Logger.ww(TAG, "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isAndroidQ(android.content.Context r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            r2 = 28
            if (r4 != 0) goto L16
            boolean r3 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r3 == 0) goto Lf
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r2) goto L14
            goto L2b
        Lf:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L14
            goto L2b
        L14:
            r0 = 0
            goto L2b
        L16:
            boolean r4 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r4 == 0) goto L1f
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r2) goto L14
            goto L23
        L1f:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 <= r2) goto L14
        L23:
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            if (r3 <= r2) goto L14
        L2b:
            if (r0 == 0) goto L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "is Android Q, msg: "
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "JPushConstants"
            cn.jpush.android.helper.Logger.d(r4, r3)
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean isSameProcessWithJCommonService(Context context) {
        Boolean bool;
        try {
            Boolean bool2 = isSameProcessWithJCommonReceiver;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (messageReceiverProcess == null) {
                getMessageReceiverClass(context);
            }
            ComponentInfo a4 = a.a(context, context.getPackageName(), JCommonService.class);
            if (a4 != null) {
                if (a4.processName.equals(messageReceiverProcess)) {
                    Logger.dd(TAG, "same process with JCommonService");
                    bool = Boolean.TRUE;
                } else {
                    Logger.dd(TAG, "is not same process with JCommonService");
                    bool = Boolean.FALSE;
                }
                isSameProcessWithJCommonReceiver = bool;
                return isSameProcessWithJCommonReceiver.booleanValue();
            }
            return false;
        } catch (Throwable th) {
            Logger.w(TAG, "call isSameProcessWithJCommonService failed:" + th.getMessage());
            return false;
        }
    }

    public static boolean isTcpConnected() {
        return tcpConnected;
    }

    public static void setBundle(Bundle bundle) {
        configBundle = bundle;
    }

    public static void setTcpConnected(boolean z3) {
        tcpConnected = z3;
    }

    public static void testAndroidQ() {
    }
}
