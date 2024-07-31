package com.amap.api.col.p047s;

/* renamed from: com.amap.api.col.s.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class RequestCacheConfig {

    /* renamed from: a */
    private static volatile boolean f6273a;

    /* renamed from: a */
    public static synchronized void m52774a() {
        synchronized (RequestCacheConfig.class) {
            if (!f6273a) {
                RequestCacheControl.m52764b().m52759g("regeo", new RequestCacheWorkerCheckDistance("/geocode/regeo"));
                RequestCacheControl.m52764b().m52759g("placeAround", new RequestCacheWorkerCheckDistance("/place/around"));
                RequestCacheControl.m52764b().m52759g("placeText", new RequestCacheWorker("/place/text"));
                RequestCacheControl.m52764b().m52759g("geo", new RequestCacheWorker("/geocode/geo"));
                f6273a = true;
            }
        }
    }
}
