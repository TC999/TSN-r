package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAPlotOptions.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010\t\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScatter;", "", "()V", "dashStyle", "", "getDashStyle", "()Ljava/lang/String;", "setDashStyle", "(Ljava/lang/String;)V", "enableMouseTracking", "getEnableMouseTracking", "()Ljava/lang/Object;", "setEnableMouseTracking", "(Ljava/lang/Object;)V", "lineColor", "getLineColor", "setLineColor", "lineWidth", "", "getLineWidth", "()Ljava/lang/Number;", "setLineWidth", "(Ljava/lang/Number;)V", "linkedTo", "getLinkedTo", "setLinkedTo", "marker", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "getMarker", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "setMarker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)V", "states", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "getStates", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "setStates", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;)V", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAScatter {
    @Nullable
    private String dashStyle;
    @Nullable
    private Object enableMouseTracking;
    @Nullable
    private String lineColor;
    @Nullable
    private Number lineWidth;
    @Nullable
    private String linkedTo;
    @Nullable
    private AAMarker marker;
    @Nullable
    private AAStates states;

    @NotNull
    public final AAScatter dashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType != null ? aAChartLineDashStyleType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAScatter enableMouseTracking(@Nullable Object obj) {
        this.enableMouseTracking = obj;
        return this;
    }

    @Nullable
    public final String getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Object getEnableMouseTracking() {
        return this.enableMouseTracking;
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
    public final String getLinkedTo() {
        return this.linkedTo;
    }

    @Nullable
    public final AAMarker getMarker() {
        return this.marker;
    }

    @Nullable
    public final AAStates getStates() {
        return this.states;
    }

    @NotNull
    public final AAScatter lineColor(@Nullable String str) {
        this.lineColor = str;
        return this;
    }

    @NotNull
    public final AAScatter lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAScatter linkedTo(@Nullable String str) {
        this.linkedTo = str;
        return this;
    }

    @NotNull
    public final AAScatter marker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    public final void setDashStyle(@Nullable String str) {
        this.dashStyle = str;
    }

    public final void setEnableMouseTracking(@Nullable Object obj) {
        this.enableMouseTracking = obj;
    }

    public final void setLineColor(@Nullable String str) {
        this.lineColor = str;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLinkedTo(@Nullable String str) {
        this.linkedTo = str;
    }

    public final void setMarker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
    }

    public final void setStates(@Nullable AAStates aAStates) {
        this.states = aAStates;
    }

    @NotNull
    public final AAScatter states(@Nullable AAStates aAStates) {
        this.states = aAStates;
        return this;
    }
}
