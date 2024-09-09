package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: SyntheticJavaPartsProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a implements e {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f57875b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends e> inner) {
        f0.p(inner, "inner");
        this.f57875b = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public List<f> a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor) {
        f0.p(thisDescriptor, "thisDescriptor");
        List<e> list = this.f57875b;
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            c0.o0(arrayList, eVar.a(thisDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.c> result) {
        f0.p(thisDescriptor, "thisDescriptor");
        f0.p(result, "result");
        for (e eVar : this.f57875b) {
            eVar.b(thisDescriptor, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull f name, @NotNull Collection<u0> result) {
        f0.p(thisDescriptor, "thisDescriptor");
        f0.p(name, "name");
        f0.p(result, "result");
        for (e eVar : this.f57875b) {
            eVar.c(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull f name, @NotNull Collection<u0> result) {
        f0.p(thisDescriptor, "thisDescriptor");
        f0.p(name, "name");
        f0.p(result, "result");
        for (e eVar : this.f57875b) {
            eVar.d(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public List<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor) {
        f0.p(thisDescriptor, "thisDescriptor");
        List<e> list = this.f57875b;
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            c0.o0(arrayList, eVar.e(thisDescriptor));
        }
        return arrayList;
    }
}
