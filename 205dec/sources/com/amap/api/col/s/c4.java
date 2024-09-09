package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BusRouteSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c4 extends b4<RouteSearch.BusRouteQuery, BusRouteResult> {
    public c4(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult U(String str) throws AMapException {
        return r4.u(str);
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
        stringBuffer.append(j4.d(((RouteSearch.BusRouteQuery) this.f9630n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearch.BusRouteQuery) this.f9630n).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f9630n).getCity();
        if (!r4.s0(city)) {
            city = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!r4.s0(((RouteSearch.BusRouteQuery) this.f9630n).getCity())) {
            String i4 = b4.i(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(i4);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.f9630n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f9630n).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.f9630n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.f9630n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/direction/transit/integrated?";
    }
}
