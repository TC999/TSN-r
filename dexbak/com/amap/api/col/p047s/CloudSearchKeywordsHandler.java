package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.h4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CloudSearchKeywordsHandler extends CloudHandler<CloudSearch.Query, CloudResult> {

    /* renamed from: t */
    private int f6175t;

    public CloudSearchKeywordsHandler(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f6175t = 0;
    }

    /* renamed from: Q */
    private String m52939Q() {
        return ((CloudSearch.Query) this.f5880n).getSortingrules() != null ? ((CloudSearch.Query) this.f5880n).getSortingrules().toString() : "";
    }

    /* renamed from: R */
    private String m52938R() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f5880n).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f5880n).getFilterNumString();
        stringBuffer.append(filterString);
        if (!C2082j4.m52824j(filterString) && !C2082j4.m52824j(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    /* renamed from: T */
    private static String m52937T(String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }

    /* renamed from: Z */
    private static String m52936Z(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: a0 */
    public CloudResult mo52183I(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str != null && !str.equals("")) {
            try {
                arrayList = m52934b0(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            T t = this.f5880n;
            return CloudResult.createPagedResult((CloudSearch.Query) t, this.f6175t, ((CloudSearch.Query) t).getBound(), ((CloudSearch.Query) this.f5880n).getPageSize(), arrayList);
        }
        T t2 = this.f5880n;
        return CloudResult.createPagedResult((CloudSearch.Query) t2, this.f6175t, ((CloudSearch.Query) t2).getBound(), ((CloudSearch.Query) this.f5880n).getPageSize(), null);
    }

    /* renamed from: b0 */
    private ArrayList<CloudItem> m52934b0(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray m53005U = CloudHandler.m53005U(jSONObject);
        if (m53005U == null) {
            return arrayList;
        }
        this.f6175t = CloudHandler.m53003W(jSONObject);
        for (int i = 0; i < m53005U.length(); i++) {
            JSONObject optJSONObject = m53005U.optJSONObject(i);
            CloudItemDetail m53002X = CloudHandler.m53002X(optJSONObject);
            CloudHandler.m53004V(m53002X, optJSONObject);
            arrayList.add(m53002X);
        }
        return arrayList;
    }

    /* renamed from: c */
    private static String m52933c(Map<String, String> map) {
        return m52931d0(m52936Z(map));
    }

    /* renamed from: c0 */
    private static String m52932c0(String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }

    /* renamed from: d0 */
    private static String m52931d0(String str) {
        try {
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = m52937T(str);
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String m52932c0 = m52932c0(stringBuffer.toString());
        if (m52932c0.length() > 1) {
            return (String) m52932c0.subSequence(0, m52932c0.length() - 1);
        }
        return str;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        String str = C2077i4.m52890f() + "/datasearch";
        String shape = ((CloudSearch.Query) this.f5880n).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        } else if (!shape.equals("Polygon") && !shape.equals("Rectangle")) {
            if (shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                return str + "/local";
            }
            return str;
        } else {
            return str + "/polygon";
        }
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C2199x0.m52327i(this.f5883q));
        hashtable.put("output", "json");
        if (((CloudSearch.Query) this.f5880n).getBound() != null) {
            if (((CloudSearch.Query) this.f5880n).getBound().getShape().equals("Bound")) {
                double m52833a = C2082j4.m52833a(((CloudSearch.Query) this.f5880n).getBound().getCenter().getLongitude());
                double m52833a2 = C2082j4.m52833a(((CloudSearch.Query) this.f5880n).getBound().getCenter().getLatitude());
                hashtable.put("center", m52833a + "," + m52833a2);
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) this.f5880n).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) this.f5880n).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f5880n).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f5880n).getBound().getUpperRight();
                double m52833a3 = C2082j4.m52833a(lowerLeft.getLatitude());
                double m52833a4 = C2082j4.m52833a(lowerLeft.getLongitude());
                double m52833a5 = C2082j4.m52833a(upperRight.getLatitude());
                double m52833a6 = C2082j4.m52833a(upperRight.getLongitude());
                hashtable.put("polygon", m52833a4 + "," + m52833a3 + ";" + m52833a6 + "," + m52833a5);
            } else if (((CloudSearch.Query) this.f5880n).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f5880n).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", C2082j4.m52827g(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.f5880n).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(DistrictSearchQuery.KEYWORDS_CITY, ((CloudSearch.Query) this.f5880n).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.f5880n).getTableID());
        if (!C2082j4.m52824j(m52939Q())) {
            hashtable.put("sortrule", m52939Q());
        }
        String m52938R = m52938R();
        if (!C2082j4.m52824j(m52938R)) {
            hashtable.put("filter", m52938R);
        }
        String queryString = ((CloudSearch.Query) this.f5880n).getQueryString();
        if (queryString != null && !"".equals(queryString)) {
            hashtable.put("keywords", queryString);
        } else {
            hashtable.put("keywords", "");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) this.f5880n).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) this.f5880n).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String m53275a = C2016a1.m53275a();
        String m53273c = C2016a1.m53273c(this.f5883q, m53275a, m52933c(hashtable));
        hashtable.put("ts", m53275a);
        hashtable.put("scode", m53273c);
        return hashtable;
    }
}
