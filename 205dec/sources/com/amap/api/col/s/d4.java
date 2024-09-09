package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BusRouteSearchHandlerV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d4 extends b4<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public d4(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResultV2 U(String str) throws AMapException {
        return r4.L(str);
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
        stringBuffer.append(j4.d(((RouteSearchV2.BusRouteQuery) this.f9630n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearchV2.BusRouteQuery) this.f9630n).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) this.f9630n).getCity();
        if (!r4.s0(city)) {
            city = b4.i(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!r4.s0(((RouteSearchV2.BusRouteQuery) this.f9630n).getCity())) {
            String i4 = b4.i(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(i4);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.BusRouteQuery) this.f9630n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f9630n).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(((RouteSearchV2.BusRouteQuery) this.f9630n).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) this.f9630n).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) this.f9630n).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) this.f9630n).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) this.f9630n).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) this.f9630n).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) this.f9630n).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f9630n).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f9630n).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f9630n).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/transit/integrated?";
    }
}
