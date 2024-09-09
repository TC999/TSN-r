package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DriveRouteSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n4 extends b4<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public n4(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult U(String str) throws AMapException {
        return r4.T(str);
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
        if (((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationType());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateProvince());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.f9630n).getMode());
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.f9630n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.f9630n).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) this.f9630n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) this.f9630n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f9630n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f9630n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b4.i(((RouteSearch.DriveRouteQuery) this.f9630n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.f9630n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f9630n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/direction/driving?";
    }
}
