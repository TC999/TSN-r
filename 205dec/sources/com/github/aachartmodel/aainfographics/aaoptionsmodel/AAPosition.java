package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AACredits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "", "()V", "align", "", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "verticalAlign", "getVerticalAlign", "setVerticalAlign", "x", "", "getX", "()Ljava/lang/Number;", "setX", "(Ljava/lang/Number;)V", "y", "getY", "setY", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAPosition {
    @Nullable
    private String align;
    @Nullable
    private String verticalAlign;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private Number f37125x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Number f37126y;

    @NotNull
    public final AAPosition align(@Nullable String str) {
        this.align = str;
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f37125x;
    }

    @Nullable
    public final Number getY() {
        return this.f37126y;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f37125x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f37126y = number;
    }

    @NotNull
    public final AAPosition verticalAlign(@Nullable String str) {
        this.verticalAlign = str;
        return this;
    }

    @NotNull
    public final AAPosition y(@Nullable Number number) {
        this.f37126y = number;
        return this;
    }

    @NotNull
    public final AAPosition align(@Nullable Number number) {
        this.f37125x = number;
        return this;
    }
}
