package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestCacheConfig.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f10001a;

    public static synchronized void a() {
        synchronized (m.class) {
            if (!f10001a) {
                n.b().g("regeo", new p("/geocode/regeo"));
                n.b().g("placeAround", new p("/place/around"));
                n.b().g("placeText", new o("/place/text"));
                n.b().g("geo", new o("/geocode/geo"));
                f10001a = true;
            }
        }
    }
}
