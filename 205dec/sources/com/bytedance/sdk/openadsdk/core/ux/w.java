package com.bytedance.sdk.openadsdk.core.ux;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private int f35105c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private int f35106w;
    private int xv;

    public int c() {
        return this.f35105c;
    }

    public boolean sr() {
        return this.sr;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", w());
            jSONObject.put("log_level", c());
            jSONObject.put("max_size", xv());
            jSONObject.put("is_open", sr());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    public int w() {
        return this.f35106w;
    }

    public int xv() {
        return this.xv;
    }

    public void c(int i4) {
        this.f35105c = i4;
    }

    public void w(int i4) {
        this.f35106w = i4;
    }

    public void xv(int i4) {
        this.xv = i4;
    }

    public static w c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (JSONException e4) {
            a.sr("CLogConfig", "parse failed:" + e4);
            return null;
        }
    }

    public static w c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        wVar.w(jSONObject.optInt("expire_days"));
        wVar.c(jSONObject.optInt("log_level"));
        wVar.xv(jSONObject.optInt("max_size"));
        wVar.c(jSONObject.optBoolean("is_open"));
        return wVar;
    }

    public void c(boolean z3) {
        this.sr = z3;
    }
}
