package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DrivePlanSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m4 extends b4<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public m4(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    private static DriveRoutePlanResult U(String str) throws AMapException {
        return r4.C0(str);
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
        if (((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getDestinationType());
            }
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getPlateProvince());
            }
            if (!r4.s0(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.f9630n).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f9630n).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DrivePlanQuery) this.f9630n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) this.f9630n).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) this.f9630n).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) this.f9630n).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) this.f9630n).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.c() + "/etd/driving?";
    }
}
