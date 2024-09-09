package com.baidu.liantian.rp.a;

import com.baidu.liantian.b.e;
import org.json.JSONObject;

/* compiled from: ReportConfigInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f12240a;

    /* renamed from: b  reason: collision with root package name */
    public String f12241b;

    /* renamed from: c  reason: collision with root package name */
    public String f12242c;

    /* renamed from: d  reason: collision with root package name */
    public String f12243d;

    /* renamed from: e  reason: collision with root package name */
    public String f12244e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f12240a);
            jSONObject.put("1", aVar.f12242c);
            jSONObject.put("2", aVar.f12243d);
            jSONObject.put("3", aVar.f12244e);
            jSONObject.put("4", aVar.f12241b);
        } catch (Throwable unused) {
            e.a();
        }
        return jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f12243d;
            if (str == null) {
                if (aVar.f12243d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f12243d)) {
                return false;
            }
            String str2 = this.f12244e;
            if (str2 == null) {
                if (aVar.f12244e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f12244e)) {
                return false;
            }
            String str3 = this.f12241b;
            if (str3 == null) {
                if (aVar.f12241b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f12241b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f12243d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f12244e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f12241b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f12240a = jSONObject.optString("0");
            aVar.f12242c = jSONObject.optString("1");
            aVar.f12243d = jSONObject.optString("2");
            aVar.f12244e = jSONObject.optString("3");
            aVar.f12241b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            e.a();
            return null;
        }
    }
}
