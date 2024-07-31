package com.amap.api.col.p047s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* renamed from: com.amap.api.col.s.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestConfig {

    /* renamed from: r */
    private static volatile RequestConfig f6368r;

    /* renamed from: a */
    boolean f6369a = true;

    /* renamed from: b */
    boolean f6370b = true;

    /* renamed from: c */
    boolean f6371c = true;

    /* renamed from: d */
    boolean f6372d = true;

    /* renamed from: e */
    boolean f6373e = true;

    /* renamed from: f */
    boolean f6374f = true;

    /* renamed from: g */
    boolean f6375g = true;

    /* renamed from: h */
    int f6376h = 25;

    /* renamed from: i */
    int f6377i = 100;

    /* renamed from: j */
    int f6378j = 100;

    /* renamed from: k */
    int f6379k = 100;

    /* renamed from: l */
    int f6380l = 6;

    /* renamed from: m */
    int f6381m = 100;

    /* renamed from: n */
    int f6382n = 5000;

    /* renamed from: o */
    int f6383o = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;

    /* renamed from: p */
    int f6384p = 100000000;

    /* renamed from: q */
    int f6385q = 16;

    /* renamed from: a */
    public static RequestConfig m52687a() {
        if (f6368r == null) {
            synchronized (RequestConfig.class) {
                if (f6368r == null) {
                    f6368r = new RequestConfig();
                }
            }
        }
        return f6368r;
    }

    /* renamed from: l */
    public static void m52676l(List<LatLonPoint> list) throws AMapException {
        if (list != null && 16 < list.size()) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
        }
    }

    /* renamed from: A */
    public final void m52690A(int i) {
        this.f6385q = i;
    }

    /* renamed from: B */
    public final int m52689B(int i) {
        int i2;
        return (this.f6372d && (i2 = this.f6381m) < i) ? i2 : i;
    }

    /* renamed from: C */
    public final int m52688C(int i) {
        int i2;
        return (this.f6372d && (i2 = this.f6376h) < i) ? i2 : i;
    }

    /* renamed from: b */
    public final void m52686b(int i) {
        this.f6376h = i;
    }

    /* renamed from: c */
    public final void m52685c(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f6373e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double m52832b = C2082j4.m52832b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(m52832b);
        if (this.f6383o < m52832b / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    /* renamed from: d */
    public final void m52684d(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double m52832b;
        if (!this.f6371c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double d = Utils.DOUBLE_EPSILON;
        if (list != null && list.size() != 0) {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            for (LatLonPoint latLonPoint : list) {
                double m52832b2 = C2082j4.m52832b(from, latLonPoint);
                Double.isNaN(m52832b2);
                d += m52832b2;
                from = latLonPoint;
            }
            double m52832b3 = C2082j4.m52832b(from, to);
            Double.isNaN(m52832b3);
            m52832b = d + m52832b3;
        } else {
            m52832b = C2082j4.m52832b(fromAndTo.getFrom(), fromAndTo.getTo());
        }
        if (this.f6382n < m52832b / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    /* renamed from: e */
    public final void m52683e(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f6373e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double m52832b = C2082j4.m52832b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(m52832b);
        if (this.f6383o < m52832b / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    /* renamed from: f */
    public final void m52682f(String str) throws AMapException {
        if (str != null && this.f6370b && str.length() > this.f6377i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }

    /* renamed from: g */
    public final void m52681g(List<LatLonPoint> list) throws AMapException {
        if (this.f6375g && list != null) {
            if (this.f6380l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }

    /* renamed from: h */
    public final void m52680h(boolean z) {
        this.f6369a = z;
    }

    /* renamed from: i */
    public final void m52679i(int i) {
        this.f6377i = i;
    }

    /* renamed from: j */
    public final void m52678j(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f6374f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double m52832b = C2082j4.m52832b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(m52832b);
        if (this.f6379k < m52832b / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    /* renamed from: k */
    public final void m52677k(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f6374f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double m52832b = C2082j4.m52832b(fromAndTo.getFrom(), fromAndTo.getTo());
        Double.isNaN(m52832b);
        if (this.f6379k < m52832b / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    /* renamed from: m */
    public final void m52675m(boolean z) {
        this.f6371c = z;
    }

    /* renamed from: n */
    public final void m52674n(int i) {
        this.f6378j = i;
    }

    /* renamed from: o */
    public final void m52673o(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f6369a && list != null) {
            if (this.f6378j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double m52823k = C2082j4.m52823k(list2);
                    if (this.f6385q >= list2.size()) {
                        if (this.f6384p < m52823k) {
                            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                        }
                    } else {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                    }
                }
                return;
            }
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
        }
    }

    /* renamed from: p */
    public final void m52672p(boolean z) {
        this.f6372d = z;
    }

    /* renamed from: q */
    public final void m52671q(int i) {
        this.f6379k = i;
    }

    /* renamed from: r */
    public final void m52670r(boolean z) {
        this.f6373e = z;
    }

    /* renamed from: s */
    public final void m52669s(int i) {
        this.f6380l = i;
    }

    /* renamed from: t */
    public final void m52668t(boolean z) {
        this.f6374f = z;
    }

    /* renamed from: u */
    public final void m52667u(int i) {
        this.f6381m = i;
    }

    /* renamed from: v */
    public final void m52666v(boolean z) {
        this.f6375g = z;
    }

    /* renamed from: w */
    public final void m52665w(int i) {
        this.f6382n = i;
    }

    /* renamed from: x */
    public final void m52664x(boolean z) {
        this.f6370b = z;
    }

    /* renamed from: y */
    public final void m52663y(int i) {
        this.f6383o = i;
    }

    /* renamed from: z */
    public final void m52662z(int i) {
        this.f6384p = i;
    }
}
