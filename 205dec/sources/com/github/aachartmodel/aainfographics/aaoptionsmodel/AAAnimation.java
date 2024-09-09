package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAAnimation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "", "()V", "duration", "", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "easing", "", "getEasing", "()Ljava/lang/String;", "setEasing", "(Ljava/lang/String;)V", "prop", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAAnimation {
    @Nullable
    private Integer duration;
    @Nullable
    private String easing;

    @NotNull
    public final AAAnimation duration(@Nullable Integer num) {
        this.duration = num;
        return this;
    }

    @NotNull
    public final AAAnimation easing(@Nullable AAChartAnimationType aAChartAnimationType) {
        this.easing = aAChartAnimationType != null ? aAChartAnimationType.getValue() : null;
        return this;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getEasing() {
        return this.easing;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setEasing(@Nullable String str) {
        this.easing = str;
    }
}
