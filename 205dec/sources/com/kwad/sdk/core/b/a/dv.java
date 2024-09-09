package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dv implements com.kwad.sdk.core.d<FeedPageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        a2(feedPageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        return b2(feedPageInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadType = jSONObject.optLong("load_type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(feedPageInfo.materialUrl)) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (JSONObject.NULL.toString().equals(feedPageInfo.extMsg)) {
            feedPageInfo.extMsg = "";
        }
        feedPageInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(feedPageInfo.abParams)) {
            feedPageInfo.abParams = "";
        }
        feedPageInfo.callbackType = jSONObject.optInt("callback_type");
        feedPageInfo.materialInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("material_info");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                FeedPageInfo.a aVar = new FeedPageInfo.a();
                aVar.parseJson(optJSONArray.optJSONObject(i4));
                feedPageInfo.materialInfoList.add(aVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = feedPageInfo.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        int i5 = feedPageInfo.loadStatus;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", i5);
        }
        int i6 = feedPageInfo.adNum;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i6);
        }
        int i7 = feedPageInfo.type;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i7);
        }
        long j4 = feedPageInfo.loadType;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_type", j4);
        }
        long j5 = feedPageInfo.loadDataDuration;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j5);
        }
        long j6 = feedPageInfo.resourceLoadDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "resource_load_duration_ms", j6);
        }
        int i8 = feedPageInfo.materialType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i8);
        }
        String str = feedPageInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        long j7 = feedPageInfo.renderDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j7);
        }
        int i9 = feedPageInfo.renderType;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", i9);
        }
        int i10 = feedPageInfo.expectedRenderType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expected_render_type", i10);
        }
        long j8 = feedPageInfo.convertDuration;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convert_duartion_ms", j8);
        }
        String str2 = feedPageInfo.extMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        String str3 = feedPageInfo.abParams;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ab_params", feedPageInfo.abParams);
        }
        int i11 = feedPageInfo.callbackType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callback_type", i11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "material_info", feedPageInfo.materialInfoList);
        return jSONObject;
    }
}
