package com.github.aachartmodel.aainfographics.aachartcreator;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AAChartModel.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m12616d2 = {"aa_toAAOptions", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "charts_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAChartModelKt {
    @NotNull
    public static final AAOptions aa_toAAOptions(@NotNull AAChartModel aa_toAAOptions) {
        C14342f0.m8184p(aa_toAAOptions, "$this$aa_toAAOptions");
        return AAOptionsConstructor.INSTANCE.configureChartOptions(aa_toAAOptions);
    }
}
