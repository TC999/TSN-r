package com.github.aachartmodel.aainfographics.aatools;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAColor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\t"}, d2 = {"AARgb", "", "red", "", "green", "blue", "alpha", "", "AARgba", "charts_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAColorKt {
    @NotNull
    public static final String AARgb(int i4, int i5, int i6, float f4) {
        return AARgba(i4, i5, i6, 1.0f);
    }

    public static /* synthetic */ String AARgb$default(int i4, int i5, int i6, float f4, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            f4 = 1.0f;
        }
        return AARgb(i4, i5, i6, f4);
    }

    @NotNull
    public static final String AARgba(int i4, int i5, int i6, float f4) {
        return "rgba(" + i4 + ',' + i5 + ',' + i6 + ',' + f4 + ')';
    }

    public static /* synthetic */ String AARgba$default(int i4, int i5, int i6, float f4, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            f4 = 1.0f;
        }
        return AARgba(i4, i5, i6, f4);
    }
}
