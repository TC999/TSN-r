package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: ClassKind.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum ClassKind {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
