package com.bxkj.student.p094v2.common.data;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.common.utils.C5543h;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import p027c0.SportsDb;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/c;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.data.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsDataAnalysis {
    @NotNull

    /* renamed from: a */
    public static final C5482a f19931a = new C5482a(null);

    /* compiled from: SportsDataAnalysis.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J$\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u0002J\u0096\u0001\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u001a\u0010\f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u001a\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u001a\u0010\u000e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¨\u0006$"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/c$a;", "", "", "", "", "dataList", "Lkotlin/f1;", "d", "", "maxStride", "Lkotlin/Function1;", "", "paceMinute", "paceKm", "distanceMinute", "", "exceptionStepDistanceCount", "b", "distance", "", RtspHeaders.Values.TIME, "a", "pace", "g", "h", "speed", "i", "e", "totalRange", "endQualifiedTime", "c", "Lc0/c;", "sportsDb", "f", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.data.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5482a {
        private C5482a() {
        }

        public /* synthetic */ C5482a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final double m39245a(double d, long j) {
            return (d > Utils.DOUBLE_EPSILON ? 1 : (d == Utils.DOUBLE_EPSILON ? 0 : -1)) == 0 ? Utils.DOUBLE_EPSILON : new BigDecimal(j).divide(new BigDecimal(60), 10, 4).divide(new BigDecimal(d), 10, 4).multiply(new BigDecimal(1000)).setScale(2, 4).doubleValue();
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x039d  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x03bc A[LOOP:5: B:49:0x01d9->B:108:0x03bc, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x03b8 A[EDGE_INSN: B:134:0x03b8->B:107:0x03b8 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x029b  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x029d  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x02a1  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x02a3  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x02a7  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0325  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0353  */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m39244b(double r35, @org.jetbrains.annotations.NotNull java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r37, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15280l<? super java.util.List<java.lang.Double>, kotlin.Unit> r38, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15280l<? super java.util.List<java.lang.Double>, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15280l<? super java.util.List<java.lang.Double>, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15280l<? super java.lang.Integer, kotlin.Unit> r41) {
            /*
                Method dump skipped, instructions count: 1158
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.common.data.SportsDataAnalysis.C5482a.m39244b(double, java.util.List, l1.l, l1.l, l1.l, l1.l):void");
        }

        /* renamed from: c */
        public final int m39243c(double d, int i, double d2) {
            double d3 = 1000;
            Double.isNaN(d3);
            double d4 = d * d3;
            C5482a c5482a = i != -1 ? this : null;
            if (c5482a == null) {
                return i;
            }
            if (!(!(d4 == Utils.DOUBLE_EPSILON))) {
                c5482a = null;
            }
            if (c5482a == null) {
                return i;
            }
            if ((d2 > d4 ? c5482a : null) == null) {
                return i;
            }
            try {
                return (int) Math.ceil(new BigDecimal(i).multiply(new BigDecimal(d2).divide(new BigDecimal(d4), 10, 4)).doubleValue());
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        /* renamed from: d */
        public final void m39242d(@NotNull List<? extends Map<String, ? extends Object>> dataList) {
            int m8957Y;
            ArrayList arrayList;
            double d;
            double d2;
            PointData pointData;
            BigDecimal bigDecimal;
            PointData pointData2;
            C14342f0.m8184p(dataList, "dataList");
            if (!dataList.isEmpty()) {
                m8957Y = C14236x.m8957Y(dataList, 10);
                ArrayList arrayList2 = new ArrayList(m8957Y);
                for (Iterator it = dataList.iterator(); it.hasNext(); it = it) {
                    Map<String, ? extends Object> map = (Map) it.next();
                    JsonGet jsonGet = JsonGet.f15134a;
                    arrayList2.add(new PointData(jsonGet.m43774f(map, "a"), jsonGet.m43774f(map, "o"), (long) jsonGet.m43774f(map, UMCommonContent.f37782aL), jsonGet.m43771i(map, "s"), jsonGet.m43776d(map, "i"), (int) jsonGet.m43774f(map, C7304t.f25048d), (long) jsonGet.m43774f(map, "c"), jsonGet.m43769k(map, "e")));
                }
                PointData pointData3 = (PointData) arrayList2.get(0);
                C5543h.f20113a.m39084s(Utils.DOUBLE_EPSILON);
                int size = arrayList2.size();
                if (1 < size) {
                    double d3 = 0.0d;
                    d2 = 0.0d;
                    int i = 1;
                    PointData pointData4 = null;
                    int i2 = 0;
                    while (true) {
                        int i3 = i + 1;
                        PointData pointData5 = (PointData) arrayList2.get(i);
                        arrayList = arrayList2;
                        BigDecimal valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData5.getA(), pointData5.getO()), new LatLng(pointData3.getA(), pointData3.getO())));
                        if (pointData5.getE() != 0) {
                            if (!pointData5.isI()) {
                                C5543h.C5544a c5544a = C5543h.f20113a;
                                if (pointData5.getS() > c5544a.m39092k()) {
                                    BigDecimal divide = new BigDecimal(d3).divide(new BigDecimal(pointData5.getC()), 10, 4);
                                    pointData = pointData3;
                                    BigDecimal divide2 = new BigDecimal(pointData5.getT() - pointData3.getT()).abs().divide(new BigDecimal(1000), 10, 4);
                                    C11792j.m20460m("漂移点countDistance=" + d3 + " countTime=" + pointData5.getC() + " avg=" + divide + " time=" + divide2 + " appendDistance=" + valueOf, new Object[0]);
                                    valueOf = divide.multiply(divide2);
                                } else {
                                    pointData = pointData3;
                                }
                                if (!pointData.isI() && !pointData5.isI()) {
                                    if (pointData5.getT() - pointData.getT() > 10000) {
                                        C11792j.m20468e("进入隧道算法，超过10秒未获取到定位点", new Object[0]);
                                        valueOf = BigDecimal.valueOf((double) Utils.DOUBLE_EPSILON);
                                        bigDecimal = BigDecimal.valueOf((double) Utils.DOUBLE_EPSILON);
                                        pointData2 = pointData;
                                        i2 = 0;
                                        double doubleValue = new BigDecimal(d3).add(valueOf).doubleValue();
                                        d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue, pointData5.getC());
                                    } else {
                                        if (pointData4 != null) {
                                            i2++;
                                            valueOf = BigDecimal.valueOf((double) Utils.DOUBLE_EPSILON);
                                            bigDecimal = BigDecimal.valueOf((double) Utils.DOUBLE_EPSILON);
                                            C11792j.m20468e("扔掉第" + i2 + "个点", new Object[0]);
                                            if (i2 == 10) {
                                                valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData5.getA(), pointData5.getO()), new LatLng(pointData4.getA(), pointData4.getO())));
                                                C11792j.m20468e("进入隧道算法，恢复10个定位点后补偿距离算法补偿后的appendDistance=" + valueOf + " gpsAppendDistance=" + valueOf, new Object[0]);
                                                bigDecimal = valueOf;
                                                pointData2 = null;
                                                double doubleValue2 = new BigDecimal(d3).add(valueOf).doubleValue();
                                                d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                                pointData4 = pointData2;
                                                d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue2, pointData5.getC());
                                            }
                                            pointData2 = pointData4;
                                            double doubleValue22 = new BigDecimal(d3).add(valueOf).doubleValue();
                                            d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                            pointData4 = pointData2;
                                            d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue22, pointData5.getC());
                                        }
                                        bigDecimal = valueOf;
                                        pointData2 = pointData4;
                                        double doubleValue222 = new BigDecimal(d3).add(valueOf).doubleValue();
                                        d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue222, pointData5.getC());
                                    }
                                } else {
                                    if (pointData4 != null) {
                                        C11792j.m20468e("中途出现了暂停的点，将丢失的点位置空，重新按规则计算", new Object[0]);
                                        bigDecimal = valueOf;
                                        pointData2 = null;
                                        double doubleValue2222 = new BigDecimal(d3).add(valueOf).doubleValue();
                                        d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue2222, pointData5.getC());
                                    }
                                    bigDecimal = valueOf;
                                    pointData2 = pointData4;
                                    double doubleValue22222 = new BigDecimal(d3).add(valueOf).doubleValue();
                                    d2 = new BigDecimal(d2).add(bigDecimal).doubleValue();
                                    pointData4 = pointData2;
                                    d3 = c5544a.m39100c((int) pointData5.getE(), pointData5.getC(), doubleValue22222, pointData5.getC());
                                }
                            }
                            pointData3 = pointData5;
                        }
                        if (i3 >= size) {
                            break;
                        }
                        i = i3;
                        arrayList2 = arrayList;
                    }
                    d = d3;
                } else {
                    arrayList = arrayList2;
                    d = Utils.DOUBLE_EPSILON;
                    d2 = Utils.DOUBLE_EPSILON;
                }
                C11792j.m20468e("最终countDistance=" + d + " \n时间" + ((Object) FormatUtils.m39630g(((PointData) arrayList.get(arrayList.size() - 1)).getC())) + "\nGPS原始距离" + d2, new Object[0]);
            }
        }

        @NotNull
        /* renamed from: e */
        public final String m39241e(double d) {
            BigDecimal[] divideAndRemainder = new BigDecimal(d).divideAndRemainder(BigDecimal.ONE);
            BigDecimal bigDecimal = divideAndRemainder[0];
            BigDecimal bigDecimal2 = divideAndRemainder[1];
            StringBuilder sb = new StringBuilder();
            sb.append(bigDecimal.intValue());
            sb.append('\'');
            sb.append((Object) new DecimalFormat("00").format(bigDecimal2.multiply(new BigDecimal(60)).setScale(0, 4)));
            sb.append('\"');
            return sb.toString();
        }

        @NotNull
        /* renamed from: f */
        public final String m39240f(@NotNull SportsDb sportsDb) {
            C14342f0.m8184p(sportsDb, "sportsDb");
            JsonGet jsonGet = JsonGet.f15134a;
            Map<String, Object> m43782A = jsonGet.m43782A(sportsDb.m58121L());
            double parseDouble = Double.parseDouble(sportsDb.m58132A());
            double m43774f = jsonGet.m43774f(m43782A, "totalRange");
            double d = 1000;
            Double.isNaN(d);
            if (parseDouble < m43774f * d) {
                return "运动距离不符合";
            }
            if (FormatUtils.m39617t(sportsDb.m58117P()) < jsonGet.m43774f(m43782A, "step")) {
                return "运动步数不符合";
            }
            int m43769k = jsonGet.m43769k(m43782A, "startQualifiedTime");
            double m43774f2 = jsonGet.m43774f(m43782A, "totalRange");
            int m43769k2 = jsonGet.m43769k(m43782A, "endQualifiedTime");
            double m39632e = FormatUtils.m39632e(Double.parseDouble(sportsDb.m58132A()));
            Double.isNaN(d);
            int m39243c = m39243c(m43774f2, m43769k2, m39632e * d);
            if (Double.parseDouble(sportsDb.m58062z()) >= m43769k * 60 && (m39243c == -1 || Double.parseDouble(sportsDb.m58062z()) <= m39243c * 60)) {
                return jsonGet.m43754z(sportsDb.m58123J()).size() < jsonGet.m43766n(m43782A, "list").size() ? "未经过必经点" : "";
            }
            C11792j.m20469d("时间无效", new Object[0]);
            return "运动时间不符合";
        }

        /* renamed from: g */
        public final double m39239g(double d) {
            if (d == Utils.DOUBLE_EPSILON) {
                return -0.0d;
            }
            return new BigDecimal(1).divide(new BigDecimal(d).divide(new BigDecimal(60), 10, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP).doubleValue();
        }

        /* renamed from: h */
        public final double m39238h(double d) {
            return (d > Utils.DOUBLE_EPSILON ? 1 : (d == Utils.DOUBLE_EPSILON ? 0 : -1)) == 0 ? Utils.DOUBLE_EPSILON : new BigDecimal(1000).divide(new BigDecimal(d).multiply(new BigDecimal(60)), 2, RoundingMode.HALF_UP).doubleValue();
        }

        /* renamed from: i */
        public final double m39237i(double d) {
            return (d > Utils.DOUBLE_EPSILON ? 1 : (d == Utils.DOUBLE_EPSILON ? 0 : -1)) == 0 ? Utils.DOUBLE_EPSILON : new BigDecimal(1).divide(new BigDecimal(60), 10, RoundingMode.HALF_UP).divide(new BigDecimal(d).divide(new BigDecimal(1000), 10, RoundingMode.HALF_UP), 10, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }
}
