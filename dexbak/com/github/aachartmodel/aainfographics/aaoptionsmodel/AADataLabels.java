package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: AADataLabels.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0004\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010[J\u0015\u0010\t\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\"\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u0010%\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017J\u0015\u0010(\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u0010+\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0010\u00100\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0010\u00103\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0015\u00106\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u00109\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0010\u0010<\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017J\u0010\u0010?\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0015\u0010B\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u0010E\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010FJ\u0010\u0010K\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\u0015\u0010N\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\\J\u0010\u0010Q\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010]J\u0010\u0010T\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017J\u0010\u0010W\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001c\u0010%\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001e\u0010(\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001c\u0010+\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001c\u0010<\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001c\u0010?\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u001e\u0010N\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001c\u0010T\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0019\"\u0004\bV\u0010\u001bR\u001c\u0010W\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0019\"\u0004\bY\u0010\u001b¨\u0006^"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "", "()V", "align", "", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "allowOverlap", "", "getAllowOverlap", "()Ljava/lang/Boolean;", "setAllowOverlap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "borderColor", "getBorderColor", "setBorderColor", "borderRadius", "", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "borderWidth", "getBorderWidth", "setBorderWidth", "color", "getColor", "setColor", "crop", "getCrop", "setCrop", "distance", "getDistance", "setDistance", "enabled", "getEnabled", "setEnabled", "filter", "getFilter", "()Ljava/lang/Object;", "setFilter", "(Ljava/lang/Object;)V", IjkMediaMeta.IJKM_KEY_FORMAT, "getFormat", "setFormat", "formatter", "getFormatter", "setFormatter", "inside", "getInside", "setInside", "overflow", "getOverflow", "setOverflow", "rotation", "getRotation", "setRotation", "shape", "getShape", "setShape", "softConnector", "getSoftConnector", "setSoftConnector", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "textPath", "getTextPath", "setTextPath", "useHTML", "getUseHTML", "setUseHTML", "verticalAlign", "getVerticalAlign", "setVerticalAlign", "x", "getX", "setX", "y", "getY", "setY", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AADataLabels {
    @Nullable
    private String align;
    @Nullable
    private Boolean allowOverlap;
    @Nullable
    private String backgroundColor;
    @Nullable
    private String borderColor;
    @Nullable
    private Number borderRadius;
    @Nullable
    private Number borderWidth;
    @Nullable
    private String color;
    @Nullable
    private Boolean crop;
    @Nullable
    private Number distance;
    @Nullable
    private Boolean enabled;
    @Nullable
    private Object filter;
    @Nullable
    private String format;
    @Nullable
    private String formatter;
    @Nullable
    private Boolean inside;
    @Nullable
    private String overflow;
    @Nullable
    private Number rotation;
    @Nullable
    private String shape;
    @Nullable
    private Boolean softConnector;
    @Nullable
    private AAStyle style;
    @Nullable
    private Object textPath;
    @Nullable
    private Boolean useHTML;
    @Nullable
    private String verticalAlign;
    @Nullable

    /* renamed from: x */
    private Number f23525x;
    @Nullable

    /* renamed from: y */
    private Number f23526y;

    @NotNull
    public final AADataLabels align(@Nullable AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AADataLabels allowOverlap(@Nullable Boolean bool) {
        this.allowOverlap = bool;
        return this;
    }

    @NotNull
    public final AADataLabels backgroundColor(@Nullable String str) {
        this.backgroundColor = str;
        return this;
    }

    @NotNull
    public final AADataLabels borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AADataLabels borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AADataLabels borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AADataLabels color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AADataLabels crop(@Nullable Boolean bool) {
        this.crop = bool;
        return this;
    }

    @NotNull
    public final AADataLabels distance(@Nullable Number number) {
        this.distance = number;
        return this;
    }

    @NotNull
    public final AADataLabels enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AADataLabels filter(@Nullable Object obj) {
        this.filter = obj;
        return this;
    }

    @NotNull
    public final AADataLabels format(@Nullable String str) {
        this.format = str;
        return this;
    }

    @NotNull
    public final AADataLabels formatter(@Nullable String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final Boolean getAllowOverlap() {
        return this.allowOverlap;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final Boolean getCrop() {
        return this.crop;
    }

    @Nullable
    public final Number getDistance() {
        return this.distance;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Object getFilter() {
        return this.filter;
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final Boolean getInside() {
        return this.inside;
    }

    @Nullable
    public final String getOverflow() {
        return this.overflow;
    }

    @Nullable
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @Nullable
    public final Boolean getSoftConnector() {
        return this.softConnector;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final Object getTextPath() {
        return this.textPath;
    }

    @Nullable
    public final Boolean getUseHTML() {
        return this.useHTML;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f23525x;
    }

    @Nullable
    public final Number getY() {
        return this.f23526y;
    }

    @NotNull
    public final AADataLabels inside(@Nullable Boolean bool) {
        this.inside = bool;
        return this;
    }

    @NotNull
    public final AADataLabels overflow(@Nullable String str) {
        this.overflow = str;
        return this;
    }

    @NotNull
    public final AADataLabels rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setAllowOverlap(@Nullable Boolean bool) {
        this.allowOverlap = bool;
    }

    public final void setBackgroundColor(@Nullable String str) {
        this.backgroundColor = str;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setCrop(@Nullable Boolean bool) {
        this.crop = bool;
    }

    public final void setDistance(@Nullable Number number) {
        this.distance = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFilter(@Nullable Object obj) {
        this.filter = obj;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setInside(@Nullable Boolean bool) {
        this.inside = bool;
    }

    public final void setOverflow(@Nullable String str) {
        this.overflow = str;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    public final void setSoftConnector(@Nullable Boolean bool) {
        this.softConnector = bool;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setTextPath(@Nullable Object obj) {
        this.textPath = obj;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f23525x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f23526y = number;
    }

    @NotNull
    public final AADataLabels shape(@Nullable String str) {
        this.shape = str;
        return this;
    }

    @NotNull
    public final AADataLabels softConnector(@Nullable Boolean bool) {
        this.softConnector = bool;
        return this;
    }

    @NotNull
    public final AADataLabels style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AADataLabels textPath(@Nullable Object obj) {
        this.textPath = obj;
        return this;
    }

    @NotNull
    public final AADataLabels useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AADataLabels verticalAlign(@Nullable AAChartVerticalAlignType aAChartVerticalAlignType) {
        this.verticalAlign = aAChartVerticalAlignType != null ? aAChartVerticalAlignType.getValue() : null;
        return this;
    }

    @NotNull
    /* renamed from: x */
    public final AADataLabels m35516x(@Nullable Number number) {
        this.f23525x = number;
        return this;
    }

    @NotNull
    /* renamed from: y */
    public final AADataLabels m35515y(@Nullable Number number) {
        this.f23526y = number;
        return this;
    }
}
