package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10115hk implements InterfaceC10273d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        m26858a(patchAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return m26857b(patchAdInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26858a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleIcon)) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleTitle)) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleDownloadingTitle)) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleAdMark)) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleCardUrl)) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleTitle)) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleSubTitle)) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleAdMark)) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26857b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchAdInfo.weakStyleIcon;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        String str2 = patchAdInfo.weakStyleTitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        String str3 = patchAdInfo.weakStyleDownloadingTitle;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        String str4 = patchAdInfo.weakStyleAdMark;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        long j = patchAdInfo.weakStyleAppearTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "weakStyleAppearTime", j);
        }
        C11126t.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        int i = patchAdInfo.typePortrait;
        if (i != 0) {
            C11126t.putValue(jSONObject, "typePortrait", i);
        }
        String str5 = patchAdInfo.strongStyleCardUrl;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        long j2 = patchAdInfo.strongStyleAppearTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "strongStyleAppearTime", j2);
        }
        String str6 = patchAdInfo.strongStyleTitle;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        String str7 = patchAdInfo.strongStyleSubTitle;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        String str8 = patchAdInfo.strongStyleAdMark;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        C11126t.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        long j3 = patchAdInfo.weakStyleShowTime;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "weakStyleShowTime", j3);
        }
        long j4 = patchAdInfo.strongStyleShowTime;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "strongStyleShowTime", j4);
        }
        return jSONObject;
    }
}
