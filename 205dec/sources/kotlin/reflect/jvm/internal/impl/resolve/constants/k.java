package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k extends g<f1> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57836b = new a(null);

    /* compiled from: constantValues.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final k a(@NotNull String message) {
            f0.p(message, "message");
            return new b(message);
        }
    }

    /* compiled from: constantValues.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends k {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final String f57837c;

        public b(@NotNull String message) {
            f0.p(message, "message");
            this.f57837c = message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        @NotNull
        public String toString() {
            return this.f57837c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        @NotNull
        public m0 getType(@NotNull d0 module) {
            f0.p(module, "module");
            m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j(this.f57837c);
            f0.o(j4, "createErrorType(message)");
            return j4;
        }
    }

    public k() {
        super(f1.f55527a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    /* renamed from: b */
    public f1 a() {
        throw new UnsupportedOperationException();
    }
}
