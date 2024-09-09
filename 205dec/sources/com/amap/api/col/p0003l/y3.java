package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AbstractBasicLbsRestHandler.java */
/* renamed from: com.amap.api.col.3l.y3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class y3<T, V> extends x3<T, V> {
    public y3(Context context, T t3) {
        super(context, t3);
    }

    @Override // com.amap.api.col.p0003l.x3
    protected abstract V e(String str) throws fc;

    @Override // com.amap.api.col.p0003l.Cif
    public byte[] getEntityBytes() {
        try {
            return m().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.x3, com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 10.0.600");
        hashMap.put("x-INFO", h4.i(this.f9404k));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.x3
    protected abstract String m();
}
