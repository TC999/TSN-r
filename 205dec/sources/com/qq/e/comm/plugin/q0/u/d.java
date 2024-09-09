package com.qq.e.comm.plugin.q0.u;

import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends j {

    /* renamed from: a  reason: collision with root package name */
    private String f45578a;

    public d(String str) {
        this.f45578a = str;
    }

    private void b(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        try {
            JSONObject d4 = dVar.d();
            if (d4 == null) {
                hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45551f, ""));
                return;
            }
            JSONArray jSONArray = d4.getJSONArray("settings");
            JSONObject jSONObject = new JSONObject();
            if (jSONArray != null) {
                com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
                JSONObject jSONObject2 = new JSONObject();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String string = jSONArray.getString(i4);
                    jSONObject2.put(string, f4.a(string, this.f45578a));
                }
                jSONObject.put("data", jSONObject2);
                jSONObject.put("code", 0);
            }
            hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45548c, jSONObject));
        } catch (JSONException unused) {
            d1.b("CommonServiceHandler", "Json exception!");
            hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, ""));
        }
    }

    @Override // com.qq.e.comm.plugin.q0.u.j
    public com.qq.e.comm.plugin.q0.s.f<String> a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String a4 = dVar.a();
        if (((a4.hashCode() == -1850459763 && a4.equals("getControlServerSettings")) ? (char) 0 : '\uffff') == 0) {
            b(hVar, dVar);
        }
        return new com.qq.e.comm.plugin.q0.s.f<>(null);
    }

    public String a() {
        return "gdtcommon";
    }
}
