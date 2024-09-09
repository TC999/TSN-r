package com.mbridge.msdk.foundation.entity;

import java.util.Set;

/* compiled from: InstallApp.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private String f39294a;

    /* renamed from: b  reason: collision with root package name */
    private String f39295b;

    public i() {
    }

    public final String a() {
        return this.f39294a;
    }

    public final String b() {
        return this.f39295b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            String str = this.f39294a;
            if (str == null) {
                if (iVar.f39294a != null) {
                    return false;
                }
            } else if (!str.equals(iVar.f39294a)) {
                return false;
            }
            String str2 = this.f39295b;
            if (str2 == null) {
                if (iVar.f39295b != null) {
                    return false;
                }
            } else if (!str2.equals(iVar.f39295b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f39294a;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f39295b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public i(String str, String str2) {
        this.f39294a = str;
        this.f39295b = str2;
    }

    public final void a(String str) {
        this.f39294a = str;
    }

    public final void b(String str) {
        this.f39295b = str;
    }

    public static String a(Set<i> set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (i iVar : set) {
                        stringBuffer.append("{\"campaignId\":");
                        stringBuffer.append(iVar.f39294a + ",");
                        stringBuffer.append("\"packageName\":");
                        stringBuffer.append(iVar.f39295b + "},");
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
