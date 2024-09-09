package com.bxkj.student.v2.common.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.v2.common.data.PointData;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DriftUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/h;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private static int f23358b;

    /* renamed from: k  reason: collision with root package name */
    private static double f23367k;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23357a = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static double f23359c = 5.0d;

    /* renamed from: d  reason: collision with root package name */
    private static double f23360d = 0.6d;

    /* renamed from: e  reason: collision with root package name */
    private static double f23361e = 0.8d;

    /* renamed from: f  reason: collision with root package name */
    private static double f23362f = 2.3d;

    /* renamed from: g  reason: collision with root package name */
    private static int f23363g = 80;

    /* renamed from: h  reason: collision with root package name */
    private static int f23364h = 150;

    /* renamed from: i  reason: collision with root package name */
    private static int f23365i = MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM;

    /* renamed from: j  reason: collision with root package name */
    private static int f23366j = 300;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: DriftUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b(\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ&\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\"\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010$\"\u0004\b\f\u0010&R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&\u00a8\u0006?"}, d2 = {"Lcom/bxkj/student/v2/common/utils/h$a;", "", "", "durationStep", "", "durationTime", "", "b", "step", "p", "g", "", "x", "a", "D", "Lcom/bxkj/student/v2/common/data/PointData;", "prePoint", "curPoint", "", "C", "durationDistance", "countTime", "c", "", "latLngList", "exceptionRatio", "d", "B", "stepCheckDistance", "I", CampaignEx.JSON_KEY_AD_Q, "()I", "A", "(I)V", "maxSpeed", "k", "()D", "v", "(D)V", "minStride", "o", "z", "avgStride", "f", "r", "maxStride", "m", "limitMinStep", "j", "u", "minStep", "n", "y", "maxStep", "l", "w", "limitMaxStep", "i", "t", "h", "s", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final double D(double[] dArr) {
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

        private final double b(int i4, long j4) {
            if (j4 == 0) {
                return 0.0d;
            }
            return new BigDecimal(i4).divide(new BigDecimal(j4), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(60)).setScale(0, RoundingMode.HALF_UP).doubleValue();
        }

        public static /* synthetic */ boolean e(a aVar, List list, double d4, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                d4 = 0.0d;
            }
            return aVar.d(list, d4);
        }

        private final double g(int i4) {
            double l4 = l();
            double f4 = f();
            Double.isNaN(l4);
            return l4 * f4;
        }

        private final double p(int i4) {
            double d4 = i4;
            double f4 = f();
            Double.isNaN(d4);
            return d4 * f4;
        }

        public final void A(int i4) {
            h.f23358b = i4;
        }

        public final double B(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            f0.p(prePoint, "prePoint");
            f0.p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getA(), prePoint.getO()), new LatLng(curPoint.getA(), curPoint.getO())));
            BigDecimal abs = new BigDecimal(curPoint.getT() - prePoint.getT()).divide(new BigDecimal(1000), 10, 4).abs();
            if (abs.doubleValue() == 0.0d) {
                return bigDecimal.doubleValue();
            }
            return bigDecimal.divide(abs, 10, 4).abs().doubleValue();
        }

        public final boolean C(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            f0.p(prePoint, "prePoint");
            f0.p(curPoint, "curPoint");
            return B(prePoint, curPoint) < k();
        }

        public final double c(int i4, long j4, double d4, long j5) {
            if (j5 <= 180) {
                double b4 = b(i4, j4);
                if (b4 < j()) {
                    return Math.min(p(i4), d4);
                }
                return b4 > ((double) l()) ? Math.min(g(i4), d4) : d4;
            }
            return d4;
        }

        public final boolean d(@NotNull List<PointData> latLngList, double d4) {
            List v5;
            int i4;
            f0.p(latLngList, "latLngList");
            v5 = kotlin.collections.f0.v5(latLngList, 30);
            com.orhanobut.logger.j.d("lastList.size=" + v5.size() + " exceptionRatio=" + d4, new Object[0]);
            if (v5.isEmpty()) {
                i4 = 0;
            } else {
                Iterator it = v5.iterator();
                i4 = 0;
                while (it.hasNext()) {
                    if ((((double) ((PointData) it.next()).getS()) > h.f23357a.k()) && (i4 = i4 + 1) < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                }
            }
            Integer valueOf = Integer.valueOf(i4);
            double size = v5.size();
            Double.isNaN(size);
            if (!(((double) valueOf.intValue()) > size * d4)) {
                valueOf = null;
            }
            if (valueOf == null) {
                return false;
            }
            valueOf.intValue();
            return true;
        }

        public final double f() {
            return h.f23361e;
        }

        public final double h() {
            return h.f23367k;
        }

        public final int i() {
            return h.f23366j;
        }

        public final int j() {
            return h.f23363g;
        }

        public final double k() {
            return h.f23359c;
        }

        public final int l() {
            return h.f23365i;
        }

        public final double m() {
            return h.f23362f;
        }

        public final int n() {
            return h.f23364h;
        }

        public final double o() {
            return h.f23360d;
        }

        public final int q() {
            return h.f23358b;
        }

        public final void r(double d4) {
            h.f23361e = d4;
        }

        public final void s(double d4) {
            h.f23367k = d4;
        }

        public final void t(int i4) {
            h.f23366j = i4;
        }

        public final void u(int i4) {
            h.f23363g = i4;
        }

        public final void v(double d4) {
            h.f23359c = d4;
        }

        public final void w(int i4) {
            h.f23365i = i4;
        }

        public final void x(double d4) {
            h.f23362f = d4;
        }

        public final void y(int i4) {
            h.f23364h = i4;
        }

        public final void z(double d4) {
            h.f23360d = d4;
        }
    }
}
