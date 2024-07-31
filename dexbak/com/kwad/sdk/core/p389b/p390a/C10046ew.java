package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ew */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10046ew implements InterfaceC10273d<HttpDnsInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        m26996a(httpDnsInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        return m26995b(httpDnsInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26996a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        httpDnsInfo.recommendList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("recommendList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                HttpDnsInfo.IpInfo ipInfo = new HttpDnsInfo.IpInfo();
                ipInfo.parseJson(optJSONArray.optJSONObject(i));
                httpDnsInfo.recommendList.add(ipInfo);
            }
        }
        httpDnsInfo.backUpList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("backUpList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                HttpDnsInfo.IpInfo ipInfo2 = new HttpDnsInfo.IpInfo();
                ipInfo2.parseJson(optJSONArray2.optJSONObject(i2));
                httpDnsInfo.backUpList.add(ipInfo2);
            }
        }
        httpDnsInfo.otherList = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("otherList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                HttpDnsInfo.IpInfo ipInfo3 = new HttpDnsInfo.IpInfo();
                ipInfo3.parseJson(optJSONArray3.optJSONObject(i3));
                httpDnsInfo.otherList.add(ipInfo3);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26995b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "recommendList", httpDnsInfo.recommendList);
        C11126t.putValue(jSONObject, "backUpList", httpDnsInfo.backUpList);
        C11126t.putValue(jSONObject, "otherList", httpDnsInfo.otherList);
        return jSONObject;
    }
}
