package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.C15428j;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.impl.StaticMDCBinder;
import p595g2.MDCAdapter;

/* renamed from: org.slf4j.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MDC {

    /* renamed from: a */
    static final String f44319a = "http://www.slf4j.org/codes.html#null_MDCA";

    /* renamed from: b */
    static final String f44320b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";

    /* renamed from: c */
    static MDCAdapter f44321c;

    /* compiled from: MDC.java */
    /* renamed from: org.slf4j.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15426b implements Closeable {

        /* renamed from: a */
        private final String f44322a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            MDC.m2636h(this.f44322a);
        }

        private C15426b(String str) {
            this.f44322a = str;
        }
    }

    static {
        try {
            f44321c = m2643a();
        } catch (Exception e) {
            C15428j.m2565d("MDC binding unsuccessful.", e);
        } catch (NoClassDefFoundError e2) {
            f44321c = new NOPMDCAdapter();
            String message = e2.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                C15428j.m2566c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                C15428j.m2566c("Defaulting to no-operation MDCAdapter implementation.");
                C15428j.m2566c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e2;
        }
    }

    private MDC() {
    }

    /* renamed from: a */
    private static MDCAdapter m2643a() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.m2549c().m2551a();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.f44372a.m2551a();
        }
    }

    /* renamed from: b */
    public static void m2642b() {
        MDCAdapter mDCAdapter = f44321c;
        if (mDCAdapter != null) {
            mDCAdapter.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    /* renamed from: c */
    public static String m2641c(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = f44321c;
            if (mDCAdapter != null) {
                return mDCAdapter.get(str);
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    /* renamed from: d */
    public static Map<String, String> m2640d() {
        MDCAdapter mDCAdapter = f44321c;
        if (mDCAdapter != null) {
            return mDCAdapter.mo2582b();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    /* renamed from: e */
    public static MDCAdapter m2639e() {
        return f44321c;
    }

    /* renamed from: f */
    public static void m2638f(String str, String str2) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = f44321c;
            if (mDCAdapter != null) {
                mDCAdapter.mo2583a(str, str2);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    /* renamed from: g */
    public static C15426b m2637g(String str, String str2) throws IllegalArgumentException {
        m2638f(str, str2);
        return new C15426b(str);
    }

    /* renamed from: h */
    public static void m2636h(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = f44321c;
            if (mDCAdapter != null) {
                mDCAdapter.remove(str);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    /* renamed from: i */
    public static void m2635i(Map<String, String> map) {
        MDCAdapter mDCAdapter = f44321c;
        if (mDCAdapter != null) {
            mDCAdapter.mo2581c(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
