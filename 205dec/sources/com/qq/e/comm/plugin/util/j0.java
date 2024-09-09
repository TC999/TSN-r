package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f46496a;

    public j0() {
        this.f46496a = new JSONObject();
    }

    public static j0 a(String str) {
        return new j0(str);
    }

    public String toString() {
        return this.f46496a.toString();
    }

    public j0 a(String str, int i4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f46496a.put(str, i4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public j0(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (!str.trim().isEmpty() && !str.toLowerCase().equals("null")) {
                    jSONObject = new JSONObject(str);
                    this.f46496a = jSONObject;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                this.f46496a = new JSONObject();
                return;
            }
        }
        jSONObject = new JSONObject();
        this.f46496a = jSONObject;
    }

    public j0 a(String str, long j4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f46496a.put(str, j4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public j0(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f46496a = new JSONObject();
        } else {
            this.f46496a = jSONObject;
        }
    }

    public j0 a(String str, double d4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f46496a.put(str, d4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public j0 a(String str, boolean z3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f46496a.put(str, z3);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public j0 a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f46496a.put(str, str2);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public j0 a(String str, Object obj) {
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.f46496a.put(str, obj);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public JSONObject a() {
        return this.f46496a;
    }
}
