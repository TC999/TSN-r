package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAPlotBandsElement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "", "()V", "borderColor", "", "borderWidth", "", "className", "color", "from", "index", "", "Ljava/lang/Integer;", "label", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "to", "prop", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAPlotBandsElement {
    private String borderColor;
    private Number borderWidth;
    private String className;
    private Object color;
    private Number from;
    private Integer index;
    private AALabel label;
    private Number to;

    @NotNull
    public final AAPlotBandsElement borderColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement className(@NotNull String prop) {
        f0.p(prop, "prop");
        this.className = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement color(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement from(@Nullable Number number) {
        this.from = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement index(@Nullable Integer num) {
        this.index = num;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement label(@NotNull AALabel prop) {
        f0.p(prop, "prop");
        this.label = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement to(@Nullable Number number) {
        this.to = number;
        return this;
    }
}
