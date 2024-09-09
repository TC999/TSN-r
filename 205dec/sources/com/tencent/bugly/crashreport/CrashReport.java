package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CrashReport {

    /* renamed from: a  reason: collision with root package name */
    private static Context f50716a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c  reason: collision with root package name */
        CrashHandleCallback f50718c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f50689a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f50690b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i4) {
            this.f50689a = i4;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z3) {
            this.f50690b = z3;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f50718c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f50718c;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static void closeBugly() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f50716a == null) {
        } else {
            aq a4 = aq.a();
            if (a4 != null) {
                a4.b(f50716a);
            }
            closeCrashReport();
            s.a(f50716a);
            ak a5 = ak.a();
            if (a5 != null) {
                a5.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().c();
        }
    }

    public static void closeNativeReport() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().d();
        }
    }

    public static void enableBugly(boolean z3) {
        p.f51256a = z3;
    }

    public static void enableObtainId(Context context, boolean z3) {
        setCollectPrivacyInfo(context, z3);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(al.f50920b, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return aa.a(context).w();
        }
    }

    public static String getAppChannel() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return aa.a(f50716a).f50840s;
        }
    }

    public static String getAppID() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return aa.a(f50716a).e();
        }
    }

    public static String getAppVer() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return aa.a(f50716a).f50836o;
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            al.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return aa.a(context).f50829h;
    }

    public static Context getContext() {
        return f50716a;
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static Proxy getHttpProxy() {
        return an.f50924a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        } else {
            return aa.a(f50716a).K;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(al.f50920b, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (ap.b(str)) {
            return null;
        } else {
            return aa.a(context).g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(al.f50920b, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return aa.a(context).v();
        }
    }

    public static String getUserId() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return aa.a(f50716a).f();
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(al.f50920b, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return aa.a(context).z();
        }
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f50716a = context;
        p.a(CrashModule.getInstance());
        p.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            at a4 = at.a();
            Boolean bool = a4.A;
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = aa.b().f50825d;
            List<y> a5 = w.a().a(1);
            ArrayList arrayList = new ArrayList();
            if (a5 != null && a5.size() > 0) {
                for (y yVar : a5) {
                    if (str.equals(yVar.f51336c)) {
                        a4.A = Boolean.TRUE;
                        arrayList.add(yVar);
                    }
                }
                if (arrayList.size() > 0) {
                    w.a().a(arrayList);
                }
                return true;
            }
            a4.A = Boolean.FALSE;
            return false;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i4, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            au.a(thread, i4, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ap.b(str) || ap.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(al.f50920b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(al.f50920b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        aa.a(context).b(replace, str2);
        al.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "putUserData args context should not be null");
        } else if (str == null) {
            al.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            al.d("putUserData args value should not be null", new Object[0]);
        } else {
            if (str2.length() > 200) {
                al.d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            aa a4 = aa.a(context);
            if (a4.w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                aa.a(context).a(str, str2);
                al.c("replace KV %s %s", str, str2);
            } else if (a4.v() >= 50) {
                al.d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                if (str.length() > 50) {
                    al.d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str, str2);
                }
                aa.a(context).a(str, str2);
                al.b("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(al.f50920b, "removeUserData args context should not be null");
            return "unknown";
        } else if (ap.b(str)) {
            return null;
        } else {
            al.b("[param] remove user data: %s", str);
            return aa.a(context).f(str);
        }
    }

    public static void setAllThreadStackEnable(Context context, boolean z3, boolean z4) {
        aa a4 = aa.a(context);
        a4.Q = z3;
        a4.R = z4;
    }

    public static void setAppChannel(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(al.f50920b, "App channel is null, will not set");
        } else {
            aa.a(context).f50840s = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(al.f50920b, "App package is null, will not set");
        } else {
            aa.a(context).f50824c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
            }
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(al.f50920b, "App version is null, will not set");
        } else {
            aa.a(context).f50836o = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void setBuglyDbName(String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(al.f50920b, "Set Bugly DB name: ".concat(String.valueOf(str)));
        x.f51330a = str;
    }

    public static void setCollectPrivacyInfo(Context context, boolean z3) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(al.f50920b, "setCollectPrivacyInfo: ".concat(String.valueOf(z3)));
            aa.a(context).f50835n = z3;
        }
    }

    public static void setContext(Context context) {
        f50716a = context;
    }

    public static void setCrashFilter(String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.f50920b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.f50999q = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.f50920b, "Set crash stack filter: ".concat(String.valueOf(str)));
        at.f51000r = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(al.f50920b, "setTombPath args context should not be null");
        } else if (str == null) {
            Log.w(al.f50920b, "tombstone path is null, will not set");
        } else {
            Log.i(al.f50920b, "user set tombstone path: ".concat(str));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z3) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(al.f50920b, "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z3)));
        NativeCrashHandler.setShouldHandleInJava(z3);
    }

    public static void setHttpProxy(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            an.f50924a = null;
        } else {
            an.f50924a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i4));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z3) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z3) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            al.d("Context should not be null.", new Object[0]);
        } else {
            if (z3) {
                al.c("This is a development device.", new Object[0]);
            } else {
                al.c("This is not a development device.", new Object[0]);
            }
            aa.a(context).I = z3;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z3) {
        return setJavascriptMonitor(webView, z3, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || ap.b(str) || ap.b(str2)) {
        } else {
            aa a4 = aa.a(context);
            if (str == null || str2 == null) {
                return;
            }
            synchronized (a4.T) {
                a4.K.put(str, str2);
            }
        }
    }

    public static void setServerUrl(String str) {
        if (!ap.b(str) && ap.d(str)) {
            ac.a(str);
            StrategyBean.f50741a = str;
            StrategyBean.f50742b = str;
            return;
        }
        Log.i(al.f50920b, "URL is invalid.");
    }

    public static void setSessionIntervalMills(long j4) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            s.a(j4);
        }
    }

    public static void setUserId(String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f50716a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i4) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(al.f50920b, "setTag args context should not be null");
        } else {
            if (i4 <= 0) {
                al.d("setTag args tagId should > 0", new Object[0]);
            }
            aa a4 = aa.a(context);
            synchronized (a4.U) {
                int i5 = a4.f50844w;
                if (i5 != i4) {
                    a4.f50844w = i4;
                    al.a("user scene tag %d changed to tag %d", Integer.valueOf(i5), Integer.valueOf(a4.f50844w));
                }
            }
            al.b("[param] set user scene tag: %d", Integer.valueOf(i4));
        }
    }

    public static void startCrashReport() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            at.a().b();
        }
    }

    public static void testANRCrash() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i4;
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            aa b4 = aa.b();
            if (b4 != null && (i4 = b4.f50845x) != 24096) {
                b4.f50845x = 24096;
                al.a("server scene tag %d changed to tag %d", Integer.valueOf(i4), Integer.valueOf(b4.f50845x));
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void uploadUserInfo() {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not upload user info because bugly is disable.");
            return;
        }
        r rVar = s.f51277b;
        if (rVar == null) {
            Log.w(al.f50920b, "Can not upload user info because bugly is not init.");
        } else {
            rVar.b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z3, boolean z4) {
        if (webView == null) {
            Log.w(al.f50920b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final String a() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void b() {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final CharSequence c() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }
        }, z3, z4);
    }

    public static void testNativeCrash(boolean z3, boolean z4, boolean z5) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z3, z4, z5);
        }
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z3) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(al.f50920b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            al.d("throwable is null, just return", new Object[0]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            final at a4 = at.a();
            a4.f51006w.a(new Runnable() { // from class: com.tencent.bugly.proguard.at.3

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f51012a = false;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f51015d = null;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ byte[] f51016e = null;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ boolean f51017f = true;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        al.c("post a throwable %b", Boolean.valueOf(this.f51012a));
                        at.this.f51003t.a(thread, th, false, this.f51015d, this.f51016e, this.f51017f);
                        if (z3) {
                            al.a("clear user datas", new Object[0]);
                            aa.a(at.this.f51001c).u();
                        }
                    } catch (Throwable th2) {
                        if (!al.b(th2)) {
                            th2.printStackTrace();
                        }
                        al.e("java catch error: %s", th.toString());
                    }
                }
            });
        }
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f50716a = context;
        p.a(CrashModule.getInstance());
        p.a(context, userStrategy);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i4) {
        if (inetAddress == null) {
            an.f50924a = null;
        } else {
            an.f50924a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i4));
        }
    }

    public static void postException(int i4, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i4, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(al.f50920b, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            al.d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                al.d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(aa.a(context).f())) {
                return;
            }
            aa a4 = aa.a(context);
            synchronized (a4.V) {
                a4.f50833l = str;
            }
            al.b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                s.a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.f51256a) {
            Log.w(al.f50920b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return aa.a(context).K;
        }
    }

    public static void initCrashReport(Context context, String str, boolean z3) {
        initCrashReport(context, str, z3, null);
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z3) {
        return setJavascriptMonitor(aVar, z3, false);
    }

    public static void initCrashReport(Context context, String str, boolean z3, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f50716a = context;
        p.a(CrashModule.getInstance());
        p.a(context, str, z3, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(a aVar, boolean z3, boolean z4) {
        if (aVar == null) {
            Log.w(al.f50920b, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            al.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!p.f51256a) {
                Log.w(al.f50920b, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            al.c("URL of webview is %s", aVar.a());
            if (!z4 && Build.VERSION.SDK_INT < 19) {
                al.e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            al.a("Enable the javascript needed by webview monitor.", new Object[0]);
            aVar.b();
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(aVar);
            if (h5JavaScriptInterface != null) {
                al.a("Add a secure javascript interface to the webview.", new Object[0]);
                aVar.a(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z3) {
                al.a("Inject bugly.js(v%s) to the webview.", bc.b());
                String a4 = bc.a();
                if (a4 == null) {
                    al.e("Failed to inject Bugly.js.", bc.b());
                    return false;
                }
                aVar.a("javascript:".concat(a4));
            }
            return true;
        }
    }
}
