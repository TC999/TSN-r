package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinJvmBinarySourceElement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final p f57254b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> f57255c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57256d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final DeserializedContainerAbiStability f57257e;

    public r(@NotNull p binaryClass, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> rVar, boolean z3, @NotNull DeserializedContainerAbiStability abiStability) {
        f0.p(binaryClass, "binaryClass");
        f0.p(abiStability, "abiStability");
        this.f57254b = binaryClass;
        this.f57255c = rVar;
        this.f57256d = z3;
        this.f57257e = abiStability;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f
    @NotNull
    public String a() {
        return "Class '" + this.f57254b.c().b().b() + '\'';
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    @NotNull
    public w0 b() {
        w0 NO_SOURCE_FILE = w0.f56635a;
        f0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final p d() {
        return this.f57254b;
    }

    @NotNull
    public String toString() {
        return ((Object) r.class.getSimpleName()) + ": " + this.f57254b;
    }
}
