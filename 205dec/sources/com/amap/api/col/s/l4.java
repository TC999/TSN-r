package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DistrictServerHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l4 extends b4<DistrictSearchQuery, DistrictResult> {
    public l4(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: U */
    public DistrictResult I(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f9630n, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e4) {
            j4.i(e4, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e5) {
            j4.i(e5, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        r4.I(optJSONArray, arrayList, null);
        return districtResult;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f9630n).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f9630n).getPageSize());
        if (((DistrictSearchQuery) this.f9630n).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f9630n).checkKeyWords()) {
            String i4 = b4.i(((DistrictSearchQuery) this.f9630n).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(i4);
        }
        stringBuffer.append("&key=" + x0.i(this.f9633q));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.f9630n).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/config/district?";
    }
}
