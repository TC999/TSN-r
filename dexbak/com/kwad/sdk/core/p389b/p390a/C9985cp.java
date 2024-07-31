package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9985cp implements InterfaceC10273d<CouponInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(CouponInfo couponInfo, JSONObject jSONObject) {
        m27112a(couponInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(CouponInfo couponInfo, JSONObject jSONObject) {
        return m27111b(couponInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27112a(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponInfo.displayName = jSONObject.optString("displayName");
        if (JSONObject.NULL.toString().equals(couponInfo.displayName)) {
            couponInfo.displayName = "";
        }
        couponInfo.displayTitle = jSONObject.optString("displayTitle");
        if (JSONObject.NULL.toString().equals(couponInfo.displayTitle)) {
            couponInfo.displayTitle = "";
        }
        couponInfo.displayValue = jSONObject.optString("displayValue");
        if (JSONObject.NULL.toString().equals(couponInfo.displayValue)) {
            couponInfo.displayValue = "";
        }
        couponInfo.displayBase = jSONObject.optString("displayBase");
        if (JSONObject.NULL.toString().equals(couponInfo.displayBase)) {
            couponInfo.displayBase = "";
        }
        couponInfo.displayType = jSONObject.optString("displayType");
        if (JSONObject.NULL.toString().equals(couponInfo.displayType)) {
            couponInfo.displayType = "";
        }
        couponInfo.displayActionWords = jSONObject.optString("displayActionWords");
        if (JSONObject.NULL.toString().equals(couponInfo.displayActionWords)) {
            couponInfo.displayActionWords = "";
        }
        couponInfo.displayDiscount = jSONObject.optString("displayDiscount");
        if (JSONObject.NULL.toString().equals(couponInfo.displayDiscount)) {
            couponInfo.displayDiscount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27111b(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = couponInfo.displayName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "displayName", couponInfo.displayName);
        }
        String str2 = couponInfo.displayTitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "displayTitle", couponInfo.displayTitle);
        }
        String str3 = couponInfo.displayValue;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "displayValue", couponInfo.displayValue);
        }
        String str4 = couponInfo.displayBase;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "displayBase", couponInfo.displayBase);
        }
        String str5 = couponInfo.displayType;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "displayType", couponInfo.displayType);
        }
        String str6 = couponInfo.displayActionWords;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "displayActionWords", couponInfo.displayActionWords);
        }
        String str7 = couponInfo.displayDiscount;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "displayDiscount", couponInfo.displayDiscount);
        }
        return jSONObject;
    }
}
