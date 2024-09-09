package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DistanceSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k4 extends b4<DistanceSearch.DistanceQuery, DistanceResult> {

    /* renamed from: t  reason: collision with root package name */
    private final String f9982t;

    /* renamed from: u  reason: collision with root package name */
    private final String f9983u;

    /* renamed from: v  reason: collision with root package name */
    private final String f9984v;

    public k4(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.f9982t = "/distance?";
        this.f9983u = "|";
        this.f9984v = ",";
    }

    private static DistanceResult U(String str) throws AMapException {
        return r4.y0(str);
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
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f9630n).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i4 = 0; i4 < size; i4++) {
                LatLonPoint latLonPoint = origins.get(i4);
                if (latLonPoint != null) {
                    double a4 = j4.a(latLonPoint.getLatitude());
                    stringBuffer.append(j4.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a4);
                    if (i4 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f9630n).getDestination();
        if (destination != null) {
            double a5 = j4.a(destination.getLatitude());
            double a6 = j4.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a6);
            stringBuffer.append(",");
            stringBuffer.append(a5);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f9630n).getType());
        if (!TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.f9630n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f9630n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.f9630n).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f9630n).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/distance?";
    }
}
