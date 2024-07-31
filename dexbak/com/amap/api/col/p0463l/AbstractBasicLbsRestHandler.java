package com.amap.api.col.p0463l;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.y3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractBasicLbsRestHandler<T, V> extends AbstractBasicHandler<T, V> {
    public AbstractBasicLbsRestHandler(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: e */
    protected abstract V mo53402e(String str) throws AMapException;

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public byte[] getEntityBytes() {
        try {
            return mo53401m().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler, com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 10.0.600");
        hashMap.put("x-INFO", ClientInfo.m54925i(this.f5673k));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: m */
    protected abstract String mo53401m();
}
