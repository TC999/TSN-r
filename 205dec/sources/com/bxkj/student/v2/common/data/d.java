package com.bxkj.student.v2.common.data;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.h;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.orhanobut.logger.j;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsDataAnalysis.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/data/d;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23165a = new a(null);

    /* compiled from: SportsDataAnalysis.kt */
    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J$\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u0002J\u0096\u0001\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u001a\u0010\f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u001a\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u001a\u0010\u000e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f\u00a8\u0006$"}, d2 = {"Lcom/bxkj/student/v2/common/data/d$a;", "", "", "", "", "dataList", "Lkotlin/f1;", "d", "", "maxStride", "Lkotlin/Function1;", "", "paceMinute", "paceKm", "distanceMinute", "", "exceptionStepDistanceCount", "b", "distance", "", "time", "a", "pace", "g", "h", "speed", "i", "e", "totalRange", "endQualifiedTime", "c", "Lc0/c;", "sportsDb", "f", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final double a(double d4, long j4) {
            if (d4 == 0.0d) {
                return 0.0d;
            }
            return new BigDecimal(j4).divide(new BigDecimal(60), 10, 4).divide(new BigDecimal(d4), 10, 4).multiply(new BigDecimal(1000)).setScale(2, 4).doubleValue();
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0385  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x03a1  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x03c0 A[LOOP:5: B:49:0x01dd->B:108:0x03c0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x03bc A[EDGE_INSN: B:134:0x03bc->B:107:0x03bc ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x02a1  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x02a5  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x02a7  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x02ab  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0329  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0357  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(double r35, @org.jetbrains.annotations.NotNull java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r37, @org.jetbrains.annotations.NotNull d2.l<? super java.util.List<java.lang.Double>, kotlin.f1> r38, @org.jetbrains.annotations.NotNull d2.l<? super java.util.List<java.lang.Double>, kotlin.f1> r39, @org.jetbrains.annotations.NotNull d2.l<? super java.util.List<java.lang.Double>, kotlin.f1> r40, @org.jetbrains.annotations.NotNull d2.l<? super java.lang.Integer, kotlin.f1> r41) {
            /*
                Method dump skipped, instructions count: 1168
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.data.d.a.b(double, java.util.List, d2.l, d2.l, d2.l, d2.l):void");
        }

        public final int c(double d4, int i4, double d5) {
            double d6 = 1000;
            Double.isNaN(d6);
            double d7 = d4 * d6;
            a aVar = i4 != -1 ? this : null;
            if (aVar == null) {
                return i4;
            }
            if (!(!(d7 == 0.0d))) {
                aVar = null;
            }
            if (aVar == null) {
                return i4;
            }
            if ((d5 > d7 ? aVar : null) == null) {
                return i4;
            }
            try {
                return (int) Math.ceil(new BigDecimal(i4).multiply(new BigDecimal(d5).divide(new BigDecimal(d7), 10, 4)).doubleValue());
            } catch (Exception e4) {
                e4.printStackTrace();
                return -1;
            }
        }

        public final void d(@NotNull List<? extends Map<String, ? extends Object>> dataList) {
            int Z;
            ArrayList arrayList;
            double d4;
            double d5;
            PointData pointData;
            BigDecimal bigDecimal;
            PointData pointData2;
            f0.p(dataList, "dataList");
            if (!dataList.isEmpty()) {
                Z = y.Z(dataList, 10);
                ArrayList arrayList2 = new ArrayList(Z);
                for (Iterator it = dataList.iterator(); it.hasNext(); it = it) {
                    Map map = (Map) it.next();
                    m mVar = m.a;
                    arrayList2.add(new PointData(mVar.f(map, "a"), mVar.f(map, "o"), (long) mVar.f(map, "t"), mVar.i(map, "s"), mVar.d(map, "i"), (int) mVar.f(map, "l"), (long) mVar.f(map, "c"), mVar.k(map, "e")));
                }
                PointData pointData3 = (PointData) arrayList2.get(0);
                h.f23357a.s(0.0d);
                int size = arrayList2.size();
                if (1 < size) {
                    double d6 = 0.0d;
                    d5 = 0.0d;
                    int i4 = 1;
                    PointData pointData4 = null;
                    int i5 = 0;
                    while (true) {
                        int i6 = i4 + 1;
                        PointData pointData5 = (PointData) arrayList2.get(i4);
                        arrayList = arrayList2;
                        BigDecimal valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData5.getA(), pointData5.getO()), new LatLng(pointData3.getA(), pointData3.getO())));
                        if (pointData5.getE() != 0) {
                            if (!pointData5.isI()) {
                                h.a aVar = h.f23357a;
                                if (pointData5.getS() > aVar.k()) {
                                    BigDecimal divide = new BigDecimal(d6).divide(new BigDecimal(pointData5.getC()), 10, 4);
                                    pointData = pointData3;
                                    BigDecimal divide2 = new BigDecimal(pointData5.getT() - pointData3.getT()).abs().divide(new BigDecimal(1000), 10, 4);
                                    j.m("\u6f02\u79fb\u70b9countDistance=" + d6 + " countTime=" + pointData5.getC() + " avg=" + divide + " time=" + divide2 + " appendDistance=" + valueOf, new Object[0]);
                                    valueOf = divide.multiply(divide2);
                                } else {
                                    pointData = pointData3;
                                }
                                if (!pointData.isI() && !pointData5.isI()) {
                                    if (pointData5.getT() - pointData.getT() > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                                        j.e("\u8fdb\u5165\u96a7\u9053\u7b97\u6cd5\uff0c\u8d85\u8fc710\u79d2\u672a\u83b7\u53d6\u5230\u5b9a\u4f4d\u70b9", new Object[0]);
                                        valueOf = BigDecimal.valueOf(0.0d);
                                        bigDecimal = BigDecimal.valueOf(0.0d);
                                        pointData2 = pointData;
                                        i5 = 0;
                                        double doubleValue = new BigDecimal(d6).add(valueOf).doubleValue();
                                        d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue, pointData5.getC());
                                    } else {
                                        if (pointData4 != null) {
                                            i5++;
                                            valueOf = BigDecimal.valueOf(0.0d);
                                            bigDecimal = BigDecimal.valueOf(0.0d);
                                            j.e("\u6254\u6389\u7b2c" + i5 + "\u4e2a\u70b9", new Object[0]);
                                            if (i5 == 10) {
                                                valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData5.getA(), pointData5.getO()), new LatLng(pointData4.getA(), pointData4.getO())));
                                                j.e("\u8fdb\u5165\u96a7\u9053\u7b97\u6cd5\uff0c\u6062\u590d10\u4e2a\u5b9a\u4f4d\u70b9\u540e\u8865\u507f\u8ddd\u79bb\u7b97\u6cd5\u8865\u507f\u540e\u7684appendDistance=" + valueOf + " gpsAppendDistance=" + valueOf, new Object[0]);
                                                bigDecimal = valueOf;
                                                pointData2 = null;
                                                double doubleValue2 = new BigDecimal(d6).add(valueOf).doubleValue();
                                                d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                                pointData4 = pointData2;
                                                d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue2, pointData5.getC());
                                            }
                                            pointData2 = pointData4;
                                            double doubleValue22 = new BigDecimal(d6).add(valueOf).doubleValue();
                                            d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                            pointData4 = pointData2;
                                            d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue22, pointData5.getC());
                                        }
                                        bigDecimal = valueOf;
                                        pointData2 = pointData4;
                                        double doubleValue222 = new BigDecimal(d6).add(valueOf).doubleValue();
                                        d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue222, pointData5.getC());
                                    }
                                } else {
                                    if (pointData4 != null) {
                                        j.e("\u4e2d\u9014\u51fa\u73b0\u4e86\u6682\u505c\u7684\u70b9\uff0c\u5c06\u4e22\u5931\u7684\u70b9\u4f4d\u7f6e\u7a7a\uff0c\u91cd\u65b0\u6309\u89c4\u5219\u8ba1\u7b97", new Object[0]);
                                        bigDecimal = valueOf;
                                        pointData2 = null;
                                        double doubleValue2222 = new BigDecimal(d6).add(valueOf).doubleValue();
                                        d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                        pointData4 = pointData2;
                                        d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue2222, pointData5.getC());
                                    }
                                    bigDecimal = valueOf;
                                    pointData2 = pointData4;
                                    double doubleValue22222 = new BigDecimal(d6).add(valueOf).doubleValue();
                                    d5 = new BigDecimal(d5).add(bigDecimal).doubleValue();
                                    pointData4 = pointData2;
                                    d6 = aVar.c((int) pointData5.getE(), pointData5.getC(), doubleValue22222, pointData5.getC());
                                }
                            }
                            pointData3 = pointData5;
                        }
                        if (i6 >= size) {
                            break;
                        }
                        i4 = i6;
                        arrayList2 = arrayList;
                    }
                    d4 = d6;
                } else {
                    arrayList = arrayList2;
                    d4 = 0.0d;
                    d5 = 0.0d;
                }
                j.e("\u6700\u7ec8countDistance=" + d4 + " \n\u65f6\u95f4" + ((Object) i.g(((PointData) arrayList.get(arrayList.size() - 1)).getC())) + "\nGPS\u539f\u59cb\u8ddd\u79bb" + d5, new Object[0]);
            }
        }

        @NotNull
        public final String e(double d4) {
            BigDecimal[] divideAndRemainder = new BigDecimal(d4).divideAndRemainder(BigDecimal.ONE);
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
        public final String f(@NotNull c0.c sportsDb) {
            f0.p(sportsDb, "sportsDb");
            m mVar = m.a;
            Map A = mVar.A(sportsDb.N());
            double parseDouble = Double.parseDouble(sportsDb.C());
            double f4 = mVar.f(A, "totalRange");
            double d4 = 1000;
            Double.isNaN(d4);
            if (parseDouble < f4 * d4) {
                return "\u8fd0\u52a8\u8ddd\u79bb\u4e0d\u7b26\u5408";
            }
            if (i.t(sportsDb.R()) < mVar.f(A, "step")) {
                return "\u8fd0\u52a8\u6b65\u6570\u4e0d\u7b26\u5408";
            }
            int k4 = mVar.k(A, "startQualifiedTime");
            double f5 = mVar.f(A, "totalRange");
            int k5 = mVar.k(A, "endQualifiedTime");
            double e4 = i.e(Double.parseDouble(sportsDb.C()));
            Double.isNaN(d4);
            int c4 = c(f5, k5, e4 * d4);
            if (Double.parseDouble(sportsDb.B()) >= k4 * 60 && (c4 == -1 || Double.parseDouble(sportsDb.B()) <= c4 * 60)) {
                return mVar.z(sportsDb.L()).size() < mVar.n(A, "list").size() ? "\u672a\u7ecf\u8fc7\u5fc5\u7ecf\u70b9" : "";
            }
            j.d("\u65f6\u95f4\u65e0\u6548", new Object[0]);
            return "\u8fd0\u52a8\u65f6\u95f4\u4e0d\u7b26\u5408";
        }

        public final double g(double d4) {
            if (d4 == 0.0d) {
                return -0.0d;
            }
            return new BigDecimal(1).divide(new BigDecimal(d4).divide(new BigDecimal(60), 10, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP).doubleValue();
        }

        public final double h(double d4) {
            if (d4 == 0.0d) {
                return 0.0d;
            }
            return new BigDecimal(1000).divide(new BigDecimal(d4).multiply(new BigDecimal(60)), 2, RoundingMode.HALF_UP).doubleValue();
        }

        public final double i(double d4) {
            if (d4 == 0.0d) {
                return 0.0d;
            }
            return new BigDecimal(1).divide(new BigDecimal(60), 10, RoundingMode.HALF_UP).divide(new BigDecimal(d4).divide(new BigDecimal(1000), 10, RoundingMode.HALF_UP), 10, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }
}
