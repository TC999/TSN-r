package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAStates.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0019J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "", "()V", "attributes", "", "", "getAttributes", "()Ljava/util/Map;", "setAttributes", "(Ljava/util/Map;)V", "opacity", "", "getOpacity", "()Ljava/lang/Float;", "setOpacity", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "size", "", "getSize", "()Ljava/lang/Number;", "setSize", "(Ljava/lang/Number;)V", "prop", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAHalo {
    @Nullable
    private Map<String, ?> attributes;
    @Nullable
    private Float opacity;
    @Nullable
    private Number size;

    @NotNull
    public final AAHalo attributes(@Nullable AASVGAttributes aASVGAttributes) {
        this.attributes = aASVGAttributes != null ? aASVGAttributes.toDic() : null;
        return this;
    }

    @Nullable
    public final Map<String, ?> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final Float getOpacity() {
        return this.opacity;
    }

    @Nullable
    public final Number getSize() {
        return this.size;
    }

    @NotNull
    public final AAHalo opacity(@Nullable Float f) {
        this.opacity = f;
        return this;
    }

    public final void setAttributes(@Nullable Map<String, ?> map) {
        this.attributes = map;
    }

    public final void setOpacity(@Nullable Float f) {
        this.opacity = f;
    }

    public final void setSize(@Nullable Number number) {
        this.size = number;
    }

    @NotNull
    public final AAHalo size(@Nullable Number number) {
        this.size = number;
        return this;
    }
}
