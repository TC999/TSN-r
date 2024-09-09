package com.github.aachartmodel.aainfographics.aachartcreator;

import com.google.gson.internal.LinkedTreeMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChartView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "", "()V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "index", "", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "offset", "Lcom/google/gson/internal/LinkedTreeMap;", "getOffset", "()Lcom/google/gson/internal/LinkedTreeMap;", "setOffset", "(Lcom/google/gson/internal/LinkedTreeMap;)V", "x", "", "getX", "()Ljava/lang/Double;", "setX", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "y", "getY", "setY", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAMoveOverEventMessageModel {
    @Nullable
    private String category;
    @Nullable
    private Integer index;
    @Nullable
    private String name;
    @Nullable
    private LinkedTreeMap<String, Object> offset;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private Double f37115x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Double f37116y;

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final LinkedTreeMap<String, Object> getOffset() {
        return this.offset;
    }

    @Nullable
    public final Double getX() {
        return this.f37115x;
    }

    @Nullable
    public final Double getY() {
        return this.f37116y;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setIndex(@Nullable Integer num) {
        this.index = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setOffset(@Nullable LinkedTreeMap<String, Object> linkedTreeMap) {
        this.offset = linkedTreeMap;
    }

    public final void setX(@Nullable Double d4) {
        this.f37115x = d4;
    }

    public final void setY(@Nullable Double d4) {
        this.f37116y = d4;
    }
}
