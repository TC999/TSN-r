package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* renamed from: com.amap.api.col.s.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NearbyUpdateHandler extends BasicLBSRestHandler<UploadInfo, Integer> {

    /* renamed from: t */
    private Context f5909t;

    /* renamed from: u */
    private UploadInfo f5910u;

    public NearbyUpdateHandler(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f5909t = context;
        this.f5910u = uploadInfo;
    }

    /* renamed from: U */
    private static Integer m53205U() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53205U();
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5909t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f5910u.getUserID());
        LatLonPoint point = this.f5910u.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((int) (point.getLongitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((int) (point.getLatitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f5910u.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52891e() + "/nearby/data/create";
    }
}
