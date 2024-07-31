package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.l4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DistrictServerHandler extends BasicLBSRestHandler<DistrictSearchQuery, DistrictResult> {
    public DistrictServerHandler(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: U */
    public DistrictResult mo52183I(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f5880n, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e) {
            C2082j4.m52825i(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        JSONHelper.m52560I(optJSONArray, arrayList, null);
        return districtResult;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f5880n).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f5880n).getPageSize());
        if (((DistrictSearchQuery) this.f5880n).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f5880n).checkKeyWords()) {
            String m53218i = BasicLBSRestHandler.m53218i(((DistrictSearchQuery) this.f5880n).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(m53218i);
        }
        stringBuffer.append("&key=" + C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.f5880n).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/config/district?";
    }
}
