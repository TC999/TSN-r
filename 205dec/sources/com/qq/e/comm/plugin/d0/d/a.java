package com.qq.e.comm.plugin.d0.d;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f42239a.opt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str, String str2) {
        JSONObject optJSONObject = this.f42239a.optJSONObject("ps");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        try {
            this.f42239a.putOpt(str, obj);
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj, String str2) {
        try {
            JSONObject optJSONObject = this.f42239a.optJSONObject("ps");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f42239a.putOpt("ps", optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }
}
