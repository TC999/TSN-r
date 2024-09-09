package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a implements k0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f57953a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final s f57954b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d0 f57955c;

    /* renamed from: d  reason: collision with root package name */
    protected i f57956d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, g0> f57957e;

    /* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1172a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, g0> {
        C1172a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final g0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            f0.p(fqName, "fqName");
            n d4 = a.this.d(fqName);
            if (d4 == null) {
                return null;
            }
            d4.G0(a.this.e());
            return d4;
        }
    }

    public a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull s finder, @NotNull d0 moduleDescriptor) {
        f0.p(storageManager, "storageManager");
        f0.p(finder, "finder");
        f0.p(moduleDescriptor, "moduleDescriptor");
        this.f57953a = storageManager;
        this.f57954b = finder;
        this.f57955c = moduleDescriptor;
        this.f57957e = storageManager.e(new C1172a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public List<g0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        List<g0> N;
        f0.p(fqName, "fqName");
        N = CollectionsKt__CollectionsKt.N(this.f57957e.invoke(fqName));
        return N;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<g0> packageFragments) {
        f0.p(fqName, "fqName");
        f0.p(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(packageFragments, this.f57957e.invoke(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.reflect.jvm.internal.impl.descriptors.l d4;
        f0.p(fqName, "fqName");
        if (this.f57957e.u(fqName)) {
            d4 = (g0) this.f57957e.invoke(fqName);
        } else {
            d4 = d(fqName);
        }
        return d4 == null;
    }

    @Nullable
    protected abstract n d(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @NotNull
    protected final i e() {
        i iVar = this.f57956d;
        if (iVar != null) {
            return iVar;
        }
        f0.S("components");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final s f() {
        return this.f57954b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final d0 g() {
        return this.f57955c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n h() {
        return this.f57953a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(@NotNull i iVar) {
        f0.p(iVar, "<set-?>");
        this.f57956d = iVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        Set k4;
        f0.p(fqName, "fqName");
        f0.p(nameFilter, "nameFilter");
        k4 = j1.k();
        return k4;
    }
}
