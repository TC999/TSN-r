package com.bxkj.base.v2.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DecimalFormatUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/base/v2/common/utils/e;", "", "", "d", "", "a", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f18604a = new e();

    private e() {
    }

    @NotNull
    public final String a(double d4) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d4);
        f0.o(format, "DecimalFormat(\"0.00\").ap\u2026ingMode.FLOOR }.format(d)");
        return format;
    }

    @NotNull
    public final String b(double d4) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d4);
        f0.o(format, "DecimalFormat(\"0.000\").a\u2026ingMode.FLOOR }.format(d)");
        return format;
    }
}
