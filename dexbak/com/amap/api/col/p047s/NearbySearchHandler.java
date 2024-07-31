package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NearbySearchHandler extends BasicLBSRestHandler<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: t */
    private Context f5890t;

    /* renamed from: u */
    private NearbySearch.NearbyQuery f5891u;

    public NearbySearchHandler(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f5890t = context;
        this.f5891u = nearbyQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: U */
    public NearbySearchResult mo52183I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.f5891u.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> m52480x = JSONHelper.m52480x(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(m52480x);
            return nearbySearchResult;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5890t));
        LatLonPoint centerPoint = this.f5891u.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f5891u.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.f5891u.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f5891u.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52891e() + "/nearby/around";
    }
}
