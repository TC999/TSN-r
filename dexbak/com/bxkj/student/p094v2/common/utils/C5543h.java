package com.bxkj.student.p094v2.common.utils;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: DriftUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/h;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C5543h {

    /* renamed from: b */
    private static int f20114b;

    /* renamed from: k */
    private static double f20123k;
    @NotNull

    /* renamed from: a */
    public static final C5544a f20113a = new C5544a(null);

    /* renamed from: c */
    private static double f20115c = 5.0d;

    /* renamed from: d */
    private static double f20116d = 0.6d;

    /* renamed from: e */
    private static double f20117e = 0.8d;

    /* renamed from: f */
    private static double f20118f = 2.3d;

    /* renamed from: g */
    private static int f20119g = 80;

    /* renamed from: h */
    private static int f20120h = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;

    /* renamed from: i */
    private static int f20121i = 220;

    /* renamed from: j */
    private static int f20122j = 300;

    /* compiled from: DriftUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b(\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ&\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\"\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010$\"\u0004\b\f\u0010&R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&¨\u0006?"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/h$a;", "", "", "durationStep", "", "durationTime", "", "b", "step", "p", "g", "", "x", "a", "D", "Lcom/bxkj/student/v2/common/data/PointData;", "prePoint", "curPoint", "", "C", "durationDistance", "countTime", "c", "", "latLngList", "exceptionRatio", "d", "B", "stepCheckDistance", "I", CampaignEx.JSON_KEY_AD_Q, "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "maxSpeed", "k", "()D", "v", "(D)V", "minStride", "o", UMCommonContent.f37777aG, "avgStride", "f", "r", "maxStride", "m", "limitMinStep", "j", "u", "minStep", "n", "y", "maxStep", C7304t.f25048d, IAdInterListener.AdReqParam.WIDTH, "limitMaxStep", "i", UMCommonContent.f37782aL, "h", "s", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5544a {
        private C5544a() {
        }

        public /* synthetic */ C5544a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: D */
        private final double m39103D(double[] dArr) {
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

        /* renamed from: a */
        private final double m39102a(double[] dArr) {
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

        /* renamed from: b */
        private final double m39101b(int i, long j) {
            return j == 0 ? Utils.DOUBLE_EPSILON : new BigDecimal(i).divide(new BigDecimal(j), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(60)).setScale(0, RoundingMode.HALF_UP).doubleValue();
        }

        /* renamed from: e */
        public static /* synthetic */ boolean m39098e(C5544a c5544a, List list, double d, int i, Object obj) {
            if ((i & 2) != 0) {
                d = Utils.DOUBLE_EPSILON;
            }
            return c5544a.m39099d(list, d);
        }

        /* renamed from: g */
        private final double m39096g(int i) {
            double m39091l = m39091l();
            double m39097f = m39097f();
            Double.isNaN(m39091l);
            return m39091l * m39097f;
        }

        /* renamed from: p */
        private final double m39087p(int i) {
            double d = i;
            double m39097f = m39097f();
            Double.isNaN(d);
            return d * m39097f;
        }

        /* renamed from: A */
        public final void m39106A(int i) {
            C5543h.f20114b = i;
        }

        /* renamed from: B */
        public final double m39105B(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            C14342f0.m8184p(prePoint, "prePoint");
            C14342f0.m8184p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getA(), prePoint.getO()), new LatLng(curPoint.getA(), curPoint.getO())));
            BigDecimal abs = new BigDecimal(curPoint.getT() - prePoint.getT()).divide(new BigDecimal(1000), 10, 4).abs();
            if (abs.doubleValue() == Utils.DOUBLE_EPSILON) {
                return bigDecimal.doubleValue();
            }
            return bigDecimal.divide(abs, 10, 4).abs().doubleValue();
        }

        /* renamed from: C */
        public final boolean m39104C(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            C14342f0.m8184p(prePoint, "prePoint");
            C14342f0.m8184p(curPoint, "curPoint");
            return m39105B(prePoint, curPoint) < m39092k();
        }

        /* renamed from: c */
        public final double m39100c(int i, long j, double d, long j2) {
            if (j2 <= 180) {
                double m39101b = m39101b(i, j);
                if (m39101b < m39093j()) {
                    return Math.min(m39087p(i), d);
                }
                return m39101b > ((double) m39091l()) ? Math.min(m39096g(i), d) : d;
            }
            return d;
        }

        /* renamed from: d */
        public final boolean m39099d(@NotNull List<PointData> latLngList, double d) {
            List m12036x5;
            int i;
            C14342f0.m8184p(latLngList, "latLngList");
            m12036x5 = _Collections.m12036x5(latLngList, 30);
            C11792j.m20469d("lastList.size=" + m12036x5.size() + " exceptionRatio=" + d, new Object[0]);
            if (m12036x5.isEmpty()) {
                i = 0;
            } else {
                Iterator it = m12036x5.iterator();
                i = 0;
                while (it.hasNext()) {
                    if ((((double) ((PointData) it.next()).getS()) > C5543h.f20113a.m39092k()) && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.m12461V();
                    }
                }
            }
            Integer valueOf = Integer.valueOf(i);
            double size = m12036x5.size();
            Double.isNaN(size);
            if (!(((double) valueOf.intValue()) > size * d)) {
                valueOf = null;
            }
            if (valueOf == null) {
                return false;
            }
            valueOf.intValue();
            return true;
        }

        /* renamed from: f */
        public final double m39097f() {
            return C5543h.f20117e;
        }

        /* renamed from: h */
        public final double m39095h() {
            return C5543h.f20123k;
        }

        /* renamed from: i */
        public final int m39094i() {
            return C5543h.f20122j;
        }

        /* renamed from: j */
        public final int m39093j() {
            return C5543h.f20119g;
        }

        /* renamed from: k */
        public final double m39092k() {
            return C5543h.f20115c;
        }

        /* renamed from: l */
        public final int m39091l() {
            return C5543h.f20121i;
        }

        /* renamed from: m */
        public final double m39090m() {
            return C5543h.f20118f;
        }

        /* renamed from: n */
        public final int m39089n() {
            return C5543h.f20120h;
        }

        /* renamed from: o */
        public final double m39088o() {
            return C5543h.f20116d;
        }

        /* renamed from: q */
        public final int m39086q() {
            return C5543h.f20114b;
        }

        /* renamed from: r */
        public final void m39085r(double d) {
            C5543h.f20117e = d;
        }

        /* renamed from: s */
        public final void m39084s(double d) {
            C5543h.f20123k = d;
        }

        /* renamed from: t */
        public final void m39083t(int i) {
            C5543h.f20122j = i;
        }

        /* renamed from: u */
        public final void m39082u(int i) {
            C5543h.f20119g = i;
        }

        /* renamed from: v */
        public final void m39081v(double d) {
            C5543h.f20115c = d;
        }

        /* renamed from: w */
        public final void m39080w(int i) {
            C5543h.f20121i = i;
        }

        /* renamed from: x */
        public final void m39079x(double d) {
            C5543h.f20118f = d;
        }

        /* renamed from: y */
        public final void m39078y(int i) {
            C5543h.f20120h = i;
        }

        /* renamed from: z */
        public final void m39077z(double d) {
            C5543h.f20116d = d;
        }
    }
}
