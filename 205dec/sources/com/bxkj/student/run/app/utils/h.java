package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Douglas.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f22816a;

    /* renamed from: b  reason: collision with root package name */
    private int f22817b;

    /* renamed from: c  reason: collision with root package name */
    private double f22818c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<k> f22819d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<k> f22820e = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Douglas.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements Comparator<k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(k latLngPoint, k t12) {
            return latLngPoint.compareTo(t12);
        }
    }

    public h(ArrayList<LatLng> mLineInit, double dmax) {
        if (mLineInit != null) {
            this.f22818c = dmax;
            this.f22816a = 0;
            this.f22817b = mLineInit.size() - 1;
            for (int i4 = 0; i4 < mLineInit.size(); i4++) {
                this.f22819d.add(new k(i4, mLineInit.get(i4)));
            }
            return;
        }
        throw new IllegalArgumentException("\u4f20\u5165\u7684\u7ecf\u7eac\u5ea6\u5750\u6807list\u4e3a\u7a7a");
    }

    private ArrayList<k> b(k[] originalLatLngs, ArrayList<k> endLatLngs, int start, int end, double dMax) {
        k kVar = originalLatLngs[start];
        k kVar2 = originalLatLngs[end];
        double d4 = 0.0d;
        int i4 = 0;
        for (int i5 = start + 1; i5 < end; i5++) {
            double c4 = c(kVar, kVar2, originalLatLngs[i5]);
            if (c4 > d4) {
                i4 = i5;
                d4 = c4;
            }
        }
        if (d4 > dMax) {
            endLatLngs.add(originalLatLngs[i4]);
            b(originalLatLngs, endLatLngs, start, i4, dMax);
            b(originalLatLngs, endLatLngs, i4, end, dMax);
        }
        return endLatLngs;
    }

    private double c(k start, k end, k center) {
        double abs = Math.abs(AMapUtils.calculateLineDistance(start.f22880b, end.f22880b));
        double abs2 = Math.abs(AMapUtils.calculateLineDistance(start.f22880b, center.f22880b));
        double abs3 = Math.abs(AMapUtils.calculateLineDistance(center.f22880b, end.f22880b));
        Double.isNaN(abs);
        Double.isNaN(abs2);
        Double.isNaN(abs3);
        double d4 = ((abs + abs2) + abs3) / 2.0d;
        Double.isNaN(abs);
        Double.isNaN(abs2);
        Double.isNaN(abs3);
        Double.isNaN(abs);
        return (Math.sqrt((((d4 - abs) * d4) * (d4 - abs2)) * (d4 - abs3)) * 2.0d) / abs;
    }

    public ArrayList<LatLng> a() {
        int size = this.f22819d.size();
        ArrayList<k> b4 = b((k[]) this.f22819d.toArray(new k[size]), this.f22820e, this.f22816a, this.f22817b, this.f22818c);
        b4.add(this.f22819d.get(0));
        b4.add(this.f22819d.get(size - 1));
        Collections.sort(b4, new a());
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Iterator<k> it = b4.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f22880b);
        }
        return arrayList;
    }
}
