package com.bxkj.student.run.app.drift;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.github.mikephil.charting.utils.Utils;
import com.orhanobut.logger.C11792j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/run/app/drift/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.run.app.drift.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DriftUtils {
    @NotNull

    /* renamed from: a */
    public static final C5221a f19083a = new C5221a(null);

    /* renamed from: b */
    public static final int f19084b = 10;

    /* compiled from: DriftUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u001c\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/student/run/app/drift/a$a;", "", "", "x", "", "a", "d", "Lcom/bxkj/student/run/app/location/LatLngTimeSpeed;", "prePoint", "curPoint", "", "c", "", "list", "e", "b", "", "maxSpeed", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.drift.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5221a {
        private C5221a() {
        }

        public /* synthetic */ C5221a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        private final double m40075a(double[] dArr) {
            int length = dArr.length;
            double d = Utils.DOUBLE_EPSILON;
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    d += dArr[i];
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            double d2 = length;
            Double.isNaN(d2);
            return d / d2;
        }

        /* renamed from: d */
        private final double m40072d(double[] dArr) {
            int length = dArr.length;
            int i = 0;
            double d = Utils.DOUBLE_EPSILON;
            double d2 = 0.0d;
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    d2 += dArr[i2];
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            double d3 = length;
            Double.isNaN(d3);
            double d4 = d2 / d3;
            if (length > 0) {
                while (true) {
                    int i4 = i + 1;
                    d += (dArr[i] - d4) * (dArr[i] - d4);
                    if (i4 >= length) {
                        break;
                    }
                    i = i4;
                }
            }
            Double.isNaN(d3);
            return d / d3;
        }

        /* renamed from: b */
        public final double m40074b(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            C14342f0.m8184p(prePoint, "prePoint");
            C14342f0.m8184p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getLatitude(), prePoint.getLongitude()), new LatLng(curPoint.getLatitude(), curPoint.getLongitude())));
            BigDecimal abs = new BigDecimal(curPoint.getTime() - prePoint.getTime()).divide(new BigDecimal(1000), 10, 4).abs();
            if (abs.compareTo(new BigDecimal(0)) == 0) {
                return bigDecimal.doubleValue();
            }
            BigDecimal abs2 = bigDecimal.divide(abs, 10, 4).abs();
            if (abs2.compareTo(new BigDecimal(10)) == 1) {
                C11792j.m20460m("漂移点轨迹过滤器 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2, new Object[0]);
            } else if (bigDecimal.compareTo(new BigDecimal(10)) == 1) {
                C11792j.m20469d("漂移点轨迹过滤器 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2 + " prePoint=" + prePoint + " curPoint=" + curPoint, new Object[0]);
            }
            return abs2.doubleValue();
        }

        /* renamed from: c */
        public final boolean m40073c(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            C14342f0.m8184p(prePoint, "prePoint");
            C14342f0.m8184p(curPoint, "curPoint");
            return m40074b(prePoint, curPoint) < 10.0d;
        }

        /* renamed from: e */
        public final boolean m40071e(@NotNull List<? extends LatLngTimeSpeed> list, @NotNull LatLngTimeSpeed curPoint) {
            double[] m12253E5;
            double[] m12253E52;
            C14342f0.m8184p(list, "list");
            C14342f0.m8184p(curPoint, "curPoint");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (1 < size) {
                int i = 1;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(Double.valueOf(m40074b(list.get(i - 1), list.get(i))));
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            m12253E5 = _Collections.m12253E5(arrayList);
            double m40072d = m40072d(m12253E5);
            m12253E52 = _Collections.m12253E5(arrayList);
            double m40075a = m40075a(m12253E52);
            double m40074b = m40074b(list.get(list.size() - 1), curPoint);
            double pow = Math.pow(m40074b - m40075a, 2.0d);
            if (m40074b > m40075a) {
                double d = 10;
                Double.isNaN(d);
                if (pow > d * m40072d) {
                    C11792j.m20469d("漂移点->方差" + m40072d + " 平均速度" + m40075a + " 当前速度" + m40074b + " pow" + pow, new Object[0]);
                    return false;
                }
                return true;
            }
            return true;
        }
    }
}
