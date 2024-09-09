package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RideRouteSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s extends b4<RouteSearch.RideRouteQuery, RideRouteResult> {
    public s(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResult U(String str) throws AMapException {
        return r4.t0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f9633q));
        stringBuffer.append("&origin=");
        stringBuffer.append(j4.d(((RouteSearch.RideRouteQuery) this.f9630n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearch.RideRouteQuery) this.f9630n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((RouteSearch.RideRouteQuery) this.f9630n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.RideRouteQuery) this.f9630n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.c() + "/direction/bicycling?";
    }
}
