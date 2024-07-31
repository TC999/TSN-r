package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* renamed from: com.amap.api.col.s.c4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusRouteSearchHandler extends BasicLBSRestHandler<RouteSearch.BusRouteQuery, BusRouteResult> {
    public BusRouteSearchHandler(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* renamed from: U */
    private static BusRouteResult m53128U(String str) throws AMapException {
        return JSONHelper.m52486u(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53128U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&origin=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearch.BusRouteQuery) this.f5880n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearch.BusRouteQuery) this.f5880n).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f5880n).getCity();
        if (!JSONHelper.m52489s0(city)) {
            city = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!JSONHelper.m52489s0(((RouteSearch.BusRouteQuery) this.f5880n).getCity())) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(m53218i);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.f5880n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f5880n).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.f5880n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.f5880n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/direction/transit/integrated?";
    }
}
