package com.amap.api.col.p0463l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.v5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CrashManager {

    /* renamed from: a */
    private SDKInfo f5563a;

    /* compiled from: CrashManager.java */
    /* renamed from: com.amap.api.col.3l.v5$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C1972a {

        /* renamed from: a */
        public static Map<String, CrashManager> f5564a = new HashMap();
    }

    private CrashManager(SDKInfo sDKInfo) {
        this.f5563a = sDKInfo;
    }

    /* renamed from: a */
    public static CrashManager m53654a(SDKInfo sDKInfo) {
        if (C1972a.f5564a.get(sDKInfo.m54400a()) == null) {
            C1972a.f5564a.put(sDKInfo.m54400a(), new CrashManager(sDKInfo));
        }
        return C1972a.f5564a.get(sDKInfo.m54400a());
    }

    /* renamed from: b */
    public final void m53653b(Context context, boolean z, boolean z2) {
        SPConfig.m53399b(context, this.f5563a, "sckey", String.valueOf(z));
        if (z) {
            SPConfig.m53399b(context, this.f5563a, "scisf", String.valueOf(z2));
        }
    }

    /* renamed from: c */
    public final boolean m53652c(Context context) {
        try {
            return Boolean.parseBoolean(SPConfig.m53400a(context, this.f5563a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    public final boolean m53651d(Context context) {
        try {
            return Boolean.parseBoolean(SPConfig.m53400a(context, this.f5563a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }
}
