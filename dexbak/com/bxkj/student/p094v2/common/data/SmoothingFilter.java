package com.bxkj.student.p094v2.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/a;", "", "Lcom/bxkj/student/v2/common/data/PointData;", "lastPoint", "newPoint", "a", "", "b", "D", "alpha", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.data.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SmoothingFilter {
    @NotNull

    /* renamed from: a */
    public static final SmoothingFilter f19892a = new SmoothingFilter();

    /* renamed from: b */
    private static double f19893b = 0.2d;

    private SmoothingFilter() {
    }

    @NotNull
    /* renamed from: a */
    public final PointData m39363a(@NotNull PointData lastPoint, @NotNull PointData newPoint) {
        C14342f0.m8184p(lastPoint, "lastPoint");
        C14342f0.m8184p(newPoint, "newPoint");
        double a = f19893b * newPoint.getA();
        double d = 1;
        double d2 = f19893b;
        Double.isNaN(d);
        newPoint.setA(a + ((d - d2) * lastPoint.getA()));
        double o = f19893b * newPoint.getO();
        double d3 = f19893b;
        Double.isNaN(d);
        newPoint.setO(o + ((d - d3) * lastPoint.getO()));
        return newPoint;
    }
}
