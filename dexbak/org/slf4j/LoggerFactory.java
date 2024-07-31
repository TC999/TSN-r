package org.slf4j;

import cn.bluemobi.dylan.photoview.C1204a;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.C15428j;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* renamed from: org.slf4j.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class LoggerFactory {

    /* renamed from: a */
    static final String f44296a = "http://www.slf4j.org/codes.html";

    /* renamed from: b */
    static final String f44297b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";

    /* renamed from: c */
    static final String f44298c = "http://www.slf4j.org/codes.html#multiple_bindings";

    /* renamed from: d */
    static final String f44299d = "http://www.slf4j.org/codes.html#null_LF";

    /* renamed from: e */
    static final String f44300e = "http://www.slf4j.org/codes.html#version_mismatch";

    /* renamed from: f */
    static final String f44301f = "http://www.slf4j.org/codes.html#substituteLogger";

    /* renamed from: g */
    static final String f44302g = "http://www.slf4j.org/codes.html#loggerNameMismatch";

    /* renamed from: h */
    static final String f44303h = "http://www.slf4j.org/codes.html#replay";

    /* renamed from: i */
    static final String f44304i = "http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: j */
    static final String f44305j = "org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: k */
    static final int f44306k = 0;

    /* renamed from: l */
    static final int f44307l = 1;

    /* renamed from: m */
    static final int f44308m = 2;

    /* renamed from: n */
    static final int f44309n = 3;

    /* renamed from: o */
    static final int f44310o = 4;

    /* renamed from: p */
    static volatile int f44311p = 0;

    /* renamed from: t */
    static final String f44315t = "java.vendor.url";

    /* renamed from: q */
    static SubstituteLoggerFactory f44312q = new SubstituteLoggerFactory();

    /* renamed from: r */
    static NOPLoggerFactory f44313r = new NOPLoggerFactory();

    /* renamed from: s */
    static final String f44314s = "slf4j.detectLoggerNameMismatch";

    /* renamed from: u */
    static boolean f44316u = C15428j.m2563f(f44314s);

    /* renamed from: v */
    private static final String[] f44317v = {C1204a.f1890f, "1.7"};

    /* renamed from: w */
    private static String f44318w = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory() {
    }

    /* renamed from: a */
    private static final void m2664a() {
        Set<URL> set = null;
        try {
            if (!m2653l()) {
                set = m2659f();
                m2646s(set);
            }
            StaticLoggerBinder.m2552c();
            f44311p = 3;
            m2647r(set);
            m2658g();
            m2649p();
            f44312q.m2573b();
        } catch (Exception e) {
            m2660e(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (m2652m(e2.getMessage())) {
                f44311p = 4;
                C15428j.m2566c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C15428j.m2566c("Defaulting to no-operation (NOP) logger implementation");
                C15428j.m2566c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m2660e(e2);
            throw e2;
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f44311p = 2;
                C15428j.m2566c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C15428j.m2566c("Your binding is version 1.5.5 or earlier.");
                C15428j.m2566c("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    /* renamed from: b */
    private static void m2663b(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        if (substituteLoggingEvent.m2625h().m2578d()) {
            m2662c(i);
        } else if (substituteLoggingEvent.m2625h().m2577e()) {
        } else {
            m2661d();
        }
    }

    /* renamed from: c */
    private static void m2662c(int i) {
        C15428j.m2566c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        C15428j.m2566c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C15428j.m2566c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: d */
    private static void m2661d() {
        C15428j.m2566c("The following set of substitute loggers may have been accessed");
        C15428j.m2566c("during the initialization phase. Logging calls during this");
        C15428j.m2566c("phase were not honored. However, subsequent logging calls to these");
        C15428j.m2566c("loggers will work as normally expected.");
        C15428j.m2566c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: e */
    static void m2660e(Throwable th) {
        f44311p = 2;
        C15428j.m2565d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* renamed from: f */
    static Set<URL> m2659f() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f44318w);
            } else {
                resources = classLoader.getResources(f44318w);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e) {
            C15428j.m2565d("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* renamed from: g */
    private static void m2658g() {
        synchronized (f44312q) {
            f44312q.m2569f();
            for (SubstituteLogger substituteLogger : f44312q.m2570e()) {
                substituteLogger.m2574h(m2655j(substituteLogger.getName()));
            }
        }
    }

    /* renamed from: h */
    public static ILoggerFactory m2657h() {
        if (f44311p == 0) {
            synchronized (LoggerFactory.class) {
                if (f44311p == 0) {
                    f44311p = 1;
                    m2650o();
                }
            }
        }
        int i = f44311p;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return f44313r;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return StaticLoggerBinder.m2552c().mo2554a();
            }
            throw new IllegalStateException(f44305j);
        }
        return f44312q;
    }

    /* renamed from: i */
    public static InterfaceC15424c m2656i(Class<?> cls) {
        Class<?> m2568a;
        InterfaceC15424c m2655j = m2655j(cls.getName());
        if (f44316u && (m2568a = C15428j.m2568a()) != null && m2651n(cls, m2568a)) {
            C15428j.m2566c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", m2655j.getName(), m2568a.getName()));
            C15428j.m2566c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return m2655j;
    }

    /* renamed from: j */
    public static InterfaceC15424c m2655j(String str) {
        return m2657h().mo2557a(str);
    }

    /* renamed from: k */
    private static boolean m2654k(Set<URL> set) {
        return set.size() > 1;
    }

    /* renamed from: l */
    private static boolean m2653l() {
        String m2562g = C15428j.m2562g(f44315t);
        if (m2562g == null) {
            return false;
        }
        return m2562g.toLowerCase().contains(FaceEnvironment.f8430OS);
    }

    /* renamed from: m */
    private static boolean m2652m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* renamed from: n */
    private static boolean m2651n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    /* renamed from: o */
    private static final void m2650o() {
        m2664a();
        if (f44311p == 3) {
            m2644u();
        }
    }

    /* renamed from: p */
    private static void m2649p() {
        LinkedBlockingQueue<SubstituteLoggingEvent> m2572c = f44312q.m2572c();
        int size = m2572c.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList(128);
        int i = 0;
        while (m2572c.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                m2648q(substituteLoggingEvent);
                int i2 = i + 1;
                if (i == 0) {
                    m2663b(substituteLoggingEvent, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    /* renamed from: q */
    private static void m2648q(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent == null) {
            return;
        }
        SubstituteLogger m2625h = substituteLoggingEvent.m2625h();
        String name = m2625h.getName();
        if (!m2625h.m2576f()) {
            if (m2625h.m2577e()) {
                return;
            }
            if (m2625h.m2578d()) {
                m2625h.m2575g(substituteLoggingEvent);
                return;
            } else {
                C15428j.m2566c(name);
                return;
            }
        }
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    /* renamed from: r */
    private static void m2647r(Set<URL> set) {
        if (set == null || !m2654k(set)) {
            return;
        }
        C15428j.m2566c("Actual binding is of type [" + StaticLoggerBinder.m2552c().mo2553b() + "]");
    }

    /* renamed from: s */
    private static void m2646s(Set<URL> set) {
        if (m2654k(set)) {
            C15428j.m2566c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                C15428j.m2566c("Found binding in [" + it.next() + "]");
            }
            C15428j.m2566c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: t */
    static void m2645t() {
        f44311p = 0;
    }

    /* renamed from: u */
    private static final void m2644u() {
        try {
            String str = StaticLoggerBinder.f44369c;
            boolean z = false;
            for (String str2 : f44317v) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            C15428j.m2566c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f44317v).toString());
            C15428j.m2566c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            C15428j.m2565d("Unexpected problem occured during version sanity check", th);
        }
    }
}
