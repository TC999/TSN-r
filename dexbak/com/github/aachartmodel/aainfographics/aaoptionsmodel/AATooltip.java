package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AATooltip.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0001J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0018J\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010YJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u00106\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u00109\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\tJ\u0015\u0010B\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010YJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010X\u001a\u00020FJ\u0015\u0010K\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010YJ\u0015\u0010N\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010O¢\u0006\u0002\u0010ZJ\u0010\u0010U\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR\u001c\u0010*\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010\rR\u001c\u0010-\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\rR\u001c\u00100\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001c\u00103\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000b\"\u0004\b5\u0010\rR\u001c\u00106\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\u001c\u00109\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000b\"\u0004\b;\u0010\rR\u001e\u0010<\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001c\u0010?\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR\u001e\u0010B\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bL\u0010 \"\u0004\bM\u0010\"R\u001e\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010U\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000b\"\u0004\bW\u0010\r¨\u0006["}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "", "()V", "backgroundColor", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "borderRadius", "", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "borderWidth", "getBorderWidth", "setBorderWidth", "dateTimeLabelFormats", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "getDateTimeLabelFormats", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;", "setDateTimeLabelFormats", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADateTimeLabelFormats;)V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "followTouchMove", "getFollowTouchMove", "setFollowTouchMove", "footerFormat", "getFooterFormat", "setFooterFormat", "formatter", "getFormatter", "setFormatter", "headerFormat", "getHeaderFormat", "setHeaderFormat", "padding", "getPadding", "setPadding", "pointFormat", "getPointFormat", "setPointFormat", "pointFormatter", "getPointFormatter", "setPointFormatter", "positioner", "getPositioner", "setPositioner", "shadow", "getShadow", "setShadow", "shape", "getShape", "setShape", "shared", "getShared", "setShared", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "useHTML", "getUseHTML", "setUseHTML", "valueDecimals", "", "getValueDecimals", "()Ljava/lang/Integer;", "setValueDecimals", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "valueSuffix", "getValueSuffix", "setValueSuffix", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AATooltip {
    @Nullable
    private Object backgroundColor;
    @Nullable
    private String borderColor;
    @Nullable
    private Number borderRadius;
    @Nullable
    private Number borderWidth;
    @Nullable
    private AADateTimeLabelFormats dateTimeLabelFormats;
    @Nullable
    private Boolean enabled;
    @Nullable
    private Boolean followTouchMove;
    @Nullable
    private String footerFormat;
    @Nullable
    private String formatter;
    @Nullable
    private String headerFormat;
    @Nullable
    private Number padding;
    @Nullable
    private String pointFormat;
    @Nullable
    private String pointFormatter;
    @Nullable
    private String positioner;
    @Nullable
    private Boolean shadow;
    @Nullable
    private String shape;
    @Nullable
    private Boolean shared;
    @Nullable
    private AAStyle style;
    @Nullable
    private Boolean useHTML;
    @Nullable
    private Integer valueDecimals;
    @Nullable
    private String valueSuffix;

    public AATooltip() {
        Boolean bool = Boolean.TRUE;
        this.shared = bool;
        this.enabled = bool;
        this.shadow = bool;
    }

    @NotNull
    public final AATooltip backgroundColor(@NotNull Object prop) {
        C14342f0.m8184p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AATooltip borderColor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AATooltip borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AATooltip borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AATooltip dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        C14342f0.m8184p(prop, "prop");
        this.dateTimeLabelFormats = prop;
        return this;
    }

    @NotNull
    public final AATooltip enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AATooltip followTouchMove(boolean z) {
        this.followTouchMove = Boolean.valueOf(z);
        return this;
    }

    @NotNull
    public final AATooltip footerFormat(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.footerFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip formatter(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @Nullable
    public final Object getBackgroundColor() {
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
    public final AADateTimeLabelFormats getDateTimeLabelFormats() {
        return this.dateTimeLabelFormats;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Boolean getFollowTouchMove() {
        return this.followTouchMove;
    }

    @Nullable
    public final String getFooterFormat() {
        return this.footerFormat;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final String getHeaderFormat() {
        return this.headerFormat;
    }

    @Nullable
    public final Number getPadding() {
        return this.padding;
    }

    @Nullable
    public final String getPointFormat() {
        return this.pointFormat;
    }

    @Nullable
    public final String getPointFormatter() {
        return this.pointFormatter;
    }

    @Nullable
    public final String getPositioner() {
        return this.positioner;
    }

    @Nullable
    public final Boolean getShadow() {
        return this.shadow;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @Nullable
    public final Boolean getShared() {
        return this.shared;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final Boolean getUseHTML() {
        return this.useHTML;
    }

    @Nullable
    public final Integer getValueDecimals() {
        return this.valueDecimals;
    }

    @Nullable
    public final String getValueSuffix() {
        return this.valueSuffix;
    }

    @NotNull
    public final AATooltip headerFormat(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.headerFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip padding(@NotNull Number prop) {
        C14342f0.m8184p(prop, "prop");
        this.padding = prop;
        return this;
    }

    @NotNull
    public final AATooltip pointFormat(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip pointFormatter(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointFormatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AATooltip positioner(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.positioner = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
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

    public final void setDateTimeLabelFormats(@Nullable AADateTimeLabelFormats aADateTimeLabelFormats) {
        this.dateTimeLabelFormats = aADateTimeLabelFormats;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFollowTouchMove(@Nullable Boolean bool) {
        this.followTouchMove = bool;
    }

    public final void setFooterFormat(@Nullable String str) {
        this.footerFormat = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setHeaderFormat(@Nullable String str) {
        this.headerFormat = str;
    }

    public final void setPadding(@Nullable Number number) {
        this.padding = number;
    }

    public final void setPointFormat(@Nullable String str) {
        this.pointFormat = str;
    }

    public final void setPointFormatter(@Nullable String str) {
        this.pointFormatter = str;
    }

    public final void setPositioner(@Nullable String str) {
        this.positioner = str;
    }

    public final void setShadow(@Nullable Boolean bool) {
        this.shadow = bool;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    public final void setShared(@Nullable Boolean bool) {
        this.shared = bool;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setValueDecimals(@Nullable Integer num) {
        this.valueDecimals = num;
    }

    public final void setValueSuffix(@Nullable String str) {
        this.valueSuffix = str;
    }

    @NotNull
    public final AATooltip shadow(boolean z) {
        this.shadow = Boolean.valueOf(z);
        return this;
    }

    @NotNull
    public final AATooltip shape(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.shape = prop;
        return this;
    }

    @NotNull
    public final AATooltip shared(@Nullable Boolean bool) {
        this.shared = bool;
        return this;
    }

    @NotNull
    public final AATooltip style(@NotNull AAStyle prop) {
        C14342f0.m8184p(prop, "prop");
        this.style = prop;
        return this;
    }

    @NotNull
    public final AATooltip useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AATooltip valueDecimals(@Nullable Integer num) {
        this.valueDecimals = num;
        return this;
    }

    @NotNull
    public final AATooltip valueSuffix(@Nullable String str) {
        this.valueSuffix = str;
        return this;
    }
}
