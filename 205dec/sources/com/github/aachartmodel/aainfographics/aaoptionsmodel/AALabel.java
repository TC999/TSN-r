package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AALabel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0004\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u001a\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u000101J\u0015\u0010 \u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010!\u00a2\u0006\u0002\u00102J\u0010\u0010'\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0010\u0010*\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0010J\u0010\u0010-\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "", "()V", "align", "", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "format", "getFormat", "setFormat", "formatter", "getFormatter", "setFormatter", "rotation", "", "getRotation", "()Ljava/lang/Number;", "setRotation", "(Ljava/lang/Number;)V", "style", "getStyle", "()Ljava/lang/Object;", "setStyle", "(Ljava/lang/Object;)V", "text", "getText", "setText", "textAlign", "getTextAlign", "setTextAlign", "useHTML", "", "getUseHTML", "()Ljava/lang/Boolean;", "setUseHTML", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "verticalAlign", "getVerticalAlign", "setVerticalAlign", "x", "getX", "setX", "y", "getY", "setY", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AALabel {
    @Nullable
    private String align;
    @Nullable
    private String format;
    @Nullable
    private String formatter;
    @Nullable
    private Number rotation;
    @Nullable
    private Object style;
    @Nullable
    private String text;
    @Nullable
    private String textAlign;
    @Nullable
    private Boolean useHTML;
    @Nullable
    private String verticalAlign;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private Number f37119x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Number f37120y;

    @NotNull
    public final AALabel align(@Nullable String str) {
        this.align = str;
        return this;
    }

    @NotNull
    public final AALabel format(@Nullable String str) {
        this.format = str;
        return this;
    }

    @NotNull
    public final AALabel formatter(@Nullable String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
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
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final Object getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTextAlign() {
        return this.textAlign;
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
        return this.f37119x;
    }

    @Nullable
    public final Number getY() {
        return this.f37120y;
    }

    @NotNull
    public final AALabel rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setStyle(@Nullable Object obj) {
        this.style = obj;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setTextAlign(@Nullable String str) {
        this.textAlign = str;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f37119x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f37120y = number;
    }

    @NotNull
    public final AALabel style(@Nullable Object obj) {
        this.style = obj;
        return this;
    }

    @NotNull
    public final AALabel text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AALabel textAlign(@Nullable AAChartAlignType aAChartAlignType) {
        this.textAlign = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AALabel useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AALabel verticalAlign(@Nullable String str) {
        this.verticalAlign = str;
        return this;
    }

    @NotNull
    public final AALabel x(@Nullable Number number) {
        this.f37119x = number;
        return this;
    }

    @NotNull
    public final AALabel y(@Nullable Number number) {
        this.f37120y = number;
        return this;
    }
}
