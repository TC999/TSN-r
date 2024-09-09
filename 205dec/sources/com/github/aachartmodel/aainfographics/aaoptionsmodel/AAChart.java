package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChart.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010VJ\u001b\u0010\u001e\u001a\u00020\u00002\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f\u00a2\u0006\u0002\u0010WJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u00002\u0006\u0010U\u001a\u000202J\u0015\u00107\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010VJ\u0010\u0010:\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010XJ\u000e\u0010=\u001a\u00020\u00002\u0006\u0010U\u001a\u000202J\u0015\u0010@\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010VJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010U\u001a\u00020DJ\u0010\u0010I\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010JJ\u0010\u0010O\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010YJ\u0010\u0010R\u001a\u00020\u00002\b\u0010R\u001a\u0004\u0018\u000102R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001c\u0010(\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001c\u0010+\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR\u001c\u0010:\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010=\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001e\u0010@\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\bA\u0010\u001a\"\u0004\bB\u0010\u001cR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R\u001c\u0010R\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106\u00a8\u0006Z"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "", "()V", "animation", "getAnimation", "()Ljava/lang/Object;", "setAnimation", "(Ljava/lang/Object;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "events", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "getEvents", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "setEvents", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;)V", "height", "", "getHeight", "()Ljava/lang/Number;", "setHeight", "(Ljava/lang/Number;)V", "inverted", "", "getInverted", "()Ljava/lang/Boolean;", "setInverted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "margin", "", "getMargin", "()[Ljava/lang/Number;", "setMargin", "([Ljava/lang/Number;)V", "[Ljava/lang/Number;", "marginBottom", "getMarginBottom", "setMarginBottom", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "panKey", "", "getPanKey", "()Ljava/lang/String;", "setPanKey", "(Ljava/lang/String;)V", "panning", "getPanning", "setPanning", "pinchType", "getPinchType", "setPinchType", "plotBackgroundImage", "getPlotBackgroundImage", "setPlotBackgroundImage", "polar", "getPolar", "setPolar", "resetZoomButton", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "getResetZoomButton", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "setResetZoomButton", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;)V", "scrollablePlotArea", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "getScrollablePlotArea", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "setScrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "type", "getType", "setType", "zoomType", "getZoomType", "setZoomType", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAChart {
    @Nullable
    private Object animation;
    @Nullable
    private Object backgroundColor;
    @Nullable
    private AAChartEvents events;
    @Nullable
    private Number height;
    @Nullable
    private Boolean inverted;
    @Nullable
    private Number[] margin;
    @Nullable
    private Number marginBottom;
    @Nullable
    private Number marginLeft;
    @Nullable
    private Number marginRight;
    @Nullable
    private Number marginTop;
    @Nullable
    private String panKey;
    @Nullable
    private Boolean panning;
    @Nullable
    private String pinchType;
    @Nullable
    private String plotBackgroundImage;
    @Nullable
    private Boolean polar;
    @Nullable
    private AAResetZoomButton resetZoomButton;
    @Nullable
    private AAScrollablePlotArea scrollablePlotArea;
    @Nullable
    private String type;
    @Nullable
    private String zoomType;

    @NotNull
    public final AAChart animation(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.animation = prop;
        return this;
    }

    @NotNull
    public final AAChart backgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @NotNull
    public final AAChart events(@Nullable AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
        return this;
    }

    @Nullable
    public final Object getAnimation() {
        return this.animation;
    }

    @Nullable
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final AAChartEvents getEvents() {
        return this.events;
    }

    @Nullable
    public final Number getHeight() {
        return this.height;
    }

    @Nullable
    public final Boolean getInverted() {
        return this.inverted;
    }

    @Nullable
    public final Number[] getMargin() {
        return this.margin;
    }

    @Nullable
    public final Number getMarginBottom() {
        return this.marginBottom;
    }

    @Nullable
    public final Number getMarginLeft() {
        return this.marginLeft;
    }

    @Nullable
    public final Number getMarginRight() {
        return this.marginRight;
    }

    @Nullable
    public final Number getMarginTop() {
        return this.marginTop;
    }

    @Nullable
    public final String getPanKey() {
        return this.panKey;
    }

    @Nullable
    public final Boolean getPanning() {
        return this.panning;
    }

    @Nullable
    public final String getPinchType() {
        return this.pinchType;
    }

    @Nullable
    public final String getPlotBackgroundImage() {
        return this.plotBackgroundImage;
    }

    @Nullable
    public final Boolean getPolar() {
        return this.polar;
    }

    @Nullable
    public final AAResetZoomButton getResetZoomButton() {
        return this.resetZoomButton;
    }

    @Nullable
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getZoomType() {
        return this.zoomType;
    }

    @NotNull
    public final AAChart height(@Nullable Number number) {
        this.height = number;
        return this;
    }

    @NotNull
    public final AAChart inverted(@Nullable Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @NotNull
    public final AAChart margin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @NotNull
    public final AAChart marginBottom(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.marginBottom = prop;
        return this;
    }

    @NotNull
    public final AAChart marginLeft(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.marginLeft = prop;
        return this;
    }

    @NotNull
    public final AAChart marginRight(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.marginRight = prop;
        return this;
    }

    @NotNull
    public final AAChart marginTop(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.marginTop = prop;
        return this;
    }

    @NotNull
    public final AAChart panKey(@NotNull String prop) {
        f0.p(prop, "prop");
        this.panKey = prop;
        return this;
    }

    @NotNull
    public final AAChart panning(@Nullable Boolean bool) {
        this.panning = bool;
        return this;
    }

    @NotNull
    public final AAChart pinchType(@Nullable AAChartZoomType aAChartZoomType) {
        this.pinchType = aAChartZoomType != null ? aAChartZoomType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAChart plotBackgroundImage(@NotNull String prop) {
        f0.p(prop, "prop");
        this.plotBackgroundImage = prop;
        return this;
    }

    @NotNull
    public final AAChart polar(@Nullable Boolean bool) {
        this.polar = bool;
        return this;
    }

    @NotNull
    public final AAChart resetZoomButton(@NotNull AAResetZoomButton prop) {
        f0.p(prop, "prop");
        this.resetZoomButton = prop;
        return this;
    }

    @NotNull
    public final AAChart scrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
        return this;
    }

    public final void setAnimation(@Nullable Object obj) {
        this.animation = obj;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setEvents(@Nullable AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
    }

    public final void setHeight(@Nullable Number number) {
        this.height = number;
    }

    public final void setInverted(@Nullable Boolean bool) {
        this.inverted = bool;
    }

    public final void setMargin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarginBottom(@Nullable Number number) {
        this.marginBottom = number;
    }

    public final void setMarginLeft(@Nullable Number number) {
        this.marginLeft = number;
    }

    public final void setMarginRight(@Nullable Number number) {
        this.marginRight = number;
    }

    public final void setMarginTop(@Nullable Number number) {
        this.marginTop = number;
    }

    public final void setPanKey(@Nullable String str) {
        this.panKey = str;
    }

    public final void setPanning(@Nullable Boolean bool) {
        this.panning = bool;
    }

    public final void setPinchType(@Nullable String str) {
        this.pinchType = str;
    }

    public final void setPlotBackgroundImage(@Nullable String str) {
        this.plotBackgroundImage = str;
    }

    public final void setPolar(@Nullable Boolean bool) {
        this.polar = bool;
    }

    public final void setResetZoomButton(@Nullable AAResetZoomButton aAResetZoomButton) {
        this.resetZoomButton = aAResetZoomButton;
    }

    public final void setScrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setZoomType(@Nullable String str) {
        this.zoomType = str;
    }

    @NotNull
    public final AAChart type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAChart zoomType(@Nullable String str) {
        this.zoomType = str;
        return this;
    }
}
