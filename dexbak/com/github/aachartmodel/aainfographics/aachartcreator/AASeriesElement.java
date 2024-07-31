package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAZonesElement;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AASeriesElement.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0010\u0010\u0006\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000b\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\r\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000e\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0015\u0010\u0010\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0015\u0010\u0011\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0010\u0010\u0012\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010;J\u0019\u0010\u0013\u001a\u00020\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0010<J\u0010\u0010\u0016\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0017J\u0015\u0010\u0018\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0010\u0010\u0019\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0015\u0010\u001a\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010=J\u0010\u0010\u001d\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001e\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u001f\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\tJ\u0010\u0010 \u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0010\u0010#\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0010\u0010$\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0015\u0010%\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0010\u0010&\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010'J\u0015\u0010(\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010:J\u0010\u0010)\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010*\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0010\u0010+\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010,\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001J\u0010\u0010-\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010>J\u0015\u00101\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u000102¢\u0006\u0002\u0010?J\u0015\u00104\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u000102¢\u0006\u0002\u0010?J\u0010\u00105\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0007J\u0019\u00106\u001a\u00020\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u0002070\u0014¢\u0006\u0002\u0010@R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010)\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u0012\u00104\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u0010\u00105\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u00108¨\u0006A"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "()V", "allowPointSelect", "", "Ljava/lang/Boolean;", "borderColor", "", "borderRadius", "", "borderRadiusBottomLeft", "borderRadiusBottomRight", "borderRadiusTopLeft", "borderRadiusTopRight", "borderWidth", "color", "colorByPoint", "connectNulls", "dashStyle", "data", "", "[Ljava/lang/Object;", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "enableMouseTracking", "fillColor", "fillOpacity", "", "Ljava/lang/Float;", "id", "innerSize", "lineWidth", "marker", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "name", "negativeColor", "negativeFillColor", "reversed", "shadow", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "showInLegend", "size", "stack", "states", "step", "threshold", "tooltip", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "type", "yAxis", "", "Ljava/lang/Integer;", "zIndex", "zoneAxis", "zones", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AASeriesElement {
    private Boolean allowPointSelect;
    private String borderColor;
    private Number borderRadius;
    private Object borderRadiusBottomLeft;
    private Object borderRadiusBottomRight;
    private Object borderRadiusTopLeft;
    private Object borderRadiusTopRight;
    private Number borderWidth;
    private Object color;
    private Boolean colorByPoint;
    private Boolean connectNulls;
    private String dashStyle;
    private Object[] data;
    private AADataLabels dataLabels;
    private Boolean enableMouseTracking;
    private Object fillColor;
    private Float fillOpacity;

    /* renamed from: id */
    private String f23524id;
    private Object innerSize;
    private Number lineWidth;
    private AAMarker marker;
    private String name;
    private String negativeColor;
    private Object negativeFillColor;
    private Boolean reversed;
    private AAShadow shadow;
    private Boolean showInLegend;
    private Object size;
    private String stack;
    private Object states;
    private Object step;
    private Number threshold;
    private AATooltip tooltip;
    private String type;
    private Integer yAxis;
    private Integer zIndex;
    private String zoneAxis;
    private AAZonesElement[] zones;

    @NotNull
    public final AASeriesElement allowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AASeriesElement color(@Nullable Object obj) {
        this.color = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement connectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement dashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType != null ? aAChartLineDashStyleType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeriesElement data(@NotNull Object[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AASeriesElement dataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @NotNull
    public final AASeriesElement enableMouseTracking(@Nullable Boolean bool) {
        this.enableMouseTracking = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement fillColor(@Nullable Object obj) {
        this.fillColor = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement fillOpacity(@Nullable Float f) {
        this.fillOpacity = f;
        return this;
    }

    @NotNull
    /* renamed from: id */
    public final AASeriesElement m35517id(@Nullable String str) {
        this.f23524id = str;
        return this;
    }

    @NotNull
    public final AASeriesElement innerSize(@Nullable Object obj) {
        this.innerSize = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AASeriesElement marker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    @NotNull
    public final AASeriesElement name(@Nullable String str) {
        this.name = str;
        return this;
    }

    @NotNull
    public final AASeriesElement negativeColor(@Nullable String str) {
        this.negativeColor = str;
        return this;
    }

    @NotNull
    public final AASeriesElement negativeFillColor(@Nullable Object obj) {
        this.negativeFillColor = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement reversed(@Nullable Boolean bool) {
        this.reversed = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement shadow(@Nullable AAShadow aAShadow) {
        this.shadow = aAShadow;
        return this;
    }

    @NotNull
    public final AASeriesElement showInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement size(@Nullable Object obj) {
        this.size = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement stack(@Nullable String str) {
        this.stack = str;
        return this;
    }

    @NotNull
    public final AASeriesElement states(@Nullable Object obj) {
        this.states = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement step(@Nullable Object obj) {
        this.step = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement threshold(@Nullable Number number) {
        this.threshold = number;
        return this;
    }

    @NotNull
    public final AASeriesElement tooltip(@Nullable AATooltip aATooltip) {
        this.tooltip = aATooltip;
        return this;
    }

    @NotNull
    public final AASeriesElement type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeriesElement yAxis(@Nullable Integer num) {
        this.yAxis = num;
        return this;
    }

    @NotNull
    public final AASeriesElement zIndex(@Nullable Integer num) {
        this.zIndex = num;
        return this;
    }

    @NotNull
    public final AASeriesElement zoneAxis(@Nullable String str) {
        this.zoneAxis = str;
        return this;
    }

    @NotNull
    public final AASeriesElement zones(@NotNull AAZonesElement[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.zones = prop;
        return this;
    }
}
