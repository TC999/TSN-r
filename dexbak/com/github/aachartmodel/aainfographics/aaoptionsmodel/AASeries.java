package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.umeng.analytics.pro.UContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AASeries.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010 \u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010#\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0010J\u0015\u0010&\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010oJ\u0015\u0010-\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010oJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010n\u001a\u000201J\u000e\u00106\u001a\u00020\u00002\u0006\u0010n\u001a\u000207J\u0019\u0010<\u001a\u00020\u00002\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\n0=¢\u0006\u0002\u0010pJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010n\u001a\u00020DJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010n\u001a\u00020JJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010n\u001a\u00020PJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0001J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0010J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010n\u001a\u00020`J\u0010\u0010e\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010qJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010n\u001a\u00020iR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001c\u0010#\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010=X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010V\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\u0019R\u001c\u0010\\\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0012\"\u0004\b^\u0010\u0014R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\f\"\u0004\bg\u0010\u000eR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006r"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "()V", "animation", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "getAnimation", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "setAnimation", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;)V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "borderRadius", "", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "borderRadiusBottomLeft", "getBorderRadiusBottomLeft", "()Ljava/lang/Object;", "setBorderRadiusBottomLeft", "(Ljava/lang/Object;)V", "borderRadiusBottomRight", "getBorderRadiusBottomRight", "setBorderRadiusBottomRight", "borderRadiusTopLeft", "getBorderRadiusTopLeft", "setBorderRadiusTopLeft", "borderRadiusTopRight", "getBorderRadiusTopRight", "setBorderRadiusTopRight", "borderWidth", "getBorderWidth", "setBorderWidth", "colorByPoint", "", "getColorByPoint", "()Ljava/lang/Boolean;", "setColorByPoint", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "connectNulls", "getConnectNulls", "setConnectNulls", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", UContent.f38134ax, "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "getEvents", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "setEvents", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;)V", "keys", "", "getKeys", "()[Ljava/lang/String;", "setKeys", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "marker", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "getMarker", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "setMarker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)V", "point", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;", "getPoint", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;", "setPoint", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;)V", "pointInterval", "", "getPointInterval", "()Ljava/lang/Integer;", "setPointInterval", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pointIntervalUnit", "getPointIntervalUnit", "setPointIntervalUnit", "pointPlacement", "getPointPlacement", "setPointPlacement", "pointStart", "getPointStart", "setPointStart", "shadow", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "getShadow", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "setShadow", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;)V", "stacking", "getStacking", "setStacking", "states", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "getStates", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "setStates", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;)V", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AASeries {
    @Nullable
    private AAAnimation animation;
    @Nullable
    private String borderColor;
    @Nullable
    private Number borderRadius;
    @Nullable
    private Object borderRadiusBottomLeft;
    @Nullable
    private Object borderRadiusBottomRight;
    @Nullable
    private Object borderRadiusTopLeft;
    @Nullable
    private Object borderRadiusTopRight;
    @Nullable
    private Number borderWidth;
    @Nullable
    private Boolean colorByPoint;
    @Nullable
    private Boolean connectNulls;
    @Nullable
    private AADataLabels dataLabels;
    @Nullable
    private AASeriesEvents events;
    @Nullable
    private String[] keys;
    @Nullable
    private AAMarker marker;
    @Nullable
    private AAPoint point;
    @Nullable
    private Integer pointInterval;
    @Nullable
    private String pointIntervalUnit;
    @Nullable
    private Object pointPlacement;
    @Nullable
    private Number pointStart;
    @Nullable
    private com.github.aachartmodel.aainfographics.aachartcreator.AAShadow shadow;
    @Nullable
    private String stacking;
    @Nullable
    private AAStates states;

    @NotNull
    public final AASeries animation(@NotNull AAAnimation prop) {
        C14342f0.m8184p(prop, "prop");
        this.animation = prop;
        return this;
    }

    @NotNull
    public final AASeries borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASeries borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @NotNull
    public final AASeries borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AASeries colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AASeries connectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @NotNull
    public final AASeries dataLabels(@NotNull AADataLabels prop) {
        C14342f0.m8184p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AASeries events(@NotNull AASeriesEvents prop) {
        C14342f0.m8184p(prop, "prop");
        this.events = prop;
        return this;
    }

    @Nullable
    public final AAAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final Object getBorderRadiusBottomLeft() {
        return this.borderRadiusBottomLeft;
    }

    @Nullable
    public final Object getBorderRadiusBottomRight() {
        return this.borderRadiusBottomRight;
    }

    @Nullable
    public final Object getBorderRadiusTopLeft() {
        return this.borderRadiusTopLeft;
    }

    @Nullable
    public final Object getBorderRadiusTopRight() {
        return this.borderRadiusTopRight;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final Boolean getColorByPoint() {
        return this.colorByPoint;
    }

    @Nullable
    public final Boolean getConnectNulls() {
        return this.connectNulls;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @Nullable
    public final AASeriesEvents getEvents() {
        return this.events;
    }

    @Nullable
    public final String[] getKeys() {
        return this.keys;
    }

    @Nullable
    public final AAMarker getMarker() {
        return this.marker;
    }

    @Nullable
    public final AAPoint getPoint() {
        return this.point;
    }

    @Nullable
    public final Integer getPointInterval() {
        return this.pointInterval;
    }

    @Nullable
    public final String getPointIntervalUnit() {
        return this.pointIntervalUnit;
    }

    @Nullable
    public final Object getPointPlacement() {
        return this.pointPlacement;
    }

    @Nullable
    public final Number getPointStart() {
        return this.pointStart;
    }

    @Nullable
    public final com.github.aachartmodel.aainfographics.aachartcreator.AAShadow getShadow() {
        return this.shadow;
    }

    @Nullable
    public final String getStacking() {
        return this.stacking;
    }

    @Nullable
    public final AAStates getStates() {
        return this.states;
    }

    @NotNull
    public final AASeries keys(@NotNull String[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.keys = prop;
        return this;
    }

    @NotNull
    public final AASeries marker(@NotNull AAMarker prop) {
        C14342f0.m8184p(prop, "prop");
        this.marker = prop;
        return this;
    }

    @NotNull
    public final AASeries point(@NotNull AAPoint prop) {
        C14342f0.m8184p(prop, "prop");
        this.point = prop;
        return this;
    }

    @NotNull
    public final AASeries pointInterval(int i) {
        this.pointInterval = Integer.valueOf(i);
        return this;
    }

    @NotNull
    public final AASeries pointIntervalUnit(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointIntervalUnit = prop;
        return this;
    }

    @NotNull
    public final AASeries pointPlacement(@NotNull Object prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointPlacement = prop;
        return this;
    }

    @NotNull
    public final AASeries pointStart(@NotNull Number prop) {
        C14342f0.m8184p(prop, "prop");
        this.pointStart = prop;
        return this;
    }

    public final void setAnimation(@Nullable AAAnimation aAAnimation) {
        this.animation = aAAnimation;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setBorderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
    }

    public final void setBorderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
    }

    public final void setBorderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
    }

    public final void setBorderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setColorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
    }

    public final void setConnectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setEvents(@Nullable AASeriesEvents aASeriesEvents) {
        this.events = aASeriesEvents;
    }

    public final void setKeys(@Nullable String[] strArr) {
        this.keys = strArr;
    }

    public final void setMarker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
    }

    public final void setPoint(@Nullable AAPoint aAPoint) {
        this.point = aAPoint;
    }

    public final void setPointInterval(@Nullable Integer num) {
        this.pointInterval = num;
    }

    public final void setPointIntervalUnit(@Nullable String str) {
        this.pointIntervalUnit = str;
    }

    public final void setPointPlacement(@Nullable Object obj) {
        this.pointPlacement = obj;
    }

    public final void setPointStart(@Nullable Number number) {
        this.pointStart = number;
    }

    public final void setShadow(@Nullable com.github.aachartmodel.aainfographics.aachartcreator.AAShadow aAShadow) {
        this.shadow = aAShadow;
    }

    public final void setStacking(@Nullable String str) {
        this.stacking = str;
    }

    public final void setStates(@Nullable AAStates aAStates) {
        this.states = aAStates;
    }

    @NotNull
    public final AASeries shadow(@NotNull com.github.aachartmodel.aainfographics.aachartcreator.AAShadow prop) {
        C14342f0.m8184p(prop, "prop");
        this.shadow = prop;
        return this;
    }

    @NotNull
    public final AASeries stacking(@Nullable AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType != null ? aAChartStackingType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeries states(@NotNull AAStates prop) {
        C14342f0.m8184p(prop, "prop");
        this.states = prop;
        return this;
    }
}
