package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.f4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class CloudHandler<T, V> extends BasicLBSRestHandler<T, V> {
    public CloudHandler(Context context, T t) {
        super(context, t);
        this.f5879m = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: U */
    public static JSONArray m53005U(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("list");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V */
    public static void m53004V(CloudItem cloudItem, JSONObject jSONObject) {
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
    /* renamed from: W */
    public static int m53003W(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return optJSONObject.optInt("count");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: X */
    public static CloudItemDetail m53002X(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(JSONHelper.m52484v(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), JSONHelper.m52484v(jSONObject, "title"), JSONHelper.m52484v(jSONObject, "address"));
        cloudItemDetail.setCreatetime(JSONHelper.m52484v(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(JSONHelper.m52484v(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!m53001Y(optString)) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    /* renamed from: Y */
    private static boolean m53001Y(String str) {
        return str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: J */
    protected final V mo53006J(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            C2082j4.m52825i(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C2082j4.m52821m(str);
        return mo52183I(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public final Map<String, String> mo52199p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", C2016a1.m53274b(this.f5883q));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        return null;
    }
}
