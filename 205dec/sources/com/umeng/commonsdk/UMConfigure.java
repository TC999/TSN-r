package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.b;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", "zid"};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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
            Log.e("UMLog", "\u4f20\u5165\u4e1a\u52a1\u7c7b\u578b\u679a\u4e3e\u503c\u4e0d\u80fd\u4e3anull\uff0cdeleteModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
        } else if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "\u4f20\u5165key\u4e3a\u7a7a\uff0cdeleteModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
        } else {
            try {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", "\u4f20\u5165key\u957f\u5ea6\u8d85\u9650\uff0cdeleteModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
                    return;
                }
                int ordinal = bs_type.ordinal();
                String[] strArr = BUSINESS_TYPE;
                String str2 = ordinal < strArr.length ? strArr[ordinal] : "";
                if (TextUtils.isEmpty(str2)) {
                    Log.e("UMLog", "\u4f20\u5165\u4e1a\u52a1\u7c7b\u578b\u53c2\u6570\u9519\u8bef\uff0cdeleteModuleTag\u8c03\u7528\u65e0\u6548\u3002");
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

    public static void enableAzxSwitch(boolean z3) {
        b.a(z3);
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
        boolean z3;
        synchronized (lockObject) {
            z3 = isFinish;
        }
        return z3;
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
                Log.e("UMConfigure", "context is null !!!");
                return;
            }
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String a4 = aw.a(origApplicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(a4);
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

    public static void init(Context context, int i4, String str) {
        init(context, null, null, i4, str);
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
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isPreInit() {
        boolean z3;
        synchronized (PreInitLock) {
            z3 = preInitComplete;
        }
        return z3;
    }

    private static boolean isSilentMode() {
        boolean a4 = c.a();
        UMRTLog.i("MobclickRT", "--->>> isSilentMode() return: " + a4);
        return a4;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(bm.f52722m);
        return !new File(sb.toString()).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(bm.f52721l);
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
                Log.e("UMConfigure", "preInit: context is null, pls check!");
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
        l.a(origApplicationContext);
        if (!needSendZcfgEnv(origApplicationContext)) {
            FieldManager.a().a(origApplicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean a4 = c.a();
        if (debugLog && a4) {
            UMRTLog.i("MobclickRT", "--->>> \u5f53\u524d\u5904\u4e8e\u9759\u9ed8\u6a21\u5f0f!");
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(String str) {
        au.b().a(str);
    }

    private static void setCheckDevice(boolean z3) {
        AnalyticsConstants.CHECK_DEVICE = z3;
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
            return;
        }
        UMServerURL.DEFAULT_URL = str;
        UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z3) {
        com.umeng.commonsdk.statistics.b.a(z3);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j4) {
        a.f53551c = ((int) j4) * 1000;
    }

    public static void setLogEnabled(boolean z3) {
        try {
            debugLog = z3;
            MLog.DEBUG = z3;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            Class cls2 = Boolean.TYPE;
            invoke(getDecMethod(cls, "setDebugMode", new Class[]{cls2}), decInstanceObject, new Object[]{Boolean.valueOf(z3)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z3);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{cls2}), new Object[]{Boolean.valueOf(z3)});
        } catch (Exception e4) {
            if (debugLog) {
                Log.e("UMConfigure", "set log enabled e is " + e4);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e("UMConfigure", "set log enabled e is " + th);
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", "\u4f20\u5165\u4e1a\u52a1\u7c7b\u578b\u679a\u4e3e\u503c\u4e0d\u80fd\u4e3anull\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", "\u4f20\u5165key\u957f\u5ea6\u8d85\u9650\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
                    return;
                } else if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", "\u4f20\u5165value\u957f\u5ea6\u8d85\u9650\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
                    return;
                } else {
                    int ordinal = bs_type.ordinal();
                    String[] strArr = BUSINESS_TYPE;
                    String str3 = ordinal < strArr.length ? strArr[ordinal] : "";
                    if (TextUtils.isEmpty(str3)) {
                        Log.e("UMLog", "\u4f20\u5165\u4e1a\u52a1\u7c7b\u578b\u53c2\u6570\u9519\u8bef\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\u3002");
                        return;
                    }
                    TagHelper.setModuleTag(str3 + "_" + str, str2);
                    return;
                }
            }
            Log.e("UMLog", "\u4f20\u5165key\u6216value\u4e3a\u7a7a\uff0csetModuleTag\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u53c2\u6570\u3002");
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z3) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z3;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(AMPSConstants.AdType.AD_TYPE_NATIVE)) {
                com.umeng.commonsdk.stateless.a.f53519a = AMPSConstants.AdType.AD_TYPE_NATIVE;
                a.f53549a = AMPSConstants.AdType.AD_TYPE_NATIVE;
            } else if (str.equals("Cocos2d-x")) {
                com.umeng.commonsdk.stateless.a.f53519a = "Cocos2d-x";
                a.f53549a = "Cocos2d-x";
            } else if (str.equals("Cocos2d-x_lua")) {
                com.umeng.commonsdk.stateless.a.f53519a = "Cocos2d-x_lua";
                a.f53549a = "Cocos2d-x_lua";
            } else if (str.equals("Unity")) {
                com.umeng.commonsdk.stateless.a.f53519a = "Unity";
                a.f53549a = "Unity";
            } else if (str.equals("react-native")) {
                com.umeng.commonsdk.stateless.a.f53519a = "react-native";
                a.f53549a = "react-native";
            } else if (str.equals("phonegap")) {
                com.umeng.commonsdk.stateless.a.f53519a = "phonegap";
                a.f53549a = "phonegap";
            } else if (str.equals("weex")) {
                com.umeng.commonsdk.stateless.a.f53519a = "weex";
                a.f53549a = "weex";
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.f53519a = "hybrid";
                a.f53549a = "hybrid";
            } else if (str.equals("flutter")) {
                com.umeng.commonsdk.stateless.a.f53519a = "flutter";
                a.f53549a = "flutter";
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.f53520b = str2;
        a.f53550b = str2;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(Context context, boolean z3) {
        UMWorkDispatch.sendEvent(context, 32800, com.umeng.commonsdk.internal.b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z3) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, 32792, com.umeng.commonsdk.internal.b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    public static void init(Context context, String str, String str2, int i4, String str3) {
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
                    Log.i("UMConfigure", "common version is 9.6.5");
                    Log.i("UMConfigure", "common type is " + SdkVersion.SDK_TYPE);
                }
            } catch (Exception e4) {
                if (debugLog) {
                    Log.e("UMConfigure", "init e is " + e4);
                }
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e("UMConfigure", "init e is " + th);
            }
        }
        if (context == null) {
            if (debugLog) {
                Log.e("UMConfigure", "context is null !!!");
            }
        } else if (isInit) {
            if (debugLog) {
                Log.e("UMConfigure", "has inited !!!");
            }
        } else {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            UMGlobalContext.getInstance(origApplicationContext);
            if (c.a()) {
                if (!isPreInit()) {
                    preInitInternal(origApplicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMWorkDispatch.sendEvent(origApplicationContext, 32802, com.umeng.commonsdk.internal.b.a(origApplicationContext).a(), null);
                return;
            }
            try {
                if (getClass("com.umeng.umzid.ZIDManager") == null) {
                    Log.e("UMConfigure", "--->>> SDK \u521d\u59cb\u5316\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u96c6\u6210umeng-asms-1.2.x.aar\u5e93\u3002<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(origApplicationContext, "SDK \u521d\u59cb\u5316\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u96c6\u6210umeng-asms-1.2.X.aar\u5e93\u3002", 1).show();
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
                    Log.e("UMLog", "\u57fa\u7840\u7ec4\u4ef6\u5e939.3.x\u7248\u672c\u4ec5\u652f\u63016.2.0\u53ca\u66f4\u9ad8\u7248\u672c\u63a8\u9001SDK\u30017.1.0\u53ca\u66f4\u9ad8\u7248\u672c\u5206\u4eabSDK\u3002");
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(origApplicationContext, "\u57fa\u7840\u7ec4\u4ef6\u5e939.3.x\u7248\u672c\u4ec5\u652f\u63016.2.0\u53ca\u66f4\u9ad8\u7248\u672c\u63a8\u9001SDK\u30017.1.0\u53ca\u66f4\u9ad8\u7248\u672c\u5206\u4eabSDK\u3002", 1).show();
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
                    Log.e("UMLog", "\u57fa\u7840\u7ec4\u4ef6\u5e939.3.x\u7248\u672c\u4ec5\u652f\u63016.2.0\u53ca\u66f4\u9ad8\u7248\u672c\u63a8\u9001SDK\u30017.1.0\u53ca\u66f4\u9ad8\u7248\u672c\u5206\u4eabSDK\u3002");
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(origApplicationContext, "\u57fa\u7840\u7ec4\u4ef6\u5e939.3.x\u7248\u672c\u4ec5\u652f\u63016.2.0\u53ca\u66f4\u9ad8\u7248\u672c\u63a8\u9001SDK\u30017.1.0\u53ca\u66f4\u9ad8\u7248\u672c\u5206\u4eabSDK\u3002", 1).show();
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
                    UMLog.mutlInfo("AppKey\u6539\u53d8!!!", 2, "");
                }
                UMUtils.setLastAppkey(origApplicationContext, sAppkey);
            }
            if (debugLog) {
                Log.i("UMConfigure", "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
            }
            if (debugLog) {
                String appkeyByXML = UMUtils.getAppkeyByXML(origApplicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                    UMLog.mutlInfo("\u8bf7\u6ce8\u610f\uff1a\u60a8init\u63a5\u53e3\u4e2d\u8bbe\u7f6e\u7684AppKey\u662f@\uff0cmanifest\u4e2d\u8bbe\u7f6e\u7684AppKey\u662f#\uff0cinit\u63a5\u53e3\u8bbe\u7f6e\u7684AppKey\u4f1a\u8986\u76d6manifest\u4e2d\u8bbe\u7f6e\u7684AppKey", 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                }
            }
            UMUtils.setChannel(origApplicationContext, sChannel);
            if (debugLog) {
                Log.i("UMConfigure", "channel is " + sChannel);
            }
            try {
                Method declaredMethod5 = MobclickAgent.class.getDeclaredMethod("init", Context.class);
                if (declaredMethod5 != null) {
                    declaredMethod5.setAccessible(true);
                    declaredMethod5.invoke(MobclickAgent.class, origApplicationContext);
                    if (FieldManager.allow("header_first_resume")) {
                        UMRTLog.i("MobclickRT", "--->>> FirstResumeTrigger enabled.");
                        l.a(origApplicationContext).b(origApplicationContext);
                    } else {
                        UMRTLog.i("MobclickRT", "--->>> FirstResumeTrigger disabled.");
                    }
                    if (debugLog) {
                        UMLog.mutlInfo("\u7edf\u8ba1SDK\u521d\u59cb\u5316\u6210\u529f", 2, "");
                    }
                }
                Class.forName("com.umeng.analytics.game.UMGameAgent");
                Method declaredMethod6 = MobclickAgent.class.getDeclaredMethod("setGameScenarioType", Context.class);
                if (declaredMethod6 != null) {
                    declaredMethod6.setAccessible(true);
                    declaredMethod6.invoke(MobclickAgent.class, origApplicationContext);
                }
                if (com.umeng.commonsdk.statistics.b.f53552a.indexOf("e") >= 0 && (declaredMethod4 = MobclickAgent.class.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
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
                            UMLog.mutlInfo("PUSH AppKey\u8bbe\u7f6e\u6210\u529f", 2, "");
                        }
                    }
                    Method declaredMethod10 = cls5.getDeclaredMethod("setMessageChannel", String.class);
                    if (declaredMethod10 != null) {
                        declaredMethod10.setAccessible(true);
                        declaredMethod10.invoke(invoke2, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo("PUSH Channel\u8bbe\u7f6e\u6210\u529f", 2, "");
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        if (debugLog) {
                            Log.i("UMConfigure", "push secret is " + str3);
                        }
                        Method declaredMethod11 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                        if (declaredMethod11 != null) {
                            declaredMethod11.setAccessible(true);
                            declaredMethod11.invoke(invoke2, str3);
                            if (debugLog) {
                                UMLog.mutlInfo("PUSH Secret\u8bbe\u7f6e\u6210\u529f", 2, "");
                            }
                        }
                    }
                }
            } catch (Exception unused6) {
            }
            try {
                Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
                setFile(cls6, "APPKEY", sAppkey);
                if (cls6 != null && (declaredMethod3 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(cls6, origApplicationContext, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo("Share AppKey\u8bbe\u7f6e\u6210\u529f", 2, "");
                    }
                }
            } catch (Throwable unused7) {
            }
            AnalyticsConstants.setDeviceType(i4);
            try {
                Class<?> cls7 = Class.forName("com.umeng.error.UMError");
                Method declaredMethod12 = cls7.getDeclaredMethod("init", Context.class);
                if (declaredMethod12 != null) {
                    declaredMethod12.setAccessible(true);
                    declaredMethod12.invoke(cls7, origApplicationContext);
                    if (debugLog) {
                        UMLog.mutlInfo("\u9519\u8bef\u5206\u6790SDK\u521d\u59cb\u5316\u6210\u529f", 2, "");
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
                            UMLog.mutlInfo("APM SDK\u521d\u59cb\u5316\u6210\u529f", 2, "");
                        }
                    }
                }
            } catch (Throwable unused9) {
            }
            try {
                Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
                if (declaredMethod14 != null) {
                    declaredMethod14.invoke(null, origApplicationContext, sAppkey, sChannel, Integer.valueOf(i4), str3);
                    UMRTLog.i("MobclickRT", "--->>>\u521d\u59cb\u5316 EventFacade \u6210\u529f.");
                }
            } catch (Throwable unused10) {
            }
            try {
                Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                if (declaredMethod15 != null) {
                    declaredMethod15.invoke(null, origApplicationContext, sAppkey);
                    UMRTLog.i("MobclickRT", "--->>>\u521d\u59cb\u5316 VTTracker \u6210\u529f.");
                }
            } catch (Throwable unused11) {
            }
            synchronized (lockObject) {
                isFinish = true;
            }
            if (needCheckPolicyResult(origApplicationContext)) {
                synchronized (lock) {
                    if (preInitInvokedFlag == 0) {
                        Log.e("UMConfigure", "\u68c0\u6d4b\u5230SDK\u521d\u59cb\u5316\u8fc7\u7a0b\u9057\u6f0fUMConfigure.preInit\u51fd\u6570\uff0c\u8bf7\u53c2\u8003\u3010\u53cb\u76df+\u3011\u5408\u89c4\u6307\u5357: https://developer.umeng.com/docs/119267/detail/182050");
                    }
                    if (policyGrantResult == 0) {
                        Log.e("UMConfigure", "\u68c0\u6d4b\u5230\u672a\u8c03\u7528\u9690\u79c1\u6388\u6743API\uff0c\u8be6\u60c5\u89c1\uff1ahttps://developer.umeng.com/docs/119267/detail/182050");
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("preInitInvoked", preInitInvokedFlag);
                        jSONObject.put("policyGrantInvoked", policyGrantInvokedFlag);
                        jSONObject.put("policyGrantResult", policyGrantResult);
                        UMWorkDispatch.sendEvent(origApplicationContext, 32793, com.umeng.commonsdk.internal.b.a(origApplicationContext).a(), jSONObject);
                    } catch (Throwable unused12) {
                    }
                }
            }
            if (needSendZcfgEnv(origApplicationContext)) {
                UMRTLog.e("MobclickRT", "--->>> \u8d70\u96f6\u53f7\u62a5\u6587\u53d1\u9001\u903b\u8f91");
                UMWorkDispatch.sendEvent(origApplicationContext, 32781, com.umeng.commonsdk.internal.b.a(origApplicationContext).a(), null);
            } else if (UMUtils.isMainProgress(origApplicationContext)) {
                UMRTLog.e("MobclickRT", "--->>> \u8d70\u6b63\u5e38\u903b\u8f91.");
                if (FieldManager.b()) {
                    UMWorkDispatch.sendEvent(origApplicationContext, 32791, com.umeng.commonsdk.internal.b.a(origApplicationContext).a(), null);
                }
                if (FieldManager.allow("header_device_oaid")) {
                    com.umeng.commonsdk.internal.c.a(origApplicationContext, false);
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
            UMWorkDispatch.sendEvent(context, 32804, com.umeng.commonsdk.internal.b.a(context).a(), null);
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

    private static void setFile(Class<?> cls, String str, boolean z3) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z3));
            } catch (Exception unused) {
            }
        }
    }
}
