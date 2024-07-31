package com.amap.api.maps.model;

import com.amap.api.col.p0463l.Bounds;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.amap.api.maps.model.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class PointQuadTree {

    /* renamed from: a */
    private final Bounds f7057a;

    /* renamed from: b */
    private final int f7058b;

    /* renamed from: c */
    private List<WeightedLatLng> f7059c;

    /* renamed from: d */
    private List<PointQuadTree> f7060d;

    /* JADX INFO: Access modifiers changed from: protected */
    public PointQuadTree(Bounds bounds) {
        this(bounds, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m52020a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f7057a.m54642a(point.f7977x, point.f7978y)) {
            m52023a(point.f7977x, point.f7978y, weightedLatLng);
        }
    }

    private PointQuadTree(double d, double d2, double d3, double d4, int i) {
        this(new Bounds(d, d2, d3, d4), i);
    }

    private PointQuadTree(Bounds bounds, int i) {
        this.f7060d = null;
        this.f7057a = bounds;
        this.f7058b = i;
    }

    /* renamed from: a */
    private void m52023a(double d, double d2, WeightedLatLng weightedLatLng) {
        List<PointQuadTree> list = this.f7060d;
        if (list != null) {
            Bounds bounds = this.f7057a;
            if (d2 < bounds.f4597f) {
                if (d < bounds.f4596e) {
                    list.get(0).m52023a(d, d2, weightedLatLng);
                    return;
                } else {
                    list.get(1).m52023a(d, d2, weightedLatLng);
                    return;
                }
            } else if (d < bounds.f4596e) {
                list.get(2).m52023a(d, d2, weightedLatLng);
                return;
            } else {
                list.get(3).m52023a(d, d2, weightedLatLng);
                return;
            }
        }
        if (this.f7059c == null) {
            this.f7059c = new ArrayList();
        }
        this.f7059c.add(weightedLatLng);
        if (this.f7059c.size() <= 50 || this.f7058b >= 40) {
            return;
        }
        m52024a();
    }

    /* renamed from: a */
    private void m52024a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7060d = arrayList;
        Bounds bounds = this.f7057a;
        arrayList.add(new PointQuadTree(bounds.f4592a, bounds.f4596e, bounds.f4593b, bounds.f4597f, this.f7058b + 1));
        List<PointQuadTree> list = this.f7060d;
        Bounds bounds2 = this.f7057a;
        list.add(new PointQuadTree(bounds2.f4596e, bounds2.f4594c, bounds2.f4593b, bounds2.f4597f, this.f7058b + 1));
        List<PointQuadTree> list2 = this.f7060d;
        Bounds bounds3 = this.f7057a;
        list2.add(new PointQuadTree(bounds3.f4592a, bounds3.f4596e, bounds3.f4597f, bounds3.f4595d, this.f7058b + 1));
        List<PointQuadTree> list3 = this.f7060d;
        Bounds bounds4 = this.f7057a;
        list3.add(new PointQuadTree(bounds4.f4596e, bounds4.f4594c, bounds4.f4597f, bounds4.f4595d, this.f7058b + 1));
        List<WeightedLatLng> list4 = this.f7059c;
        this.f7059c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            m52023a(weightedLatLng.getPoint().f7977x, weightedLatLng.getPoint().f7978y, weightedLatLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Collection<WeightedLatLng> m52022a(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        m52021a(bounds, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m52021a(Bounds bounds, Collection<WeightedLatLng> collection) {
        if (this.f7057a.m54640c(bounds)) {
            List<PointQuadTree> list = this.f7060d;
            if (list != null) {
                for (PointQuadTree pointQuadTree : list) {
                    pointQuadTree.m52021a(bounds, collection);
                }
            } else if (this.f7059c != null) {
                if (bounds.m54638e(this.f7057a)) {
                    collection.addAll(this.f7059c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.f7059c) {
                    if (bounds.m54639d(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
