package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.mobads.sdk.internal.cm */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2660cm implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static String f8845a = "";

    /* renamed from: b */
    private static final String f8846b = "remote";

    /* renamed from: c */
    private static final String f8847c = "proxy";

    /* renamed from: d */
    private static final String f8848d = "third-mtj";

    /* renamed from: e */
    private static final String f8849e = "third-cpu";

    /* renamed from: f */
    private static final String f8850f = "third-cpu-cyber";

    /* renamed from: g */
    private static final String f8851g = "third-novel";

    /* renamed from: h */
    private static final String f8852h = "third-aigc";

    /* renamed from: i */
    private static final String f8853i = "third-aigc-virtual";

    /* renamed from: j */
    private static final String f8854j = "third-aigc-speech";

    /* renamed from: k */
    private static Thread.UncaughtExceptionHandler f8855k = null;

    /* renamed from: l */
    private static volatile C2660cm f8856l = null;

    /* renamed from: o */
    private static final String f8857o = "key_crash_source";

    /* renamed from: p */
    private static final String f8858p = "key_crash_trace";

    /* renamed from: q */
    private static final String f8859q = "key_crash_ad";

    /* renamed from: m */
    private Context f8860m;

    /* renamed from: n */
    private InterfaceC2661a f8861n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mobads.sdk.internal.cm$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2661a {
        /* renamed from: a */
        void mo50616a(String str);
    }

    private C2660cm(Context context) {
        this.f8860m = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f8855k = Thread.getDefaultUncaughtExceptionHandler();
    }

    /* renamed from: d */
    private List<String> m50620d() {
        IXAdContainerFactory m51049c;
        ArrayList arrayList = new ArrayList();
        try {
            C2580aa m51057a = C2580aa.m51057a();
            if (m51057a != null && (m51049c = m51057a.m51049c()) != null) {
                Object remoteParam = m51049c.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* renamed from: e */
    private SharedPreferences m50619e() {
        return this.f8860m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    /* renamed from: f */
    private SharedPreferences.Editor m50618f() {
        return m50619e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m50617g() {
        SharedPreferences.Editor m50618f = m50618f();
        m50618f.clear();
        m50618f.apply();
    }

    /* renamed from: c */
    public void m50621c() {
        this.f8861n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String m50624a = m50624a(th);
            if (m50624a != null) {
                m50626a(m50624a, Log.getStackTraceString(th));
                InterfaceC2661a interfaceC2661a = this.f8861n;
                if (interfaceC2661a != null) {
                    interfaceC2661a.mo50616a(m50624a);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f8855k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e) {
            C2634bs.m50744a().m50729c(e);
        }
    }

    /* renamed from: b */
    public void m50623b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof C2660cm) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    public static C2660cm m50631a(Context context) {
        if (f8856l == null) {
            synchronized (C2660cm.class) {
                if (f8856l == null) {
                    f8856l = new C2660cm(context);
                }
            }
        }
        return f8856l;
    }

    /* renamed from: a */
    public void m50632a() {
        C2614bb.m50841a().m50840a((AbstractRunnableC2710i) new C2662cn(this));
    }

    /* renamed from: a */
    public void m50630a(InterfaceC2661a interfaceC2661a) {
        this.f8861n = interfaceC2661a;
    }

    /* renamed from: a */
    private String m50624a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> m50620d = m50620d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (!className.startsWith(C2736x.f9298au) && !className.startsWith(C2736x.f9299av) && !className.startsWith(C2736x.f9300aw)) {
                    if (className.startsWith(C2736x.f9301ax) || className.startsWith(C2736x.f9302ay) || className.startsWith(C2736x.f9303az)) {
                        return f8847c;
                    }
                    if (className.startsWith(C2736x.f9262aA)) {
                        return f8848d;
                    }
                    if (className.startsWith(C2736x.f9263aB)) {
                        return f8849e;
                    }
                    if (className.startsWith(C2736x.f9264aC) || className.startsWith(C2736x.f9265aD)) {
                        return f8850f;
                    }
                    if (className.startsWith(C2736x.f9273aL)) {
                        return f8854j;
                    }
                    if (className.startsWith(C2736x.f9269aH) || className.startsWith(C2736x.f9270aI) || className.startsWith(C2736x.f9271aJ) || className.startsWith(C2736x.f9272aK)) {
                        return f8853i;
                    }
                    if (className.startsWith(C2736x.f9268aG)) {
                        return f8852h;
                    }
                    if (!className.startsWith(C2736x.f9266aE) && !className.startsWith(C2736x.f9267aF)) {
                        if (m50625a(className, m50620d)) {
                        }
                    } else if (C2659cl.f8843g.booleanValue()) {
                        return f8851g;
                    }
                }
                return f8846b;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m50625a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m50626a(String str, String str2) {
        SharedPreferences.Editor m50618f = m50618f();
        m50618f.putString(f8857o, str);
        m50618f.putString(f8858p, ("crashtime:" + System.currentTimeMillis() + " ") + str2);
        m50618f.putString(f8859q, f8845a);
        m50618f.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m50627a(String str) {
        return m50619e().getString(str, "");
    }
}
