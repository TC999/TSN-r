package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.feed.monitor.FeedErrorInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10016dt implements InterfaceC10273d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        m27050a(feedErrorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        return m27049b(feedErrorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27050a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27049b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = feedErrorInfo.materialType;
        if (j != 0) {
            C11126t.putValue(jSONObject, "material_type", j);
        }
        long j2 = feedErrorInfo.width;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "width", j2);
        }
        long j3 = feedErrorInfo.feedType;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "feed_type", j3);
        }
        return jSONObject;
    }
}
