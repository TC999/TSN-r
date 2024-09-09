package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface n extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.s {

    /* compiled from: KotlinClassFinder.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a {

        /* compiled from: KotlinClassFinder.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1154a extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final byte[] f57250a;

            @NotNull
            public final byte[] b() {
                return this.f57250a;
            }
        }

        /* compiled from: KotlinClassFinder.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final p f57251a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private final byte[] f57252b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull p kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                f0.p(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f57251a = kotlinJvmBinaryClass;
                this.f57252b = bArr;
            }

            @NotNull
            public final p b() {
                return this.f57251a;
            }

            public /* synthetic */ b(p pVar, byte[] bArr, int i4, kotlin.jvm.internal.u uVar) {
                this(pVar, (i4 & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @Nullable
        public final p a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.b();
        }
    }

    @Nullable
    a b(@NotNull m2.g gVar);

    @Nullable
    a c(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);
}
