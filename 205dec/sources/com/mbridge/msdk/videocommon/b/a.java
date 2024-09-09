package com.mbridge.msdk.videocommon.b;

import org.json.JSONObject;

/* compiled from: AdParams.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f40938a;

    /* renamed from: b  reason: collision with root package name */
    private String f40939b;

    private a(String str, String str2) {
        this.f40938a = str;
        this.f40939b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
