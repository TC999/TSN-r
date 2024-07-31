package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* renamed from: com.amap.api.col.s.o4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DriveRouteSearchHandlerV2 extends BasicLBSRestHandler<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public DriveRouteSearchHandlerV2(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* renamed from: U */
    private static DriveRouteResultV2 m52712U(String str) throws AMapException {
        return JSONHelper.m52528Y(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52712U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        if (((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getFrom()));
            if (!JSONHelper.m52489s0(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getTo()));
            if (!JSONHelper.m52489s0(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID());
            }
            if (!JSONHelper.m52489s0(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getOriginType());
            }
            if (!JSONHelper.m52489s0(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getMode().getValue());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) this.f5880n).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C2082j4.m52831c(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) this.f5880n).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) this.f5880n).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) this.f5880n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f5880n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f5880n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(BasicLBSRestHandler.m53218i(((RouteSearchV2.DriveRouteQuery) this.f5880n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) this.f5880n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f5880n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52892d() + "/direction/driving?";
    }
}
