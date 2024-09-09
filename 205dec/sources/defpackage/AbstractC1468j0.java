package defpackage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* renamed from: j0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class AbstractC1468j0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f55207a;

    /* renamed from: b  reason: collision with root package name */
    public static final P f55208b = new P();

    /* renamed from: c  reason: collision with root package name */
    public static final G0 f55209c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f55210d = {"1.6", "1.7"};

    /* renamed from: e  reason: collision with root package name */
    public static final String f55211e = "org/slf4j/impl/StaticLoggerBinder.class";

    public static final void a() {
        try {
            LinkedHashSet c4 = c();
            f(c4);
            StaticLoggerBinder.getSingleton();
            f55207a = 3;
            e(c4);
            b();
        } catch (Exception e4) {
            f55207a = 2;
            AbstractC1457e.k("Failed to instantiate SLF4J LoggerFactory", e4);
            throw new IllegalStateException("Unexpected initialization failure", e4);
        } catch (NoClassDefFoundError e5) {
            String message = e5.getMessage();
            if (message == null || (message.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1 && message.indexOf("org.slf4j.impl.StaticLoggerBinder") == -1)) {
                f55207a = 2;
                AbstractC1457e.k("Failed to instantiate SLF4J LoggerFactory", e5);
                throw e5;
            }
            f55207a = 4;
            AbstractC1457e.j("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            AbstractC1457e.j("Defaulting to no-operation (NOP) logger implementation");
            AbstractC1457e.j("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e6) {
            String message2 = e6.getMessage();
            if (message2 != null && message2.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1) {
                f55207a = 2;
                AbstractC1457e.j("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                AbstractC1457e.j("Your binding is version 1.5.5 or earlier.");
                AbstractC1457e.j("Upgrade your binding to version 1.6.x.");
            }
            throw e6;
        }
    }

    public static final void b() {
        P p3 = f55208b;
        p3.getClass();
        ArrayList arrayList = new ArrayList();
        synchronized (((List) p3.f53a)) {
            arrayList.addAll((List) p3.f53a);
        }
        if (arrayList.size() == 0) {
            return;
        }
        AbstractC1457e.j("The following loggers will not work because they were created");
        AbstractC1457e.j("during the default configuration phase of the underlying logging system.");
        AbstractC1457e.j("See also http://www.slf4j.org/codes.html#substituteLogger");
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            AbstractC1457e.j((String) arrayList.get(i4));
        }
    }

    public static LinkedHashSet c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = AbstractC1468j0.class.getClassLoader();
            String str = f55211e;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e4) {
            AbstractC1457e.k("Error getting resources from path", e4);
        }
        return linkedHashSet;
    }

    public static ILoggerFactory d() {
        if (f55207a == 0) {
            f55207a = 1;
            a();
            if (f55207a == 3) {
                g();
            }
        }
        int i4 = f55207a;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return f55209c;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return StaticLoggerBinder.getSingleton().getLoggerFactory();
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return f55208b;
    }

    public static void e(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            AbstractC1457e.j("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
        }
    }

    public static void f(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            AbstractC1457e.j("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                AbstractC1457e.j("Found binding in [" + ((URL) it.next()) + "]");
            }
            AbstractC1457e.j("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void g() {
        String[] strArr;
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            int i4 = 0;
            boolean z3 = false;
            while (true) {
                strArr = f55210d;
                if (i4 >= strArr.length) {
                    break;
                }
                if (str.startsWith(strArr[i4])) {
                    z3 = true;
                }
                i4++;
            }
            if (z3) {
                return;
            }
            AbstractC1457e.j("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(strArr).toString());
            AbstractC1457e.j("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            AbstractC1457e.k("Unexpected problem occured during version sanity check", th);
        }
    }
}
