package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AMapPathSmoothTool {

    /* renamed from: d */
    private double f19540d;

    /* renamed from: e */
    private double f19541e;

    /* renamed from: f */
    private double f19542f;

    /* renamed from: g */
    private double f19543g;

    /* renamed from: h */
    private double f19544h;

    /* renamed from: i */
    private double f19545i;

    /* renamed from: j */
    private double f19546j;

    /* renamed from: k */
    private double f19547k;

    /* renamed from: l */
    private double f19548l;

    /* renamed from: m */
    private double f19549m;

    /* renamed from: n */
    private double f19550n;

    /* renamed from: o */
    private double f19551o;

    /* renamed from: p */
    private double f19552p;

    /* renamed from: q */
    private double f19553q;

    /* renamed from: a */
    private int f19537a = 3;

    /* renamed from: b */
    private float f19538b = 0.3f;

    /* renamed from: c */
    private float f19539c = 10.0f;

    /* renamed from: r */
    private double f19554r = Utils.DOUBLE_EPSILON;

    /* renamed from: s */
    private double f19555s = Utils.DOUBLE_EPSILON;

    /* renamed from: a */
    private static double m39694a(LatLng p, LatLng lineBegin, LatLng lineEnd) {
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
    private static LatLng m39692c(List<LatLng> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    /* renamed from: e */
    private void m39690e() {
        this.f19546j = 0.001d;
        this.f19547k = 0.001d;
        this.f19548l = 5.698402909980532E-4d;
        this.f19549m = 5.698402909980532E-4d;
    }

    /* renamed from: f */
    private LatLng m39689f(double oldValue_x, double value_x, double oldValue_y, double value_y) {
        this.f19540d = oldValue_x;
        this.f19541e = value_x;
        double d = this.f19546j;
        double d2 = this.f19548l;
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + this.f19555s;
        this.f19550n = sqrt;
        double d3 = this.f19546j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d3 * d3))) + this.f19554r;
        this.f19552p = sqrt2;
        double d4 = this.f19541e;
        double d5 = this.f19540d;
        this.f19544h = ((d4 - d5) * sqrt2) + d5;
        double d6 = this.f19550n;
        this.f19548l = Math.sqrt((1.0d - sqrt2) * d6 * d6);
        this.f19542f = oldValue_y;
        this.f19543g = value_y;
        double d7 = this.f19547k;
        double d8 = this.f19549m;
        double sqrt3 = Math.sqrt((d7 * d7) + (d8 * d8)) + this.f19555s;
        this.f19551o = sqrt3;
        double d9 = this.f19547k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d9 * d9))) + this.f19554r;
        this.f19553q = sqrt4;
        double d10 = this.f19543g;
        double d11 = this.f19542f;
        this.f19545i = ((d10 - d11) * sqrt4) + d11;
        double d12 = 1.0d - sqrt4;
        double d13 = this.f19551o;
        this.f19549m = Math.sqrt(d12 * d13 * d13);
        return new LatLng(this.f19545i, this.f19544h);
    }

    /* renamed from: h */
    private List<LatLng> m39687h(List<LatLng> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            m39690e();
            LatLng latLng = originlist.get(0);
            arrayList.add(latLng);
            for (int i = 1; i < originlist.size(); i++) {
                LatLng m39685j = m39685j(latLng, originlist.get(i), intensity);
                if (m39685j != null) {
                    arrayList.add(m39685j);
                    latLng = m39685j;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private LatLng m39685j(LatLng lastLoc, LatLng curLoc, int intensity) {
        if (this.f19546j == Utils.DOUBLE_EPSILON || this.f19547k == Utils.DOUBLE_EPSILON) {
            m39690e();
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
                latLng = m39689f(lastLoc.longitude, curLoc.longitude, lastLoc.latitude, curLoc.latitude);
                i++;
                curLoc = latLng;
            }
        }
        return latLng;
    }

    /* renamed from: l */
    private List<LatLng> m39683l(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLng m39692c = m39692c(arrayList);
            LatLng latLng = inPoints.get(i);
            if (m39692c != null && i != inPoints.size() - 1) {
                if (m39694a(latLng, m39692c, inPoints.get(i + 1)) < threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private List<LatLng> m39681n(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLng m39692c = m39692c(arrayList);
            LatLng latLng = inPoints.get(i);
            if (m39692c != null && i != inPoints.size() - 1) {
                if (m39694a(latLng, m39692c, inPoints.get(i + 1)) > threshHold) {
                    arrayList.add(latLng);
                }
            } else {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public int m39693b() {
        return this.f19537a;
    }

    /* renamed from: d */
    public float m39691d() {
        return this.f19538b;
    }

    /* renamed from: g */
    public List<LatLng> m39688g(List<LatLng> originlist) {
        return m39687h(originlist, this.f19537a);
    }

    /* renamed from: i */
    public LatLng m39686i(LatLng lastLoc, LatLng curLoc) {
        return m39685j(lastLoc, curLoc, this.f19537a);
    }

    /* renamed from: k */
    public List<LatLng> m39684k(List<LatLng> originlist) {
        return m39681n(m39687h(m39680o(originlist), this.f19537a), this.f19538b);
    }

    /* renamed from: m */
    public List<LatLng> m39682m(List<LatLng> inPoints) {
        return m39681n(inPoints, this.f19538b);
    }

    /* renamed from: o */
    public List<LatLng> m39680o(List<LatLng> originlist) {
        return m39683l(originlist, this.f19539c);
    }

    /* renamed from: p */
    public void m39679p(int mIntensity) {
        this.f19537a = mIntensity;
    }

    /* renamed from: q */
    public void m39678q(float mnoiseThreshhold) {
        this.f19539c = mnoiseThreshhold;
    }

    /* renamed from: r */
    public void m39677r(float mThreshhold) {
        this.f19538b = mThreshhold;
    }
}
