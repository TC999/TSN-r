package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TruckRouteSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z extends b4<RouteSearch.TruckRouteQuery, TruckRouteRestult> {

    /* renamed from: t  reason: collision with root package name */
    private final String f10543t;

    /* renamed from: u  reason: collision with root package name */
    private final String f10544u;

    /* renamed from: v  reason: collision with root package name */
    private final String f10545v;

    public z(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.f10543t = "/direction/truck?";
        this.f10544u = "|";
        this.f10545v = ",";
    }

    private static TruckRouteRestult U(String str) throws AMapException {
        return r4.A0(str);
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
        if (((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getDestinationType());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getPlateProvince());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f9630n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.f9630n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f9630n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.c() + "/direction/truck?";
    }
}
