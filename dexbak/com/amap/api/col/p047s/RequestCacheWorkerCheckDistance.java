package com.amap.api.col.p047s;

import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.LatLonPoint;
import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.amap.api.col.s.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class RequestCacheWorkerCheckDistance extends RequestCacheWorker {

    /* renamed from: j */
    private double f6335j;

    /* compiled from: RequestCacheWorkerCheckDistance.java */
    /* renamed from: com.amap.api.col.s.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C2110a {

        /* renamed from: a */
        LatLonPoint f6336a;

        /* renamed from: b */
        double f6337b;

        public C2110a(double d, double d2, double d3) {
            this.f6336a = null;
            this.f6337b = Utils.DOUBLE_EPSILON;
            this.f6336a = new LatLonPoint(d, d2);
            this.f6337b = d3;
        }

        /* renamed from: a */
        public final boolean m52706a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C2110a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f6336a;
                C2110a c2110a = (C2110a) obj;
                LatLonPoint latLonPoint2 = c2110a.f6336a;
                if (latLonPoint == latLonPoint2) {
                    return true;
                }
                if (latLonPoint != null && C2082j4.m52832b(latLonPoint, latLonPoint2) <= c2110a.f6337b) {
                    return true;
                }
            }
            return false;
        }
    }

    public RequestCacheWorkerCheckDistance(String... strArr) {
        super(strArr);
        this.f6335j = Utils.DOUBLE_EPSILON;
    }

    @Override // com.amap.api.col.p047s.RequestCacheWorker
    /* renamed from: c */
    public final void mo52711c(RequestCacheControl.C2096a c2096a) {
        super.mo52711c(c2096a);
        if (c2096a != null) {
            this.f6335j = c2096a.m52750h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.RequestCacheWorker
    /* renamed from: f */
    public final boolean mo52710f(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        String str;
        if (linkedHashMap != null && c2097b != null) {
            if (c2097b.f6301b == null) {
                return super.mo52710f(linkedHashMap, c2097b);
            }
            for (RequestCacheControl.C2097b c2097b2 : linkedHashMap.keySet()) {
                if (c2097b2 != null && (str = c2097b2.f6300a) != null && str.equals(c2097b.f6300a)) {
                    Object obj = c2097b2.f6301b;
                    if ((obj instanceof C2110a) && ((C2110a) obj).m52706a(c2097b.f6301b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.RequestCacheWorker
    /* renamed from: g */
    public final Object mo52709g(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        String str;
        if (linkedHashMap != null && c2097b != null) {
            if (c2097b.f6301b == null) {
                return super.mo52709g(linkedHashMap, c2097b);
            }
            for (RequestCacheControl.C2097b c2097b2 : linkedHashMap.keySet()) {
                if (c2097b2 != null && (str = c2097b2.f6300a) != null && str.equals(c2097b.f6300a)) {
                    Object obj = c2097b2.f6301b;
                    if ((obj instanceof C2110a) && ((C2110a) obj).m52706a(c2097b.f6301b)) {
                        return linkedHashMap.get(c2097b2);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.RequestCacheWorker
    /* renamed from: k */
    public final Object mo52708k(LinkedHashMap<RequestCacheControl.C2097b, Object> linkedHashMap, RequestCacheControl.C2097b c2097b) {
        RequestCacheControl.C2097b c2097b2;
        String str;
        if (linkedHashMap != null && c2097b != null) {
            if (c2097b.f6301b == null) {
                return super.mo52708k(linkedHashMap, c2097b);
            }
            Iterator<RequestCacheControl.C2097b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    c2097b2 = null;
                    break;
                }
                c2097b2 = it.next();
                if (c2097b2 != null && (str = c2097b2.f6300a) != null && str.equals(c2097b.f6300a)) {
                    Object obj = c2097b2.f6301b;
                    if ((obj instanceof C2110a) && ((C2110a) obj).m52706a(c2097b.f6301b)) {
                        break;
                    }
                }
            }
            if (c2097b2 != null) {
                return linkedHashMap.remove(c2097b2);
            }
        }
        return null;
    }

    /* renamed from: l */
    public final double m52707l() {
        return this.f6335j;
    }
}
