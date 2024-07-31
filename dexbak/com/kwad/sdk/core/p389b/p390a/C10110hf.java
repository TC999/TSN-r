package com.kwad.sdk.core.p389b.p390a;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10110hf implements InterfaceC10273d<C10772b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10772b c10772b, JSONObject jSONObject) {
        m26868a(c10772b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10772b c10772b, JSONObject jSONObject) {
        return m26867b(c10772b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26868a(C10772b c10772b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10772b.aHX = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(c10772b.aHX)) {
            c10772b.aHX = "";
        }
        c10772b.aHY = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(c10772b.aHY)) {
            c10772b.aHY = "";
        }
        c10772b.aHZ = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(c10772b.aHZ)) {
            c10772b.aHZ = "";
        }
        c10772b.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(c10772b.packageUrl)) {
            c10772b.packageUrl = "";
        }
        c10772b.version = jSONObject.optString(ConstantHelper.LOG_VS);
        if (JSONObject.NULL.toString().equals(c10772b.version)) {
            c10772b.version = "";
        }
        c10772b.ajL = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(c10772b.ajL)) {
            c10772b.ajL = "";
        }
        c10772b.loadType = jSONObject.optInt("loadType");
        c10772b.packageType = jSONObject.optInt("packageType");
        c10772b.aIb = jSONObject.optBoolean("public");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26867b(C10772b c10772b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10772b.aHX;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "packageId", c10772b.aHX);
        }
        String str2 = c10772b.aHY;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "zipFileName", c10772b.aHY);
        }
        String str3 = c10772b.aHZ;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "zipPath", c10772b.aHZ);
        }
        String str4 = c10772b.packageUrl;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "packageUrl", c10772b.packageUrl);
        }
        String str5 = c10772b.version;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, c10772b.version);
        }
        String str6 = c10772b.ajL;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "checksum", c10772b.ajL);
        }
        int i = c10772b.loadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "loadType", i);
        }
        int i2 = c10772b.packageType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "packageType", i2);
        }
        boolean z = c10772b.aIb;
        if (z) {
            C11126t.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }
}
