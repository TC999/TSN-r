package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.g4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CloudSearchIdHandler extends CloudHandler<QueryIDInternal, CloudItemDetail> {
    public CloudSearchIdHandler(Context context, QueryIDInternal queryIDInternal) {
        super(context, queryIDInternal);
    }

    /* renamed from: Z */
    private static CloudItemDetail m52967Z(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return m52966a0(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a0 */
    private static CloudItemDetail m52966a0(JSONObject jSONObject) throws JSONException {
        JSONArray m53005U = CloudHandler.m53005U(jSONObject);
        if (m53005U == null || m53005U.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = m53005U.getJSONObject(0);
        CloudItemDetail m53002X = CloudHandler.m53002X(jSONObject2);
        CloudHandler.m53004V(m53002X, jSONObject2);
        return m53002X;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52967Z(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52890f() + "/datasearch/id";
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C2199x0.m52327i(this.f5883q));
        hashtable.put("layerId", ((QueryIDInternal) this.f5880n).f6209a);
        hashtable.put("output", "json");
        hashtable.put("id", ((QueryIDInternal) this.f5880n).f6210b);
        String m53275a = C2016a1.m53275a();
        String m53273c = C2016a1.m53273c(this.f5883q, m53275a, C2079j1.m52859r(hashtable));
        hashtable.put("ts", m53275a);
        hashtable.put("scode", m53273c);
        return hashtable;
    }
}
