package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10051fa implements InterfaceC10273d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        m26986a(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return m26985b(imageLoaderInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26986a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26985b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = imageLoaderInfo.totalCount;
        if (i != 0) {
            C11126t.putValue(jSONObject, "total_count", i);
        }
        int i2 = imageLoaderInfo.failedCount;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "failed_count", i2);
        }
        int i3 = imageLoaderInfo.successCount;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "success_count", i3);
        }
        double d = imageLoaderInfo.duration;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "duration", d);
        }
        return jSONObject;
    }
}
