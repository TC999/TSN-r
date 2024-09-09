package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CloudSearchKeywordsHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h4 extends f4<CloudSearch.Query, CloudResult> {

    /* renamed from: t  reason: collision with root package name */
    private int f9903t;

    public h4(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f9903t = 0;
    }

    private String Q() {
        return ((CloudSearch.Query) this.f9630n).getSortingrules() != null ? ((CloudSearch.Query) this.f9630n).getSortingrules().toString() : "";
    }

    private String R() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f9630n).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f9630n).getFilterNumString();
        stringBuffer.append(filterString);
        if (!j4.j(filterString) && !j4.j(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    private static String T(String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }

    private static String Z(Map<String, String> map) {
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
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: a0 */
    public CloudResult I(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str != null && !str.equals("")) {
            try {
                arrayList = b0(new JSONObject(str));
            } catch (JSONException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            Object obj = this.f9630n;
            return CloudResult.createPagedResult((CloudSearch.Query) obj, this.f9903t, ((CloudSearch.Query) obj).getBound(), ((CloudSearch.Query) this.f9630n).getPageSize(), arrayList);
        }
        Object obj2 = this.f9630n;
        return CloudResult.createPagedResult((CloudSearch.Query) obj2, this.f9903t, ((CloudSearch.Query) obj2).getBound(), ((CloudSearch.Query) this.f9630n).getPageSize(), null);
    }

    private ArrayList<CloudItem> b0(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray U = f4.U(jSONObject);
        if (U == null) {
            return arrayList;
        }
        this.f9903t = f4.W(jSONObject);
        for (int i4 = 0; i4 < U.length(); i4++) {
            JSONObject optJSONObject = U.optJSONObject(i4);
            CloudItemDetail X = f4.X(optJSONObject);
            f4.V(X, optJSONObject);
            arrayList.add(X);
        }
        return arrayList;
    }

    private static String c(Map<String, String> map) {
        return d0(Z(map));
    }

    private static String c0(String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }

    private static String d0(String str) {
        try {
        } catch (Throwable th) {
            d2.e(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = T(str);
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String c02 = c0(stringBuffer.toString());
        if (c02.length() > 1) {
            return (String) c02.subSequence(0, c02.length() - 1);
        }
        return str;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.f() + "/datasearch";
        String shape = ((CloudSearch.Query) this.f9630n).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        } else if (!shape.equals("Polygon") && !shape.equals("Rectangle")) {
            if (shape.equals("Local")) {
                return str + "/local";
            }
            return str;
        } else {
            return str + "/polygon";
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, x0.i(this.f9633q));
        hashtable.put("output", "json");
        if (((CloudSearch.Query) this.f9630n).getBound() != null) {
            if (((CloudSearch.Query) this.f9630n).getBound().getShape().equals("Bound")) {
                double a4 = j4.a(((CloudSearch.Query) this.f9630n).getBound().getCenter().getLongitude());
                double a5 = j4.a(((CloudSearch.Query) this.f9630n).getBound().getCenter().getLatitude());
                hashtable.put(AutoScrollViewPager.f4767g, a4 + "," + a5);
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) this.f9630n).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) this.f9630n).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f9630n).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f9630n).getBound().getUpperRight();
                double a6 = j4.a(lowerLeft.getLatitude());
                double a7 = j4.a(lowerLeft.getLongitude());
                double a8 = j4.a(upperRight.getLatitude());
                double a9 = j4.a(upperRight.getLongitude());
                hashtable.put("polygon", a7 + "," + a6 + ";" + a9 + "," + a8);
            } else if (((CloudSearch.Query) this.f9630n).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f9630n).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", j4.g(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.f9630n).getBound().getShape().equals("Local")) {
                hashtable.put("city", ((CloudSearch.Query) this.f9630n).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.f9630n).getTableID());
        if (!j4.j(Q())) {
            hashtable.put("sortrule", Q());
        }
        String R = R();
        if (!j4.j(R)) {
            hashtable.put("filter", R);
        }
        String queryString = ((CloudSearch.Query) this.f9630n).getQueryString();
        if (queryString != null && !"".equals(queryString)) {
            hashtable.put("keywords", queryString);
        } else {
            hashtable.put("keywords", "");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) this.f9630n).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) this.f9630n).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a10 = a1.a();
        String c4 = a1.c(this.f9633q, a10, c(hashtable));
        hashtable.put("ts", a10);
        hashtable.put("scode", c4);
        return hashtable;
    }
}
