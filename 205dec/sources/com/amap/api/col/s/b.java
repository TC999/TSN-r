package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NearbySearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b extends b4<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: t  reason: collision with root package name */
    private Context f9640t;

    /* renamed from: u  reason: collision with root package name */
    private NearbySearch.NearbyQuery f9641u;

    public b(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f9640t = context;
        this.f9641u = nearbyQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: U */
    public NearbySearchResult I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z3 = true;
            if (this.f9641u.getType() != 1) {
                z3 = false;
            }
            ArrayList<NearbyInfo> x3 = r4.x(jSONObject, z3);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(x3);
            return nearbySearchResult;
        } catch (JSONException e4) {
            j4.i(e4, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f9640t));
        LatLonPoint centerPoint = this.f9641u.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f9641u.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.f9641u.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f9641u.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/around";
    }
}
