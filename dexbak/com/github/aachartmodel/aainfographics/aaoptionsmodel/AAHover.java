package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAStates.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\t\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010*J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010+J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010!J\u0010\u0010&\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006,"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "", "()V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "brightness", "", "getBrightness", "()Ljava/lang/Float;", "setBrightness", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "color", "getColor", "setColor", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "halo", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "getHalo", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "setHalo", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;)V", "lineWidth", "", "getLineWidth", "()Ljava/lang/Number;", "setLineWidth", "(Ljava/lang/Number;)V", "lineWidthPlus", "getLineWidthPlus", "setLineWidthPlus", "prop", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAHover {
    @Nullable
    private String borderColor;
    @Nullable
    private Float brightness;
    @Nullable
    private String color;
    @Nullable
    private Boolean enabled;
    @Nullable
    private AAHalo halo;
    @Nullable
    private Number lineWidth;
    @Nullable
    private Number lineWidthPlus;

    @NotNull
    public final AAHover borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AAHover brightness(@Nullable Float f) {
        this.brightness = f;
        return this;
    }

    @NotNull
    public final AAHover color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AAHover enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Float getBrightness() {
        return this.brightness;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final AAHalo getHalo() {
        return this.halo;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getLineWidthPlus() {
        return this.lineWidthPlus;
    }

    @NotNull
    public final AAHover halo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
        return this;
    }

    @NotNull
    public final AAHover lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAHover lineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
        return this;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBrightness(@Nullable Float f) {
        this.brightness = f;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setHalo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
    }
}
