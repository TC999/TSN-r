package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLayoutType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AALegend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010\t\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u00106J\u0015\u0010\u0019\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u00106J\u0010\u0010\u001c\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u00104\u001a\u00020 J\u0010\u0010%\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0004J\u000e\u0010(\u001a\u00020\u00002\u0006\u00104\u001a\u000207J\u000e\u0010+\u001a\u00020\u00002\u0006\u00104\u001a\u000208J\u0010\u0010.\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\rJ\u0010\u00101\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u001c\u00101\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011\u00a8\u00069"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "", "()V", "align", "", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()Ljava/lang/Number;", "setBorderWidth", "(Ljava/lang/Number;)V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "floating", "getFloating", "setFloating", "itemMarginTop", "getItemMarginTop", "setItemMarginTop", "itemStyle", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "getItemStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "setItemStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;)V", "labelFormat", "getLabelFormat", "setLabelFormat", "layout", "getLayout", "setLayout", "verticalAlign", "getVerticalAlign", "setVerticalAlign", "x", "getX", "setX", "y", "getY", "setY", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLayoutType;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AALegend {
    @Nullable
    private String align;
    @Nullable
    private String borderColor;
    @Nullable
    private Number borderWidth;
    @Nullable
    private Boolean enabled;
    @Nullable
    private Boolean floating;
    @Nullable
    private Number itemMarginTop;
    @Nullable
    private AAItemStyle itemStyle;
    @Nullable
    private String labelFormat;
    @Nullable
    private String layout;
    @Nullable
    private String verticalAlign;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private Number f37123x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Number f37124y;

    @NotNull
    public final AALegend align(@NotNull AAChartAlignType prop) {
        f0.p(prop, "prop");
        this.align = prop.getValue();
        return this;
    }

    @NotNull
    public final AALegend borderColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AALegend borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AALegend enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AALegend floating(@Nullable Boolean bool) {
        this.floating = bool;
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Boolean getFloating() {
        return this.floating;
    }

    @Nullable
    public final Number getItemMarginTop() {
        return this.itemMarginTop;
    }

    @Nullable
    public final AAItemStyle getItemStyle() {
        return this.itemStyle;
    }

    @Nullable
    public final String getLabelFormat() {
        return this.labelFormat;
    }

    @Nullable
    public final String getLayout() {
        return this.layout;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f37123x;
    }

    @Nullable
    public final Number getY() {
        return this.f37124y;
    }

    @NotNull
    public final AALegend itemMarginTop(@Nullable Number number) {
        this.itemMarginTop = number;
        return this;
    }

    @NotNull
    public final AALegend itemStyle(@NotNull AAItemStyle prop) {
        f0.p(prop, "prop");
        this.itemStyle = prop;
        return this;
    }

    @NotNull
    public final AALegend labelFormat(@Nullable String str) {
        this.labelFormat = str;
        return this;
    }

    @NotNull
    public final AALegend layout(@NotNull AAChartLayoutType prop) {
        f0.p(prop, "prop");
        this.layout = prop.getValue();
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFloating(@Nullable Boolean bool) {
        this.floating = bool;
    }

    public final void setItemMarginTop(@Nullable Number number) {
        this.itemMarginTop = number;
    }

    public final void setItemStyle(@Nullable AAItemStyle aAItemStyle) {
        this.itemStyle = aAItemStyle;
    }

    public final void setLabelFormat(@Nullable String str) {
        this.labelFormat = str;
    }

    public final void setLayout(@Nullable String str) {
        this.layout = str;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f37123x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f37124y = number;
    }

    @NotNull
    public final AALegend verticalAlign(@NotNull AAChartVerticalAlignType prop) {
        f0.p(prop, "prop");
        this.verticalAlign = prop.getValue();
        return this;
    }

    @NotNull
    public final AALegend x(@Nullable Number number) {
        this.f37123x = number;
        return this;
    }

    @NotNull
    public final AALegend y(@Nullable Number number) {
        this.f37124y = number;
        return this;
    }
}
