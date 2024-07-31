package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* renamed from: com.amap.api.col.s.k4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DistanceSearchHandler extends BasicLBSRestHandler<DistanceSearch.DistanceQuery, DistanceResult> {

    /* renamed from: t */
    private final String f6254t;

    /* renamed from: u */
    private final String f6255u;

    /* renamed from: v */
    private final String f6256v;

    public DistanceSearchHandler(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.f6254t = "/distance?";
        this.f6255u = "|";
        this.f6256v = ",";
    }

    /* renamed from: U */
    private static DistanceResult m52780U(String str) throws AMapException {
        return JSONHelper.m52477y0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52780U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f5880n).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i = 0; i < size; i++) {
                LatLonPoint latLonPoint = origins.get(i);
                if (latLonPoint != null) {
                    double m52833a = C2082j4.m52833a(latLonPoint.getLatitude());
                    stringBuffer.append(C2082j4.m52833a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(m52833a);
                    if (i < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f5880n).getDestination();
        if (destination != null) {
            double m52833a2 = C2082j4.m52833a(destination.getLatitude());
            double m52833a3 = C2082j4.m52833a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(m52833a3);
            stringBuffer.append(",");
            stringBuffer.append(m52833a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f5880n).getType());
        if (!TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.f5880n).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f5880n).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.f5880n).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f5880n).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/distance?";
    }
}
