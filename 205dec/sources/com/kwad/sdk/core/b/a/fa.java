package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fa implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = imageLoaderInfo.totalCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i4);
        }
        int i5 = imageLoaderInfo.failedCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed_count", i5);
        }
        int i6 = imageLoaderInfo.successCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "success_count", i6);
        }
        double d4 = imageLoaderInfo.duration;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", d4);
        }
        return jSONObject;
    }
}
