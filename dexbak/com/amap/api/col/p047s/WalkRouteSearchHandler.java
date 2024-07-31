package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* renamed from: com.amap.api.col.s.a0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WalkRouteSearchHandler extends BasicLBSRestHandler<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public WalkRouteSearchHandler(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* renamed from: U */
    private static WalkRouteResult m53276U(String str) throws AMapException {
        return JSONHelper.m52515f0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53276U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&origin=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearch.WalkRouteQuery) this.f5880n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C2082j4.m52830d(((RouteSearch.WalkRouteQuery) this.f5880n).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((RouteSearch.WalkRouteQuery) this.f5880n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.WalkRouteQuery) this.f5880n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/direction/walking?";
    }
}
