package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: SourceElement.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final v0 f56634a = new a();

    /* compiled from: SourceElement.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements v0 {
        a() {
        }

        private static /* synthetic */ void d(int i4) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
        @NotNull
        public w0 b() {
            w0 w0Var = w0.f56635a;
            if (w0Var == null) {
                d(0);
            }
            return w0Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    @NotNull
    w0 b();
}
