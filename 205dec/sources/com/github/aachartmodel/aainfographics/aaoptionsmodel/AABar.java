package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAPlotOptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010DJ\u0019\u0010\u0019\u001a\u00020\u00002\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a\u00a2\u0006\u0002\u0010EJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010C\u001a\u00020!J\u0015\u0010&\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'\u00a2\u0006\u0002\u0010FJ\u0015\u0010-\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010DJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u00103\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'\u00a2\u0006\u0002\u0010FJ\u0015\u00106\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'\u00a2\u0006\u0002\u0010FJ\u000e\u00109\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u0010<\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010=\u00a2\u0006\u0002\u0010GR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001c\u00100\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001e\u00103\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001e\u00106\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\u001c\u00109\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001e\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006H"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABar;", "", "()V", "borderRadius", "", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "borderWidth", "getBorderWidth", "setBorderWidth", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "colorByPoint", "", "getColorByPoint", "()Ljava/lang/Boolean;", "setColorByPoint", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "data", "", "getData", "()[Ljava/lang/Object;", "setData", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", "groupPadding", "", "getGroupPadding", "()Ljava/lang/Float;", "setGroupPadding", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "grouping", "getGrouping", "setGrouping", "name", "getName", "setName", "pointPadding", "getPointPadding", "setPointPadding", "pointPlacement", "getPointPlacement", "setPointPlacement", "stacking", "getStacking", "setStacking", "yAxis", "", "getYAxis", "()Ljava/lang/Integer;", "setYAxis", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABar;", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABar;", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABar;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABar;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AABar {
    @Nullable
    private Number borderRadius;
    @Nullable
    private Number borderWidth;
    @Nullable
    private String color;
    @Nullable
    private Boolean colorByPoint;
    @Nullable
    private Object[] data;
    @Nullable
    private AADataLabels dataLabels;
    @Nullable
    private Float groupPadding;
    @Nullable
    private Boolean grouping;
    @Nullable
    private String name;
    @Nullable
    private Float pointPadding;
    @Nullable
    private Float pointPlacement;
    @Nullable
    private String stacking;
    @Nullable
    private Integer yAxis;

    @NotNull
    public final AABar borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AABar borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AABar color(@NotNull String prop) {
        f0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AABar colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AABar data(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AABar dataLabels(@NotNull AADataLabels prop) {
        f0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
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
    public final Boolean getColorByPoint() {
        return this.colorByPoint;
    }

    @Nullable
    public final Object[] getData() {
        return this.data;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @Nullable
    public final Float getGroupPadding() {
        return this.groupPadding;
    }

    @Nullable
    public final Boolean getGrouping() {
        return this.grouping;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Float getPointPadding() {
        return this.pointPadding;
    }

    @Nullable
    public final Float getPointPlacement() {
        return this.pointPlacement;
    }

    @Nullable
    public final String getStacking() {
        return this.stacking;
    }

    @Nullable
    public final Integer getYAxis() {
        return this.yAxis;
    }

    @NotNull
    public final AABar groupPadding(@Nullable Float f4) {
        this.groupPadding = f4;
        return this;
    }

    @NotNull
    public final AABar grouping(@Nullable Boolean bool) {
        this.grouping = bool;
        return this;
    }

    @NotNull
    public final AABar name(@NotNull String prop) {
        f0.p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    public final AABar pointPadding(@Nullable Float f4) {
        this.pointPadding = f4;
        return this;
    }

    @NotNull
    public final AABar pointPlacement(@Nullable Float f4) {
        this.pointPlacement = f4;
        return this;
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

    public final void setColorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
    }

    public final void setData(@Nullable Object[] objArr) {
        this.data = objArr;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setGroupPadding(@Nullable Float f4) {
        this.groupPadding = f4;
    }

    public final void setGrouping(@Nullable Boolean bool) {
        this.grouping = bool;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPointPadding(@Nullable Float f4) {
        this.pointPadding = f4;
    }

    public final void setPointPlacement(@Nullable Float f4) {
        this.pointPlacement = f4;
    }

    public final void setStacking(@Nullable String str) {
        this.stacking = str;
    }

    public final void setYAxis(@Nullable Integer num) {
        this.yAxis = num;
    }

    @NotNull
    public final AABar stacking(@NotNull String prop) {
        f0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AABar yAxis(@Nullable Integer num) {
        this.yAxis = num;
        return this;
    }
}
