package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MDC.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final String f61719a = "http://www.slf4j.org/codes.html#null_MDCA";

    /* renamed from: b  reason: collision with root package name */
    static final String f61720b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";

    /* renamed from: c  reason: collision with root package name */
    static l3.c f61721c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: MDC.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final String f61722a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e.h(this.f61722a);
        }

        private b(String str) {
            this.f61722a = str;
        }
    }

    static {
        try {
            f61721c = a();
        } catch (Exception e4) {
            j.d("MDC binding unsuccessful.", e4);
        } catch (NoClassDefFoundError e5) {
            f61721c = new org.slf4j.helpers.f();
            String message = e5.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                j.c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                j.c("Defaulting to no-operation MDCAdapter implementation.");
                j.c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e5;
        }
    }

    private e() {
    }

    private static l3.c a() throws NoClassDefFoundError {
        try {
            return org.slf4j.impl.d.c().a();
        } catch (NoSuchMethodError unused) {
            return org.slf4j.impl.d.f61772a.a();
        }
    }

    public static void b() {
        l3.c cVar = f61721c;
        if (cVar != null) {
            cVar.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static String c(String str) throws IllegalArgumentException {
        if (str != null) {
            l3.c cVar = f61721c;
            if (cVar != null) {
                return cVar.get(str);
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static Map<String, String> d() {
        l3.c cVar = f61721c;
        if (cVar != null) {
            return cVar.b();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static l3.c e() {
        return f61721c;
    }

    public static void f(String str, String str2) throws IllegalArgumentException {
        if (str != null) {
            l3.c cVar = f61721c;
            if (cVar != null) {
                cVar.a(str, str2);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static b g(String str, String str2) throws IllegalArgumentException {
        f(str, str2);
        return new b(str);
    }

    public static void h(String str) throws IllegalArgumentException {
        if (str != null) {
            l3.c cVar = f61721c;
            if (cVar != null) {
                cVar.remove(str);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static void i(Map<String, String> map) {
        l3.c cVar = f61721c;
        if (cVar != null) {
            cVar.c(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
