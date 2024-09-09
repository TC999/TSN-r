package com.facebook.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringConfigRegistry {

    /* renamed from: b  reason: collision with root package name */
    private static final SpringConfigRegistry f37079b = new SpringConfigRegistry(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<SpringConfig, String> f37080a = new HashMap();

    SpringConfigRegistry(boolean z3) {
        if (z3) {
            a(SpringConfig.f37076c, "default config");
        }
    }

    public static SpringConfigRegistry c() {
        return f37079b;
    }

    public boolean a(SpringConfig springConfig, String str) {
        if (springConfig != null) {
            if (str != null) {
                if (this.f37080a.containsKey(springConfig)) {
                    return false;
                }
                this.f37080a.put(springConfig, str);
                return true;
            }
            throw new IllegalArgumentException("configName is required");
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Map<SpringConfig, String> b() {
        return Collections.unmodifiableMap(this.f37080a);
    }

    public void d() {
        this.f37080a.clear();
    }

    public boolean e(SpringConfig springConfig) {
        if (springConfig != null) {
            return this.f37080a.remove(springConfig) != null;
        }
        throw new IllegalArgumentException("springConfig is required");
    }
}
