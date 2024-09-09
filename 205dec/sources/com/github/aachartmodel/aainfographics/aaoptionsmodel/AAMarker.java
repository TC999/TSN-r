package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAMarker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "", "()V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fillColor", "", "getFillColor", "()Ljava/lang/String;", "setFillColor", "(Ljava/lang/String;)V", "lineColor", "getLineColor", "()Ljava/lang/Object;", "setLineColor", "(Ljava/lang/Object;)V", "lineWidth", "", "getLineWidth", "()Ljava/lang/Number;", "setLineWidth", "(Ljava/lang/Number;)V", "radius", "getRadius", "setRadius", "states", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerStates;", "getStates", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerStates;", "setStates", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerStates;)V", "symbol", "getSymbol", "setSymbol", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAMarker {
    @Nullable
    private Boolean enabled;
    @Nullable
    private String fillColor;
    @Nullable
    private Object lineColor;
    @Nullable
    private Number lineWidth;
    @Nullable
    private Number radius;
    @Nullable
    private AAMarkerStates states;
    @Nullable
    private String symbol;

    @NotNull
    public final AAMarker enabled(boolean z3) {
        this.enabled = Boolean.valueOf(z3);
        return this;
    }

    @NotNull
    public final AAMarker fillColor(@NotNull String prop) {
        f0.p(prop, "prop");
        this.fillColor = prop;
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
    public final Object getLineColor() {
        return this.lineColor;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getRadius() {
        return this.radius;
    }

    @Nullable
    public final AAMarkerStates getStates() {
        return this.states;
    }

    @Nullable
    public final String getSymbol() {
        return this.symbol;
    }

    @NotNull
    public final AAMarker lineColor(@Nullable Object obj) {
        this.lineColor = obj;
        return this;
    }

    @NotNull
    public final AAMarker lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAMarker radius(@Nullable Number number) {
        this.radius = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFillColor(@Nullable String str) {
        this.fillColor = str;
    }

    public final void setLineColor(@Nullable Object obj) {
        this.lineColor = obj;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setRadius(@Nullable Number number) {
        this.radius = number;
    }

    public final void setStates(@Nullable AAMarkerStates aAMarkerStates) {
        this.states = aAMarkerStates;
    }

    public final void setSymbol(@Nullable String str) {
        this.symbol = str;
    }

    @Nullable
    public final AAMarker states(@NotNull AAMarkerStates prop) {
        f0.p(prop, "prop");
        this.states = prop;
        return this;
    }

    @NotNull
    public final AAMarker symbol(@Nullable String str) {
        this.symbol = str;
        return this;
    }
}
