package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAPlotLinesElement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "", "()V", "color", "dashStyle", "", "label", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "value", "", "width", "zIndex", "", "Ljava/lang/Integer;", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAPlotLinesElement {
    private Object color;
    private String dashStyle;
    private AALabel label;
    private Number value;
    private Number width;
    private Integer zIndex;

    @NotNull
    public final AAPlotLinesElement color(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement dashStyle(@NotNull AAChartLineDashStyleType prop) {
        f0.p(prop, "prop");
        this.dashStyle = prop.getValue();
        return this;
    }

    @NotNull
    public final AAPlotLinesElement label(@NotNull AALabel prop) {
        f0.p(prop, "prop");
        this.label = prop;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement value(@Nullable Number number) {
        this.value = number;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement width(@Nullable Number number) {
        this.width = number;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement zIndex(@Nullable Integer num) {
        this.zIndex = num;
        return this;
    }
}
