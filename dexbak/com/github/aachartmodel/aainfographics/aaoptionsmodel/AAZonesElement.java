package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAZonesElement.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "", "()V", "color", "getColor", "()Ljava/lang/Object;", "setColor", "(Ljava/lang/Object;)V", "dashStyle", "", "getDashStyle", "()Ljava/lang/String;", "setDashStyle", "(Ljava/lang/String;)V", "fillColor", "getFillColor", "setFillColor", DomainCampaignEx.LOOPBACK_VALUE, "", "getValue", "()Ljava/lang/Number;", "setValue", "(Ljava/lang/Number;)V", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAZonesElement {
    @Nullable
    private Object color;
    @Nullable
    private String dashStyle;
    @Nullable
    private Object fillColor;
    @Nullable
    private Number value;

    @NotNull
    public final AAZonesElement color(@Nullable Object obj) {
        this.color = obj;
        return this;
    }

    @NotNull
    public final AAZonesElement dashStyle(@Nullable String str) {
        this.dashStyle = str;
        return this;
    }

    @NotNull
    public final AAZonesElement fillColor(@Nullable Object obj) {
        this.fillColor = obj;
        return this;
    }

    @Nullable
    public final Object getColor() {
        return this.color;
    }

    @Nullable
    public final String getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Object getFillColor() {
        return this.fillColor;
    }

    @Nullable
    public final Number getValue() {
        return this.value;
    }

    public final void setColor(@Nullable Object obj) {
        this.color = obj;
    }

    public final void setDashStyle(@Nullable String str) {
        this.dashStyle = str;
    }

    public final void setFillColor(@Nullable Object obj) {
        this.fillColor = obj;
    }

    public final void setValue(@Nullable Number number) {
        this.value = number;
    }

    @NotNull
    public final AAZonesElement value(@Nullable Number number) {
        this.value = number;
        return this;
    }
}
