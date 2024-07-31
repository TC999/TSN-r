package com.github.aachartmodel.aainfographics.aatools;

import io.netty.util.internal.StringUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: AAColor.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m12616d2 = {"AARgb", "", "red", "", "green", "blue", "alpha", "", "AARgba", "charts_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAColorKt {
    @NotNull
    public static final String AARgb(int i, int i2, int i3, float f) {
        return AARgba(i, i2, i3, 1.0f);
    }

    public static /* synthetic */ String AARgb$default(int i, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            f = 1.0f;
        }
        return AARgb(i, i2, i3, f);
    }

    @NotNull
    public static final String AARgba(int i, int i2, int i3, float f) {
        return "rgba(" + i + StringUtil.COMMA + i2 + StringUtil.COMMA + i3 + StringUtil.COMMA + f + ')';
    }

    public static /* synthetic */ String AARgba$default(int i, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            f = 1.0f;
        }
        return AARgba(i, i2, i3, f);
    }
}
