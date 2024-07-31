package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* renamed from: com.amap.api.col.s.m4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DrivePlanSearchHandler extends BasicLBSRestHandler<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public DrivePlanSearchHandler(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    /* renamed from: U */
    private static DriveRoutePlanResult m52766U(String str) throws AMapException {
        return JSONHelper.m52571C0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52766U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        if (((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getFrom()));
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C2082j4.m52830d(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getTo()));
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getDestinationPoiID());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getOriginType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getDestinationType());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getPlateProvince());
            }
            if (!JSONHelper.m52489s0(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.f5880n).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f5880n).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DrivePlanQuery) this.f5880n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) this.f5880n).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) this.f5880n).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) this.f5880n).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) this.f5880n).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52893c() + "/etd/driving?";
    }
}
