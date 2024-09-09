package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: Modality.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Modality.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final Modality a(boolean z3, boolean z4, boolean z5) {
            if (z3) {
                return Modality.SEALED;
            }
            if (z4) {
                return Modality.ABSTRACT;
            }
            if (z5) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }
}
