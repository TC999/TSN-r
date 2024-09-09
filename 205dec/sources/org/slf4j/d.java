package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.h;
import org.slf4j.helpers.i;
import org.slf4j.helpers.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LoggerFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final String f61696a = "http://www.slf4j.org/codes.html";

    /* renamed from: b  reason: collision with root package name */
    static final String f61697b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";

    /* renamed from: c  reason: collision with root package name */
    static final String f61698c = "http://www.slf4j.org/codes.html#multiple_bindings";

    /* renamed from: d  reason: collision with root package name */
    static final String f61699d = "http://www.slf4j.org/codes.html#null_LF";

    /* renamed from: e  reason: collision with root package name */
    static final String f61700e = "http://www.slf4j.org/codes.html#version_mismatch";

    /* renamed from: f  reason: collision with root package name */
    static final String f61701f = "http://www.slf4j.org/codes.html#substituteLogger";

    /* renamed from: g  reason: collision with root package name */
    static final String f61702g = "http://www.slf4j.org/codes.html#loggerNameMismatch";

    /* renamed from: h  reason: collision with root package name */
    static final String f61703h = "http://www.slf4j.org/codes.html#replay";

    /* renamed from: i  reason: collision with root package name */
    static final String f61704i = "http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: j  reason: collision with root package name */
    static final String f61705j = "org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: k  reason: collision with root package name */
    static final int f61706k = 0;

    /* renamed from: l  reason: collision with root package name */
    static final int f61707l = 1;

    /* renamed from: m  reason: collision with root package name */
    static final int f61708m = 2;

    /* renamed from: n  reason: collision with root package name */
    static final int f61709n = 3;

    /* renamed from: o  reason: collision with root package name */
    static final int f61710o = 4;

    /* renamed from: p  reason: collision with root package name */
    static volatile int f61711p = 0;

    /* renamed from: s  reason: collision with root package name */
    static final String f61714s = "slf4j.detectLoggerNameMismatch";

    /* renamed from: t  reason: collision with root package name */
    static final String f61715t = "java.vendor.url";

    /* renamed from: q  reason: collision with root package name */
    static i f61712q = new i();

    /* renamed from: r  reason: collision with root package name */
    static org.slf4j.helpers.e f61713r = new org.slf4j.helpers.e();

    /* renamed from: u  reason: collision with root package name */
    static boolean f61716u = j.f("slf4j.detectLoggerNameMismatch");

    /* renamed from: v  reason: collision with root package name */
    private static final String[] f61717v = {"1.6", "1.7"};

    /* renamed from: w  reason: collision with root package name */
    private static String f61718w = "org/slf4j/impl/StaticLoggerBinder.class";

    private d() {
    }

    private static final void a() {
        Set<URL> set = null;
        try {
            if (!l()) {
                set = f();
                s(set);
            }
            org.slf4j.impl.c.c();
            f61711p = 3;
            r(set);
            g();
            p();
            f61712q.b();
        } catch (Exception e4) {
            e(e4);
            throw new IllegalStateException("Unexpected initialization failure", e4);
        } catch (NoClassDefFoundError e5) {
            if (m(e5.getMessage())) {
                f61711p = 4;
                j.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                j.c("Defaulting to no-operation (NOP) logger implementation");
                j.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            e(e5);
            throw e5;
        } catch (NoSuchMethodError e6) {
            String message = e6.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f61711p = 2;
                j.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                j.c("Your binding is version 1.5.5 or earlier.");
                j.c("Upgrade your binding to version 1.6.x.");
            }
            throw e6;
        }
    }

    private static void b(org.slf4j.event.d dVar, int i4) {
        if (dVar.h().d()) {
            c(i4);
        } else if (dVar.h().e()) {
        } else {
            d();
        }
    }

    private static void c(int i4) {
        j.c("A number (" + i4 + ") of logging calls during the initialization phase have been intercepted and are");
        j.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        j.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        j.c("The following set of substitute loggers may have been accessed");
        j.c("during the initialization phase. Logging calls during this");
        j.c("phase were not honored. However, subsequent logging calls to these");
        j.c("loggers will work as normally expected.");
        j.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        f61711p = 2;
        j.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = d.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f61718w);
            } else {
                resources = classLoader.getResources(f61718w);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e4) {
            j.d("Error getting resources from path", e4);
        }
        return linkedHashSet;
    }

    private static void g() {
        synchronized (f61712q) {
            f61712q.f();
            for (h hVar : f61712q.e()) {
                hVar.h(j(hVar.getName()));
            }
        }
    }

    public static a h() {
        if (f61711p == 0) {
            synchronized (d.class) {
                if (f61711p == 0) {
                    f61711p = 1;
                    o();
                }
            }
        }
        int i4 = f61711p;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return f61713r;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return org.slf4j.impl.c.c().a();
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return f61712q;
    }

    public static c i(Class<?> cls) {
        Class<?> a4;
        c j4 = j(cls.getName());
        if (f61716u && (a4 = j.a()) != null && n(cls, a4)) {
            j.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", j4.getName(), a4.getName()));
            j.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return j4;
    }

    public static c j(String str) {
        return h().a(str);
    }

    private static boolean k(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean l() {
        String g4 = j.g("java.vendor.url");
        if (g4 == null) {
            return false;
        }
        return g4.toLowerCase().contains("android");
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static boolean n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() {
        a();
        if (f61711p == 3) {
            u();
        }
    }

    private static void p() {
        LinkedBlockingQueue<org.slf4j.event.d> c4 = f61712q.c();
        int size = c4.size();
        ArrayList<org.slf4j.event.d> arrayList = new ArrayList(128);
        int i4 = 0;
        while (c4.drainTo(arrayList, 128) != 0) {
            for (org.slf4j.event.d dVar : arrayList) {
                q(dVar);
                int i5 = i4 + 1;
                if (i4 == 0) {
                    b(dVar, size);
                }
                i4 = i5;
            }
            arrayList.clear();
        }
    }

    private static void q(org.slf4j.event.d dVar) {
        if (dVar == null) {
            return;
        }
        h h4 = dVar.h();
        String name = h4.getName();
        if (!h4.f()) {
            if (h4.e()) {
                return;
            }
            if (h4.d()) {
                h4.g(dVar);
                return;
            } else {
                j.c(name);
                return;
            }
        }
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void r(Set<URL> set) {
        if (set == null || !k(set)) {
            return;
        }
        j.c("Actual binding is of type [" + org.slf4j.impl.c.c().b() + "]");
    }

    private static void s(Set<URL> set) {
        if (k(set)) {
            j.c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                j.c("Found binding in [" + it.next() + "]");
            }
            j.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    static void t() {
        f61711p = 0;
    }

    private static final void u() {
        try {
            String str = org.slf4j.impl.c.f61769c;
            boolean z3 = false;
            for (String str2 : f61717v) {
                if (str.startsWith(str2)) {
                    z3 = true;
                }
            }
            if (z3) {
                return;
            }
            j.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f61717v).toString());
            j.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            j.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
