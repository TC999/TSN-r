package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.p;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeSourceElementFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l implements l2.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f56560a = new l();

    /* compiled from: RuntimeSourceElementFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements l2.a {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final p f56561b;

        public a(@NotNull p javaElement) {
            f0.p(javaElement, "javaElement");
            this.f56561b = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
        @NotNull
        public w0 b() {
            w0 NO_SOURCE_FILE = w0.f56635a;
            f0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // l2.a
        @NotNull
        /* renamed from: d */
        public p c() {
            return this.f56561b;
        }

        @NotNull
        public String toString() {
            return a.class.getName() + ": " + c();
        }
    }

    private l() {
    }

    @Override // l2.b
    @NotNull
    public l2.a a(@NotNull m2.l javaElement) {
        f0.p(javaElement, "javaElement");
        return new a((p) javaElement);
    }
}
