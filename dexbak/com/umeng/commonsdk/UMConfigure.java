package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.AutoViewPageTracker;
import com.umeng.analytics.pro.C13131bm;
import com.umeng.analytics.pro.OpenDeviceId;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.analytics.vshelper.RealTimeDebugSwitch;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.CcgSwitch;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.UMInternalDataProtocol;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.stateless.UMSLConfig;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.BusinessWrapperConfig;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.SLModeUtil;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static boolean shouldCollectAid = true;
    private static volatile boolean shouldOutputRT = false;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", UMCommonContent.f37808al};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
        } else if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
        } else {
            try {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10021);
                    return;
                }
                int ordinal = bs_type.ordinal();
                String[] strArr = BUSINESS_TYPE;
                String str2 = ordinal < strArr.length ? strArr[ordinal] : "";
                if (TextUtils.isEmpty(str2)) {
                    Log.e("UMLog", UMLogCommon.SC_10022);
                    return;
                }
                TagHelper.deleteModuleTag(str2 + "_" + str);
            } catch (Throwable unused) {
            }
        }
    }

    private static void disableAidCollect() {
        try {
            if (getClass("com.umeng.socialize.UMShareAPI") != null) {
                shouldCollectAid = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static void enableAzxSwitch(boolean z) {
        CcgSwitch.m14105a(z);
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls != null) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            if (constructor != null) {
                constructor.setAccessible(true);
                try {
                    return constructor.newInstance(new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
                return;
            }
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String m14692a = OpenDeviceId.m14692a(origApplicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(m14692a);
                }
            }
        }).start();
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(RealTimeDebugSwitch.m14110d());
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    private static boolean isSilentMode() {
        boolean m13463a = SLModeUtil.m13463a();
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + m13463a);
        return m13463a;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(C13131bm.f37936m);
        return !new File(sb.toString()).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(C13131bm.f37935l);
        return !new File(sb.toString()).exists();
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(origApplicationContext);
        AutoViewPageTracker.m14308a(origApplicationContext);
        if (!needSendZcfgEnv(origApplicationContext)) {
            FieldManager.m14036a().m14035a(origApplicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean m13463a = SLModeUtil.m13463a();
        if (debugLog && m13463a) {
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(String str) {
        PathCenter.m14695b().m14696a(str);
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
            return;
        }
        UMServerURL.DEFAULT_URL = str;
        UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z) {
        EnvelopeManager.m13834a(z);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j) {
        BusinessWrapperConfig.f38916c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            Class cls2 = Boolean.TYPE;
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{cls2}), decInstanceObject, new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{cls2}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", UMLogCommon.SC_10024);
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10017);
                    return;
                } else if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", UMLogCommon.SC_10018);
                    return;
                } else {
                    int ordinal = bs_type.ordinal();
                    String[] strArr = BUSINESS_TYPE;
                    String str3 = ordinal < strArr.length ? strArr[ordinal] : "";
                    if (TextUtils.isEmpty(str3)) {
                        Log.e("UMLog", UMLogCommon.SC_10019);
                        return;
                    }
                    TagHelper.setModuleTag(str3 + "_" + str, str2);
                    return;
                }
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(WRAPER_TYPE_NATIVE)) {
                UMSLConfig.f38883a = WRAPER_TYPE_NATIVE;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_NATIVE;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                UMSLConfig.f38883a = WRAPER_TYPE_COCOS2DX_X;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                UMSLConfig.f38883a = WRAPER_TYPE_COCOS2DX_XLUA;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                UMSLConfig.f38883a = WRAPER_TYPE_UNITY;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                UMSLConfig.f38883a = WRAPER_TYPE_REACTNATIVE;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                UMSLConfig.f38883a = WRAPER_TYPE_PHONEGAP;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                UMSLConfig.f38883a = WRAPER_TYPE_WEEX;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                UMSLConfig.f38883a = "hybrid";
                BusinessWrapperConfig.f38914a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                UMSLConfig.f38883a = WRAPER_TYPE_FLUTTER;
                BusinessWrapperConfig.f38914a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        UMSLConfig.f38884b = str2;
        BusinessWrapperConfig.f38915b = str2;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(Context context, boolean z) {
        UMWorkDispatch.sendEvent(context, UMInternalConfig.f38778B, UMInternalData.m13974a(context).m13975a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, UMInternalConfig.f38814z, UMInternalData.m13974a(context).m13975a(), Integer.valueOf(policyGrantResult));
    }

    public static void init(Context context, String str, String str2, int i, String str3) {
        Object invoke;
        Method declaredMethod;
        Class<?> cls;
        Method declaredMethod2;
        Method declaredMethod3;
        Object invoke2;
        Method declaredMethod4;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.6.5");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
            } catch (Throwable th) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + th);
                }
            }
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "init e is " + e);
            }
        }
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
            }
        } else if (isInit) {
            if (debugLog) {
                Log.e(TAG, "has inited !!!");
            }
        } else {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            UMGlobalContext.getInstance(origApplicationContext);
            if (SLModeUtil.m13463a()) {
                if (!isPreInit()) {
                    preInitInternal(origApplicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMWorkDispatch.sendEvent(origApplicationContext, UMInternalConfig.f38780D, UMInternalData.m13974a(origApplicationContext).m13975a(), null);
                return;
            }
            try {
                if (getClass("com.umeng.umzid.ZIDManager") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(origApplicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable unused) {
                            }
                        }
                    }.start();
                    return;
                }
            } catch (Throwable unused) {
            }
            try {
                Class<?> cls2 = getClass("com.umeng.message.PushAgent");
                if (cls2 != null && !checkShareSdk(cls2)) {
                    Log.e("UMLog", UMLogCommon.SC_10015);
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                                    Looper.loop();
                                } catch (Throwable unused2) {
                                }
                            }
                        }.start();
                    }
                }
            } catch (Throwable unused2) {
            }
            try {
                Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
                if (cls3 != null && !checkShareSdk(cls3)) {
                    Log.e("UMLog", UMLogCommon.SC_10015);
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                                    Looper.loop();
                                } catch (Throwable unused3) {
                                }
                            }
                        }.start();
                    }
                }
            } catch (Throwable unused3) {
            }
            if (!isPreInit()) {
                preInitInternal(origApplicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMEnvelopeBuild.registerNetReceiver(origApplicationContext);
            UMUtils.setAppkey(origApplicationContext, sAppkey);
            String lastAppkey = UMUtils.getLastAppkey(origApplicationContext);
            if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
                }
                UMUtils.setLastAppkey(origApplicationContext, sAppkey);
            }
            if (debugLog) {
                Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
            }
            if (debugLog) {
                String appkeyByXML = UMUtils.getAppkeyByXML(origApplicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                    UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                }
            }
            UMUtils.setChannel(origApplicationContext, sChannel);
            if (debugLog) {
                Log.i(TAG, "channel is " + sChannel);
            }
            try {
                Method declaredMethod5 = MobclickAgent.class.getDeclaredMethod("init", Context.class);
                if (declaredMethod5 != null) {
                    declaredMethod5.setAccessible(true);
                    declaredMethod5.invoke(MobclickAgent.class, origApplicationContext);
                    if (FieldManager.allow(UMConstant.f39160F)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                        AutoViewPageTracker.m14308a(origApplicationContext).m14301b(origApplicationContext);
                    } else {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                    }
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                    }
                }
                Class.forName("com.umeng.analytics.game.UMGameAgent");
                Method declaredMethod6 = MobclickAgent.class.getDeclaredMethod("setGameScenarioType", Context.class);
                if (declaredMethod6 != null) {
                    declaredMethod6.setAccessible(true);
                    declaredMethod6.invoke(MobclickAgent.class, origApplicationContext);
                }
                if (EnvelopeManager.f38917a.indexOf("e") >= 0 && (declaredMethod4 = MobclickAgent.class.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                    declaredMethod4.setAccessible(true);
                    declaredMethod4.invoke(MobclickAgent.class, new Object[0]);
                }
            } catch (Throwable unused4) {
            }
            try {
                Class<?> cls4 = Class.forName("com.umeng.message.PushAgent");
                Method declaredMethod7 = cls4.getDeclaredMethod("init", Context.class);
                if (declaredMethod7 != null) {
                    declaredMethod7.setAccessible(true);
                    declaredMethod7.invoke(cls4, origApplicationContext);
                }
            } catch (Throwable unused5) {
            }
            try {
                Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
                Method declaredMethod8 = cls5.getDeclaredMethod("getInstance", Context.class);
                if (declaredMethod8 != null && (invoke2 = declaredMethod8.invoke(cls5, origApplicationContext)) != null) {
                    Method declaredMethod9 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                    if (declaredMethod9 != null) {
                        declaredMethod9.setAccessible(true);
                        declaredMethod9.invoke(invoke2, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                        }
                    }
                    Method declaredMethod10 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                    if (declaredMethod10 != null) {
                        declaredMethod10.setAccessible(true);
                        declaredMethod10.invoke(invoke2, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        if (debugLog) {
                            Log.i(TAG, "push secret is " + str3);
                        }
                        Method declaredMethod11 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                        if (declaredMethod11 != null) {
                            declaredMethod11.setAccessible(true);
                            declaredMethod11.invoke(invoke2, str3);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                            }
                        }
                    }
                }
            } catch (Exception unused6) {
            }
            try {
                Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
                setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
                if (cls6 != null && (declaredMethod3 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(cls6, origApplicationContext, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                    }
                }
            } catch (Throwable unused7) {
            }
            AnalyticsConstants.setDeviceType(i);
            try {
                Class<?> cls7 = Class.forName("com.umeng.error.UMError");
                Method declaredMethod12 = cls7.getDeclaredMethod("init", Context.class);
                if (declaredMethod12 != null) {
                    declaredMethod12.setAccessible(true);
                    declaredMethod12.invoke(cls7, origApplicationContext);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                    }
                }
            } catch (Throwable unused8) {
            }
            try {
                if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                    if (SdkVersion.SDK_TYPE == 1 && (declaredMethod2 = cls.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(cls, Boolean.TRUE);
                    }
                    Method declaredMethod13 = cls.getDeclaredMethod("init", Context.class, String.class, String.class);
                    if (declaredMethod13 != null) {
                        declaredMethod13.setAccessible(true);
                        declaredMethod13.invoke(cls, origApplicationContext, sAppkey, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                        }
                    }
                }
            } catch (Throwable unused9) {
            }
            try {
                Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
                if (declaredMethod14 != null) {
                    declaredMethod14.invoke(null, origApplicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
                }
            } catch (Throwable unused10) {
            }
            try {
                Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                if (declaredMethod15 != null) {
                    declaredMethod15.invoke(null, origApplicationContext, sAppkey);
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
                }
            } catch (Throwable unused11) {
            }
            synchronized (lockObject) {
                isFinish = true;
            }
            if (needCheckPolicyResult(origApplicationContext)) {
                synchronized (lock) {
                    if (preInitInvokedFlag == 0) {
                        Log.e(TAG, UMLogCommon.SC_10026);
                    }
                    if (policyGrantResult == 0) {
                        Log.e(TAG, UMLogCommon.SC_10028);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UMInternalConfig.f38786J, preInitInvokedFlag);
                        jSONObject.put(UMInternalConfig.f38787K, policyGrantInvokedFlag);
                        jSONObject.put("policyGrantResult", policyGrantResult);
                        UMWorkDispatch.sendEvent(origApplicationContext, UMInternalConfig.f38777A, UMInternalData.m13974a(origApplicationContext).m13975a(), jSONObject);
                    } catch (Throwable unused12) {
                    }
                }
            }
            if (needSendZcfgEnv(origApplicationContext)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
                UMWorkDispatch.sendEvent(origApplicationContext, UMInternalConfig.f38804p, UMInternalData.m13974a(origApplicationContext).m13975a(), null);
            } else if (UMUtils.isMainProgress(origApplicationContext)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
                if (FieldManager.m14032b()) {
                    UMWorkDispatch.sendEvent(origApplicationContext, UMInternalConfig.f38813y, UMInternalData.m13974a(origApplicationContext).m13975a(), null);
                }
                if (FieldManager.allow(UMConstant.f39161G)) {
                    UMInternalDataProtocol.m13970a(origApplicationContext, false);
                }
            }
            if (isDebugLog()) {
                UMConfigureInternation.doSelfCheck(origApplicationContext);
            }
            try {
                Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Class<?> cls8 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
                Method declaredMethod16 = cls8.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod16 != null && (invoke = declaredMethod16.invoke(cls8, new Object[0])) != null && (declaredMethod = cls8.getDeclaredMethod("init", Context.class)) != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(invoke, origApplicationContext2);
                }
            } catch (Exception unused13) {
            }
            UMWorkDispatch.sendEvent(context, UMInternalConfig.f38782F, UMInternalData.m13974a(context).m13975a(), null);
            if (isInit) {
                return;
            }
            isInit = true;
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }
}
