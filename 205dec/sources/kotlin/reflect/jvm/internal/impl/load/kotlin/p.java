package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinJvmBinaryClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface p {

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        void a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2);

        @Nullable
        a b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

        void c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2);

        void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj);

        @Nullable
        b e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        void visitEnd();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface b {
        @Nullable
        a a(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

        void b(@Nullable Object obj);

        void c(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        void d(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar);

        void visitEnd();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface c {
        @Nullable
        a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull v0 v0Var);

        void visitEnd();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface d {
        @Nullable
        c a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull String str, @Nullable Object obj);

        @Nullable
        e b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull String str);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface e extends c {
        @Nullable
        a a(int i4, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull v0 v0Var);
    }

    @NotNull
    kotlin.reflect.jvm.internal.impl.name.b c();

    void d(@NotNull d dVar, @Nullable byte[] bArr);

    @NotNull
    KotlinClassHeader e();

    void f(@NotNull c cVar, @Nullable byte[] bArr);

    @NotNull
    String getLocation();
}
