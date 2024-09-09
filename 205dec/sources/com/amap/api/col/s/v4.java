package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NearbyDeleteHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v4 extends b4<String, Integer> {

    /* renamed from: t  reason: collision with root package name */
    private Context f10347t;

    /* renamed from: u  reason: collision with root package name */
    private String f10348u;

    public v4(Context context, String str) {
        super(context, str);
        this.f10347t = context;
        this.f10348u = str;
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
        stringBuffer.append(x0.i(this.f10347t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f10348u);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/data/delete";
    }
}
