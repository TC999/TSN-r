package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CloudSearchIdHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g4 extends f4<j, CloudItemDetail> {
    public g4(Context context, j jVar) {
        super(context, jVar);
    }

    private static CloudItemDetail Z(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return a0(new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static CloudItemDetail a0(JSONObject jSONObject) throws JSONException {
        JSONArray U = f4.U(jSONObject);
        if (U == null || U.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = U.getJSONObject(0);
        CloudItemDetail X = f4.X(jSONObject2);
        f4.V(X, jSONObject2);
        return X;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return Z(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.f() + "/datasearch/id";
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, x0.i(this.f9633q));
        hashtable.put("layerId", ((j) this.f9630n).f9937a);
        hashtable.put("output", "json");
        hashtable.put("id", ((j) this.f9630n).f9938b);
        String a4 = a1.a();
        String c4 = a1.c(this.f9633q, a4, j1.r(hashtable));
        hashtable.put("ts", a4);
        hashtable.put("scode", c4);
        return hashtable;
    }
}
