package com.bxkj.base.p085v2.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/e;", "", "", "d", "", "a", "b", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DecimalFormatUtils {
    @NotNull

    /* renamed from: a */
    public static final DecimalFormatUtils f15114a = new DecimalFormatUtils();

    private DecimalFormatUtils() {
    }

    @NotNull
    /* renamed from: a */
    public final String m43806a(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d);
        C14342f0.m8185o(format, "DecimalFormat(\"0.00\").ap…ingMode.FLOOR }.format(d)");
        return format;
    }

    @NotNull
    /* renamed from: b */
    public final String m43805b(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d);
        C14342f0.m8185o(format, "DecimalFormat(\"0.000\").a…ingMode.FLOOR }.format(d)");
        return format;
    }
}
