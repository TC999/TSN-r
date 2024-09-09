package p2;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: SamConversionResolverImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<Object> f61793a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.b<d, m0> f61794b;

    public b(@NotNull n storageManager, @NotNull Iterable<? extends Object> samWithReceiverResolvers) {
        f0.p(storageManager, "storageManager");
        f0.p(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f61793a = samWithReceiverResolvers;
        this.f61794b = storageManager.d();
    }
}
