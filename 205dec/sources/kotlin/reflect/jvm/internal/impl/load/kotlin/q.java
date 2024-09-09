package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q implements v0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h f57253b;

    public q(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h packageFragment) {
        f0.p(packageFragment, "packageFragment");
        this.f57253b = packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    @NotNull
    public w0 b() {
        w0 NO_SOURCE_FILE = w0.f56635a;
        f0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public String toString() {
        return this.f57253b + ": " + this.f57253b.H0().keySet();
    }
}
