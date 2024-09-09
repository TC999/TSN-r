package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AASeriesElement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "", "()V", "color", "dataLabels", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "marker", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "name", "", "x", "", "y", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AADataElement {
    private Object color;
    private AADataLabels dataLabels;
    private AAMarker marker;
    private String name;

    /* renamed from: x  reason: collision with root package name */
    private Number f37113x;

    /* renamed from: y  reason: collision with root package name */
    private Number f37114y;

    @NotNull
    public final AADataElement color(@NotNull Object prop) {
        f0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AADataElement dataLabels(@NotNull AADataLabels prop) {
        f0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AADataElement marker(@NotNull AAMarker prop) {
        f0.p(prop, "prop");
        this.marker = prop;
        return this;
    }

    @NotNull
    public final AADataElement name(@NotNull String prop) {
        f0.p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    public final AADataElement x(@NotNull Number prop) {
        f0.p(prop, "prop");
        this.f37113x = prop;
        return this;
    }

    @NotNull
    public final AADataElement y(@Nullable Number number) {
        this.f37114y = number;
        return this;
    }
}
