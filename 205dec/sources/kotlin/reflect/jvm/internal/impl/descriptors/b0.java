package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: ModalityUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 {
    public static final boolean a(@NotNull d dVar) {
        kotlin.jvm.internal.f0.p(dVar, "<this>");
        return dVar.s() == Modality.FINAL && dVar.i() != ClassKind.ENUM_CLASS;
    }
}
