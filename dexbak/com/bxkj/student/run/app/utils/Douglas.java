package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.bxkj.student.run.app.utils.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Douglas {

    /* renamed from: a */
    private int f19586a;

    /* renamed from: b */
    private int f19587b;

    /* renamed from: c */
    private double f19588c;

    /* renamed from: d */
    private ArrayList<LatLngPoint> f19589d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<LatLngPoint> f19590e = new ArrayList<>();

    /* compiled from: Douglas.java */
    /* renamed from: com.bxkj.student.run.app.utils.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5383a implements Comparator<LatLngPoint> {
        C5383a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(LatLngPoint latLngPoint, LatLngPoint t1) {
            return latLngPoint.compareTo(t1);
        }
    }

    public Douglas(ArrayList<LatLng> mLineInit, double dmax) {
        if (mLineInit != null) {
            this.f19588c = dmax;
            this.f19586a = 0;
            this.f19587b = mLineInit.size() - 1;
            for (int i = 0; i < mLineInit.size(); i++) {
                this.f19589d.add(new LatLngPoint(i, mLineInit.get(i)));
            }
            return;
        }
        throw new IllegalArgumentException("传入的经纬度坐标list为空");
    }

    /* renamed from: b */
    private ArrayList<LatLngPoint> m39639b(LatLngPoint[] originalLatLngs, ArrayList<LatLngPoint> endLatLngs, int start, int end, double dMax) {
        LatLngPoint latLngPoint = originalLatLngs[start];
        LatLngPoint latLngPoint2 = originalLatLngs[end];
        double d = Utils.DOUBLE_EPSILON;
        int i = 0;
        for (int i2 = start + 1; i2 < end; i2++) {
            double m39638c = m39638c(latLngPoint, latLngPoint2, originalLatLngs[i2]);
            if (m39638c > d) {
                i = i2;
                d = m39638c;
            }
        }
        if (d > dMax) {
            endLatLngs.add(originalLatLngs[i]);
            m39639b(originalLatLngs, endLatLngs, start, i, dMax);
            m39639b(originalLatLngs, endLatLngs, i, end, dMax);
        }
        return endLatLngs;
    }

    /* renamed from: c */
    private double m39638c(LatLngPoint start, LatLngPoint end, LatLngPoint center) {
        double abs = Math.abs(AMapUtils.calculateLineDistance(start.f19650b, end.f19650b));
        double abs2 = Math.abs(AMapUtils.calculateLineDistance(start.f19650b, center.f19650b));
        double abs3 = Math.abs(AMapUtils.calculateLineDistance(center.f19650b, end.f19650b));
        Double.isNaN(abs);
        Double.isNaN(abs2);
        Double.isNaN(abs3);
        double d = ((abs + abs2) + abs3) / 2.0d;
        Double.isNaN(abs);
        Double.isNaN(abs2);
        Double.isNaN(abs3);
        Double.isNaN(abs);
        return (Math.sqrt((((d - abs) * d) * (d - abs2)) * (d - abs3)) * 2.0d) / abs;
    }

    /* renamed from: a */
    public ArrayList<LatLng> m39640a() {
        int size = this.f19589d.size();
        ArrayList<LatLngPoint> m39639b = m39639b((LatLngPoint[]) this.f19589d.toArray(new LatLngPoint[size]), this.f19590e, this.f19586a, this.f19587b, this.f19588c);
        m39639b.add(this.f19589d.get(0));
        m39639b.add(this.f19589d.get(size - 1));
        Collections.sort(m39639b, new C5383a());
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Iterator<LatLngPoint> it = m39639b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f19650b);
        }
        return arrayList;
    }
}
