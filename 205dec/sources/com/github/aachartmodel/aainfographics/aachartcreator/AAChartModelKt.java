package com.github.aachartmodel.aainfographics.aachartcreator;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChartModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"aa_toAAOptions", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "charts_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAChartModelKt {
    @NotNull
    public static final AAOptions aa_toAAOptions(@NotNull AAChartModel aa_toAAOptions) {
        f0.p(aa_toAAOptions, "$this$aa_toAAOptions");
        return AAOptionsConstructor.INSTANCE.configureChartOptions(aa_toAAOptions);
    }
}
