package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.acse.ottn.adapter.AutoScrollViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAPane.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0019\u0010\t\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "", "()V", "background", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "getBackground", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "setBackground", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;)V", AutoScrollViewPager.f4767g, "", "getCenter", "()[Ljava/lang/Object;", "setCenter", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "endAngle", "", "getEndAngle", "()Ljava/lang/Number;", "setEndAngle", "(Ljava/lang/Number;)V", "size", "getSize", "setSize", "startAngle", "getStartAngle", "setStartAngle", "prop", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAPane {
    @Nullable
    private AABackground background;
    @Nullable
    private Object[] center;
    @Nullable
    private Number endAngle;
    @Nullable
    private Number size;
    @Nullable
    private Number startAngle;

    @NotNull
    public final AAPane background(@Nullable AABackground aABackground) {
        this.background = aABackground;
        return this;
    }

    @NotNull
    public final AAPane center(@NotNull Object[] prop) {
        f0.p(prop, "prop");
        this.center = prop;
        return this;
    }

    @NotNull
    public final AAPane endAngle(@Nullable Number number) {
        this.endAngle = number;
        return this;
    }

    @Nullable
    public final AABackground getBackground() {
        return this.background;
    }

    @Nullable
    public final Object[] getCenter() {
        return this.center;
    }

    @Nullable
    public final Number getEndAngle() {
        return this.endAngle;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @Nullable
    public final Number getStartAngle() {
        return this.startAngle;
    }

    public final void setBackground(@Nullable AABackground aABackground) {
        this.background = aABackground;
    }

    public final void setCenter(@Nullable Object[] objArr) {
        this.center = objArr;
    }

    public final void setEndAngle(@Nullable Number number) {
        this.endAngle = number;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    public final void setStartAngle(@Nullable Number number) {
        this.startAngle = number;
    }

    @NotNull
    public final AAPane size(@Nullable Number number) {
        this.size = number;
        return this;
    }

    @NotNull
    public final AAPane startAngle(@Nullable Number number) {
        this.startAngle = number;
        return this;
    }
}
