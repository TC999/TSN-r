package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PathSmoothTool.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    private double f22888d;

    /* renamed from: e  reason: collision with root package name */
    private double f22889e;

    /* renamed from: f  reason: collision with root package name */
    private double f22890f;

    /* renamed from: g  reason: collision with root package name */
    private double f22891g;

    /* renamed from: h  reason: collision with root package name */
    private double f22892h;

    /* renamed from: i  reason: collision with root package name */
    private double f22893i;

    /* renamed from: j  reason: collision with root package name */
    private double f22894j;

    /* renamed from: k  reason: collision with root package name */
    private double f22895k;

    /* renamed from: l  reason: collision with root package name */
    private double f22896l;

    /* renamed from: m  reason: collision with root package name */
    private double f22897m;

    /* renamed from: n  reason: collision with root package name */
    private double f22898n;

    /* renamed from: o  reason: collision with root package name */
    private double f22899o;

    /* renamed from: p  reason: collision with root package name */
    private double f22900p;

    /* renamed from: q  reason: collision with root package name */
    private double f22901q;

    /* renamed from: a  reason: collision with root package name */
    private int f22885a = 3;

    /* renamed from: b  reason: collision with root package name */
    private float f22886b = 0.3f;

    /* renamed from: c  reason: collision with root package name */
    private float f22887c = 10.0f;

    /* renamed from: r  reason: collision with root package name */
    private double f22902r = 0.0d;

    /* renamed from: s  reason: collision with root package name */
    private double f22903s = 0.0d;

    private static double a(LatLngTimeSpeed p3, LatLngTimeSpeed lineBegin, LatLngTimeSpeed lineEnd) {
        double longitude;
        double latitude;
        double longitude2 = p3.getLongitude() - lineBegin.getLongitude();
        double latitude2 = p3.getLatitude() - lineBegin.getLatitude();
        double longitude3 = lineEnd.getLongitude() - lineBegin.getLongitude();
        double latitude3 = lineEnd.getLatitude() - lineBegin.getLatitude();
        double d4 = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        if (d4 < 0.0d || (lineBegin.getLongitude() == lineEnd.getLongitude() && lineBegin.getLatitude() == lineEnd.getLatitude())) {
            longitude = lineBegin.getLongitude();
            latitude = lineBegin.getLatitude();
        } else if (d4 > 1.0d) {
            longitude = lineEnd.getLongitude();
            latitude = lineEnd.getLatitude();
        } else {
            latitude = lineBegin.getLatitude() + (d4 * latitude3);
            longitude = lineBegin.getLongitude() + (longitude3 * d4);
        }
        return AMapUtils.calculateLineDistance(new LatLng(p3.getLatitude(), p3.getLongitude()), new LatLng(latitude, longitude));
    }

    private static LatLngTimeSpeed c(List<LatLngTimeSpeed> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    private void e() {
        this.f22894j = 0.001d;
        this.f22895k = 0.001d;
        this.f22896l = 5.698402909980532E-4d;
        this.f22897m = 5.698402909980532E-4d;
    }

    private LatLngTimeSpeed f(double oldValue_x, double value_x, double oldValue_y, double value_y, float lastLocationSpeed, float currentLocationSpeed, long lastLocationTime, long currentLocationTime, boolean isPause, int locationType) {
        this.f22888d = oldValue_x;
        this.f22889e = value_x;
        double d4 = this.f22894j;
        double d5 = this.f22896l;
        double sqrt = Math.sqrt((d4 * d4) + (d5 * d5)) + this.f22903s;
        this.f22898n = sqrt;
        double d6 = this.f22894j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d6 * d6))) + this.f22902r;
        this.f22900p = sqrt2;
        double d7 = this.f22889e;
        double d8 = this.f22888d;
        this.f22892h = ((d7 - d8) * sqrt2) + d8;
        double d9 = this.f22898n;
        this.f22896l = Math.sqrt((1.0d - sqrt2) * d9 * d9);
        this.f22890f = oldValue_y;
        this.f22891g = value_y;
        double d10 = this.f22895k;
        double d11 = this.f22897m;
        double sqrt3 = Math.sqrt((d10 * d10) + (d11 * d11)) + this.f22903s;
        this.f22899o = sqrt3;
        double d12 = this.f22895k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d12 * d12))) + this.f22902r;
        this.f22901q = sqrt4;
        double d13 = this.f22891g;
        double d14 = this.f22890f;
        this.f22893i = ((d13 - d14) * sqrt4) + d14;
        double d15 = 1.0d - sqrt4;
        double d16 = this.f22899o;
        this.f22897m = Math.sqrt(d15 * d16 * d16);
        return new LatLngTimeSpeed(this.f22893i, this.f22892h, currentLocationTime, currentLocationSpeed, isPause, locationType);
    }

    private List<LatLngTimeSpeed> h(List<LatLngTimeSpeed> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            e();
            LatLngTimeSpeed latLngTimeSpeed = originlist.get(0);
            arrayList.add(latLngTimeSpeed);
            for (int i4 = 1; i4 < originlist.size(); i4++) {
                LatLngTimeSpeed j4 = j(latLngTimeSpeed, originlist.get(i4), intensity);
                if (j4 != null) {
                    arrayList.add(j4);
                    latLngTimeSpeed = j4;
                }
            }
        }
        return arrayList;
    }

    private LatLngTimeSpeed j(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc, int intensity) {
        if (this.f22894j == 0.0d || this.f22895k == 0.0d) {
            e();
        }
        LatLngTimeSpeed latLngTimeSpeed = null;
        if (lastLoc != null && curLoc != null) {
            LatLngTimeSpeed latLngTimeSpeed2 = curLoc;
            int i4 = 0;
            for (int i5 = intensity < 1 ? 1 : intensity > 5 ? 5 : intensity; i4 < i5; i5 = i5) {
                latLngTimeSpeed = f(lastLoc.getLongitude(), latLngTimeSpeed2.getLongitude(), lastLoc.getLatitude(), latLngTimeSpeed2.getLatitude(), lastLoc.getSpeed(), latLngTimeSpeed2.getSpeed(), lastLoc.getTime(), latLngTimeSpeed2.getTime(), latLngTimeSpeed2.isPuase(), latLngTimeSpeed2.getLocationType());
                i4++;
                latLngTimeSpeed2 = latLngTimeSpeed;
            }
        }
        return latLngTimeSpeed;
    }

    private List<LatLngTimeSpeed> l(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < inPoints.size(); i4++) {
            LatLngTimeSpeed c4 = c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i4);
            if (c4 != null && i4 != inPoints.size() - 1) {
                if (a(latLngTimeSpeed, c4, inPoints.get(i4 + 1)) < threshHold) {
                    arrayList.add(latLngTimeSpeed);
                }
            } else {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    private List<LatLngTimeSpeed> n(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < inPoints.size(); i4++) {
            LatLngTimeSpeed c4 = c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i4);
            if (c4 != null && i4 != inPoints.size() - 1) {
                if (a(latLngTimeSpeed, c4, inPoints.get(i4 + 1)) > threshHold) {
                    arrayList.add(latLngTimeSpeed);
                }
            } else {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    public int b() {
        return this.f22885a;
    }

    public float d() {
        return this.f22886b;
    }

    public List<LatLngTimeSpeed> g(List<LatLngTimeSpeed> originlist) {
        return h(originlist, this.f22885a);
    }

    public LatLngTimeSpeed i(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc) {
        return j(lastLoc, curLoc, this.f22885a);
    }

    public List<LatLngTimeSpeed> k(List<LatLngTimeSpeed> originlist) {
        return n(h(o(originlist), this.f22885a), this.f22886b);
    }

    public List<LatLngTimeSpeed> m(List<LatLngTimeSpeed> inPoints) {
        return n(inPoints, this.f22886b);
    }

    public List<LatLngTimeSpeed> o(List<LatLngTimeSpeed> originlist) {
        return l(originlist, this.f22887c);
    }

    public void p(int mIntensity) {
        this.f22885a = mIntensity;
    }

    public void q(float mnoiseThreshhold) {
        this.f22887c = mnoiseThreshhold;
    }

    public void r(float mThreshhold) {
        this.f22886b = mThreshhold;
    }
}
