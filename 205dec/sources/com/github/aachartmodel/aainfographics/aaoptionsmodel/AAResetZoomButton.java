package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChart.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "", "()V", "position", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "getPosition", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "setPosition", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)V", "relativeTo", "", "getRelativeTo", "()Ljava/lang/String;", "setRelativeTo", "(Ljava/lang/String;)V", "theme", "", "getTheme", "()Ljava/util/Map;", "setTheme", "(Ljava/util/Map;)V", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAResetZoomButton {
    @Nullable
    private AAPosition position;
    @Nullable
    private String relativeTo;
    @Nullable
    private Map<String, ? extends Object> theme;

    @Nullable
    public final AAPosition getPosition() {
        return this.position;
    }

    @Nullable
    public final String getRelativeTo() {
        return this.relativeTo;
    }

    @Nullable
    public final Map<String, Object> getTheme() {
        return this.theme;
    }

    @NotNull
    public final AAResetZoomButton position(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    @NotNull
    public final AAResetZoomButton relativeTo(@Nullable String str) {
        this.relativeTo = str;
        return this;
    }

    public final void setPosition(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setRelativeTo(@Nullable String str) {
        this.relativeTo = str;
    }

    public final void setTheme(@Nullable Map<String, ? extends Object> map) {
        this.theme = map;
    }

    @NotNull
    public final AAResetZoomButton theme(@Nullable Map<String, ? extends Object> map) {
        this.theme = map;
        return this;
    }
}
