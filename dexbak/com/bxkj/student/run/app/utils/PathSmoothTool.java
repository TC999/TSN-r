package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.o */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PathSmoothTool {

    /* renamed from: d */
    private double f19658d;

    /* renamed from: e */
    private double f19659e;

    /* renamed from: f */
    private double f19660f;

    /* renamed from: g */
    private double f19661g;

    /* renamed from: h */
    private double f19662h;

    /* renamed from: i */
    private double f19663i;

    /* renamed from: j */
    private double f19664j;

    /* renamed from: k */
    private double f19665k;

    /* renamed from: l */
    private double f19666l;

    /* renamed from: m */
    private double f19667m;

    /* renamed from: n */
    private double f19668n;

    /* renamed from: o */
    private double f19669o;

    /* renamed from: p */
    private double f19670p;

    /* renamed from: q */
    private double f19671q;

    /* renamed from: a */
    private int f19655a = 3;

    /* renamed from: b */
    private float f19656b = 0.3f;

    /* renamed from: c */
    private float f19657c = 10.0f;

    /* renamed from: r */
    private double f19672r = Utils.DOUBLE_EPSILON;

    /* renamed from: s */
    private double f19673s = Utils.DOUBLE_EPSILON;

    /* renamed from: a */
    private static double m39590a(LatLngTimeSpeed p, LatLngTimeSpeed lineBegin, LatLngTimeSpeed lineEnd) {
        double longitude;
        double latitude;
        double longitude2 = p.getLongitude() - lineBegin.getLongitude();
        double latitude2 = p.getLatitude() - lineBegin.getLatitude();
        double longitude3 = lineEnd.getLongitude() - lineBegin.getLongitude();
        double latitude3 = lineEnd.getLatitude() - lineBegin.getLatitude();
        double d = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        if (d < Utils.DOUBLE_EPSILON || (lineBegin.getLongitude() == lineEnd.getLongitude() && lineBegin.getLatitude() == lineEnd.getLatitude())) {
            longitude = lineBegin.getLongitude();
            latitude = lineBegin.getLatitude();
        } else if (d > 1.0d) {
            longitude = lineEnd.getLongitude();
            latitude = lineEnd.getLatitude();
        } else {
            latitude = lineBegin.getLatitude() + (d * latitude3);
            longitude = lineBegin.getLongitude() + (longitude3 * d);
        }
        return AMapUtils.calculateLineDistance(new LatLng(p.getLatitude(), p.getLongitude()), new LatLng(latitude, longitude));
    }

    /* renamed from: c */
    private static LatLngTimeSpeed m39588c(List<LatLngTimeSpeed> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    /* renamed from: e */
    private void m39586e() {
        this.f19664j = 0.001d;
        this.f19665k = 0.001d;
        this.f19666l = 5.698402909980532E-4d;
        this.f19667m = 5.698402909980532E-4d;
    }

    /* renamed from: f */
    private LatLngTimeSpeed m39585f(double oldValue_x, double value_x, double oldValue_y, double value_y, float lastLocationSpeed, float currentLocationSpeed, long lastLocationTime, long currentLocationTime, boolean isPause, int locationType) {
        this.f19658d = oldValue_x;
        this.f19659e = value_x;
        double d = this.f19664j;
        double d2 = this.f19666l;
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + this.f19673s;
        this.f19668n = sqrt;
        double d3 = this.f19664j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d3 * d3))) + this.f19672r;
        this.f19670p = sqrt2;
        double d4 = this.f19659e;
        double d5 = this.f19658d;
        this.f19662h = ((d4 - d5) * sqrt2) + d5;
        double d6 = this.f19668n;
        this.f19666l = Math.sqrt((1.0d - sqrt2) * d6 * d6);
        this.f19660f = oldValue_y;
        this.f19661g = value_y;
        double d7 = this.f19665k;
        double d8 = this.f19667m;
        double sqrt3 = Math.sqrt((d7 * d7) + (d8 * d8)) + this.f19673s;
        this.f19669o = sqrt3;
        double d9 = this.f19665k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d9 * d9))) + this.f19672r;
        this.f19671q = sqrt4;
        double d10 = this.f19661g;
        double d11 = this.f19660f;
        this.f19663i = ((d10 - d11) * sqrt4) + d11;
        double d12 = 1.0d - sqrt4;
        double d13 = this.f19669o;
        this.f19667m = Math.sqrt(d12 * d13 * d13);
        return new LatLngTimeSpeed(this.f19663i, this.f19662h, currentLocationTime, currentLocationSpeed, isPause, locationType);
    }

    /* renamed from: h */
    private List<LatLngTimeSpeed> m39583h(List<LatLngTimeSpeed> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            m39586e();
            LatLngTimeSpeed latLngTimeSpeed = originlist.get(0);
            arrayList.add(latLngTimeSpeed);
            for (int i = 1; i < originlist.size(); i++) {
                LatLngTimeSpeed m39581j = m39581j(latLngTimeSpeed, originlist.get(i), intensity);
                if (m39581j != null) {
                    arrayList.add(m39581j);
                    latLngTimeSpeed = m39581j;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private LatLngTimeSpeed m39581j(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc, int intensity) {
        if (this.f19664j == Utils.DOUBLE_EPSILON || this.f19665k == Utils.DOUBLE_EPSILON) {
            m39586e();
        }
        LatLngTimeSpeed latLngTimeSpeed = null;
        if (lastLoc != null && curLoc != null) {
            LatLngTimeSpeed latLngTimeSpeed2 = curLoc;
            int i = 0;
            for (int i2 = intensity < 1 ? 1 : intensity > 5 ? 5 : intensity; i < i2; i2 = i2) {
                latLngTimeSpeed = m39585f(lastLoc.getLongitude(), latLngTimeSpeed2.getLongitude(), lastLoc.getLatitude(), latLngTimeSpeed2.getLatitude(), lastLoc.getSpeed(), latLngTimeSpeed2.getSpeed(), lastLoc.getTime(), latLngTimeSpeed2.getTime(), latLngTimeSpeed2.isPuase(), latLngTimeSpeed2.getLocationType());
                i++;
                latLngTimeSpeed2 = latLngTimeSpeed;
            }
        }
        return latLngTimeSpeed;
    }

    /* renamed from: l */
    private List<LatLngTimeSpeed> m39579l(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLngTimeSpeed m39588c = m39588c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i);
            if (m39588c != null && i != inPoints.size() - 1) {
                if (m39590a(latLngTimeSpeed, m39588c, inPoints.get(i + 1)) < threshHold) {
                    arrayList.add(latLngTimeSpeed);
                }
            } else {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private List<LatLngTimeSpeed> m39577n(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < inPoints.size(); i++) {
            LatLngTimeSpeed m39588c = m39588c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i);
            if (m39588c != null && i != inPoints.size() - 1) {
                if (m39590a(latLngTimeSpeed, m39588c, inPoints.get(i + 1)) > threshHold) {
                    arrayList.add(latLngTimeSpeed);
                }
            } else {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public int m39589b() {
        return this.f19655a;
    }

    /* renamed from: d */
    public float m39587d() {
        return this.f19656b;
    }

    /* renamed from: g */
    public List<LatLngTimeSpeed> m39584g(List<LatLngTimeSpeed> originlist) {
        return m39583h(originlist, this.f19655a);
    }

    /* renamed from: i */
    public LatLngTimeSpeed m39582i(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc) {
        return m39581j(lastLoc, curLoc, this.f19655a);
    }

    /* renamed from: k */
    public List<LatLngTimeSpeed> m39580k(List<LatLngTimeSpeed> originlist) {
        return m39577n(m39583h(m39576o(originlist), this.f19655a), this.f19656b);
    }

    /* renamed from: m */
    public List<LatLngTimeSpeed> m39578m(List<LatLngTimeSpeed> inPoints) {
        return m39577n(inPoints, this.f19656b);
    }

    /* renamed from: o */
    public List<LatLngTimeSpeed> m39576o(List<LatLngTimeSpeed> originlist) {
        return m39579l(originlist, this.f19657c);
    }

    /* renamed from: p */
    public void m39575p(int mIntensity) {
        this.f19655a = mIntensity;
    }

    /* renamed from: q */
    public void m39574q(float mnoiseThreshhold) {
        this.f19657c = mnoiseThreshhold;
    }

    /* renamed from: r */
    public void m39573r(float mThreshhold) {
        this.f19656b = mThreshhold;
    }
}
