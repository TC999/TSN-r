package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AASeriesElement.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "", "()V", "color", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "marker", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "name", "", "x", "", "y", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AADataElement {
    private Object color;
    private AADataLabels dataLabels;
    private AAMarker marker;
    private String name;

    /* renamed from: x */
    private Number f23520x;

    /* renamed from: y */
    private Number f23521y;

    @NotNull
    public final AADataElement color(@NotNull Object prop) {
        C14342f0.m8184p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AADataElement dataLabels(@NotNull AADataLabels prop) {
        C14342f0.m8184p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AADataElement marker(@NotNull AAMarker prop) {
        C14342f0.m8184p(prop, "prop");
        this.marker = prop;
        return this;
    }

    @NotNull
    public final AADataElement name(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    /* renamed from: x */
    public final AADataElement m35519x(@NotNull Number prop) {
        C14342f0.m8184p(prop, "prop");
        this.f23520x = prop;
        return this;
    }

    @NotNull
    /* renamed from: y */
    public final AADataElement m35518y(@Nullable Number number) {
        this.f23521y = number;
        return this;
    }
}
