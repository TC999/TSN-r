package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotatedImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final f f56231a;

    public b(@NotNull f fVar) {
        if (fVar == null) {
            B(0);
        }
        this.f56231a = fVar;
    }

    private static /* synthetic */ void B(int i4) {
        String str = i4 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i4 != 1 ? 3 : 2];
        if (i4 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i4 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i4 != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 == 1) {
            throw new IllegalStateException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public f getAnnotations() {
        f fVar = this.f56231a;
        if (fVar == null) {
            B(1);
        }
        return fVar;
    }
}
