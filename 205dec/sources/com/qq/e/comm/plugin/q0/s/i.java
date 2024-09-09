package com.qq.e.comm.plugin.q0.s;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.j;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends a {
    public i(com.qq.e.comm.plugin.q0.h hVar) {
        super(hVar);
    }

    private void c(d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.a())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", dVar.a());
                a(jSONObject.toString());
                return;
            } catch (JSONException e4) {
                a(new String[0]);
                d1.a(e4.getMessage(), e4);
                return;
            }
        }
        a(new String[0]);
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public f<String> a(String str) {
        JSONObject jSONObject;
        d1.a("UnJsBridge-jsPrompt", str);
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            v.b(100292, null, 3, new com.qq.e.comm.plugin.n0.d().a("msg", str));
            return new f<>(-1, "Invalid message");
        } else if (!"GDTJsBridge".equals(jSONObject.optString("gdtJB"))) {
            v.b(100292, null, 4, new com.qq.e.comm.plugin.n0.d().a("msg", str));
            return new f<>(-1, "Unsupported protocol");
        } else {
            String optString = jSONObject.optString("service");
            String optString2 = jSONObject.optString("action");
            String optString3 = jSONObject.optString(EventMonitor.V3_PARAMS);
            String optString4 = jSONObject.optString("callbackId");
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(optString3)) {
                    jSONObject2 = new JSONObject(optString3);
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            return b(new d(optString, optString2, optString4, jSONObject2));
        }
    }

    @Override // com.qq.e.comm.plugin.q0.s.g
    public void b(String str) {
        d dVar;
        Uri parse = Uri.parse(str);
        if (i2.b(parse)) {
            try {
                dVar = a(parse);
            } catch (Throwable th) {
                d1.a(String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str), th);
                dVar = null;
            }
            c(dVar);
            b(dVar);
        }
    }

    private f<String> b(d dVar) {
        if (dVar == null) {
            return new f<>(null);
        }
        if ("template".equals(dVar.e())) {
            if ("multiAction".equals(dVar.a())) {
                a(TextUtils.isEmpty(dVar.c()) ? dVar.d().toString() : dVar.c(), dVar.f());
            } else {
                a(dVar);
            }
            return new f<>(null);
        }
        j a4 = this.f45524b.a(dVar.e());
        if (a4 != null) {
            return a4.a(this.f45523a, dVar);
        }
        a(new e(dVar, e.a.f45550e, "Unsupported service!", 0));
        return new f<>(1000, "Unsupported service");
    }

    private void a(d dVar) {
        com.qq.e.comm.plugin.q0.u.i a4 = this.f45525c.a(dVar.a());
        if (a4 != null) {
            a4.a(this.f45523a, dVar);
        } else {
            a(new e(dVar, e.a.f45550e, "Unsupported action!", 0));
        }
    }

    private void a(String str, long j4) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                a(new d("", jSONObject.optString("action"), jSONObject.optString("callbackId"), jSONObject.optJSONObject(EventMonitor.V3_PARAMS), j4));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
