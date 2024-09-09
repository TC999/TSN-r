package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAMarker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010#J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0014R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerHover;", "", "()V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fillColor", "", "getFillColor", "()Ljava/lang/String;", "setFillColor", "(Ljava/lang/String;)V", "lineColor", "getLineColor", "setLineColor", "lineWidth", "", "getLineWidth", "()Ljava/lang/Number;", "setLineWidth", "(Ljava/lang/Number;)V", "lineWidthPlus", "getLineWidthPlus", "setLineWidthPlus", "radius", "getRadius", "setRadius", "radiusPlus", "getRadiusPlus", "setRadiusPlus", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerHover;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAMarkerHover {
    @Nullable
    private Boolean enabled;
    @Nullable
    private String fillColor;
    @Nullable
    private String lineColor;
    @Nullable
    private Number lineWidth;
    @Nullable
    private Number lineWidthPlus;
    @Nullable
    private Number radius;
    @Nullable
    private Number radiusPlus;

    @NotNull
    public final AAMarkerHover enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AAMarkerHover fillColor(@Nullable String str) {
        this.fillColor = str;
        return this;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final String getFillColor() {
        return this.fillColor;
    }

    @Nullable
    public final String getLineColor() {
        return this.lineColor;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getLineWidthPlus() {
        return this.lineWidthPlus;
    }

    @Nullable
    public final Number getRadius() {
        return this.radius;
    }

    @Nullable
    public final Number getRadiusPlus() {
        return this.radiusPlus;
    }

    @NotNull
    public final AAMarkerHover lineColor(@Nullable String str) {
        this.lineColor = str;
        return this;
    }

    @NotNull
    public final AAMarkerHover lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover lineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover radius(@Nullable Number number) {
        this.radius = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover radiusPlus(@Nullable Number number) {
        this.radiusPlus = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFillColor(@Nullable String str) {
        this.fillColor = str;
    }

    public final void setLineColor(@Nullable String str) {
        this.lineColor = str;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
    }

    public final void setRadius(@Nullable Number number) {
        this.radius = number;
    }

    public final void setRadiusPlus(@Nullable Number number) {
        this.radiusPlus = number;
    }
}
