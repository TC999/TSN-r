package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AplAction.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ab extends z {

    /* renamed from: a  reason: collision with root package name */
    private String f52497a;

    /* renamed from: b  reason: collision with root package name */
    private String f52498b;

    public ab(String str, ArrayList<aa> arrayList) {
        super(str, arrayList);
        this.f52497a = "";
        this.f52498b = "";
    }

    @Override // com.umeng.analytics.pro.z, com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a4 = super.a(str, jSONObject);
        if (a4 != null) {
            try {
                a4.put("batch", this.f52497a);
                a4.put("action", this.f52498b);
            } catch (Throwable unused) {
            }
        }
        return a4;
    }

    public void c(String str) {
        this.f52497a = str;
    }

    public String d() {
        return this.f52497a;
    }

    public String e() {
        return this.f52498b;
    }

    public void d(String str) {
        this.f52498b = str;
    }
}
