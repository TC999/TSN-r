package com.qq.e.comm.plugin.q0.t;

import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f45556a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f45557b;

    public a(c cVar, JSONObject jSONObject) {
        this.f45556a = cVar;
        this.f45557b = jSONObject;
    }

    public JSONObject a() {
        return this.f45557b;
    }

    public c b() {
        return this.f45556a;
    }

    public String toString() {
        return "event<" + this.f45556a + "," + this.f45557b + ">";
    }

    public static a a(String str, JSONObject jSONObject) {
        c a4 = c.a(str);
        if (a4 == null) {
            d1.a("Unknown ADEvent Type:" + str);
            return null;
        }
        return new a(a4, jSONObject);
    }
}
