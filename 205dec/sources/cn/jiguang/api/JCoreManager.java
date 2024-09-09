package cn.jiguang.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jiguang.bk.f;
import cn.jiguang.bq.d;
import cn.jiguang.c.b;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JCoreManager {
    private static final String TAG = "JCoreManager";
    private static final AtomicBoolean isInited = new AtomicBoolean();

    public static void addActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.a(activityLifecycleCallbacks);
    }

    public static void addDispatchAction(String str, String str2) {
        a.a(str, str2);
    }

    public static void changeLiveStatus(boolean z3) {
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object onEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static void init(Context context) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        if (!cn.jiguang.cn.a.a()) {
            d.l(TAG, "user don't auth, so return init");
            return;
        }
        JConstants.isCallInit.set(true);
        AtomicBoolean atomicBoolean = isInited;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        try {
            if (f.a(appContext)) {
                atomicBoolean.set(false);
                JConstants.isCallInit.set(false);
                return;
            }
            a.a(appContext);
            JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return false;
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    public static Object onEvent(Context context, String str, int i4, String str2, Bundle bundle, Object... objArr) {
        boolean z3;
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 18:
            case 19:
            case 20:
            case 21:
            case 25:
            case 26:
            case 32:
            case 33:
            case 34:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 49:
            case 52:
            case 53:
            case 58:
            case 60:
            case 63:
            case 64:
            case 67:
            case 68:
            case 69:
            case 75:
            case 76:
            case 77:
            case 78:
            case 82:
            case 83:
            case 90:
            case 91:
            case 92:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 108:
            case 109:
            case 110:
            case 119:
            case 120:
            case 121:
            case 123:
                z3 = false;
                break;
            default:
                z3 = true;
                break;
        }
        return onEvent(context, str, i4, z3, str2, bundle, objArr);
    }

    public static Object onEvent(Context context, String str, int i4, boolean z3, String str2, Bundle bundle, Object... objArr) {
        if (!b.f3194a.contains(Integer.valueOf(i4))) {
            if (96 == i4) {
                try {
                    boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                    d.d(TAG, "saveAuth\uff1a" + booleanValue);
                    cn.jiguang.cn.a.a(booleanValue, true);
                } catch (Throwable unused) {
                }
            }
            init(context);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i4, z3, str2, bundle, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0040, B:14:0x0046, B:9:0x0019), top: B:19:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #0 {all -> 0x006b, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:10:0x001b, B:12:0x0040, B:14:0x0046, B:9:0x0019), top: B:19:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void register(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = cn.jiguang.bk.a.b(r11)     // Catch: java.lang.Throwable -> L6b
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = "JCoreManager"
            if (r1 != 0) goto L19
            boolean r0 = r0.equals(r12)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L13
            goto L19
        L13:
            java.lang.String r0 = "[register] not same appkey with manifest,please check it"
            cn.jiguang.bq.d.j(r2, r0)     // Catch: java.lang.Throwable -> L6b
            goto L1b
        L19:
            cn.jiguang.internal.JConstants.APP_KEY = r12     // Catch: java.lang.Throwable -> L6b
        L1b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r0.<init>()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = "[register]  appkey ="
            r0.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = cn.jiguang.internal.JConstants.APP_KEY     // Catch: java.lang.Throwable -> L6b
            r0.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = " originKep="
            r0.append(r1)     // Catch: java.lang.Throwable -> L6b
            r0.append(r12)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6b
            cn.jiguang.bq.d.e(r2, r0)     // Catch: java.lang.Throwable -> L6b
            boolean r0 = cn.jiguang.bk.f.a(r11)     // Catch: java.lang.Throwable -> L6b
            r1 = 0
            if (r0 == 0) goto L46
            java.util.concurrent.atomic.AtomicBoolean r11 = cn.jiguang.internal.JConstants.isCallInit     // Catch: java.lang.Throwable -> L6b
            r11.set(r1)     // Catch: java.lang.Throwable -> L6b
            return
        L46:
            java.util.concurrent.atomic.AtomicBoolean r0 = cn.jiguang.internal.JConstants.isCallInit     // Catch: java.lang.Throwable -> L6b
            r2 = 1
            r0.set(r2)     // Catch: java.lang.Throwable -> L6b
            cn.jiguang.d.a.a(r11)     // Catch: java.lang.Throwable -> L6b
            android.os.Bundle r9 = new android.os.Bundle     // Catch: java.lang.Throwable -> L6b
            r9.<init>()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r0 = "appkey"
            r9.putString(r0, r12)     // Catch: java.lang.Throwable -> L6b
            cn.jiguang.internal.JCoreInternalHelper r3 = cn.jiguang.internal.JCoreInternalHelper.getInstance()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "JCore"
            r6 = 10
            r7 = 1
            java.lang.String r8 = "a5"
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6b
            r4 = r11
            r3.onEvent(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6b
            goto L6f
        L6b:
            r11 = move-exception
            r11.printStackTrace()
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JCoreManager.register(android.content.Context, java.lang.String):void");
    }

    public static void removeActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.b(activityLifecycleCallbacks);
    }

    public static void reportWakedData(Context context, Bundle bundle, int i4) {
        if (context == null) {
            d.j(TAG, "[reportWakedData] context was null");
        } else if (bundle == null) {
            d.j(TAG, "[reportWakedData] bundle was null");
        } else {
            int i5 = bundle.getInt("type", -1);
            if (i5 != -1) {
                i4 = i5;
            }
            if (i4 != 8 && i4 != 16) {
                d.j(TAG, "[reportWakedData] wrong type:" + i4);
                return;
            }
            bundle.putInt("type", i4);
            d.c(TAG, "action - reportWakedData" + bundle.toString());
            onEvent(context, null, 74, null, bundle, new Object[0]);
        }
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (context instanceof Activity) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 23) {
                str = "[requestPermission] android.os.Build.VERSION.SDK_INT<23";
            } else if (context.getApplicationInfo().targetSdkVersion >= 23) {
                if (i4 < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
                    return;
                }
                try {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    linkedList.add("android.permission.READ_EXTERNAL_STORAGE");
                    linkedList.add("android.permission.ACCESS_FINE_LOCATION");
                    linkedList.add("android.permission.READ_PHONE_STATE");
                    if (JConstants.isAndroidQ(context, false, "will request background location permission")) {
                        linkedList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    }
                    List<String> a4 = cn.jiguang.f.a.a(context, linkedList);
                    if (a4 != null && !a4.isEmpty()) {
                        d.a(TAG, "lackPermissions:" + a4);
                        Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a4.toArray(new String[a4.size()]), 1);
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    d.j(TAG, "#unexcepted - requestPermission e:" + e4);
                    return;
                }
            } else {
                str = "[requestPermission] app targetSdkVersion<23";
            }
        } else {
            str = "[requestPermission] context must instanceof Activity";
        }
        d.j(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z3) {
        JConstants.DEBUG_MODE = z3;
    }

    public static void setLBSEnable(Context context, boolean z3) {
        d.c(TAG, "action - setLBSEnable-control:" + z3);
        if (!z3) {
            try {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.Y().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z3));
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }

    public static void unRegister(Context context) {
        JConstants.isCallInit.set(true);
        a.a(context);
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a23", null, new Object[0]);
    }
}
