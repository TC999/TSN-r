package com.bxkj.student.run.app.drift;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.orhanobut.logger.j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DriftUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/run/app/drift/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0277a f22329a = new C0277a(null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f22330b = 10;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DriftUtils.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u001c\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/student/run/app/drift/a$a;", "", "", "x", "", "a", "d", "Lcom/bxkj/student/run/app/location/LatLngTimeSpeed;", "prePoint", "curPoint", "", "c", "", "list", "e", "b", "", "maxSpeed", "I", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.drift.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class C0277a {
        private C0277a() {
        }

        public /* synthetic */ C0277a(u uVar) {
            this();
        }

        private final double a(double[] dArr) {
            int length = dArr.length;
            double d4 = 0.0d;
            if (length > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    d4 += dArr[i4];
                    if (i5 >= length) {
                        break;
                    }
                    i4 = i5;
                }
            }
            double d5 = length;
            Double.isNaN(d5);
            return d4 / d5;
        }

        private final double d(double[] dArr) {
            int length = dArr.length;
            int i4 = 0;
            double d4 = 0.0d;
            double d5 = 0.0d;
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    d5 += dArr[i5];
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            double d6 = length;
            Double.isNaN(d6);
            double d7 = d5 / d6;
            if (length > 0) {
                while (true) {
                    int i7 = i4 + 1;
                    d4 += (dArr[i4] - d7) * (dArr[i4] - d7);
                    if (i7 >= length) {
                        break;
                    }
                    i4 = i7;
                }
            }
            Double.isNaN(d6);
            return d4 / d6;
        }

        public final double b(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            f0.p(prePoint, "prePoint");
            f0.p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getLatitude(), prePoint.getLongitude()), new LatLng(curPoint.getLatitude(), curPoint.getLongitude())));
            BigDecimal abs = new BigDecimal(curPoint.getTime() - prePoint.getTime()).divide(new BigDecimal(1000), 10, 4).abs();
            if (abs.compareTo(new BigDecimal(0)) == 0) {
                return bigDecimal.doubleValue();
            }
            BigDecimal abs2 = bigDecimal.divide(abs, 10, 4).abs();
            if (abs2.compareTo(new BigDecimal(10)) == 1) {
                j.m("\u6f02\u79fb\u70b9\u8f68\u8ff9\u8fc7\u6ee4\u5668 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2, new Object[0]);
            } else if (bigDecimal.compareTo(new BigDecimal(10)) == 1) {
                j.d("\u6f02\u79fb\u70b9\u8f68\u8ff9\u8fc7\u6ee4\u5668 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2 + " prePoint=" + prePoint + " curPoint=" + curPoint, new Object[0]);
            }
            return abs2.doubleValue();
        }

        public final boolean c(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            f0.p(prePoint, "prePoint");
            f0.p(curPoint, "curPoint");
            return b(prePoint, curPoint) < 10.0d;
        }

        public final boolean e(@NotNull List<? extends LatLngTimeSpeed> list, @NotNull LatLngTimeSpeed curPoint) {
            f0.p(list, "list");
            f0.p(curPoint, "curPoint");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (1 < size) {
                int i4 = 1;
                while (true) {
                    int i5 = i4 + 1;
                    arrayList.add(Double.valueOf(b(list.get(i4 - 1), list.get(i4))));
                    if (i5 >= size) {
                        break;
                    }
                    i4 = i5;
                }
            }
            double d4 = d(v.E5(arrayList));
            double a4 = a(v.E5(arrayList));
            double b4 = b(list.get(list.size() - 1), curPoint);
            double pow = Math.pow(b4 - a4, 2.0d);
            if (b4 > a4) {
                double d5 = 10;
                Double.isNaN(d5);
                if (pow > d5 * d4) {
                    j.d("\u6f02\u79fb\u70b9->\u65b9\u5dee" + d4 + " \u5e73\u5747\u901f\u5ea6" + a4 + " \u5f53\u524d\u901f\u5ea6" + b4 + " pow" + pow, new Object[0]);
                    return false;
                }
                return true;
            }
            return true;
        }
    }
}
