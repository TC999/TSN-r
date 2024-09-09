package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NearbyUpdateHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c extends b4<UploadInfo, Integer> {

    /* renamed from: t  reason: collision with root package name */
    private Context f9659t;

    /* renamed from: u  reason: collision with root package name */
    private UploadInfo f9660u;

    public c(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f9659t = context;
        this.f9660u = uploadInfo;
    }

    private static Integer U() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return U();
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f9659t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f9660u.getUserID());
        LatLonPoint point = this.f9660u.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((int) (point.getLongitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((int) (point.getLatitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f9660u.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/data/create";
    }
}
