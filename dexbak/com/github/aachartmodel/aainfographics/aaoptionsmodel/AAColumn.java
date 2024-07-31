package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAPlotOptions.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010DJ\u0019\u0010\u0019\u001a\u00020\u00002\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\u0010EJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010C\u001a\u00020!J\u0015\u0010&\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010FJ\u0015\u0010-\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010DJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u00103\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010FJ\u0015\u00106\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010FJ\u000e\u00109\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\rJ\u0015\u0010<\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010=¢\u0006\u0002\u0010GR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001c\u00100\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001e\u00103\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001e\u00106\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\u001c\u00109\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001e\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006H"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumn;", "", "()V", "borderRadius", "", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "borderWidth", "getBorderWidth", "setBorderWidth", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "colorByPoint", "", "getColorByPoint", "()Ljava/lang/Boolean;", "setColorByPoint", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "data", "", "getData", "()[Ljava/lang/Object;", "setData", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", "groupPadding", "", "getGroupPadding", "()Ljava/lang/Float;", "setGroupPadding", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "grouping", "getGrouping", "setGrouping", "name", "getName", "setName", "pointPadding", "getPointPadding", "setPointPadding", "pointPlacement", "getPointPlacement", "setPointPlacement", "stacking", "getStacking", "setStacking", "yAxis", "", "getYAxis", "()Ljava/lang/Integer;", "setYAxis", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumn;", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumn;", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumn;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumn;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAColumn {
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
    public final AAColumn borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AAColumn borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AAColumn color(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAColumn colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AAColumn data(@NotNull Object[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AAColumn dataLabels(@NotNull AADataLabels prop) {
        C14342f0.m8184p(prop, "prop");
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
    public final AAColumn groupPadding(@Nullable Float f) {
        this.groupPadding = f;
        return this;
    }

    @NotNull
    public final AAColumn grouping(@Nullable Boolean bool) {
        this.grouping = bool;
        return this;
    }

    @NotNull
    public final AAColumn name(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    public final AAColumn pointPadding(@Nullable Float f) {
        this.pointPadding = f;
        return this;
    }

    @NotNull
    public final AAColumn pointPlacement(@Nullable Float f) {
        this.pointPlacement = f;
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

    public final void setGroupPadding(@Nullable Float f) {
        this.groupPadding = f;
    }

    public final void setGrouping(@Nullable Boolean bool) {
        this.grouping = bool;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPointPadding(@Nullable Float f) {
        this.pointPadding = f;
    }

    public final void setPointPlacement(@Nullable Float f) {
        this.pointPlacement = f;
    }

    public final void setStacking(@Nullable String str) {
        this.stacking = str;
    }

    public final void setYAxis(@Nullable Integer num) {
        this.yAxis = num;
    }

    @NotNull
    public final AAColumn stacking(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AAColumn yAxis(@Nullable Integer num) {
        this.yAxis = num;
        return this;
    }
}
