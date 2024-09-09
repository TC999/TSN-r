package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f57236a = new b(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final d f57237b = new d(JvmPrimitiveType.BOOLEAN);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final d f57238c = new d(JvmPrimitiveType.CHAR);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final d f57239d = new d(JvmPrimitiveType.BYTE);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final d f57240e = new d(JvmPrimitiveType.SHORT);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final d f57241f = new d(JvmPrimitiveType.INT);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final d f57242g = new d(JvmPrimitiveType.FLOAT);
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final d f57243h = new d(JvmPrimitiveType.LONG);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final d f57244i = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends k {
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        private final k f57245j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull k elementType) {
            super(null);
            f0.p(elementType, "elementType");
            this.f57245j = elementType;
        }

        @NotNull
        public final k i() {
            return this.f57245j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final d a() {
            return k.f57237b;
        }

        @NotNull
        public final d b() {
            return k.f57239d;
        }

        @NotNull
        public final d c() {
            return k.f57238c;
        }

        @NotNull
        public final d d() {
            return k.f57244i;
        }

        @NotNull
        public final d e() {
            return k.f57242g;
        }

        @NotNull
        public final d f() {
            return k.f57241f;
        }

        @NotNull
        public final d g() {
            return k.f57243h;
        }

        @NotNull
        public final d h() {
            return k.f57240e;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends k {
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        private final String f57246j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String internalName) {
            super(null);
            f0.p(internalName, "internalName");
            this.f57246j = internalName;
        }

        @NotNull
        public final String i() {
            return this.f57246j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends k {
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private final JvmPrimitiveType f57247j;

        public d(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.f57247j = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType i() {
            return this.f57247j;
        }
    }

    private k() {
    }

    public /* synthetic */ k(kotlin.jvm.internal.u uVar) {
        this();
    }

    @NotNull
    public String toString() {
        return m.f57248a.d(this);
    }
}
