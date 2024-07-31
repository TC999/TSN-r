package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.tools.z */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameOptimizedController {

    /* renamed from: a */
    private volatile ConcurrentHashMap<String, Boolean> f31171a;

    /* renamed from: b */
    private volatile ConcurrentHashMap<String, Integer> f31172b;

    /* renamed from: c */
    private volatile Setting f31173c;

    /* renamed from: d */
    private volatile JSONObject f31174d;

    /* renamed from: e */
    private final Object f31175e;

    /* renamed from: f */
    private final Object f31176f;

    /* renamed from: g */
    private final Object f31177g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SameOptimizedController.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.z$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11437a {

        /* renamed from: a */
        private static final SameOptimizedController f31178a = new SameOptimizedController();
    }

    /* renamed from: a */
    public static SameOptimizedController m21727a() {
        return C11437a.f31178a;
    }

    /* renamed from: b */
    private static Integer m21721b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private ConcurrentHashMap<String, Boolean> m21719c() {
        synchronized (this.f31175e) {
            if (this.f31171a == null) {
                this.f31171a = new ConcurrentHashMap<>(11);
            }
        }
        return this.f31171a;
    }

    /* renamed from: d */
    private ConcurrentHashMap<String, Integer> m21718d() {
        synchronized (this.f31176f) {
            if (this.f31172b == null) {
                this.f31172b = new ConcurrentHashMap<>(5);
            }
        }
        return this.f31172b;
    }

    private SameOptimizedController() {
        this.f31175e = new Object();
        this.f31176f = new Object();
        this.f31177g = new Object();
    }

    /* renamed from: b */
    private boolean m21720b(String str, boolean z) {
        if (m21723b()) {
            return z;
        }
        try {
            return this.f31174d.optInt(str, z ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z;
        }
    }

    /* renamed from: a */
    public final int m21726a(String str, int i) {
        Integer valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ConcurrentHashMap<String, Integer> m21718d = m21718d();
            Integer m21721b = m21721b(str, m21718d);
            if (m21721b != null) {
                return m21721b.intValue();
            }
            try {
                valueOf = Integer.valueOf(m21722b(str, i));
            } catch (Exception unused) {
                valueOf = Integer.valueOf(i);
            }
            m21718d.put(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused2) {
            return i;
        }
    }

    /* renamed from: b */
    private int m21722b(String str, int i) {
        if (m21723b()) {
            return i;
        }
        try {
            return this.f31174d.optInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: b */
    private boolean m21723b() {
        synchronized (this.f31177g) {
            if (this.f31173c == null) {
                try {
                    this.f31173c = SettingManager.m23261a().m23241g(SharedPerferenceManager.m22949a().m22944b(MBridgeConstans.SDK_APP_ID));
                } catch (Exception unused) {
                    this.f31173c = null;
                }
            }
            if (this.f31173c != null && this.f31174d == null) {
                this.f31174d = this.f31173c.m23287s();
            }
        }
        return this.f31173c == null || this.f31174d == null;
    }

    /* renamed from: a */
    public final boolean m21724a(String str, boolean z) {
        Boolean valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            ConcurrentHashMap<String, Boolean> m21719c = m21719c();
            Boolean m21725a = m21725a(str, m21719c);
            if (m21725a != null) {
                return m21725a.booleanValue();
            }
            try {
                valueOf = Boolean.valueOf(m21720b(str, z));
            } catch (Exception unused) {
                valueOf = Boolean.valueOf(z);
            }
            m21719c.put(str, valueOf);
            return valueOf.booleanValue();
        } catch (Exception unused2) {
            return z;
        }
    }

    /* renamed from: a */
    private static Boolean m21725a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
