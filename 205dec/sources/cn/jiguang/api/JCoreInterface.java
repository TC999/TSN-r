package cn.jiguang.api;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jiguang.cl.a;
import cn.jiguang.cl.b;
import cn.jiguang.cl.c;
import cn.jiguang.cl.d;
import cn.jiguang.cl.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JCoreInterface {
    public static String DAEMON_ACTION = "cn.jpush.android.intent.DaemonService";
    private static final String TAG = "JCoreInterface";
    private static Context mApplicationContext;

    public static void asyncExecute(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 12, null, null, runnable);
    }

    public static boolean canCallDirect() {
        return false;
    }

    public static void ci(Context context, boolean z3) {
        JCoreManager.onEvent(context, null, 120, null, null, Boolean.valueOf(z3));
    }

    public static void execute(String str, Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 11, str, null, runnable);
    }

    public static JSONObject fillBaseReport(JSONObject jSONObject, String str) {
        Object onEvent = JCoreManager.onEvent(null, null, 26, null, null, jSONObject, str);
        if (onEvent instanceof JSONObject) {
            return (JSONObject) onEvent;
        }
        return null;
    }

    public static String getAccountId() {
        Object onEvent = JCoreManager.onEvent(null, null, 5, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getAppKey() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 7, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getChannel() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 6, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getCommonConfigAppkey() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 7, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static boolean getConnectionState(Context context) {
        return JCoreManager.getConnectionState(mApplicationContext);
    }

    public static String getDaemonAction() {
        return DAEMON_ACTION;
    }

    public static boolean getDebugMode() {
        return JCoreManager.getDebugMode();
    }

    public static String getDeviceId(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 8, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getHttpConfig(Context context, String str) {
        return "";
    }

    public static int getJCoreSDKVersionInt() {
        Object onEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
        if (onEvent instanceof Integer) {
            return ((Integer) onEvent).intValue();
        }
        return 0;
    }

    public static long getNextRid() {
        return e.b(mApplicationContext);
    }

    public static String getRegistrationID(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 4, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static long getReportTime() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 19, null, null, new Object[0]);
        return onEvent instanceof Long ? ((Long) onEvent).longValue() : System.currentTimeMillis() / 1000;
    }

    public static boolean getRuningFlag() {
        try {
            return Build.BRAND.equals("nubia");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int getSid() {
        return 0;
    }

    public static long getUid() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 20, null, null, new Object[0]);
        if (onEvent instanceof Long) {
            return ((Long) onEvent).longValue();
        }
        return 0L;
    }

    public static boolean init(Context context, boolean z3) {
        if (context != null) {
            mApplicationContext = context;
        }
        JCoreManager.init(context);
        return true;
    }

    public static void initAction(String str, Class<? extends JAction> cls) {
        a.a().a(str, cls.getName());
    }

    public static void initActionExtra(String str, Class<? extends JActionExtra> cls) {
        a.a().b(str, cls.getName());
    }

    public static void initCrashHandler(Context context) {
        JCoreManager.initCrashHandler(context);
    }

    public static boolean isTcpConnected() {
        return JCoreManager.getConnectionState(mApplicationContext);
    }

    public static boolean isValidRegistered() {
        Object onEvent = JCoreManager.onEvent(mApplicationContext, null, 21, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static void onFragmentPause(Context context, String str) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "f_pause", null, str);
    }

    public static void onFragmentResume(Context context, String str) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "f_resume", null, str);
    }

    public static void onKillProcess(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "kill", null, new Object[0]);
    }

    public static void onPause(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, CampaignEx.JSON_NATIVE_VIDEO_PAUSE, null, new Object[0]);
    }

    public static void onResume(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, CampaignEx.JSON_NATIVE_VIDEO_RESUME, null, new Object[0]);
    }

    public static void processCtrlReport(int i4) {
        JCoreManager.onEvent(null, null, 24, null, null, Integer.valueOf(i4));
    }

    public static void putSingleExecutor(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static void register(Context context) {
        d.b(TAG, "Action - init registerOnly:");
        if (context != null) {
            mApplicationContext = context;
        }
        JCoreManager.init(context);
    }

    public static void report(Context context, JSONObject jSONObject, boolean z3) {
        JCoreManager.onEvent(context, "JSupport", 14, null, null, jSONObject);
    }

    public static boolean reportHttpData(Context context, Object obj, String str) {
        JCoreManager.onEvent(context, str, 14, null, null, obj);
        return true;
    }

    public static void requestPermission(Context context) {
        JCoreManager.requestPermission(context);
    }

    public static void restart(Context context, String str, Bundle bundle, boolean z3) {
        JCoreManager.onEvent(context, str, 1, null, null, new Object[0]);
    }

    private static void send(Context context, String str, int i4, byte[] bArr, int i5, boolean z3) {
        if (bArr != null) {
            try {
                if (bArr.length > 24) {
                    byte[] bArr2 = new byte[24];
                    byte[] bArr3 = new byte[bArr.length - 24];
                    System.arraycopy(bArr, 0, bArr2, 0, 24);
                    System.arraycopy(bArr, 24, bArr3, 0, bArr.length - 24);
                    c cVar = new c(true, bArr2);
                    Bundle bundle = new Bundle();
                    bundle.putInt("cmd", cVar.a());
                    bundle.putInt("ver", cVar.e());
                    bundle.putLong("rid", cVar.b().longValue());
                    bundle.putLong("timeout", i5);
                    bundle.putByteArray("body", bArr3);
                    JCoreManager.onEvent(context, str, z3 ? 17 : 50, null, bundle, new Object[0]);
                }
            } catch (Throwable th) {
                d.e(TAG, "send failed:" + th.getMessage());
            }
        }
    }

    public static void sendAction(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                JCoreManager.onEvent(context, str, 3, bundle.getString("action"), bundle, new Object[0]);
            } catch (Throwable th) {
                d.e(TAG, "sendAction failed:" + th);
            }
        }
    }

    public static void sendData(Context context, String str, int i4, byte[] bArr) {
        send(context, str, i4, bArr, 0, false);
    }

    public static void sendRequestData(Context context, String str, int i4, byte[] bArr) {
        send(context, str, 0, bArr, i4, true);
    }

    public static void setAccountId(String str) {
        JCoreManager.onEvent(null, null, 22, str, null, new Object[0]);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        if (jAnalyticsAction != null) {
            JCoreManager.setAnalysisAction(jAnalyticsAction);
        }
    }

    public static void setCanLaunchedStoppedService(boolean z3) {
    }

    public static void setDaemonAction(String str) {
        DAEMON_ACTION = str;
    }

    public static void setDebugMode(boolean z3) {
        JCoreManager.setDebugMode(z3);
    }

    public static void setImLBSEnable(Context context, boolean z3) {
        d.b(TAG, "action - setImLBSEnable-control");
        JCoreManager.setLBSEnable(context, z3);
    }

    public static void setLocationReportDelay(Context context, long j4) {
        JCoreManager.onEvent(context, null, 28, null, null, Long.valueOf(j4));
    }

    public static void setPowerSaveMode(Context context, boolean z3) {
    }

    public static void setTestConn(boolean z3) {
    }

    public static void setTestConnIPPort(String str, int i4) {
        d.b(TAG, "Action - setTestConnIPPort ip:" + str + " port:" + i4);
    }

    public static void setWakeEnable(Context context, boolean z3) {
        JCoreManager.onEvent(context, null, 73, null, null, Boolean.valueOf(z3));
    }

    public static Bundle si(Context context, int i4, Bundle bundle) {
        if (context != null) {
            mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return b.a(context, i4, bundle);
    }

    public static void stop(Context context, String str, Bundle bundle) {
        JCoreManager.onEvent(context, str, 0, null, null, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        JCoreManager.stopCrashHandler(context);
    }

    public static void testCountryCode(Context context, String str) {
        JCoreManager.onEvent(context, null, 23, str, null, new Object[0]);
    }

    public static void triggerSceneCheck(Context context, int i4) {
        JCoreManager.onEvent(context, null, 29, null, null, Integer.valueOf(i4));
    }
}
