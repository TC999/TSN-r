package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AACredits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "", "()V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "href", "", "getHref", "()Ljava/lang/String;", "setHref", "(Ljava/lang/String;)V", "position", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "getPosition", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "setPosition", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)V", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "text", "getText", "setText", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AACredits {
    @Nullable
    private Boolean enabled;
    @Nullable
    private String href;
    @Nullable
    private AAPosition position;
    @Nullable
    private AAStyle style;
    @Nullable
    private String text;

    @NotNull
    public final AACredits enabled(boolean z3) {
        this.enabled = Boolean.valueOf(z3);
        return this;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final String getHref() {
        return this.href;
    }

    @Nullable
    public final AAPosition getPosition() {
        return this.position;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final AACredits href(@Nullable String str) {
        this.href = str;
        return this;
    }

    @NotNull
    public final AACredits position(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setHref(@Nullable String str) {
        this.href = str;
    }

    public final void setPosition(@Nullable AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public final AACredits style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AACredits text(@Nullable String str) {
        this.text = str;
        return this;
    }
}
