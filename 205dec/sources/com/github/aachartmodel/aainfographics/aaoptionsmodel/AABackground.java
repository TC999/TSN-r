package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAPane.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "", "()V", "backgroundColor", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "borderWidth", "", "getBorderWidth", "()Ljava/lang/Number;", "setBorderWidth", "(Ljava/lang/Number;)V", "className", "getClassName", "setClassName", "innerRadius", "getInnerRadius", "setInnerRadius", "outerRadius", "getOuterRadius", "setOuterRadius", "shape", "getShape", "setShape", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AABackground {
    @Nullable
    private Object backgroundColor;
    @Nullable
    private String borderColor;
    @Nullable
    private Number borderWidth;
    @Nullable
    private String className;
    @Nullable
    private Number innerRadius;
    @Nullable
    private Number outerRadius;
    @Nullable
    private String shape;

    @NotNull
    public final AABackground backgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @NotNull
    public final AABackground borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AABackground borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AABackground className(@Nullable String str) {
        this.className = str;
        return this;
    }

    @Nullable
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final String getClassName() {
        return this.className;
    }

    @Nullable
    public final Number getInnerRadius() {
        return this.innerRadius;
    }

    @Nullable
    public final Number getOuterRadius() {
        return this.outerRadius;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @NotNull
    public final AABackground innerRadius(@Nullable Number number) {
        this.innerRadius = number;
        return this;
    }

    @NotNull
    public final AABackground outerRadius(@Nullable Number number) {
        this.outerRadius = number;
        return this;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setClassName(@Nullable String str) {
        this.className = str;
    }

    public final void setInnerRadius(@Nullable Number number) {
        this.innerRadius = number;
    }

    public final void setOuterRadius(@Nullable Number number) {
        this.outerRadius = number;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    @NotNull
    public final AABackground shape(@Nullable String str) {
        this.shape = str;
        return this;
    }
}
