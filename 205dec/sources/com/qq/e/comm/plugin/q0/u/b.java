package com.qq.e.comm.plugin.q0.u;

import android.view.View;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b extends j {

    /* renamed from: b  reason: collision with root package name */
    private static final String f45575b = "b";

    /* renamed from: a  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.g0.e f45576a;

    public b(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45576a = eVar;
    }

    protected abstract com.qq.e.comm.plugin.q0.s.f<String> a();

    @Override // com.qq.e.comm.plugin.q0.u.j
    public final com.qq.e.comm.plugin.q0.s.f<String> a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String a4 = dVar.a();
        String str = f45575b;
        d1.a(str, "handleAction : " + a4);
        View a5 = hVar.a();
        if ("getVideoAdInfo".equals(a4)) {
            return a(a5);
        }
        if ("onClick".equals(a4)) {
            return a(a5, dVar.d());
        }
        if ("isViewable".equals(a4)) {
            return b(a5);
        }
        if ("replayVideo".equals(a4)) {
            return a();
        }
        return new com.qq.e.comm.plugin.q0.s.f<>(1000, "Unsupported action");
    }

    protected abstract void a(View view, String str, long j4);

    protected com.qq.e.comm.plugin.q0.s.f<String> b(View view) {
        if (view == null) {
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
        return a(o2.a(view.getContext(), view, 100));
    }

    protected abstract JSONObject c(View view) throws JSONException;

    protected com.qq.e.comm.plugin.q0.s.f<String> a(View view) {
        if (view == null) {
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            b0 p02 = this.f45576a.p0();
            JSONObject c4 = c(view);
            jSONObject.put("code", 0);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a4 = p02.a();
            jSONObject2.put("adInfo", c4);
            jSONObject2.put("cfg", a4);
            jSONObject.put("data", jSONObject2);
            return new com.qq.e.comm.plugin.q0.s.f<>(jSONObject.toString());
        } catch (JSONException e4) {
            d1.a(f45575b, "handleGetVideoAdInfo", e4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
    }

    protected com.qq.e.comm.plugin.q0.s.f<String> a(View view, JSONObject jSONObject) {
        long j4;
        String str;
        if (jSONObject != null) {
            str = jSONObject.optString("antiSpam");
            j4 = jSONObject.optLong("supportMarket");
        } else {
            j4 = 0;
            str = null;
        }
        d1.a(f45575b, "handleOnClick, supportMarket=%s", Long.valueOf(j4));
        a(view, str, j4);
        return new com.qq.e.comm.plugin.q0.s.f<>(null);
    }

    public com.qq.e.comm.plugin.q0.s.f<String> a(boolean z3) {
        String str = f45575b;
        d1.a(str, "isViewable : " + z3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z3);
            return new com.qq.e.comm.plugin.q0.s.f<>(jSONObject.toString());
        } catch (Exception e4) {
            String str2 = f45575b;
            d1.a(str2, "isViewable JSONException : " + e4.getMessage());
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
    }
}
