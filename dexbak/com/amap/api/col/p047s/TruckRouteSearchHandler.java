package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* renamed from: com.amap.api.col.s.z */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TruckRouteSearchHandler extends BasicLBSRestHandler<RouteSearch.TruckRouteQuery, TruckRouteRestult> {

    /* renamed from: t */
    private final String f6820t;

    /* renamed from: u */
    private final String f6821u;

    /* renamed from: v */
    private final String f6822v;

    public TruckRouteSearchHandler(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.f6820t = "/direction/truck?";
        this.f6821u = "|";
        this.f6822v = ",";
    }

    /* renamed from: U */
    private static TruckRouteRestult m52181U(String str) throws AMapException {
        return JSONHelper.m52575A0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52181U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        if (((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getFrom()));
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getTo()));
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getDestinationPoiID());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getOriginType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getDestinationType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getPlateProvince());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f5880n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.f5880n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f5880n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52893c() + "/direction/truck?";
    }
}
