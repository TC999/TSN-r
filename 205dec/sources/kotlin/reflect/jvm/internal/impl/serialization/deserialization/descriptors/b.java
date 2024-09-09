package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedAnnotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.f {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f58037b = {n0.u(new PropertyReference1Impl(n0.d(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f58038a;

    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d2.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> compute) {
        f0.p(storageManager, "storageManager");
        f0.p(compute, "compute");
        this.f58038a = storageManager.g(compute);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> a() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58038a, this, f58037b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.a(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return a().iterator();
    }
}
