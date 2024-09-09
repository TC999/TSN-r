package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ew implements com.kwad.sdk.core.d<HttpDnsInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        a2(httpDnsInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        return b2(httpDnsInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        httpDnsInfo.recommendList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("recommendList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                HttpDnsInfo.IpInfo ipInfo = new HttpDnsInfo.IpInfo();
                ipInfo.parseJson(optJSONArray.optJSONObject(i4));
                httpDnsInfo.recommendList.add(ipInfo);
            }
        }
        httpDnsInfo.backUpList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("backUpList");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                HttpDnsInfo.IpInfo ipInfo2 = new HttpDnsInfo.IpInfo();
                ipInfo2.parseJson(optJSONArray2.optJSONObject(i5));
                httpDnsInfo.backUpList.add(ipInfo2);
            }
        }
        httpDnsInfo.otherList = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("otherList");
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                HttpDnsInfo.IpInfo ipInfo3 = new HttpDnsInfo.IpInfo();
                ipInfo3.parseJson(optJSONArray3.optJSONObject(i6));
                httpDnsInfo.otherList.add(ipInfo3);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "recommendList", httpDnsInfo.recommendList);
        com.kwad.sdk.utils.t.putValue(jSONObject, "backUpList", httpDnsInfo.backUpList);
        com.kwad.sdk.utils.t.putValue(jSONObject, "otherList", httpDnsInfo.otherList);
        return jSONObject;
    }
}
