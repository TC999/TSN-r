package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CloudHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class f4<T, V> extends b4<T, V> {
    public f4(Context context, T t3) {
        super(context, t3);
        this.f9629m = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONArray U(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("list");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void V(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int W(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return optJSONObject.optInt("count");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CloudItemDetail X(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(r4.v(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), r4.v(jSONObject, "title"), r4.v(jSONObject, "address"));
        cloudItemDetail.setCreatetime(r4.v(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(r4.v(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!Y(optString)) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    private static boolean Y(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }

    @Override // com.amap.api.col.s.a3
    protected final V J(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e4) {
            j4.i(e4, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        j4.m(str);
        return I(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", a1.b(this.f9633q));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.dz
    public final byte[] q() {
        return null;
    }
}
