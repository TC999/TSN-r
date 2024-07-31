package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* renamed from: com.amap.api.col.s.d4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusRouteSearchHandlerV2 extends BasicLBSRestHandler<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public BusRouteSearchHandlerV2(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* renamed from: U */
    private static BusRouteResultV2 m53079U(String str) throws AMapException {
        return JSONHelper.m52554L(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53079U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&origin=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.BusRouteQuery) this.f5880n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.BusRouteQuery) this.f5880n).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) this.f5880n).getCity();
        if (!JSONHelper.m52489s0(city)) {
            city = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!JSONHelper.m52489s0(((RouteSearchV2.BusRouteQuery) this.f5880n).getCity())) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(m53218i);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.BusRouteQuery) this.f5880n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f5880n).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C2082j4.m52831c(((RouteSearchV2.BusRouteQuery) this.f5880n).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) this.f5880n).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) this.f5880n).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) this.f5880n).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) this.f5880n).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) this.f5880n).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) this.f5880n).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f5880n).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f5880n).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f5880n).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52892d() + "/direction/transit/integrated?";
    }
}
