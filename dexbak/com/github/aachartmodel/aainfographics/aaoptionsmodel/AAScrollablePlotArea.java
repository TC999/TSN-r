package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAScrollablePlotArea.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "", "()V", "minHeight", "", "getMinHeight", "()Ljava/lang/Number;", "setMinHeight", "(Ljava/lang/Number;)V", "minWidth", "getMinWidth", "setMinWidth", "opacity", "", "getOpacity", "()Ljava/lang/Float;", "setOpacity", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scrollPositionX", "getScrollPositionX", "setScrollPositionX", "scrollPositionY", "getScrollPositionY", "setScrollPositionY", "prop", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAScrollablePlotArea {
    @Nullable
    private Number minHeight;
    @Nullable
    private Number minWidth;
    @Nullable
    private Float opacity;
    @Nullable
    private Number scrollPositionX;
    @Nullable
    private Number scrollPositionY;

    @Nullable
    public final Number getMinHeight() {
        return this.minHeight;
    }

    @Nullable
    public final Number getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    public final Float getOpacity() {
        return this.opacity;
    }

    @Nullable
    public final Number getScrollPositionX() {
        return this.scrollPositionX;
    }

    @Nullable
    public final Number getScrollPositionY() {
        return this.scrollPositionY;
    }

    @NotNull
    public final AAScrollablePlotArea minHeight(@Nullable Number number) {
        this.minHeight = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea minWidth(@Nullable Number number) {
        this.minWidth = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea opacity(@Nullable Float f) {
        this.opacity = f;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea scrollPositionX(@Nullable Number number) {
        this.scrollPositionX = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea scrollPositionY(@Nullable Number number) {
        this.scrollPositionY = number;
        return this;
    }

    public final void setMinHeight(@Nullable Number number) {
        this.minHeight = number;
    }

    public final void setMinWidth(@Nullable Number number) {
        this.minWidth = number;
    }

    public final void setOpacity(@Nullable Float f) {
        this.opacity = f;
    }

    public final void setScrollPositionX(@Nullable Number number) {
        this.scrollPositionX = number;
    }

    public final void setScrollPositionY(@Nullable Number number) {
        this.scrollPositionY = number;
    }
}
