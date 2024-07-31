package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AALegend.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0018"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "cursor", "getCursor", "setCursor", "fontSize", "getFontSize", "setFontSize", "fontWeight", "getFontWeight", "setFontWeight", "pointer", "getPointer", "setPointer", "prop", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartFontWeightType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAItemStyle {
    @Nullable
    private String color;
    @Nullable
    private String cursor;
    @Nullable
    private String fontSize;
    @Nullable
    private String fontWeight;
    @Nullable
    private String pointer;

    @NotNull
    public final AAItemStyle color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AAItemStyle cursor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.cursor = prop;
        return this;
    }

    @NotNull
    public final AAItemStyle fontSize(@Nullable Number number) {
        if (number != null) {
            this.fontSize = number + "px";
        }
        return this;
    }

    @NotNull
    public final AAItemStyle fontWeight(@Nullable AAChartFontWeightType aAChartFontWeightType) {
        this.fontWeight = aAChartFontWeightType != null ? aAChartFontWeightType.getValue() : null;
        return this;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getCursor() {
        return this.cursor;
    }

    @Nullable
    public final String getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final String getPointer() {
        return this.pointer;
    }

    @NotNull
    public final AAItemStyle pointer(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointer = prop;
        return this;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setCursor(@Nullable String str) {
        this.cursor = str;
    }

    public final void setFontSize(@Nullable String str) {
        this.fontSize = str;
    }

    public final void setFontWeight(@Nullable String str) {
        this.fontWeight = str;
    }

    public final void setPointer(@Nullable String str) {
        this.pointer = str;
    }
}
