package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WalkRouteSearchHandlerV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c0 extends b4<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    public c0(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    private static WalkRouteResultV2 U(String str) throws AMapException {
        return r4.j0(str);
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
        stringBuffer.append(j4.d(((RouteSearchV2.WalkRouteQuery) this.f9630n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearchV2.WalkRouteQuery) this.f9630n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f9630n).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f9630n).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(((RouteSearchV2.WalkRouteQuery) this.f9630n).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/walking?";
    }
}
