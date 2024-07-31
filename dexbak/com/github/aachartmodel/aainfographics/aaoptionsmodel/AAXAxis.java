package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAXAxis.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\bJ\u001b\u0010\t\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0015\u0010 \u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010!\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\bJ\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010(\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u0015\u0010*\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010+\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020,0\n¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020/0\n¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u00102\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00103\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bJ\u0015\u00104\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u0019\u00107\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0015J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000bJ\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020<J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020>J\u0015\u0010?\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006@"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAxis;", "()V", "allowDecimals", "prop", "", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "alternateGridColor", "", "categories", "", "", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "crosshair", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "dateTimeLabelFormats", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "gridLineColor", "gridLineDashStyle", "gridLineInterpolation", "gridLineWidth", "", "labels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "lineColor", "lineWidth", "linkedTo", "", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "max", "min", "minRange", "minTickInterval", "minorGridLineColor", "minorGridLineDashStyle", "minorGridLineWidth", "minorTickColor", "minorTickInterval", "minorTickLength", "minorTickPosition", "minorTickWidth", Debug.f43401e, "opposite", "plotBands", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "plotLines", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "reversed", "startOnTick", "tickColor", "tickInterval", "tickLength", "tickPosition", "tickPositions", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "tickWidth", "tickmarkPlacement", "title", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "type", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartAxisType;", "visible", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAXAxis extends AAAxis {
    @NotNull
    public final AAXAxis allowDecimals(@Nullable Boolean bool) {
        setAllowDecimals(bool);
        return this;
    }

    @NotNull
    public final AAXAxis alternateGridColor(@NotNull Object prop) {
        C14342f0.m8184p(prop, "prop");
        setAlternateGridColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis categories(@Nullable String[] strArr) {
        setCategories(strArr);
        return this;
    }

    @NotNull
    public final AAXAxis crosshair(@NotNull AACrosshair prop) {
        C14342f0.m8184p(prop, "prop");
        setCrosshair(prop);
        return this;
    }

    @NotNull
    public final AAXAxis dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        C14342f0.m8184p(prop, "prop");
        setDateTimeLabelFormats(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineColor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setGridLineColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineDashStyle(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setGridLineDashStyle(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineInterpolation(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setGridLineInterpolation(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineWidth(@Nullable Number number) {
        setGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis labels(@NotNull AALabels prop) {
        C14342f0.m8184p(prop, "prop");
        setLabels(prop);
        return this;
    }

    @NotNull
    public final AAXAxis lineColor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setLineColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis lineWidth(@Nullable Number number) {
        setLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis linkedTo(@Nullable Integer num) {
        setLinkedTo(num);
        return this;
    }

    @NotNull
    public final AAXAxis max(@Nullable Number number) {
        setMax(number);
        return this;
    }

    @NotNull
    public final AAXAxis min(@Nullable Number number) {
        setMin(number);
        return this;
    }

    @NotNull
    public final AAXAxis minRange(@Nullable Integer num) {
        setMinRange(num);
        return this;
    }

    @NotNull
    public final AAXAxis minTickInterval(@Nullable Integer num) {
        setMinTickInterval(num);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineColor(@Nullable String str) {
        setMinorGridLineColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineDashStyle(@Nullable String str) {
        setMinorGridLineDashStyle(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineWidth(@Nullable Number number) {
        setMinorGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickColor(@Nullable String str) {
        setMinorTickColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickInterval(@Nullable Object obj) {
        setMinorTickInterval(obj);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickLength(@Nullable Number number) {
        setMinorTickLength(number);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickPosition(@Nullable String str) {
        setMinorTickPosition(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickWidth(@Nullable Number number) {
        setMinorTickWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis off(@Nullable Number number) {
        setOff(number);
        return this;
    }

    @NotNull
    public final AAXAxis opposite(@Nullable Boolean bool) {
        setOpposite(bool);
        return this;
    }

    @NotNull
    public final AAXAxis plotBands(@NotNull AAPlotBandsElement[] prop) {
        C14342f0.m8184p(prop, "prop");
        setPlotBands(prop);
        return this;
    }

    @NotNull
    public final AAXAxis plotLines(@NotNull AAPlotLinesElement[] prop) {
        C14342f0.m8184p(prop, "prop");
        setPlotLines(prop);
        return this;
    }

    @NotNull
    public final AAXAxis reversed(@Nullable Boolean bool) {
        setReversed(bool);
        return this;
    }

    @NotNull
    public final AAXAxis startOnTick(@Nullable Boolean bool) {
        setStartOnTick(bool);
        return this;
    }

    @NotNull
    public final AAXAxis tickColor(@Nullable String str) {
        setTickColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis tickInterval(@Nullable Integer num) {
        setTickInterval(num);
        return this;
    }

    @NotNull
    public final AAXAxis tickLength(@Nullable Number number) {
        setTickLength(number);
        return this;
    }

    @NotNull
    public final AAXAxis tickPosition(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setTickPosition(prop);
        return this;
    }

    @NotNull
    public final AAXAxis tickPositions(@NotNull Object[] prop) {
        C14342f0.m8184p(prop, "prop");
        setTickPositions(prop);
        return this;
    }

    @NotNull
    public final AAXAxis tickWidth(@Nullable Number number) {
        setTickWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis tickmarkPlacement(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        setTickmarkPlacement(prop);
        return this;
    }

    @NotNull
    public final AAXAxis title(@NotNull AATitle prop) {
        C14342f0.m8184p(prop, "prop");
        setTitle(prop);
        return this;
    }

    @NotNull
    public final AAXAxis type(@NotNull AAChartAxisType prop) {
        C14342f0.m8184p(prop, "prop");
        setType(prop.getValue());
        return this;
    }

    @NotNull
    public final AAXAxis visible(@Nullable Boolean bool) {
        setVisible(bool);
        return this;
    }
}
