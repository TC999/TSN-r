package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAChart;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AACredits;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALang;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALegend;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPane;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPlotOptions;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AASubtitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAXAxis;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAYAxis;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAOptions.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u0004J\u001b\u0010\t\u001a\u00020\u00002\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\u0002\u0010cJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010b\u001a\u00020)J\u001b\u0010.\u001a\u00020\u00002\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\u0002\u0010cJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010b\u001a\u000202J\u000e\u00107\u001a\u00020\u00002\u0006\u0010b\u001a\u000208J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010b\u001a\u00020>J\u0015\u0010C\u001a\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010D¢\u0006\u0002\u0010dJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010b\u001a\u00020KJ\u0019\u0010P\u001a\u00020\u00002\f\u0010b\u001a\b\u0012\u0004\u0012\u00020K0\n¢\u0006\u0002\u0010eJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010b\u001a\u00020WJ\u0019\u0010\\\u001a\u00020\u00002\f\u0010b\u001a\b\u0012\u0004\u0012\u00020W0\n¢\u0006\u0002\u0010fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\\\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006g"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "", "()V", "chart", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "getChart", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "setChart", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;)V", "colors", "", "getColors", "()[Ljava/lang/Object;", "setColors", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "credits", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "getCredits", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "setCredits", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;)V", "defaultOptions", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "getDefaultOptions", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "setDefaultOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;)V", "legend", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "getLegend", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "setLegend", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;)V", "pane", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "getPane", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "setPane", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;)V", "plotOptions", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;", "getPlotOptions", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;", "setPlotOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;)V", "series", "getSeries", "setSeries", "subtitle", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "getSubtitle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "setSubtitle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;)V", "title", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "getTitle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "setTitle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;)V", "tooltip", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "getTooltip", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "setTooltip", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;)V", "touchEventEnabled", "", "getTouchEventEnabled", "()Ljava/lang/Boolean;", "setTouchEventEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "xAxis", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "getXAxis", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "setXAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)V", "xAxisArray", "getXAxisArray", "()[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "setXAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)V", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "yAxis", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "getYAxis", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "setYAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)V", "yAxisArray", "getYAxisArray", "()[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "setYAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)V", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "prop", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAOptions {
    @Nullable
    private AAChart chart;
    @Nullable
    private Object[] colors;
    @Nullable
    private AACredits credits;
    @Nullable
    private AALang defaultOptions;
    @Nullable
    private AALegend legend;
    @Nullable
    private AAPane pane;
    @Nullable
    private AAPlotOptions plotOptions;
    @Nullable
    private Object[] series;
    @Nullable
    private AASubtitle subtitle;
    @Nullable
    private AATitle title;
    @Nullable
    private AATooltip tooltip;
    @Nullable
    private Boolean touchEventEnabled;
    @Nullable
    private AAXAxis xAxis;
    @Nullable
    private AAXAxis[] xAxisArray;
    @Nullable
    private AAYAxis yAxis;
    @Nullable
    private AAYAxis[] yAxisArray;

    public AAOptions() {
        AACredits aACredits = new AACredits();
        aACredits.setEnabled(Boolean.FALSE);
        this.credits = aACredits;
    }

    @NotNull
    public final AAOptions chart(@NotNull AAChart prop) {
        C14342f0.m8184p(prop, "prop");
        this.chart = prop;
        return this;
    }

    @NotNull
    public final AAOptions colors(@Nullable Object[] objArr) {
        this.colors = objArr;
        return this;
    }

    @NotNull
    public final AAOptions credits(@NotNull AACredits prop) {
        C14342f0.m8184p(prop, "prop");
        this.credits = prop;
        return this;
    }

    @NotNull
    public final AAOptions defaultOptions(@NotNull AALang prop) {
        C14342f0.m8184p(prop, "prop");
        this.defaultOptions = prop;
        return this;
    }

    @Nullable
    public final AAChart getChart() {
        return this.chart;
    }

    @Nullable
    public final Object[] getColors() {
        return this.colors;
    }

    @Nullable
    public final AACredits getCredits() {
        return this.credits;
    }

    @Nullable
    public final AALang getDefaultOptions() {
        return this.defaultOptions;
    }

    @Nullable
    public final AALegend getLegend() {
        return this.legend;
    }

    @Nullable
    public final AAPane getPane() {
        return this.pane;
    }

    @Nullable
    public final AAPlotOptions getPlotOptions() {
        return this.plotOptions;
    }

    @Nullable
    public final Object[] getSeries() {
        return this.series;
    }

    @Nullable
    public final AASubtitle getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AATitle getTitle() {
        return this.title;
    }

    @Nullable
    public final AATooltip getTooltip() {
        return this.tooltip;
    }

    @Nullable
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @Nullable
    public final AAXAxis getXAxis() {
        return this.xAxis;
    }

    @Nullable
    public final AAXAxis[] getXAxisArray() {
        return this.xAxisArray;
    }

    @Nullable
    public final AAYAxis getYAxis() {
        return this.yAxis;
    }

    @Nullable
    public final AAYAxis[] getYAxisArray() {
        return this.yAxisArray;
    }

    @NotNull
    public final AAOptions legend(@NotNull AALegend prop) {
        C14342f0.m8184p(prop, "prop");
        this.legend = prop;
        return this;
    }

    @NotNull
    public final AAOptions pane(@Nullable AAPane aAPane) {
        this.pane = aAPane;
        return this;
    }

    @NotNull
    public final AAOptions plotOptions(@NotNull AAPlotOptions prop) {
        C14342f0.m8184p(prop, "prop");
        this.plotOptions = prop;
        return this;
    }

    @NotNull
    public final AAOptions series(@Nullable Object[] objArr) {
        this.series = objArr;
        return this;
    }

    public final void setChart(@Nullable AAChart aAChart) {
        this.chart = aAChart;
    }

    public final void setColors(@Nullable Object[] objArr) {
        this.colors = objArr;
    }

    public final void setCredits(@Nullable AACredits aACredits) {
        this.credits = aACredits;
    }

    public final void setDefaultOptions(@Nullable AALang aALang) {
        this.defaultOptions = aALang;
    }

    public final void setLegend(@Nullable AALegend aALegend) {
        this.legend = aALegend;
    }

    public final void setPane(@Nullable AAPane aAPane) {
        this.pane = aAPane;
    }

    public final void setPlotOptions(@Nullable AAPlotOptions aAPlotOptions) {
        this.plotOptions = aAPlotOptions;
    }

    public final void setSeries(@Nullable Object[] objArr) {
        this.series = objArr;
    }

    public final void setSubtitle(@Nullable AASubtitle aASubtitle) {
        this.subtitle = aASubtitle;
    }

    public final void setTitle(@Nullable AATitle aATitle) {
        this.title = aATitle;
    }

    public final void setTooltip(@Nullable AATooltip aATooltip) {
        this.tooltip = aATooltip;
    }

    public final void setTouchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxis(@Nullable AAXAxis aAXAxis) {
        this.xAxis = aAXAxis;
    }

    public final void setXAxisArray(@Nullable AAXAxis[] aAXAxisArr) {
        this.xAxisArray = aAXAxisArr;
    }

    public final void setYAxis(@Nullable AAYAxis aAYAxis) {
        this.yAxis = aAYAxis;
    }

    public final void setYAxisArray(@Nullable AAYAxis[] aAYAxisArr) {
        this.yAxisArray = aAYAxisArr;
    }

    @NotNull
    public final AAOptions subtitle(@NotNull AASubtitle prop) {
        C14342f0.m8184p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AAOptions title(@NotNull AATitle prop) {
        C14342f0.m8184p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AAOptions tooltip(@NotNull AATooltip prop) {
        C14342f0.m8184p(prop, "prop");
        this.tooltip = prop;
        return this;
    }

    @NotNull
    public final AAOptions touchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @NotNull
    public final AAOptions xAxis(@NotNull AAXAxis prop) {
        C14342f0.m8184p(prop, "prop");
        this.xAxis = prop;
        return this;
    }

    @NotNull
    public final AAOptions xAxisArray(@NotNull AAXAxis[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.xAxisArray = prop;
        return this;
    }

    @NotNull
    public final AAOptions yAxis(@NotNull AAYAxis prop) {
        C14342f0.m8184p(prop, "prop");
        this.yAxis = prop;
        return this;
    }

    @NotNull
    public final AAOptions yAxisArray(@NotNull AAYAxis[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.yAxisArray = prop;
        return this;
    }
}
