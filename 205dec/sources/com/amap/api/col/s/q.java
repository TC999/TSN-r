package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestConfig.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q {

    /* renamed from: r  reason: collision with root package name */
    private static volatile q f10096r;

    /* renamed from: a  reason: collision with root package name */
    boolean f10097a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f10098b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f10099c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f10100d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f10101e = true;

    /* renamed from: f  reason: collision with root package name */
    boolean f10102f = true;

    /* renamed from: g  reason: collision with root package name */
    boolean f10103g = true;

    /* renamed from: h  reason: collision with root package name */
    int f10104h = 25;

    /* renamed from: i  reason: collision with root package name */
    int f10105i = 100;

    /* renamed from: j  reason: collision with root package name */
    int f10106j = 100;

    /* renamed from: k  reason: collision with root package name */
    int f10107k = 100;

    /* renamed from: l  reason: collision with root package name */
    int f10108l = 6;

    /* renamed from: m  reason: collision with root package name */
    int f10109m = 100;

    /* renamed from: n  reason: collision with root package name */
    int f10110n = 5000;

    /* renamed from: o  reason: collision with root package name */
    int f10111o = 1200;

    /* renamed from: p  reason: collision with root package name */
    int f10112p = 100000000;

    /* renamed from: q  reason: collision with root package name */
    int f10113q = 16;

    public static q a() {
        if (f10096r == null) {
            synchronized (q.class) {
                if (f10096r == null) {
                    f10096r = new q();
                }
            }
        }
        return f10096r;
    }

    public static void l(List<LatLonPoint> list) throws AMapException {
        if (list != null && 16 < list.size()) {
            throw new AMapException("\u9014\u7ecf\u70b9\u4e2a\u6570\u8d85\u9650");
        }
    }

    public final void A(int i4) {
        this.f10113q = i4;
    }

    public final int B(int i4) {
        int i5;
        return (this.f10100d && (i5 = this.f10109m) < i4) ? i5 : i4;
    }

    public final int C(int i4) {
        int i5;
        return (this.f10100d && (i5 = this.f10104h) < i4) ? i5 : i4;
    }

    public final void b(int i4) {
        this.f10104h = i4;
    }

    public final void c(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f10101e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double b4 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(b4);
        if (this.f10111o < b4 / 1000.0d) {
            throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f");
        }
    }

    public final void d(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double b4;
        if (!this.f10099c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double d4 = 0.0d;
        if (list != null && list.size() != 0) {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            for (LatLonPoint latLonPoint : list) {
                double b5 = j4.b(from, latLonPoint);
                Double.isNaN(b5);
                d4 += b5;
                from = latLonPoint;
            }
            double b6 = j4.b(from, to);
            Double.isNaN(b6);
            b4 = d4 + b6;
        } else {
            b4 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        }
        if (this.f10110n < b4 / 1000.0d) {
            throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f");
        }
    }

    public final void e(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f10101e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double b4 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(b4);
        if (this.f10111o < b4 / 1000.0d) {
            throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f");
        }
    }

    public final void f(String str) throws AMapException {
        if (str != null && this.f10098b && str.length() > this.f10105i) {
            throw new AMapException("\u5173\u952e\u5b57\u8fc7\u957f");
        }
    }

    public final void g(List<LatLonPoint> list) throws AMapException {
        if (this.f10103g && list != null) {
            if (this.f10108l < list.size()) {
                throw new AMapException("\u9014\u7ecf\u70b9\u4e2a\u6570\u8d85\u9650");
            }
        }
    }

    public final void h(boolean z3) {
        this.f10097a = z3;
    }

    public final void i(int i4) {
        this.f10105i = i4;
    }

    public final void j(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f10102f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double b4 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(b4);
        if (this.f10107k < b4 / 1000.0d) {
            throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f");
        }
    }

    public final void k(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f10102f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double b4 = j4.b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(b4);
        if (this.f10107k < b4 / 1000.0d) {
            throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f");
        }
    }

    public final void m(boolean z3) {
        this.f10099c = z3;
    }

    public final void n(int i4) {
        this.f10106j = i4;
    }

    public final void o(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f10097a && list != null) {
            if (this.f10106j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double k4 = j4.k(list2);
                    if (this.f10113q >= list2.size()) {
                        if (this.f10112p < k4) {
                            throw new AMapException("\u907f\u8ba9\u533a\u57df\u5927\u5c0f\u8d85\u9650");
                        }
                    } else {
                        throw new AMapException("\u907f\u8ba9\u533a\u57df\u70b9\u4e2a\u6570\u8d85\u9650");
                    }
                }
                return;
            }
            throw new AMapException("\u907f\u8ba9\u533a\u57df\u4e2a\u6570\u8d85\u9650");
        }
    }

    public final void p(boolean z3) {
        this.f10100d = z3;
    }

    public final void q(int i4) {
        this.f10107k = i4;
    }

    public final void r(boolean z3) {
        this.f10101e = z3;
    }

    public final void s(int i4) {
        this.f10108l = i4;
    }

    public final void t(boolean z3) {
        this.f10102f = z3;
    }

    public final void u(int i4) {
        this.f10109m = i4;
    }

    public final void v(boolean z3) {
        this.f10103g = z3;
    }

    public final void w(int i4) {
        this.f10110n = i4;
    }

    public final void x(boolean z3) {
        this.f10098b = z3;
    }

    public final void y(int i4) {
        this.f10111o = i4;
    }

    public final void z(int i4) {
        this.f10112p = i4;
    }
}
