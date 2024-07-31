package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.b0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AutoTPoiSearchHandler extends BasicLBSRestHandler<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: t */
    private AutoTCommonParam f5892t;

    public AutoTPoiSearchHandler(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f5892t = null;
        this.f5892t = new AutoTCommonParam(context);
    }

    /* renamed from: U */
    private static AutoTChargeStationResult m53243U(String str) throws AMapException {
        try {
            return AutoTSearchResultParser.m53242a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53243U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuilder sb = new StringBuilder(this.f5892t.m53294a());
        sb.append("&adcode=");
        sb.append(((AutoTSearch.Query) this.f5880n).getAdCode());
        sb.append("&city=");
        sb.append(((AutoTSearch.Query) this.f5880n).getCity());
        sb.append("&data_type=");
        sb.append(((AutoTSearch.Query) this.f5880n).getDataType());
        sb.append("&geoobj=");
        sb.append(((AutoTSearch.Query) this.f5880n).getGeoObj());
        sb.append("&keywords=");
        sb.append(((AutoTSearch.Query) this.f5880n).getKeywords());
        sb.append("&pagenum=");
        sb.append(((AutoTSearch.Query) this.f5880n).getPageNum());
        sb.append("&pagesize=");
        sb.append(((AutoTSearch.Query) this.f5880n).getPageSize());
        sb.append("&qii=");
        sb.append(((AutoTSearch.Query) this.f5880n).isQii());
        sb.append("&query_type=");
        sb.append(((AutoTSearch.Query) this.f5880n).getQueryType());
        sb.append("&range=");
        sb.append(((AutoTSearch.Query) this.f5880n).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) this.f5880n).getLatLonPoint();
        if (latLonPoint != null) {
            sb.append("&longitude=");
            sb.append(latLonPoint.getLongitude());
            sb.append("&latitude=");
            sb.append(latLonPoint.getLatitude());
        }
        sb.append("&user_loc=");
        sb.append(((AutoTSearch.Query) this.f5880n).getUserLoc());
        sb.append("&user_city=");
        sb.append(((AutoTSearch.Query) this.f5880n).getUserCity());
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) this.f5880n).getFilterBox();
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

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        try {
            String m53223c = AutoTSignatureUtils.m53223c(new HashMap(), ((AutoTSearch.Query) this.f5880n).getAccessKey());
            String m53224b = AutoTSignatureUtils.m53224b("POST", m53223c, ((AutoTSearch.Query) this.f5880n).getSecretKey());
            return C2077i4.m52889g() + "/ws/mapapi/poi/infolite/auto?" + m53223c + "&Signature=" + m53224b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
