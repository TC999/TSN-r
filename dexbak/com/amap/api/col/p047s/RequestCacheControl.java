package com.amap.api.col.p047s;

import com.github.mikephil.charting.utils.Utils;
import java.util.HashMap;

/* renamed from: com.amap.api.col.s.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestCacheControl {

    /* renamed from: b */
    private static volatile RequestCacheControl f6294b;

    /* renamed from: a */
    private HashMap<String, RequestCacheWorker> f6295a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestCacheControl.java */
    /* renamed from: com.amap.api.col.s.n$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2096a {

        /* renamed from: a */
        private boolean f6296a = true;

        /* renamed from: b */
        private long f6297b = 86400;

        /* renamed from: c */
        private int f6298c = 10;

        /* renamed from: d */
        private double f6299d = Utils.DOUBLE_EPSILON;

        /* renamed from: a */
        public final void m52757a(double d) {
            this.f6299d = d;
        }

        /* renamed from: b */
        public final void m52756b(int i) {
            this.f6298c = i;
        }

        /* renamed from: c */
        public final void m52755c(long j) {
            this.f6297b = j;
        }

        /* renamed from: d */
        public final void m52754d(boolean z) {
            this.f6296a = z;
        }

        /* renamed from: e */
        public final boolean m52753e() {
            return this.f6296a;
        }

        /* renamed from: f */
        public final long m52752f() {
            return this.f6297b;
        }

        /* renamed from: g */
        public final int m52751g() {
            return this.f6298c;
        }

        /* renamed from: h */
        public final double m52750h() {
            return this.f6299d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestCacheControl.java */
    /* renamed from: com.amap.api.col.s.n$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2097b {

        /* renamed from: a */
        String f6300a;

        /* renamed from: b */
        Object f6301b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C2097b.class == obj.getClass()) {
                C2097b c2097b = (C2097b) obj;
                String str = this.f6300a;
                if (str == null) {
                    return c2097b.f6300a == null && this.f6301b == c2097b.f6301b;
                } else if (str.equals(c2097b.f6300a) && this.f6301b == c2097b.f6301b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f6300a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f6301b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestCacheControl.java */
    /* renamed from: com.amap.api.col.s.n$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2098c {

        /* renamed from: a */
        Object f6302a;

        /* renamed from: b */
        boolean f6303b;

        public C2098c(Object obj, boolean z) {
            this.f6302a = obj;
            this.f6303b = z;
        }
    }

    /* renamed from: b */
    public static RequestCacheControl m52764b() {
        if (f6294b == null) {
            synchronized (RequestCacheControl.class) {
                if (f6294b == null) {
                    f6294b = new RequestCacheControl();
                }
            }
        }
        return f6294b;
    }

    /* renamed from: a */
    public final C2098c m52765a(C2097b c2097b) {
        C2098c m52730a;
        if (c2097b == null) {
            return null;
        }
        for (RequestCacheWorker requestCacheWorker : this.f6295a.values()) {
            if (requestCacheWorker != null && (m52730a = requestCacheWorker.m52730a(c2097b)) != null) {
                return m52730a;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final synchronized RequestCacheWorker m52763c(String str) {
        return this.f6295a.get(str);
    }

    /* renamed from: d */
    public final void m52762d(C2096a c2096a) {
        if (c2096a == null) {
            return;
        }
        for (RequestCacheWorker requestCacheWorker : this.f6295a.values()) {
            if (requestCacheWorker != null) {
                requestCacheWorker.mo52711c(c2096a);
            }
        }
    }

    /* renamed from: e */
    public final void m52761e(C2097b c2097b, Object obj) {
        for (RequestCacheWorker requestCacheWorker : this.f6295a.values()) {
            if (requestCacheWorker != null) {
                requestCacheWorker.m52728d(c2097b, obj);
            }
        }
    }

    /* renamed from: f */
    public final void m52760f(String str, C2096a c2096a) {
        RequestCacheWorker requestCacheWorker;
        if (str == null || c2096a == null || (requestCacheWorker = this.f6295a.get(str)) == null) {
            return;
        }
        requestCacheWorker.mo52711c(c2096a);
    }

    /* renamed from: g */
    public final synchronized void m52759g(String str, RequestCacheWorker requestCacheWorker) {
        this.f6295a.put(str, requestCacheWorker);
    }

    /* renamed from: h */
    public final boolean m52758h(C2097b c2097b) {
        if (c2097b == null) {
            return false;
        }
        for (RequestCacheWorker requestCacheWorker : this.f6295a.values()) {
            if (requestCacheWorker != null && requestCacheWorker.m52724j(c2097b)) {
                return true;
            }
        }
        return false;
    }
}
