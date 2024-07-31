package com.facebook.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SpringConfigRegistry {

    /* renamed from: b */
    private static final SpringConfigRegistry f23483b = new SpringConfigRegistry(true);

    /* renamed from: a */
    private final Map<SpringConfig, String> f23484a = new HashMap();

    SpringConfigRegistry(boolean z) {
        if (z) {
            m35561a(SpringConfig.f23480c, "default config");
        }
    }

    /* renamed from: c */
    public static SpringConfigRegistry m35559c() {
        return f23483b;
    }

    /* renamed from: a */
    public boolean m35561a(SpringConfig springConfig, String str) {
        if (springConfig != null) {
            if (str != null) {
                if (this.f23484a.containsKey(springConfig)) {
                    return false;
                }
                this.f23484a.put(springConfig, str);
                return true;
            }
            throw new IllegalArgumentException("configName is required");
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    /* renamed from: b */
    public Map<SpringConfig, String> m35560b() {
        return Collections.unmodifiableMap(this.f23484a);
    }

    /* renamed from: d */
    public void m35558d() {
        this.f23484a.clear();
    }

    /* renamed from: e */
    public boolean m35557e(SpringConfig springConfig) {
        if (springConfig != null) {
            return this.f23484a.remove(springConfig) != null;
        }
        throw new IllegalArgumentException("springConfig is required");
    }
}
