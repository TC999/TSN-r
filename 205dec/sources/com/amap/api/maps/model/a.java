package com.amap.api.maps.model;

import com.amap.api.col.p0003l.k2;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PointQuadTree.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final k2 f10754a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10755b;

    /* renamed from: c  reason: collision with root package name */
    private List<WeightedLatLng> f10756c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f10757d;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(k2 k2Var) {
        this(k2Var, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f10754a.a(point.f11671x, point.f11672y)) {
            a(point.f11671x, point.f11672y, weightedLatLng);
        }
    }

    private a(double d4, double d5, double d6, double d7, int i4) {
        this(new k2(d4, d5, d6, d7), i4);
    }

    private a(k2 k2Var, int i4) {
        this.f10757d = null;
        this.f10754a = k2Var;
        this.f10755b = i4;
    }

    private void a(double d4, double d5, WeightedLatLng weightedLatLng) {
        List<a> list = this.f10757d;
        if (list != null) {
            k2 k2Var = this.f10754a;
            if (d5 < k2Var.f8234f) {
                if (d4 < k2Var.f8233e) {
                    list.get(0).a(d4, d5, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d4, d5, weightedLatLng);
                    return;
                }
            } else if (d4 < k2Var.f8233e) {
                list.get(2).a(d4, d5, weightedLatLng);
                return;
            } else {
                list.get(3).a(d4, d5, weightedLatLng);
                return;
            }
        }
        if (this.f10756c == null) {
            this.f10756c = new ArrayList();
        }
        this.f10756c.add(weightedLatLng);
        if (this.f10756c.size() <= 50 || this.f10755b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f10757d = arrayList;
        k2 k2Var = this.f10754a;
        arrayList.add(new a(k2Var.f8229a, k2Var.f8233e, k2Var.f8230b, k2Var.f8234f, this.f10755b + 1));
        List<a> list = this.f10757d;
        k2 k2Var2 = this.f10754a;
        list.add(new a(k2Var2.f8233e, k2Var2.f8231c, k2Var2.f8230b, k2Var2.f8234f, this.f10755b + 1));
        List<a> list2 = this.f10757d;
        k2 k2Var3 = this.f10754a;
        list2.add(new a(k2Var3.f8229a, k2Var3.f8233e, k2Var3.f8234f, k2Var3.f8232d, this.f10755b + 1));
        List<a> list3 = this.f10757d;
        k2 k2Var4 = this.f10754a;
        list3.add(new a(k2Var4.f8233e, k2Var4.f8231c, k2Var4.f8234f, k2Var4.f8232d, this.f10755b + 1));
        List<WeightedLatLng> list4 = this.f10756c;
        this.f10756c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().f11671x, weightedLatLng.getPoint().f11672y, weightedLatLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<WeightedLatLng> a(k2 k2Var) {
        ArrayList arrayList = new ArrayList();
        a(k2Var, arrayList);
        return arrayList;
    }

    private void a(k2 k2Var, Collection<WeightedLatLng> collection) {
        if (this.f10754a.c(k2Var)) {
            List<a> list = this.f10757d;
            if (list != null) {
                for (a aVar : list) {
                    aVar.a(k2Var, collection);
                }
            } else if (this.f10756c != null) {
                if (k2Var.e(this.f10754a)) {
                    collection.addAll(this.f10756c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.f10756c) {
                    if (k2Var.d(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
