package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cp implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static String f12693a = "";

    /* renamed from: b  reason: collision with root package name */
    private static final String f12694b = "remote";

    /* renamed from: c  reason: collision with root package name */
    private static final String f12695c = "proxy";

    /* renamed from: d  reason: collision with root package name */
    private static final String f12696d = "third-mtj";

    /* renamed from: e  reason: collision with root package name */
    private static final String f12697e = "third-cpu";

    /* renamed from: f  reason: collision with root package name */
    private static final String f12698f = "third-cpu-cyber";

    /* renamed from: g  reason: collision with root package name */
    private static final String f12699g = "third-novel";

    /* renamed from: h  reason: collision with root package name */
    private static final String f12700h = "third-aigc";

    /* renamed from: i  reason: collision with root package name */
    private static final String f12701i = "third-aigc-virtual";

    /* renamed from: j  reason: collision with root package name */
    private static final String f12702j = "third-aigc-speech";

    /* renamed from: k  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f12703k = null;

    /* renamed from: l  reason: collision with root package name */
    private static volatile cp f12704l = null;

    /* renamed from: o  reason: collision with root package name */
    private static final String f12705o = "key_crash_source";

    /* renamed from: p  reason: collision with root package name */
    private static final String f12706p = "key_crash_trace";

    /* renamed from: q  reason: collision with root package name */
    private static final String f12707q = "key_crash_ad";

    /* renamed from: m  reason: collision with root package name */
    private Context f12708m;

    /* renamed from: n  reason: collision with root package name */
    private a f12709n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str);
    }

    private cp(Context context) {
        this.f12708m = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f12703k = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c4;
        ArrayList arrayList = new ArrayList();
        try {
            aa a4 = aa.a();
            if (a4 != null && (c4 = a4.c()) != null) {
                Object remoteParam = c4.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f12708m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f4 = f();
        f4.clear();
        f4.apply();
    }

    public void c() {
        this.f12709n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a4 = a(th);
            if (a4 != null) {
                a(a4, Log.getStackTraceString(th));
                a aVar = this.f12709n;
                if (aVar != null) {
                    aVar.a(a4);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f12703k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e4) {
            bv.a().c(e4);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static cp a(Context context) {
        if (f12704l == null) {
            synchronized (cp.class) {
                if (f12704l == null) {
                    f12704l = new cp(context);
                }
            }
        }
        return f12704l;
    }

    public void a() {
        be.a().a((i) new cq(this));
    }

    public void a(a aVar) {
        this.f12709n = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d4 = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (!className.startsWith(x.av) && !className.startsWith(x.aw) && !className.startsWith(x.ax)) {
                    if (className.startsWith(x.ay) || className.startsWith(x.az) || className.startsWith(x.aA)) {
                        return f12695c;
                    }
                    if (className.startsWith(x.aB)) {
                        return f12696d;
                    }
                    if (className.startsWith(x.aC)) {
                        return f12697e;
                    }
                    if (className.startsWith(x.aD) || className.startsWith(x.aE)) {
                        return f12698f;
                    }
                    if (className.startsWith(x.aM)) {
                        return f12702j;
                    }
                    if (className.startsWith(x.aI) || className.startsWith(x.aJ) || className.startsWith(x.aK) || className.startsWith(x.aL)) {
                        return f12701i;
                    }
                    if (className.startsWith(x.aH)) {
                        return f12700h;
                    }
                    if (!className.startsWith(x.aF) && !className.startsWith(x.aG)) {
                        if (a(className, d4)) {
                        }
                    } else if (co.f12663g.booleanValue()) {
                        return f12699g;
                    }
                }
                return f12694b;
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f4 = f();
        f4.putString(f12705o, str);
        f4.putString(f12706p, ("crashtime:" + System.currentTimeMillis() + " ") + str2);
        f4.putString(f12707q, f12693a);
        f4.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}
