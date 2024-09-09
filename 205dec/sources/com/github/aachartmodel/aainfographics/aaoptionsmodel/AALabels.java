package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AALabels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010EJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010*\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010+\u00a2\u0006\u0002\u0010FJ\u0015\u00101\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010+\u00a2\u0006\u0002\u0010FJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010C\u001a\u000205J\u0015\u0010:\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0002\u0010EJ\u0010\u0010=\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010@\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001c\u0010'\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u001e\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00101\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00100\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u001c\u0010=\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u0010\u0013R\u001c\u0010@\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010\u0013\u00a8\u0006G"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "", "()V", "align", "", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "autoRotation", "getAutoRotation", "()Ljava/lang/Object;", "setAutoRotation", "(Ljava/lang/Object;)V", "autoRotationLimit", "", "getAutoRotationLimit", "()Ljava/lang/Number;", "setAutoRotationLimit", "(Ljava/lang/Number;)V", "distance", "getDistance", "setDistance", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "format", "getFormat", "setFormat", "formatter", "getFormatter", "setFormatter", "padding", "getPadding", "setPadding", "rotation", "getRotation", "setRotation", "staggerLines", "", "getStaggerLines", "()Ljava/lang/Integer;", "setStaggerLines", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "step", "getStep", "setStep", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "useHTML", "getUseHTML", "setUseHTML", "x", "getX", "setX", "y", "getY", "setY", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AALabels {
    @Nullable
    private String align;
    @Nullable
    private Object autoRotation;
    @Nullable
    private Number autoRotationLimit;
    @Nullable
    private Number distance;
    @Nullable
    private Boolean enabled;
    @Nullable
    private String format;
    @Nullable
    private String formatter;
    @Nullable
    private Number padding;
    @Nullable
    private Number rotation;
    @Nullable
    private Integer staggerLines;
    @Nullable
    private Integer step;
    @Nullable
    private AAStyle style;
    @Nullable
    private Boolean useHTML;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private Number f37121x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Number f37122y;

    @NotNull
    public final AALabels align(@NotNull AAChartAlignType prop) {
        f0.p(prop, "prop");
        this.align = prop.getValue();
        return this;
    }

    @NotNull
    public final AALabels autoRotation(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.autoRotation = prop;
        return this;
    }

    @NotNull
    public final AALabels autoRotationLimit(@Nullable Number number) {
        this.autoRotationLimit = number;
        return this;
    }

    @NotNull
    public final AALabels distance(@Nullable Number number) {
        this.distance = number;
        return this;
    }

    @NotNull
    public final AALabels enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AALabels format(@NotNull String prop) {
        f0.p(prop, "prop");
        this.format = prop;
        return this;
    }

    @NotNull
    public final AALabels formatter(@NotNull String prop) {
        f0.p(prop, "prop");
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final Object getAutoRotation() {
        return this.autoRotation;
    }

    @Nullable
    public final Number getAutoRotationLimit() {
        return this.autoRotationLimit;
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
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final Number getPadding() {
        return this.padding;
    }

    @Nullable
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final Integer getStaggerLines() {
        return this.staggerLines;
    }

    @Nullable
    public final Integer getStep() {
        return this.step;
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
    public final Number getX() {
        return this.f37121x;
    }

    @Nullable
    public final Number getY() {
        return this.f37122y;
    }

    @NotNull
    public final AALabels padding(@Nullable Number number) {
        this.padding = number;
        return this;
    }

    @NotNull
    public final AALabels rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setAutoRotation(@Nullable Object obj) {
        this.autoRotation = obj;
    }

    public final void setAutoRotationLimit(@Nullable Number number) {
        this.autoRotationLimit = number;
    }

    public final void setDistance(@Nullable Number number) {
        this.distance = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setPadding(@Nullable Number number) {
        this.padding = number;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setStaggerLines(@Nullable Integer num) {
        this.staggerLines = num;
    }

    public final void setStep(@Nullable Integer num) {
        this.step = num;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setX(@Nullable Number number) {
        this.f37121x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f37122y = number;
    }

    @NotNull
    public final AALabels staggerLines(@Nullable Integer num) {
        this.staggerLines = num;
        return this;
    }

    @NotNull
    public final AALabels step(@Nullable Integer num) {
        this.step = num;
        return this;
    }

    @NotNull
    public final AALabels style(@NotNull AAStyle prop) {
        f0.p(prop, "prop");
        this.style = prop;
        return this;
    }

    @NotNull
    public final AALabels useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AALabels x(@Nullable Number number) {
        this.f37121x = number;
        return this;
    }

    @NotNull
    public final AALabels y(@Nullable Number number) {
        this.f37122y = number;
        return this;
    }
}
