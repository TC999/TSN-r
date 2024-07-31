package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* renamed from: com.amap.api.col.s.c0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WalkRouteSearchHandlerV2 extends BasicLBSRestHandler<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    public WalkRouteSearchHandlerV2(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* renamed from: U */
    private static WalkRouteResultV2 m53204U(String str) throws AMapException {
        return JSONHelper.m52507j0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53204U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&origin=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.WalkRouteQuery) this.f5880n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearchV2.WalkRouteQuery) this.f5880n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f5880n).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f5880n).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C2082j4.m52831c(((RouteSearchV2.WalkRouteQuery) this.f5880n).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52892d() + "/direction/walking?";
    }
}
