package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: SameOptimizedController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Boolean> f39944a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Integer> f39945b;

    /* renamed from: c  reason: collision with root package name */
    private volatile com.mbridge.msdk.c.a f39946c;

    /* renamed from: d  reason: collision with root package name */
    private volatile JSONObject f39947d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f39948e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f39949f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f39950g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SameOptimizedController.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final z f39951a = new z();
    }

    public static z a() {
        return a.f39951a;
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.f39948e) {
            if (this.f39944a == null) {
                this.f39944a = new ConcurrentHashMap<>(11);
            }
        }
        return this.f39944a;
    }

    private ConcurrentHashMap<String, Integer> d() {
        synchronized (this.f39949f) {
            if (this.f39945b == null) {
                this.f39945b = new ConcurrentHashMap<>(5);
            }
        }
        return this.f39945b;
    }

    private z() {
        this.f39948e = new Object();
        this.f39949f = new Object();
        this.f39950g = new Object();
    }

    private boolean b(String str, boolean z3) {
        if (b()) {
            return z3;
        }
        try {
            return this.f39947d.optInt(str, z3 ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z3;
        }
    }

    public final int a(String str, int i4) {
        Integer valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i4;
            }
            ConcurrentHashMap<String, Integer> d4 = d();
            Integer b4 = b(str, d4);
            if (b4 != null) {
                return b4.intValue();
            }
            try {
                valueOf = Integer.valueOf(b(str, i4));
            } catch (Exception unused) {
                valueOf = Integer.valueOf(i4);
            }
            d4.put(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused2) {
            return i4;
        }
    }

    private int b(String str, int i4) {
        if (b()) {
            return i4;
        }
        try {
            return this.f39947d.optInt(str, i4);
        } catch (Exception unused) {
            return i4;
        }
    }

    private boolean b() {
        synchronized (this.f39950g) {
            if (this.f39946c == null) {
                try {
                    this.f39946c = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID));
                } catch (Exception unused) {
                    this.f39946c = null;
                }
            }
            if (this.f39946c != null && this.f39947d == null) {
                this.f39947d = this.f39946c.s();
            }
        }
        return this.f39946c == null || this.f39947d == null;
    }

    public final boolean a(String str, boolean z3) {
        Boolean valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return z3;
            }
            ConcurrentHashMap<String, Boolean> c4 = c();
            Boolean a4 = a(str, c4);
            if (a4 != null) {
                return a4.booleanValue();
            }
            try {
                valueOf = Boolean.valueOf(b(str, z3));
            } catch (Exception unused) {
                valueOf = Boolean.valueOf(z3);
            }
            c4.put(str, valueOf);
            return valueOf.booleanValue();
        } catch (Exception unused2) {
            return z3;
        }
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
