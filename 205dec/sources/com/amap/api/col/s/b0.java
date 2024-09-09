package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AutoTPoiSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b0 extends b4<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: t  reason: collision with root package name */
    private a f9642t;

    public b0(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f9642t = null;
        this.f9642t = new a(context);
    }

    private static AutoTChargeStationResult U(String str) throws AMapException {
        try {
            return b1.a(new JSONObject(str));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuilder sb = new StringBuilder(this.f9642t.a());
        sb.append("&adcode=");
        sb.append(((AutoTSearch.Query) this.f9630n).getAdCode());
        sb.append("&city=");
        sb.append(((AutoTSearch.Query) this.f9630n).getCity());
        sb.append("&data_type=");
        sb.append(((AutoTSearch.Query) this.f9630n).getDataType());
        sb.append("&geoobj=");
        sb.append(((AutoTSearch.Query) this.f9630n).getGeoObj());
        sb.append("&keywords=");
        sb.append(((AutoTSearch.Query) this.f9630n).getKeywords());
        sb.append("&pagenum=");
        sb.append(((AutoTSearch.Query) this.f9630n).getPageNum());
        sb.append("&pagesize=");
        sb.append(((AutoTSearch.Query) this.f9630n).getPageSize());
        sb.append("&qii=");
        sb.append(((AutoTSearch.Query) this.f9630n).isQii());
        sb.append("&query_type=");
        sb.append(((AutoTSearch.Query) this.f9630n).getQueryType());
        sb.append("&range=");
        sb.append(((AutoTSearch.Query) this.f9630n).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) this.f9630n).getLatLonPoint();
        if (latLonPoint != null) {
            sb.append("&longitude=");
            sb.append(latLonPoint.getLongitude());
            sb.append("&latitude=");
            sb.append(latLonPoint.getLatitude());
        }
        sb.append("&user_loc=");
        sb.append(((AutoTSearch.Query) this.f9630n).getUserLoc());
        sb.append("&user_city=");
        sb.append(((AutoTSearch.Query) this.f9630n).getUserCity());
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) this.f9630n).getFilterBox();
        if (filterBox != null) {
            sb.append("&retain_state=");
            sb.append(filterBox.getRetainState());
            sb.append("&checked_level=");
            sb.append(filterBox.getCheckedLevel());
            sb.append("&classify_v2_data=");
            sb.append(filterBox.getClassifyV2Data());
            sb.append("&classify_v2_level2_data=");
            sb.append(filterBox.getClassifyV2Level2Data());
            sb.append("&classify_v2_level3_data=");
            sb.append(filterBox.getClassifyV2Level3Data());
        }
        return sb.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        try {
            String c4 = b2.c(new HashMap(), ((AutoTSearch.Query) this.f9630n).getAccessKey());
            String b4 = b2.b("POST", c4, ((AutoTSearch.Query) this.f9630n).getSecretKey());
            return i4.g() + "/ws/mapapi/poi/infolite/auto?" + c4 + "&Signature=" + b4;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
