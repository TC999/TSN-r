package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PathSmoothToolOrigin {

    /* renamed from: d */
    private double f19677d;

    /* renamed from: e */
    private double f19678e;

    /* renamed from: f */
    private double f19679f;

    /* renamed from: g */
    private double f19680g;

    /* renamed from: h */
    private double f19681h;

    /* renamed from: i */
    private double f19682i;

    /* renamed from: j */
    private double f19683j;

    /* renamed from: k */
    private double f19684k;

    /* renamed from: l */
    private double f19685l;

    /* renamed from: m */
    private double f19686m;

    /* renamed from: n */
    private double f19687n;

    /* renamed from: o */
    private double f19688o;

    /* renamed from: p */
    private double f19689p;

    /* renamed from: q */
    private double f19690q;

    /* renamed from: a */
    private int f19674a = 3;

    /* renamed from: b */
    private float f19675b = 0.3f;

    /* renamed from: c */
    private float f19676c = 10.0f;

    /* renamed from: r */
    private double f19691r = Utils.DOUBLE_EPSILON;

    /* renamed from: s */
    private double f19692s = Utils.DOUBLE_EPSILON;

    /* renamed from: a */
    private static double m39572a(LatLng p, LatLng lineBegin, LatLng lineEnd) {
        double d = p.longitude;
        double d2 = lineBegin.longitude;
        double d3 = p.latitude;
        double d4 = lineBegin.latitude;
        double d5 = lineEnd.longitude;
        double d6 = d5 - d2;
        double d7 = lineEnd.latitude;
        double d8 = d7 - d4;
        double d9 = (((d - d2) * d6) + ((d3 - d4) * d8)) / ((d6 * d6) + (d8 * d8));
        if (d9 >= Utils.DOUBLE_EPSILON && (d2 != d5 || d4 != d7)) {
            if (d9 > 1.0d) {
                d4 = d7;
                d2 = d5;
            } else {
                d2 += d6 * d9;
                d4 += d9 * d8;
            }
        }
        return AMapUtils.calculateLineDistance(p, new LatLng(d4, d2));
    }

    /* renamed from: c */
    private static LatLng m39570c(List<LatLng> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    /* renamed from: e */
    private void m39568e() {
        this.f19683j = 0.001d;
        this.f19684k = 0.001d;
        this.f19685l = 5.698402909980532E-4d;
        this.f19686m = 5.698402909980532E-4d;
    }

    /* renamed from: f */
    private LatLng m39567f(double oldValue_x, double value_x, double oldValue_y, double value_y) {
        this.f19677d = oldValue_x;
        this.f19678e = value_x;
        double d = this.f19683j;
        double d2 = this.f19685l;
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + this.f19692s;
        this.f19687n = sqrt;
        double d3 = this.f19683j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d3 * d3))) + this.f19691r;
        this.f19689p = sqrt2;
        double d4 = this.f19678e;
        double d5 = this.f19677d;
        this.f19681h = ((d4 - d5) * sqrt2) + d5;
        double d6 = this.f19687n;
        this.f19685l = Math.sqrt((1.0d - sqrt2) * d6 * d6);
        this.f19679f = oldValue_y;
        this.f19680g = value_y;
        double d7 = this.f19684k;
        double d8 = this.f19686m;
        double sqrt3 = Math.sqrt((d7 * d7) + (d8 * d8)) + this.f19692s;
        this.f19688o = sqrt3;
        double d9 = this.f19684k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d9 * d9))) + this.f19691r;
        this.f19690q = sqrt4;
        double d10 = this.f19680g;
        double d11 = this.f19679f;
        this.f19682i = ((d10 - d11) * sqrt4) + d11;
        double d12 = 1.0d - sqrt4;
        double d13 = this.f19688o;
        this.f19686m = Math.sqrt(d12 * d13 * d13);
        return new LatLng(this.f19682i, this.f19681h);
    }

    /* renamed from: h */
    private List<LatLng> m39565h(List<LatLng> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            m39568e();
            LatLng latLng = originlist.get(0);
            arrayList.add(latLng);
            for (int i = 1; i < originlist.size(); i++) {
                LatLng m39563j = m39563j(latLng, originlist.get(i), intensity);
                if (m39563j != null) {
                    arrayList.add(m39563j);
                    latLng = m39563j;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private LatLng m39563j(LatLng lastLoc, LatLng curLoc, int intensity) {
        if (this.f19683j == Utils.DOUBLE_EPSILON || this.f19684k == Utils.DOUBLE_EPSILON) {
            m39568e();
        }
        LatLng latLng = null;
        if (lastLoc != null && curLoc != null) {
            if (intensity < 1) {
                intensity = 1;
            } else if (intensity > 5) {
                intensity = 5;
            }
            int i = 0;
            while (i < intensity) {
                latLng = m39567f(lastLoc.longitude, curLoc.longitude, lastLoc.latitude, curLoc.latitude);
                i++;
                curLoc = latLng;
            }
        }
        return latLng;
    }

    /* renamed from: l */
    private List<LatLng> m39561l(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLng m39570c = m39570c(arrayList);
            LatLng latLng = inPoints.get(i);
            if (m39570c != null && i != inPoints.size() - 1) {
                if (m39572a(latLng, m39570c, inPoints.get(i + 1)) < threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private List<LatLng> m39559n(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLng m39570c = m39570c(arrayList);
            LatLng latLng = inPoints.get(i);
            if (m39570c != null && i != inPoints.size() - 1) {
                if (m39572a(latLng, m39570c, inPoints.get(i + 1)) > threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public int m39571b() {
        return this.f19674a;
    }

    /* renamed from: d */
    public float m39569d() {
        return this.f19675b;
    }

    /* renamed from: g */
    public List<LatLng> m39566g(List<LatLng> originlist) {
        return m39565h(originlist, this.f19674a);
    }

    /* renamed from: i */
    public LatLng m39564i(LatLng lastLoc, LatLng curLoc) {
        return m39563j(lastLoc, curLoc, this.f19674a);
    }

    /* renamed from: k */
    public List<LatLng> m39562k(List<LatLng> originlist) {
        return m39559n(m39565h(m39558o(originlist), this.f19674a), this.f19675b);
    }

    /* renamed from: m */
    public List<LatLng> m39560m(List<LatLng> inPoints) {
        return m39559n(inPoints, this.f19675b);
    }

    /* renamed from: o */
    public List<LatLng> m39558o(List<LatLng> originlist) {
        return m39561l(originlist, this.f19676c);
    }

    /* renamed from: p */
    public void m39557p(int mIntensity) {
        this.f19674a = mIntensity;
    }

    /* renamed from: q */
    public void m39556q(float mnoiseThreshhold) {
        this.f19676c = mnoiseThreshhold;
    }

    /* renamed from: r */
    public void m39555r(float mThreshhold) {
        this.f19675b = mThreshhold;
    }
}
