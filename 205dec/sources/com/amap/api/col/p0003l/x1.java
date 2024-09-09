package com.amap.api.col.p0003l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CustomStyleTextureRequest.java */
/* renamed from: com.amap.api.col.3l.x1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x1 extends x3<String, a> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CustomStyleTextureRequest.java */
    /* renamed from: com.amap.api.col.3l.x1$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9387a;

        /* renamed from: b  reason: collision with root package name */
        public int f9388b = -1;
    }

    public x1(Context context, String str) {
        super(context, str);
        this.f9405p = "/map/styles";
    }

    private static a p(byte[] bArr) throws fc {
        a aVar = new a();
        aVar.f9387a = bArr;
        return aVar;
    }

    public final void b(String str) {
        this.f9405p = str;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected final /* bridge */ /* synthetic */ a e(String str) throws fc {
        return null;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected final /* synthetic */ a f(byte[] bArr) throws fc {
        return p(bArr);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return a3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9404k));
        hashMap.put("output", "bin");
        String a4 = h4.a();
        String c4 = h4.c(this.f9404k, a4, q4.r(hashMap));
        hashMap.put("ts", a4);
        hashMap.put("scode", c4);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f9405p;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected final String m() {
        return null;
    }
}
