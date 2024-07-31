package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p560h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C12786aa;
import com.tencent.bugly.proguard.C12803ac;
import com.tencent.bugly.proguard.C12818ak;
import com.tencent.bugly.proguard.C12820al;
import com.tencent.bugly.proguard.C12823an;
import com.tencent.bugly.proguard.C12828ap;
import com.tencent.bugly.proguard.C12829aq;
import com.tencent.bugly.proguard.C12848at;
import com.tencent.bugly.proguard.C12853au;
import com.tencent.bugly.proguard.C12869bc;
import com.tencent.bugly.proguard.C12904p;
import com.tencent.bugly.proguard.C12906r;
import com.tencent.bugly.proguard.C12912s;
import com.tencent.bugly.proguard.C12920w;
import com.tencent.bugly.proguard.C12922x;
import com.tencent.bugly.proguard.C12923y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f36266a;

    /* compiled from: BUGLY */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class CrashHandleCallback extends BUGLY.C12768a {
    }

    /* compiled from: BUGLY */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class UserStrategy extends BUGLY {

        /* renamed from: c */
        CrashHandleCallback f36268c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BUGLY
        public synchronized int getCallBackType() {
            return this.f36239a;
        }

        @Override // com.tencent.bugly.BUGLY
        public synchronized boolean getCloseErrorCallback() {
            return this.f36240b;
        }

        @Override // com.tencent.bugly.BUGLY
        public synchronized void setCallBackType(int i) {
            this.f36239a = i;
        }

        @Override // com.tencent.bugly.BUGLY
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f36240b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f36268c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BUGLY
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f36268c;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.CrashReport$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12772a {
        /* renamed from: a */
        String mo16043a();

        /* renamed from: a */
        void mo16042a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        /* renamed from: a */
        void mo16041a(String str);

        /* renamed from: b */
        void mo16040b();

        /* renamed from: c */
        CharSequence mo16039c();
    }

    public static void closeBugly() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f36266a == null) {
        } else {
            C12829aq m15806a = C12829aq.m15806a();
            if (m15806a != null) {
                m15806a.m15800b(f36266a);
            }
            closeCrashReport();
            C12912s.m15543a(f36266a);
            C12818ak m15887a = C12818ak.m15887a();
            if (m15887a != null) {
                m15887a.m15884b();
            }
        }
    }

    public static void closeCrashReport() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12848at.m15755a().m15747c();
        }
    }

    public static void closeNativeReport() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12848at.m15755a().m15746d();
        }
    }

    public static void enableBugly(boolean z) {
        C12904p.f36890a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        setCollectPrivacyInfo(context, z);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(C12820al.f36546b, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return C12786aa.m16009a(context).m15977w();
        }
    }

    public static String getAppChannel() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C12786aa.m16009a(f36266a).f36466s;
        }
    }

    public static String getAppID() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C12786aa.m16009a(f36266a).m15998e();
        }
    }

    public static String getAppVer() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C12786aa.m16009a(f36266a).f36462o;
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C12820al.m15873d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return C12786aa.m16009a(context).f36455h;
    }

    public static Context getContext() {
        return f36266a;
    }

    public static String getDeviceID(Context context) {
        return C12786aa.m16009a(context).m15994g();
    }

    public static Proxy getHttpProxy() {
        return C12823an.f36550a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        } else {
            return C12786aa.m16009a(f36266a).f36409K;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C12820al.f36546b, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (C12828ap.m15817b(str)) {
            return null;
        } else {
            return C12786aa.m16009a(context).m15993g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(C12820al.f36546b, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return C12786aa.m16009a(context).m15978v();
        }
    }

    public static String getUserId() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C12786aa.m16009a(f36266a).m15996f();
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(C12820al.f36546b, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return C12786aa.m16009a(context).m15974z();
        }
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f36266a = context;
        C12904p.m15567a(CrashModule.getInstance());
        C12904p.m15571a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            C12848at m15755a = C12848at.m15755a();
            Boolean bool = m15755a.f36628A;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = C12786aa.m16005b().f36451d;
            List<C12923y> m15508a = C12920w.m15509a().m15508a(1);
            ArrayList arrayList = new ArrayList();
            if (m15508a != null && m15508a.size() > 0) {
                for (C12923y c12923y : m15508a) {
                    if (str.equals(c12923y.f36970c)) {
                        m15755a.f36628A = Boolean.TRUE;
                        arrayList.add(c12923y);
                    }
                }
                if (arrayList.size() > 0) {
                    C12920w.m15509a().m15489a(arrayList);
                }
                return true;
            }
            m15755a.f36628A = Boolean.FALSE;
            return false;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12853au.m15734a(thread, i, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || C12828ap.m15817b(str) || C12828ap.m15817b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(C12820al.f36546b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(C12820al.f36546b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        C12786aa.m16009a(context).m16003b(replace, str2);
        C12820al.m15876b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "putUserData args context should not be null");
        } else if (str == null) {
            C12820al.m15873d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            C12820al.m15873d("putUserData args value should not be null", new Object[0]);
        } else {
            if (str2.length() > 200) {
                C12820al.m15873d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            C12786aa m16009a = C12786aa.m16009a(context);
            if (m16009a.m15977w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                C12786aa.m16009a(context).m16007a(str, str2);
                C12820al.m15874c("replace KV %s %s", str, str2);
            } else if (m16009a.m15978v() >= 50) {
                C12820al.m15873d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                if (str.length() > 50) {
                    C12820al.m15873d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str, str2);
                }
                C12786aa.m16009a(context).m16007a(str, str2);
                C12820al.m15876b("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C12820al.f36546b, "removeUserData args context should not be null");
            return "unknown";
        } else if (C12828ap.m15817b(str)) {
            return null;
        } else {
            C12820al.m15876b("[param] remove user data: %s", str);
            return C12786aa.m16009a(context).m15995f(str);
        }
    }

    public static void setAllThreadStackEnable(Context context, boolean z, boolean z2) {
        C12786aa m16009a = C12786aa.m16009a(context);
        m16009a.f36415Q = z;
        m16009a.f36416R = z2;
    }

    public static void setAppChannel(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(C12820al.f36546b, "App channel is null, will not set");
        } else {
            C12786aa.m16009a(context).f36466s = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(C12820al.f36546b, "App package is null, will not set");
        } else {
            C12786aa.m16009a(context).f36450c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
            }
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(C12820al.f36546b, "App version is null, will not set");
        } else {
            C12786aa.m16009a(context).f36462o = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void setBuglyDbName(String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(C12820al.f36546b, "Set Bugly DB name: ".concat(String.valueOf(str)));
        C12922x.f36964a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(C12820al.f36546b, "setCollectPrivacyInfo: ".concat(String.valueOf(z)));
            C12786aa.m16009a(context).f36461n = z;
        }
    }

    public static void setContext(Context context) {
        f36266a = context;
    }

    public static void setCrashFilter(String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(C12820al.f36546b, "Set crash stack filter: ".concat(String.valueOf(str)));
        C12848at.f36626q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(C12820al.f36546b, "Set crash stack filter: ".concat(String.valueOf(str)));
        C12848at.f36627r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C12786aa.m16009a(context).m16008a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C12786aa.m16009a(context).m16004b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(C12820al.f36546b, "setTombPath args context should not be null");
        } else if (str == null) {
            Log.w(C12820al.f36546b, "tombstone path is null, will not set");
        } else {
            Log.i(C12820al.f36546b, "user set tombstone path: ".concat(str));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(C12820al.f36546b, "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z)));
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            C12823an.f36550a = null;
        } else {
            C12823an.f36550a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z) {
        C12820al.m15878a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            C12820al.m15873d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C12820al.m15874c("This is a development device.", new Object[0]);
            } else {
                C12820al.m15874c("This is not a development device.", new Object[0]);
            }
            C12786aa.m16009a(context).f36407I = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || C12828ap.m15817b(str) || C12828ap.m15817b(str2)) {
        } else {
            C12786aa m16009a = C12786aa.m16009a(context);
            if (str == null || str2 == null) {
                return;
            }
            synchronized (m16009a.f36418T) {
                m16009a.f36409K.put(str, str2);
            }
        }
    }

    public static void setServerUrl(String str) {
        if (!C12828ap.m15817b(str) && C12828ap.m15809d(str)) {
            C12803ac.m15944a(str);
            StrategyBean.f36291a = str;
            StrategyBean.f36292b = str;
            return;
        }
        Log.i(C12820al.f36546b, "URL is invalid.");
    }

    public static void setSessionIntervalMills(long j) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            C12912s.m15544a(j);
        }
    }

    public static void setUserId(String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f36266a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(C12820al.f36546b, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                C12820al.m15873d("setTag args tagId should > 0", new Object[0]);
            }
            C12786aa m16009a = C12786aa.m16009a(context);
            synchronized (m16009a.f36419U) {
                int i2 = m16009a.f36470w;
                if (i2 != i) {
                    m16009a.f36470w = i;
                    C12820al.m15878a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(m16009a.f36470w));
                }
            }
            C12820al.m15876b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static void startCrashReport() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12848at.m15755a().m15749b();
        }
    }

    public static void testANRCrash() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12820al.m15878a("start to create a anr crash for test!", new Object[0]);
            C12848at.m15755a().m15742h();
        }
    }

    public static void testJavaCrash() {
        int i;
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12786aa m16005b = C12786aa.m16005b();
            if (m16005b != null && (i = m16005b.f36471x) != 24096) {
                m16005b.f36471x = 24096;
                C12820al.m15878a("server scene tag %d changed to tag %d", Integer.valueOf(i), Integer.valueOf(m16005b.f36471x));
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void uploadUserInfo() {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not upload user info because bugly is disable.");
            return;
        }
        C12906r c12906r = C12912s.f36911b;
        if (c12906r == null) {
            Log.w(C12820al.f36546b, "Can not upload user info because bugly is not init.");
        } else {
            c12906r.m15552b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(C12820al.f36546b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new InterfaceC12772a() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.InterfaceC12772a
            /* renamed from: a */
            public final String mo16043a() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.InterfaceC12772a
            /* renamed from: b */
            public final void mo16040b() {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.InterfaceC12772a
            /* renamed from: c */
            public final CharSequence mo16039c() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.InterfaceC12772a
            /* renamed from: a */
            public final void mo16041a(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.InterfaceC12772a
            /* renamed from: a */
            public final void mo16042a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }
        }, z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C12820al.m15878a("start to create a native crash for test!", new Object[0]);
            C12848at.m15755a().m15750a(z, z2, z3);
        }
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C12820al.f36546b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            C12820al.m15873d("throwable is null, just return", new Object[0]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            final C12848at m15755a = C12848at.m15755a();
            m15755a.f36636w.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.at.3

                /* renamed from: a */
                final /* synthetic */ boolean f36642a = false;

                /* renamed from: d */
                final /* synthetic */ String f36645d = null;

                /* renamed from: e */
                final /* synthetic */ byte[] f36646e = null;

                /* renamed from: f */
                final /* synthetic */ boolean f36647f = true;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C12820al.m15874c("post a throwable %b", Boolean.valueOf(this.f36642a));
                        C12848at.this.f36633t.m15728a(thread, th, false, this.f36645d, this.f36646e, this.f36647f);
                        if (z) {
                            C12820al.m15878a("clear user datas", new Object[0]);
                            C12786aa.m16009a(C12848at.this.f36631c).m15979u();
                        }
                    } catch (Throwable th2) {
                        if (!C12820al.m15875b(th2)) {
                            th2.printStackTrace();
                        }
                        C12820al.m15872e("java catch error: %s", th.toString());
                    }
                }
            });
        }
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f36266a = context;
        C12904p.m15567a(CrashModule.getInstance());
        C12904p.m15570a(context, userStrategy);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            C12823an.f36550a = null;
        } else {
            C12823an.f36550a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(C12820al.f36546b, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            C12820al.m15873d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                C12820al.m15873d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(C12786aa.m16009a(context).m15996f())) {
                return;
            }
            C12786aa m16009a = C12786aa.m16009a(context);
            synchronized (m16009a.f36420V) {
                m16009a.f36459l = str;
            }
            C12820al.m15876b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                C12912s.m15545a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C12904p.f36890a) {
            Log.w(C12820al.f36546b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            C12820al.m15873d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return C12786aa.m16009a(context).f36409K;
        }
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static boolean setJavascriptMonitor(InterfaceC12772a interfaceC12772a, boolean z) {
        return setJavascriptMonitor(interfaceC12772a, z, false);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f36266a = context;
        C12904p.m15567a(CrashModule.getInstance());
        C12904p.m15569a(context, str, z, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(InterfaceC12772a interfaceC12772a, boolean z, boolean z2) {
        if (interfaceC12772a == null) {
            Log.w(C12820al.f36546b, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            C12820al.m15872e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            C12820al.m15878a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!C12904p.f36890a) {
                Log.w(C12820al.f36546b, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            C12820al.m15874c("URL of webview is %s", interfaceC12772a.mo16043a());
            if (!z2 && Build.VERSION.SDK_INT < 19) {
                C12820al.m15872e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            C12820al.m15878a("Enable the javascript needed by webview monitor.", new Object[0]);
            interfaceC12772a.mo16040b();
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(interfaceC12772a);
            if (h5JavaScriptInterface != null) {
                C12820al.m15878a("Add a secure javascript interface to the webview.", new Object[0]);
                interfaceC12772a.mo16042a(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z) {
                C12820al.m15878a("Inject bugly.js(v%s) to the webview.", C12869bc.m15696b());
                String m15697a = C12869bc.m15697a();
                if (m15697a == null) {
                    C12820al.m15872e("Failed to inject Bugly.js.", C12869bc.m15696b());
                    return false;
                }
                interfaceC12772a.mo16041a("javascript:".concat(m15697a));
            }
            return true;
        }
    }
}
