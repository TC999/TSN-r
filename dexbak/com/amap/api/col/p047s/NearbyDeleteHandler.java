package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* renamed from: com.amap.api.col.s.v4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NearbyDeleteHandler extends BasicLBSRestHandler<String, Integer> {

    /* renamed from: t */
    private Context f6619t;

    /* renamed from: u */
    private String f6620u;

    public NearbyDeleteHandler(Context context, String str) {
        super(context, str);
        this.f6619t = context;
        this.f6620u = str;
    }

    /* renamed from: U */
    private static Integer m52377U() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52377U();
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f6619t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f6620u);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52891e() + "/nearby/data/delete";
    }
}
