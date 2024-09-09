package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: ErrorReporter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f58159a = new a();

    /* compiled from: ErrorReporter.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements p {
        a() {
        }

        private static /* synthetic */ void c(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i4 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.p
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                c(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.p
        public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<String> list) {
            if (dVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(@NotNull CallableMemberDescriptor callableMemberDescriptor);

    void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<String> list);
}
