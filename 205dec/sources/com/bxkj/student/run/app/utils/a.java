package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AMapPathSmoothTool.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private double f22770d;

    /* renamed from: e  reason: collision with root package name */
    private double f22771e;

    /* renamed from: f  reason: collision with root package name */
    private double f22772f;

    /* renamed from: g  reason: collision with root package name */
    private double f22773g;

    /* renamed from: h  reason: collision with root package name */
    private double f22774h;

    /* renamed from: i  reason: collision with root package name */
    private double f22775i;

    /* renamed from: j  reason: collision with root package name */
    private double f22776j;

    /* renamed from: k  reason: collision with root package name */
    private double f22777k;

    /* renamed from: l  reason: collision with root package name */
    private double f22778l;

    /* renamed from: m  reason: collision with root package name */
    private double f22779m;

    /* renamed from: n  reason: collision with root package name */
    private double f22780n;

    /* renamed from: o  reason: collision with root package name */
    private double f22781o;

    /* renamed from: p  reason: collision with root package name */
    private double f22782p;

    /* renamed from: q  reason: collision with root package name */
    private double f22783q;

    /* renamed from: a  reason: collision with root package name */
    private int f22767a = 3;

    /* renamed from: b  reason: collision with root package name */
    private float f22768b = 0.3f;

    /* renamed from: c  reason: collision with root package name */
    private float f22769c = 10.0f;

    /* renamed from: r  reason: collision with root package name */
    private double f22784r = 0.0d;

    /* renamed from: s  reason: collision with root package name */
    private double f22785s = 0.0d;

    private static double a(LatLng p3, LatLng lineBegin, LatLng lineEnd) {
        double d4 = p3.longitude;
        double d5 = lineBegin.longitude;
        double d6 = p3.latitude;
        double d7 = lineBegin.latitude;
        double d8 = lineEnd.longitude;
        double d9 = d8 - d5;
        double d10 = lineEnd.latitude;
        double d11 = d10 - d7;
        double d12 = (((d4 - d5) * d9) + ((d6 - d7) * d11)) / ((d9 * d9) + (d11 * d11));
        if (d12 >= 0.0d && (d5 != d8 || d7 != d10)) {
            if (d12 > 1.0d) {
                d7 = d10;
                d5 = d8;
            } else {
                d5 += d9 * d12;
                d7 += d12 * d11;
            }
        }
        return AMapUtils.calculateLineDistance(p3, new LatLng(d7, d5));
    }

    private static LatLng c(List<LatLng> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    private void e() {
        this.f22776j = 0.001d;
        this.f22777k = 0.001d;
        this.f22778l = 5.698402909980532E-4d;
        this.f22779m = 5.698402909980532E-4d;
    }

    private LatLng f(double oldValue_x, double value_x, double oldValue_y, double value_y) {
        this.f22770d = oldValue_x;
        this.f22771e = value_x;
        double d4 = this.f22776j;
        double d5 = this.f22778l;
        double sqrt = Math.sqrt((d4 * d4) + (d5 * d5)) + this.f22785s;
        this.f22780n = sqrt;
        double d6 = this.f22776j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d6 * d6))) + this.f22784r;
        this.f22782p = sqrt2;
        double d7 = this.f22771e;
        double d8 = this.f22770d;
        this.f22774h = ((d7 - d8) * sqrt2) + d8;
        double d9 = this.f22780n;
        this.f22778l = Math.sqrt((1.0d - sqrt2) * d9 * d9);
        this.f22772f = oldValue_y;
        this.f22773g = value_y;
        double d10 = this.f22777k;
        double d11 = this.f22779m;
        double sqrt3 = Math.sqrt((d10 * d10) + (d11 * d11)) + this.f22785s;
        this.f22781o = sqrt3;
        double d12 = this.f22777k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d12 * d12))) + this.f22784r;
        this.f22783q = sqrt4;
        double d13 = this.f22773g;
        double d14 = this.f22772f;
        this.f22775i = ((d13 - d14) * sqrt4) + d14;
        double d15 = 1.0d - sqrt4;
        double d16 = this.f22781o;
        this.f22779m = Math.sqrt(d15 * d16 * d16);
        return new LatLng(this.f22775i, this.f22774h);
    }

    private List<LatLng> h(List<LatLng> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            e();
            LatLng latLng = originlist.get(0);
            arrayList.add(latLng);
            for (int i4 = 1; i4 < originlist.size(); i4++) {
                LatLng j4 = j(latLng, originlist.get(i4), intensity);
                if (j4 != null) {
                    arrayList.add(j4);
                    latLng = j4;
                }
            }
        }
        return arrayList;
    }

    private LatLng j(LatLng lastLoc, LatLng curLoc, int intensity) {
        if (this.f22776j == 0.0d || this.f22777k == 0.0d) {
            e();
        }
        LatLng latLng = null;
        if (lastLoc != null && curLoc != null) {
            if (intensity < 1) {
                intensity = 1;
            } else if (intensity > 5) {
                intensity = 5;
            }
            int i4 = 0;
            while (i4 < intensity) {
                latLng = f(lastLoc.longitude, curLoc.longitude, lastLoc.latitude, curLoc.latitude);
                i4++;
                curLoc = latLng;
            }
        }
        return latLng;
    }

    private List<LatLng> l(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < inPoints.size(); i4++) {
            LatLng c4 = c(arrayList);
            LatLng latLng = inPoints.get(i4);
            if (c4 != null && i4 != inPoints.size() - 1) {
                if (a(latLng, c4, inPoints.get(i4 + 1)) < threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    private List<LatLng> n(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < inPoints.size(); i4++) {
            LatLng c4 = c(arrayList);
            LatLng latLng = inPoints.get(i4);
            if (c4 != null && i4 != inPoints.size() - 1) {
                if (a(latLng, c4, inPoints.get(i4 + 1)) > threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    public int b() {
        return this.f22767a;
    }

    public float d() {
        return this.f22768b;
    }

    public List<LatLng> g(List<LatLng> originlist) {
        return h(originlist, this.f22767a);
    }

    public LatLng i(LatLng lastLoc, LatLng curLoc) {
        return j(lastLoc, curLoc, this.f22767a);
    }

    public List<LatLng> k(List<LatLng> originlist) {
        return n(h(o(originlist), this.f22767a), this.f22768b);
    }

    public List<LatLng> m(List<LatLng> inPoints) {
        return n(inPoints, this.f22768b);
    }

    public List<LatLng> o(List<LatLng> originlist) {
        return l(originlist, this.f22769c);
    }

    public void p(int mIntensity) {
        this.f22767a = mIntensity;
    }

    public void q(float mnoiseThreshhold) {
        this.f22769c = mnoiseThreshhold;
    }

    public void r(float mThreshhold) {
        this.f22768b = mThreshhold;
    }
}
