package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DriveRouteSearchHandlerV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o4 extends b4<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public o4(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 U(String str) throws AMapException {
        return r4.Y(str);
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
        if (((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getMode().getValue());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) this.f9630n).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) this.f9630n).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) this.f9630n).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) this.f9630n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f9630n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f9630n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b4.i(((RouteSearchV2.DriveRouteQuery) this.f9630n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) this.f9630n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f9630n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/driving?";
    }
}
