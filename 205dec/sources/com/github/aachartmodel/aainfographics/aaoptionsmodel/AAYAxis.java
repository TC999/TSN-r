package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAYAxis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u001b\u0010\u000e\u001a\u00020\u00002\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0015\u0010$\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!J\u0015\u0010%\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!J\u0010\u0010&\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0010J\u0010\u0010'\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0010J\u0010\u0010(\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0010J\u0010\u0010*\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010+\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0010J\u0010\u0010-\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u0015\u0010/\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0019\u00100\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002010\u000f\u00a2\u0006\u0002\u00102J\u0019\u00103\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002040\u000f\u00a2\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0015\u00107\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u00108\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0010J\u0015\u00109\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!J\u0010\u0010:\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u0019\u0010<\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0010J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020CJ\u0015\u0010D\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006E"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAxis;", "()V", "stackLabels", "", "getStackLabels", "()Ljava/lang/Object;", "setStackLabels", "(Ljava/lang/Object;)V", "allowDecimals", "prop", "", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "alternateGridColor", "categories", "", "", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "crosshair", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "dateTimeLabelFormats", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "gridLineColor", "gridLineDashStyle", "gridLineInterpolation", "gridLineWidth", "", "labels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "lineColor", "lineWidth", "linkedTo", "", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "max", "min", "minRange", "minTickInterval", "minorGridLineColor", "minorGridLineDashStyle", "minorGridLineWidth", "minorTickColor", "minorTickInterval", "minorTickLength", "minorTickPosition", "minorTickWidth", "off", "opposite", "plotBands", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "plotLines", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "reversed", "startOnTick", "tickColor", "tickInterval", "tickLength", "tickPosition", "tickPositions", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "tickWidth", "tickmarkPlacement", "title", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "type", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartAxisType;", "visible", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAYAxis extends AAAxis {
    @Nullable
    private Object stackLabels;

    @NotNull
    public final AAYAxis allowDecimals(@Nullable Boolean bool) {
        setAllowDecimals(bool);
        return this;
    }

    @NotNull
    public final AAYAxis alternateGridColor(@NotNull Object prop) {
        f0.p(prop, "prop");
        setAlternateGridColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis categories(@Nullable String[] strArr) {
        setCategories(strArr);
        return this;
    }

    @NotNull
    public final AAYAxis crosshair(@NotNull AACrosshair prop) {
        f0.p(prop, "prop");
        setCrosshair(prop);
        return this;
    }

    @NotNull
    public final AAYAxis dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        f0.p(prop, "prop");
        setDateTimeLabelFormats(prop);
        return this;
    }

    @Nullable
    public final Object getStackLabels() {
        return this.stackLabels;
    }

    @NotNull
    public final AAYAxis gridLineColor(@NotNull String prop) {
        f0.p(prop, "prop");
        setGridLineColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineDashStyle(@NotNull String prop) {
        f0.p(prop, "prop");
        setGridLineDashStyle(prop);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineInterpolation(@NotNull String prop) {
        f0.p(prop, "prop");
        setGridLineInterpolation(prop);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineWidth(@Nullable Number number) {
        setGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis labels(@NotNull AALabels prop) {
        f0.p(prop, "prop");
        setLabels(prop);
        return this;
    }

    @NotNull
    public final AAYAxis lineColor(@NotNull String prop) {
        f0.p(prop, "prop");
        setLineColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis lineWidth(@Nullable Number number) {
        setLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis linkedTo(@Nullable Integer num) {
        setLinkedTo(num);
        return this;
    }

    @NotNull
    public final AAYAxis max(@Nullable Number number) {
        setMax(number);
        return this;
    }

    @NotNull
    public final AAYAxis min(@Nullable Number number) {
        setMin(number);
        return this;
    }

    @NotNull
    public final AAYAxis minRange(@Nullable Integer num) {
        setMinRange(num);
        return this;
    }

    @NotNull
    public final AAYAxis minTickInterval(@Nullable Integer num) {
        setMinTickInterval(num);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineColor(@Nullable String str) {
        setMinorGridLineColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineDashStyle(@Nullable String str) {
        setMinorGridLineDashStyle(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineWidth(@Nullable Number number) {
        setMinorGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickColor(@Nullable String str) {
        setMinorTickColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickInterval(@Nullable Object obj) {
        setMinorTickInterval(obj);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickLength(@Nullable Number number) {
        setMinorTickLength(number);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickPosition(@Nullable String str) {
        setMinorTickPosition(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickWidth(@Nullable Number number) {
        setMinorTickWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis off(@Nullable Number number) {
        setOff(number);
        return this;
    }

    @NotNull
    public final AAYAxis opposite(@Nullable Boolean bool) {
        setOpposite(bool);
        return this;
    }

    @NotNull
    public final AAYAxis plotBands(@NotNull AAPlotBandsElement[] prop) {
        f0.p(prop, "prop");
        setPlotBands(prop);
        return this;
    }

    @NotNull
    public final AAYAxis plotLines(@NotNull AAPlotLinesElement[] prop) {
        f0.p(prop, "prop");
        setPlotLines(prop);
        return this;
    }

    @NotNull
    public final AAYAxis reversed(@Nullable Boolean bool) {
        setReversed(bool);
        return this;
    }

    public final void setStackLabels(@Nullable Object obj) {
        this.stackLabels = obj;
    }

    @NotNull
    public final AAYAxis stackLabels(@Nullable Object obj) {
        this.stackLabels = obj;
        return this;
    }

    @NotNull
    public final AAYAxis startOnTick(@Nullable Boolean bool) {
        setStartOnTick(bool);
        return this;
    }

    @NotNull
    public final AAYAxis tickColor(@Nullable String str) {
        setTickColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis tickInterval(@Nullable Integer num) {
        setTickInterval(num);
        return this;
    }

    @NotNull
    public final AAYAxis tickLength(@Nullable Number number) {
        setTickLength(number);
        return this;
    }

    @NotNull
    public final AAYAxis tickPosition(@NotNull String prop) {
        f0.p(prop, "prop");
        setTickPosition(prop);
        return this;
    }

    @NotNull
    public final AAYAxis tickPositions(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        setTickPositions(prop);
        return this;
    }

    @NotNull
    public final AAYAxis tickWidth(@Nullable Number number) {
        setTickWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis tickmarkPlacement(@NotNull String prop) {
        f0.p(prop, "prop");
        setTickmarkPlacement(prop);
        return this;
    }

    @NotNull
    public final AAYAxis title(@NotNull AATitle prop) {
        f0.p(prop, "prop");
        setTitle(prop);
        return this;
    }

    @NotNull
    public final AAYAxis type(@NotNull AAChartAxisType prop) {
        f0.p(prop, "prop");
        setType(prop.getValue());
        return this;
    }

    @NotNull
    public final AAYAxis visible(@Nullable Boolean bool) {
        setVisible(bool);
        return this;
    }
}
