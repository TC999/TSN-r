package com.qq.e.comm.plugin.m0;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.qq.e.comm.plugin.d0.d.h;
import com.qq.e.comm.plugin.util.a2;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.v0;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static JSONObject a() throws JSONException {
        com.qq.e.comm.plugin.d0.a d4 = com.qq.e.comm.plugin.d0.a.d();
        JSONObject a4 = a(d4.f());
        a4.put("app", a(d4.b()));
        a4.put("c", a(d4.c()));
        a4.put("sdk", a(d4.e()));
        return a4;
    }

    public static JSONObject b(com.qq.e.comm.plugin.d0.e.c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.putOpt("did", cVar.h());
            jSONObject.putOpt(LiveConfigKey.MEDIUM, cVar.f42280j);
            jSONObject.putOpt("lg", cVar.k());
            jSONObject.putOpt("w", Integer.valueOf(cVar.i()));
            jSONObject.putOpt("h", Integer.valueOf(cVar.g()));
            jSONObject.putOpt("dd", Integer.valueOf(cVar.f()));
            jSONObject.putOpt("apil", Integer.valueOf(cVar.r()));
            jSONObject.putOpt("os", "android");
            jSONObject.putOpt("op", cVar.o());
            jSONObject.putOpt("mf", Build.MANUFACTURER);
            a2.a(jSONObject, "/launch");
        }
        return jSONObject;
    }

    public static JSONObject a(h hVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hVar != null) {
            jSONObject.putOpt("suid", hVar.e());
            jSONObject.putOpt("sid", hVar.d());
        }
        return jSONObject;
    }

    public static JSONObject a(com.qq.e.comm.plugin.d0.c.d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", e1.i());
        jSONObject.putOpt("pv", Integer.valueOf(dVar.b()));
        jSONObject.putOpt("sdk_st", Integer.valueOf(e1.g()));
        jSONObject.putOpt("sdk_cnl", Integer.valueOf(e1.d()));
        if (!TextUtils.isEmpty(e1.e())) {
            jSONObject.putOpt("sdk_ex1", e1.e());
        }
        if (!TextUtils.isEmpty(e1.f())) {
            jSONObject.putOpt("sdk_ex2", e1.f());
        }
        return jSONObject;
    }

    public static JSONObject a(h hVar, com.qq.e.comm.plugin.d0.c.d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hVar != null) {
            jSONObject.putOpt("app", hVar.a());
            jSONObject.putOpt("sdk", hVar.b());
        }
        if (dVar != null) {
            jSONObject.putOpt("jar", dVar.a());
            jSONObject.putOpt("plugin_version", Integer.valueOf(dVar.b()));
        }
        return jSONObject;
    }

    public static JSONObject a(com.qq.e.comm.plugin.d0.e.a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("an", aVar.b());
            jSONObject.putOpt("appkey", aVar.a());
            jSONObject.putOpt("appv", aVar.d());
            jSONObject.putOpt("appn", aVar.c());
        }
        return jSONObject;
    }

    public static JSONObject a(com.qq.e.comm.plugin.d0.e.c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.putOpt("so", cVar.q());
            jSONObject.putOpt("dn", cVar.e());
            String a4 = v0.a();
            if (!TextUtils.isEmpty(a4)) {
                jSONObject.putOpt("cell_native", a4);
            }
            for (Map.Entry<String, String> entry : cVar.j().entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
