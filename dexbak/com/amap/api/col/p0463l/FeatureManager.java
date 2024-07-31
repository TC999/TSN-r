package com.amap.api.col.p0463l;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.fa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FeatureManager {

    /* renamed from: a */
    private Map<String, Boolean> f4168a;

    /* renamed from: b */
    private AtomicBoolean f4169b;

    /* compiled from: FeatureManager.java */
    /* renamed from: com.amap.api.col.3l.fa$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1809a {

        /* renamed from: a */
        private static FeatureManager f4170a = new FeatureManager((byte) 0);
    }

    /* synthetic */ FeatureManager(byte b) {
        this();
    }

    /* renamed from: a */
    public static FeatureManager m55016a() {
        return C1809a.f4170a;
    }

    /* renamed from: e */
    private void m55012e() {
        this.f4168a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f4168a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f4168a.put("feature_terrain", bool);
    }

    /* renamed from: b */
    public final void m55015b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mvt_able");
        AuthConfigManager.m55040x(optString, true);
        this.f4168a.put("feature_mvt", Boolean.valueOf(AuthConfigManager.m55040x(optString, true)));
        this.f4168a.put("feature_gltf", Boolean.valueOf(AuthConfigManager.m55040x(jSONObject.optString("gltf_able"), false)));
        this.f4168a.put("feature_terrain", Boolean.valueOf(AuthConfigManager.m55040x(jSONObject.optString("terrain_able"), false)));
        this.f4169b.set(true);
    }

    /* renamed from: c */
    public final boolean m55014c(String str) {
        if (this.f4168a.containsKey(str)) {
            return this.f4168a.get(str).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m55013d() {
        return this.f4169b.get();
    }

    private FeatureManager() {
        this.f4168a = new ConcurrentHashMap();
        this.f4169b = new AtomicBoolean(false);
        m55012e();
    }
}
