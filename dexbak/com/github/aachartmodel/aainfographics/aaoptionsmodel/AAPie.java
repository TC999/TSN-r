package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAPlotOptions.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00108J\u0010\u0010\n\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0010J\u0019\u0010\u0015\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\u00109J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010#J\u0010\u0010(\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010#J\u0015\u0010+\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00108J\u0010\u0010.\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010#J\u0010\u00101\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010#J\u0010\u00104\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010:R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u001c\u00101\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u001c\u00104\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014¨\u0006;"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPie;", "", "()V", "allowPointSelect", "", "getAllowPointSelect", "()Ljava/lang/Boolean;", "setAllowPointSelect", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "center", "getCenter", "()Ljava/lang/Object;", "setCenter", "(Ljava/lang/Object;)V", "cursor", "", "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "data", "", "getData", "()[Ljava/lang/Object;", "setData", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", "depth", "", "getDepth", "()Ljava/lang/Number;", "setDepth", "(Ljava/lang/Number;)V", "endAngle", "getEndAngle", "setEndAngle", "showInLegend", "getShowInLegend", "setShowInLegend", "size", "getSize", "setSize", "startAngle", "getStartAngle", "setStartAngle", "type", "getType", "setType", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPie;", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPie;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAPie {
    @Nullable
    private Boolean allowPointSelect;
    @Nullable
    private Object center;
    @Nullable
    private String cursor;
    @Nullable
    private Object[] data;
    @Nullable
    private AADataLabels dataLabels;
    @Nullable
    private Number depth;
    @Nullable
    private Number endAngle;
    @Nullable
    private Boolean showInLegend;
    @Nullable
    private Number size;
    @Nullable
    private Number startAngle;
    @Nullable
    private String type;

    @NotNull
    public final AAPie allowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
        return this;
    }

    @NotNull
    public final AAPie center(@Nullable Object obj) {
        this.center = obj;
        return this;
    }

    @NotNull
    public final AAPie cursor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.cursor = prop;
        return this;
    }

    @NotNull
    public final AAPie data(@NotNull Object[] prop) {
        C14342f0.m8184p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AAPie dataLabels(@NotNull AADataLabels prop) {
        C14342f0.m8184p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AAPie depth(@Nullable Number number) {
        this.depth = number;
        return this;
    }

    @NotNull
    public final AAPie endAngle(@Nullable Number number) {
        this.endAngle = number;
        return this;
    }

    @Nullable
    public final Boolean getAllowPointSelect() {
        return this.allowPointSelect;
    }

    @Nullable
    public final Object getCenter() {
        return this.center;
    }

    @Nullable
    public final String getCursor() {
        return this.cursor;
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
    public final Number getDepth() {
        return this.depth;
    }

    @Nullable
    public final Number getEndAngle() {
        return this.endAngle;
    }

    @Nullable
    public final Boolean getShowInLegend() {
        return this.showInLegend;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @Nullable
    public final Number getStartAngle() {
        return this.startAngle;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final void setAllowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
    }

    public final void setCenter(@Nullable Object obj) {
        this.center = obj;
    }

    public final void setCursor(@Nullable String str) {
        this.cursor = str;
    }

    public final void setData(@Nullable Object[] objArr) {
        this.data = objArr;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setDepth(@Nullable Number number) {
        this.depth = number;
    }

    public final void setEndAngle(@Nullable Number number) {
        this.endAngle = number;
    }

    public final void setShowInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    public final void setStartAngle(@Nullable Number number) {
        this.startAngle = number;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public final AAPie showInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
        return this;
    }

    @NotNull
    public final AAPie size(@Nullable Number number) {
        this.size = number;
        return this;
    }

    @NotNull
    public final AAPie startAngle(@Nullable Number number) {
        this.startAngle = number;
        return this;
    }

    @NotNull
    public final AAPie type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }
}
