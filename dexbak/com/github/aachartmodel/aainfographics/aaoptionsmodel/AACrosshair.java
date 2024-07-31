package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AACrosshair.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "dashStyle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "getDashStyle", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "setDashStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;)V", "width", "", "getWidth", "()Ljava/lang/Number;", "setWidth", "(Ljava/lang/Number;)V", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AACrosshair {
    @Nullable
    private String color;
    @Nullable
    private AAChartLineDashStyleType dashStyle;
    @Nullable
    private Number width;

    @NotNull
    public final AACrosshair color(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AACrosshair dashStyle(@NotNull AAChartLineDashStyleType prop) {
        C14342f0.m8184p(prop, "prop");
        this.dashStyle = prop;
        return this;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final AAChartLineDashStyleType getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Number getWidth() {
        return this.width;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setDashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType;
    }

    public final void setWidth(@Nullable Number number) {
        this.width = number;
    }

    @NotNull
    public final AACrosshair width(@Nullable Number number) {
        this.width = number;
        return this;
    }
}
