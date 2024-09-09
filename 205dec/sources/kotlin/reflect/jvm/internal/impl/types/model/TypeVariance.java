package kotlin.reflect.jvm.internal.impl.types.model;

import org.jetbrains.annotations.NotNull;

/* compiled from: TypeSystemContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    @NotNull
    private final String presentation;

    TypeVariance(String str) {
        this.presentation = str;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.presentation;
    }
}
