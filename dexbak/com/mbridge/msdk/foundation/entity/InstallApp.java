package com.mbridge.msdk.foundation.entity;

import java.util.Set;

/* renamed from: com.mbridge.msdk.foundation.entity.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class InstallApp {

    /* renamed from: a */
    private String f30473a;

    /* renamed from: b */
    private String f30474b;

    public InstallApp() {
    }

    /* renamed from: a */
    public final String m22542a() {
        return this.f30473a;
    }

    /* renamed from: b */
    public final String m22539b() {
        return this.f30474b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InstallApp.class == obj.getClass()) {
            InstallApp installApp = (InstallApp) obj;
            String str = this.f30473a;
            if (str == null) {
                if (installApp.f30473a != null) {
                    return false;
                }
            } else if (!str.equals(installApp.f30473a)) {
                return false;
            }
            String str2 = this.f30474b;
            if (str2 == null) {
                if (installApp.f30474b != null) {
                    return false;
                }
            } else if (!str2.equals(installApp.f30474b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f30473a;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f30474b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public InstallApp(String str, String str2) {
        this.f30473a = str;
        this.f30474b = str2;
    }

    /* renamed from: a */
    public final void m22541a(String str) {
        this.f30473a = str;
    }

    /* renamed from: b */
    public final void m22538b(String str) {
        this.f30474b = str;
    }

    /* renamed from: a */
    public static String m22540a(Set<InstallApp> set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (InstallApp installApp : set) {
                        stringBuffer.append("{\"campaignId\":");
                        stringBuffer.append(installApp.f30473a + ",");
                        stringBuffer.append("\"packageName\":");
                        stringBuffer.append(installApp.f30474b + "},");
                    }
                    return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
