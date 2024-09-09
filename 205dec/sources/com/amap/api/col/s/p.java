package com.amap.api.col.s;

import com.amap.api.col.s.n;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestCacheWorkerCheckDistance.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class p extends o {

    /* renamed from: j  reason: collision with root package name */
    private double f10063j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RequestCacheWorkerCheckDistance.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        LatLonPoint f10064a;

        /* renamed from: b  reason: collision with root package name */
        double f10065b;

        public a(double d4, double d5, double d6) {
            this.f10064a = null;
            this.f10065b = 0.0d;
            this.f10064a = new LatLonPoint(d4, d5);
            this.f10065b = d6;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f10064a;
                a aVar = (a) obj;
                LatLonPoint latLonPoint2 = aVar.f10064a;
                if (latLonPoint == latLonPoint2) {
                    return true;
                }
                if (latLonPoint != null && j4.b(latLonPoint, latLonPoint2) <= aVar.f10065b) {
                    return true;
                }
            }
            return false;
        }
    }

    public p(String... strArr) {
        super(strArr);
        this.f10063j = 0.0d;
    }

    @Override // com.amap.api.col.s.o
    public final void c(n.a aVar) {
        super.c(aVar);
        if (aVar != null) {
            this.f10063j = aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.o
    public final boolean f(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f10029b == null) {
                return super.f(linkedHashMap, bVar);
            }
            for (n.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f10028a) != null && str.equals(bVar.f10028a)) {
                    Object obj = bVar2.f10029b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f10029b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.o
    public final Object g(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f10029b == null) {
                return super.g(linkedHashMap, bVar);
            }
            for (n.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f10028a) != null && str.equals(bVar.f10028a)) {
                    Object obj = bVar2.f10029b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f10029b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.o
    public final Object k(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        n.b bVar2;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f10029b == null) {
                return super.k(linkedHashMap, bVar);
            }
            Iterator<n.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && (str = bVar2.f10028a) != null && str.equals(bVar.f10028a)) {
                    Object obj = bVar2.f10029b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f10029b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    public final double l() {
        return this.f10063j;
    }
}
