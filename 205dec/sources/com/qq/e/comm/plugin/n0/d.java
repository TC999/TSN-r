package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f44743a;

    public d(JSONObject jSONObject) {
        this.f44743a = jSONObject;
    }

    public d a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.f44743a.putOpt(str, obj);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public String toString() {
        return this.f44743a.toString();
    }

    public d() {
        this(new JSONObject());
    }

    public JSONObject a() {
        JSONObject jSONObject = this.f44743a;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        return this.f44743a;
    }
}
