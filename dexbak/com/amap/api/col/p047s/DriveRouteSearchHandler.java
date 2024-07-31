package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* renamed from: com.amap.api.col.s.n4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DriveRouteSearchHandler extends BasicLBSRestHandler<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public DriveRouteSearchHandler(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* renamed from: U */
    private static DriveRouteResult m52731U(String str) throws AMapException {
        return JSONHelper.m52538T(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52731U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        if (((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getFrom()));
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getTo()));
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getOriginType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateProvince());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.f5880n).getMode());
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.f5880n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.f5880n).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) this.f5880n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) this.f5880n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f5880n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f5880n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(BasicLBSRestHandler.m53218i(((RouteSearch.DriveRouteQuery) this.f5880n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.f5880n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f5880n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/direction/driving?";
    }
}
