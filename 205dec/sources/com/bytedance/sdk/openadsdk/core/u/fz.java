package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz {

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c> f34672c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public int f34673c;
        public String sr;

        /* renamed from: w  reason: collision with root package name */
        public String f34674w;
        public String xv;

        public c(JSONObject jSONObject) {
            try {
                this.f34673c = jSONObject.optInt("type");
                this.f34674w = jSONObject.optString("url");
                this.xv = jSONObject.optString("pid");
                this.sr = jSONObject.optString("ecom_live_params");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f34673c);
                jSONObject.put("url", this.f34674w);
                jSONObject.put("pid", this.xv);
                jSONObject.put("ecom_live_params", this.sr);
                return jSONObject;
            } catch (JSONException e4) {
                throw new RuntimeException(e4);
            }
        }

        public boolean w() {
            if (3 == this.f34673c) {
                return !TextUtils.isEmpty(this.sr);
            }
            return !TextUtils.isEmpty(this.f34674w);
        }
    }

    public fz(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    c cVar = new c(optJSONObject.optJSONObject(next));
                    if (cVar.w()) {
                        this.f34672c.put(next, cVar);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.d("lfz", "\u51fa\u9519\u5566", e4);
        }
    }

    public static String sr(me meVar, String str) {
        c cVar;
        fz c4 = c(meVar);
        return (c4 == null || (cVar = c4.f34672c.get(str)) == null) ? "" : cVar.xv;
    }

    public static String ux(me meVar, String str) {
        c cVar;
        fz c4 = c(meVar);
        return (c4 == null || (cVar = c4.f34672c.get(str)) == null) ? "" : cVar.sr;
    }

    public static int w(me meVar, String str) {
        c cVar;
        fz c4 = c(meVar);
        if (c4 == null || (cVar = c4.f34672c.get(str)) == null) {
            return 0;
        }
        return cVar.f34673c;
    }

    public static String xv(me meVar, String str) {
        c cVar;
        fz c4 = c(meVar);
        return (c4 == null || (cVar = c4.f34672c.get(str)) == null) ? "" : cVar.f34674w;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, c> entry : this.f34672c.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().c());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static fz c(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.ym();
    }

    public static boolean c(me meVar, String str) {
        fz c4 = c(meVar);
        if (c4 != null && c4.f34672c.containsKey(str)) {
            return !TextUtils.isEmpty(xv(meVar, str));
        }
        return false;
    }
}
