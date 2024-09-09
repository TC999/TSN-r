package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private String f34707c;

    /* renamed from: w  reason: collision with root package name */
    private int f34708w;

    public k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cloud_game_info")) == null) {
            return;
        }
        this.f34707c = optJSONObject.optString("cloud_game_url");
        this.f34708w = optJSONObject.optInt("cloud_game_type");
    }

    private static int f(me meVar) {
        k ux = ux(meVar);
        if (ux == null) {
            return 0;
        }
        return ux.f34708w;
    }

    public static boolean sr(me meVar) {
        return c(meVar) && f(meVar) == 0;
    }

    private static k ux(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.wx();
    }

    public static String w(me meVar) {
        k ux = ux(meVar);
        return ux == null ? "" : ux.f34707c;
    }

    public static boolean xv(me meVar) {
        return c(meVar) && f(meVar) == 1;
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cloud_game_url", this.f34707c);
            jSONObject2.put("cloud_game_type", this.f34708w);
            jSONObject.put("cloud_game_info", jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean c(me meVar) {
        k ux = ux(meVar);
        if (ux == null) {
            return false;
        }
        return !TextUtils.isEmpty(ux.f34707c);
    }
}
